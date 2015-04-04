/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.util.Date;

/**
 *
 * @author Rav
 */
public class NewClass
{
    public static void main(String s[])
    {
        String d = new Date().toString();
        int date = new Date().getDate();
        int year = new Date().getYear();
        //int month = new Date().getMonth();
        System.out.println(d+" "+date+" "+year);//+" "+month);
    }
}
