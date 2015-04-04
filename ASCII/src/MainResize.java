import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class MainResize extends JFrame
{
    double s=0.3;
    JButton plus,minus;
    public MainResize()
    {
        super("None");
//        setSize(400,400);
        Container c=getContentPane();
        c.setLayout(new GridLayout(1,0));
        //  I want resize this picture (image.jpg)
        String path ="D:\\My World\\Event\\Posters\\1.jpg";
       // URL url = getClass().getResource(path);
        //System.out.println("url = " + url);
        ImageIcon vv=new ImageIcon(path);
        //JLabel jl=new JLabel("",vv,JLabel.LEFT);
        //c.add(jl);
        //c.add(new JLabel(scale(vv.getImage(), 0.2)));
        ImageIcon ravv=rotate(vv.getImage(), s,0);

         c.add(new JLabel(scale(ravv.getImage(),s)));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private ImageIcon scale(Image src, double scale)
    {
        int w = (int)(scale*src.getWidth(this));
        int h = (int)(scale*src.getHeight(this));
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage dst = new BufferedImage(w, h, type);
        Graphics2D g2 = dst.createGraphics();
        g2.drawImage(src, 0, 0, w, h, this);
        g2.dispose();
        return new ImageIcon(dst);
    }

    private ImageIcon rotate(Image src,double scale,double angle)
    {
        int w = src.getWidth(this);
	int h = src.getHeight(this);
	int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage dst = new BufferedImage(w, h, type);
        Graphics2D g2 = dst.createGraphics();
	g2.rotate(Math.toRadians(angle), w/2, h/2);
	g2.drawImage(src,0,0,w, h,0,0,w, h, null);
       g2.dispose();
        ImageIcon rav=new ImageIcon(dst);
       // return rav;
        return new ImageIcon(dst);
    }

    public static void main(String[] args) {
        new MainResize();
    }
}