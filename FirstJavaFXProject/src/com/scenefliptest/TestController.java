/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scenefliptest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Ravjot
 */
public class TestController implements Initializable, IScreenController {

    SceneNavigator myController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void next(){
        myController.setScreen("test1");
    }

    @Override
    public void setScreenParent(SceneNavigator screenPage) {
         myController = screenPage;
    }
    
}
