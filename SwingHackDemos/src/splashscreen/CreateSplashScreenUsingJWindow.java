/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package splashscreen;

import javax.swing.JWindow;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Dimension;

public class CreateSplashScreenUsingJWindow extends JWindow
{
Image imageForSplashScreen;
ImageIcon ii;

public CreateSplashScreenUsingJWindow()
{
 //Get image for splash screen image.
 //Put full address for your image location
 //In my case, my image location is : C:\Documents and Settings\evergreen\Desktop\splashscreenimage.jpg
 imageForSplashScreen=Toolkit.getDefaultToolkit().getImage("splashscreenimage.jpg");

 //Create ImageIcon from Image
 ii=new ImageIcon(imageForSplashScreen);

 //Set JWindow size from image size
 setSize(ii.getIconWidth(),ii.getIconHeight());

 //Get current screen size
 Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();

 //Get x coordinate on screen for make JWindow locate at center
 int x=(screenSize.width-getSize().width)/2;

 //Get y coordinate on screen for make JWindow locate at center
 int y=(screenSize.height-getSize().height)/2;

 //Set new location for JWindow
 setLocation(x,y);

 //Make JWindow visible.
 setVisible(true);
}

//Paint image onto JWindow
public void paint(Graphics g)
{
 super.paint(g);
 g.drawImage(imageForSplashScreen,0,0,this);
}

public static void main(String[]args)
{
 CreateSplashScreenUsingJWindow cssujw=new CreateSplashScreenUsingJWindow();

 try
 {
  //Make JWindow appear for 5 seconds before disappear
  Thread.sleep(5000);
  cssujw.dispose();
 }
 catch(Exception exception)
 {
  exception.printStackTrace();
 }

 JFrame frame=new JFrame("Main Window");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setSize(500,500);
 frame.setVisible(true);
}
}
