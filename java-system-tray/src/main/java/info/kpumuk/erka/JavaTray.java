package info.kpumuk.erka;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

public class JavaTray {

	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) throws AWTException {
		if (SystemTray.isSupported()) {
			SystemTray systemTray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage("icon.gif");
			final TrayIcon trayIcon = new TrayIcon(image);
			final PopupMenu popupMenu = new PopupMenu();
			popupMenu.add("menu item 1");
			popupMenu.add("menu item 2");
			popupMenu.addSeparator();
			final MenuItem menuItemQuit = new MenuItem("Quit");
			popupMenu.add(menuItemQuit);
			menuItemQuit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			trayIcon.setPopupMenu(popupMenu);
			systemTray.add(trayIcon);
		} else {
			System.out.println("Tray is not supported");
		}

	}

	public void test() throws AWTException {
	}
}
