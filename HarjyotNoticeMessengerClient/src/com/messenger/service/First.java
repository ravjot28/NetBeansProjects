package com.messenger.service;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class First extends JFrame
        implements Runnable {

    TrayIcon trayIcon;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w = (int) this.tk.getScreenSize().getWidth();
    int h = (int) this.tk.getScreenSize().getHeight();
    final SystemTray tray = SystemTray.getSystemTray();
    Thread th = new Thread(this);
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;

    public First() {
        initComponents();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jTextField2 = new JTextField();
        this.jTextField3 = new JTextField();
        this.jTextField4 = new JTextField();
        this.jTextField5 = new JTextField();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();

        setDefaultCloseOperation(3);

        this.jPanel1.setBorder(BorderFactory.createTitledBorder(null, "STUDENT DETAILS", 0, 0, new Font("Tahoma", 1, 14)));

        this.jLabel1.setText("Name");

        this.jLabel2.setText("Enroll No");

        this.jLabel3.setText("Branch");

        this.jLabel4.setText("Year");

        this.jLabel5.setText("Email id");

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel2, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel4, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel5, GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextField2, -2, -1, -2).addComponent(this.jTextField3, -2, -1, -2).addComponent(this.jTextField4, -2, -1, -2).addComponent(this.jTextField5, -2, -1, -2).addComponent(this.jTextField1, -2, 206, -2)).addContainerGap(42, 32767)));

        jPanel1Layout.linkSize(0, new Component[]{this.jTextField1, this.jTextField2, this.jTextField3, this.jTextField4, this.jTextField5});

        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTextField1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTextField2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTextField3, -2, -1, -2)).addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jTextField4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jTextField5, -2, -1, -2)).addContainerGap(46, 32767)));

        this.jButton1.setText("SUBMIT");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    BufferedWriter b = new BufferedWriter(new FileWriter("Notices\\UserInfo\\userinfo.ravs"));
                    b.append(First.this.jTextField3.getText().trim());
                    b.newLine();
                    b.append(First.this.jTextField4.getText().trim());
                    b.close();
                } catch (Exception as) {
                }
                First.this.dispose();
                new First.FullTray();
            }
        });
        this.jButton2.setText("CANCEL");
        this.jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(66, 66, 66).addComponent(this.jButton1).addGap(62, 62, 62).addComponent(this.jButton2))).addContainerGap(56, 32767)));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(32, 32767)));

        setName("GTBIT Messenger");
        setIconImage(new ImageIcon("img/r.gif").getImage());
        setTitle("GTBIT Messenger");
        pack();
        setLocation(this.h / 2, this.w / 8);
    }

    public void run() {
        String yr = "";
        String br = "";
        try {
            BufferedReader b = new BufferedReader(new FileReader("Notices\\UserInfo\\userinfo.ravs"));
            br = b.readLine().trim();
            yr = b.readLine().trim();
            b.close();
        } catch (Exception as) {
        }
        new InboxReader(yr, br);
    }

    class FullTray {

        FullTray() {
            First.this.th.start();
            Runnable runner = new Runnable() {
                public void run() {
                    if (SystemTray.isSupported()) {
                        Image image = Toolkit.getDefaultToolkit().getImage("img\\icon.jpg");
                        PopupMenu popup = new PopupMenu();
                        final TrayIcon trayIcon = new TrayIcon(image, "GTBIT Informer", popup);

                        MenuItem item = new MenuItem("Close");
                        item.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                First.this.tray.remove(trayIcon);
                                System.exit(0);
                            }
                        });
                        popup.add(item);

                        item = new MenuItem("About");
                        item.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                EventQueue.invokeLater(new Runnable() {
                                    public void run() {
                                    }
                                });
                            }
                        });
                        popup.add(item);
                        try {
                            First.this.tray.add(trayIcon);
                        } catch (Exception easd) {
                            System.err.println("Can't add to tray");
                        }
                    } else {
                        System.err.println("Tray unavailable");
                    }
                }
            };
            EventQueue.invokeLater(runner);
        }

        class ShowMessageListener
                implements ActionListener {

            TrayIcon trayIcon;
            String title;
            String message;
            TrayIcon.MessageType messageType;

            ShowMessageListener(TrayIcon trayIcon, String title, String message, TrayIcon.MessageType messageType) {
                this.trayIcon = trayIcon;
                this.title = title;
                this.message = message;
                this.messageType = messageType;
            }

            public void actionPerformed(ActionEvent e) {
                this.trayIcon.displayMessage(this.title, this.message, this.messageType);
            }
        }
    }
}
