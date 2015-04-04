package test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class InboxReader
{
   static String messagess=",";
   Session session;
   Store store;
   boolean exception=false;
	InboxReader()
        {
            File f=new File("id.ravs");
            if(f.exists())
            {
                try
                {
                    BufferedReader b=new BufferedReader(new FileReader("id.ravs"));
                    messagess=b.readLine().trim();
                }catch(Exception ad){}
            }
             Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
			try
                        {
				session = Session.getDefaultInstance(props, null);
				store = session.getStore("imaps");
				store.connect("imap.gmail.com", "ravjot28@gmail.com", "ravjotsingh21");
            }catch(Exception adfasf){System.out.println(adfasf);}
		startreading();

	}

        public void startreading()
    {
           System.out.println(store);
try
{
				Folder inbox = store.getFolder("Inbox");//Folder inbox = store.getFolder("Personal");//Folder inbox = store.getFolder("[Gmail]/Trash");//Folder inbox = store.getFolder("[Gmail]/Spam");//Folder inbox = store.getFolder("[Gmail]/Drafts");//Folder inbox = store.getFolder("[Gmail]/All Mail");//Folder inbox = store.getFolder("[Gmail]/Starred");//Folder inbox = store.getFolder("[Gmail]/Sent Mail");//Folder inbox = store.getFolder("Inbox");
				inbox.open(Folder.READ_ONLY);
				//Message messages[] = inbox.getMessages();
                                FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
                                Message messages[] = inbox.search(ft);
                                java.util.Date date = new java.util.Date();

				for(Message message:messages)
                                {
                                    if(!messagess.contains(","+message.getMessageNumber()))
                                    {
                                        dumpEnvelope(message);
                                        int a=message.getMessageNumber();
                                        messagess=messagess+a+",";
                                    }   
                                }
                                System.out.println(messagess);
                     } catch (Exception e) {exception=true;}
                try
                                    {
                                            new Thread().sleep(3000);
                                    }catch(Exception adf){System.out.println("2");}
           if(exception)
           {
              
               try{ store.close();BufferedWriter b=new BufferedWriter(new FileWriter("id.ravs")); b.append(messagess); b.close();new InboxReader();}catch(Exception asd){}
           }
 else
           {
                                    startreading();
        }

           System.out.println("Exception is"+exception);
        }
        public static void main(String asd[])
    {
            new InboxReader();
        }

        public static void dumpEnvelope(Message m) throws Exception 
        {

        Date d = m.getSentDate();
            java.util.Date date = new java.util.Date();
        pr(" ");
        Address[] a;
        // FROM
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++)
                pr("FROM: " + a[j].toString());
        }

        // TO
        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++) {
                pr("TO: " + a[j].toString());
            }
        }

        // SUBJECT
        pr("SUBJECT: " + m.getSubject());

        // DATE
        pr("SendDate: " +
                (d != null ? d.toString() : "UNKNOWN"));


    }

    static String indentStr = "                                               ";
    static int level = 0;

    /**
     * Print a, possibly indented, string.
     */
    public static void pr(String s) {

        System.out.print(indentStr.substring(0, level * 2));
        System.out.println(s);
    }

}