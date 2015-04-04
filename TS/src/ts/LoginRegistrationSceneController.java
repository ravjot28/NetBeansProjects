/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ravjotsingh
 */
public class LoginRegistrationSceneController implements Initializable, IScreenController {

    private SceneNavigator myController;

    @FXML
    TextField loginEmailAddressTextField;
    @FXML
    PasswordField loginPasswordField;
    @FXML
    TextField registrationFullNameField;
    @FXML
    TextField registrationEmailAddressField;
    @FXML
    PasswordField registratonPasswordField;
    @FXML
    PasswordField registrationRePasswordField;
    @FXML
    BorderPane registrationPane;
    @FXML
    BorderPane forgotPasswordPane;
    @FXML
    BorderPane resetPasswordPane;
    @FXML
    TextField forgotPasswordEmailAddressField;
    @FXML
    TextField forgotPasswordPassCodeField;
    @FXML
    PasswordField forgotPasswordPasswordField;
    @FXML
    PasswordField forgotPasswordRePasswordField;

    private Stage stage;

    private LoginRegistrationBinding loginRegistrationBinding = new LoginRegistrationBinding();

    private String requestType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Bindings.bindBidirectional(loginEmailAddressTextField.textProperty(), loginRegistrationBinding.loginEmailAddressProperty());
        Bindings.bindBidirectional(loginPasswordField.textProperty(), loginRegistrationBinding.loginPasswordProperty());

        Bindings.bindBidirectional(registrationFullNameField.textProperty(), loginRegistrationBinding.registrationFullNameProperty());
        Bindings.bindBidirectional(registrationEmailAddressField.textProperty(), loginRegistrationBinding.registrationEmailAddressProperty());
        Bindings.bindBidirectional(registratonPasswordField.textProperty(), loginRegistrationBinding.registrationPasswordProperty());
        Bindings.bindBidirectional(registrationRePasswordField.textProperty(), loginRegistrationBinding.registrationRePasswordProperty());

        Bindings.bindBidirectional(forgotPasswordEmailAddressField.textProperty(), loginRegistrationBinding.forgotPasswordEmailAddressProperty());
        Bindings.bindBidirectional(forgotPasswordPassCodeField.textProperty(), loginRegistrationBinding.forgotPasswordPassCodeProperty());
        Bindings.bindBidirectional(forgotPasswordPasswordField.textProperty(), loginRegistrationBinding.forgotPasswordPasswordProperty());
        Bindings.bindBidirectional(forgotPasswordRePasswordField.textProperty(), loginRegistrationBinding.forgotPasswordRePasswordProperty());

        resetPasswordPane.setVisible(false);
        forgotPasswordPane.setVisible(false);
        registrationPane.setVisible(true);
    }

    @Override
    public void setScreenParent(SceneNavigator screenPage) {
        this.myController = screenPage;
    }

    @FXML
    public void loginUser() {
        forgotPasswordEmailAddressField.setText(null);
        forgotPasswordPassCodeField.setText(null);
        forgotPasswordPasswordField.setText(null);
        forgotPasswordRePasswordField.setText(null);
        registrationFullNameField.setText(null);
        registrationEmailAddressField.setText(null);
        registratonPasswordField.setText(null);
        registrationRePasswordField.setText(null);
        System.out.println(loginRegistrationBinding.getLoginEmailAddress());
        System.out.println(loginRegistrationBinding.getLoginPassword());
        try {
            boolean isValid = validateRequest();
            if (isValid) {
                
                Task task = new Task<Void>() {
                    @Override
                    public Void call() {
                        try {
                            
                        } catch (Exception ex) {
                            genericError("","");
                        }
                        return null;
                    }
                };
                new Thread(task).start();
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginRegistrationSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void registerUser() {
        loginEmailAddressTextField.setText(null);
        loginPasswordField.setText(null);
        forgotPasswordEmailAddressField.setText(null);
        forgotPasswordPassCodeField.setText(null);
        forgotPasswordPasswordField.setText(null);
        forgotPasswordRePasswordField.setText(null);
        System.out.println(loginRegistrationBinding.getRegistrationEmailAddress());
        System.out.println(loginRegistrationBinding.getRegistrationFullName());
        System.out.println(loginRegistrationBinding.getRegistrationPassword());
        System.out.println(loginRegistrationBinding.getRegistrationRePassword());
        try {
            boolean isValid = validateRequest();
            if (isValid) {
                Task task = new Task<Void>() {
                    @Override
                    public Void call() {
                        try {
                            

                        } catch (Exception ex) {
                            genericError("","");
                        }
                        return null;
                    }
                };
                new Thread(task).start();

            }
        } catch (Exception ex) {
            Logger.getLogger(LoginRegistrationSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void success(final String title, final String message) {
        Platform.runLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    public void successMoveToResetPassword() {
        moveToResetPassword();
    }

    @Override
    public void error(final String title, final String message) {
        Platform.runLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    @Override
    public void genericError(final String title, final String message) {
        Platform.runLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    @FXML
    public void goToForgotPassword() {
        resetPasswordPane.setVisible(false);
        forgotPasswordPane.setVisible(true);
        registrationPane.setVisible(false);
    }

    @FXML
    public void forgotPassword() {
          
            
        
    }

    public void moveToResetPassword() {
        resetPasswordPane.setVisible(true);
        forgotPasswordPane.setVisible(false);
        registrationPane.setVisible(false);
    }

    @FXML
    public void resetPassword() {
        
    }

    @FXML
    public void viewTermsAndConditions() {
        stage = new Stage();
        Group root = new Group();
        root.getChildren().addAll(myController.getNodeScreen("tncTextViewerScreen"));
        root.autosize();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Terms And Conditions");
        //stage.getIcons().add(new Image(GlobalConstants.stageIconImageLocation));
        stage.centerOnScreen();
        stage.setFocused(true);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    public void viewAboutUs() {
        stage = new Stage();
        Group root = new Group();
        root.getChildren().addAll(myController.getNodeScreen("aboutusTextViewerScreen"));
        root.autosize();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("About Us");
        //stage.getIcons().add(new Image(GlobalConstants.stageIconImageLocation));
        stage.centerOnScreen();
        stage.setFocused(true);
        stage.show();
    }

    @FXML
    public void returnToSignUp() {
        loginEmailAddressTextField.setText(null);
        loginPasswordField.setText(null);
        registrationFullNameField.setText(null);
        registrationEmailAddressField.setText(null);
        registratonPasswordField.setText(null);
        registrationRePasswordField.setText(null);
        forgotPasswordEmailAddressField.setText(null);
        forgotPasswordPassCodeField.setText(null);
        forgotPasswordPasswordField.setText(null);
        forgotPasswordRePasswordField.setText(null);
        resetPasswordPane.setVisible(false);
        forgotPasswordPane.setVisible(false);
        registrationPane.setVisible(true);
    }

    @Override
    public Object populateDTO() {
        return null;
    }

    @Override
    public boolean validateRequest() throws Exception {
        return false;
    }
}
