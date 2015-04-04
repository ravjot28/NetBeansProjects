package Support;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class SpinDissolver extends Dissolver
{
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g.drawImage(screen_buffer,-fullscreen.getX(),-fullscreen.getY(),null);

        AffineTransform old_trans = g2.getTransform();

        g2.translate(frame.getX(),frame.getY());

        g2.translate(0,((count+1)*(frame.getX()+frame.getWidth())/20));

        float scale = 1f/((float)count+1);
        
        g2.scale(scale, scale);

        g2.rotate(((float)count)/3.14/1.3,frame.getWidth()/2,frame.getHeight()/2);

        g2.drawImage(frame_buffer,0,0,null);

        g2.setTransform(old_trans);
    }
}
