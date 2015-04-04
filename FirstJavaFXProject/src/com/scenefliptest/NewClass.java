/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scenefliptest;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ravjot
 */
public class NewClass extends Application{

    public static void main(String a[]) {
        launch();
    }

    public Rectangle rect() {
        Rectangle rectSeq = new Rectangle(25, 25, 50, 50);
        rectSeq.setArcHeight(15);
        rectSeq.setArcWidth(15);
        rectSeq.setFill(Color.CRIMSON);
        rectSeq.setTranslateX(50);
        rectSeq.setTranslateY(50);
        FadeTransition fadeTransition =
                new FadeTransition(Duration.millis(1000), rectSeq);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);

        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(2000), rectSeq);
        translateTransition.setFromX(50);
        translateTransition.setToX(375);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);

        RotateTransition rotateTransition =
                new RotateTransition(Duration.millis(2000), rectSeq);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);

        ScaleTransition scaleTransition =
                new ScaleTransition(Duration.millis(2000), rectSeq);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                rotateTransition,
                scaleTransition);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.setAutoReverse(true);

        sequentialTransition.play();
        return rectSeq;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        root.getChildren().addAll(rect());
        root.autosize();
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(GlobalConstants.calendarCSSPath);
        
        //stage.initStyle(StageStyle.UNDECORATED);
        //stage.sizeToScene();
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Yo Yo Honey Singh");
        //stage.getIcons().add(new Image(GlobalConstants.registrationSceneIconImageLocation));
        stage.show();
    }
}
