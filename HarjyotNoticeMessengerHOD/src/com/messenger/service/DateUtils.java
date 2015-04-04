package com.messenger.service;

/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ 
/*    */ public class DateUtils
/*    */ {
/*    */   public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
/*    */ 
/*    */   public static String now()
/*    */   {
/* 10 */     Calendar cal = Calendar.getInstance();
/* 11 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 12 */     String a = sdf.format(cal.getTime());
/* 13 */     a = a.replaceAll("-", "");
/* 14 */     a = a.replaceAll(":", "");
/* 15 */     a = a.replaceAll(" ", "");
/* 16 */     return a;
/*    */   }
/*    */ }

/* Location:           D:\Harjyot Project\Notice Messenger\HOD\Messenger.jar
 * Qualified Name:     DateUtils
 * JD-Core Version:    0.6.2
 */