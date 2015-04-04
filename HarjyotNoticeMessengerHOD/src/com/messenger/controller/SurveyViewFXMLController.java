/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.controller;

import com.messenger.bindingDTO.NoticeBindingDTO;
import com.messenger.bindingDTO.SurveyBindingDTO;
import com.messenger.dao.SurveyDAO;
import com.messenger.ui.ScreenController;
import com.messenger.util.ReadObject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author Ravjot
 */
public class SurveyViewFXMLController implements Initializable, ControlledScreen {

    Logger logger = LoggerFactory.getLogger(SurveyViewFXMLController.class);
    ScreenController myForm;
    SurveyBindingDTO surveyDTO = new SurveyBindingDTO();
    @FXML
    TextArea notice;
    @FXML
    Label noticeSender;
    @FXML
    Label noticeDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Bindings.bindBidirectional(notice.textProperty(), surveyDTO.surveyBodyProperty());
        Bindings.bindBidirectional(noticeDate.textProperty(), surveyDTO.surveyDateProperty());
        Bindings.bindBidirectional(noticeSender.textProperty(), surveyDTO.surveySenderProperty());

        ReadObject ro = new ReadObject();

        SurveyDAO survey = ro.readSurveyObject();
        surveyDTO.setSurveyBody(survey.getBody());
        surveyDTO.setSurveyDate(survey.getDate());
        surveyDTO.setSurveySender(survey.getFrom());
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        myForm = screenPage;
    }
}
