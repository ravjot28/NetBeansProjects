package TestingGUI;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

public class TransparentFrame implements MouseListener
{
    private static final float OPAQUE = 1.0f;
    private static final float TRANSLUCENT = 0.5f;
    final JFrame frame = new JFrame();

    
    public static void main(String[] args)
    {
        new TransparentFrame();
    }

    TransparentFrame()
    {
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e)
            {
                com.sun.awt.AWTUtilities.setWindowOpacity(frame, TRANSLUCENT);
            }


            @Override
            public void mouseExited(MouseEvent e)
            {
                com.sun.awt.AWTUtilities.setWindowOpacity(frame, OPAQUE);
            }
        });

        frame.setLayout(new GridLayout(3,3));
        JButton b1 = new JButton("1");
        b1.addMouseListener(this);
        frame.add(b1);
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));

        frame.pack();

        frame.setVisible(true);
  }

    public void mouseEntered(MouseEvent e)
            {
                com.sun.awt.AWTUtilities.setWindowOpacity(frame, TRANSLUCENT);
            }



            public void mouseExited(MouseEvent e)
            {
                com.sun.awt.AWTUtilities.setWindowOpacity(frame, OPAQUE);
            }

    public void mouseClicked(MouseEvent me) {

    }

    public void mousePressed(MouseEvent me) {

    }

    public void mouseReleased(MouseEvent me) {

    }
    }

