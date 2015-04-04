package GUITest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FullScreenJFrame extends JFrame
{
    public FullScreenJFrame(String title)
    {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setUndecorated(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setBounds(0,0,screenSize.width,screenSize.height);

        getContentPane().add(new JLabel("A JFrame"),BorderLayout.NORTH);

        JButton closeButton = new JButton("Close");

        closeButton.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent ae)
                                            {
                                                FullScreenJFrame.this.setVisible(false);
                                                System.exit(0);
                                            }
                                        }
                                     );

        getContentPane().add(closeButton,BorderLayout.CENTER);
    }

    public static void main(String s[])
    {
        FullScreenJFrame f = new FullScreenJFrame("");
        f.setVisible(true);
    }
}
