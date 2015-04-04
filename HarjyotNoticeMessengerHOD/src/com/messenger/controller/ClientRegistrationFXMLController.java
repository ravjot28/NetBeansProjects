/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.controller;

import com.messenger.bindingDTO.RegisteringBindingDTO;
import com.messenger.service.InboxReader;
import com.messenger.ui.ScreenController;
import com.messenger.util.CommonValidations;
import com.messenger.util.InvokeAnimation;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author Ravjot
 */
public class ClientRegistrationFXMLController implements Initializable, ControlledScreen {

    Logger logger = LoggerFactory.getLogger(ClientRegistrationFXMLController.class);
    ScreenController myForm;
    @FXML
    TextField fullNameTextField;
    @FXML
    TextField emailAddressTextField;
    @FXML
    TextField enrollNoTextField;
    @FXML
    ComboBox yearChoice;
    @FXML
    ComboBox branchChoice;
    RegisteringBindingDTO registeringDTO = new RegisteringBindingDTO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Bindings.bindBidirectional(fullNameTextField.textProperty(), registeringDTO.fullNameProperty());
        Bindings.bindBidirectional(emailAddressTextField.textProperty(), registeringDTO.emailProperty());
        Bindings.bindBidirectional(enrollNoTextField.textProperty(), registeringDTO.enrollNoProperty());
        yearChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newVlaue) {
                if (newVlaue != null) {
                    registeringDTO.setYear(newVlaue);
                }
            }
        });

        branchChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldValue, String newVlaue) {
                if (newVlaue != null) {
                    registeringDTO.setBranch(newVlaue);
                }
            }
        });
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        myForm = screenPage;
    }

    @FXML
    public void registerAction() {
        logger.info("Register");
        String fullName = registeringDTO.getFullName();
        String emailAddress = registeringDTO.getEmailID();
        String enrollNumber = registeringDTO.getEnrollNo();
        String branch = registeringDTO.getBranch();
        String year = registeringDTO.getYear();

        if (!CommonValidations.isStringEmpty(fullName)) {
            if (!CommonValidations.isStringEmpty(enrollNumber)) {
                if (!CommonValidations.isStringEmpty(emailAddress) && CommonValidations.isValidEmailAddress(emailAddress)) {
                    if (!CommonValidations.isStringEmpty(branch)) {
                        if (!CommonValidations.isStringEmpty(year)) {
                            logger.info("Full Name " + registeringDTO.getFullName());
                            logger.info("Email Address " + registeringDTO.getEmailID());
                            logger.info("Enrollment Number " + registeringDTO.getEnrollNo());
                            logger.info("Branch " + registeringDTO.getBranch());
                            logger.info("Year " + registeringDTO.getYear());
                            try {
                                BufferedWriter b = new BufferedWriter(new FileWriter("Notices\\UserInfo\\userinfo.ravs"));
                                b.append(registeringDTO.getBranch().trim());
                                b.newLine();
                                b.append(registeringDTO.getYear().trim());
                                b.close();
                            } catch (Exception e) {
                                logger.error(e.getMessage(), e);
                            }

                            Scene scene = fullNameTextField.getScene();
                            if (scene != null) {
                                Window window = scene.getWindow();
                                if (window != null) {
                                    window.hide();
                                }
                            }

                            Task task = new Task<Void>() {
                                @Override
                                public Void call() {
                                    callReader();
                                    return null;
                                }
                            };
                            new Thread(task).start();
                        } else {
                            InvokeAnimation.attentionSeekerWobble(yearChoice);
                        }
                    } else {
                        InvokeAnimation.attentionSeekerWobble(branchChoice);
                    }
                } else {
                    InvokeAnimation.attentionSeekerWobble(emailAddressTextField);
                }
            } else {
                InvokeAnimation.attentionSeekerWobble(enrollNoTextField);
            }
        } else {
            InvokeAnimation.attentionSeekerWobble(fullNameTextField);
            fullNameTextField.getStyleClass().add("promptTextError");
        }
    }

    public void callReader() {
        
    }

    @FXML
    public void quitAction() {
        System.exit(0);
    }
}
