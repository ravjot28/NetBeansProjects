/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Ravjot
 */
public class temp {

    public static void main(String re[]) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        cal.setTime(sdf.parse("2/11/1966"));
        System.out.println(cal);
        
        System.out.println("W/o".toUpperCase());
    }
}
