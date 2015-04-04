package slidenotestaskbar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class TestSlideInNotification implements MouseListener
{
    public static void main(String a[])
    {
        new TestSlideInNotification();
    }

    TestSlideInNotification()
    {
        /*Icon errorIcon = UIManager.getIcon("OptionPane.errorIcon");
        JLabel label = new JLabel("Test My application which will slide out from taskbar",errorIcon,SwingConstants.LEFT);
        label.addMouseListener(this);*/
        NewJPanel p = new NewJPanel();
        SlideInNotification slider = new SlideInNotification(p);
        slider.showAt(450);
    }

    public void mouseClicked(MouseEvent e) {
        System.exit(0);
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
