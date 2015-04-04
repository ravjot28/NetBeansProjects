package com.messenger.service;

/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.FileWriter;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ public class MessengerPage extends JFrame
/*     */   implements Runnable
/*     */ {
/*  22 */   Thread th = new Thread(this);
/*     */   JButton jButton1;
/*     */   JButton jButton2;
/*     */   JCheckBox jCheckBox1;
/*     */   JCheckBox jCheckBox2;
/*     */   JCheckBox jCheckBox3;
/*     */   JCheckBox jCheckBox4;
/*     */   JCheckBox jCheckBox5;
/*     */   JCheckBox jCheckBox6;
/*     */   JLabel jLabel1;
/*     */   JLabel jLabel2;
/*     */   JLabel jLabel3;
/*     */   JLabel jLabel4;
/*     */   JRadioButton jRadioButton1;
/*     */   JRadioButton jRadioButton2;
/*     */   JRadioButton jRadioButton3;
/*     */   JRadioButton jRadioButton4;
/*     */   JRadioButton jRadioButton5;
/*     */   JRadioButton jRadioButton6;
/*     */   JRadioButton jRadioButton7;
/*     */   JRadioButton jRadioButton8;
/*     */   JRadioButton jRadioButton9;
/*     */   JScrollPane jScrollPane1;
/*     */   JTextArea jTextArea1;
/*  46 */   String surcode = "";
/*     */   private InfiniteProgressPanel glassPane;
/*     */   private String tname;
/*  51 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*  52 */   int w = (int)this.tk.getScreenSize().getWidth();
/*  53 */   int h = (int)this.tk.getScreenSize().getHeight();
/*     */ 
/*     */   public MessengerPage(String t)
/*     */   {
/*  57 */     this.tname = t;
/*  58 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  63 */     this.jRadioButton1 = new JRadioButton();
/*  64 */     this.jRadioButton2 = new JRadioButton();
/*  65 */     this.jRadioButton3 = new JRadioButton();
/*  66 */     this.jRadioButton4 = new JRadioButton();
/*  67 */     this.jRadioButton5 = new JRadioButton();
/*  68 */     this.jRadioButton6 = new JRadioButton();
/*  69 */     this.jRadioButton7 = new JRadioButton();
/*  70 */     this.jRadioButton8 = new JRadioButton();
/*  71 */     this.jRadioButton9 = new JRadioButton();
/*  72 */     this.jCheckBox1 = new JCheckBox();
/*  73 */     this.jCheckBox2 = new JCheckBox();
/*  74 */     this.jCheckBox3 = new JCheckBox();
/*  75 */     this.jCheckBox4 = new JCheckBox();
/*  76 */     this.jScrollPane1 = new JScrollPane();
/*  77 */     this.jTextArea1 = new JTextArea();
/*  78 */     this.jCheckBox5 = new JCheckBox();
/*  79 */     this.jButton1 = new JButton();
/*  80 */     this.jButton2 = new JButton();
/*  81 */     this.jLabel1 = new JLabel();
/*  82 */     this.jCheckBox6 = new JCheckBox();
/*  83 */     this.jLabel2 = new JLabel();
/*  84 */     this.jLabel3 = new JLabel();
/*  85 */     this.jLabel4 = new JLabel();
/*     */ 
/*  87 */     this.glassPane = new InfiniteProgressPanel();
/*     */ 
/*  90 */     setName("GTBIT Messenger");
/*  91 */     setIconImage(new ImageIcon("img/r.gif").getImage());
/*  92 */     setDefaultCloseOperation(3);
/*  93 */     setMaximumSize(new Dimension(724, 535));
/*  94 */     setMinimumSize(new Dimension(724, 535));
/*  95 */     setPreferredSize(new Dimension(724, 535));
/*  96 */     setBackground(new Color(255, 255, 255));
/*  97 */     getContentPane().setLayout(null);
/*  98 */     setGlassPane(this.glassPane);
/*     */ 
/* 100 */     this.jRadioButton1.setText("CSE-1");
/*     */ 
/* 102 */     getContentPane().add(this.jRadioButton1);
/* 103 */     this.jRadioButton1.setBounds(521, 65, 71, 23);
/*     */ 
/* 105 */     this.jRadioButton2.setText("CSE-2");
/*     */ 
/* 107 */     getContentPane().add(this.jRadioButton2);
/* 108 */     this.jRadioButton2.setBounds(610, 65, 71, 23);
/*     */ 
/* 110 */     this.jRadioButton3.setText("ECE-1");
/* 111 */     getContentPane().add(this.jRadioButton3);
/* 112 */     this.jRadioButton3.setBounds(521, 106, 71, 23);
/*     */ 
/* 114 */     this.jRadioButton4.setText("ECE-2");
/* 115 */     getContentPane().add(this.jRadioButton4);
/* 116 */     this.jRadioButton4.setBounds(610, 106, 71, 23);
/*     */ 
/* 118 */     this.jRadioButton5.setText("IT-1");
/* 119 */     getContentPane().add(this.jRadioButton5);
/* 120 */     this.jRadioButton5.setBounds(521, 147, 60, 23);
/*     */ 
/* 122 */     this.jRadioButton6.setText("IT-2");
/* 123 */     getContentPane().add(this.jRadioButton6);
/* 124 */     this.jRadioButton6.setBounds(610, 147, 60, 23);
/*     */ 
/* 126 */     this.jRadioButton7.setText("EEE-1");
/* 127 */     getContentPane().add(this.jRadioButton7);
/* 128 */     this.jRadioButton7.setBounds(521, 188, 69, 23);
/*     */ 
/* 130 */     this.jRadioButton8.setText("EEE-2");
/* 131 */     getContentPane().add(this.jRadioButton8);
/* 132 */     this.jRadioButton8.setBounds(610, 188, 69, 23);
/*     */ 
/* 134 */     this.jRadioButton9.setText("All");
/* 135 */     getContentPane().add(this.jRadioButton9);
/* 136 */     this.jRadioButton9.setBounds(521, 229, 49, 23);
/* 137 */     this.jRadioButton9.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent sd)
/*     */       {
/* 141 */         if (MessengerPage.this.jRadioButton9.isSelected())
/*     */         {
/* 143 */           MessengerPage.this.jRadioButton1.setSelected(true);
/* 144 */           MessengerPage.this.jRadioButton2.setSelected(true);
/* 145 */           MessengerPage.this.jRadioButton3.setSelected(true);
/* 146 */           MessengerPage.this.jRadioButton4.setSelected(true);
/* 147 */           MessengerPage.this.jRadioButton5.setSelected(true);
/* 148 */           MessengerPage.this.jRadioButton6.setSelected(true);
/* 149 */           MessengerPage.this.jRadioButton7.setSelected(true);
/* 150 */           MessengerPage.this.jRadioButton8.setSelected(true);
/*     */ 
/* 152 */           MessengerPage.this.jRadioButton1.setEnabled(false);
/* 153 */           MessengerPage.this.jRadioButton2.setEnabled(false);
/* 154 */           MessengerPage.this.jRadioButton3.setEnabled(false);
/* 155 */           MessengerPage.this.jRadioButton4.setEnabled(false);
/* 156 */           MessengerPage.this.jRadioButton5.setEnabled(false);
/* 157 */           MessengerPage.this.jRadioButton6.setEnabled(false);
/* 158 */           MessengerPage.this.jRadioButton7.setEnabled(false);
/* 159 */           MessengerPage.this.jRadioButton8.setEnabled(false);
/*     */         }
/*     */         else
/*     */         {
/* 163 */           MessengerPage.this.jRadioButton1.setSelected(false);
/* 164 */           MessengerPage.this.jRadioButton2.setSelected(false);
/* 165 */           MessengerPage.this.jRadioButton3.setSelected(false);
/* 166 */           MessengerPage.this.jRadioButton4.setSelected(false);
/* 167 */           MessengerPage.this.jRadioButton5.setSelected(false);
/* 168 */           MessengerPage.this.jRadioButton6.setSelected(false);
/* 169 */           MessengerPage.this.jRadioButton7.setSelected(false);
/* 170 */           MessengerPage.this.jRadioButton8.setSelected(false);
/* 171 */           MessengerPage.this.jRadioButton1.setEnabled(true);
/* 172 */           MessengerPage.this.jRadioButton2.setEnabled(true);
/* 173 */           MessengerPage.this.jRadioButton3.setEnabled(true);
/* 174 */           MessengerPage.this.jRadioButton4.setEnabled(true);
/* 175 */           MessengerPage.this.jRadioButton5.setEnabled(true);
/* 176 */           MessengerPage.this.jRadioButton6.setEnabled(true);
/* 177 */           MessengerPage.this.jRadioButton7.setEnabled(true);
/* 178 */           MessengerPage.this.jRadioButton8.setEnabled(true);
/*     */         }
/*     */       }
/*     */     });
/* 184 */     this.jCheckBox1.setText("1st Year");
/* 185 */     getContentPane().add(this.jCheckBox1);
/* 186 */     this.jCheckBox1.setBounds(521, 294, 83, 23);
/*     */ 
/* 188 */     this.jCheckBox2.setText("2nd Year");
/* 189 */     getContentPane().add(this.jCheckBox2);
/* 190 */     this.jCheckBox2.setBounds(611, 294, 87, 23);
/*     */ 
/* 192 */     this.jCheckBox3.setText("3rd Year");
/* 193 */     getContentPane().add(this.jCheckBox3);
/* 194 */     this.jCheckBox3.setBounds(521, 335, 84, 23);
/*     */ 
/* 196 */     this.jCheckBox4.setText("4th Year");
/* 197 */     getContentPane().add(this.jCheckBox4);
/* 198 */     this.jCheckBox4.setBounds(612, 335, 84, 23);
/*     */ 
/* 200 */     this.jTextArea1.setColumns(20);
/* 201 */     this.jTextArea1.setRows(5);
/* 202 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/* 203 */     this.jTextArea1.setWrapStyleWord(true);
/* 204 */     this.jTextArea1.setLineWrap(true);
/*     */ 
/* 206 */     getContentPane().add(this.jScrollPane1);
/* 207 */     this.jScrollPane1.setBounds(20, 65, 495, 362);
/*     */ 
/* 209 */     this.jCheckBox5.setText("Survey");
/* 210 */     getContentPane().add(this.jCheckBox5);
/* 211 */     this.jCheckBox5.setBounds(521, 427, 73, 23);
/*     */ 
/* 213 */     this.jButton1.setText("Send");
/* 214 */     getContentPane().add(this.jButton1);
/* 215 */     this.jButton1.setBounds(232, 470, 75, 29);
/*     */ 
/* 217 */     this.jButton2.setText("Log Out");
/* 218 */     getContentPane().add(this.jButton2);
/* 219 */     this.jButton2.setBounds(370, 470, 94, 29);
/*     */ 
/* 221 */     this.jLabel1.setFont(new Font("Zapfino", 1, 18));
/* 222 */     this.jLabel1.setText("Welcome To GTBIT Messenger");
/* 223 */     getContentPane().add(this.jLabel1);
/* 224 */     this.jLabel1.setBounds(8, 0, 358, 61);
/*     */ 
/* 226 */     this.jCheckBox6.setText("All");
/* 227 */     getContentPane().add(this.jCheckBox6);
/* 228 */     this.jCheckBox6.setBounds(521, 376, 49, 23);
/* 229 */     this.jCheckBox6.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent ae)
/*     */       {
/* 233 */         if (MessengerPage.this.jCheckBox6.isSelected())
/*     */         {
/* 235 */           MessengerPage.this.jCheckBox1.setSelected(true);
/* 236 */           MessengerPage.this.jCheckBox2.setSelected(true);
/* 237 */           MessengerPage.this.jCheckBox3.setSelected(true);
/* 238 */           MessengerPage.this.jCheckBox4.setSelected(true);
/*     */ 
/* 240 */           MessengerPage.this.jCheckBox1.setEnabled(false);
/* 241 */           MessengerPage.this.jCheckBox2.setEnabled(false);
/* 242 */           MessengerPage.this.jCheckBox3.setEnabled(false);
/* 243 */           MessengerPage.this.jCheckBox4.setEnabled(false);
/*     */         }
/*     */         else
/*     */         {
/* 247 */           MessengerPage.this.jCheckBox1.setSelected(false);
/* 248 */           MessengerPage.this.jCheckBox2.setSelected(false);
/* 249 */           MessengerPage.this.jCheckBox3.setSelected(false);
/* 250 */           MessengerPage.this.jCheckBox4.setSelected(false);
/*     */ 
/* 252 */           MessengerPage.this.jCheckBox1.setEnabled(true);
/* 253 */           MessengerPage.this.jCheckBox2.setEnabled(true);
/* 254 */           MessengerPage.this.jCheckBox3.setEnabled(true);
/* 255 */           MessengerPage.this.jCheckBox4.setEnabled(true);
/*     */         }
/*     */       }
/*     */     });
/* 261 */     this.jLabel2.setText("Branch");
/* 262 */     getContentPane().add(this.jLabel2);
/* 263 */     this.jLabel2.setBounds(521, 35, 42, 16);
/*     */ 
/* 265 */     this.jLabel3.setText("Year");
/* 266 */     getContentPane().add(this.jLabel3);
/* 267 */     this.jLabel3.setBounds(521, 274, 27, 16);
/* 268 */     getContentPane().add(this.jLabel4);
/* 269 */     this.jLabel4.setIcon(new ImageIcon("img/3.jpg"));
/* 270 */     this.jLabel4.setBounds(0, 0, 725, 513);
/* 271 */     this.jButton1.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent sd)
/*     */       {
/* 275 */         MessengerPage.this.th.start();
/*     */       }
/*     */     });
/* 279 */     this.jButton2.addActionListener(new ActionListener() {
/* 280 */       public void actionPerformed(ActionEvent sd) { System.exit(0); }
/*     */ 
/*     */     });
/* 282 */     setName("GTBIT Messenger");
/* 283 */     setIconImage(new ImageIcon("img/r.gif").getImage());
/* 284 */     setTitle("GTBIT Messenger");
/* 285 */     pack();
/* 286 */     setLocation(this.h / 2, this.w / 8);
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/* 292 */     String year = "";
/* 293 */     String branch = "";
/* 294 */     String survey = "";
/* 295 */     if (this.jCheckBox6.isSelected())
/*     */     {
/* 297 */       year = "1,2,3,4,";
/*     */     }
/*     */     else
/*     */     {
/* 301 */       if (this.jCheckBox1.isSelected())
/*     */       {
/* 303 */         year = year + "1,";
/*     */       }
/* 305 */       if (this.jCheckBox2.isSelected())
/*     */       {
/* 307 */         year = year + "2,";
/*     */       }
/* 309 */       if (this.jCheckBox3.isSelected())
/*     */       {
/* 311 */         year = year + "3,";
/*     */       }
/* 313 */       if (this.jCheckBox4.isSelected())
/*     */       {
/* 315 */         year = year + "4,";
/*     */       }
/*     */     }
/* 318 */     if (this.jRadioButton9.isSelected())
/*     */     {
/* 320 */       branch = "CSE-1,CSE-2,ECE-1,ECE-2,IT-1,IT-2,EEE-1,EEE-2,";
/*     */     }
/*     */     else
/*     */     {
/* 324 */       if (this.jRadioButton1.isSelected())
/*     */       {
/* 326 */         branch = branch + "CSE-1,";
/*     */       }
/*     */ 
/* 329 */       if (this.jRadioButton2.isSelected())
/*     */       {
/* 331 */         branch = branch + "CSE-2,";
/*     */       }
/* 333 */       if (this.jRadioButton3.isSelected())
/*     */       {
/* 335 */         branch = branch + "ECE-1,";
/*     */       }
/*     */ 
/* 338 */       if (this.jRadioButton4.isSelected())
/*     */       {
/* 340 */         branch = branch + "ECE-2,";
/*     */       }
/*     */ 
/* 343 */       if (this.jRadioButton5.isSelected())
/*     */       {
/* 345 */         branch = branch + "IT-1,";
/*     */       }
/*     */ 
/* 348 */       if (this.jRadioButton6.isSelected())
/*     */       {
/* 350 */         branch = branch + "IT-2,";
/*     */       }
/*     */ 
/* 353 */       if (this.jRadioButton7.isSelected())
/*     */       {
/* 355 */         branch = branch + "EEE-1,";
/*     */       }
/*     */ 
/* 358 */       if (this.jRadioButton8.isSelected())
/*     */       {
/* 360 */         branch = branch + "EEE-2,";
/*     */       }
/*     */     }
/*     */ 
/* 364 */     if (this.jCheckBox5.isSelected())
/*     */     {
/* 366 */       survey = "yes";
/*     */     }
/*     */     else
/*     */     {
/* 370 */       survey = "no";
/*     */     }
/*     */ 
/* 373 */     if (branch.equalsIgnoreCase(""))
/*     */     {
/* 375 */       JOptionPane.showMessageDialog(null, "OOPs!!! Select Branch(es)", "Error", 0);
/*     */     }
/* 378 */     else if (year.equalsIgnoreCase(""))
/*     */     {
/* 380 */       JOptionPane.showMessageDialog(null, "OOPs!!! Select Year(s)", "Error", 0);
/*     */     }
/* 383 */     else if (this.jTextArea1.getText().trim().length() <= 0)
/*     */     {
/* 385 */       if (survey.equalsIgnoreCase("no"))
/*     */       {
/* 387 */         JOptionPane.showMessageDialog(null, "OOPs!!! Please write the Notice", "Error", 0);
/*     */       }
/*     */       else
/*     */       {
/* 391 */         JOptionPane.showMessageDialog(null, "OOPs!!! Please write the Survey", "Error", 0);
/*     */       }
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 405 */       int answer = 100;
/* 406 */       if (survey.equalsIgnoreCase("no"))
/*     */       {
/* 408 */         answer = JOptionPane.showConfirmDialog(null, "Should I send the notice?", "Confirmation", 0);
/*     */       }
/*     */       else
/*     */       {
/* 412 */         answer = JOptionPane.showConfirmDialog(null, "Should I send the Survey?", "Confirmation", 0);
/*     */       }
/*     */ 
/* 415 */       if (answer == 0)
/*     */       {
/* 417 */         String text = this.jTextArea1.getText();
/* 418 */         this.surcode = DateUtils.now();
/* 419 */         String sub = year + "##" + branch + "##" + survey + this.tname + this.surcode + "##" + new Calendar1().getdate() + "##" + this.tname + "##";
/* 420 */         String[] to = { "ravnotifier@gmail.com" };
/* 421 */         this.glassPane.start();
/* 422 */         sending s = new sending("gtbitinfo1@gmail.com", text, sub, to, "docomo3401");
/* 423 */         String check = s.send();
/* 424 */         if (check.equalsIgnoreCase("caught"))
/*     */         {
/* 426 */           this.glassPane.stop();
/* 427 */           JOptionPane.showMessageDialog(null, "Network Problem Please check your internet connection", "Error", 0);
/*     */         }
/* 431 */         else if (survey.equalsIgnoreCase("yes"))
/*     */         {
/*     */           try
/*     */           {
/* 436 */             BufferedWriter b = new BufferedWriter(new FileWriter("Bin/Data/Surveys/" + this.tname + this.surcode + ".ravs"));
/* 437 */             b.close(); } catch (Exception sdsdf) {
/*     */           }
/* 439 */           this.glassPane.stop();
/* 440 */           JOptionPane.showMessageDialog(null, "Survey Sent", "Confirmation", 1);
/*     */         }
/*     */         else
/*     */         {
/* 444 */           this.glassPane.stop();
/* 445 */           JOptionPane.showMessageDialog(null, "Notice Sent", "Confirmation", 1);
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 451 */     this.jTextArea1.setText("");
/* 452 */     this.jCheckBox1.setSelected(false);
/* 453 */     this.jCheckBox2.setSelected(false);
/* 454 */     this.jCheckBox3.setSelected(false);
/* 455 */     this.jCheckBox4.setSelected(false);
/* 456 */     this.jCheckBox5.setSelected(false);
/*     */ 
/* 458 */     this.jCheckBox1.setEnabled(true);
/* 459 */     this.jCheckBox2.setEnabled(true);
/* 460 */     this.jCheckBox3.setEnabled(true);
/* 461 */     this.jCheckBox4.setEnabled(true);
/* 462 */     this.jRadioButton1.setSelected(false);
/* 463 */     this.jRadioButton2.setSelected(false);
/* 464 */     this.jRadioButton3.setSelected(false);
/* 465 */     this.jRadioButton4.setSelected(false);
/* 466 */     this.jRadioButton5.setSelected(false);
/* 467 */     this.jRadioButton6.setSelected(false);
/* 468 */     this.jRadioButton7.setSelected(false);
/* 469 */     this.jRadioButton8.setSelected(false);
/* 470 */     this.jRadioButton1.setEnabled(true);
/* 471 */     this.jRadioButton2.setEnabled(true);
/* 472 */     this.jRadioButton3.setEnabled(true);
/* 473 */     this.jRadioButton4.setEnabled(true);
/* 474 */     this.jRadioButton5.setEnabled(true);
/* 475 */     this.jRadioButton6.setEnabled(true);
/* 476 */     this.jRadioButton7.setEnabled(true);
/* 477 */     this.jRadioButton8.setEnabled(true);
/* 478 */     this.jRadioButton9.setSelected(false);
/* 479 */     dispose();
/* 480 */     new MessengerPage(this.tname).setVisible(true);
/*     */   }
/*     */ }

/* Location:           D:\Harjyot Project\Notice Messenger\HOD\Messenger.jar
 * Qualified Name:     MessengerPage
 * JD-Core Version:    0.6.2
 */