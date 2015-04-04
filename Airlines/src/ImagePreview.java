import javax.swing.*;
import java.beans.*;
import java.awt.*;
import java.io.*;

public class ImagePreview extends JPanel implements PropertyChangeListener
{
    private JFileChooser jfc;
    private Image img;

    public ImagePreview(JFileChooser jfc)
    {
         try
         {
             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
         }catch(Exception e){}
        this.jfc = jfc;
        Dimension sz = new Dimension(200,200);
        setPreferredSize(sz);
    }

    public void propertyChange(PropertyChangeEvent evt)
    {
        try
        {
            File file = jfc.getSelectedFile();
            updateImage(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void updateImage(File file) throws IOException
    {
        if(file == null) {
            return;
        }
        sun.awt.shell.ShellFolder sf = sun.awt.shell.ShellFolder.getShellFolder(file);

        img=new ImageIcon(sf.getIcon(true)).getImage();
       // img = ImageIO.read(file);
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        // fill the background
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());

        if(img != null)
        {
            // calculate the scaling factor
            int w = img.getWidth(null);
            int h = img.getHeight(null);
            int side = Math.max(w,h);
            double scale = 32.0/(double)side;
            w = (int)(scale * (double)w);
            h = (int)(scale * (double)h);

            // draw the image
            g.drawImage(img,0,0,w,h,null);

            // draw the image dimensions
            String dim = w + " x " + h;
            g.setColor(Color.white);
            g.drawString(dim,31,196);
            g.setColor(Color.white);
            g.drawString(dim,30,195);

        } else
        {

            // print a message
            g.setColor(Color.black);
            g.drawString("Not an image",30,100);
        }
    }

           
}