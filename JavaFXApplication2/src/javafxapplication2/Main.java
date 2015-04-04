/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ravjotsingh
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("LoginPageFXML.fxml"));
            Parent loadScreen = (Parent) myLoader.load();
            
            
            Scene scene = new Scene(loadScreen);        
        
        stage.initStyle(StageStyle.UNDECORATED);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
    
    public static void main(String as[]){
        launch(as);
    }
    
}
