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
 *Description: This entity class contains details
 *              of the branches.
 * @author Rav
 */
@Entity
@Table(name = "branchInfo")
public class BranchInfo implements Serializable {

    @Id
    @GeneratedValue(generator = "branchInfo_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, initialValue = 101, sequenceName = "branchInfo_seq", name = "branchInfo_seq")
    private int branchInfoId;
    private long target;
    private long applications;
    private long issued;
    private float bal_amount;
    private long bal_target;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branchId")
    private Branches branch;

    public long getApplications() {
        return applications;
    }

    public void setApplications(long applications) {
        this.applications = applications;
    }

    public float getBal_amount() {
        return bal_amount;
    }

    public void setBal_amount(float bal_amount) {
        this.bal_amount = bal_amount;
    }

    public long getBal_target() {
        return bal_target;
    }

    public void setBal_target(long bal_target) {
        this.bal_target = bal_target;
    }

    public Branches getBranch() {
        return branch;
    }

    public void setBranch(Branches branch) {
        this.branch = branch;
    }

    public int getBranchInfoId() {
        return branchInfoId;
    }

    public void setBranchInfoId(int branchInfoId) {
        this.branchInfoId = branchInfoId;
    }

    public long getIssued() {
        return issued;
    }

    public void setIssued(long issued) {
        this.issued = issued;
    }

    public long getTarget() {
        return target;
    }

    public void setTarget(long target) {
        this.target = target;
    }
}
