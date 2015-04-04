/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rvp.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Rav
 */

@Entity
@Table(name = "mutualFundApplicationDetails")
public class MutualFundApplicationDetails implements Serializable {

    @Id
    @GeneratedValue(generator = "mfApplicationId_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, initialValue = 101, sequenceName = "mfApplicationId_seq", name = "mfApplicationId_seq")
    private int mfApplicationId;
    private float amount;
    private int customerDetailsId;
    private String micrNo;
    private String subBrokerCode;
    private int customerId;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="mfDetailId")
    private MutualFundDetail mfDetail;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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

    public int getMfApplicationId() {
        return mfApplicationId;
    }

    public void setMfApplicationId(int mfApplicationId) {
        this.mfApplicationId = mfApplicationId;
    }

    public MutualFundDetail getMfDetail() {
        return mfDetail;
    }

    public void setMfDetail(MutualFundDetail mfDetail) {
        this.mfDetail = mfDetail;
    }

    public String getMicrNo() {
        return micrNo;
    }

    public void setMicrNo(String micrNo) {
        this.micrNo = micrNo;
    }

    public String getSubBrokerCode() {
        return subBrokerCode;
    }

    public void setSubBrokerCode(String subBrokerCode) {
        this.subBrokerCode = subBrokerCode;
    }
}
