import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import javax.swing.*;

public class GUI implements ActionListener
{
    private Frame f;
    private Button b1,b2,b3;
    private TextField to,sub;
    private TextArea body;
    private Label l3,l4;
    private Panel p1,p2,p3,p4,p5,p6;
    JPanel rav;
    public GUI()
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
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void launch() throws Exception
    {
         LookAndFeel lf = UIManager.getLookAndFeel();
               try
               {
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
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
        p1.add(new JPanel());
        rav.add(p6,BorderLayout.CENTER);
        rav.add(p1,BorderLayout.SOUTH);
        f.add(p6,BorderLayout.NORTH);
        f.add(p4,BorderLayout.CENTER);
        f.add(p5,BorderLayout.SOUTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        f.pack();
        f.setVisible(true);
    }
    private void actionExit()
    {
        System.exit(0);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Send"))
        {
            String add[]=new String[2];
            String uu="";
                String pp="";
             try
            {
                int c=0;
                BufferedReader b=new BufferedReader(new FileReader("Bin/UserInfo/info.ravs"));
                testing t=new testing("Bin/UserInfo/info.ravs");
                String ravsss=t.send();
                StringTokenizer r=new StringTokenizer(ravsss,"\n");
                
                int cc=0;
                while(r.hasMoreTokens())
                {
                    add[cc]=r.nextToken();
                    cc++;
                }
               /* String data=b.readLine();
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
           sending s1=new sending(fr,b,s,t,p);
           String result=s1.send();
           JOptionPane.showMessageDialog(null, result,"Alert",JOptionPane.INFORMATION_MESSAGE);
           if(result.equals("Your message is successfully mailed"))
           {
               f.setVisible(false);
               new GUI();
           }
        }
        else
            if(ae.getActionCommand().equalsIgnoreCase("Change id"))
            {
                f.setVisible(false);
                new First(0);
            }
        else
        {
            to.setText("");
            sub.setText("");
            body.setText("");
        }
    }

    

}
