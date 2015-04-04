import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class First extends JFrame implements ActionListener
{
    JButton save,reset;
    TextField uname,pwd;
    JLabel u,p,head;
    JPanel p1,p2,p3,p4,p5,p6;
    JFrame f;
    public static void main(String args[])
    {
        new First();
    }

    public First(int a)
    {
        if(a==0)
        {
            create();
        }
    }

    public First()
    {
        try
        {
            int count=0;
            BufferedReader b=new BufferedReader(new FileReader("Bin/UserInfo/info.ravs"));
            String data=b.readLine();
            while(data!=null)
            {
                count++;
                data=b.readLine();
            }
            b.close();
            if(count==0)
            {
                create();
            }
            else
            {
                new GUI();
            }
        } catch (IOException ex)
        {
            create();
        }
    }

    public void create()
    {
        LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                   // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
        f=new JFrame("User Information");
        f.setLayout(new BorderLayout());
         f.addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {        System.exit(0);      }    });

        save=new JButton("Save");
        reset=new JButton("Reset");
        uname=new TextField(30);
        pwd=new TextField(30);
        pwd.setEchoChar('*');
        u=new JLabel("Email Id");
        p=new JLabel("Password");
        head=new JLabel("Welcome to Rav Outlook");
        head.setFont(new Font("Palatino Linotype",Font.BOLD,20));
        p1=new JPanel();
        p1.add(save);
        p1.add(reset);
        p2=new JPanel(new GridLayout(2,1));
        p3=new JPanel(new GridLayout(1,2));
        p4=new JPanel(new GridLayout(1,2));
        p3.add(u);
        p3.add(uname);
        p4.add(p);
        p4.add(pwd);
        p2.add(p3);
        p2.add(p4);
        p5=new JPanel(new BorderLayout());
        p5.add(new JPanel(),BorderLayout.NORTH);
        p5.add(new JPanel(),BorderLayout.EAST);
        p5.add(new JPanel(),BorderLayout.WEST);
        p5.add(new JPanel(),BorderLayout.SOUTH);
        p6=new JPanel(new GridLayout(1,3));
        p6.add(new JPanel());
        p6.add(head);
        p6.add(new JPanel());
        p5.add(p6,BorderLayout.CENTER);
        f.add(p5,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.add(p1,BorderLayout.SOUTH);
        save.addActionListener(this);
        reset.addActionListener(this);
        f.pack();
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("Save"))
        {
            try
            {
                BufferedWriter b1=new BufferedWriter(new FileWriter("Bin/UserInfo/info.ravs"));
                String u=uname.getText();
                String p=pwd.getText();
                String give=u+"\n"+p;
                new testing("Bin/UserInfo/info.ravs",give);
                //b1.append(u);
                //b1.newLine();
                //b1.append(p);
                //b1.close();
            }catch(Exception e21){System.out.print(e21);}
            f.setVisible(false);
            new GUI();
        }
        else
        {
            
            uname.setText(null);
            pwd.setText(null);
        }
    }

}
