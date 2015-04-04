import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener
{
    private Frame f12;
    private JButton b1,b2;
    private JTextField sub;
    private TextArea body;
    private Label l1,l2,l3,l4,l5;
    private Panel p1;
    private Panel p2,p3,p4,p5,p6;
    public GUI()
    {
        f12=new Frame("Send Bug Report");
        f12.addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {        f12.setVisible(false);      }    });

        sub=new JTextField(20);
        body=new TextArea("", 30 , 100 , TextArea.SCROLLBARS_VERTICAL_ONLY);
        b1=new JButton("Send");
        b2=new JButton("Reset");
        l4=new Label("Sub *");
        l1=new Label("");
        p1=new Panel();
        p2=new Panel(new GridLayout(2,1));
        p3=new Panel(new FlowLayout());
        p4=new Panel();
        p5=new Panel(new FlowLayout());
        p6=new Panel(new GridLayout(3,1));
    }

    public void launch() throws Exception
    {
        LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                   // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception e) {
                    }
       
        f12.setLayout(new BorderLayout());
        p3.add(l4);
        p3.add(sub);
        p1.add(l1);
        p4.add(body);
        p5.add(b1);
        p5.add(b2);
        p2.add(p5);
        p6.add(p3);
        p6.add(p1);
        f12.add(p6,BorderLayout.NORTH);
        f12.add(p4,BorderLayout.CENTER);
        f12.add(p2,BorderLayout.SOUTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
        f12.pack();
        f12.setVisible(true);
    }
    private void actionExit()
    {
        System.exit(0);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Send"))
        {
             if(sub.getText().equalsIgnoreCase(""))
                {
                    JOptionPane.showMessageDialog(null,"Subject is empty please fill it.","Subject Empty",JOptionPane.ERROR_MESSAGE);
                }else
            if(body.getText().equalsIgnoreCase(""))
            {
                JOptionPane.showMessageDialog(null,"Body is empty please fill it.","Body Empty",JOptionPane.ERROR_MESSAGE);
            }
               
                else
                {
           /* b1.setVisible(false);
            b2.setVisible(false);
           String s=sub.getText();
           String b=body.getText();
           sending s1=new sending(b,s);
           l1.setLocation(340,20);
            l1.setSize(104,15);
            l1.setAlignment(Label.CENTER);
            l1.setText("Sending.");*/

           String s=sub.getText();
           String b=body.getText();
                 sending s1=new sending(b,s);
           String result=s1.send();
           JOptionPane.showMessageDialog(null, result,"Alert",JOptionPane.INFORMATION_MESSAGE);
           if(result.equals("Your message is successfully mailed"))
           {
               JOptionPane.showMessageDialog(null, result,"Alert",JOptionPane.INFORMATION_MESSAGE);
               f12.setVisible(false);
           }
            /*b1.setVisible(true);
            b2.setVisible(true);
            l1.setAlignment(Label.CENTER);
           l1.setLocation(340,20);
            l1.setSize(44,15);
            l1.setBackground(Color.yellow);
            l1.setText("Sent....");*/
                }
        }
        
        else
        {
            sub.setText("");
            body.setText("");
            l1.setText("");
        }
    }
}
