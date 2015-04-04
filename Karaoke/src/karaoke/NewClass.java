/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package karaoke;

/**
 *
 * @author Ravjot
 */
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
 
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
/**
*
* @author Seven
*/
public class NewClass extends Application {
 
  File file;
 
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
      launch(args);
  }
 
  @Override
  public void start(Stage primaryStage) {
      primaryStage.setTitle("Hello World!");
     
      final Label labelFile = new Label();
     
      Button btn = new Button();
      btn.setText("Open FileChooser'");
      btn.setOnAction(new EventHandler<ActionEvent>() {
 
          @Override
          public void handle(ActionEvent event) {
              FileChooser fileChooser = new FileChooser();
 
              //Set extension filter
              FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("AVI files (*.avi)", "*.avi");
              fileChooser.getExtensionFilters().add(extFilter);
             
              //Show open file dialog
              file = fileChooser.showOpenDialog(null);
             
              labelFile.setText(file.getPath());
          }
      });
     
      VBox vBox = new VBox();
      vBox.getChildren().addAll(labelFile, btn);
     
      StackPane root = new StackPane();
      root.getChildren().add(vBox);
      primaryStage.setScene(new Scene(root, 300, 250));
      primaryStage.show();
  }
}
