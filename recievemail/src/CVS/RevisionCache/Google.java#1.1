import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Google extends JFrame implements ActionListener
{
     String s;
     JTextField t;
     JFrame f;
     JPanel p;
     JButton search;
     JButton clear;
     Google()
     {
         s="";
         f=new JFrame("Google Search");
         p=new JPanel();
         t=new JTextField(30);
         search=new JButton("Search");
         clear=new JButton("Clear");
         search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if((t.getText()=="")||(t.getText()==null))
                {
                    JOptionPane.showMessageDialog(null,"Please enter the word to be searched","Error",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    s=t.getText();
                    launch();
                }
            }
        });
        clear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                t.setText("");
            }
        });
        f.setLayout(new GridLayout(2,1));
        f.setLocationRelativeTo(null);
        p.add(search);
        p.add(clear);
        f.add(t);
        f.add(p);
        f.addWindowListener(new WindowAdapter()
                            {
                                public void windowClosing(WindowEvent e)
                                {
                                    System.exit(0);
                                }
                            });
        f.pack();
        f.setVisible(true);
     }
     public void launch()
     {
         String google="http://www.google.ca/search?q="+s+"&hl=en&ie=UTF-8&oe=UTF8";
          String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler" + " " + google;
                                        System.out.println(cmd);
        try {
            Process p = Runtime.getRuntime().exec(cmd);
        } catch (IOException ex) {
            Logger.getLogger(Google.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       public static void main(String sap[])
{
   
    new Google();
}

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
