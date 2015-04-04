import javafx.animation.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.transform.*;
import javafx.stage.*;
import java.lang.Math.*;

def showLines = false;                          // If set to true, green guide lines will be shown to help visualize the page fold and page corner calculations
def pageMaxW = 220;
def pageMaxH = 300;
def bookMaxW = pageMaxW*2;
def bookMaxH = pageMaxH;

class Page extends CustomNode
{
    public var fill = Color.RED;
    public var stroke = Color.WHITE;
    public var text = "A";

    override function create():Node
    {
        return Group
        {
            var r:Node;
            var t:Node;
            content:
            [
                r = Rectangle
                {
                    width: pageMaxW
                    height: pageMaxH
                    fill: bind stroke
                }
                Rectangle
                {
                    x: 10
                    y: 10
                    width: pageMaxW - 20
                    height: pageMaxH - 20
                    fill: bind fill
                }
                t = Text
                {
                    textOrigin: TextOrigin.TOP
                    translateX: bind ((r.layoutBounds.width - t.layoutBounds.width)/2) + t.layoutBounds.minX
                    translateY: bind ((r.layoutBounds.height - t.layoutBounds.height)/2) + t.layoutBounds.minY
                    content: bind text
                    fill: Color.WHITE
                    font:Font.font("Default", 70)
                }
            ]
        };
    }
}

class PageHolder extends CustomNode
{
    public var content:Node on replace { g.content = content };
    public var isLeft:Boolean;
    public var gx1 = 0.0;
    public var gy1 = 0.0;
    public var gx2 = 1.0;
    public var gy2 = 0.0;
    var g:Group;
    var gradient:Paint;

    function createLeftGradient():Paint
    {
        LinearGradient
        {
            proportional: false
            startX: gx1
            startY: gy1
            endX: gx2
            endY: gy2
            stops: [
                Stop
                {
                    offset: 0.0
                    color: Color.color(0, 0, 0, 0.3)
                }
                Stop
                {
                    offset: 0.2
                    color: Color.color(0.6, 0.6, 0.6, 0.1)
                }
                Stop
                {
                    offset: 0.3
                    color: Color.color(0.6, 0.6, 0.6, 0.08)
                }
                Stop
                {
                    offset: 0.4
                    color: Color.color(0.6, 0.6, 0.6, 0.0)
                }
            ]
        }
    }

    function createRightGradient():Paint
    {
        LinearGradient
        {
            proportional: false
            startX: gx1
            startY: gy1
            endX: gx2
            endY: gy2
            stops: [
                Stop
                {
                    offset: 0.0
                    color: Color.color(0, 0, 0, 0.4)
                }
                Stop
                {
                    offset: 0.2
                    color: Color.color(0, 0, 0, 0.1)
                }
                Stop
                {
                    offset: 0.35
                    color: Color.TRANSPARENT
                }
            ]
        }
    }

    function initGradient()
    {
        if (isLeft)
        {
            gx1 = pageMaxW;
            gx2 = 0;
        } else
        {
            gx1 = 0;
            gx2 = pageMaxW;
        }
        gy1 = 0;
        gy2 = 0;
        updateGradient();
    }

    function updateGradient()
    {
        gradient = if (isLeft) createLeftGradient() else createRightGradient();
    }

    override function create():Node
    {
        return Group
        {
            content:
            [
                g = Group {}
                Rectangle
                {
                    width: pageMaxW
                    height: pageMaxH
                    fill: bind gradient
                }
            ]
        }
    }
}

class Grip extends CustomNode
{
    public-init var entered:function():Void;
    public-init var update:function(Number, Number):Void;
    public-init var animate:function(Number, Number):Void;
    var inDrag = false;

    override function create():Node
    {
        Rectangle
        {
            fill: Color.TRANSPARENT
            width: 50
            height: 50
            onMouseEntered:function(e)
            {
                entered();
            }
            onMouseMoved:function(e)
            {
                if (not inDrag)
                {
                    var curX = boundsInParent.minX + e.x;
                    var curY = boundsInParent.minY + e.y;
                    update(curX, curY);
                }
            }
            onMouseExited:function(e)
            {
                if (not inDrag)
                {
                    var curX = boundsInParent.minX + e.x;
                    var curY = boundsInParent.minY + e.y;
                    animate(curX, curY);
                }
            }
            onMousePressed:function(e)
            {
                inDrag = true;
                var curX = boundsInParent.minX + e.x;
                var curY = boundsInParent.minY + e.y;
                update(curX, curY);
            }
            onMouseDragged:function(e)
            {
                var curX = boundsInParent.minX + e.x;
                var curY = boundsInParent.minY + e.y;
                update(curX, curY);
            }
            onMouseReleased:function(e)
            {
                inDrag = false;
                var curX = boundsInParent.minX + e.x;
                var curY = boundsInParent.minY + e.y;
                animate(curX, curY);
            }
        }
    }
}

class Book extends CustomNode
{
    public var pages:Node[];

    var startIndex = 2;
    var pageHolders = for (i in [0..<6]) PageHolder { isLeft: i mod 2 == 0 };
    var gripBR:Node;
    var gripBL:Node;
    var inFlipRight = false;
    var inFlipLeft  = false;
    var lineGroup:Group;
    var lines = for (i in [0..<7]) Line { stroke: Color.LIME strokeWidth: 4 };
    var currentCornerX = 0.0;
    var currentCornerY = 0.0 on replace
    {
        if (inFlipLeft)
        {
            updateBL(currentCornerX, currentCornerY);
        } else if (inFlipRight)
        {
            updateBR(currentCornerX, currentCornerY);
        }
    };

    function updateCorner(bookBotCornerX:Number, bookBotCornerY:Number,
                          bookTopCornerX:Number, bookTopCornerY:Number,
                          mouseX:Number, mouseY:Number,
                          backHolder:PageHolder, frontHolder:PageHolder)
    {
        def pageW = pageMaxW;
        def pageH = pageMaxH;

        // Find the x and y deltas between the current mouse location and  the bottom corner of the book.
        var dx = mouseX - bookBotCornerX;
        var dy = mouseY - bookBotCornerY;
        def theta1 = atan(dy/dx);               // Find the angle (theta1) of the vector connecting the current mouse location and the bottom corner of the book

        /*
         *  Find the x distance (x0) of the mid-point of the delta vector.
         *  This is the distance between the bottom corner of the book
         *  and the bottom fold of the page; this is clamped if necessary
         *  since it can't be larger than the page width
         */
        var x0;
        if (theta1 == 0) {
            x0 = dx/2;
        } else {
            def y0 = dy/2;                      // Find the y distance (y0) of the mid-point of the delta vector.
            def h0 = y0/sin(theta1);            // Find the length of the vector connecting the mid-point and the bottom corner of the book (h0, the hypotenuse).
            x0 = h0/cos(theta1);
        }
        if (abs(x0) > pageW) {
            x0 = signum(x0)*pageW;
        }
        def theta2 = (PI / 2) - theta1;         // Find the angle (theta2) of the vector connecting the bottom fold and the top fold.
        def bx0 = if (theta1 == 0) 0 else pageH/tan(theta2);    // Find the x distance (bx0) between the bottom fold and the top fold.
        /*
         *   Find the x distance (mx0) between the top corner of the book
         *   and the top fold of the page; this is clamped if necessary
         *   since it can't be larger than the page width
         */
        var mx0 = x0 + bx0;
        if (inFlipLeft) {
            if (mx0 > pageW) {
                mx0 = pageW;
            }
        } else {
            if (mx0 < -pageW) {
                mx0 = -pageW;
            }
        }

        // Find the coordinates of the top/bottom page folds (relative to the book's origin).
        def pageBotFoldX = bookBotCornerX + x0;
        def pageBotFoldY = bookBotCornerY;
        def pageTopFoldX = bookTopCornerX + mx0;
        def pageTopFoldY = bookTopCornerY;

        // Find the x and y deltas between the top and bottom folds.
        dx = pageBotFoldX - pageTopFoldX;
        dy = pageBotFoldY - pageTopFoldY;
        def theta3 = atan(dy/dx);               // Find the angle (theta3) of the adjusted vector between the top and bottom folds.
        def theta4 = PI - (2*theta3);           // Find the angle (theta4) of the left page edge.
        // Find the x and y deltas between the top fold and the top-left corner of the page.
        def ex = -mx0*cos(theta4);
        def ey = -mx0*sin(theta4);
        /* Find the x and y deltas between the top-left corner of the page
            and the bottom-left corner of the page.  (The bottom-left corner
            of the page is always a fixed distance, pageH, away from the
            top-left corner.)*/
        def ix = pageH*sin(theta4);
        def iy = pageH*cos(theta4);
        // Find the coordinates of the top-left and bottom-left corners of the page (relative to the book's origin).
        def pageTLCornerX = pageTopFoldX - ex;
        def pageTLCornerY = pageTopFoldY + ey;
        def pageBLCornerX = pageTLCornerX + ix;
        def pageBLCornerY = pageTLCornerY + iy;

        if (showLines) {
            lines[0].startX = bookBotCornerX;
            lines[0].startY = bookBotCornerY;
            lines[0].endX   = pageBLCornerX;
            lines[0].endY   = pageBLCornerY;

            lines[1].startX = bookBotCornerX;
            lines[1].startY = bookBotCornerY;
            lines[1].endX   = pageBotFoldX;
            lines[1].endY   = pageBotFoldY;

            lines[2].startX = pageBLCornerX;
            lines[2].startY = pageBLCornerY;
            lines[2].endX   = pageBotFoldX;
            lines[2].endY   = pageBotFoldY;

            lines[3].startX = pageBLCornerX;
            lines[3].startY = pageBLCornerY;
            lines[3].endX   = pageTLCornerX;
            lines[3].endY   = pageTLCornerY;

            lines[4].startX = pageBotFoldX;
            lines[4].startY = pageBotFoldY;
            lines[4].endX   = pageTopFoldX;
            lines[4].endY   = pageTopFoldY;

            lines[5].startX = bookTopCornerX;
            lines[5].startY = bookTopCornerY;
            lines[5].endX   = pageTopFoldX;
            lines[5].endY   = pageTopFoldY;

            lines[6].startX = pageTopFoldX;
            lines[6].startY = pageTopFoldY;
            lines[6].endX   = pageTLCornerX;
            lines[6].endY   = pageTLCornerY;
        }

        var adjX = if (inFlipLeft) pageW else 0;        // Find the transform and clip for the page being turned.
        var nudge = if (inFlipLeft) 2 else -2;
        backHolder.transforms = [
            Translate {
                x: pageBLCornerX - adjX
                y: pageBLCornerY - pageH
            }
            Rotate {
                angle: toDegrees(-theta4)
                pivotX: adjX
                pivotY: pageH
            }
        ];
        backHolder.clip = Polygon {
            points: [
                adjX+nudge, pageH,
                adjX-x0, pageH,
                adjX-mx0, 0,
                adjX+nudge, 0,
            ]
        };

        // Find the gradient points (massive handwaving here, these calculations were derived from tiny sketches on napkins)...
        def y1 = (pageH - pageBLCornerY)/2;
        if (y1 >= 0) {
            def x1 = if (y1 == 0) -x0 else y1*tan(theta2);
            def intPointX = adjX + x1;
            def intPointY = pageH - y1;
            backHolder.gx1 = intPointX;
            backHolder.gy1 = intPointY;
            backHolder.gx2 = adjX;
            backHolder.gy2 = pageH;
            if (backHolder.gx1 < 0.1) {
                backHolder.gx1 = 0.1;
            }
            if (backHolder.gy1 > pageH - 0.1) {
                backHolder.gy1 = pageH - 0.1;
            }
        } else {
            dx = pageTLCornerX - bookTopCornerX;
            dy = pageTLCornerY - bookTopCornerY;
            def y2 = pageTLCornerY/2;
            def theta5 = atan(-dy/dx);
            def theta6 = (PI/2) - theta5;
            def mx1 = y2/tan(theta6);
            backHolder.gx1 = adjX - mx0 - mx1;
            backHolder.gy1 = y2/sin(theta6);
            backHolder.gx2 = adjX;
            backHolder.gy2 = 0;
        }
        backHolder.updateGradient();
        if (inFlipLeft) {
            frontHolder.clip = Polygon {
                points: [
                    pageW, 0,
                    pageW, pageH,
                    x0, pageH,
                    mx0, 0,
                ]
            };
        } else {
            frontHolder.clip = Polygon {
                points: [
                    0, 0,
                    pageW+mx0, 0,
                    pageW+x0, pageH,
                    0, pageH,
                ]
            };
        }
    }

    // The x and y parameters are relative to the book's origin
    function updateBL(x:Number, y:Number):Void {
        // Find the coordinates of the bottom and top corners of the book (relative to the book's origin).
        def bookBotCornerX = 0;
        def bookBotCornerY = bookMaxH;
        def bookTopCornerX = 0;
        def bookTopCornerY = 0;
        var curX = x;                           // The x-coordinate is clamped to the edge of the book.
        var curY = y;
        if (curX <= bookBotCornerX) {
            curX = bookBotCornerX + 1;
        }
        updateCorner(bookBotCornerX, bookBotCornerY,
                     bookTopCornerX, bookTopCornerY,
                     curX, curY, pageHolders[1], pageHolders[2]);
    }
    // The x and y parameters are relative to the book's origin...
    function updateBR(x:Number, y:Number):Void {
        // Find the coordinates of the bottom and top corners of the book (relative to the book's origin).
        def bookBotCornerX = bookMaxW;
        def bookBotCornerY = bookMaxH;
        def bookTopCornerX = bookMaxW;
        def bookTopCornerY = 0;
        var curX = x;                           // The x-coordinate is clamped to the edge of the book.
        var curY = y;
        if (curX >= bookBotCornerX) {
            curX = bookBotCornerX - 1;
        }
        updateCorner(bookBotCornerX, bookBotCornerY,
                     bookTopCornerX, bookTopCornerY,
                     curX, curY, pageHolders[4], pageHolders[3]);
    }

    function animateFlip(curX:Number, curY:Number):Void {
        // Disable the grips while the animation is in progress.
        gripBL.visible = false;
        gripBR.visible = false;
        var endX = if (curX < pageMaxW) 0 else bookMaxW;
        var endY = bookMaxH;
        Timeline {
            keyFrames: [
                at (0s) {
                    currentCornerX => curX;
                    currentCornerY => curY;
                }
                at (400ms) {
                    currentCornerX => endX tween Interpolator.EASEOUT;
                    currentCornerY => endY tween Interpolator.EASEOUT;
                }
                KeyFrame {
                    time: 401ms
                    action:function() {
                        var curIndex = startIndex;
                        if (inFlipLeft and curX > pageMaxW) {
                            startIndex -= 2;
                            if (startIndex < 0) {
                                startIndex = 0;
                            }
                        } else if (inFlipRight and curX < pageMaxW) {
                            startIndex += 2;
                            if (startIndex > sizeof(pages) - 2) {
                                startIndex = sizeof(pages) - 2;
                            }
                        }
                        if (curIndex != startIndex) {
                            updatePageHolders();
                        }
                        inFlipLeft = false;
                        inFlipRight = false;
                        lineGroup.visible = false;
                        gripBL.visible = startIndex > 0;
                        gripBR.visible = startIndex < sizeof(pages) - 2;
                    }
                }
            ]
        }.play();
    }

    function updatePageHolders() {
        for (i in [0..<6]) {
            // explicitly remove any existing content in the holders
            pageHolders[i].content = null;
            pageHolders[i].clip = null;
        }
        for (i in [0..<6]) {
            var content = if (startIndex+i < 2) null else pages[startIndex + i - 2];
            pageHolders[i].content = content;
            pageHolders[i].clip = null;
        }
        pageHolders[5].translateX = pageMaxW;
        pageHolders[3].translateX = pageMaxW;
        pageHolders[1].visible = false;
        pageHolders[4].visible = false;
    }

    function initGradients() {
        for (i in [0..<6]) {
            pageHolders[i].initGradient();
        }
    }

    override function create():Node {
        updatePageHolders();
        initGradients();
        return Group {
            content: [
                pageHolders[0],
                pageHolders[2],
                pageHolders[5],
                pageHolders[3],
                pageHolders[1],
                pageHolders[4],

                lineGroup = Group {
                    visible: false
                    content: lines
                }

                gripBL = Grip {
                    translateX: 0
                    translateY: bind bookMaxH - 50
                    entered:function() {
                        lineGroup.visible = showLines;
                        pageHolders[1].visible = true;
                        gripBR.visible = false;
                        inFlipLeft = true;
                    }
                    update: updateBL
                    animate: animateFlip
                }

                gripBR = Grip {
                    translateX: bind bookMaxW - 50
                    translateY: bind bookMaxH - 50
                    entered:function() {
                        lineGroup.visible = showLines;
                        pageHolders[4].visible = true;
                        gripBL.visible = false;
                        inFlipRight = true;
                    }
                    update: updateBR
                    animate: animateFlip
                }
            ]
        };
    }
}

Stage {
    var scene:Scene;
    title: "Book Demo"
    width: 800
    height: 600
    scene:scene = Scene {
        fill: Color.BLACK
        content: [
            Book {
                translateX: bind (scene.width - bookMaxW)/2
                translateY: bind (scene.height - bookMaxH)/2
                pages: [
                    Page {
                        fill: Color.WHITESMOKE
                        text: "A"
                    }
                    Page {
                        fill: Color.WHITESMOKE
                        text: "B"
                    }
                    Page {
                        fill: Color.WHITESMOKE
                        text: "C"
                    }
                    Page {
                        fill: Color.WHITESMOKE
                        text: "D"
                    }
                    Page {
                        fill: Color.WHITESMOKE
                        text: "E"
                    }
                    Page {
                        fill: Color.PURPLE
                        text: "F"
                    }
                ]
            }
        ]
    }
}
