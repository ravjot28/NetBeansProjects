import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.Properties;

public class ReadAllEmail
{
   Session session;
   Store store;
   String uname;
   String pname;

   public ReadAllEmail(String u,String p)
   {
        uname=u;
        pname=p;

        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");

        try
        {
            session = Session.getDefaultInstance(props, null);
            store = session.getStore("imaps");
            store.connect("imap.gmail.com",u,p);
        }catch(Exception adfasf)
            {
                System.out.println(adfasf);
            }
   }


   public boolean startreading()
   {
       try
       {
           Folder inbox = store.getFolder("Inbox");

           inbox.open(Folder.READ_WRITE);

           FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
           Message messages[] = inbox.search(ft);

           for(Message message:messages)
           {
                   message.setFlag(Flags.Flag.SEEN, true);
           }
           return true;
       } catch (Exception e)
        {
           return false;
        }
   }

   
}