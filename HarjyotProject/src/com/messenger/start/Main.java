/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.start;

import com.messenger.constants.GlobalConstants;
import com.messenger.ui.ScreenController;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Ravjot
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ScreenController sceneNavigator = new ScreenController();
        sceneNavigator.loadScreen(GlobalConstants.registrationScene, GlobalConstants.registrationSceneFXML);

        String fname = "Notices\\UserInfo\\userinfo.ravs";

        File f = new File(fname);
        if ((f.exists()) && (f.length() != 0L)) /*     */ {
            new Main.FullTray();
        } else {

            sceneNavigator.setScreen(GlobalConstants.registrationScene);
        }

        Group root = new Group();
        root.getChildren().addAll(sceneNavigator);


        Scene scene = new Scene(root);
        root.autosize();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle(GlobalConstants.registrationSceneTitle);

        //stage.getIcons().add(new Image(GlobalConstants.registrationLoginIconImage));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
