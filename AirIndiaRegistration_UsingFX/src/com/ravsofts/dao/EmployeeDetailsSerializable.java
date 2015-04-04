/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.dao;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Ravjot
 */
public class EmployeeDetailsSerializable implements Serializable{
    
    private String fullName;
    private String staffNo ;
    private Calendar dateOfBirth;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }    
}
