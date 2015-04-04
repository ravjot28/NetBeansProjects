import org.lobobrowser.gui.*;
import org.lobobrowser.main.*;
import javax.swing.*;

public class LoboTestFrame extends JFrame {
	public static void main(String[] args) throws Exception
        {

		// This step is necessary for extensions to work:
		PlatformInit.getInstance().init(false, false);

		// Create frame with a specific size.
		JFrame frame = new LoboTestFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}

	public LoboTestFrame() throws Exception {
		FramePanel framePanel = new FramePanel();
		this.getContentPane().add(framePanel);
		framePanel.navigate("http://www.google.com");
	}
}