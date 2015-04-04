package AppDownload;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class DownloadMain implements Runnable
{
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();

    String[] apps;

    JFrame f;
    
    JPanel panel;

    InfiniteProgressPanel glassPane;

    AppDownload appPanel[];

    final Point hotspot = new Point(0, 0);

    public void launch()
    {
        f = new JFrame("GizmoStore Download App");

        f.setIconImage(new ImageIcon("Bin\\img\\logo.png").getImage());
        f.setCursor(java.awt.Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("Bin\\img\\cursor.png").getImage(), hotspot, "Rav Cursor"));
        panel = new JPanel();

        glassPane = new InfiniteProgressPanel("Checking For New Apps.....");
    
        panel.setLayout(new GridLayout(4,4));

        f.add(panel);

        f.setGlassPane(glassPane);

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = (d.width-320)/2;
        int y = (d.height-320)/2;

        f.setBounds(x, y,320,320);
        f.setVisible(true);
        
        Thread th = null;
        th = new Thread(this);
        th.start();
    }

    public void run()
    {
        glassPane.start();
        getNewApp gna = new getNewApp();
        if(gna.check())
        {
            apps = gna.getApp();

        if(apps.length>0)
        {

        appPanel = new AppDownload[apps.length];

        panel.setLayout(new GridLayout((apps.length/3),3));

        for(int i=0;i<apps.length;i++)
        {
            StringTokenizer st = new StringTokenizer(apps[i],"!!");

            String details = st.nextToken();
            String link = st.nextToken();

            StringTokenizer image = new StringTokenizer(details,"^^");
            String name = image.nextToken();
            String img = image.nextToken();

            appPanel[i] = new AppDownload(link,details,img);
            Border thickBorder = new LineBorder(Color.gray, 2);
            appPanel[i].setBorder(thickBorder);
            panel.add(appPanel[i]);
        }

        panel.revalidate();
        panel.repaint();

        f.pack();

        int x = (d.width-f.getSize().width)/2;
        int y = (d.height-f.getSize().height)/2;

        f.setLocation(x, y);
        }

        else
        {
            f.dispose();
            JOptionPane.showMessageDialog(null,"No New Apps.", "Information",JOptionPane.INFORMATION_MESSAGE);
        }

        glassPane.stop();
        }
        else
        {
            glassPane.stop();
            f.dispose();
            JOptionPane.showMessageDialog(null,"Internet Connection Error.", "Information",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
