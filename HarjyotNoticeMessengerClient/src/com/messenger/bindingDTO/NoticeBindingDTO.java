/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.bindingDTO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ravjot
 */
public class NoticeBindingDTO {
    private StringProperty noticeBody = new SimpleStringProperty();
    private StringProperty noticeSender = new SimpleStringProperty();
    private StringProperty noticeDate = new SimpleStringProperty();

    /**
     * @return the emailID
     */
    public String getNoticeBody() {
        return (String) this.noticeBody.get();
    }

    /**
     * @param emailID the emailID to set
     */
    public void setNoticeBody(String noticeBody) {
        this.noticeBody.set(noticeBody);
    }

    public StringProperty noticeBodyProperty() {
        return this.noticeBody;
    }

    /**
     * @return the userName
     */
    public String getNoticeSender() {
        return (String) this.noticeSender.get();
    }

    /**
     * @param userName the userName to set
     */
    public void setNoticeSender(String noticeSender) {
        this.noticeSender.set(noticeSender);
    }

    public StringProperty noticeSenderProperty() {
        return this.noticeSender;
    }

    /**
     * @return the userName
     */
    public String getNoticeDate() {
        return (String) this.noticeDate.get();
    }

    /**
     * @param userName the userName to set
     */
    public void setNoticeDate(String noticeDate) {
        this.noticeDate.set(noticeDate);
    }

    public StringProperty noticeDateProperty() {
        return this.noticeDate;
    }

    /**
     * @return the userName
     */
    public String getBranch() {
        return (String) this.noticeDate.get();
    }

    /**
     * @param userName the userName to set
     */
    public void setBranch(String noticeDate) {
        this.noticeDate.set(noticeDate);
    }

    public StringProperty branchProperty() {
        return this.noticeDate;
    }
}
