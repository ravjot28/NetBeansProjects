/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.dao;

import java.io.Serializable;
import java.util.Calendar;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ravjot
 */
public class EmployeeDetails implements Serializable{

    private StringProperty fullName = new SimpleStringProperty();
    private StringProperty staffNo = new SimpleStringProperty();
    private Calendar dateOfBirth;

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String first) {
        this.fullName.set(first);
    }
    
    public StringProperty fullNameProperty() {
        return fullName;
    }
    
     public String getStaffNo() {
        return staffNo.get();
    }

    public void setStaffNo(String first) {
        this.staffNo.set(first);
    }
    
    public StringProperty staffNoProperty() {
        return staffNo;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
