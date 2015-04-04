package guitest;
import java.awt.*;
import javax.swing.*;

class TransparentButton extends JButton {
        public TransparentButton(String text) {
            super(text);
            setOpaque(false);
        }

        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
            super.paint(g2);
            g2.dispose();
        }
}

public class ButtonTest extends JFrame
{
    public static void main(String args[])
    {
        JFrame f=new JFrame();
       
        TransparentButton b=new TransparentButton("Click Me");
        f.add(b);
        f.setVisible(true);
    }
}