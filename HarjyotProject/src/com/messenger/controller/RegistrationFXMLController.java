/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.controller;

import com.messenger.bindingDTO.RegisteringBindingDTO;
import com.messenger.ui.ScreenController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ravjot
 */
public class RegistrationFXMLController implements Initializable,ControlledScreen{

    ScreenController myScreen;
    
    @FXML
    TextField fullName;
    
    @FXML
    TextField enrollNo;
    
    @FXML
    TextField emailAddress;
    
    @FXML
    ComboBox branch;
    
    @FXML
    ComboBox year;
    
    
    RegisteringBindingDTO registeringDTO;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        registeringDTO = new RegisteringBindingDTO();
        //Bindings.bindBidirectional(this.emailAddress.textProperty(), this.registeringDTO.emailProperty());
        //Bindings.bindBidirectional(this.fullName.textProperty(), this.registeringDTO.fullNameProperty());
        //Bindings.bindBidirectional(this.enrollNo.textProperty(), this.registeringDTO.enrollNoProperty());
    }    

    @Override
    public void setScreenParent(ScreenController screenPage) {
        myScreen = screenPage;
    }
    
    @FXML
    public void registerUser(){
        System.out.println("Register");
        //registeringDTO.setBranch(""+branch.getSelectionModel().selectedItemProperty());
        //registeringDTO.setYear(""+year.getSelectionModel().selectedItemProperty());
        
        System.out.println(registeringDTO.getFullName());
        System.out.println(registeringDTO.getEnrollNo());
        System.out.println(registeringDTO.getEmailID());
        System.out.println(registeringDTO.getBranch());
        System.out.println(registeringDTO.getYear());
    }
    
    @FXML
    public void quit(){
        System.exit(0);
    }
}
