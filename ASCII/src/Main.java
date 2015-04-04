import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.StringTokenizer;

public class Main extends JFrame implements ActionListener
{
    JFrame f;
    JButton b,b1,b2,b3;
    JLabel l1,l2;
    JTextField q,a;
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
        f=new JFrame("ASCII Convertor");
        b=new JButton("Encode");
        b1=new JButton("Decode");
        b2=new JButton("Clear");
        b3=new JButton("Exit");
        l1=new JLabel("Enter Your data");
        l2=new JLabel("Output");
        q=new JTextField(30);
        a=new JTextField(30);
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p1.add(l1);
        p1.add(q);
        p2.add(l2);
        p2.add(a);
        p3.add(b);
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        f.setLayout(new GridLayout(3,1));
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.pack();
        f.setLocationRelativeTo(null);
        f.addWindowListener(new WindowAdapter() {      public void windowClosing(WindowEvent e) {        System.exit(0);      }    });
        f.setVisible(true);
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
                    if(e.getActionCommand().equalsIgnoreCase("Encode"))
                    {
                        if((q.getText()!="")||(q.getText()!=null))
                        {
                            String result="";
                            for(int i=0;i<q.getText().length();i++)
                            {
                                char c = q.getText().charAt(i);
                                int j = (int) c;
                                result=result+j+",";
                            }
                            a.setText(result);
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
                       String result="";
                                String c = q.getText();
                                StringTokenizer Tok = new StringTokenizer(c,",");
                                int n=0;
                                while (Tok.hasMoreElements())
                                {
                                    int j = Integer.parseInt((String) Tok.nextElement());
                                    char cc=(char)j;
                                    result=result+cc;
                                }
                                
                            a.setText(result);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Please Enter the Base64 number","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
        }

    public static void main(String args[])
    {
        new Main();
    }

}
