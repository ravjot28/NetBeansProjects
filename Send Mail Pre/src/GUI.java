import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GUI implements ActionListener
{
    private Frame f;
    private Button b1,b2;
    private TextField from,to,pwd,sub;
    private TextArea body;
    private Label l1,l2,l3,l4,l5;
    private Panel p1,p2,p3,p4,p5,p6;
    public GUI()
    {
        f=new Frame("Send Mail");
        f.addWindowListener(new WindowAdapter()
        {      public void windowClosing(WindowEvent e) {        actionExit();      }    });

        from=new TextField(30);
        pwd=new TextField(30);
        pwd.setEchoChar('*');
        to=new TextField(30);
        sub=new TextField(30);
        body=new TextArea(30,100);
        b1=new Button("Send");
        b2=new Button("Reset");
        l1=new Label("From (ID) *");
        l2=new Label("Password *");
        l3=new Label("To *");
        l4=new Label("Sub *");
        l5=new Label("Body");
        p1=new Panel();
        p2=new Panel();
        p3=new Panel();
        p4=new Panel();
        p5=new Panel();
        p6=new Panel(new GridLayout(3,1));
    }

    public void launch() throws Exception
    {
        f.setLayout(new BorderLayout());
        p1.add(l1);
        p1.add(from);
        p1.add(l2);
        p1.add(pwd);
        p2.add(l3);
        p2.add(to);
        p3.add(l4);
        p3.add(sub);
        p4.add(body);
        p5.add(b1);
        p5.add(b2);
        p6.add(p1);
        p6.add(p2);
        p6.add(p3);
        f.add(p6,BorderLayout.NORTH);
        f.add(p4,BorderLayout.CENTER);
        f.add(p5,BorderLayout.SOUTH);
        b1.addActionListener(this);
        b2.addActionListener(this);
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
           String fr=from.getText();
           String p=pwd.getText();
           String s=sub.getText();
           String b=body.getText();
           StringTokenizer st1=new StringTokenizer(to.getText(),",");
           String[] t=new String[st1.countTokens()];
           int i=0;
           while(st1.hasMoreTokens())
           {
               t[i]=st1.nextToken();
               i++;
           }
           System.out.println("Sending the data to sending class--->");
           sending s1=new sending(fr,b,s,t,p);
           String result=s1.send();
           JOptionPane.showMessageDialog(null, result,"Alert",JOptionPane.INFORMATION_MESSAGE);
           if(result.equals("Your message is successfully mailed"))
           {
               f.setVisible(false);
               GUI a=new GUI();
                try {
                    a.launch();
                } catch (Exception ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
        }
        else
        {
            from.setText("");
            pwd.setText("");
            to.setText("");
            sub.setText("");
            body.setText("");
        }
    }

    public static void main(String args[]) throws Exception
    {
        GUI a=new GUI();
        a.launch();
    }


}
