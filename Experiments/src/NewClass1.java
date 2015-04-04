import java.awt.*;
import javax.swing.*;
public class NewClass1 extends JFrame
{
    public static void main(String args[])
    {
        JFrame f=new JFrame("helo");
        f.setLayout(new GridLayout(2,2));
        JRadioButton r1,r2,r3,r4;
        String s1="Heelo all i am ravjot nice to meet you wat are you trying to do dont you know i am the best person on earth and hows your life going and say namaste to uncle aunty chacha chahi and aal is welllss";
        String s2=s1.substring(0,100);
        String s3=s1.substring(50);
        String s4="<html>"+s2+s3+"</html>";
        r1=new JRadioButton(s4);
        r2=new JRadioButton(s4);
        r3=new JRadioButton(s4);
        r4=new JRadioButton(s4);
        f.add(r1);
        f.add(r2);
        f.add(r3);
        f.add(r4);
        f.pack();
        f.setVisible(true);
    }
}
