package cursor;

import java.awt.*;
import javax.swing.*;

public class CustomCursorExample extends JFrame {
    public CustomCursorExample() {
        super("Custom Cursor Example");

        JPanel pane = (JPanel) getContentPane();
        pane.setPreferredSize(new Dimension(300, 300));

        // change the next three objects to your needs
        final Image cursorImage = new ImageIcon("cursor.png").getImage();
        final Point hotspot = new Point(0, 0);
        final String name = "My Cursor";

        JButton mouseButton = new JButton();
        mouseButton.setLocation(10, 10);
        mouseButton.setSize(80, 30);
        mouseButton.setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, name));
        pane.add(mouseButton);

        pane.setLayout(new BorderLayout());

        pack();
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new CustomCursorExample();
    }
}