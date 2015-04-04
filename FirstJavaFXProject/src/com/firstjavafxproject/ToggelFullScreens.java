/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstjavafxproject;

/**
 *
 * @author Rav
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ToggelFullScreens extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setFullScreen(true);
        Button btn = new Button("Login");
        btn.setOnAction(loginClienteHandler());

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("JavaFX version: " + com.sun.javafx.runtime.VersionInfo.getRuntimeVersion());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public EventHandler loginClienteHandler() {
        EventHandler evh = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new Scene(VBoxBuilder.create().children(new Text("text")).build()));
                primaryStage.sizeToScene();
                primaryStage.setFullScreen(false);
                primaryStage.setFullScreen(true);
            }
        };
        return evh;
    }

    public static void main(String[] args) {
        launch(args);
    }
}