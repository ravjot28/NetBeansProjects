/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EarthQuakeDialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Rav
 */
public class NewClass extends JFrame
{
    DialogEarthquakeCenter dec;

    public static void main(String asp[])
    {
        new NewClass();
    }

    NewClass()
    {
        setTitle("Hi");
         dec = new DialogEarthquakeCenter (this);
        JButton b = new JButton("Press Me 1");
        add(b,BorderLayout.CENTER);
        b.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent ar)
                                {
                                    dec.startShake( );
                                }
                            });
        add(new JButton("Press Me 2"),BorderLayout.EAST);
        add(new JButton("Press Me 3"),BorderLayout.NORTH);
        add(new JButton("Press Me 4"),BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
}
