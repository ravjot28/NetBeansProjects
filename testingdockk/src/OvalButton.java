import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class OvalButton extends JFrame
{
    JFrame f;

    OvalButton()
    {
        f=new JFrame("Hi");
        XrButton xb = new XrButton(new ImageIcon("Bin\\img\\r.gif"));
        f.add(xb,BorderLayout.CENTER);
        f.add(new JPanel(),BorderLayout.SOUTH);
        f.add(new JPanel(),BorderLayout.NORTH);
        f.add(new JPanel(),BorderLayout.EAST);
        f.add(new JPanel(),BorderLayout.WEST);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String ds[])
    {
        new OvalButton();
    }
class XrButton extends JButton implements MouseListener
{
	String  text;
	boolean mouseIn = false;

public XrButton(ImageIcon s)
{
	super(s);
	setBorderPainted(false);
	addMouseListener(this);
	setContentAreaFilled(false);
}
public void paintComponent(Graphics g)
{
 	Graphics2D g2 = (Graphics2D)g;
	if (getModel().isPressed())
	{
		g.setColor(Color.pink);
		g2.fillRect(3,3,getWidth()-6,getHeight()-6);
	}
	super.paintComponent(g);

	if (mouseIn) g2.setColor(Color.red);
		else     g2.setColor(new Color(128,0,128));
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2.setStroke(new BasicStroke(1.2f));
	g2.draw(new RoundRectangle2D.Double(1,1,(getWidth()-3),
											(getHeight()-3),12,8));
	g2.setStroke(new BasicStroke(1.5f));
	g2.drawLine(4,getHeight()-3,getWidth()-4,getHeight()-3);

	g2.dispose();
}
public void mouseClicked(MouseEvent e){}
public void mouseEntered(MouseEvent e)
{
	mouseIn = true;
}
public void mouseExited(MouseEvent e)
{
	mouseIn = false;
}
public void mousePressed(MouseEvent e)
{
}
public void mouseReleased(MouseEvent e)
{
}
}
}