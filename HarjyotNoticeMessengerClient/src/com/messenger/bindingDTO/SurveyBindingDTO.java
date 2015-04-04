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
public class SurveyBindingDTO {

    private StringProperty surveyBody = new SimpleStringProperty();
    private StringProperty surveySender = new SimpleStringProperty();
    private StringProperty surveyDate = new SimpleStringProperty();

    /**
     * @return the emailID
     */
    public String getSurveyBody() {
        return (String) this.surveyBody.get();
    }

    /**
     * @param emailID the emailID to set
     */
    public void setSurveyBody(String surveyBody) {
        this.surveyBody.set(surveyBody);
    }

    public StringProperty surveyBodyProperty() {
        return this.surveyBody;
    }

    /**
     * @return the userName
     */
    public String getSurveySender() {
        return (String) this.surveySender.get();
    }

    /**
     * @param userName the userName to set
     */
    public void setSurveySender(String surveySender) {
        this.surveySender.set(surveySender);
    }

    public StringProperty surveySenderProperty() {
        return this.surveySender;
    }

    /**
     * @return the userName
     */
    public String getSurveyDate() {
        return (String) this.surveyDate.get();
    }

    /**
     * @param userName the userName to set
     */
    public void setSurveyDate(String surveyDate) {
        this.surveyDate.set(surveyDate);
    }

    public StringProperty surveyDateProperty() {
        return this.surveyDate;
    }

    /**
     * @return the userName
     */
    public String getBranch() {
        return (String) this.surveyDate.get();
    }

    /**
     * @param userName the userName to set
     */
    public void setBranch(String surveyDate) {
        this.surveyDate.set(surveyDate);
    }

    public StringProperty branchProperty() {
        return this.surveyDate;
    }
}
