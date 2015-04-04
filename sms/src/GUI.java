import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUI extends JFrame implements ActionListener
{
    JTextField t;
    JButton publish;
    public static void main(String asd[])
    {
        new GUI();
    }
    GUI()
    {
        JFrame f=new JFrame("Facebook");
        publish=new JButton("Publish");
        t=new JTextField(50);
        f.setLayout(new BorderLayout());
        publish.addActionListener(this);
        f.add(t,BorderLayout.NORTH);
        f.add(publish,BorderLayout.SOUTH);
        f.pack();
        f.addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        System.exit(0);      }    });
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("publish"))
        {
                String message=t.getText();
                System.out.println(message);
                try {
                new SendtoFacebook().rav(message,"","");
            } catch (Exception ex) {System.out.println("Exception at Action performed publish");
            }
          
            }
        }
    }


