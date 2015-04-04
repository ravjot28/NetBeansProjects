import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.CustomNode;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.JFileChooser;

import java.lang.Math;

// @author Sergey A. Malenkov

def startVideoURL = "http://webcast-west.sun.com/interactive/javafx/VideoCube.fxm";
def chooser = new JFileChooser();
def r = 100;
def d = r + r;

class Point {
    var x:Number;
    var y:Number;
    var z:Number;

    function rotateX(cos, sin) {
        var tmp = cos*y - sin*z;
        z = cos*z + sin*y;
        y = tmp;
    }

    function rotateY(cos, sin) {
        var tmp = cos*x + sin*z;
        z = cos*z - sin*x;
        x = tmp;
    }

    function rotateZ(cos, sin) {
        var tmp = cos*x - sin*y;
        y = cos*y + sin*x;
        x = tmp;
    }
}

class Face extends CustomNode {
    var number:Integer;
    var ul:Point;
    var ur:Point;
    var lr:Point;
    var ll:Point;
    var background = Color.web("#ebe4ab");
    var foreground = Color.web("#3b3336");
    var error = true;
    var media:Media;
    var source:String on replace old {
        if (source != old) {
            error = false;
            media = Media {
                source: source
                onError:function(error) {
                    this.error = true;
                    Alert.inform("Loading error", error.message)
                }
            }
        }
    }

    def z = bind ul.z + ur.z + lr.z + ll.z;
    var start:Number;
    var length:Number;

    def animation = Timeline {
        repeatCount: Timeline.INDEFINITE
        keyFrames: [
            at(0s) { start => 90; length => 0 },
            at(2s) { start => 90; length => 360 },
            at(4s) { start => 450; length => 0 }
        ]
    }

    def animate = bind z > 0 and error on replace old {
        if (animate != old) {
            if (animate) {
                animation.play()
            } else {
                animation.pause()
            }
        }
    }

    override function create() {
        def pt = PerspectiveTransform {
            ulx: bind d + ul.x
            uly: bind d + ul.y
            urx: bind d + ur.x
            ury: bind d + ur.y
            lrx: bind d + lr.x
            lry: bind d + lr.y
            llx: bind d + ll.x
            lly: bind d + ll.y
        }
        Group {
            visible: bind z > 0
            content: [
                Polygon {
                    points: bind [
                        pt.ulx,
                        pt.uly,
                        pt.urx,
                        pt.ury,
                        pt.lrx,
                        pt.lry,
                        pt.llx,
                        pt.lly
                    ]
                    cursor: Cursor.HAND
                    blocksMouse: true
                    onMouseClicked:function(event) {
                        rotation.pause();
                        if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
                            source = chooser.getSelectedFile().toURI().toString()
                        }
                        rotation.play();
                    }
                    onMouseDragged:function(event) {
                        ax = if (-5 < event.dragY and event.dragY < 5) then 0 else - event.dragY/10000;
                        ay = if (-5 < event.dragX and event.dragX < 5) then 0 else event.dragX/10000;
                    }
                },
                Group {
                    effect: pt
                    visible: bind error
                    content: [
                        Rectangle {
                            x: -100
                            width: 200
                            y: -100
                            height: 200
                            fill: bind background
                            stroke: bind foreground
                            strokeWidth: 2
                        },
                        Circle {
                            radius: 85
                            fill: bind foreground
                        },
                        Circle {
                            radius: 80
                            fill: Color.web("#c7b668")
                        },
                        Circle {
                            radius: 70
                            fill: Color.web("#645f37")
                        },
                        Circle {
                            radius: 65
                            fill: bind background
                        },
                        Text {
                            x: -34
                            y: 40
                            content: bind "{number}"
                            fill: bind foreground
                            font:Font {
                                size: 120
                                embolden: true
                            }
                        },
                        Line {
                            startX: -80
                            endX: 80
                            stroke: bind foreground
                            strokeWidth: 2
                        },
                        Line {
                            startY: -80
                            endY: 80
                            stroke: bind foreground
                            strokeWidth: 2
                        },
                        Arc {
                          radiusX: 80
                          radiusY: 80
                          startAngle: bind start
                          length: bind length
                          type: ArcType.ROUND
                          opacity: 0.2
                        }
                    ]
                },
                MediaView {
                    effect: pt
                    visible: bind not error
                    mediaPlayer:MediaPlayer {
                        media: bind media
                        autoPlay: true
                        repeatCount: MediaPlayer.REPEAT_FOREVER
                        volume: bind if (z > 0)
                                then 0.25*z/r
                                else 0
                    }
                }
            ]
        }
    }
}

var ax = 0.002;
def cx = bind Math.cos(ax);
def sx = bind Math.sin(ax);
var ay = -0.006;
def cy = bind Math.cos(ay);
def sy = bind Math.sin(ay);
def ful = Point {
    x: -r
    y: -r
    z: r
}
def fur = Point {
    x: r
    y: -r
    z: r
}
def flr = Point {
    x: r
    y: r
    z: r
}
def fll = Point {
    x: -r
    y: r
    z: r
}
def bul = Point {
    x: bind - ful.x
    y: bind - ful.y
    z: bind - ful.z
}
def bur = Point {
    x: bind - fur.x
    y: bind - fur.y
    z: bind - fur.z
}
def blr = Point {
    x: bind - flr.x
    y: bind - flr.y
    z: bind - flr.z
}
def bll = Point {
    x: bind - fll.x
    y: bind - fll.y
    z: bind - fll.z
}

Stage {
    title: "Video Cube (JavaFX sample)"
    style: StageStyle.TRANSPARENT
    resizable: false
    scene:Scene {
        fill: null
        width: d + d
        height: d + d
        content: [
            Face {
                number: 1
                ul: ful
                ur: fur
                lr: flr
                ll: fll
                source: startVideoURL
            },
            Face {
                number: 2
                ul: flr
                ur: fur
                lr: bll
                ll: bul
            },
            Face {
                number: 3
                ul: bur
                ur: fll
                lr: flr
                ll: bul
            },
            Face {
                number: 4
                ul: bll
                ur: fur
                lr: ful
                ll: blr
            },
            Face {
                number: 5
                ul: bur
                ur: blr
                lr: ful
                ll: fll
            },
            Face {
                number: 6
                ul: bur
                ur: bul
                lr: bll
                ll: blr
            }
        ]
    }
}

def rotation = Timeline {
    repeatCount: Timeline.INDEFINITE
    keyFrames:KeyFrame {
        time: 40ms
        action:function() {
            if (ax != 0) {
                ful.rotateX(cx, sx);
                fur.rotateX(cx, sx);
                flr.rotateX(cx, sx);
                fll.rotateX(cx, sx);
            }
            if (ay != 0) {
                ful.rotateY(cy, sy);
                fur.rotateY(cy, sy);
                flr.rotateY(cy, sy);
                fll.rotateY(cy, sy);
            }
        }
    }
}
rotation.play()