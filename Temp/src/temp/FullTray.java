package temp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FullTray {
  static class ShowMessageListener implements ActionListener {
    TrayIcon trayIcon;
    String title;
    String message;
    TrayIcon.MessageType messageType;
    ShowMessageListener(
        TrayIcon trayIcon,
        String title,
        String message,
        TrayIcon.MessageType messageType) {
      this.trayIcon = trayIcon;
      this.title = title;
      this.message = message;
      this.messageType = messageType;
    }
    public void actionPerformed(ActionEvent e) {
      trayIcon.displayMessage(title, message, messageType);
    }
  }
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
      public void run() {
        if (SystemTray.isSupported()) {
          final SystemTray tray = SystemTray.getSystemTray();
          Image image = Toolkit.getDefaultToolkit().getImage("gifIcon.gif");
          PopupMenu popup = new PopupMenu();
          final TrayIcon trayIcon = new TrayIcon(image, "Rav's Mp3 Player", popup);

          MenuItem item = new MenuItem("Open");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      new rav();
            }
	  });
          popup.add(item);
          item = new MenuItem("Close");
	  item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	      tray.remove(trayIcon);
            }
	  });
          popup.add(item);
          try {
            tray.add(trayIcon);
          } catch (AWTException e) {
            System.err.println("Can't add to tray");
          }
        } else {
          System.err.println("Tray unavailable");
        }
      }
    };
    EventQueue.invokeLater(runner);
  }
}

class rav
{
    rav()
    {
        JFrame f=new JFrame();
        f.add(new JButton("Test"));
        f.pack();
        f.setVisible(true);
    }
}