package richtexteditor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
 
public class FameDenHTMLEditor extends Application {    
    private final String INITIAL_TEXT = "Enter you Text Here";
 
    @Override
    public void start(Stage stage) {
        stage.setTitle("FameDenHTMLEditor");
        stage.setWidth(500);
        stage.setHeight(500);
        Scene scene = new Scene(new Group());
    
        VBox root = new VBox();      
        root.setPadding(new Insets(8, 8, 8, 8));
        root.setSpacing(5);
        root.setAlignment(Pos.BOTTOM_LEFT);
              
        final HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(245);
        htmlEditor.setHtmlText(INITIAL_TEXT);       
 
        final TextArea htmlCode = new TextArea();
        htmlCode.setWrapText(true);
    
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.getStyleClass().add("noborder-scroll-pane");
        scrollPane.setContent(htmlCode);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(180);
 
        Button showHTMLButton = new Button("Produce HTML Code");
        root.setAlignment(Pos.CENTER);
        showHTMLButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent arg0) {
                htmlCode.setText(htmlEditor.getHtmlText());
            }
        });
        
        root.getChildren().addAll(htmlEditor, showHTMLButton, scrollPane);
        scene.setRoot(root);
 
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}