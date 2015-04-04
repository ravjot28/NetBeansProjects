package slidenotestaskbar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;

public class SlideInNotification extends Object
{
    protected static final int ANIMATION_TIME = 500;
    protected static final float ANIMATION_TIME_F = (float) ANIMATION_TIME;
    protected static final int ANIMATION_DELAY = 10;

    JWindow window;
    JComponent contents;
    AnimatingSheet animatingSheet;
    Rectangle desktopBounds;
    Dimension tempWindowSize;
    Timer animationTimer;
    int showX,startY;
    long animationStart;

    public SlideInNotification()
    {
        initDesktopBounds();
    }

    public SlideInNotification(JComponent contents)
    {
        this();
        setContents(contents);
    }

    protected void initDesktopBounds()
    {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        desktopBounds = env.getMaximumWindowBounds();
        System.out.println("Max Window Bounds = "+desktopBounds);
    }

    public void setContents(JComponent contents)
    {
        this.contents = contents;
        JWindow tempWindow = new JWindow();
        tempWindow.getContentPane().add(contents);
        tempWindow.pack();
        tempWindowSize = tempWindow.getSize();
        tempWindow.getContentPane().removeAll();
        window = new JWindow();
        animatingSheet = new AnimatingSheet();
        animatingSheet.setSource(contents);
        window.getContentPane().add(animatingSheet);
    }

    public void showAt(int x)
    {
        showX = x;
        startY = desktopBounds.y + desktopBounds.height;

        ActionListener animationLogic = new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent ae)
                                            {
                                                long elapsed = System.currentTimeMillis() - animationStart;

                                                if(elapsed>ANIMATION_TIME)
                                                {
                                                    window.getContentPane().removeAll();
                                                    window.getContentPane().add(contents);
                                                    window.pack();
                                                    window.setLocation(showX,startY-window.getSize().height);
                                                    window.setVisible(true);
                                                    window.repaint();
                                                    animationTimer.stop();
                                                    animationTimer = null;
                                                }
                                                else
                                                {
                                                    float progress = (float) elapsed/ANIMATION_TIME_F;
                                                    int animatingHeight = (int)(progress*tempWindowSize.getHeight());
                                                    animatingHeight = Math.max(animatingHeight,1);
                                                    animatingSheet.setAnimatingHeight(animatingHeight);
                                                    window.pack();
                                                    window.setLocation(showX,startY-window.getHeight());
                                                    window.setVisible(true);
                                                    window.repaint();
                                                }
                                            }
                                        };

         animationTimer = new Timer(ANIMATION_DELAY,animationLogic);
         animationStart = System.currentTimeMillis();
         animationTimer.start();
    }

    class AnimatingSheet extends JPanel
    {
        Dimension animatingSize = new Dimension(0,1);
        JComponent source;

        BufferedImage offscreenImage;

        public AnimatingSheet()
        {
            super();
            setOpaque(true);
        }

        public void setSource(JComponent source)
        {
            this.source = source;
            animatingSize.width = source.getWidth();
            makeOffScreenImage(source);
        }

        public void setAnimatingHeight(int height)
        {
            animatingSize.height = height;
            setSize(animatingSize);
        }

        private void makeOffScreenImage(JComponent source)
        {
            GraphicsConfiguration gfxConfig = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            offscreenImage = gfxConfig.createCompatibleImage(source.getWidth(), source.getHeight());
            Graphics2D offscreenGraphics = (Graphics2D) offscreenImage.getGraphics();
            offscreenGraphics.setColor(source.getBackground());
            offscreenGraphics.fillRect(0,0,source.getWidth(),source.getHeight());
            source.paint(offscreenGraphics);
        }

        public Dimension getPreferredSize()
        {
            return animatingSize;
        }

        public Dimension getMinimumSize()
        {
            return animatingSize;
        }

        public Dimension getMaximumSize()
        {
            return animatingSize;
        }

        public void update(Graphics g)
        {
            paint(g);
        }

        public void paint(Graphics g)
        {
            BufferedImage fragment = offscreenImage.getSubimage(0,0,source.getWidth(),animatingSize.height);
            g.drawImage(fragment,0,0,this);
        }
    }
}
