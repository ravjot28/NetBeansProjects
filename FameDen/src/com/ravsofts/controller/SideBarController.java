/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.controller;

import com.ravsofts.util.ControlledScreen;
import com.ravsofts.fxml.ScreenController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Ravjot
 */
public class SideBarController implements Initializable, ControlledScreen {

    ScreenController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreenController screenPage) {
        myController = screenPage;
    }
}
