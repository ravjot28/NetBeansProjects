package com.messenger.service;

/*     */ import java.awt.Component;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.FileWriter;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ 
/*     */ public class First extends JFrame
/*     */ {
/*  10 */   String fname = "Bin/Data/UserInfo/userinfo.ravs";
/*     */   String name;
/*  12 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  13 */   int w = (int)this.tk.getScreenSize().getWidth();
/*  14 */   int h = (int)this.tk.getScreenSize().getHeight();
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JPanel jPanel1;
/*     */   private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   private JTextField jTextField3;
/*     */   private JTextField jTextField4;
/*     */   private JTextField jTextField5;
/*     */ 
/*     */   public First()
/*     */   {
/*  17 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  29 */     this.jTextField3 = new JTextField();
/*  30 */     this.jPanel1 = new JPanel();
/*  31 */     this.jLabel1 = new JLabel();
/*  32 */     this.jLabel2 = new JLabel();
/*  33 */     this.jLabel3 = new JLabel();
/*  34 */     this.jLabel4 = new JLabel();
/*  35 */     this.jTextField1 = new JTextField();
/*  36 */     this.jTextField2 = new JTextField();
/*  37 */     this.jTextField4 = new JTextField();
/*  38 */     this.jTextField5 = new JTextField();
/*  39 */     this.jButton1 = new JButton();
/*  40 */     this.jButton2 = new JButton();
/*     */ 
/*  42 */     this.jTextField3.setText("jTextField3");
/*     */ 
/*  44 */     setDefaultCloseOperation(3);
/*     */ 
/*  46 */     this.jLabel1.setText("Name");
/*     */ 
/*  48 */     this.jLabel2.setText("Designation");
/*     */ 
/*  50 */     this.jLabel3.setText("Department");
/*     */ 
/*  52 */     this.jLabel4.setText("Email Id");
/*     */ 
/*  54 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  55 */     this.jPanel1.setLayout(jPanel1Layout);
/*  56 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel2, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel4, GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextField2, -2, -1, -2).addComponent(this.jTextField4, -2, -1, -2).addComponent(this.jTextField5, -2, -1, -2).addComponent(this.jTextField1, -2, 214, -2)).addContainerGap(-1, 32767)));
/*     */ 
/*  74 */     jPanel1Layout.linkSize(0, new Component[] { this.jLabel1, this.jLabel2, this.jLabel3, this.jLabel4 });
/*     */ 
/*  76 */     jPanel1Layout.linkSize(0, new Component[] { this.jTextField1, this.jTextField2, this.jTextField4, this.jTextField5 });
/*     */ 
/*  78 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTextField1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTextField2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTextField4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jTextField5, -2, -1, -2)).addContainerGap(83, 32767)));
/*     */ 
/* 100 */     this.jButton1.setText("Submit");
/* 101 */     this.jButton1.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent ae)
/*     */       {
/*     */         try
/*     */         {
/* 107 */           BufferedWriter b = new BufferedWriter(new FileWriter("Bin/Data/UserInfo/userinfo.ravs"));
/* 108 */           b.append(First.this.jTextField1.getText().trim());
/* 109 */           b.close(); } catch (Exception as) {
/*     */         }
/* 111 */         First.this.dispose();
/* 112 */         EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 114 */             new Option().setVisible(true);
/*     */           }
/*     */         });
/*     */       }
/*     */     });
/* 120 */     this.jButton2.setText("Cancel");
/* 121 */     this.jButton2.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent ae)
/*     */       {
/* 125 */         System.exit(0);
/*     */       }
/*     */     });
/* 129 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 130 */     getContentPane().setLayout(layout);
/* 131 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(50, 50, 50).addComponent(this.jButton1).addGap(61, 61, 61).addComponent(this.jButton2)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2))).addContainerGap(81, 32767)));
/*     */ 
/* 145 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(48, 32767)));
/*     */ 
/* 156 */     setName("GTBIT Messenger");
/* 157 */     setIconImage(new ImageIcon("img/r.gif").getImage());
/* 158 */     setTitle("GTBIT Messenger");
/* 159 */     pack();
/* 160 */     setLocation(this.h / 2, this.w / 6);
/*     */   }
/*     */ }

/* Location:           D:\Harjyot Project\Notice Messenger\HOD\Messenger.jar
 * Qualified Name:     First
 * JD-Core Version:    0.6.2
 */