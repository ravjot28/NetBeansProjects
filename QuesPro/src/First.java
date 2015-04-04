import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
public class First extends JFrame implements ActionListener
{
    String info[];
    JFrame f;
    JButton enter;
    JLabel event,name,pwd;
    TextField n,p;
    JPanel p1,p2,p3,p4;
    public static void main(String args[])
    {
        new First();
    }

    public First()
    {
         LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                   UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
        info=new String[9];
        info=getdata();
        event=new JLabel(info[0]);
        name=new JLabel("Username");
        pwd=new JLabel("Password");
        n=new TextField("",20);
        p=new TextField("",20);
        p.setEchoChar('$');
        enter=new JButton(new ImageIcon("MainIcon/enter.png"));
        enter.setActionCommand("enter");
        p1=new JPanel();
        p2=new JPanel(new GridLayout(2,2,100,100));
        p3=new JPanel();
        event.setFont(new Font("sansserif", Font.PLAIN,45));
        p1.add(event);
        p2.add(name);
        p2.add(n);
        p2.add(pwd);
        p2.add(p);
        p3.add(enter);
        f=new JFrame("Gates '10");
        f.setLayout(new BorderLayout());
        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.add(p3,BorderLayout.SOUTH);
        enter.addActionListener(this);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {System.exit(0);}});
        f.setLocation(400,200);
        f.setSize(400,300);
        f.setVisible(true);
    }

    public String[] getdata()
    {
        String in[]=new String[9];
        String data=null;
        int c=0;
        try
        {
            BufferedReader b=new BufferedReader(new FileReader("Files/info.txt"));
            data=b.readLine();
            while(data!=null)
            {
                in[c]=data;
                c++;
                data=b.readLine();
            }
            b.close();
        }catch(Exception e){}
        return in;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("enter"))
        {
            if((n.getText().equalsIgnoreCase(info[1]))&&(p.getText().equals(info[2])))
            {
                f.setVisible(false);
                new Second(info);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Oops Incorrect Username or Password","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
