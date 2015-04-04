/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gift;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import static javafx.application.Application.launch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Rav
 */
public class Gift extends Application {
    
    private ImageView image;
    @Override
    public void start(Stage primaryStage) {
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });*/
        String urls[] ={"http://www.glitters123.com/glitter_graphics/Romantic/Romantic-Glitters-2.gif",
        "http://www.glitters123.com/glitter_graphics/Romantic/Romantic-Glitters-18.gif",
        "http://www.glitters123.com/glitter_graphics/Romantic/Romantic-Glitters-16.gif",
        "http://www.glitters123.com/glitter_graphics/Romantic/Romantic-Glitters-1.gif",
        "http://www.glitters123.com/glitter_graphics/Love/Love-Glitters-58.gif",
        "http://www.glitters123.com/glitter_graphics/Love/Love-Glitters-56.gif",
        "http://www.glitters123.com/glitter_graphics/Love/Love-Glitters-55.gif",
        "http://www.glitters123.com/glitter_graphics/Love/Love-Glitters-57.gif",
        "http://www.glitters123.com/glitter_graphics/Love/Love-Glitters-59.gif",
        "http://www.glitters123.com/glitter_graphics/Love/Love-Glitters-60.gif",
        "http://www.glitters123.com/glitter_graphics/Love/Love-Glitters-61.gif",
        "http://www.glitters123.com/glitter_graphics/Love/Love-Glitters-62.gif",
        "http://www.glitters123.com/glitter_graphics/Love/Love-Glitters-63.gif"};
        
        image = new ImageView(urls[new Random().nextInt((urls.length+1) - 0) + 0]);
        
        //StackPane root = new StackPane();
        Pane root = new Pane();
        root.getChildren().add(image);
        
        Scene scene = new Scene(root, 500, 500,Color.TRANSPARENT);
        
        primaryStage.setTitle("Samta");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
