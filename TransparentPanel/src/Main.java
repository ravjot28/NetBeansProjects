import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame
{
    public static void main(String s[])
    {
        new Main();
    }

    Main()
    {
        JTransparentPanel p=new JTransparentPanel();
        JTransparentPanel p1=new JTransparentPanel();
        JTransparentPanel p2=new JTransparentPanel();
        JButton b=new JButton("Hello");
        JLabel l=new JLabel("Hi All");
        JTextField t=new JTextField(30);
        p.add(b);
        p1.add(l);
        p2.add(t);
        p.show();
        p2.show();
        p1.show();
    }
}
