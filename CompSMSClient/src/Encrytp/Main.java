package Encrytp;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
public class Main extends JFrame implements ActionListener
{
    JFrame f;
    JButton b,b1,b2,b3;
    JTextField q,a;
    JLabel l1,l2;
    JPanel p1,p2,p3;
    Main()
    {
        LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                   //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
        f=new JFrame("Base64 Decoder");
        f.setLayout(new GridLayout(3,1));
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        b=new JButton("Decode Base64");
        b3=new JButton("Encode Base64");
        b1=new JButton("Clear");
        b2=new JButton("Exit");
        p3.add(b);
        p3.add(b3);
        p3.add(b1);
        p3.add(b2);
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        l1=new JLabel("Enter the given Number");
        l2=new JLabel("Output");
        q=new JTextField(30);
        a=new JTextField(30);
        p1.add(l1);
        p1.add(q);
        p2.add(l2);
        p2.add(a);
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.pack();
        f.setLocationRelativeTo(null);
        f.addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        System.exit(0);      }    });
        f.setVisible(true);
    }
    public static void main(String arg[])
    {
        new Main();
       new Base64Encoder("Man");
        
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equalsIgnoreCase("Exit"))
        {
            System.exit(0);
        }
        else
                if(e.getActionCommand().equalsIgnoreCase("Clear"))
                {
                    q.setText("");
                    a.setText("");
                }
                else
                    if(e.getActionCommand().equalsIgnoreCase("Encode Base64"))
                    {
                        if((q.getText()!="")||(q.getText()!=null))
            {
               Base64Encoder b= new Base64Encoder(q.getText());
               String rav=b.get();
               a.setText(rav);
            }

            else
            {
                JOptionPane.showMessageDialog(null,"Please Enter the given number","Error",JOptionPane.ERROR_MESSAGE);
            }
                    }
        else
        {
            if((q.getText()!="")||(q.getText()!=null))
            {
               Base64Decoder b= new Base64Decoder(q.getText());
               String rav=b.get();
               a.setText(rav);
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Please Enter the Base64 number","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}