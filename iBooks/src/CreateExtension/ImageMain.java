package CreateExtension;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;

public class ImageMain {

public static void setup(String s)
{
    //load a pdf from a byte buffer
    File file = new File(s);
    RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "r");
        } catch (FileNotFoundException ex) {
            
        }
    FileChannel channel = raf.getChannel();
    ByteBuffer buf = null;
        try {
            buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        } catch (IOException ex) {

        }
    PDFFile pdffile = null;
        try {
            pdffile = new PDFFile(buf);
        } catch (IOException ex) {

        }
    int numPgs = pdffile.getNumPages();

     Copy c = new Copy();
     c.copyfile("Bin\\Data\\End.png", "Bin\\Data\\Temp\\0.png");

    for (int i=1; i<=numPgs; i++)
    {
        // draw the first page to an image
        PDFPage page = pdffile.getPage(i);

        //get the width and height for the doc at the default zoom
        Rectangle rect = new Rectangle(0,0,(int)page.getBBox().getWidth(),(int)page.getBBox().getHeight());

        //generate the image
        Image img = page.getImage(rect.width, rect.height, //width & height
            rect, // clip rect
            null, // null for the ImageObserver
            true, // fill background with white
            true  // block until drawing is done
            );
        //save it as a file
        BufferedImage bImg = toBufferedImage( img );
        File yourImageFile = new File("Bin\\Data\\Temp\\" + i + ".png");
            try {
                ImageIO.write(bImg, "png", yourImageFile);
            } catch (IOException ex) {

            }
    }
    if((numPgs%2)==0)
    {
        c = new Copy();
        c.copyfile("Bin\\Data\\End.png", "Bin\\Data\\Temp\\"+(numPgs+1)+".png");
    }
}


// This method returns a buffered image with the contents of an image

public static BufferedImage toBufferedImage(Image image)
{
    if (image instanceof BufferedImage)
    {
        return (BufferedImage)image;
    }

    // This code ensures that all the pixels in the image are loaded
    image = new ImageIcon(image).getImage();

    // Determine if the image has transparent pixels; for this method's
    // implementation, see e661 Determining If an Image Has Transparent Pixels
   //boolean hasAlpha = hasAlpha(image);

    // Create a buffered image with a format that's compatible with the screen
    BufferedImage bimage = null;
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    try {
        // Determine the type of transparency of the new buffered image
        int transparency = Transparency.OPAQUE;
        if (true) {
            transparency = Transparency.BITMASK;
        }

        // Create the buffered image
        GraphicsDevice gs = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gs.getDefaultConfiguration();
        bimage = gc.createCompatibleImage(
            image.getWidth(null), image.getHeight(null), transparency);
    } catch (HeadlessException e) {
        // The system does not have a screen
    }

    if (bimage == null) {
        // Create a buffered image using the default color model
        int type = BufferedImage.TYPE_INT_RGB;
        if (true) {
            type = BufferedImage.TYPE_INT_ARGB;
        }
        bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
    }

    // Copy image to buffered image
    Graphics g = bimage.createGraphics();

    // Paint the image onto the buffered image
    g.drawImage(image, 0, 0, null);
    g.dispose();

    return bimage;
}

private static void copyfile(String srFile, String dtFile){
    try{
      File f1 = new File(srFile);
      File f2 = new File(dtFile);
      InputStream in = new FileInputStream(f1);

      //For Append the file.
//      OutputStream out = new FileOutputStream(f2,true);

      //For Overwrite the file.
      OutputStream out = new FileOutputStream(f2);

      byte[] buf = new byte[1024];
      int len;
      while ((len = in.read(buf)) > 0){
        out.write(buf, 0, len);
      }
      in.close();
      out.close();
    }
    catch(Exception ex){}
  }
}