/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rvp.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Description: This entity class contains details
 *              of the user.
 * @author Rav
 */
@Entity
@Table(name="userInfo")
public class UserInfo implements Serializable {
    @Id
    @Column(name="userInfoId")
    @GeneratedValue(generator = "userInfoId_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, initialValue = 101, sequenceName = "userInfoId_seq", name = "userInfoId_seq")
    private int userInfoId;
    private String userRole;
    private String useraccesstoScreens;
    private int branchId;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="userId")
    private Users users;

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUseraccesstoScreens() {
        return useraccesstoScreens;
    }

    public void setUseraccesstoScreens(String useraccesstoScreens) {
        this.useraccesstoScreens = useraccesstoScreens;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb = sb.append("UserId: ")
                .append(this.getUserInfoId())
                .append("\n")
                .append("Branch Id: ")
                .append(this.getBranchId())
                .append("\n")
                .append("User Role: ")
                .append(this.getUserRole())
                .append("\n")
                .append("User Access To Screens: ")
                .append(this.getUseraccesstoScreens());
        return sb.toString();
    }
}
