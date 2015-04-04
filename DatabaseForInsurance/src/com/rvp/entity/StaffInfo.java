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
@Table(name = "staffInfo")
public class StaffInfo implements Serializable {

    @Id
    @GeneratedValue(generator = "staffInfoId_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, initialValue = 101, sequenceName = "staffInfoId_seq", name = "staffInfoId_seq")
    private int staffInfoId;
    private long staffTarget;
    private long staffApplications;
    private long staffIssued;
    private float staffBalAmount;
    private float staffBalTarget;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="staffId")
    private Staff staff;

    public long getStaffApplications() {
        return staffApplications;
    }

    public void setStaffApplications(long staffApplications) {
        this.staffApplications = staffApplications;
    }

    public float getStaffBalAmount() {
        return staffBalAmount;
    }

    public void setStaffBalAmount(float staffBalAmount) {
        this.staffBalAmount = staffBalAmount;
    }

    public float getStaffBalTarget() {
        return staffBalTarget;
    }

    public void setStaffBalTarget(float staffBalTarget) {
        this.staffBalTarget = staffBalTarget;
    }

    public int getStaffInfoId() {
        return staffInfoId;
    }

    public void setStaffInfoId(int staffInfoId) {
        this.staffInfoId = staffInfoId;
    }

    public long getStaffIssued() {
        return staffIssued;
    }

    public void setStaffIssued(long staffIssued) {
        this.staffIssued = staffIssued;
    }

    public long getStaffTarget() {
        return staffTarget;
    }

    public void setStaffTarget(long staffTarget) {
        this.staffTarget = staffTarget;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
