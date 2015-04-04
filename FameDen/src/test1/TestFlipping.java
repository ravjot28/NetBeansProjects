/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Ravjot
 */
public class TestFlipping extends Application{
    FlippingPanel a = null;
     @Override
    public void start(Stage stage) throws Exception {
         a =new FlippingPanel(a,a);
         
         Button b = new Button("Press ME");
         a.getChildren().add(b);
        
         b.setOnAction(loginClienteHandler());
         
        //root.autosize();
        
         Scene scene = new Scene(a);
        //scene.getStylesheets().add(GlobalConstants.calendarCSSPath);
        
        stage.initStyle(StageStyle.UNDECORATED);
        //stage.sizeToScene();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Flipping");
        //stage.getIcons().add(new Image(GlobalConstants.registrationSceneIconImageLocation));
        stage.show();
    }
     
     public EventHandler loginClienteHandler() {
        EventHandler evh = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                a.flip();
            }
        };
        return evh;
    }

    public static void main(String[] args) {
        launch();
    }
}
