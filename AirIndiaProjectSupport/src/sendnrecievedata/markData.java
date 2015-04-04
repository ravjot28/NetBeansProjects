package sendnrecievedata;

import java.util.Properties;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class markData
{
   static String messagess=",";
   Session session;
   Store store;
   boolean exception=false;
   int email_number[];

   public markData(String email,String password,int number[])
   {
       this.email_number = number;
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


   public boolean process()
   {
       try
       {
           Folder inbox = store.getFolder("Inbox");

           inbox.open(Folder.READ_WRITE);

           for(int i=0;i<email_number.length;i++)
           {
               Message message = inbox.getMessage(email_number[i]);
                message.setFlag(Flag.SEEN,true);
           }
           return true;
           
       } catch (Exception e)
       {
           System.out.println("Exception 1: "+e);
       }
       return false;
   }
}
