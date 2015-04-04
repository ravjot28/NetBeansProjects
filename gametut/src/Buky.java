import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;

public class Buky extends JFrame
{
    public static void main(String a[])
    {
        DisplayMode dm=new DisplayMode(800,600,16,DisplayMode.REFRESH_RATE_UNKNOWN);
        Buky b=new Buky();
        b.run(dm);
    }

    public void run(DisplayMode dm)
    {
        setBackground(Color.GRAY);
        setForeground(Color.ORANGE);
        setFont(new Font("Arial",Font.BOLD,24));
        Screen s=new Screen();
        try
        {
            s.setFullScreen(dm, this);
            try
            {
                Thread.sleep(5000);
            }catch(Exception s1){}
        }
        catch(Exception sd)
        {}
        finally
        {
            s.restoreWindow();
        }
    }

    public void paint(Graphics g)
    {
        //if(g instanceof Graphics2D)
        //{
            //Graphics2D g2=(Graphics2D)g;
            //g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //}
        g.drawString("Rav Softs Presentation",200,200);
    }
}
