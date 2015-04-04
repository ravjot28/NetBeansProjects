package com.messenger.service;

/*    */ import java.awt.GridLayout;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class Surveys
/*    */   implements ActionListener, Runnable
/*    */ {
/*    */   JButton[] b;
/*    */   String name;
/* 17 */   Thread th = new Thread(this);
/*    */   String fname;
/*    */   private InfiniteProgressPanel glassPane;
/* 20 */   Toolkit tk = Toolkit.getDefaultToolkit();
/* 21 */   int w = (int)this.tk.getScreenSize().getWidth();
/* 22 */   int h = (int)this.tk.getScreenSize().getHeight();
/*    */ 
/*    */   Surveys()
/*    */   {
/* 26 */     String fname = "Bin/Data/UserInfo/userinfo.ravs";
/* 27 */     JFrame frame = new JFrame("Surveys");
/*    */     try
/*    */     {
/* 30 */       BufferedReader b = new BufferedReader(new FileReader(fname));
/* 31 */       this.name = b.readLine().trim();
/* 32 */       b.close(); } catch (Exception asd) {
/*    */     }
/* 34 */     File f = new File("Bin/Data/Surveys/");
/* 35 */     String[] l = f.list();
/* 36 */     this.b = new JButton[l.length];
/*    */ 
/* 38 */     frame.setLayout(new GridLayout(l.length, 0));
/*    */ 
/* 40 */     for (int i = 0; i < l.length; i++)
/*    */     {
/* 42 */       if (!new File("Bin/Data/Surveys/" + l[i]).isHidden())
/*    */       {
/* 44 */         String temp = l[i].replaceAll(".ravs", "").trim();
/* 45 */         temp = temp.replaceAll(this.name, "");
/* 46 */         String yr = temp.substring(0, 4);
/* 47 */         String mn = temp.substring(4, 6);
/* 48 */         String dt = temp.substring(6, 8);
/* 49 */         String nm = dt + "/" + mn + "/" + yr;
/* 50 */         this.b[i] = new JButton("Survey on " + nm);
/* 51 */         this.b[i].setActionCommand(l[i].trim());
/* 52 */         this.b[i].addActionListener(this);
/* 53 */         frame.add(this.b[i]);
/*    */       }
/*    */     }
/* 56 */     this.glassPane = new InfiniteProgressPanel();
/* 57 */     frame.setGlassPane(this.glassPane);
/* 58 */     frame.setName("GTBIT Messenger");
/* 59 */     frame.setIconImage(new ImageIcon("img/r.gif").getImage());
/* 60 */     frame.setDefaultCloseOperation(2);
/* 61 */     frame.pack();
/* 62 */     frame.setTitle("GTBIT Messenger");
/* 63 */     frame.pack();
/* 64 */     frame.setLocation(this.h / 2, this.w / 6);
/* 65 */     frame.setVisible(true);
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent ae)
/*    */   {
/* 70 */     String file = ae.getActionCommand();
/* 71 */     System.out.println("Bin/Data/Surveys/" + file);
/* 72 */     this.fname = file.replaceAll(".ravs", "");
/* 73 */     this.th.start();
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/* 78 */     this.glassPane.start();
/* 79 */     new InboxReader(this.fname);
/* 80 */     this.glassPane.stop();
/* 81 */     new Surveys();
/*    */   }
/*    */ }

/* Location:           D:\Harjyot Project\Notice Messenger\HOD\Messenger.jar
 * Qualified Name:     Surveys
 * JD-Core Version:    0.6.2
 */