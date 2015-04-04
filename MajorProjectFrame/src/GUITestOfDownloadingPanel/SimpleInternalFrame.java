package GUITestOfDownloadingPanel;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class SimpleInternalFrame extends Frame {
  JLayeredPane desktop;
  JInternalFrame internalFrame;
  public SimpleInternalFrame() {
    super("");
    setSize(500, 400);

    desktop = new JDesktopPane();
    desktop.setOpaque(true);
    add(desktop, BorderLayout.CENTER);

    internalFrame = new JInternalFrame("Meow", true, true, true, true);
    internalFrame.setBounds(50, 50, 200, 100);
    internalFrame.getContentPane().add(new JLabel(new ImageIcon("1.jpg")));
    internalFrame.setVisible(true);

    desktop.add(internalFrame, new Integer(1));
  }

  public static void main(String args[]) {
    SimpleInternalFrame sif = new SimpleInternalFrame();
    sif.setVisible(true);
  }
}