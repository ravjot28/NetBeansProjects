import DragUndecoratedJFrame.RavDragUndecoratedJFrame;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class Main
{
    public static void main(String ar[])
    {
        JFrame f = new JFrame("Hi");
        NewJPanel p = new NewJPanel();
        
        f.setLayout(new FlowLayout());
       
        f.add(p);
        f.setUndecorated(true);
        RavDragUndecoratedJFrame m =new RavDragUndecoratedJFrame(p,f);
        p.addMouseListener(m);
        p.addMouseMotionListener(m);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
