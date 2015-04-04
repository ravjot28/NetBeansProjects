import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

def w = 500;
def h = 400;

public class MyScene extends Scene {
    var xx = w / 3;
    var yy = h / 2;
    var rotate = 0;
    var text = "";

    var tl = Timeline {

      repeatCount: Timeline.INDEFINITE
      keyFrames : [
        KeyFrame {
          time: 70ms
          action: function() {
             text = JavaFXToSwingTest.tf.getText();
             rotate = (rotate+5) mod 360;
          }
        }
      ]
     }

     override var content= [
        Rectangle {
            width: w, height: h
            fill: Color.BLUE
        },
        Text {
            font : Font {
                    size: 24
                   }
            layoutX: bind  xx
            layoutY: bind yy
            rotate: bind rotate
            content: bind text
            fill: Color.YELLOW
        }
    ];

    init { tl.play(); }
}  