/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PartialFrame {

  private int height;
  private Rectangle screenRect = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
  private JDialog dialog = new JDialog() {

    @Override
    public void paint(Graphics g) {
      g.setClip(0, 0, getWidth(), height);
      super.paint(g);
    }
  };
  private Timer timer = new Timer(20, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
      height++;
      if (height == dialog.getHeight()) {
        timer.stop();
      }
      dialog.setLocation(screenRect.width - dialog.getWidth(),screenRect.height - height);
      dialog.repaint();
    }
  });

  public static void main(String[] args) {
    //JDialog.setDefaultLookAndFeelDecorated(true);
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        new PartialFrame().makeUI();
      }
    });
  }

  public void makeUI() {
      
    timer.setInitialDelay(0);
    timer.start();

    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    dialog.setUndecorated(true);
    ((JComponent) dialog.getContentPane()).setBorder(BorderFactory.createLineBorder(Color.RED, 10));
    JButton button = new JButton("Exit");
    button.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        dialog.dispose();
      }
    });
    dialog.add(button, BorderLayout.NORTH);
    dialog.add(new JLabel("Message"), BorderLayout.CENTER);
    dialog.pack();
    dialog.setVisible(true);
  }
}