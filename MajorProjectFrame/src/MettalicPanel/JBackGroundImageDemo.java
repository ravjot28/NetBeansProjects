/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MettalicPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
/*
 * Created on Mar 24, 2008
 *
 */

/**
 * @author Anand
 */

public class JBackGroundImageDemo extends JFrame
{
    Container con = null;
    JPanel panelBgImg;

    public JBackGroundImageDemo()
    {
        setTitle("Trash");
        con = getContentPane();

        con.setLayout(null);
        ImageIcon imh = new ImageIcon("Bin\\img\\trash.png");
        setSize(imh.getIconWidth(), imh.getIconHeight());

        panelBgImg = new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                Image img = new ImageIcon("Bin\\img\\trash.png").getImage();
                Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
                setSize(size);
                setLayout(null);
                g.drawImage(img, 0, 0, null);
            }
        };

        con.add(panelBgImg);
        panelBgImg.setBounds(0, 0, imh.getIconWidth(), imh.getIconHeight());

        GridBagLayout layout = new GridBagLayout();

        panelBgImg.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 200));

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new JBackGroundImageDemo().setVisible(true);
    }
}
	