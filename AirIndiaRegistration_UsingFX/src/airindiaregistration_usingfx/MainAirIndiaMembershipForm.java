/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airindiaregistration_usingfx;

/**
 *
 * @author Ravjot
 */
import com.ravsofts.dao.EmployeeDetails;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainAirIndiaMembershipForm extends Application {

    @FXML
    private TextField fullName;
    private EmployeeDetails employeeDetails = new EmployeeDetails();
    private Stage primaryStage;
    private AnchorPane page;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(MainAirIndiaMembershipForm.class, (java.lang.String[]) null);
    }

    @Override
    public void start(Stage primary) {
        this.primaryStage = primary;
        try {
            BorderPane mainPage = new BorderPane();
            page = (AnchorPane) FXMLLoader.load(MainAirIndiaMembershipForm.class.getResource("MainAirIndiaMembershipForm.fxml"));
            mainPage.setCenter(page);
            Scene scene = new Scene(mainPage);
            primaryStage.setScene(scene);
            primaryStage.resizableProperty().setValue(false);
            primaryStage.centerOnScreen();
            primaryStage.setTitle("BSAEIA Membership Form");
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(MainAirIndiaMembershipForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void quitButtonHandler() {
        System.exit(0);
    }

    @FXML
    private void moveToSecondPage() throws IOException {
       System.out.println("Hello");
       Pane root = FXMLLoader.load(MainAirIndiaMembershipForm.class.getResource("MainAirIndiaMembershipForm.fxml"));
       System.out.println(root.lookup("#fullName"));
       System.out.println(((TextField)root.lookup("#fullName")));
    }
}
