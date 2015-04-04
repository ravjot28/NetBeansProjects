package info.kpumuk.erka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

import org.jdesktop.jdic.tray.SystemTray;
import org.jdesktop.jdic.tray.TrayIcon;

/**
 *  
 */
public class JdicTray {
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SystemTray tray = SystemTray.getDefaultSystemTray();
		ImageIcon icon = new ImageIcon((JdicTray.class)
				.getResource("/icon.gif"));
		JPopupMenu jPopupMenu = new JPopupMenu("A Menu");
		jPopupMenu.add("menu item 1");
		jPopupMenu.add("menu item 2");
		jPopupMenu.addSeparator();
		JMenuItem menuItem = new JMenuItem("Quit");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jPopupMenu.add(menuItem);
		TrayIcon ti = new TrayIcon(icon, "JDIC Tray", jPopupMenu);
		tray.addTrayIcon(ti);
	}
}
