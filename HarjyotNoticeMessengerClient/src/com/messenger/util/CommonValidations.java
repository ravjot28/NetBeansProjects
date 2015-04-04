/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ravjot
 */
public class CommonValidations {

    public static boolean isStringEmpty(String data) {
        boolean result = false;
        if (data == null || data.trim().length() == 0) {
            result = true;
        }
        return result;
    }

    public static boolean isValidEmailAddress(String emailAddress) {
        boolean result = false;

        if (!isStringEmpty(emailAddress)) {
            String EMAIL_PATTERN =
                    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(emailAddress);
            result =  matcher.matches();
        }

        return result;
    }
}
