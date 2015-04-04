import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseInput extends Core implements KeyListener,MouseMotionListener,MouseListener,MouseWheelListener
{
    private String mess="";
    public static void main(String s[])
    {
        new MouseInput().run();
    }

    public void init()
    {
        super.init();
        Window w=s.getFullScreenWindow();
        w.addMouseListener(this);
        w.addMouseMotionListener(this);
        w.addMouseWheelListener(this);
        w.addKeyListener(this);
    }

    public synchronized void draw(Graphics2D g)
    {
        Window w=s.getFullScreenWindow();
        g.setColor(w.getBackground());
        g.fillRect(0,0,s.getWidth(),s.getHeight());
        g.setColor(w.getForeground());
        g.drawString(mess,178,180);
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

    public void mouseDragged(MouseEvent me)
    {
        mess="You are dragging the mouse";
    }

    public void mouseMoved(MouseEvent me)
    {
        mess="You are moving the mouse";
    }

    public void mouseClicked(MouseEvent me)
    {
        
    }

    public void mousePressed(MouseEvent me)
    {
        mess="You Pressed down the mouse";
    }

    public void mouseReleased(MouseEvent me)
    {
        mess="You Released the mouse";
    }

    public void mouseEntered(MouseEvent me) 
    {
        
    }

    public void mouseExited(MouseEvent me) 
    {
        
    }

    public void mouseWheelMoved(MouseWheelEvent mwe)
    {
        mess="You are moving the mouse wheel";
    }
}
