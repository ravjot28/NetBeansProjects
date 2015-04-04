/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gurmathquiz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Ravjot
 */
public class MainViewFXMLController implements Initializable,ControlledScreen {

    ScreenController sceneController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreenController screenPage) {
        sceneController = screenPage;
    }
}
