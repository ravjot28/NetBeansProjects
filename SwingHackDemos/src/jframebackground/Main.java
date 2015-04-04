package jframebackground;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main
{
    Main()
    {
        JFrame myFrame=new JFrame("Put Image");
        JButton button1=new JButton("Sample 1");
        JButton button2=new JButton("Sample 2");
        PutImageOnJFrame c=new PutImageOnJFrame();
        c.add(button1);
        c.add(button2);
        myFrame.add(c);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image a=Toolkit.getDefaultToolkit().getImage("bg.jpg");
        //myFrame.setSize(400,400);
        myFrame.pack();
        myFrame.setVisible(true);
    }

    public static void main(String sd[])
    {
        new Main();
    }

}
