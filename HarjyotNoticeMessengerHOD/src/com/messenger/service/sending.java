package com.messenger.service;

/*    */ import com.sun.net.ssl.internal.ssl.Provider;
/*    */ import java.security.Security;
/*    */ import java.util.Properties;
/*    */ import javax.mail.Authenticator;
/*    */ import javax.mail.Message;
/*    */ import javax.mail.PasswordAuthentication;
/*    */ import javax.mail.Session;
/*    */ import javax.mail.Transport;
/*    */ import javax.mail.internet.InternetAddress;
/*    */ import javax.mail.internet.MimeMessage;
/*    */ 
/*    */ public class sending
/*    */ {
/*    */   private static final String SMTP_HOST_NAME = "smtp.gmail.com";
/*    */   private static final String SMTP_PORT = "465";
/*    */   private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
/* 11 */   String MsgTxt = null;
/* 12 */   String Subject = null;
/* 13 */   String From = null;
/* 14 */   String pwd = null;
/*    */   String[] too;
/* 16 */   String ss = "";
/*    */ 
/*    */   public sending(String fr, String msg, String sub, String[] fro, String p)
/*    */   {
/* 20 */     this.MsgTxt = msg;
/* 21 */     this.Subject = sub;
/* 22 */     this.From = fr;
/* 23 */     this.pwd = p;
/* 24 */     this.too = fro;
/*    */   }
/*    */ 
/*    */   public String send()
/*    */   {
/* 29 */     String s = "";
/* 30 */     Security.addProvider(new Provider());
/*    */     try
/*    */     {
/* 33 */       sendSSLMessage(this.too, this.Subject, this.MsgTxt, this.From, this.pwd);
/*    */     }
/*    */     catch (Exception e) {
/* 36 */       s = e.getMessage();
/*    */     }
/* 38 */     if (s.equals(""))
/*    */     {
/* 40 */       s = "Your message is successfully mailed";
/*    */     }
/* 42 */     return this.ss;
/*    */   }
/*    */ 
/*    */   public void sendSSLMessage(String[] recipients, String subject, String message, String from, String pwd)
/*    */   {
/*    */     try
/*    */     {
/* 50 */       boolean debug = false;
/* 51 */       Properties props = new Properties();
/* 52 */       props.put("mail.smtp.host", "smtp.gmail.com");
/* 53 */       props.put("mail.smtp.auth", "true");
/* 54 */       props.put("mail.debug", "true");
/* 55 */       props.put("mail.smtp.port", "465");
/* 56 */       props.put("mail.smtp.socketFactory.port", "465");
/* 57 */       props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
/* 58 */       props.put("mail.smtp.socketFactory.fallback", "false");
/* 59 */       final String from1 = from;
/* 60 */       final String pwd1 = pwd;
/* 61 */       Session session = Session.getDefaultInstance(props, new Authenticator() {
/*    */         protected PasswordAuthentication getPasswordAuthentication() {
/* 63 */           return new PasswordAuthentication(from1, pwd1);
/*    */         }
/*    */       });
/* 65 */       session.setDebug(debug);
/*    */ 
/* 67 */       Message msg = new MimeMessage(session);
/* 68 */       InternetAddress addressFrom = new InternetAddress(from);
/* 69 */       msg.setFrom(addressFrom);
/*    */ 
/* 71 */       InternetAddress[] addressTo = new InternetAddress[recipients.length];
/* 72 */       for (int i = 0; i < recipients.length; i++)
/*    */       {
/* 74 */         addressTo[i] = new InternetAddress(recipients[i]);
/*    */       }
/* 76 */       msg.setRecipients(Message.RecipientType.TO, addressTo);
/*    */ 
/* 78 */       msg.setSubject(subject);
/* 79 */       msg.setContent(message, "text/plain");
/* 80 */       Transport.send(msg);
/* 81 */       from = null;
/* 82 */       recipients = null;
/* 83 */       pwd = null;
/* 84 */       subject = null;
/* 85 */       message = null; } catch (Exception asda) {
/* 86 */       this.ss = "caught";
/*    */     }
/*    */   }
/*    */ }

/* Location:           D:\Harjyot Project\Notice Messenger\HOD\Messenger.jar
 * Qualified Name:     sending
 * JD-Core Version:    0.6.2
 */