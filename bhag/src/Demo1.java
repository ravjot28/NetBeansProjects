import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.sql.*;


public class Demo1 extends JFrame implements ActionListener
{
String str;
JButton b1,b2;
JLabel l1,l2,l3,l4,l5;
String records[][];
static int count=0;

public Demo1()
{
   records=new Get().get();
setVisible(true);
setSize(1200,900);
setLayout(null);
setResizable(false);
//Assigning Labels for output Display
l1=new JLabel(records[count][0]);
l2=new JLabel(records[count][1]);
l3=new JLabel(records[count][2]);
l4=new JLabel(records[count][3]);
l5=new JLabel(records[count][4]);




//Assigning Button
b1=new JButton("Next");
b2=new JButton("Previous");

//Font
Font f1=new Font("Times New Roman",Font.BOLD,16);
l1.setFont(f1);
l2.setFont(f1);
l3.setFont(f1);
l4.setFont(f1);
l5.setFont(f1);

//SetBounds
l1.setBounds(250,40,150,20);
l2.setBounds(250,80,150,20);
l3.setBounds(250,120,150,20);
l4.setBounds(250,160,150,20);
l5.setBounds(250,200,150,20);



b1.setBounds(550,680,150,20);
b2.setBounds(350,680,150,20);

//Adding Labels and TextFields
add(l1);
add(l2);
add(l3);
add(l4);
add(l5);




add(b1);
add(b2);

b1.addActionListener(this);
b2.addActionListener(this);

}

public void actionPerformed(ActionEvent ae)
{
    if(ae.getActionCommand().equalsIgnoreCase("next"))
    {
            try {
                
                int i = new Get().size();
                System.out.println(i);
                if (count >= i-1) {
                    count = i-1;
                } else {
                    count++;
                }
                l1.setText(records[count][0]);
                l2.setText(records[count][1]);
                l3.setText(records[count][2]);
                l4.setText(records[count][3]);
                l5.setText(records[count][4]);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Demo1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Demo1.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    else
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
        l2.setText(records[count][1]);
        l3.setText(records[count][2]);
        l4.setText(records[count][3]);
        l5.setText(records[count][4]);
    }


}

public static void main(String args[])
{
new Demo1();
}
}






