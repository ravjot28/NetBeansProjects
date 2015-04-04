import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame extends JFrame {

	public static void main(String[] args) {
		TestFrame tester = new TestFrame ();
			tester.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons/r.gif"));
		tester.setVisible (true);
	}

	public TestFrame ()  {
		super ("File chooser test");

		//  Create the controls
		setBounds (100, 100, 400, 400);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		JButton fileChooserButton = new JButton ("Choose File");
		JPanel buttonPanel = new JPanel ();
		buttonPanel.add (fileChooserButton);
		getContentPane ().add (buttonPanel);

		fileChooserButton.addActionListener (new ActionListener ()  {
			public void actionPerformed (ActionEvent e)  {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(TestFrame.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				   System.out.println("You chose to open this file: " +
						chooser.getSelectedFile().getName());
				}
			}
		});
	}
}