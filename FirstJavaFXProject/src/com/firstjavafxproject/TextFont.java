/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstjavafxproject;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Rav
 */
public class TextFont extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.LAWNGREEN);
        Text text = new Text(50, 50, "JavaFX 2.0");
        Font serif = Font.font("Serif", 30);
        text.setFont(serif);
        text.setFill(Color.RED);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.0f);
        dropShadow.setOffsetY(2.0f);
        dropShadow.setColor(Color.rgb(50, 50, 50, .588));
        text.setEffect(dropShadow);
        root.getChildren().add(text);

        Reflection refl = new Reflection();
        refl.setFraction(0.8f);
        text.setEffect(refl);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String as[]) {
        launch(as);
    }
}
