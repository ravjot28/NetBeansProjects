import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener
{
    String in[]=new String[9];
    private JPanel p,p1,p2,p3,p4;
    private JFrame f;
    JLabel user,phone,phone2;
    JTextField name;
    IntegerField phone1,phone22;
    JButton enter,reset;

    public Main(String[] info)
    {
        in=info;
        f=new JFrame("GTBIT Simulator");
        p=new JPanel(new GridLayout(3,1));
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        user=new JLabel("Team Name");
        phone=new JLabel("Phone Number");
        phone2=new JLabel("Second Phone Number");
        name=new JTextField(20);
        phone1=new IntegerField(10);
        phone22=new IntegerField(10);
        enter=new JButton(new ImageIcon("MainIcon/enter.png"));
        reset=new JButton(new ImageIcon("MainIcon/reset.gif"));
        enter.setToolTipText("Enter");
        reset.setToolTipText("Reset");
        enter.setActionCommand("enter");
        reset.setActionCommand("reset");
        launch();
    }

    public void launch()
    {
       f.setLayout(new BorderLayout());
       p1.add(user);
       p1.add(name);
       p2.add(phone);
       p2.add(phone1);
       p4.add(phone2);
       p4.add(phone22);
       p3.add(enter);
       p3.add(reset);
       p.add(p1);
       p.add(p2);
       p.add(p4);
       f.add(p,BorderLayout.CENTER);
       f.add(p3,BorderLayout.SOUTH);
       f.pack();
       f.setLocation(500,300);
       enter.addActionListener(this);
       reset.addActionListener(this);
       f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {System.exit(0);}});
       f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("enter"))
        {
            String n=name.getText();
            String p=phone1.getText();
            String p1=phone22.getText();
           
                if((p.isEmpty())&&(p1.isEmpty()))
                {
                    p=null;
                    n=null;
                    JOptionPane.showMessageDialog(null,"Oops Please Enter the Correct phone number","Invalid Phone Number",JOptionPane.ERROR_MESSAGE);
                }
                else
                if(n.equalsIgnoreCase(""))
                {
                    p=null;
                    n=null;
                    JOptionPane.showMessageDialog(null,"Oops Please Enter Name","Invalid Name",JOptionPane.ERROR_MESSAGE);
                }
                else
                if((p.length()==10)&&(p1.length()==10))
                {
                    f.setVisible(false);
                    new quesbank(name.getText(),phone1.getText(),phone22.getText(),in);
                }
                else
                {
                    p=null;
                    n=null;
                    JOptionPane.showMessageDialog(null,"Oops Please Enter the Correct phone number","Invalid Phone Number",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        else
            if(e.getActionCommand().equalsIgnoreCase("reset"))
            {
                name.setText(null);
                phone1.setText(null);
            }
    }

}
