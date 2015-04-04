/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fameden.experiments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author ravjotsingh
 */
public class TestSpotlight extends Application {

    public static void main(String s) {
        launch(s);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Slide out demo");


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpotLightTestFXML.fxml"));
        Pane leftPane = (Pane) fxmlLoader.load();
        StackPane g = new StackPane();
        final Scene scene = new Scene(g, 300, 250);
        scene.setFill(null);
        Rectangle r = new Rectangle();
        r.setFill(Color.BLACK);

        g.getChildren().add(leftPane);

        
        stage.setScene(scene);
        stage.show();
    }

}
