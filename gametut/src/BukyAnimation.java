import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class BukyAnimation
{
    private Screen screen;
    private Image bg;
    private Animation a;

    public static void main(String a[])
    {
        DisplayMode dm=new DisplayMode(800,600,16,DisplayMode.REFRESH_RATE_UNKNOWN);
        BukyAnimation b=new BukyAnimation();
        b.run(dm);
    }

    public void loadPics()
    {
        bg=new ImageIcon("bg.jpg").getImage();
        Image face1=new ImageIcon("face.jpg").getImage();
        Image face2=new ImageIcon("face1.jpg").getImage();
        a=new Animation();
        a.addScene(face1, 250);
        a.addScene(face2, 250);
    }

    public void run(DisplayMode dm)
    {
        screen=new Screen();
        try
        {
            screen.setFullScreen(dm,new JFrame());
            loadPics();
            movieLoop();
        }catch(Exception s1)
        {}finally{
            screen.restoreWindow();
        }
    }

    public void movieLoop()
    {
        long startingTime=System.currentTimeMillis();
        long cumTime=startingTime;
        while((cumTime-startingTime)<5000)
        {
            long timePassed=System.currentTimeMillis()-cumTime;
            cumTime += timePassed;
            a.update(timePassed);
            Graphics g=screen.getFullScreenWindow().getGraphics();
            draw(g);
            g.dispose();
            try
            {
                Thread.sleep(20);
            }catch(Exception sd){}
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(bg,0,0, null);
        g.drawImage(a.getImage(),0,0, null);
    }

    
}
