/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rvp.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Rav
 */

@Entity
@Table(name = "customer_details")
public class CustomerDetails implements Serializable {

    @Id
    @Column(name="customerDetailsId")
    @GeneratedValue(generator = "customerDetailsId_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, initialValue = 101, sequenceName = "customerDetailsId_seq", name = "customerDetailsId_seq")
    private int customerDetailsId;
    //Remeber to add the customerId present in the Customer table
    private int customerId;
    private String customerChequeNumber;
    private Date customerChequeDate;
    private String customerBankName;
    private String customerBankBranch;
    private String customerPanNo;
    private String customerIdProof;
    private String customerIncomeProof;
    private String customerAgeProof;
    private String customerAddressProof;

    public String getCustomerAddressProof() {
        return customerAddressProof;
    }

    public void setCustomerAddressProof(String customerAddressProof) {
        this.customerAddressProof = customerAddressProof;
    }

    public String getCustomerAgeProof() {
        return customerAgeProof;
    }

    public void setCustomerAgeProof(String customerAgeProof) {
        this.customerAgeProof = customerAgeProof;
    }

    public String getCustomerBankBranch() {
        return customerBankBranch;
    }

    public void setCustomerBankBranch(String customerBankBranch) {
        this.customerBankBranch = customerBankBranch;
    }

    public String getCustomerBankName() {
        return customerBankName;
    }

    public void setCustomerBankName(String customerBankName) {
        this.customerBankName = customerBankName;
    }

    public Date getCustomerChequeDate() {
        return customerChequeDate;
    }

    public void setCustomerChequeDate(Date customerChequeDate) {
        this.customerChequeDate = customerChequeDate;
    }

    public String getCustomerChequeNumber() {
        return customerChequeNumber;
    }

    public void setCustomerChequeNumber(String customerChequeNumber) {
        this.customerChequeNumber = customerChequeNumber;
    }

    public int getCustomerDetailsId() {
        return customerDetailsId;
    }

    public void setCustomerDetailsId(int customerDetailsId) {
        this.customerDetailsId = customerDetailsId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerIdProof() {
        return customerIdProof;
    }

    public void setCustomerIdProof(String customerIdProof) {
        this.customerIdProof = customerIdProof;
    }

    public String getCustomerIncomeProof() {
        return customerIncomeProof;
    }

    public void setCustomerIncomeProof(String customerIncomeProof) {
        this.customerIncomeProof = customerIncomeProof;
    }

    public String getCustomerPanNo() {
        return customerPanNo;
    }

    public void setCustomerPanNo(String customerPanNo) {
        this.customerPanNo = customerPanNo;
    }
}
