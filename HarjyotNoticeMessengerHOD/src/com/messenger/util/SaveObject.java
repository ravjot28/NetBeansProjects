/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.util;

import com.messenger.dao.NoticeDAO;
import com.messenger.dao.SurveyDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Ravjot
 */
public class SaveObject {

    public boolean saveNoticeObject(NoticeDAO e) {
        try {
            String dir = "Notices\\Temp\\";

            if (!new File(dir).exists()) {
                File f = new File(dir);
                f.mkdir();
            }

            FileOutputStream fileOut =
                    new FileOutputStream("Notices\\Temp\\noticeTemp.ravs");
            ObjectOutputStream out =
                    new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            return true;
        } catch (Exception i) {
            i.printStackTrace();
            return false;
        }
    }

    public boolean saveSurveyObject(SurveyDAO e) {
        try {
            String dir = "Notices\\Temp\\";

            if (!new File(dir).exists()) {
                File f = new File(dir);
                f.mkdir();
            }

            FileOutputStream fileOut =
                    new FileOutputStream("Notices\\Temp\\surveyTemp.ravs");
            ObjectOutputStream out =
                    new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            return true;
        } catch (Exception i) {
            i.printStackTrace();
            return false;
        }
    }
}
