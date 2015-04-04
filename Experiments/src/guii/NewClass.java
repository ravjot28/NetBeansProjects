package guii;
import java.awt.*;
import javax.swing.*;
public class NewClass extends JFrame
{
    JFrame f;
    JButton prev,next,submit,finish;
    JRadioButton r1,r2,r3,r4;
    ButtonGroup bg;
    JTextField t;
    TextArea ta;
    JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12;
    public static void main(String args[])
    {
        new NewClass();
    }

    public NewClass()
    {
        f=new JFrame();
        r1=new JRadioButton("1");
        r2=new JRadioButton("2");
        r3=new JRadioButton("3");
        r4=new JRadioButton("4");
        ta=new TextArea("Hiiii this the first ques",5,50,TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setFont(new Font("sansserif", Font.PLAIN,25));
        f.setLayout(new BorderLayout());
        p1=new JPanel(new GridLayout(2,2,360,0));
        p7=new JPanel(new GridLayout(1,3));
        p2=new JPanel();
        p1.add(r1);
        p1.add(r2);
        p1.add(r3);
        p1.add(r4);
        p2.add(ta);
        p7.add(new JPanel());
        p7.add(p1);
        p7.add(new JPanel());
        p3=new JPanel(new GridLayout(1,4,100,100));
        prev=new JButton("Previous");
        next=new JButton("Next");
        submit=new JButton("Submit");
        finish=new JButton("End");
        p3.add(prev);
        p3.add(submit);
        p3.add(next);
        p3.add(finish);
        p4=new JPanel(new BorderLayout());
        p4.add(p2,BorderLayout.NORTH);
        p4.add(p7,BorderLayout.CENTER);
        p4.add(p3,BorderLayout.SOUTH);
        p5=new JPanel(new BorderLayout());
        t=new JTextField(5);
        p5.add(t,BorderLayout.EAST);
        p6=new JPanel(new BorderLayout());
        p6.add(p5,BorderLayout.NORTH);
        p6.add(p4,BorderLayout.CENTER);
        p8=new JPanel(new BorderLayout());
        JLabel l1=new JLabel("SQL MANIA");
        p8.add(l1,BorderLayout.CENTER);
        p9=new JPanel(new BorderLayout());
        p10=new JPanel(new GridLayout(3,1));
        JLabel l=new JLabel("Made By:Ravjot Singh");
        JLabel l2=new JLabel("ravjot28@gmail.com");
        JLabel l3=new JLabel("9540140052");
        l.setFont(new Font("sansserif", Font.PLAIN,25));
        l1.setFont(new Font("sansserif", Font.PLAIN,35));
        l2.setFont(new Font("sansserif", Font.PLAIN,25));
        l3.setFont(new Font("sansserif", Font.PLAIN,25));
        p10.add(l);
        p10.add(l2);
        p10.add(l3);
        p9.add(p10,BorderLayout.EAST);
        p11=new JPanel(new GridLayout(10,1));
        JButton b1=new JButton("1");
        JButton b2=new JButton("1");
        JButton b3=new JButton("1");
        JButton b4=new JButton("1");
        JButton b5=new JButton("1");
        JButton b6=new JButton("1");
        JButton b7=new JButton("1");
        JButton b8=new JButton("1");
        JButton b9=new JButton("1");
        JButton b10=new JButton("1");
        f.add(p6,BorderLayout.CENTER);
        p11.add(b1);
        p11.add(b2);
        p11.add(b3);
        p11.add(b4);
        p11.add(b5);
        p11.add(b6);
        p11.add(b7);
        p11.add(b8);
        p11.add(b9);
        p11.add(b10);
        p11.setSize(100,20);
        p12=new JPanel(new BorderLayout());
        f.add(p8,BorderLayout.NORTH);
        f.add(p9,BorderLayout.SOUTH);
        f.add(p11,BorderLayout.EAST);
        f.setUndecorated(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        f.setSize(((int) tk.getScreenSize().getWidth()), ((int) tk.getScreenSize().getHeight()));
        f.setVisible(true);
    }

}
