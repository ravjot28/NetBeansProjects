/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Ravjot
 */
import static javafx.application.Application.launch;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class CSSBoxStyles extends Application {
  @Override public void start(Stage stage) {
    StackPane  shadowPane = new StackPane();
    shadowPane.getStyleClass().add("right-page-turn");
 
    AnchorPane anchorPane = new AnchorPane(); 
    anchorPane.getStyleClass().add("content-pane");
    anchorPane.setMinSize(400, 200);
                                     
    StackPane layout = new StackPane();
    layout.getChildren().setAll(
      shadowPane,
      anchorPane      
    );
    
    stage.setScene(new Scene(layout));
    stage.getScene().getStylesheets().add(
      getClass().getResource("shadow-style.css").toExternalForm()
    );
    stage.show();
  }
 
  public static void main(String[] args) { launch(args); }
}
