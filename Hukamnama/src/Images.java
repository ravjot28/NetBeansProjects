import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.util.*;
import java.net.URL;

public class Images extends JFrame
{
    private Screen s;
    private Image bg;
    private Image pic;
    private Image pic1;
    private boolean loaded=true;

    public final static String img="hukamnama/"+new Random().nextInt(50)+".jpg";
    public final static String welcome ="hukamnama/ggs.jpg";
    public final static String wel ="hukamnama/bh.gif";
    URL welcome1 = getClass().getClassLoader().getResource(welcome);
    URL wel1 = getClass().getClassLoader().getResource(wel);
    URL img1 = getClass().getClassLoader().getResource(img);

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
        loaded=true;
        s=new Screen();
        try
        {
            s.setFullScreen(dm, this);
            
            loadpics();
            loaded=true;
            repaint();
            try
            {
                Thread.sleep(5000);
            }catch(Exception s1){}
            loaded=false;
            repaint();
           /* try
            {
                Thread.sleep(5000);
            }catch(Exception s1){}*/
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
        bg=new ImageIcon(img1).getImage();
        pic=new ImageIcon(welcome1).getImage();
        pic1=new ImageIcon(wel1).getImage();
    }

    public void paint(Graphics g)
    {
        if(loaded)
        {
            //System.out.println("Welcome");
            g.drawImage(pic,25,25,null);
        }
        else
        {
            g.drawImage(pic1,0,0,null);
            //System.out.println("Vak");
            g.drawImage(bg,0,150,null);
        }
    }
}
