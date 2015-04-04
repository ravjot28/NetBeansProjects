/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fameden.experiments;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ravjotsingh
 */
public class NewClass extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Light.Spot light = new Light.Spot();
        light.setX(150);
        light.setY(100);
        light.setZ(80);
        light.setPointsAtX(0);
        light.setPointsAtY(0);
        light.setPointsAtZ(-50);
        light.setSpecularExponent(2);

        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);

        Text text = new Text();
        text.setText("Spot");
        text.setFill(Color.STEELBLUE);
        text.setFont(Font.font(null, FontWeight.BOLD, 80));
        text.setX(10.0);
        text.setY(10.0);
        text.setTextOrigin(VPos.TOP);
        text.setEffect(lighting);

        Rectangle rect = new Rectangle(200, 150);
        rect.setFill(Color.ALICEBLUE);
        rect.setEffect(lighting);
        AnchorPane pane = new AnchorPane();
        pane.getChildren().add(rect);
        Scene root = new Scene(pane);
        stage.setScene(root);
        stage.show();
    }
    
    public static void  main(String as[]){
        launch();
    }

}
