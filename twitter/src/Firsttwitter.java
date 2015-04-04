import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
public class Firsttwitter extends JFrame implements ActionListener
{
    JButton save,reset;
    TextField uname,pwd;
    JLabel u,p,head;
    JPanel p1,p2,p3,p4,p5,p6;
    JFrame f;
    public static void main(String args[])
    {
        new Firsttwitter();
    }

    public Firsttwitter(int a)
    {
        if(a==0)
        {
            create();
        }
    }

    public Firsttwitter()
    {
        try
        {
            int count=0;
            BufferedReader b=new BufferedReader(new FileReader("Bin/UserInfo/infotwitter.ravs"));
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

                    String add[]=new String[2];
                    String u=null;
                    String p=null;
                try
                {
                
                testingtwitter t=new testingtwitter("Bin/UserInfo/infotwitter.ravs");
                String ravsss=t.send();
                StringTokenizer r=new StringTokenizer(ravsss,"\n");

                int cc=0;
                while(r.hasMoreTokens())
                {
                    add[cc]=r.nextToken();
                    if(cc==0)
                    {
                        u=add[cc];
                    }
                    else
                    {
                        p=add[cc];
                    }
                    cc++;
                }

            }catch(Exception e21){}
                new GUItwitter(u,p);
            }
        } catch (IOException ex)
        {
            create();
        }
    }

    public void create()
    {
       
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
        head=new JLabel("Welcome to Rav Twitter Application");
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
        f.setIconImage(new javax.swing.ImageIcon("R.gif").getImage());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("Save"))
        {
            try
            {
                BufferedWriter b1=new BufferedWriter(new FileWriter("Bin/UserInfo/infotwitter.ravs"));
                String u=uname.getText();
                String p=pwd.getText();
                String give=u+"\n"+p;
                new testingtwitter("Bin/UserInfo/infotwitter.ravs",give);
               // b1.append(u);
                //b1.newLine();
                //b1.append(p);
                //b1.close();
            }catch(Exception e21){}
            f.setVisible(false);
            new GUItwitter(uname.getText(),pwd.getText());
        }
        else
        {
            uname.setText(null);
            pwd.setText(null);
        }
    }
}
