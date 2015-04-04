/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.util;

import com.messenger.dao.NoticeDAO;
import com.messenger.dao.SurveyDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author Ravjot
 */
public class ReadObject {

    public NoticeDAO readNoticeObject() {
        NoticeDAO e = null;
        try {
            String serializableFileName = "Notices\\Temp\\noticeTemp.ravs";
            if (new File(serializableFileName).exists()) {
                FileInputStream fileIn =
                        new FileInputStream(serializableFileName);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                e = (NoticeDAO) in.readObject();
                in.close();
                fileIn.close();
            }
        } catch (Exception i) {
            i.printStackTrace();
        }
        return e;
    }
    
    public SurveyDAO readSurveyObject() {
        SurveyDAO e = null;
        try {
            String serializableFileName = "Notices\\Temp\\surveyTemp.ravs";
            if (new File(serializableFileName).exists()) {
                FileInputStream fileIn =
                        new FileInputStream(serializableFileName);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                e = (SurveyDAO) in.readObject();
                in.close();
                fileIn.close();
            }
        } catch (Exception i) {
            i.printStackTrace();
        }
        return e;
    }
}
