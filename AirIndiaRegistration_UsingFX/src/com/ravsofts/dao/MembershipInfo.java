/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ravjot
 */
public class MembershipInfo implements Serializable{
    
    private AddressDetailsSerializable addressDetails;
    private ContactDetailsSerializable contactInfo;
    private EmployeeDetailsSerializable employeeDetails;
    private List<NomineeDetails> nomineeDetails;

    public AddressDetailsSerializable getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDetailsSerializable addressDetails) {
        this.addressDetails = addressDetails;
    }

    public ContactDetailsSerializable getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactDetailsSerializable contactInfo) {
        this.contactInfo = contactInfo;
    }

    public EmployeeDetailsSerializable getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetailsSerializable employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public List<NomineeDetails> getNomineeDetails() {
        return nomineeDetails;
    }

    public void setNomineeDetails(List<NomineeDetails> nomineeDetails) {
        this.nomineeDetails = nomineeDetails;
    }
}
