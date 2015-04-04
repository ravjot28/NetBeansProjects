/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhag;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;
import java.sql.*;

public class Demo extends JFrame implements ActionListener
{
	String str;
	JButton b1,b2;
	JLabel l1,tf;
	Checkbox c1,c2,c3,c4;
	CheckboxGroup cbg;
        JFrame f;
	String records[][];
	static int count=0;

public Demo()
	{
                setUndecorated(true);
//		records=new Get().get();
		setVisible(true);
		setSize(1200,900);
		setLayout(null);
		setResizable(false);


		//Assigning Label for output Display

		l1=new JLabel(records[count][0]);

		//Assigning for Clock
		tf=new JLabel();
		javax.swing.Timer t=new javax.swing.Timer(1000,new ClockListener());
		t.start();

		//RadioButtons
		cbg=new CheckboxGroup();
		c1=new Checkbox(records[count][1],cbg,false);
		c2=new Checkbox(records[count][2],cbg,false);
		c3=new Checkbox(records[count][3],cbg,false);
		c4=new Checkbox(records[count][4],cbg,false);

		//Assigning Buttons
		b1=new JButton("Next");
		b2=new JButton("Previous");

		//Font
		Font f=new Font("Times New Roman",Font.BOLD,16);

		l1.setFont(f);


		c1.setFont(f);
		c2.setFont(f);
		c3.setFont(f);
		c4.setFont(f);

		tf.setFont(f);

		//SetBounds
		l1.setBounds(250,40,150,20);

		c1.setBounds(250,80,150,20);
		c2.setBounds(250,120,150,20);
		c3.setBounds(250,160,150,20);
		c4.setBounds(250,200,150,20);

		b1.setBounds(550,680,150,20);
		b2.setBounds(350,680,150,20);

		tf.setBounds(550,40,60,20);



		//Adding Labels,Buttons and TextFields

		add(l1);

		add(c1);
		add(c2);
		add(c3);
		add(c4);


		add(b1);
		add(b2);

		add(tf);


		b1.addActionListener(this);
		b2.addActionListener(this);


	}



public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equalsIgnoreCase("next"))
			{
			/*	try
					{
					//	int i=new Get().size();

//						if(count>=i-1)
							{
								count=i-1;
							}
						else
							{
								count++;
							}
						l1.setText(records[count][0]);
						c1.setLabel(records[count][1]);
						c2.setLabel(records[count][2]);
						c3.setLabel(records[count][3]);
						c4.setLabel(records[count][4]);

					}catch(Exception e){}

			}
		else
			{
				try
					{
						if(count!=0)
						{
							count--;
						}
						else
						{
							count=0;
						}
						l1.setText(records[count][0]);
						c1.setLabel(records[count][1]);
						c2.setLabel(records[count][2]);
						c3.setLabel(records[count][3]);
						c4.setLabel(records[count][4]);
					}catch(Exception e){}
			}*/

	}
    }
public static void main(String args[])
	{

		Demo d=new Demo();

		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

class ClockListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
			{
				Calendar c=Calendar.getInstance();
				int h=c.get(Calendar.HOUR_OF_DAY);
				int m=c.get(Calendar.MINUTE);
				int s=c.get(Calendar.SECOND);
				tf.setText(""+h+":"+m+":"+s);
			}
	}
}