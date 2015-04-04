package Support;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Dissolver extends JComponent implements Runnable
{
    Frame frame;
    Window fullscreen;
    int count;
    BufferedImage frame_buffer;
    BufferedImage screen_buffer;

    public Dissolver()
    {

    }

    public void dissolveExit(JFrame frame)
    {
        try
        {
            this.frame = frame;
            Robot robot = new Robot();
            
            Rectangle frame_rect = frame.getBounds();
            frame_buffer = robot.createScreenCapture(frame_rect);

            frame.setVisible(false);

            Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

            Rectangle screen_rect = new Rectangle(0,0,screensize.width,screensize.height);
            screen_buffer = robot.createScreenCapture(screen_rect);

            fullscreen = new Window(new JFrame());
            fullscreen.setSize(screensize);
            fullscreen.add(this);
            this.setSize(screensize);
            fullscreen.setVisible(true);

            new Thread(this).start();
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public void run()
    {
        try
        {
            count = 0;
            Thread.currentThread().sleep(100);
            for(int i=0;i<20;i++)
            {
                count = i;
                fullscreen.repaint();
                Thread.currentThread().sleep(100);
            }
        }catch(InterruptedException ex)
        {
            System.exit(0);
        }
        try
        {
            Thread.currentThread().sleep(50);
            System.exit(0);
        }catch(Exception ae){}
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g.drawImage(screen_buffer,-fullscreen.getX(), -fullscreen.getY(),null);

        Composite old_comp = g2.getComposite();
        Composite fade = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f - ((float)count)/20f);
        g2.setComposite(fade);
        g2.drawImage(frame_buffer, frame.getX(),frame.getY(),null);
        g2.setComposite(old_comp);
    }
}
