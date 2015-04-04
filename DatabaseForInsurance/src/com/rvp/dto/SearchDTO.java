/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rvp.dto;

import java.util.List;

/**
 *
 * @author Rav
 */
public class SearchDTO {

    private String dob;
    private String ackDateTo;
    private String ackDateFrom;
    private String ackNo;
    private String appNo;
    private String policyNo;
    private String depositorName;
    private String checkNo;
    private String emailId;
    private List<InsuranceDTO> dto;

    public String getAckDateFrom() {
        return ackDateFrom;
    }

    public void setAckDateFrom(String ackDateFrom) {
        this.ackDateFrom = ackDateFrom;
    }

    public String getAckDateTo() {
        return ackDateTo;
    }

    public void setAckDateTo(String ackDateTo) {
        this.ackDateTo = ackDateTo;
    }

    public List<InsuranceDTO> getDto() {
        return dto;
    }

    public void setDto(List<InsuranceDTO> dto) {
        this.dto = dto;
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

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getDepositorName() {
        return depositorName;
    }

    public void setDepositorName(String depositorName) {
        this.depositorName = depositorName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
}
