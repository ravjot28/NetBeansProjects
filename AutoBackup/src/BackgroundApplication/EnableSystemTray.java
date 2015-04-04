/*
 *  Creates the icon in the System Tray of the OS
 *  and
 *  calls classes which checks the new pen drive or external hard disk insertion recursively
 */

package BackgroundApplication;

import BackSupport.OS;
import Log.LogInput;
import Restore.RestoreFrame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EnableSystemTray implements Runnable
{
    final SystemTray tray = SystemTray.getSystemTray();     //Creates the object of the container to put in the System Tray

    static ArrayList<String> dirs;      //Stores the list of System drives

    CheckDirs cd;

    public EnableSystemTray(ArrayList<String> a)
    {
        this.dirs = a;      //Stores the list 
    }

    class ShowMessageListener implements ActionListener
    {
        TrayIcon trayIcon;
        String title;
        String message;
        TrayIcon.MessageType messageType;

        ShowMessageListener(TrayIcon trayIcon,String title,String message,TrayIcon.MessageType messageType)     //Constructor of the tooltip message class
        {
            this.trayIcon = trayIcon;
            this.title = title;
            this.message = message;
            this.messageType = messageType;
        }

        public void actionPerformed(ActionEvent e)
        {
            trayIcon.displayMessage(title, message, messageType);       //Sets the tooltip text and other details
        }
    }

    public void run()       //The system tray is executed in another thread to reduce the load in current thread
    {
        cd = new CheckDirs(dirs);           //Creation of the object of the class which checks the new disk inserted in the system
        Thread th = new Thread(cd);         //Creates another thread which excutes the checking of new disk inserted in the system
        th.start();

        if (SystemTray.isSupported())
        {
            Image image = Toolkit.getDefaultToolkit().getImage("AutoBackup\\Files\\Pics\\The-Backup.icon.png");     //Image that will be displayed in the System Tray

            PopupMenu popup = new PopupMenu();
            
            final TrayIcon trayIcon = new TrayIcon(image,"R Auto Backup", popup);       //Displays R Auto Backup when we hover the mouse over the System Tray Icon

            MenuItem item = new MenuItem("Close");      //Close option is displayed when user right clicks on the pic
            
            item.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    cd.stopChecking();              //Close the thread which checks for new disk inserted in the system
                    System.exit(0);                 //exits
                }
            });
            popup.add(item);                        //Adds the close menu to the menu item

            item = new MenuItem("Restore Backup");

            item.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            java.awt.EventQueue.invokeLater(new Runnable()
                                            {
                                                public void run()
                                                {
                                                    new RestoreFrame().setVisible(true);
                                                }
                                            });
                                        }
                                    });

             popup.add(item);

            try
            {
                tray.add(trayIcon);
            } catch (Exception easd)
            {
                LogInput li = new LogInput();           //If error occurs sotre the error in log file
                li.input(new OS().getOS()+" Tray unavailable");
                JOptionPane.showMessageDialog(null,"Can't add to tray","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            LogInput li = new LogInput();           //If System Tray can not be created then OS details stored in the log file
            li.input(new OS().getOS()+" Tray unavailable");
            JOptionPane.showMessageDialog(null,"Tray unavailable","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}