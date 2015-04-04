import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Images extends JFrame
{
    private Screen s;
    private Image bg;
    private Image pic;
    private boolean loaded;
    public static void main(String a[])
    {
        DisplayMode dm=new DisplayMode(800,600,32,DisplayMode.REFRESH_RATE_UNKNOWN);
        Images b=new Images();
        
        b.run(dm);
    }

    public void run(DisplayMode dm)
    {
        setBackground(Color.BLACK);
        setForeground(Color.BLACK);
        setFont(new Font("Arial",Font.BOLD,24));
        loaded=false;
        s=new Screen();
        try
        {
            s.setFullScreen(dm, this);
            loadpics();
            /*try
            {
                Thread.sleep(5000);
            }catch(Exception s1){}*/
            addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e)
            {
                int key =e.getKeyCode();
                if(key==KeyEvent.VK_ESCAPE)
                {
                    dispose();
                     s.restoreWindow();
                }

            }
        });
        }
        catch(Exception sd)
        {}
        finally
        {
            //s.restoreWindow();
        }
    }

    public void loadpics()
    {
        bg=new ImageIcon("bg.png").getImage();
        //pic=new ImageIcon("").getImage();
        loaded=true;
        repaint();
    }

    public void paint(Graphics g)
    {
        if(loaded)
        {
            g.drawImage(bg,0,100,null);
            //g.drawImage(pic,178,180,null);
        }
    }
}
