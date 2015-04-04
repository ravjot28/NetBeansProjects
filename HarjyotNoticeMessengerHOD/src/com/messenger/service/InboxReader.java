package com.messenger.service;

/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.util.Date;
/*     */ import java.util.Properties;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.mail.Address;
/*     */ import javax.mail.Flags;
/*     */ import javax.mail.Folder;
/*     */ import javax.mail.Message;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Store;
/*     */ import javax.mail.search.FlagTerm;
/*     */ import org.jfree.ui.RefineryUtilities;
/*     */ 
/*     */ public class InboxReader
/*     */ {
/*  22 */   static String messagess = ",";
/*     */   Session session;
/*     */   Store store;
/*     */   String[][] aaa;
/*  26 */   boolean exception = false;
/*     */   String fname1;
/*  28 */   boolean stop = false;
/*     */ 
/* 180 */   static String indentStr = "                                               ";
/* 181 */   static int level = 0;
/*     */ 
/*     */   InboxReader(String f2)
/*     */   {
/*  31 */     this.fname1 = f2;
/*  32 */     File f = new File("id1.ravs");
/*  33 */     if (f.exists())
/*     */     {
/*     */       try
/*     */       {
/*  37 */         BufferedReader b = new BufferedReader(new FileReader("id1.ravs"));
/*  38 */         messagess = b.readLine().trim(); } catch (Exception ad) {
/*     */       }
/*     */     }
/*  41 */     Properties props = System.getProperties();
/*  42 */     props.setProperty("mail.store.protocol", "imaps");
/*     */     try
/*     */     {
/*  45 */       this.session = Session.getDefaultInstance(props, null);
/*  46 */       this.store = this.session.getStore("imaps");
/*  47 */       this.store.connect("imap.gmail.com", "ravsurvey@gmail.com", "ravjotsingh"); } catch (Exception adfasf) {
/*  48 */       System.out.println(adfasf);
/*  49 */     }startreading();
/*     */   }
/*     */ 
/*     */   public void startreading()
/*     */   {
/*  55 */     System.out.println(this.store);
/*     */     try
/*     */     {
/*  58 */       Folder inbox = this.store.getFolder("Inbox");
/*  59 */       inbox.open(1);
/*     */ 
/*  61 */       FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
/*  62 */       Message[] messages = inbox.search(ft);
/*  63 */       Date date = new Date();
/*  64 */       String p = "";
/*  65 */       for (Message message : messages)
/*     */       {
/*  67 */         if (!messagess.contains("," + message.getMessageNumber()))
/*     */         {
/*  69 */           p = p + dumpEnvelope(message) + "$$$";
/*  70 */           int a = message.getMessageNumber();
/*  71 */           messagess = messagess + a + ",";
/*     */         }
/*     */       }
/*  74 */       if (p.length() != 0)
/*     */       {
/*  76 */         StringTokenizer t = new StringTokenizer(p, "$$$");
/*  77 */         String[][] aa = new String[t.countTokens()][3];
/*  78 */         int i = 0;
/*  79 */         while (t.hasMoreTokens())
/*     */         {
/*  81 */           String temp = t.nextToken();
/*  82 */           StringTokenizer t1 = new StringTokenizer(temp, "|");
/*  83 */           int j = 0;
/*  84 */           while (t1.hasMoreTokens())
/*     */           {
/*  86 */             String temp1 = t1.nextElement().toString();
/*  87 */             if (!temp1.contains("TO:"))
/*     */             {
/*  89 */               aa[i][j] = temp1;
/*  90 */               j++;
/*     */             }
/*     */           }
/*  93 */           i++;
/*     */         }
/*  95 */         this.aaa = aa;
/*  96 */         int countt = 0;
/*  97 */         int tot = 0;
/*  98 */         for (int i2 = 0; i2 < this.aaa.length; i2++)
/*     */         {
/* 100 */           String fname = this.aaa[i2][1].replaceAll("SUBJECT: ", "");
/* 101 */           if (fname.equalsIgnoreCase(this.fname1))
/*     */           {
/* 103 */             countt++;
/* 104 */             tot = Integer.parseInt(this.aaa[i2][2].trim());
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 110 */         System.out.println("Count : " + countt + "  Total : " + tot);
/* 111 */         chart demo = new chart("Survey", countt, tot - countt);
/* 112 */         demo.pack();
/* 113 */         RefineryUtilities.centerFrameOnScreen(demo);
/* 114 */         demo.setVisible(true);
/* 115 */         this.stop = true;
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 124 */       this.exception = true;
/* 125 */     }if (!this.stop)
/*     */     {
/*     */       try
/*     */       {
/* 130 */         new Thread(); Thread.sleep(100L); } catch (Exception adf) {
/* 131 */         System.out.println("2");
/* 132 */       }if (this.exception)
/*     */         try {
/* 134 */           this.store.close(); BufferedWriter b = new BufferedWriter(new FileWriter("id1.ravs")); b.append(messagess); b.close(); new InboxReader(this.fname1);
/*     */         }
/*     */         catch (Exception asd) {
/*     */         }
/* 138 */       else startreading();
/*     */ 
/* 141 */       System.out.println("Exception is" + this.exception);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String dumpEnvelope(Message m) throws Exception
/*     */   {
/* 147 */     String a1 = "";
/* 148 */     String a2 = "";
/* 149 */     String a3 = "";
/* 150 */     String a4 = "";
/* 151 */     Date d = m.getSentDate();
/* 152 */     Date date = new Date();
/* 153 */     pr(" ");
/*     */     Address[] a;
/* 156 */     if ((a = m.getFrom()) != null) {
/* 157 */       for (int j = 0; j < a.length; j++) {
/* 158 */         a1 = a1 + pr(new StringBuilder().append("FROM: ").append(a[j].toString()).toString()) + ",";
/*     */       }
/*     */     }
/*     */ 
/* 162 */     if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
/* 163 */       for (int j = 0; j < a.length; j++) {
/* 164 */         a2 = a2 + pr(new StringBuilder().append("TO: ").append(a[j].toString()).toString()) + ",";
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 169 */     a3 = a3 + pr(new StringBuilder().append("SUBJECT: ").append(m.getSubject()).toString());
/*     */ 
/* 171 */     a4 = m.getContent().toString();
/*     */ 
/* 177 */     return a1 + "|" + a2 + "|" + a3 + "|" + a4 + "|";
/*     */   }
/*     */ 
/*     */   public static String pr(String s)
/*     */   {
/* 188 */     System.out.print(indentStr.substring(0, level * 2));
/* 189 */     return s;
/*     */   }
/*     */ }

/* Location:           D:\Harjyot Project\Notice Messenger\HOD\Messenger.jar
 * Qualified Name:     InboxReader
 * JD-Core Version:    0.6.2
 */