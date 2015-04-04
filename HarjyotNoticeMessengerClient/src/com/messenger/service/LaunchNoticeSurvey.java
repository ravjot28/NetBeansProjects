/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.service;

import com.messenger.constants.GlobalConstants;
import com.messenger.ui.ScreenController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rav
 */
public class LaunchNoticeSurvey extends Application {

    private String request;

    public void displayNotice() throws Exception {
        System.out.println("In displayNotice ");
        request = "NOTICE";
        start(new Stage());
    }

    public void displaySurvey() throws Exception {
        System.out.println("In displaySurvey ");
        request = "SURVEY";
        start(new Stage());
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("In start ");
        ScreenController sceneNavigator = new ScreenController();
        if (request.equals("NOTICE")) {
            sceneNavigator.loadScreen(GlobalConstants.noticeScene, GlobalConstants.noticeSceneFXML);
            sceneNavigator.setScreen(GlobalConstants.noticeScene);
        } else {
            sceneNavigator.loadScreen(GlobalConstants.surveyScene, GlobalConstants.surveySceneFXML);
            sceneNavigator.setScreen(GlobalConstants.surveyScene);
        }
        Group root = new Group();
        root.getChildren().addAll(sceneNavigator);


        Scene scene = new Scene(root);
        root.autosize();
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        if (request.equals("NOTICE")) {
            stage.setTitle(GlobalConstants.noticeSceneTitle);
        } else {
            stage.setTitle(GlobalConstants.surveySceneTitle);
        }

        //stage.getIcons().add(new Image(GlobalConstants.registrationLoginIconImage));
        stage.show();
    }
}
