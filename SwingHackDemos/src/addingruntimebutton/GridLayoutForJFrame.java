/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classdiferentiation;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.GridLayout;

public class GridLayoutForJFrame
{
public static void main(String[]args)
{
 //Create a JFrame with title ( Set JFrame layout using Grid Layout )
 JFrame frame=new JFrame("Set JFrame layout using Grid Layout");

 //Create grid layout that contains :
 //3 rows
 //2 columns
 GridLayout layout=new GridLayout(3,2);

 //Set JFrame layout to grid layout with 3 rows and 2 columns
 frame.setLayout(layout);

 //Create 6 buttons that we want to add into JFrame
 JButton button1=new JButton("BUTTON1");
 JButton button2=new JButton("BUTTON2");
 JButton button3=new JButton("BUTTON3");
 JButton button4=new JButton("BUTTON4");
 JButton button5=new JButton("BUTTON5");
 JButton button6=new JButton("BUTTON6");


 //Add all buttons into JFrame

 //Add first button at row number 1 and column number 1
 frame.add(button1);

 //Add second button at row number 1 and column number 2
 frame.add(button2);

 //Add third button at row number 2 and column number 1
 frame.add(button3);

 //Add fourth button at row number 2 and column number 2
 frame.add(button4);

 //Add fifth button at row number 3 and column number 1
 frame.add(button5);

 //Add sixth button at row number 3 and column number 2
 frame.add(button6);

 //Set default close operation for JFrame
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 //Set JFrame size :
 //Width : 400 pixels
 //Height : 400 pixels
 frame.setSize(400,400);

 //Make JFrame visible. So we can see it.
 frame.setVisible(true);
}
}  