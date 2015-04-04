/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gurmathquiz;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioButtonBuilder;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Rav
 */
public class GurmathQuiz extends Application {

    @Override
    public void start(final Stage primaryStage) {
        /*GridPane gridPane = new GridPane();
         gridPane.setPadding(new Insets(6));
         gridPane.setHgap(5);
         gridPane.setVgap(5);

         Label question = new Label("Question");
         TextArea questionContent = new TextArea();
         questionContent.opacityProperty().setValue(0.3);
         questionContent.setId("text-field");
         questionContent.getStylesheets().addAll(this.getClass().getResource("css/style.css").toExternalForm());

         questionContent.prefWidthProperty().bind(primaryStage.widthProperty());
         ToggleGroup tGroup = new ToggleGroup();
         RadioButton r1 = RadioButtonBuilder.create().toggleGroup(tGroup).text("sdfsfd").build();
         RadioButton r2 = RadioButtonBuilder.create().toggleGroup(tGroup).text("2sfsdsdfsd").build();
         RadioButton r3 = RadioButtonBuilder.create().toggleGroup(tGroup).text("3sfsfsdf").build();
         RadioButton r4 = RadioButtonBuilder.create().toggleGroup(tGroup).text("4sfsd").build();

        
         Button submit = new Button("Submit");
        
         //coulmm - row

         GridPane.setHalignment(question, HPos.LEFT);
         gridPane.add(question, 0, 0);

         GridPane.setHalignment(questionContent, HPos.RIGHT);
         gridPane.add(questionContent, 1, 0);
        
         GridPane.setHalignment(r1, HPos.LEFT);
         gridPane.add(r1, 0, 1);
        
         GridPane.setHalignment(r2, HPos.RIGHT);
         gridPane.add(r2, 1, 1);
        
        
         GridPane.setHalignment(r3, HPos.LEFT);
         gridPane.add(r3, 0, 2);
        
        
         GridPane.setHalignment(r4, HPos.RIGHT);
         gridPane.add(r4, 1, 2);

         Button btn = new Button();
         btn.setText("Say 'Hello World'");
         btn.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
         Stage dialogStage = new Stage(StageStyle.UTILITY);
         dialogStage.initModality(Modality.APPLICATION_MODAL);
         Group root = new Group();

         root.getChildren().add(VBoxBuilder.create().
         children(new Text("Hi"), new Button("Ok.")).
         alignment(Pos.CENTER).padding(new Insets(5)).build());
         dialogStage.setScene(new Scene(root, 500, 500));
         dialogStage.initOwner(primaryStage);
         dialogStage.show();

         //System.out.println(dialogStage.getOwner() == primaryStage.getOwner());
         }
         });

         StackPane root = new StackPane();
         StackPane.setMargin(gridPane, new Insets(8,8,8,8));
         root.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
         root.getChildren().add(gridPane);

         Rectangle2D r = Screen.getPrimary().getBounds();
         Scene scene = new Scene(root, r.getWidth(), r.getHeight());
         root.setId("pane");
         scene.getStylesheets().addAll(this.getClass().getResource("css/style.css").toExternalForm());
         scene.setOnKeyReleased(new EventHandler< javafx.scene.input.KeyEvent>() {
         @Override
         public void handle(javafx.scene.input.KeyEvent t) {
         if (t.getCode() == KeyCode.ESCAPE) {
         primaryStage.close();
         }
         }
         });*/

        ScreenController screenController = new ScreenController();
        screenController.loadScreen("mainView", "MainViewFXML.fxml");


        screenController.setScreen("mainView");


        StackPane root = new StackPane();
        root.getChildren().addAll(screenController);

        
        Rectangle2D r = Screen.getPrimary().getBounds();
        Scene scene = new Scene(root, r.getWidth(), r.getHeight());
        screenController.setMaxSize( r.getWidth(), r.getHeight());
        screenController.setMinSize(r.getWidth(), r.getHeight());
        //root.setId("pane");
        //scene.getStylesheets().addAll(this.getClass().getResource("css/style.css").toExternalForm());
        scene.setOnKeyReleased(new EventHandler< javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent t) {
                if (t.getCode() == KeyCode.ESCAPE) {
                    primaryStage.close();
                }
            }
        });
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
