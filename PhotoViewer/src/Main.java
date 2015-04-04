import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main extends JFrame implements ActionListener
{
    JFrame f;
    String fname="Temp/Pic.txt";
    JButton next,prev,zin,zout,rr,rl;
    String ravs[];
    int count=0;
    JPanel p;
    JLabel l;
    ImageIcon vv;
    int rrr;
    int rrl;
    public static void main(String[] args) 
    {
        new Main();
    }

    Main()
    {
        rrl=0;
        rrr=360;
        f=new JFrame("Pic Viewer");
        l=new JLabel();
        f.setLayout(new BorderLayout());
        //  I want resize this picture (image.jpg)
        p=new JPanel();
        rr=new JButton("Rotate Right");
        rl=new JButton("Rotate Left");
        zin=new JButton("Zoom In");
        zout=new JButton("Zoom Out");
        next=new JButton("Next");
        prev=new JButton("Prev");
        p.add(zin);
        p.add(zout);
        p.add(next);
        p.add(prev);
        p.add(rr);
        p.add(rl);
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(count>=getNumberOfLines(fname)-1)
                {
                    count=getNumberOfLines(fname)-1;
                }
                else
                {
                    count++;
                }
                view11(ravs[count]);
            }
        });
        prev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(count<=0)
                {
                    count=0;
                }
                else
                {
                    count--;
                }
                view11(ravs[count]);
            }
        });
        rr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                rrr=rrr-90;
                ImageIcon ppp=rotate(vv.getImage(),rrr);
                    l.setIcon(view(ppp.getImage()));

            }
        });
        rl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

                rrl=rrl+90;
                System.out.println("Left"+rrl);
                ImageIcon pp=rotate(vv.getImage(),rrl);
                    l.setIcon(view(pp.getImage()));
       
            }
        });
        if(getNumberOfLines(fname)<=0)
        {
            new Add(fname);
        }
        ravs=new String[getNumberOfLines(fname)];
        String d="";
        int c=0;
        try
        {
            BufferedReader b1=new BufferedReader(new FileReader(fname));
            d=b1.readLine();
            while(d!=null)
            {
                ravs[c]=d;
                c++;
                d=b1.readLine();
            }
        }catch(Exception sdfsaf){}
        view11(ravs[count]);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.addWindowListener(
                            new WindowAdapter()
                            {
                                public void windowClosing(WindowEvent e)
                                {
                                    try
                                    {
                                        BufferedWriter bb=new BufferedWriter(new FileWriter(fname));
                                        bb.write("");
                                        bb.close();
                                    }catch(Exception asda){}
                                    System.exit(0);
                                }
                            }
                        );
        f.setVisible(true);
    }
public void view11(String n)
{
        String path =n;
        vv=new ImageIcon(path);
        l.setIcon(view(vv.getImage()));
        f.add(l,BorderLayout.CENTER);
        f.add(p,BorderLayout.SOUTH);
}
   private ImageIcon view(Image src)
    {
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage dst = new BufferedImage(600,400, type);
        Graphics2D g2 = dst.createGraphics();
        g2.drawImage(src, 0, 0,600, 400, this);
        g2.dispose();
        return new ImageIcon(dst);
    }

    private ImageIcon rotate(Image src,double angle)
    {
                int w = src.getWidth(this);
	int h = src.getHeight(this);
	int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage dst = new BufferedImage(w, h, type);
        Graphics2D g2 = dst.createGraphics();
	g2.rotate(Math.toRadians(angle),w/2,h/2);
	g2.drawImage(src,0,0,w,h,0,0,w,h, null);
       g2.dispose();
       // ImageIcon rav=new ImageIcon(dst);
       // return rav;
        return new ImageIcon(dst);
    }

    private ImageIcon scale(Image src, double scale)
    {
        System.out.println("Orignal Size w="+src.getWidth(this)+"     h="+src.getHeight(this));
        int w = (int)(scale*src.getWidth(this));
        int h = (int)(scale*src.getHeight(this));
        System.out.println("AfterScaling Size w="+w+"     h="+h);
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage dst = new BufferedImage(w, h, type);
        Graphics2D g2 = dst.createGraphics();
        g2.drawImage(src, 0, 0, w, h, this);
        g2.dispose();
        return new ImageIcon(dst);
    }

    public int getNumberOfLines(String name) {
		int numberOfLines = 0;


		LineNumberReader lineCounter = null;
		try {
			lineCounter = new LineNumberReader(new FileReader(name));
			while ((lineCounter.readLine()) != null) {
				continue;
			}
			numberOfLines = lineCounter.getLineNumber();

		} catch (IOException e)
                {
		}

		return numberOfLines;
	}

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
