import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main
{
    TrayIcon trayIcon;
    final SystemTray tray = SystemTray.getSystemTray();
    public GraphicsDevice vc;
    Window w;

    Main()
    {
        GraphicsEnvironment env=GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc=env.getDefaultScreenDevice();
        w = new MainFrame();
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

    public static void main(String asp[])
    {
        new Main();
    }

    
}
