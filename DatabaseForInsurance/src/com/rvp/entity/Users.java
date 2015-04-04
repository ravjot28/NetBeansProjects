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
 *
 * @author Rav
 * Description: Entity Class for Users table
 *              which will hold the information of all users
 *              who can login
 */
@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(generator = "userId_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, initialValue = 101, sequenceName = "userId_seq", name = "userId_seq")
    private int userId;
    private String userName;
    private String userPassword;
    private char active;

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        StringBuffer sb = null;
        sb = new StringBuffer();
        sb = sb.append("UserId: ")
                .append(this.getUserId())
                .append("\n")
                .append("User Name: ")
                .append(this.getUserName())
                .append("\n")
                .append("User Password: ")
                .append(this.getUserPassword())
                .append("\n")
                .append("Active: ")
                .append(this.getActive());
        return sb.toString();
    }
}
