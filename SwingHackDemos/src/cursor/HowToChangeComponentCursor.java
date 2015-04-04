/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cursor;

import java.awt.Frame;
import java.awt.Component;
import java.awt.Cursor;

import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HowToChangeComponentCursor
{
 public static void main(String[]args)
 {
  WindowListener wl=new WindowAdapter()
  {
   public void windowClosing(WindowEvent evt)
   {
    System.exit(0);
   }
  };

  Frame a=new Frame("HOVER YOUR CURSOR IN THIS FRAME");
  a.addWindowListener(wl);

  //METHOD setCursor WILL SET NEW CURSOR FOR COMPONENT
  a.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

  a.setSize(800,600);
  a.setVisible(true);
 }
}  