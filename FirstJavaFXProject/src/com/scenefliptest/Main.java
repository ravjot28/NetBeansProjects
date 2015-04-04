/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scenefliptest;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ravjot
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        SceneNavigator sceneNavigator = new SceneNavigator();
        sceneNavigator.loadScreen("test", "Test.fxml");
        sceneNavigator.loadScreen("test1", "Test1.fxml");
        
        sceneNavigator.setScreen("test");
        Group root = new Group();
        root.getChildren().addAll(sceneNavigator);
        root.autosize();
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(GlobalConstants.calendarCSSPath);
        
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Yo Yo Honey Singh");
        //stage.getIcons().add(new Image(GlobalConstants.registrationSceneIconImageLocation));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
