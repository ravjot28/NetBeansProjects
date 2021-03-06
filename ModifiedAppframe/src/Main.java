import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.StringTokenizer;

public class Main implements Runnable
{
    TrayIcon trayIcon;
    final SystemTray tray = SystemTray.getSystemTray();
    Thread th = new Thread(this);
    public GraphicsDevice vc;
    Window w;
    static boolean fullscreen=false;

    Main()
    {
        new FullTray();
    }

    public int getNumberOfLines(String name)
    {
	int numberOfLines = 0;
	LineNumberReader lineCounter = null;
	try
        {
            lineCounter = new LineNumberReader(new FileReader(name));
            while ((lineCounter.readLine()) != null)
            {
                continue;
            }
            numberOfLines = lineCounter.getLineNumber();
	} catch (IOException e)
           {}
	return numberOfLines;
    }

    public void run()
    {
        String apps[][]=new String[getNumberOfLines("Bin\\Data\\tags.ravs")][2];
        try
        {
            BufferedReader b= new BufferedReader(new FileReader("Bin\\Data\\tags.ravs"));
            System.out.println("Lines "+getNumberOfLines("Bin\\Data\\tags.ravs"));
            for(int i=0;i<getNumberOfLines("Bin\\Data\\tags.ravs");i++)
            {
                String ravv=b.readLine();
                StringTokenizer t = new StringTokenizer(ravv.trim(),"##");
                System.out.println(t.countTokens());
                System.out.println(apps[i][0]);
                apps[i][0]=t.nextToken();
                apps[i][1]=t.nextToken();
                System.out.println(apps[i][0]+"  "+apps[i][1]);
            }
            b.close();
        }catch(Exception as){}
        GraphicsEnvironment env=GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc=env.getDefaultScreenDevice();
        w = new SpotlightPane(apps);
        w.addMouseListener(new MouseListener()
                            {
                                public void mouseClicked(MouseEvent me)
                                {
                                    w.dispose();
                                }

                                public void mousePressed(MouseEvent me)
                                {

                                }

                                public void mouseReleased(MouseEvent me)
                                {

                                }

                                public void mouseEntered(MouseEvent me)
                                {

                                }

                                public void mouseExited(MouseEvent me)
                                {

                                }
                            });
        if(fullscreen)
        {
            vc.setFullScreenWindow(w);
        }
        w.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e)
            {
                int key =e.getKeyCode();
                if(key==KeyEvent.VK_ESCAPE)
                {
                    w.dispose();
                }

            }
        });
        w.setVisible(true);
	com.sun.awt.AWTUtilities.setWindowOpacity(w, 0.75f);
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
                                            Image image = Toolkit.getDefaultToolkit().getImage("Bin\\img\\redstar.gif");
                                            PopupMenu popup = new PopupMenu();
                                            final TrayIcon trayIcon = new TrayIcon(image,"R App Store", popup);

                                            MenuItem item = new MenuItem("Open");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent e)
                                                                        {
                                                                            if(!w.isShowing())
                                                                            {
                                                                                w.setVisible(true);
                                                                                com.sun.awt.AWTUtilities.setWindowOpacity(w, 0.75f);
                                                                            }
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

                                            item = new MenuItem("Full Screen Mode");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent ae)
                                                                        {
                                                                            w.dispose();
                                                                            fullscreen=true;
                                                                            vc.setFullScreenWindow(w);
                                                                            w.setVisible(true);
                                                                            //com.sun.awt.AWTUtilities.setWindowOpacity(w, 0.75f);
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
