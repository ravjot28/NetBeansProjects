/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rav
 */
public class NewClass {
public static void main(String args[]){
    JFrame f = new JFrame();
    f.setLayout(new BorderLayout());
    final JPanel p = new JPanel();
    p.add(new JLabel("A Panel"));
    f.add(p, BorderLayout.CENTER);

    //create a button which will hide the panel when clicked.
    JButton b = new JButton("HIDE");
    b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                p.setVisible(false);
        }
    });

    JButton b1 = new JButton("Show");
    b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                p.setVisible(true);
        }
    });

    f.add(b,BorderLayout.SOUTH);
    f.add(b1,BorderLayout.NORTH);
    f.pack();
    f.setVisible(true);
}
}
