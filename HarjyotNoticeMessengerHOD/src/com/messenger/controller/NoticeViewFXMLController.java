/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.controller;

import com.messenger.bindingDTO.NoticeBindingDTO;
import com.messenger.dao.NoticeDAO;
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
public class NoticeViewFXMLController implements Initializable, ControlledScreen {

    Logger logger = LoggerFactory.getLogger(NoticeViewFXMLController.class);
    ScreenController myForm;
    NoticeBindingDTO noticeDTO = new NoticeBindingDTO();
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
        Bindings.bindBidirectional(notice.textProperty(), noticeDTO.noticeBodyProperty());
        Bindings.bindBidirectional(noticeDate.textProperty(), noticeDTO.noticeDateProperty());
        Bindings.bindBidirectional(noticeSender.textProperty(), noticeDTO.noticeSenderProperty());

        ReadObject ro = new ReadObject();

        NoticeDAO notice = ro.readNoticeObject();
        noticeDTO.setNoticeBody(notice.getBody());
        noticeDTO.setNoticeDate(notice.getDate());
        noticeDTO.setNoticeSender(notice.getFrom());

    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        myForm = screenPage;
    }
}
