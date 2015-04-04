package newpackage;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.beans.*;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class ImagePreview extends JPanel implements PropertyChangeListener
{
    private JFileChooser jfc;
    private Image img;

    public ImagePreview(JFileChooser jfc)
    {
        this.jfc = jfc;
        Dimension sz = new Dimension(200,200);
        setPreferredSize(sz);
    }

    public void propertyChange(PropertyChangeEvent evt)
    {
        try
        {
            System.out.println("updating");
            File file = jfc.getSelectedFile();
            updateImage(file);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
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


ImagePreview()
    {
    JFileChooser jfc = new JFileChooser();
        ImagePreview preview = new ImagePreview(jfc);
        jfc.addPropertyChangeListener(preview);
        jfc.setAccessory(preview);
        //jfc.showOpenDialog(null);
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
    {
      //System.out.println("getCurrentDirectory():"+  chooser.getCurrentDirectory());
      //System.out.println("getSelectedFile():"+  chooser.getSelectedFile());
      System.out.println(jfc.getSelectedFile().toString());
      }
    else
    {
      System.out.println("No Selection ");
    }
}
    public static void main(String[] args) {
       new ImagePreview();
    }
}