import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.CustomNode;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Math;

class FlipView extends CustomNode {
    // public variables for users of this class to set the front and back
    public var frontNode:Node;
    public var backNode:Node;

    var flipped = true;

    // the animation to flip between front and back
    var time = Math.PI/2;
    public var anim = Timeline {
        keyFrames: [
            at(0s) { time=> Math.PI/2 tween Interpolator.LINEAR},
            at(1s) { time=> -Math.PI/2 tween Interpolator.LINEAR},
            KeyFrame {
                time: 1.0s
                action:function() {
                    flipped = not flipped;
                }
            }
        ]
    }

    override public function create():Node {
        return Group {
            content: [
                Group {
                    content: backNode
                    visible: bind time < 0
                    effect: bind getPT(time)
                },
                Group {
                    content: frontNode
                    visible: bind time > 0
                    effect: bind getPT(time)
                },
            ]
        }
    }
    /**
     * Returns the actual perspective transform.
     * Calcualtes the transform by stretching the front and back
     * edges according to a sine and cosine curve multiplied by
     * the constants: radius and back
     */
    function getPT(t:Number):PerspectiveTransform {
        var width = 200;
        var height = 200;
        var radius = width/2;
        var back = height/10;
        return PerspectiveTransform {
            ulx: radius - Math.sin(t)*radius
            uly: 0 - Math.cos(t)*back
            urx: radius + Math.sin(t)*radius
            ury: 0 + Math.cos(t)*back
            lrx: radius + Math.sin(t)*radius
            lry: height - Math.cos(t)*back
            llx: radius - Math.sin(t)*radius
            lly: height + Math.cos(t)*back
        }
    }
    public function doFlip():Void {
        flip.anim.rate = 1.0;
        flip.anim.time = 0s;
        flip.anim.play();
    }

    public function doRevFlip():Void {
        flip.anim.rate = -1.0;
        flip.anim.time = 1s;
        flip.anim.play();
    }
}

// create an instance of FlipView  using two pictures of the lion
var flip: FlipView = FlipView {
    translateX: 50
    translateY: 40 + 50
    backNode:ImageView {
        image:Image { url: "{__DIR__}lion1.png"  }
    }
    frontNode:ImageView {
        image:Image { url: "{__DIR__}lion2.png"  }
    }
   onKeyPressed: function(e: KeyEvent) {
        if((e.code == KeyCode.VK_LEFT) or (e.code == KeyCode.VK_TRACK_NEXT) or
           (e.code == KeyCode.VK_RIGHT) or (e.code == KeyCode.VK_TRACK_PREV)) {
            if (flip.flipped) { flip.doFlip(); }
                else flip.doRevFlip();
        }
    }
};

public function run() {
    Stage {
        title: "Flip Transition"
        scene: Scene {
            fill: Color.BLACK
            width: 300
            height: 340
            content: [
                flip,       //The flip transition
                Group {
                    translateX: 50
                    translateY: 5
                    content: [
                        Rectangle {
                        width: 200
                        height: 35
                        fill: Color.rgb(100, 100, 100)
                        stroke: Color.DARKGRAY
                        },
                        Text {
                            fill: Color.WHITE
                            content: "Click Here to Flip"
                            y: 25
                            x: 27
                            font:Font { size: 18 }
                        },
                        Rectangle {
                            width: 200
                            height: 35
                            fill: Color.rgb(200, 0, 0, 0.0)
                            onMousePressed:function(e:MouseEvent) {
                                if (flip.flipped) { flip.doFlip(); }
                                else flip.doRevFlip();
                            }
                        }
                    ]
                }
            ]
        }
     }
    flip.requestFocus();
}
