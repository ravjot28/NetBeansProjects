import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.*;

import org.lobobrowser.gui.*;
import org.lobobrowser.ua.*;
import org.lobobrowser.main.PlatformInit;
import org.w3c.dom.html2.*;

public class VetoableNavigationDemo extends JFrame
{
	private final BrowserPanel browserPanel;
	public static void main(String[] args) throws Exception
        {
		// This step is necessary for extensions (including HTML) to work:
		PlatformInit.getInstance().init(false, false);
		// Create window with a specific size.
		JFrame frame = new VetoableNavigationDemo();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600, 400);
                frame.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e) {
               System.exit(0);
                }
            });
		frame.setVisible(true);
	}

	public VetoableNavigationDemo() throws Exception
        {
		this.setTitle("Rav Web Browser");

		// Create a BrowserPanel and set a default home page.
		final BrowserPanel bp = new BrowserPanel();
		this.browserPanel = bp;
		bp.navigate("http://www.google.com");

		// Add a navigation listener.
		bp.addNavigationListener(new LocalNavigationListener());

		// Add top-level components to window.
		//this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.add(bp);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// This needs to be called in order
				// to inform extensions about the
				// window closing.
				bp.windowClosing();
			}
		});
	}

	private class LocalNavigationListener extends NavigationAdapter {
		@Override
		public void beforeLocalNavigate(NavigationEvent event) throws NavigationVetoException {
			Object linkObject = event.getLinkObject();
			if(linkObject instanceof HTMLElement) {
				HTMLElement linkElement = (HTMLElement) linkObject;
				String rel = linkElement.getAttribute("rel");
				if("nofollow".equalsIgnoreCase(rel)) {
					Component dialogParent = event.getOriginatingFrame().getComponent();
					int response = JOptionPane.showConfirmDialog(dialogParent, "This is a rel='nofollow' link. Are you sure you want to continue?", "Please Confirm", JOptionPane.YES_NO_OPTION);
					if(response != JOptionPane.YES_OPTION) {
						throw new NavigationVetoException();
					}
				}
			}
		}
	}
}
