import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTest extends Core implements KeyListener
{
    private String mess="";

    public static void main(String a[])
    {
        new KeyTest().run();
    }

    public void init()
    {
        super.init();
        Window w=s.getFullScreenWindow();
        w.setFocusTraversalKeysEnabled(false);
        w.addKeyListener(this);
        mess="Press Esc to Exit";
    }

    @Override
    public synchronized void draw(Graphics2D g)
    {
        Window w=s.getFullScreenWindow();
        g.setColor(w.getBackground());
        g.fillRect(0,0,s.getWidth(),s.getHeight());
        g.setColor(w.getForeground());
        g.drawString(mess,187 ,180 );
    }

    public void keyTyped(KeyEvent ke)
    {
            ke.consume();
    }

    public void keyPressed(KeyEvent ke)
    {
        int keyCode=ke.getKeyCode();
        if(keyCode==KeyEvent.VK_ESCAPE)
        {
            stop();
        }
        else
        {
            mess="Pressed :"+KeyEvent.getKeyText(keyCode);
            ke.consume();
        }
    }

    public void keyReleased(KeyEvent ke)
    {
        int keyCode=ke.getKeyCode();
        mess="Released :"+KeyEvent.getKeyText(keyCode);
        ke.consume();
    }
    
}
