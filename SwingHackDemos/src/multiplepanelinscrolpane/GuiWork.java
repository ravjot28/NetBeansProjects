package multiplepanelinscrolpane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class GuiWork extends JFrame {

	JPanel leftPane = new JPanel();
	//JPanel rightPane = new JPanel();
	//JPanel topPane = new JPanel();
	JScrollPane scrollPaneLeft = new JScrollPane();
	JScrollPane scrollPaneRight = new JScrollPane();
	JButton nButton = new JButton("North");
	JButton sButton = new JButton("South");
	JButton eButton = new JButton("East");
	JButton wButton = new JButton("West");
	JButton wButton2 = new JButton("West");
	JButton wButton3 = new JButton("West");
	JButton wButton4 = new JButton("West");
	JButton wButton5 = new JButton("West");
	JButton wButton6 = new JButton("West");
	JButton wButton7 = new JButton("West");
	JButton wButton8 = new JButton("West");
	JButton wButton9 = new JButton("West");



	public GuiWork(){
super("Gui Work!");
    setSize(1000, 750);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(new BorderLayout());

    //GOAL::LACE MULTIPLE JPANELS INSIDE JSCROLLPANE !

    //Size TopPane on North Border
   // topPane.setMaximumSize(new java.awt.Dimension(1000, 200));
//    topPane.setMinimumSize((new java.awt.Dimension(1000, 200)));
  //  topPane.setPreferredSize(new java.awt.Dimension(1000, 200));
    //topPane.setBorder(BorderFactory.createLineBorder(Color.black));
    //topPane.add(nButton);
    //topPane.add(sButton);
    // add to contentPane - not JFrame itself
   // getContentPane().add(topPane, BorderLayout.NORTH);


    //Size RightPane on East Border
    //rightPane.setMaximumSize(new java.awt.Dimension(500, 350));
    //rightPane.setMinimumSize((new java.awt.Dimension(500, 350)));
    //rightPane.setPreferredSize(new java.awt.Dimension(500, 350));
    //rightPane.setBorder(BorderFactory.createLineBorder(Color.black));
    //rightPane.add(eButton);
    //getContentPane().add(rightPane, BorderLayout.EAST);


    // Size scrollPaneLeft - leftPane size doesn't matter since it's the scrollable view
    scrollPaneLeft.setMaximumSize(new java.awt.Dimension(500, 350));
    scrollPaneLeft.setMinimumSize((new java.awt.Dimension(500, 350)));
    scrollPaneLeft.setPreferredSize(new java.awt.Dimension(500, 350));
    scrollPaneLeft.setBorder(BorderFactory.createLineBorder(Color.black));
    scrollPaneLeft.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPaneLeft.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    // set leftPane as the scrollable component
    scrollPaneLeft.setViewportView(leftPane);

    //Place Components in Container
    wButton.setSize(50, 175);
    wButton.setPreferredSize(new java.awt.Dimension(300, 300));
    wButton2.setPreferredSize(new java.awt.Dimension(300, 300));
    wButton3.setPreferredSize(new java.awt.Dimension(300, 300));

    leftPane.add(wButton);
    leftPane.add(wButton2);
    leftPane.add(wButton3);
    leftPane.add(wButton4);
    // important to call revalidate here so leftPane will notify scrollPaneLeft to update accordingly
    leftPane.revalidate();
    getContentPane().add(scrollPaneLeft, BorderLayout.WEST);
}

	public static void main(String[] arguments){
		GuiWork gui = new GuiWork();
		gui.setVisible(true);
	}

}