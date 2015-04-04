/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testingmp3;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
//import ravmp3.Mp3;

/**
 *
 * @author Rav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Mp3 m = new Mp3();
       //System.out.println(m.playSong("D:\\Music\\Songs\\Hindi\\Hona Tha Pyaar.mp3"));
       //System.out.println(m.playSong("D:\\Music\\Songs\\Hindi\\Hawwa Hawwai Shaitan.mp3"));

       JFrame f = new JFrame("hi");
       JRadioButton b = new JRadioButton();
       String label = "<html><table cellpadding=0><tr><td><img src=file:\"C:\\Users\\Rav\\Documents\\NetBeansProjects\\AirIndiaNew\\Bin\\img\\edit.png\"/></html>";

// Add the icon
        b.setText(label);
        f.add(b);
        f.pack();
        f.setVisible(true);
    }

}
