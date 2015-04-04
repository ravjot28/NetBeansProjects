/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstjavafxproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Ravjot
 */
public class temp {

    public static void main(String as[]) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(cal.getTime());
// Ouput "Wed Sep 26 14:23:28 EST 2012"

        String formatted = format1.format(cal.getTime()).replace("/0", "/");
        System.out.println(formatted);
    }
}
