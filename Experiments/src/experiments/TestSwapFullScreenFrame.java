package experiments;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TestSwapFullScreenFrame extends JFrame {
	GraphicsDevice device;

	public TestSwapFullScreenFrame(GraphicsDevice device)
        {
		super("Test");
		setUndecorated(true);
		setResizable(false);
		this.device = device;
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new MyWindowListener());
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		JButton b = new JButton("Exit");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		c.add(b);
	}

	private final class MyWindowListener extends WindowAdapter {
		public void windowActivated(WindowEvent e) {
			changeScreen(true);
		}
		public void windowDeactivated(WindowEvent e) {
			changeScreen(false);
		}
	}

    public void changeScreen(boolean full) {
        if (full) {
            // Full-screen mode
            device.setFullScreenWindow(this);
            validate();
        } else {
            // Windowed mode
            device.setFullScreenWindow(null);
        }
    }



	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = env.getScreenDevices();
		TestSwapFullScreenFrame test = new TestSwapFullScreenFrame(devices[0]);
		test.setVisible(true);
	}
}