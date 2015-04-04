import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class ImagePanel extends JFrame
{
    Image img;
    ImagePanel(String s)
    {
        super(s);
        img = Toolkit.getDefaultToolkit().createImage("b:\\aditi.jpg");

    }
    public void paint(Graphics g)
    {
        // Draws the img to the BackgroundPanel.
        g.drawImage(img, 0, 0, null);
    }

    public static void main(String sd[])
    {
        new ImagePanel("Hi").setVisible(true);
    }
}
