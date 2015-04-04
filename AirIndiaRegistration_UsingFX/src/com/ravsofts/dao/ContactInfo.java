/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.dao;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ravjot
 */
public class ContactInfo implements Serializable{
    
    private StringProperty telephoneNo = new SimpleStringProperty();
    private StringProperty mobileNo = new SimpleStringProperty();
    private StringProperty emailAddress = new SimpleStringProperty();

    public String getTelephoneNo() {
        return telephoneNo.get();
    }

    public void setTelephoneNo(String first) {
        this.telephoneNo.set(first);
    }
    
    public StringProperty telephoneNoProperty() {
        return telephoneNo;
    }
    
    public String getMobileNo() {
        return mobileNo.get();
    }

    public void setMobileNo(String first) {
        this.mobileNo.set(first);
    }
    
    public StringProperty mobileNoProperty() {
        return mobileNo;
    }
    
    public String getEmailAddress() {
        return emailAddress.get();
    }

    public void setEmailAddress(String first) {
        this.emailAddress.set(first);
    }
    
    public StringProperty emailAddressProperty() {
        return emailAddress;
    }
}
