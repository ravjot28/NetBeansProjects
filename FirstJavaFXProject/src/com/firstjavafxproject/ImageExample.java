/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstjavafxproject;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class ImageExample extends Application {
    
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
        //image = new ImageView("http://goo.gl/YsuGV");
        //image = new ImageView("http://www.wallpaperama.com/post-images/forums/200903/07p-6606-loading-photo.gif");
        image = new ImageView("http://4.bp.blogspot.com/-PdAWEWtNx28/UDdO0kMIdbI/AAAAAAAADB8/7_oFMugQ5tU/s1600/Searching.gif");
        
        //StackPane root = new StackPane();
        Pane root = new Pane();
        root.getChildren().add(image);
        
        Scene scene = new Scene(root, 300, 250,Color.TRANSPARENT);
        
        primaryStage.setTitle("Hello World!");
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
