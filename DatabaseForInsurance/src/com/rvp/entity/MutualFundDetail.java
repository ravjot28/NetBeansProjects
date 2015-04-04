/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rvp.entity;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "mutualFundDetail")
public class MutualFundDetail implements Serializable {

    @Id
    @GeneratedValue(generator = "mfDetailId_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, initialValue = 101, sequenceName = "mfDetailId_seq", name = "mfDetailId_seq")
    private int mfDetailId;
    private String ackNo;
    private Date ackDate;
    private String product;
    private String type;
    private int productDetailId;
    private String sip;
    private char directSubmit;
    private String ecsType;
    private Date sipFrom;
    private Date sipTo;
    private float sipAmount;
    private String brMngr;
    private int staffId;
    private int brAss;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="mfId")
    private MutualFund mf;

    public Date getAckDate() {
        return ackDate;
    }

    public void setAckDate(Date ackDate) {
        this.ackDate = ackDate;
    }

    public String getAckNo() {
        return ackNo;
    }

    public void setAckNo(String ackNo) {
        this.ackNo = ackNo;
    }

    public int getBrAss() {
        return brAss;
    }

    public void setBrAss(int brAss) {
        this.brAss = brAss;
    }

    public String getBrMngr() {
        return brMngr;
    }

    public void setBrMngr(String brMngr) {
        this.brMngr = brMngr;
    }

    public char getDirectSubmit() {
        return directSubmit;
    }

    public void setDirectSubmit(char directSubmit) {
        this.directSubmit = directSubmit;
    }

    public String getEcsType() {
        return ecsType;
    }

    public void setEcsType(String ecsType) {
        this.ecsType = ecsType;
    }

    public int getMfDetailId() {
        return mfDetailId;
    }

    public void setMfDetailId(int mfDetailId) {
        this.mfDetailId = mfDetailId;
    }

    public MutualFund getMfId() {
        return mf;
    }

    public void setMfId(MutualFund mf) {
        this.mf = mf;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public float getSipAmount() {
        return sipAmount;
    }

    public void setSipAmount(float sipAmount) {
        this.sipAmount = sipAmount;
    }

    public Date getSipFrom() {
        return sipFrom;
    }

    public void setSipFrom(Date sipFrom) {
        this.sipFrom = sipFrom;
    }

    public Date getSipTo() {
        return sipTo;
    }

    public void setSipTo(Date sipTo) {
        this.sipTo = sipTo;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
