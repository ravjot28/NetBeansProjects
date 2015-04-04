package BookReading;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FullScreen
{
    public GraphicsDevice vc;
    Window w;

    FullScreen(String s)
    {
        GraphicsEnvironment env=GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc=env.getDefaultScreenDevice();
        w = new BookPanel(s);
        w.addMouseListener(new MouseListener()
                            {
                                public void mouseClicked(MouseEvent me)
                                {
                                    w.dispose();
                                }

                                public void mousePressed(MouseEvent me)
                                {

                                }

                                public void mouseReleased(MouseEvent me)
                                {

                                }

                                public void mouseEntered(MouseEvent me)
                                {

                                }

                                public void mouseExited(MouseEvent me)
                                {

                                }
                            });
        vc.setFullScreenWindow(w);
        w.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e)
            {
                int key =e.getKeyCode();
                if(key==KeyEvent.VK_ESCAPE)
                {
                    w.setVisible(false);
                }

            }
        });
        w.setVisible(true);
	//com.sun.awt.AWTUtilities.setWindowOpacity(w, 0.75f);
    }
}
