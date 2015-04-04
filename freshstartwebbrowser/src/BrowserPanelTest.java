import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.*;
import org.lobobrowser.gui.*;
import org.lobobrowser.main.PlatformInit;

public class BrowserPanelTest extends JFrame {
	public static void main(String[] args) throws Exception {
		// Initialize logging.
		PlatformInit.getInstance().initLogging(false);

		// This step is necessary for extensions to work:
		PlatformInit.getInstance().init(false, false);

		// Create frame with a specific size.
		JFrame frame = new BrowserPanelTest();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}

	public BrowserPanelTest() throws Exception {
		this.setTitle("Rav Web Browser");
		final BrowserPanel bp = new BrowserPanel();
		bp.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Embedded browser"));
		bp.navigate("http://www.google.com");
		this.getContentPane().add(bp);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// This needs to be called in order
				// to inform extensions about the
				// window closing.
				bp.windowClosing();
			}
		});
	}
}