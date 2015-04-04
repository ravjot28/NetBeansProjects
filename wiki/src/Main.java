import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JFrame implements ActionListener
{
    JFrame f;
    JButton b,b1;
    JTextField t;

    Main()
    {
        f=new JFrame("Wiki Seach");
        JPanel p=new JPanel();
        JPanel p1=new JPanel();
        b=new JButton("Search");
        b1=new JButton("Exit");
        t=new JTextField(30);
        b.addActionListener(this);
        b1.addActionListener(this);
        p1.add(b);
        p1.add(b1);
        p.add(t);
        f.setLayout(new GridLayout(2,1));
        f.add(p);
        f.add(p1);
        f.pack();
        f.setLocationRelativeTo(null);
        f.addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        System.exit(0);      }    });
        f.setVisible(true);
    }

    public static void main(String asd[])
    {
        new Main();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("search"))
        {
            String a="";
            if((t.getText()=="")||(t.getText()==null))
            {
                JOptionPane.showMessageDialog(null,"Please Enter content","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                a=t.getText();
            try {
                new wiki(a);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        else
        {
            System.exit(0);
        }
    }

}
