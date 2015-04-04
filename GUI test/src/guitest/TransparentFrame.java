
package guitest;
import javax.swing.*;
import java.awt.event.*;

public class TransparentFrame {
  private static final float OPAQUE = 1.0f;
  private static final float TRANSLUCENT = 0.5f;

  public static void main(String[] args) {
    final JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    frame.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        com.sun.awt.AWTUtilities.setWindowOpacity(frame, TRANSLUCENT);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        com.sun.awt.AWTUtilities.setWindowOpacity(frame, OPAQUE);
      }
    });
    frame.setVisible(true);
  }
}