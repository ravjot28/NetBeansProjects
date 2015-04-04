/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.dao;

import java.io.Serializable;

/**
 *
 * @author Ravjot
 */
public class NomineeDetails implements Serializable{
    
    private String fullName;
    private String relativeInfo;
    private String age;
    private String relative;
    private String proofs;
    private String identificationProofs;
    private String related;
    private String percentage;
    private String address;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRelativeInfo() {
        return relativeInfo;
    }

    public void setRelativeInfo(String relativeInfo) {
        this.relativeInfo = relativeInfo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRelative() {
        return relative;
    }

    public void setRelative(String relative) {
        this.relative = relative;
    }

    public String getProofs() {
        return proofs;
    }

    public void setProofs(String proofs) {
        this.proofs = proofs;
    }

    public String getIdentificationProofs() {
        return identificationProofs;
    }

    public void setIdentificationProofs(String identificationProofs) {
        this.identificationProofs = identificationProofs;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
