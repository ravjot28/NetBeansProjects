/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airindiaregistration_usingfx;

/**
 *
 * @author Ravjot
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravjot
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;
    private AnchorPane page;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(airindiaregistration_usingfx.Main.class, (java.lang.String[]) null);
    }

    @Override
    public void start(Stage primary) {
        this.primaryStage = primary;
        try {
            BorderPane mainPage = new BorderPane();
            page = (AnchorPane) FXMLLoader.load(airindiaregistration_usingfx.Main.class.getResource("MembershipFormEmployeeDetails.fxml"));
            mainPage.setCenter(page);
            Scene scene = new Scene(mainPage);
            primaryStage.setScene(scene);
            primaryStage.resizableProperty().setValue(false);
            primaryStage.centerOnScreen();
            primaryStage.setTitle("BSAEIA Membership Form");
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(airindiaregistration_usingfx.MainAirIndiaMembershipForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
