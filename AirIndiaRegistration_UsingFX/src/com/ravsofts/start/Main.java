/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.start;

import com.ravsofts.constants.GlobalConstants;
import com.ravsofts.ui.ScreenController;
import com.ravsofts.util.UserStatus;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Ravjot
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        UserStatus userStatus = new UserStatus();

        if (userStatus.isNewUser()) {
            ScreenController screenController = new ScreenController();
            screenController.loadScreen(GlobalConstants.employeeDetailsScreen, GlobalConstants.employeeDetailsScreenFXML);
            screenController.loadScreen(GlobalConstants.addressDetailsScreen, GlobalConstants.addressDetailsScreenFXML);
            screenController.loadScreen(GlobalConstants.contactDetailsScreen, GlobalConstants.contactDetailsScreenFXML);
            screenController.loadScreen(GlobalConstants.nomineeDetailsScreen, GlobalConstants.nomineeDetailsScreenFXML);
            screenController.loadScreen(GlobalConstants.agreementScreen, GlobalConstants.agreementScreenFXML);
            screenController.loadScreen(GlobalConstants.checkingStaffNoScreen, GlobalConstants.checkingStaffNoScreenFXML);
            screenController.loadScreen(GlobalConstants.sendRequestScreen, GlobalConstants.sendRequestScreenFXML);


            screenController.setScreen(GlobalConstants.employeeDetailsScreen);

            Group root = new Group();
            root.getChildren().addAll(screenController);
            root.autosize();

            Scene scene = new Scene(root);
            scene.getStylesheets().add(GlobalConstants.calendarCSSPath);
            System.out.println(scene.getStylesheets().get(0));
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(GlobalConstants.mainStageTitle);
            stage.getIcons().add(new Image(GlobalConstants.stageIconImageLocation));
            stage.show();
        } else {
            ScreenController screenController = new ScreenController();
            screenController.loadScreen(GlobalConstants.employeeDetailsEditScreen, GlobalConstants.employeeDetailsEditScreenFXML);
            screenController.loadScreen(GlobalConstants.addressDetailsEditScreen, GlobalConstants.addressDetailsEditScreenFXML);
            screenController.loadScreen(GlobalConstants.contactDetailsEditScreen, GlobalConstants.contactDetailsEditScreenFXML);
            screenController.loadScreen(GlobalConstants.nomineeDetailsEditScreen, GlobalConstants.nomineeDetailsEditScreenFXML);
            screenController.loadScreen(GlobalConstants.agreementEditScreen, GlobalConstants.agreementEditScreenFXML);
            screenController.loadScreen(GlobalConstants.checkingStaffNoScreen, GlobalConstants.checkingStaffNoScreenFXML);
            screenController.loadScreen(GlobalConstants.sendRequestScreen, GlobalConstants.sendRequestScreenFXML);

            screenController.setScreen(GlobalConstants.employeeDetailsEditScreen);

            Group root = new Group();
            root.getChildren().addAll(screenController);
            root.autosize();

            Scene scene = new Scene(root);
            scene.getStylesheets().add(GlobalConstants.calendarCSSPath);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(GlobalConstants.editStageTitle);
            stage.getIcons().add(new Image(GlobalConstants.stageIconImageLocation));
            stage.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
