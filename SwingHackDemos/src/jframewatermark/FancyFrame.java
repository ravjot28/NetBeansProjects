/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jframewatermark;

import javax.swing.*;
 import java.awt.*;

 public class FancyFrame extends JFrame
 {
     public FancyFrame()
     {
         super("Fancy Shmancy");
         setSize(256,256);

         JPanel content = new JPanel();
         content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
         content.setOpaque(false);

         JLabel label1 = new JLabel( "Username:" );
         label1.setForeground(Color.white);
         content.add( label1 );

         JTextField field = new JTextField(15);
         field.setBackground(new Color(255,255,255,80));
         content.add( field );

         JLabel label2 = new JLabel( "Password:" );
         label2.setForeground(Color.white);
         content.add( label2 );

         JPasswordField fieldPass = new JPasswordField(15);
         fieldPass.setBackground(new Color(255,255,255,80));
         content.add( fieldPass );

         getContentPane().setLayout(new FlowLayout());
         getContentPane().add(content);
         ((JPanel)getContentPane()).setOpaque(false);

         final ImageIcon m_image = new ImageIcon("r.png");
         final int winc = m_image.getIconWidth();
         final int hinc = m_image.getIconHeight();
         JLabel backlabel = new JLabel("");
         if (m_image.getIconWidth() > 0 && m_image.getIconHeight() > 0)
         {
             backlabel = new JLabel() {
                 public void paintComponent(Graphics g) {
                     int w = getParent().getWidth();
                     int h = getParent().getHeight();
                     for (int i=0;i<h+hinc;i=i+hinc)
                     {
                         for (int j=0;j<w+winc;j=j+winc)
                         {
                             m_image.paintIcon(this,g,j,i);
                         }
                     }
                 }
                 public Dimension getPreferredSize() {
                     return new Dimension(super.getSize());
                 }
                 public Dimension getMinimumSize() {
                     return getPreferredSize();
                 }
             };
         }

         getLayeredPane().add(backlabel, new Integer(Integer.MIN_VALUE));
         backlabel.setBounds(0,0,5000,5000);

         setVisible(true);
     }

     public static void main(String[] args)
     {
         new FancyFrame();
     }
 }