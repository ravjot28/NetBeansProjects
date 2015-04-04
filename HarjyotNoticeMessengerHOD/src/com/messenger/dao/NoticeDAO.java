/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.dao;

/**
 *
 * @author Rav
 */
public class NoticeDAO {
    
    private String year;
    private String branch;
    private String date;
    private String from;
    private String body;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
