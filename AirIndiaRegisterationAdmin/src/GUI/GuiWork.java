package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class GuiWork extends JFrame
{
	JPanel leftPane = new JPanel();
        
	JScrollPane scrollPaneLeft = new JScrollPane();
	JScrollPane scrollPaneRight = new JScrollPane();

	public GuiWork()
        {
            super("Gui Work!");
            setSize(1000, 750);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setLayout(new BorderLayout());

            scrollPaneLeft.setMaximumSize(new java.awt.Dimension(500, 350));
            scrollPaneLeft.setMinimumSize((new java.awt.Dimension(500, 350)));
            scrollPaneLeft.setPreferredSize(new java.awt.Dimension(500, 350));
            scrollPaneLeft.setBorder(BorderFactory.createLineBorder(Color.black));
            scrollPaneLeft.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            //scrollPaneLeft.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPaneLeft.setViewportView(leftPane);

           /* e1.setPreferredSize(new java.awt.Dimension(340, 175));
            e2.setPreferredSize(new java.awt.Dimension(340, 175));
            e3.setPreferredSize(new java.awt.Dimension(340, 175));
            e4.setPreferredSize(new java.awt.Dimension(340, 175));

            leftPane.add(e1);
            leftPane.add(e2);
            leftPane.add(e3);
            leftPane.add(e4);*/
            leftPane.revalidate();
            getContentPane().add(scrollPaneLeft, BorderLayout.CENTER);
            pack();
        }

	public static void main(String[] arguments)
        {
		GuiWork gui = new GuiWork();
		gui.setVisible(true);
	}
}