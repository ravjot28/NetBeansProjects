package com.messenger.service;

/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Image;
/*     */ import java.awt.MenuItem;
/*     */ import java.awt.PopupMenu;
/*     */ import java.awt.SystemTray;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.TrayIcon;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ 
/*     */ public class Main
/*     */   implements Runnable
/*     */ {
/*     */   TrayIcon trayIcon;
/*  17 */   final SystemTray tray = SystemTray.getSystemTray();
/*  18 */   Thread th = new Thread(this);
/*     */ 
/*     */   public static void main(String[] spp)
/*     */   {
/*  22 */     new Main();
/*     */   }
/*     */ 
/*     */   Main()
/*     */   {
/*  28 */     String fname = "Notices\\UserInfo\\userinfo.ravs";
/*     */ 
/*  30 */     File f = new File(fname);
/*  31 */     if ((f.exists()) && (f.length() != 0L))
/*     */     {
/*  33 */       new Main.FullTray();
/*     */     }
/*     */     else
/*     */     {
/*  37 */       EventQueue.invokeLater(new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/*  41 */           new First().setVisible(true);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*  49 */     String yr = "";
/*  50 */     String br = "";
/*     */     try
/*     */     {
/*  54 */       BufferedReader b = new BufferedReader(new FileReader("Notices\\UserInfo\\userinfo.ravs"));
/*  55 */       br = b.readLine().trim();
/*  56 */       yr = b.readLine().trim();
/*  57 */       b.close(); } catch (Exception as) {
/*     */     }
/*  59 */     new InboxReader(yr, br);
/*     */   }
/*     */ 
/*     */   class FullTray
/*     */   {
/*     */     FullTray()
/*     */     {
/*  87 */       Main.this.th.start();
/*  88 */       Runnable runner = new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/*  92 */           if (SystemTray.isSupported())
/*     */           {
/*  95 */             Image image = Toolkit.getDefaultToolkit().getImage("img\\icon.jpg");
/*  96 */             PopupMenu popup = new PopupMenu();
/*  97 */             final TrayIcon trayIcon = new TrayIcon(image, "GTBIT Informer", popup);
/*     */ 
/*  99 */             MenuItem item = new MenuItem("Close");
/* 100 */             item.addActionListener(new ActionListener()
/*     */             {
/*     */               public void actionPerformed(ActionEvent e)
/*     */               {
/* 104 */                 Main.this.tray.remove(trayIcon);
/* 105 */                 System.exit(0);
/*     */               }
/*     */             });
/* 108 */             popup.add(item);
/*     */ 
/* 110 */             item = new MenuItem("About");
/* 111 */             item.addActionListener(new ActionListener()
/*     */             {
/*     */               public void actionPerformed(ActionEvent ae)
/*     */               {
/* 115 */                 EventQueue.invokeLater(new Runnable()
/*     */                 {
/*     */                   public void run()
/*     */                   {
/*     */                   }
/*     */                 });
/*     */               }
/*     */             });
/* 124 */             popup.add(item);
/*     */             try
/*     */             {
/* 128 */               Main.this.tray.add(trayIcon);
/*     */             }
/*     */             catch (Exception easd)
/*     */             {
/* 132 */               System.err.println("Can't add to tray");
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 137 */             System.err.println("Tray unavailable");
/*     */           }
/*     */         }
/*     */       };
/* 142 */       EventQueue.invokeLater(runner);
/*     */     }
/*     */ 
/*     */     class ShowMessageListener
/*     */       implements ActionListener
/*     */     {
/*     */       TrayIcon trayIcon;
/*     */       String title;
/*     */       String message;
/*     */       TrayIcon.MessageType messageType;
/*     */ 
/*     */       ShowMessageListener(TrayIcon trayIcon, String title, String message, TrayIcon.MessageType messageType)
/*     */       {
/*  73 */         this.trayIcon = trayIcon;
/*  74 */         this.title = title;
/*  75 */         this.message = message;
/*  76 */         this.messageType = messageType;
/*     */       }
/*     */ 
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/*  81 */         this.trayIcon.displayMessage(this.title, this.message, this.messageType);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Ravjot\Desktop\Notice Messenger\New Student Messsenger\MessengerStudent.jar
 * Qualified Name:     Main
 * JD-Core Version:    0.6.2
 */