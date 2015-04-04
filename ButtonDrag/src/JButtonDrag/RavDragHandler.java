package JButtonDrag;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RavDragHandler extends MouseMotionAdapter
{
    public void mouseDragged(MouseEvent e)
    {
        Component c = e.getComponent();
        c.setLocation(c.getX() + e.getX()-c.getWidth()/2,c.getY() + e.getY()-c.getHeight()/2);
       
        if ( c.getX()<0 )
        {
            c.setLocation(0,c.getY());
        }

        if ( c.getY()<0 )
        {
            c.setLocation(c.getX(),0);
        }

        if ( c.getX()+c.getWidth()>c.getParent().getWidth() )
        {
            c.setLocation(c.getParent().getWidth()-c.getWidth(),c.getY());
        }

        if ( c.getY()+c.getHeight()>c.getParent().getHeight() )
        {
            c.setLocation(c.getX(),c.getParent().getHeight()-c.getHeight());
        }
    }
}