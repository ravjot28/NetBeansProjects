import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class GUI extends JFrame
{
    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JButton jButton5;
    JButton jButton6;
    JLabel jLabel1;
    JSlider jSlider1;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    TrayIcon trayIcon;
    final SystemTray tray = SystemTray.getSystemTray();

    public GUI()
    {
        initComponents();
    }

    private void initComponents()
    {
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jLabel1 = new JLabel();
        jSlider1 = new JSlider();

        jSlider1.setValue(100);
        new SetVol().run();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(370,120));
        setTitle("R iTunes Controller");
        setMinimumSize(new Dimension(370,120));
        setMaximumSize(new Dimension(370,120));
        //setUndecorated(true);
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon("Bin/img/play.gif"));
        jButton1.setBorderPainted(false);
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 10, 48, 44);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new Play().run();
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("Bin/img/prev.gif"));
        jButton2.setBorderPainted(false);
        getContentPane().add(jButton2);
        jButton2.setBounds(80, 10, 48, 44);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new Prev().run();
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("Bin/img/next.gif"));
        jButton3.setBorderPainted(false);
        getContentPane().add(jButton3);
        jButton3.setBounds(190, 10, 48, 44);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new Next().run();
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon("Bin/img/stop.gif"));
        jButton4.setBorderPainted(false);
        getContentPane().add(jButton4);
        jButton4.setBounds(240, 10, 48, 44);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new Stop().run();
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon("Bin/img/pause.png"));
        jButton5.setBorderPainted(false);
        getContentPane().add(jButton5);
        jButton5.setBounds(20, 10, 48, 44);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new Pause().run();
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon("Bin/img/tray.gif"));
        jButton6.setBorderPainted(false);
        getContentPane().add(jButton6);
        jButton6.setBounds(300, 10, 48, 44);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
                new FullTray();
            }
        });

        getContentPane().add(jSlider1);
        jSlider1.setBounds(100, 60, 190, 29);
        MyChangeListener lst = new MyChangeListener();
        jSlider1.addChangeListener(lst);

        //jButton7.setIcon(new javax.swing.ImageIcon("/Users/Rav/NetBeansProjects/MaciTunesController/Bin/img/close.png")); // NOI18N
       // jButton7.setBorderPainted(false);
        //getContentPane().add(jButton7);
        //jButton7.setBounds(320, 0, 97, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon("Bin/img/2.jpg"));
        getContentPane().add(jLabel1);
         jLabel1.setBounds(0, 0, 390, 100);

        setResizable(false);
        pack();
        setLocation(h/2,w/5);
    }

    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new GUI().setVisible(true);
            }
        });
    }

    class MyChangeListener implements ChangeListener {
    MyChangeListener() {
    }

    public synchronized void stateChanged(ChangeEvent e) {
      int frequency = jSlider1.getValue();
      new VolDec(frequency).run();

    }
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
                                                                            setVisible(true);
                                                                        }
                                                                    });
                                            popup.add(item);

                                            item = new MenuItem("Play");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent ae)
                                                                        {
                                                                            new Play().run();
                                                                        }
                                                                    });
                                            popup.add(item);

                                            item = new MenuItem("Next");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent ae)
                                                                        {
                                                                            new Next().run();
                                                                        }
                                                                    });
                                            popup.add(item);

                                            item = new MenuItem("Previous");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent ae)
                                                                        {
                                                                            new Prev().run();
                                                                        }
                                                                    });
                                            popup.add(item);

                                            item = new MenuItem("Pause");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent ae)
                                                                        {
                                                                            new Pause().run();
                                                                        }
                                                                    });
                                            popup.add(item);

                                            item = new MenuItem("Stop");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent ae)
                                                                        {
                                                                            new Stop().run();
                                                                        }
                                                                    });
                                            popup.add(item);

                                            item = new MenuItem("Quit iTunes");
                                            item.addActionListener(new ActionListener()
                                                                    {
                                                                        public void actionPerformed(ActionEvent ae)
                                                                        {
                                                                            new Quit().run();
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
