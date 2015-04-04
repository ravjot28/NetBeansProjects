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
public class AddressDetails implements Serializable{
    
    private StringProperty address = new SimpleStringProperty();
    private StringProperty city = new SimpleStringProperty();
    private StringProperty state = new SimpleStringProperty();
    private StringProperty pinCode = new SimpleStringProperty();

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String first) {
        this.address.set(first);
    }
    
    public StringProperty addressProperty() {
        return address;
    }
    
    public String getCity() {
        return city.get();
    }

    public void setCity(String first) {
        this.city.set(first);
    }
    
    public StringProperty cityProperty() {
        return city;
    }
    
    public String getState() {
        return state.get();
    }

    public void setState(String first) {
        this.state.set(first);
    }
    
    public StringProperty stateProperty() {
        return state;
    }
    
    public String getPinCode() {
        return pinCode.get();
    }

    public void setPinCode(String first) {
        this.pinCode.set(first);
    }
    
    public StringProperty pinCodeProperty() {
        return pinCode;
    }
}
