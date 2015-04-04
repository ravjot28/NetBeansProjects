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
@Table(name = "insuraceDetail")
public class InsuranceDetail implements Serializable {

    @Id
    @GeneratedValue(generator = "insuranceDetailId_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, initialValue = 101, sequenceName = "insuranceDetailId_seq", name = "insuranceDetailId_seq")
    private int insuranceDetailId;
    private String brManager;
    private int staffId;
    private String brAss;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="insuranceId")
    private Insurance insurance;

    public String getBrAss() {
        return brAss;
    }

    public void setBrAss(String brAss) {
        this.brAss = brAss;
    }

    public String getBrManager() {
        return brManager;
    }

    public void setBrManager(String brManager) {
        this.brManager = brManager;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public int getInsuranceDetailId() {
        return insuranceDetailId;
    }

    public void setInsuranceDetailId(int insuranceDetailId) {
        this.insuranceDetailId = insuranceDetailId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
}
