/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.util;

import com.ravsofts.constants.GlobalConstants;
import java.io.File;

/**
 *
 * @author Ravjot
 */
public class UserStatus {

    public boolean isNewUser() {
        String file = System.getProperty(GlobalConstants.userHome) + System.getProperty(GlobalConstants.fileSeparator) + GlobalConstants.folderName;

        File folderLocation = new File(file);

        if (folderLocation.exists()) {
            String s[] = folderLocation.list();
            if (s != null && s.length > 0) {
                for (String fileName : s) {
                    if (fileName.indexOf(GlobalConstants.fileExtension) > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
