/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import sun.security.util.Password;

/**
 * FXML Controller class
 *
 * @author ravjotsingh
 */
public class LoginPageFXMLController implements Initializable {

    @FXML
    Button button;
    
    @FXML
    PasswordField password;
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void pankaj(){
        System.out.println("sdfdsf");
    }
    
}
