/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstjavafxproject;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CheckMenuItemBuilder;
import javafx.scene.control.Menu;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.RadioMenuItemBuilder;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Rav
 */
public class MenuBarExample extends Application{
    
    public static void main(String as[]){
        launch(as);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("File");
        menu.getItems().add(new MenuItem("Save"));
        menu.getItems().add(new MenuItem("Edit"));
        menu.getItems().add(new MenuItem("Exit"));
        menuBar.getMenus().add(menu);
        
        menu = new Menu("Camera");
        menu.getItems().add(CheckMenuItemBuilder.create().text("Camera 1").selected(true).build());
        menu.getItems().add(CheckMenuItemBuilder.create().text("Camera 2").selected(true).build());
        menuBar.getMenus().add(menu);
        
        
        menu = new Menu("Alarm");
        ToggleGroup tGroup = new ToggleGroup();
        RadioMenuItem r1 = RadioMenuItemBuilder.create().toggleGroup(tGroup).text("Alarm On").build();
        RadioMenuItem r2 = RadioMenuItemBuilder.create().toggleGroup(tGroup).text("Alarm Off").build();
        menu.getItems().add(r1);
        menu.getItems().add(r2);
        
        Menu menu1 = new Menu("Temp");
        menu1.getItems().add(new CheckMenuItem("1"));
        menu1.getItems().add(new CheckMenuItem("2"));
        menu1.getItems().add(new CheckMenuItem("3"));
        
        menu.getItems().add(menu1);
        menuBar.getMenus().add(menu);
        
        
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        
        
        
        root.getChildren().add(menuBar);
        
        stage.setScene(scene);
        stage.show();
    }
    
}
