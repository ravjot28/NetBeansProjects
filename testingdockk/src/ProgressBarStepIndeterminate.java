import java.awt.BorderLayout;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressBarStepIndeterminate
{
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    ProgressBarStepIndeterminate()
    {
        JFrame frame = new JFrame("Processing Mail Please Wait....");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JProgressBar aJProgressBar = new JProgressBar(JProgressBar.HORIZONTAL);
    //aJProgressBar.setStringPainted(true);
    aJProgressBar.setIndeterminate(true);
    frame.add(new JPanel(),BorderLayout.NORTH);
    frame.add(new JPanel(),BorderLayout.WEST);
    frame.add(new JPanel(),BorderLayout.EAST);
    frame.add(new JPanel(),BorderLayout.SOUTH);
    frame.add(aJProgressBar, BorderLayout.CENTER);
    frame.setLocation(h/3,w/4);
    frame.setSize(700, 100);
    frame.setVisible(true);
    }

  public static void main(String args[]) 
  {
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgressBarStepIndeterminate();
            }
        });
    
  }
}