package com.rvp.dto;

import java.sql.Date;

public class InsuranceDTO extends CustomerInfoDTO {

    private String paymentMode;
    private String policyTerm;
    private String payTerm;
    private float policyAmt;
    private float premiumAmt;
    private float serviceTax;
    private Date premCheqDate;
    private float premCheqAmt;
    private String premCheqNum;
    private String micrNo;
    private String bankName;
    private String bankBranch;
    private String existPolicyNo;
    private StaffDetailsDTO staffDetails;
    private int userId;
    private String ecsGiven;
    private String companyName;
    private String schemeName;
    private String phNumber;
    private String ackNo;
    private Date ackDate;
    private String appNo;
    private String branchName;

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getExistPolicyNo() {
        return existPolicyNo;
    }

    public void setExistPolicyNo(String existPolicyNo) {
        this.existPolicyNo = existPolicyNo;
    }

    public String getMicrNo() {
        return micrNo;
    }

    public void setMicrNo(String micrNo) {
        this.micrNo = micrNo;
    }

    public String getPayTerm() {
        return payTerm;
    }

    public void setPayTerm(String payTerm) {
        this.payTerm = payTerm;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public float getPolicyAmt() {
        return policyAmt;
    }

    public void setPolicyAmt(float policyAmt) {
        this.policyAmt = policyAmt;
    }

    public String getPolicyTerm() {
        return policyTerm;
    }

    public void setPolicyTerm(String policyTerm) {
        this.policyTerm = policyTerm;
    }

    public float getPremCheqAmt() {
        return premCheqAmt;
    }

    public void setPremCheqAmt(float premCheqAmt) {
        this.premCheqAmt = premCheqAmt;
    }

    public Date getPremCheqDate() {
        return premCheqDate;
    }

    public void setPremCheqDate(Date premCheqDate) {
        this.premCheqDate = premCheqDate;
    }

    public String getPremCheqNum() {
        return premCheqNum;
    }

    public void setPremCheqNum(String premCheqNum) {
        this.premCheqNum = premCheqNum;
    }

    public float getPremiumAmt() {
        return premiumAmt;
    }

    public void setPremiumAmt(float premiumAmt) {
        this.premiumAmt = premiumAmt;
    }

    public float getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(float serviceTax) {
        this.serviceTax = serviceTax;
    }

    public StaffDetailsDTO getStaffDetails() {
        return staffDetails;
    }

    public void setStaffDetails(StaffDetailsDTO staffDetails) {
        this.staffDetails = staffDetails;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEcsGiven() {
        return ecsGiven;
    }

    public void setEcsGiven(String ecsGiven) {
        this.ecsGiven = ecsGiven;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

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

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
