import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


Stage
{
    title: "Hello World"
    width: 220
    height: 100

    scene: Scene
           {
               content:
               [
                   Text
                   {
                       content:"Hello All My First App :)"

                       x:0

                       y:25

                       font:Font
                            {
                                name: "Sans Serif"
                                size: 12
                            }

                   }

               ]
           }

}
