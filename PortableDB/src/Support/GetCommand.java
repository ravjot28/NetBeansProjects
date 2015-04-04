package Support;

import java.util.Properties;
import java.util.StringTokenizer;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class GetCommand
{
   static String messagess=",";
   Session session;
   Store store;
   boolean exception=false;

   public GetCommand()
   {
       Properties props = System.getProperties();
       props.setProperty("mail.store.protocol", "imaps");
       try
       {
           session = Session.getInstance(props, null);
           store = session.getStore("imaps");
           store.connect("imap.gmail.com", "portabledboperations@gmail.com", "guru3401");
       }catch(Exception adfasf)
       {
           System.out.println("Constructor Catch: "+adfasf);
       }
   }


   public String[] process()
   {
       try
       {
           Folder inbox = store.getFolder("Inbox");

           inbox.open(Folder.READ_WRITE);

           FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);

           Message messages[] = inbox.search(ft);

           String p="";
           for(int i = messages.length-1;i>=0;i--)
           {
               messages[i].setFlag(Flags.Flag.SEEN, true);
               p+=dumpEnvelope(messages[i])+"$$$";
           }

           if(p.length()!=0)
           {
               StringTokenizer t=new StringTokenizer(p,"$$$");

               String data[] = new String[t.countTokens()];

               int i =0;
               while(t.hasMoreTokens())
               {
                   String temp = t.nextToken();
                   data[i] = temp;
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
       String message="";

       if(m.getSubject().trim().equalsIgnoreCase("ravjot"))
        message = (String) m.getContent().toString().replaceAll("\\r|\\n", " ");

       return message;
   }


}
