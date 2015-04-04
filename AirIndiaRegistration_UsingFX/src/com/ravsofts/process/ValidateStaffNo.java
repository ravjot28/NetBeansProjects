/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravsofts.process;

import com.ravsofts.constants.GlobalConstants;
import java.util.StringTokenizer;

/**
 *
 * @author Ravjot
 */
public class ValidateStaffNo {

    public String[] getRegisteredStaffNo() throws Exception {
        GetEmpID ge = new GetEmpID();

        String d[] = ge.process();
        
        return d;
    }

    public boolean validateStaffNo(String staffNo) throws Exception {
        return check(getRegisteredStaffNo(),staffNo);
    }

    public boolean check(String[] d, String staffNo) {
        StringTokenizer s = new StringTokenizer(d[0], GlobalConstants.commaSymbol);
        while (s.hasMoreTokens()) {
            String staffNos = s.nextToken().trim();
            if (staffNo.trim().equals(staffNos)) {
                return false;
            }
        }
        return true;
    }
}
