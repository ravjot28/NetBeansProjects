/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.util;

import com.ravsofts.constants.GlobalConstants;
import com.ravsofts.dao.MembershipInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Ravjot
 */
public class SaveObject {

    public boolean saveObject(MembershipInfo e) {
        try {
            String dir = System.getProperty(GlobalConstants.userHome) + System.getProperty(GlobalConstants.fileSeparator) + GlobalConstants.folderName;

            if (!new File(dir).exists()) {
                File f = new File(dir);
                f.mkdir();
            }

            FileOutputStream fileOut =
                    new FileOutputStream(dir+System.getProperty(GlobalConstants.fileSeparator)+GlobalConstants.fileName);
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
