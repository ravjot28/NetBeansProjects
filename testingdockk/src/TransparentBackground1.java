import java.awt.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;

/* left to do
   listen to window focused (gained and lost) events
   listen for window uniconified event
*/

public class TransparentBackground1 extends JComponent
        implements ComponentListener, WindowFocusListener,
        Runnable {
    private JFrame frame;
    protected Image background;
    private long lastupdate = 0;
    public boolean refreshRequested = true;

    public TransparentBackground1(JFrame frame) {
        this.frame = frame;
        updateBackground();
        frame.addComponentListener(this);
        frame.addWindowFocusListener(this);
        new Thread(this).start();
    }

    public void updateBackground() {
        try {
            Robot rbt = new Robot();
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension dim = tk.getScreenSize();
            background = rbt.createScreenCapture(
                new Rectangle(0,0,(int)dim.getWidth(),(int)dim.getHeight()));
        } catch (Exception ex) {
            p(ex.toString());
            ex.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        Point pos = this.getLocationOnScreen();
        Point offset = new Point(-pos.x,-pos.y);
        g.drawImage(background,offset.x,offset.y,null);
    }


    public  void componentShown(ComponentEvent evt) { repaint(); }
    public  void componentResized(ComponentEvent evt) { repaint(); }
    public  void componentMoved(ComponentEvent evt) { repaint(); }
    public  void componentHidden(ComponentEvent evt) { }

    public void windowGainedFocus(WindowEvent evt) { refresh(); }
    public void windowLostFocus(WindowEvent evt) { refresh(); }

    public void refresh() {
       if(this.isVisible() && frame.isVisible()) {
            repaint();
            refreshRequested = true;
            lastupdate = new Date().getTime();
        }
    }

/*
    private boolean recurse = false;
    public void quickRefresh() {
        p("quick refresh");
        long now = new Date().getTime();
        if(recurse ||
           ((now - lastupdate) < 1000)) { return; }

        recurse = true;
        Point location = frame.getLocation();
        frame.hide();
        updateBackground();
        frame.show();
        frame.setLocation(location);
        repaint();
        recurse = false;
        lastupdate = now;
    }
    */

    public void run() {
        try {
            while(true) {
                Thread.sleep(250);
                long now = new Date().getTime();
                if(refreshRequested &&
                   ((now - lastupdate) > 1000)) {
                    if(frame.isVisible()) {
                        Point location = frame.getLocation();
                        frame.hide();
                        updateBackground();
                        frame.show();
                        frame.setLocation(location);
                        refresh();
                    }
                    lastupdate = now;
                    refreshRequested = false;
                }
            }
        } catch (Exception ex) {
            p(ex.toString());
            ex.printStackTrace();
        }
    }


    public static void p(String str) {
        System.out.println(str);
    }

    public static void main(String arp[])
    {
        JFrame f=new JFrame("Rav");
        TransparentBackground1 b=new TransparentBackground1(f);
        f.add(b);
        f.add(new JPanel(),BorderLayout.SOUTH);
        f.add(new JPanel(),BorderLayout.CENTER);
        f.add(new JPanel(),BorderLayout.NORTH);
        f.add(new JPanel(),BorderLayout.EAST);
        f.add(new JPanel(),BorderLayout.WEST);
        f.pack();
        f.setVisible(true);

    }

}