/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstjavafxproject;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Rav
 */
public class LayoutExample extends Application{
    
    public static void main(String as[]){
        launch(as);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        Label fName = new Label("First Name");
        TextField fNameField = new TextField();
        
        Label lName = new Label("Last Name");
        TextField lNameField = new TextField();
        
        Button submit = new Button("Submit");
        
        
        GridPane.setHalignment(fName, HPos.RIGHT);
        gridPane.add(fName, 0, 0);
        
        GridPane.setHalignment(lName, HPos.RIGHT);
        gridPane.add(lName, 0, 1);
        
        GridPane.setHalignment(fNameField, HPos.LEFT);
        gridPane.add(fNameField, 1, 0);
        
        GridPane.setHalignment(lNameField, HPos.LEFT);
        gridPane.add(lNameField, 1, 1);
        
        GridPane.setHalignment(submit, HPos.RIGHT);
        gridPane.add(submit, 1, 2);
        
        root.getChildren().add(gridPane);
        Scene scene = new Scene(root, 500, 500,Color.WHEAT);
        stage.setScene(scene);
        stage.show();
    }
    
}
