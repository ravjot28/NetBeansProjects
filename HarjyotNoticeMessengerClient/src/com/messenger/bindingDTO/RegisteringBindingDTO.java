/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.bindingDTO;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author puneet
 */
public class RegisteringBindingDTO implements Serializable {

    private StringProperty emailID = new SimpleStringProperty();
    private StringProperty fullName = new SimpleStringProperty();
    private StringProperty enrollNo = new SimpleStringProperty();
    private StringProperty year = new SimpleStringProperty();
    private StringProperty branch = new SimpleStringProperty();

    /**
     * @return the emailID
     */
    public String getEmailID() {
        return (String) this.emailID.get();
    }

    /**
     * @param emailID the emailID to set
     */
    public void setEmailID(String emailID) {
        this.emailID.set(emailID);
    }

    public StringProperty emailProperty() {
        return this.emailID;
    }

    /**
     * @return the userName
     */
    public String getFullName() {
        return (String) this.fullName.get();
    }

    /**
     * @param userName the userName to set
     */
    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public StringProperty fullNameProperty() {
        return this.fullName;
    }

    /**
     * @return the userName
     */
    public String getEnrollNo() {
        return (String) this.enrollNo.get();
    }

    /**
     * @param userName the userName to set
     */
    public void setEnrollNo(String enrollNo) {
        this.enrollNo.set(enrollNo);
    }

    public StringProperty enrollNoProperty() {
        return this.enrollNo;
    }

    /**
     * @return the userName
     */
    public String getYear() {
        return (String) this.year.get();
    }

    /**
     * @param userName the userName to set
     */
    public void setYear(String year) {
        this.year.set(year);
    }

    public StringProperty yearProperty() {
        return this.year;
    }

    /**
     * @return the userName
     */
    public String getBranch() {
        return (String) this.branch.get();
    }

    /**
     * @param userName the userName to set
     */
    public void setBranch(String branch) {
        this.branch.set(branch);
    }

    public StringProperty branchProperty() {
        return this.branch;
    }
}
