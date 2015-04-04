package robotscreenshot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TakeSnaps {

    public String snaps(String fname) {
        Robot robot;
        Rectangle size;
        BufferedImage image;
        try {
            robot = new Robot();
            size = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            image = robot.createScreenCapture(size);
            String file = save(image, "jpg", fname);
            if(file!=null){
                return file;
            }
        } catch (AWTException e) {
        } finally {
            robot = null;
            image = null;
            size = null;
        }
        return null;
    }

    private static String save(BufferedImage image, String ext, String fname) {
        File file = new File(fname + "." + ext);
        try {
            ImageIO.write(image, ext, file);
            return file.getAbsolutePath();
            
        } catch (IOException e) {
        } finally {
            file = null;
        }
        return null;
    }
}
