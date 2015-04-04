/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.fxml;

import com.ravsofts.util.ControlledScreen;
import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author Ravjot
 */
public class ScreenController extends StackPane {

    private HashMap<String, Object[]> screens = new HashMap<String, Object[]>();

    public ScreenController() {
        super();
    }

    public void getScreen(String name) {
        screens.get(name);
    }
    
    public ControlledScreen getControlledScreen(String name){
        return (ControlledScreen)(screens.get(name)[1]);
    }
    
    public Node getNodeScreen(String name){
        return (Node)(screens.get(name)[0]);
    }

    public void addScreen(String name, Object[] screen) {
        screens.put(name, screen);
    }

    public boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenControler =
                    ((ControlledScreen) myLoader.getController());

            myScreenControler.setScreenParent(this);
            addScreen(name, new Object[] {loadScreen,myScreenControler});
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setScreen(final String name) {

        if (screens.get(name) != null) { //screen loaded 
            final DoubleProperty opacity = opacityProperty();

            //Is there is more than one screen 
            if (!getChildren().isEmpty()) {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO,
                        new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(200),
                        new EventHandler() {
                    @Override
                    public void handle(Event t) {
                        //remove displayed screen 
                        getChildren().remove(0);
                        //add new screen 
                        getChildren().add(0, (Node)(screens.get(name)[0]));
                        Timeline fadeIn = new Timeline(
                                new KeyFrame(Duration.ZERO,
                                new KeyValue(opacity, 0.0)),
                                new KeyFrame(new Duration(100),
                                new KeyValue(opacity, 1.0)));
                        fadeIn.play();
                    }
                }, new KeyValue(opacity, 0.0)));
                fade.play();
            } else {
                //no one else been displayed, then just show 
                setOpacity(0.0);
                getChildren().add((Node)(screens.get(name)[0]));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO,
                        new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(800),
                        new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("screen hasn't been loaded!\n");
            return false;
        }
    }

    public boolean unloadScreen(String name) {
        if (screens.remove(name) == null) {
            System.out.println("Screen not present");
            return false;
        } else {
            return true;
        }
    }
}
