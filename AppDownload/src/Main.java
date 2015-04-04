
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class Main
{
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();

    public void launch()
    {
        AppDownload manager[] = new AppDownload[10];

        JFrame f = new JFrame("Download App");
    
        f.setLayout(new GridLayout(4,4));
        for(int i=0;i<10;i++)
        {
            manager[i] = new AppDownload("http://www.snee.com/xml/xslt/sample.doc");
            f.add(manager[i]);
        }
        

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        f.pack();
        
        int x = (d.width-f.getSize().width)/2;
        int y = (d.height-f.getSize().height)/2;

        f.setLocation(x, y);
        f.setVisible(true);
    }

    public static void main(String ar[])
    {
        Main m = new Main();
        m.launch();
    }
}
