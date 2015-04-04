package com.messenger.service;

/*    */ import java.util.Calendar;
/*    */ 
/*    */ public class Calendar1
/*    */ {
/*    */   public String getdate()
/*    */   {
/*  7 */     Calendar cal = Calendar.getInstance();
/*  8 */     int day = cal.get(5);
/*  9 */     int month = cal.get(2) + 1;
/* 10 */     int year = cal.get(1);
/* 11 */     return day + "/" + month + "/" + year;
/*    */   }
/*    */ }

/* Location:           D:\Harjyot Project\Notice Messenger\HOD\Messenger.jar
 * Qualified Name:     Calendar1
 * JD-Core Version:    0.6.2
 */