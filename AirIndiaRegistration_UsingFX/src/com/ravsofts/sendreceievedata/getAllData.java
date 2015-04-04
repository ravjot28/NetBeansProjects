package com.ravsofts.sendreceievedata;

import java.util.Properties;
import java.util.StringTokenizer;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class getAllData
{
   static String messagess=",";
   Session session;
   Store store;
   boolean exception=false;

   public getAllData(String email,String password)
   {
       Properties props = System.getProperties();
       props.setProperty("mail.store.protocol", "imaps");
       try
       {
           session = Session.getInstance(props, null);
           store = session.getStore("imaps");
           store.connect("imap.gmail.com", email, password);
       }catch(Exception adfasf)
       {
           System.out.println("Constructor Catch: "+adfasf);
       }
   }


   public String[][] process()
   {
       try
       {
           Folder inbox = store.getFolder("Inbox");

           inbox.open(Folder.READ_ONLY);

           Message messages[] = inbox.getMessages();

           String p="";
           for(int i = messages.length-1;i>=0;i--)
           {
               p+=dumpEnvelope(messages[i])+"%%%";
           }

           if(p.length()!=0)
           {
               StringTokenizer t=new StringTokenizer(p,"%%%");

               String data[][] = new String[t.countTokens()][2];

               int i =0;
               while(t.hasMoreTokens())
               {
                   StringTokenizer temp = new StringTokenizer(t.nextToken(),"`");
                   int j=0;
                   while(temp.hasMoreTokens())
                   {
                        data[i][j] = temp.nextToken();
                        j++;
                   }
                   i++;
               }
               return data;
           }
       } catch (Exception e)
       {
           System.out.println("Exception 1: "+e);
       }
       return null;
   }

   private static String dumpEnvelope(Message m) throws Exception
   {
       String subject="";
       String message="";

       // SUBJECT
       subject+=m.getSubject() + "R" + m.getMessageNumber();


       message = (String) m.getContent().toString().replaceAll("\\r|\\n", " ");

       return subject+"`"+message;
   }


}
