package Main;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Tray
{
    TrayIcon trayIcon;
    final SystemTray tray = SystemTray.getSystemTray();

    class ShowMessageListener implements ActionListener
    {
        TrayIcon trayIcon;
        String title;
        String message;
        TrayIcon.MessageType messageType;

        ShowMessageListener(TrayIcon trayIcon,String title,String message,TrayIcon.MessageType messageType)
        {
            this.trayIcon = trayIcon;
            this.title = title;
            this.message = message;
            this.messageType = messageType;
        }


        public void actionPerformed(ActionEvent e)
        {
            trayIcon.displayMessage(title, message, messageType);
        }
    }


    Tray()
    {
        Runnable runner = new Runnable()
        {
            public void run()
            {
                if (SystemTray.isSupported())
                {
                    Image image = Toolkit.getDefaultToolkit().getImage("img"+System.getProperty("file.separator")+"rav.gif");
                    PopupMenu popup = new PopupMenu();
                    final TrayIcon trayIcon = new TrayIcon(image,"BSAEIA", popup);

                    MenuItem item = new MenuItem("Close");
                    item.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            System.exit(0);
                        }
                    });

                    popup.add(item);

                    try
                    {
                        tray.add(trayIcon);
                    } catch (Exception easd)
                    {
                        JOptionPane.showMessageDialog(null,"Can't add to tray","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Tray unavailable","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        EventQueue.invokeLater(runner);
    }
}