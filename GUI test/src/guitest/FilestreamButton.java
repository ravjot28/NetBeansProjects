
package guitest;

import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FilestreamButton extends JButton
{
   public FilestreamButton(String label)
   {
      super(label);
      setContentAreaFilled(false);
   }

   public static void main(String[] args)
  {
      JButton button = new FilestreamButton("Basingstoke");

      JFrame frame = new JFrame();
      frame.getContentPane().setBackground(Color.white);
      frame.getContentPane().add(button);
      frame.getContentPane().setLayout(new FlowLayout());
      frame.setSize(200, 200);
      frame.setVisible(true);
   }
}