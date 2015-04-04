import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;
import javax.swing.*;

public class GUIMail implements ActionListener
{
    String ss[];
    String result;
    sendingMail s1;
    private Frame f;
    JFrame fplz;
    private Button b1,b2,b3;
    private TextField to,sub;
    private TextArea body;
    private Label l3,l4;
    private Panel p1,p2,p3,p4,p5,p6;
    JPanel rav;
    JLabel  lab;
    public GUIMail()
    {
            f = new Frame("Send Mail");
            f.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e) {
                    actionExit();
                }
            });
            to = new TextField(70);
            sub = new TextField(30);
            body = new TextArea(30, 100);
            b1 = new Button("Send");
            b2 = new Button("Reset");
            b3=new Button("Change id");
            l3 = new Label("To *   ");
            l4 = new Label("Sub *");
            p1 = new Panel();
            p2 = new Panel();
            p3 = new Panel();
            p4 = new Panel();
            p5 = new Panel();
            rav=new JPanel(new BorderLayout());
            p6 = new Panel(new GridLayout(3, 1));
            try
            {


            launch();
        } catch (Exception ex) {        }
    }

     public int getNumberOfLines(String name) {
		int numberOfLines = 0;



		LineNumberReader lineCounter = null;
		try {
			lineCounter = new LineNumberReader(new FileReader(name));
			while ((lineCounter.readLine()) != null) {
				continue;
			}
			numberOfLines = lineCounter.getLineNumber();

		} catch (IOException e)
                {
		}

		return numberOfLines;
	}

    public void launch() throws Exception
    {
         LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception e) {
                    }
        f.setLayout(new BorderLayout());
        p2.add(l3);
        p2.add(to);
        p3.add(l4);
        p3.add(sub);
        p4.add(body);
        p5.add(b1);
        p5.add(b2);
        p5.add(b3);
        p6.add(p1);
        p6.add(p2);
        p6.add(p3);
        JButton b4=new JButton("Attachement");
        b4.addActionListener(this);
        p1.add(b4);
        JPanel pp=new JPanel();
        lab=new JLabel("Status..");
        pp.add(lab);
        rav.add(p6,BorderLayout.NORTH);
        rav.add(pp,BorderLayout.CENTER);
        rav.add(p1,BorderLayout.SOUTH);
        f.add(rav,BorderLayout.NORTH);
        f.add(p4,BorderLayout.CENTER);
        f.add(p5,BorderLayout.SOUTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    private void actionExit()
    {
        f.setVisible(false);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Send"))
        {
            ss=new String[getNumberOfLines("attachment.ravs")];
                    String data1=null;
                    try
                    {
                        BufferedReader bbb=new BufferedReader(new FileReader("attachment.ravs"));
                        data1=bbb.readLine();
                    for(int i=0;i<getNumberOfLines("attachment.ravs");i++)
                    {
                        ss[i]=data1;
                        data1=bbb.readLine();
                        JOptionPane.showMessageDialog(null,ss[i],"Hi",JOptionPane.INFORMATION_MESSAGE);
                    }
                        bbb.close();
                    }catch(Exception bf){}
                     String add[]=new String[2];
            String uu="";
                String pp="";
             try
            {
                int c=0;
                BufferedReader b=new BufferedReader(new FileReader("Bin/UserInfo/infoMail.ravs"));
                testingMail t=new testingMail("Bin/UserInfo/infoMail.ravs");
                String ravsss=t.send();
                StringTokenizer r=new StringTokenizer(ravsss,"\n");

                int cc=0;
                while(r.hasMoreTokens())
                {
                    add[cc]=r.nextToken();
                    cc++;
                }
                /*String data=b.readLine();
                while(data!=null)
                {
                    if(c==0)
                    {
                            uu=data;
                        c++;
                    }
                    else
                    {
                        pp=data;
                    }
                    data=b.readLine();
                }

                b.close();*/
            }catch(Exception e21){}
           String fr=add[0];
           String p=add[1];
           String s=sub.getText();
           String b=body.getText();
           b=b+"\n\n\n\n                                                                                "+"Rav Softs. Presentation";
           StringTokenizer st1=new StringTokenizer(to.getText(),",");
           String[] t=new String[st1.countTokens()];
           int i=0;
           while(st1.hasMoreTokens())
           {
               t[i]=st1.nextToken();
               i++;
           }
           lab.setBackground(Color.yellow);
           f.setVisible(false);

                s1=new sendingMail(fr,b,s,t,p,ss);
           
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           result=s1.send();
            }
        });
            try
        {
            BufferedWriter ba=new BufferedWriter(new FileWriter("att.ravs"));
            BufferedWriter ba1=new BufferedWriter(new FileWriter("attachment.ravs"));
            ba.append("");
            ba1.append("");
            ba.close();
            ba1.close();
        }catch(Exception ada){}
           fplz.setVisible(false);
           JOptionPane.showMessageDialog(null, result,"Alert",JOptionPane.INFORMATION_MESSAGE);
           if(result.equals("Your message is successfully mailed"))
           {
               f.setVisible(false);
               new GUIMail();
           }
        }
        else
            if(ae.getActionCommand().equalsIgnoreCase("Change id"))
            {
                f.setVisible(false);
                new FirstMail(0);
            }
            else
                if(ae.getActionCommand().equalsIgnoreCase("attachement"))
                {
                    new attachementMail();
                    
                }
        else
        {
            to.setText("");
            sub.setText("");
            body.setText("");
        }
    }

    class plz
    {
        plz()
        {
           fplz=new JFrame("Alert");
            JLabel l=new JLabel("Please wait while mail is in process.....");
            fplz.add(l);
            fplz.setLocationRelativeTo(null);
            fplz.pack();
            fplz.setVisible(true);
        }
    }



}
