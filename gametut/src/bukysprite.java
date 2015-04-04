
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;


public class bukysprite
{
    private Sprite sprite;
    private Animation a;
    private ScreenManager s;
    private Image bg;
    private static final DisplayMode modes1[]={
                                                new DisplayMode(800,600,32,0),
                                                new DisplayMode(800,600,24,0),
                                                new DisplayMode(800,600,16,0),
                                                new DisplayMode(640,480,32,0),
                                                new DisplayMode(640,480,24,0),
                                                new DisplayMode(640,480,16,0)};
    public static void main(String sap[])
    {
        bukysprite b=new bukysprite();
        b.run();
    }

    public void loadImages()
    {
        bg=new ImageIcon("bg.jpg").getImage();
        Image face1=new ImageIcon("face.jpg").getImage();
        Image face2=new ImageIcon("face1.jpg").getImage();
        a=new Animation();
        a.addScene(face1, 250);
        a.addScene(face2, 250);
        sprite=new Sprite(a);
        sprite.setVelocityX(0.3f);
        sprite.setVelocityY(0.3f);
    }

    public void run()
    {
        s=new ScreenManager();
        try
        {
            DisplayMode dm=s.findFirstCompatibleMode(modes1);
            s.setFullScreen(dm);
            loadImages();
            movieLoop();
        }catch(Exception s)
            {
            }finally
            {
                s.restoreScreen();
            }
    }

    public void movieLoop()
    {
        long startingTime = System.currentTimeMillis();
        long cumTime=startingTime;
        while((cumTime-startingTime)<5000)
        {
            long timePassed=System.currentTimeMillis()-cumTime;
            cumTime+=timePassed;
            update(timePassed);
            Graphics2D g=s.getGraphics();
            draw(g);
            g.dispose();
            s.update();
            try
            {
                Thread.sleep(20);
            }catch(Exception s34){}
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(bg,0,0,null);
        g.drawImage(sprite.getImage(),Math.round(sprite.getX()),Math.round(sprite.getY()),null);
    }

    public void update(long timePassed)
    {
        if(sprite.getX()<0)
        {
            sprite.setVelocityX(Math.abs(sprite.getVelocityX()));
        }
        else
        if((sprite.getX()+sprite.getWidth())>=s.getWidth())
        {
            sprite.setVelocityX(-Math.abs(sprite.getVelocityX()));
        }

        if(sprite.getY()<0)
        {
            sprite.setVelocityY(Math.abs(sprite.getVelocityY()));
        }
        else
        if((sprite.getY()+sprite.getHeight())>=s.getHeight())
        {
            sprite.setVelocityY(-Math.abs(sprite.getVelocityY()));
        }
        sprite.update(timePassed);
    }

}
