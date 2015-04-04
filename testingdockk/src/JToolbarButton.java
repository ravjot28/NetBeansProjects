import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class represents the buttons used in toolbars.
 *
 * @author <a href="mailto:stephane@hillion.org">Stephane Hillion</a>
 * @version $Id: JToolbarButton.java 498555 2007-01-22 08:09:33Z cam $
 */
public class JToolbarButton extends JButton {
    /**
     * Creates a new toolbar button.
     */
    public JToolbarButton() {
        initialize();
    }

    /**
     * Creates a new toolbar button.
     * @param txt The button text.
     */
    public JToolbarButton(String txt) {
        super(txt);
        initialize();
    }

    /**
     * Initializes the button.
     */
    protected void initialize() {
        if (!System.getProperty("java.version").startsWith("1.3")) {
            setOpaque(false);
            setBackground(new java.awt.Color(0, 0, 0, 0));
        }
        setBorderPainted(false);
        setMargin(new Insets(2, 2, 2, 2));
        addMouseListener(new MouseListener());
    }

    /**
     * To manage the mouse interactions.
     */
    protected class MouseListener extends MouseAdapter {
        public void mouseEntered(MouseEvent ev) {
            setBorderPainted(true);
        }
        public void mouseExited(MouseEvent ev) {
            setBorderPainted(false);
        }
    }

    public static void main(String re[])
    {
        JFrame f=new JFrame("adfa");
        JToolbarButton b=new JToolbarButton("Click Me");
        f.add(b,BorderLayout.CENTER);
        f.add(new JPanel(),BorderLayout.NORTH);
        f.add(new JPanel(),BorderLayout.SOUTH);
        f.add(new JPanel(),BorderLayout.EAST);
        f.add(new JPanel(),BorderLayout.WEST);
        f.pack();
        f.setVisible(true);
    }
}