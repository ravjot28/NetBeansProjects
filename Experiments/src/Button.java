import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Button extends JFrame implements ActionListener
{
    public static void main(String as[])
    {
        new Button();
    }

    Button()
    {
        JFrame f=new JFrame("Rav");
        JButton b=new JButton("Rav");
        b.setSize(30,30);
        f.setLayout(new BorderLayout());
        f.add(new JPanel(),BorderLayout.NORTH);
        f.add(new JPanel(),BorderLayout.SOUTH);
        f.add(new JPanel(),BorderLayout.EAST);
        f.add(new JPanel(),BorderLayout.WEST);
        f.add(b,BorderLayout.CENTER);
        f.setSize(30,30);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {

    }

}
