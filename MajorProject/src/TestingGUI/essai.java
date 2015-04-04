package TestingGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;


public class essai
{
   public static void main(String[] argv)
   {
        // Determine if page flipping is supported
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        BufferCapabilities bufCap = gc.getBufferCapabilities();
        boolean page = bufCap.isPageFlipping();

        if (page)
        {
            System.out.println("Page flipping");
        }
        else
        {
            // Page flipping is not supported
            System.out.println("Page flipping Not Supported");
        }

        // Create a window for full-screen mode
        Frame frame = new Frame(gd.getDefaultConfiguration());
        Window win = new Window(frame);

        // Configure the window so that a mouse click will exit full-screen mode
        win.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent evt)
            {
                // Exit full-screen mode
                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice();
                        gd.setFullScreenWindow(null);
            }
        });

        try
        {
            // Enter full-screen mode
            gd.setFullScreenWindow(win);
            win.requestFocus();
            DisplayMode[] affichages = gd.getDisplayModes();
            int i;
            for(i=0;i<affichages.length;i++)
            {
                if((affichages[i].getWidth()==1280)&&(affichages[i].getHeight()==1024)&&(affichages[i].getBitDepth()==32)&&(affichages[i].getRefreshRate()==70))
                {
                    gd.setDisplayMode(affichages[i]);
                }
                //String s = i+" -> "+affichages[i].getWidth()+"X"+affichages[i].getHeight()+", BPP : "+affichages[i].getBitDepth()+" @ "+affichages[i].getRefreshRate();
                //g.drawString(s,((int)(i/50))*200+20,(i%50)*20+20);
            }
            // Create the back buffer
            int numBuffers = 2;  // Includes front buffer
            win.createBufferStrategy(numBuffers);

            // Determine the state of a back buffer after it has been displayed on the screen.
            // This information is used to optimize performance. For example, if your application
            // needs to initialize a back buffer with a background color, there is
            // no need to do so if the flip contents is BACKGROUND.
            BufferStrategy strategy = win.getBufferStrategy();
            bufCap = strategy.getCapabilities();
            BufferCapabilities.FlipContents flipContents = bufCap.getFlipContents();
            if (flipContents.equals(BufferCapabilities.FlipContents.UNDEFINED))
            {
                // The contents is unknown after a flip
            }
            else
                if (flipContents.equals(BufferCapabilities.FlipContents.BACKGROUND))
                {
                    // The contents cleared to the component's background color after a flip
                }
                else
                    if (flipContents.equals(BufferCapabilities.FlipContents.PRIOR))
                    {
                        // The contents is the contents of the front buffer just before the flip
                    }
                    else
                        if (flipContents.equals(BufferCapabilities.FlipContents.COPIED))
                        {
                            // The contents is identical to the contents just pushed to the
                            // front buffer after a flip
                        }

            int screenWidth = win.getWidth();
            int screenHeight = win.getHeight();
            int frames=0;
            int j;


            // Draw loop
            while (true)
            {
                // Get screen size
                // Get graphics context for drawing to the window
                Graphics g = strategy.getDrawGraphics();

                if (!flipContents.equals(BufferCapabilities.FlipContents.BACKGROUND))
                {
                    // Clear background
                    g.setColor(Color.white);
                    g.fillRect(0, 0, screenWidth, screenHeight);
                }
                frames++;
                g.setColor(Color.black);
                g.fillRect(0,0,1280,1024);
                String s = "frame Number "+frames;
                g.setColor(Color.red);
                g.drawString(s,20,20);
                /*
                    for(i=50;i<500;i++)
                    {
                        for(j=50;j<500;j++)
                        {
                            //g.drawString(s,i,j);
                            //g.setColor(Color.red);
                            g.drawLine(i,j,i+15,j+20);
                        }
                    }
                */
                //         g.drawImage(offscreen,0,0,null);
                // Draw shapes and images...

                // Done drawing
                g.dispose();

                // Flip the back buffer to the screen
                strategy.show();
            }
        } catch (Throwable e) {
        // Process exception...
        } finally {
        gd.setFullScreenWindow(null);
        }
    }
}