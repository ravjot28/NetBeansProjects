import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements Runnable
{
    TrayIcon trayIcon;
    final SystemTray tray = SystemTray.getSystemTray();
    Thread th = new Thread(this);

    public final static String bg="Bin\\img1\\gtbit.jpg";

    public static void main(String arp[])
    {
        new Main();
    }

    Main()
    {
        new FullTray();
    }

    public void run()
    {
        new InboxReader();
    }

    class FullTray
    {
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

        FullTray()
        {
            th.start();  
            Runnable runner = new Runnable()
                                {
                                    public void run()
                                    {
                                        if (SystemTray.isSupported())
                                        {
                                            Image image = Toolkit.getDefaultToolkit().getImage(bg);
                                            PopupMenu popup = new PopupMenu();
                                            final TrayIcon trayIcon = new TrayIcon(image,"GTBIT Informer", popup);

                                            MenuItem item = new MenuItem("Admin");
                                            item.addActionListener(new ActionListener()
                                            {
                                                public void actionPerformed(ActionEvent e)
                                                {
                                                    //tray.remove(trayIcon);
                                                    EventQueue.invokeLater(new Runnable()
                                                    {
                                                        public void run()
                                                        {
                                                            new LoginPage().setVisible(true);
                                                        }
                                                    });
                                                }
                                            });
                                            popup.add(item);
        
                                            item = new MenuItem("Close");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent e)
                                                                        {
                                                                            tray.remove(trayIcon);
                                                                            System.exit(0);
                                                                        }
                                                                    });
                                            popup.add(item);

                                            item = new MenuItem("About");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent ae)
                                                                        {
                                                                            EventQueue.invokeLater(new Runnable()
                                                                            {
                                                                                public void run()
                                                                                {
                                                                                    new About().setVisible(true);
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
                                                    System.err.println("Can't add to tray");
                                                }
                                        }
                                        else
                                        {
                                            System.err.println("Tray unavailable");
                                        }
                                          
                                    }
                                };
            EventQueue.invokeLater(runner);
        }
    }
}
