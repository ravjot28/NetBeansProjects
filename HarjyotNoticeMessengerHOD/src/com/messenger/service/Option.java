package com.messenger.service;

/*     */ import java.awt.Component;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileReader;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class Option extends JFrame
/*     */ {
/*     */   String name;
/*  12 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  13 */   int w = (int)this.tk.getScreenSize().getWidth();
/*  14 */   int h = (int)this.tk.getScreenSize().getHeight();
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JPanel jPanel1;
/*     */ 
/*     */   public Option()
/*     */   {
/*  18 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  30 */     this.jPanel1 = new JPanel();
/*  31 */     this.jButton1 = new JButton();
/*  32 */     this.jButton2 = new JButton();
/*     */ 
/*  34 */     setDefaultCloseOperation(3);
/*     */ 
/*  36 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Welcome To GTBIT Messenger", 0, 0, new Font("Tahoma", 2, 18)));
/*     */ 
/*  38 */     this.jButton1.setText("SURVEY");
/*  39 */     this.jButton1.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { Option.this.dispose(); new Surveys();
/*     */       }
/*     */     });
/*  41 */     this.jButton2.setText("NOTICE");
/*  42 */     this.jButton2.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent ae)
/*     */       {
/*  46 */         Option.this.dispose();
/*  47 */         String fname = "Bin/Data/UserInfo/userinfo.ravs";
/*     */         try
/*     */         {
/*  50 */           BufferedReader b = new BufferedReader(new FileReader(fname));
/*  51 */           Option.this.name = b.readLine().trim();
/*  52 */           b.close(); } catch (Exception asd) {
/*     */         }
/*  54 */         EventQueue.invokeLater(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*  58 */             new MessengerPage(Option.this.name).setVisible(true);
/*     */           }
/*     */         });
/*     */       }
/*     */     });
/*  64 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  65 */     this.jPanel1.setLayout(jPanel1Layout);
/*  66 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(72, 72, 72).addComponent(this.jButton1).addGap(35, 35, 35).addComponent(this.jButton2).addContainerGap(115, 32767)));
/*     */ 
/*  76 */     jPanel1Layout.linkSize(0, new Component[] { this.jButton1, this.jButton2 });
/*     */ 
/*  78 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(46, 46, 46).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(142, 32767)));
/*     */ 
/*  88 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  89 */     getContentPane().setLayout(layout);
/*  90 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
/*     */ 
/*  97 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(29, 32767)));
/*     */ 
/* 104 */     setName("GTBIT Messenger");
/* 105 */     setIconImage(new ImageIcon("img/r.gif").getImage());
/* 106 */     setTitle("GTBIT Messenger");
/* 107 */     pack();
/* 108 */     setLocation(this.h / 2, this.w / 6);
/*     */   }
/*     */ }

/* Location:           D:\Harjyot Project\Notice Messenger\HOD\Messenger.jar
 * Qualified Name:     Option
 * JD-Core Version:    0.6.2
 */