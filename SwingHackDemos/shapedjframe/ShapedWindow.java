package shapedjframe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Ellipse2D;
import static java.awt.GraphicsDevice.WindowTranslucency.*;

public class ShapedWindow extends JFrame {
    public ShapedWindow() {
        super("ShapedWindow");
        setLayout(new GridBagLayout());

        // It is best practice to set the window's shape in
        // the componentResized method.  Then, if the window
        // changes size, the shape will be correctly recalculated.
        addComponentListener(new ComponentAdapter() {
            // Give the window an elliptical shape.
            // If the window is resized, the shape is recalculated here.
            @Override
            public void componentResized(ComponentEvent e)
            {
	        //setShape(new Ellipse2D.Double(0,0,getWidth(),getHeight()));
                setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(), 50,50));
            }
        });

        setUndecorated(true);
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JButton("I am a Button"));
    }

    public static void main(String[] args) {
        // Determine what the GraphicsDevice can support.
        GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
//        boolean isPerPixelTranslucencySupported =gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);

        //If translucent windows aren't supported, exit.
       // if (!isPerPixelTranslucencySupported) {
         //   System.out.println(
           //     "Per-pixel translucency is not supported");
             //   System.exit(0);
        //}

        JFrame.setDefaultLookAndFeelDecorated(true);

        

        // Create the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShapedWindow sw = new ShapedWindow();

		// Set the window to 70% translucency, if supported.
		//if (isTranslucencySupported) {
		  //  sw.setOpacity(0.7f);
		//}

		// Display the window.
		sw.setVisible(true);
	    }
        });
    }
}