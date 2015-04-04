/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestGUI;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

class Reflect extends JButton
{

    private BufferedImage image;

    public Reflect(String img)
    {
        try
        {
            image = ImageIO.read( new File(img) );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    public void paintComponent( Graphics g )
    {
        Graphics2D g2d = (Graphics2D)g;
        int width = getWidth();
        int height = getHeight();
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        int gap = 20;
        float opacity = 0.4f;
        float fadeHeight = 0.3f;

        g2d.setPaint( new GradientPaint( 0, 0, Color.DARK_GRAY, 0, height, Color.DARK_GRAY ) );
        g2d.fillRect( 0, 0, width, height );
        g2d.translate( (width-imageWidth)/2, height/2-imageHeight );
        g2d.drawRenderedImage( image, null );
        g2d.translate( 0, 2*imageHeight+gap );
        g2d.scale( 1, -1 );

        BufferedImage reflection = new BufferedImage( imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB );
		Graphics2D rg = reflection.createGraphics();
        rg.drawRenderedImage( image, null );
		rg.setComposite( AlphaComposite.getInstance( AlphaComposite.DST_IN ) );
        rg.setPaint(
            new GradientPaint(
                0, imageHeight*fadeHeight, new Color( 0.0f, 0.0f, 0.0f, 0.0f ),
                0, imageHeight, new Color( 0.0f, 0.0f, 0.0f, opacity )
            )
        );
        rg.fillRect( 0, 0, imageWidth, imageHeight );
        rg.dispose();
        g2d.drawRenderedImage( reflection, null );
    }

    public Dimension getPreferredSize()
    {
        return new Dimension( 100, 100 );
    }

    public static void main(String sadp[])
    {
        JFrame f = new JFrame("as");
        f.add(new Reflect("r.gif"));
        f.setSize(100,100);
        f.setVisible(true);
    }
}