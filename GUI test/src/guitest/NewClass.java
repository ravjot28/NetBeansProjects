/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package guitest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewClass extends JFrame
{
    public static void main(String args[])
    {
        JFrame f=new JFrame("Hello");
        f.setLayout(new GridLayout(3,1));
        JPanel p=new JPanel();
        JPanel p1=new JPanel();
        JPanel temp=p;
        JPanel temp1=p1;
        p.addMouseMotionListener(new MyMotionListener(temp));
        p1.addMouseMotionListener(new MyMotionListener(temp));
        JButton b=new JButton("Button 1");
        JButton b1=new JButton("Button 2");
        JButton b2=new JButton("Button 3");
        p.add(b);
        p1.add(b1);
       // f.add(b2);
        f.add(p);
        f.add(p1);
        f.setVisible(true);
    }

}

class MyMotionListener implements MouseMotionListener
{
	private JPanel movingPanel;
	private Point pt;
	public MyMotionListener (JPanel movingPanel) {
		this.movingPanel = movingPanel;
	}
	public void mouseDragged(MouseEvent e) {
		pt = SwingUtilities.convertPoint(movingPanel, e.getX(), e.getY(), movingPanel.getParent());
		movingPanel.setBounds(pt.x, pt.y, movingPanel.getWidth(), movingPanel.getHeight());
	}
	public void mouseMoved(MouseEvent e) {
	}
}