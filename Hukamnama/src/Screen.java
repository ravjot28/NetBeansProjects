import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Screen
{
    private GraphicsDevice vc;

    public Screen()
    {
        GraphicsEnvironment env=GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc=env.getDefaultScreenDevice();
    }

    public void setFullScreen(DisplayMode dm,JFrame window)
    {
        window.setUndecorated(true);
        window.setResizable(false);
        window.addKeyListener(new KeyListener(){

            public void keyTyped(KeyEvent ke) {
            }

            public void keyPressed(KeyEvent ke) {
                int key = ke.getKeyCode();
                if(key==KeyEvent.VK_ESCAPE)
                {
                    restoreWindow();
                }
            }

            public void keyReleased(KeyEvent ke) {
            }
        });
        vc.setFullScreenWindow(window);
        if(dm!=null && vc.isDisplayChangeSupported())
        {
            try
            {
                vc.setDisplayMode(dm);
            }catch(Exception s){}
        }
    }

    public Window getFullScreenWindow()
    {
        return vc.getFullScreenWindow();
    }

    public void restoreWindow()
    {
        Window w=vc.getFullScreenWindow();
        if(w!=null)
        {
            w.dispose();
        }
        vc.setFullScreenWindow(null);
    }
}
