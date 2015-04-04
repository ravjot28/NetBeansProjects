package com.messenger.service;

/*    */ import java.awt.EventQueue;
/*    */ import java.io.File;
/*    */ 
/*    */ public class Main
/*    */ {
/*    */   static String name;
/*    */ 
/*    */   public static void main(String[] asp)
/*    */   {
/* 14 */     String fname = "Bin/Data/UserInfo/userinfo.ravs";
/* 15 */     File f = new File(fname);
/* 16 */     if ((f.exists()) && (f.length() != 0L))
/*    */     {
/* 18 */       EventQueue.invokeLater(new Runnable() {
/*    */         public void run() {
/* 20 */           new Option().setVisible(true);
/*    */         }
/*    */       });
/*    */     }
/*    */     else
/*    */     {
/* 26 */       new First().setVisible(true);
/*    */     }
/*    */   }
/*    */ }

/* Location:           D:\Harjyot Project\Notice Messenger\HOD\Messenger.jar
 * Qualified Name:     Main
 * JD-Core Version:    0.6.2
 */