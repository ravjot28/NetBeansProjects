/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.controller;

import com.ravsofts.constants.GlobalConstants;
import com.ravsofts.dao.EmployeeDetails;
import com.ravsofts.process.ValidateStaffNo;
import com.ravsofts.ui.ScreenController;
import java.net.URL;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.ravsofts.controls.calendar.DatePicker;

/**
 * FXML Controller class
 *
 * @author Ravjot
 */
public class MembershipFormEmployeeDetailsController implements Initializable, ControlledScreen {

    ScreenController myController;
    @FXML
    TextField fullName;
    @FXML
    TextField staffNo;
    @FXML
    TextField dob;
    @FXML
    Pane pane;
    @FXML
    private Button cancel;
    @FXML
    private Button next;
    DatePicker datePicker = new DatePicker();
    public EmployeeDetails employeeDetails = new EmployeeDetails();
    private ValidateStaffNo validateStaffNo;
    private String staffNumber;
    private boolean validation;
    private Stage stage = new Stage();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Bindings.bindBidirectional(fullName.textProperty(), employeeDetails.fullNameProperty());
        Bindings.bindBidirectional(staffNo.textProperty(), employeeDetails.staffNoProperty());

        datePicker.localeProperty().set(Locale.ENGLISH);
        datePicker.setLayoutX(124.0);
        datePicker.setLayoutY(81.0);

        datePicker.setPrefWidth(200.0);
        datePicker.selectedDateProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
            }
        });
        datePicker.setPromptText(GlobalConstants.dateOfBirthPromptText);
        datePicker.setLocale(Locale.ENGLISH);
        datePicker.getCalendarView().todayButtonTextProperty().set(GlobalConstants.todayLabel);
        datePicker.getCalendarView().setShowWeeks(false);
        pane.getChildren().add(datePicker);

        validateStaffNo = new ValidateStaffNo();
    }

    @FXML
    public void moveToAddressDetailsPage() {
        int age = -1;
        int year1 = 0;
        int year2 = 0;
        int month1 = 0;
        int month2 = 0;
        String employeeFullName = employeeDetails.getFullName();
        staffNumber = employeeDetails.getStaffNo();
        Calendar now = Calendar.getInstance();
        Calendar dateOfBirth = Calendar.getInstance();
        if (datePicker != null && datePicker.getSelectedDate() != null) {
            dateOfBirth.setTime(datePicker.getSelectedDate());
            year1 = now.get(Calendar.YEAR);
            year2 = dateOfBirth.get(Calendar.YEAR);
            age = year1 - year2;
            month1 = now.get(Calendar.MONTH);
            month2 = dateOfBirth.get(Calendar.MONTH);
            if (month2 > month1) {
                age--;
            } else if (month1 == month2) {
                int day1 = now.get(Calendar.DAY_OF_MONTH);
                int day2 = dateOfBirth.get(Calendar.DAY_OF_MONTH);
                if (day2 > day1) {
                    age--;
                }
            }
        }

        if (employeeFullName == null || employeeFullName.trim().length() == 0) {
            Dialogs.showErrorDialog(null, null, GlobalConstants.invalidFullNameFieldMessage, GlobalConstants.ERROR);
        } else if (age >= 60 || age <= 20) {
            Dialogs.showErrorDialog(null, null, GlobalConstants.invalidDOBFieldMessage, GlobalConstants.ERROR);
        } else if (staffNumber == null || staffNumber.trim().length() == 0) {
            Dialogs.showErrorDialog(null, null, GlobalConstants.invalidStaffNoFieldMessage, GlobalConstants.ERROR);
        } else {
            employeeDetails.setDateOfBirth(dateOfBirth);

            Group root = new Group();
            root.getChildren().addAll(myController.getNodeScreen(GlobalConstants.checkingStaffNoScreen));
            root.autosize();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(GlobalConstants.validationStageTitle);
            stage.getIcons().add(new Image(GlobalConstants.stageIconImageLocation));
            stage.centerOnScreen();
            stage.setFocused(true);
            cancel.disableProperty().set(true);
            next.disableProperty().set(true);
            stage.show();

            Task task = new Task<Void>() {
                @Override
                public Void call() {
                    try {
                        validation = false;
                        validation = validateStaffNo.validateStaffNo(staffNumber);
                        if (validation) {
                            passedValidation();
                        } else {
                            failedValidation();
                        }

                    } catch (Exception ex) {
                        internetConnectionError();
                    }
                    return null;
                }
            };
            new Thread(task).start();
        }
    }

    public void passedValidation() {
        Platform.runLater(new Runnable() {
            public void run() {
                cancel.disableProperty().set(false);
                next.disableProperty().set(false);
                stage.hide();
                myController.setScreen(GlobalConstants.addressDetailsScreen);
            }
        });
    }

    public void failedValidation() {
        Platform.runLater(new Runnable() {
            public void run() {
                cancel.disableProperty().set(false);
                next.disableProperty().set(false);
                stage.hide();
                Dialogs.showErrorDialog(null, null, GlobalConstants.staffNoValidationErrorMessage, GlobalConstants.ERROR);
            }
        });
    }

    public void internetConnectionError() {
        Platform.runLater(new Runnable() {
            public void run() {
                cancel.disableProperty().set(false);
                next.disableProperty().set(false);
                stage.hide();
                Dialogs.showErrorDialog(null, null, GlobalConstants.internetConnectionErrorMessage, GlobalConstants.ERROR);
            }
        });
    }

    @FXML
    public void quitButtonHandler() {
        System.exit(0);
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        myController = screenPage;
    }
}
