/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MettalicPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MidPic extends JPanel
  	{
  		public void paintComponent (Graphics g)
  		{
  			super.paintComponent(g);
  			Graphics2D g2d = (Graphics2D) g;
  			g2d.drawImage(new ImageIcon("Bin\\img\\metal.jpg").getImage(),null,null);
  		}
  	}