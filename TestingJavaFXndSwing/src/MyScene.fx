import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
public class MyScene extends Scene
{
    init
    {
        content =
                [
                    Rectangle
                    {
                        width: 200
                        height: 200
                        fill: Color.BLUE
                    },

                    Text
                    {
                        x: 20 y: 20
                        content: "Greetings Earthling!"
                        fill: Color.WHITE
                    }
                ]
    }
}