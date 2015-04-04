package jframebackground;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.FlowLayout;

public class PutImageOnJFrame extends JPanel
{
    public PutImageOnJFrame()
    {
        setOpaque(false);
        setLayout(new FlowLayout());

    }

    public void paint(Graphics g)
    {              
        Image a=Toolkit.getDefaultToolkit().getImage("bg.jpg");
        g.drawImage(a,0,0,getSize().width,getSize().height,this);
        //g.drawImage(a,0,0,a.getWidth(this),a.getHeight(this), this);
        super.paint(g);
    }
}
