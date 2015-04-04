/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstjavafxproject;

/**
 *
 * @author Ravjot
 */
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
 
/**
 *
 * @author andi
 */
public class Resize extends Application {
 
    private Random rnd = new Random(System.nanoTime());
 
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        final StackPane root = new StackPane();
        File f = new File("D:\\Multimedia\\My Pics\\309098_10150271417385592_6221109_n.jpg");
        Image image = new Image(new FileInputStream(f));
        final double width = image.getWidth();
        final double height = image.getHeight();
        Canvas background = new Canvas(width, height);
        GraphicsContext context = background.getGraphicsContext2D();
        context.drawImage(image, 0, 0);
 
        root.getChildren().add(background);
 
        AnchorPane animationPane = new AnchorPane();
        int rndX = 54;
        int rndY = 23;
        final double cWidth = width- rndX;
        final double cHeight = height - rndY;
        Canvas red = new Canvas(cWidth, cHeight);
        AnchorPane.setTopAnchor(red, (double) rndY);
        AnchorPane.setLeftAnchor(red, (double) rndX);
        AnchorPane.setBottomAnchor(red, 0.0);
        AnchorPane.setRightAnchor(red, 0.0);
        animationPane.getChildren().add(red);
        GraphicsContext context2 = red.getGraphicsContext2D();
        final Paint paintColor = Paint.valueOf(Color.RED.toString());
        context2.setFill(paintColor);
        context2.fillRect(rndX, rndY, cWidth, cHeight);
        System.out.println("Draw red rectangle "+rndX+", "+rndY+", "+cWidth+", "+cHeight);
        root.getChildren().add(animationPane);
 
        Scene scene = new Scene(root, width, height);
 
        stage.setTitle("Resize Overlay Test");
        stage.setScene(scene);
        stage.show();
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
