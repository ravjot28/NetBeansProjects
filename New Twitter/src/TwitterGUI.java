import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TwitterGUI extends JFrame implements ActionListener
{
    JFrame f;
    JButton b;
    JTextArea a;
    JLabel l;
    String uname,pwd;
    static int x=140;

    TwitterGUI(String u,String ps)
    {
        uname=u;
        pwd=ps;
        f=new JFrame("Twitter");
        b=new JButton("Tweet");
        b.addActionListener(this);
        a=new JTextArea();
        l=new JLabel(""+x);
        l.setBackground(Color.LIGHT_GRAY);
        a.setRows(2);
        a.setColumns(70);
        JPanel p=new JPanel();
        f.setLayout(new BorderLayout());
        f.add(b,BorderLayout.EAST);
        f.add(l,BorderLayout.CENTER);
        f.add(a,BorderLayout.WEST);
        f.addWindowListener(new WindowAdapter(){      public void windowClosing(WindowEvent e) {        System.exit(0);      }    });
        f.pack();
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String status=a.getText();
        try
        {
            new Twitter().send(uname, pwd,status);
        } catch (Exception ex) {        }
    }

}
