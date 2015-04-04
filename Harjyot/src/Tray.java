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

class Tray implements Runnable
{
    TrayIcon trayIcon;
    final SystemTray tray = SystemTray.getSystemTray();
    Thread th = new Thread(this);
    MainFrame frame;
    
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
        frame = new MainFrame();
        th.start();
        Runnable runner = new Runnable()
        {
            public void run()
            {
                if (SystemTray.isSupported())
                {
                    Image image = Toolkit.getDefaultToolkit().getImage("r.gif");
                    PopupMenu popup = new PopupMenu();
                    final TrayIcon trayIcon = new TrayIcon(image,"App Side Bar", popup);

                    MenuItem item = new MenuItem("Show");
                    item.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            if(!frame.isShowing())
                            {
                                frame.setVisible(true);
                            }
                        }
                    });
                    popup.add(item);
                    
                    item = new MenuItem("Hide");
                    item.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            frame.setVisible(false);
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
    
    public void run()
    {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
    }

    public static void main(String ar[])
    {
       new Tray();
    }
}