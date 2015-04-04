/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ravjotsingh
 */
public class LoginRegistrationBinding {

    private StringProperty loginEmailAddress;

    private StringProperty loginPassword;

    private StringProperty registrationPassword;

    private StringProperty registrationRePassword;

    private StringProperty registrationEmailAddress;

    private StringProperty registrationFullName;

    private StringProperty forgotPasswordEmailAddress;

    private StringProperty forgotPasswordPassword;

    private StringProperty forgotPasswordRePassword;
    
    private StringProperty forgotPasswordPassCode;

    public LoginRegistrationBinding() {
        loginPassword = new SimpleStringProperty();
        loginEmailAddress = new SimpleStringProperty();
        registrationPassword = new SimpleStringProperty();
        registrationEmailAddress = new SimpleStringProperty();
        registrationRePassword = new SimpleStringProperty();
        registrationFullName = new SimpleStringProperty();
        forgotPasswordEmailAddress = new SimpleStringProperty();
        forgotPasswordPassword = new SimpleStringProperty();
        forgotPasswordRePassword = new SimpleStringProperty();
        forgotPasswordPassCode = new SimpleStringProperty();
    }
    
    public String getLoginEmailAddress() {
        return (String) this.loginEmailAddress.get();
    }
    
    public void setLoginEmailAddress(String emailAddress) {
        this.loginEmailAddress.set(emailAddress);
    }

    public StringProperty loginEmailAddressProperty() {
        return this.loginEmailAddress;
    }
    
    public String getLoginPassword() {
        return (String) this.loginPassword.get();
    }
    
    public void setLoginPassword(String password) {
        this.loginPassword.set(password);
    }

    public StringProperty loginPasswordProperty() {
        return this.loginPassword;
    }

    public String getRegistrationFullName() {
        return (String) this.registrationFullName.get();
    }
    
    public void setRegistrationFullName(String fullName) {
        this.registrationFullName.set(fullName);
    }

    public StringProperty registrationFullNameProperty() {
        return this.registrationFullName;
    }

    public String getRegistrationEmailAddress() {
        return (String) this.registrationEmailAddress.get();
    }
    
    public void setRegistrationEmailAddress(String emailAddress) {
        this.registrationEmailAddress.set(emailAddress);
    }

    public StringProperty registrationEmailAddressProperty() {
        return this.registrationEmailAddress;
    }

    public String getRegistrationRePassword() {
        return (String) this.registrationRePassword.get();
    }
    
    public void setRegistrationRePassword(String password) {
        this.registrationRePassword.set(password);
    }

    public StringProperty registrationRePasswordProperty() {
        return this.registrationRePassword;
    }

    public String getRegistrationPassword() {
        return (String) this.registrationPassword.get();
    }
    
    public void setRegistrationPassword(String password) {
        this.registrationPassword.set(password);
    }

    public StringProperty registrationPasswordProperty() {
        return this.registrationPassword;
    }

    public String getForgotPasswordEmailAddress() {
        return (String) this.forgotPasswordEmailAddress.get();
    }

    public void setForgotPasswordEmailAddress(String emailAddress) {
        this.forgotPasswordEmailAddress.set(emailAddress);
    }

    public StringProperty forgotPasswordEmailAddressProperty() {
        return this.forgotPasswordEmailAddress;
    }

    public String getForgotPasswordPassword() {
        return (String) this.forgotPasswordPassword.get();
    }

    public void setForgotPasswordPassword(String password) {
        this.forgotPasswordPassword.set(password);
    }

    public StringProperty forgotPasswordPasswordProperty() {
        return this.forgotPasswordPassword;
    }

    public String getForgotPasswordRePassword() {
        return (String) this.forgotPasswordRePassword.get();
    }

    public void setForgotPasswordRePassword(String password) {
        this.forgotPasswordRePassword.set(password);
    }

    public StringProperty forgotPasswordRePasswordProperty() {
        return this.forgotPasswordRePassword;
    }
    
    public String getForgotPasswordPassCode() {
        return (String) this.forgotPasswordPassCode.get();
    }

    public void setForgotPasswordPassCode(String code) {
        this.forgotPasswordPassCode.set(code);
    }

    public StringProperty forgotPasswordPassCodeProperty() {
        return this.forgotPasswordPassCode;
    }

}
