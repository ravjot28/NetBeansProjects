import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main implements Runnable
{
    TrayIcon trayIcon;
    final SystemTray tray = SystemTray.getSystemTray();
    Thread th = new Thread(this);

    public static void main(String spp[])
    {
        new Main();
    }

    Main()
    {
        //String fname="Notices/UserInfo/userinfo.ravs";
        String fname="Notices\\UserInfo\\userinfo.ravs";

        File f = new File(fname);
        if((f.exists())&&(f.length()!=0))
        {
            new FullTray();
        }
        else
        {
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new First().setVisible(true);
                }
            });
        }
    }

    public void run()
    {
        String yr="";
            String br="";
            try
            {
                //BufferedReader b = new BufferedReader(new FileReader("Notices/UserInfo/userinfo.ravs"));
                BufferedReader b = new BufferedReader(new FileReader("Notices\\UserInfo\\userinfo.ravs"));
                br=b.readLine().trim();
                yr=b.readLine().trim();
                b.close();
             }catch(Exception as){}
             new InboxReader(yr,br);
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
                                            //Image image = Toolkit.getDefaultToolkit().getImage("img/icon.jpg");
                                            Image image = Toolkit.getDefaultToolkit().getImage("img\\icon.jpg");
                                            PopupMenu popup = new PopupMenu();
                                            final TrayIcon trayIcon = new TrayIcon(image,"GTBIT Informer", popup);

                                            MenuItem item = new MenuItem("Close");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent e)
                                                                        {
                                                                            tray.remove(trayIcon);
                                                                            System.exit(0);
                                                                        }
                                                                    });
                                            popup.add(item);

                                            item = new MenuItem("View Notices");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent ae)
                                                                        {
                                                                            EventQueue.invokeLater(new Runnable()
                                                                            {
                                                                                public void run()
                                                                                {
                                                                                    System.out.println("Printed");
                                                                                    new Option().setVisible(true);
                                                                                }
                                                                            });
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
                                                                                    System.out.println("Printed");
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
