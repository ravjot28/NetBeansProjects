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
import javafx.stage.Stage;

/**
 *
 * @author ravjotsingh
 */
public class BigPictureExp extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        String fxml = "BigPictureNavigationFXML.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Pane leftPane = (Pane) fxmlLoader.load();
        
        Scene scene = new Scene(leftPane);
        
        stage.setScene(scene);
        stage.setHeight(leftPane.getPrefHeight()+30);
        stage.setWidth(leftPane.getPrefWidth());
        stage.show();
    }
    
    public static void main(String as[]){
        launch(as);
    }
}
