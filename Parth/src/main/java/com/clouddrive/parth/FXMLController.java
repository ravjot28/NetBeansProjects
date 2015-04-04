package com.clouddrive.parth;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FXMLController implements Initializable {

    FileChooser fileChooser = new FileChooser();
    private String value = "";

    private String value1 = "";
    @FXML
    private Label label;
    
    @FXML
    private TextField file;
    
    @FXML
    private TextField jar;
    
    @FXML
    private TextField noOfinstance;
    
    @FXML
    private TextField instanceType;
    

    @FXML
    private void browse(ActionEvent event) {
        File file = fileChooser.showOpenDialog(label.getScene().getWindow());
        if (file != null) {
            //openFile(file);
            System.out.println(file.getAbsoluteFile());
            value = file.getAbsolutePath();
            this.file.setText(value);
        }
    }

    @FXML
    private void browse1(ActionEvent event) {
        File file = fileChooser.showOpenDialog(label.getScene().getWindow());
        if (file != null) {
            //openFile(file);
            System.out.println(file.getAbsoluteFile());
            value1 = file.getAbsolutePath();
            jar.setText(value1);
        }
    }

    @FXML
    private void submit(ActionEvent event) {
        Task task = new Task<Void>() {
            @Override
            public Void call() {
                try {
                    InputStream is = new ByteArrayInputStream(
                            ByteToArray.getByteFromFile(new File(
                                            value)));
                    AmazonOperations a = new AmazonOperations();

                    a.uploadFile(is, "input_twoval", "parthfinance");
                    is = new ByteArrayInputStream(ByteToArray.getByteFromFile(new File(value1)));
                    a.uploadFile(is, "MapReduce-0.0.1-SNAPSHOT.jar", "parthfinance");
                    try {
                        NewClass n = new NewClass();
                        n.init(instanceType.getText(),noOfinstance.getText());
                        String temp = n.runCluster();
                        byte[] t = a.downloadFile(temp + "/part-r-00000", "parthfinance");
                        ByteToArray.writeByteArray("output.txt", t);
                        message("Success", "Buy");
                    } catch (Exception e) {
                        e.printStackTrace();
                        message("Success", "Sell");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    message("Success", "Sell");
                }
                return null;
            }
        };
        new Thread(task).start();

    }

    public void message(final String title, final String message) {
        Platform.runLater(new Runnable() {
            public void run() {
                final Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                Button b = new Button("Ok.");
                b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        dialogStage.hide();
                    }
                });
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text(message), b).
                        alignment(Pos.CENTER).padding(new Insets(5)).build()));
                dialogStage.show();
                Platform.setImplicitExit(false);

                dialogStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        event.consume();
                    }
                });

//Dialogs.showErrorDialog(null, null, message, "Error");
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        value = "";
    }
}
