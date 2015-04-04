/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.dao;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ravjot
 */
public class Nominee3Details {

    private StringProperty fullName = new SimpleStringProperty();
    private StringProperty relativeInfo = new SimpleStringProperty();
    private StringProperty age = new SimpleStringProperty();
    private StringProperty relative = new SimpleStringProperty();
    private StringProperty proofs = new SimpleStringProperty();
    private StringProperty identificationProofs = new SimpleStringProperty();
    private StringProperty related = new SimpleStringProperty();
    private StringProperty percentage = new SimpleStringProperty();
    private StringProperty address = new SimpleStringProperty();
    
    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }
    
    public StringProperty fullNameProperty() {
        return fullName;
    }
    
    public String getFullName() {
        return fullName.get();
    }
    
    public void setRelativeInfo(String relativeInfo) {
        this.relativeInfo.set(relativeInfo);
    }
    
    public StringProperty relativeInfoProperty() {
        return relativeInfo;
    }
    
    public String getRelativeInfo() {
        return relativeInfo.get();
    }
    
    public void setAge(String age) {
        this.age.set(age);
    }
    
    public StringProperty ageProperty() {
        return age;
    }
    
    public String getAge() {
        return age.get();
    }
    
    public void setRelative(String relative) {
        this.relative.set(relative);
    }
    
    public StringProperty relativeProperty() {
        return relative;
    }
    
    public String getRelative() {
        return relative.get();
    }
    
    public void setProofs(String proofs) {
        this.proofs.set(proofs);
    }
    
    public StringProperty proofsProperty() {
        return proofs;
    }
    
    public String getProofs() {
        return proofs.get();
    }
    
    public void setIdentificationProofs(String identificationProofs) {
        this.relativeInfo.set(identificationProofs);
    }
    
    public StringProperty identificationProofsProperty() {
        return identificationProofs;
    }
    
    public String getIdentificationProofs() {
        return identificationProofs.get();
    }
    
    public void setRelated(String related) {
        this.related.set(related);
    }
    
    public StringProperty relatedProperty() {
        return related;
    }
    
    public String getRelated() {
        return related.get();
    }
    
    public void setPercentage(String percentage) {
        this.percentage.set(percentage);
    }
    
    public StringProperty percentageProperty() {
        return percentage;
    }
    
    public String getPercentage() {
        return percentage.get();
    }
    
    public void setAddress(String address) {
        this.address.set(address);
    }
    
    public StringProperty addressProperty() {
        return address;
    }
    
    public String getAddress() {
        return address.get();
    }
}
