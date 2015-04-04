package GUITest;

import java.awt.Color;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import ravrun.Rav;

public class Main1 implements Runnable
{
    TrayIcon trayIcon;
    final SystemTray tray = SystemTray.getSystemTray();
    Thread th = new Thread(this);
    public GraphicsDevice vc;
    Window w;
    static boolean fullscreen=false;

    int AppsNo;

    public void Process()
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
        AppsNo = getNumberOfLines("Bin\\Data\\tags.ravs");
        String apps[]=new String[getNumberOfLines("Bin\\Data\\tags.ravs")];
        try
        {
            BufferedReader b= new BufferedReader(new FileReader("Bin\\Data\\tags.ravs"));
            for(int i=0;i<getNumberOfLines("Bin\\Data\\tags.ravs");i++)
            {
                StringTokenizer t = new StringTokenizer(b.readLine().trim(),"##");
                String s=t.nextToken();
                apps[i]=t.nextToken();
            }
            b.close();
        }catch(Exception as){}
        GraphicsEnvironment env=GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc=env.getDefaultScreenDevice();
        boolean position=false;
        int p[][] = new int[AppsNo][2];
        int i=0;
        if(new File("Bin\\Data\\Positions.ravs").exists())
        {
            position=true;
            try
            {
                BufferedReader b = new BufferedReader(new FileReader("Bin\\Data\\Positions.ravs"));
                String data=b.readLine();
                while(data!=null)
                {
                    StringTokenizer s = new StringTokenizer(data,",");
                    p[i][0]= Integer.parseInt(s.nextToken().trim());
                    p[i][1]= Integer.parseInt(s.nextToken().trim());
                    i++;
                    data=b.readLine();
                }
            }catch(Exception asd){}
        }
        else
        {
            position=false;
        }
        w = new MainFrame(AppsNo,position,p,apps);
        w.setBackground(Color.DARK_GRAY);
       /* w.addMouseListener(new MouseListener()
                            {
                                public void mouseClicked(MouseEvent me)
                                {
                                    try
                                    {
                                       BufferedWriter b = new BufferedWriter(new FileWriter("Bin\\Data\\Positions.ravs"));
                                       for(int i=0;i<AppsNo;i++)
                                       {
                                           System.out.println("Location "+i+" "+w.getX()+"  "+w.getY());
                                       }
                                    }catch(Exception asd){}
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
                            });*/
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
                else
                    if(key==KeyEvent.VK_F5)
                    {
                         w.dispose();
                         fullscreen=true;
                         vc.setFullScreenWindow(w);
                         w.setVisible(true);
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
                                            Image image = Toolkit.getDefaultToolkit().getImage("Bin/img/r.gif");
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
                                                                            new Rav("Bin\\Note\\ByeSpeech\\ByeSpeech.jar").execute();
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

}
