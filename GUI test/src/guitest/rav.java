

package guitest;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import javax.swing.JPanel;
class JTransparentPanel extends JPanel
{
public JTransparentPanel()
{
this(new FlowLayout());
}

public JTransparentPanel(LayoutManager lm)
{
super(lm);
setOpaque(false);
}


}

public class rav extends JFrame
{
    public static void main(String args[])
    {
        JTransparentPanel p=new JTransparentPanel(new GridLayout(1,2));
        JPanel p1=new JPanel();
        JButton b=new JButton("Button");
        JFrame f=new JFrame("HI");
        p.add(b);
        f.setBackground(Color.red);
        f.add(p);
        p1.add(b);
        f.add(p1); f.addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        System.exit(0);
                    }
        });
        f.setVisible(true);
    }
}