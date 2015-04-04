/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rvp.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Description: This entity class contains details
 *              of the branches.
 * @author Rav
 */
@Entity
@Table(name = "branches")
public class Branches implements Serializable {

    @Id
    @GeneratedValue(generator = "branchId_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, initialValue = 101, sequenceName = "branchId_seq", name = "branchId_seq")
    private int branchId;
    private String branchName;
    private String branchZoneCode;
    private String branchBdmCode;
    private char active;

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }

    public String getBranchBdmCode() {
        return branchBdmCode;
    }

    public void setBranchBdmCode(String branchBdmCode) {
        this.branchBdmCode = branchBdmCode;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchZoneCode() {
        return branchZoneCode;
    }

    public void setBranchZoneCode(String branchZoneCode) {
        this.branchZoneCode = branchZoneCode;
    }  
}
