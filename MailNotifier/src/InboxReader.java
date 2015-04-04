import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import javax.mail.*;
import java.io.FileReader;
import javax.mail.search.FlagTerm;
import java.io.FileWriter;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import ravrun.Rav;




public class InboxReader
{
   static String messagess=",";
   Session session;
   Store store;
   String aaa[][];
   boolean exception=false;
   String uname;
   String pname;
   static String indentStr = "                                               ";
   static int level = 0;
   
	InboxReader(String u,String p)
        {
            uname=u;
            pname=p;
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
				store.connect("imap.gmail.com",u,p);
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
                                String p="";
				for(Message message:messages)
                                {
                                    if(!messagess.contains(","+message.getMessageNumber()))
                                    {
                                        p+=dumpEnvelope(message)+"$$$";
                                        int a=message.getMessageNumber();
                                        messagess=messagess+a+",";
                                    }
                                }
                                if(p.length()!=0)
                                {
                                    StringTokenizer t=new StringTokenizer(p,"$$$");
                                    String aa[][]=new String[t.countTokens()][4];
                                    int i=0;
                                    while(t.hasMoreTokens())
                                    {
                                        String temp=t.nextToken();
                                        StringTokenizer t1=new StringTokenizer(temp,"|");
                                        int j=0;
                                        while(t1.hasMoreTokens())
                                        {
                                            aa[i][j]=t1.nextElement().toString();
                                            j++;
                                        }
                                        i++;
                                    }
                                    aaa=aa;
                                    new TestSlideInNotification(aaa);
                                   
                                }
                     } catch (Exception e) {exception=true;}
                try
                                    {
                                            new Thread().sleep(100);
                                    }catch(Exception adf){System.out.println("2");}
           if(exception)
           {
               try
               {
                   store.close();
                   BufferedWriter b=new BufferedWriter(new FileWriter("id.ravs"));
                   b.append(messagess);
                   b.close();
                   new InboxReader(uname,pname);
               }catch(Exception asd){}
           }
 else
           {
                                    startreading();
        }

           System.out.println("Exception is"+exception);
        }
        public static void main(String asd[])
    {
            new InboxReader("emailid","password");
        }

        public static String dumpEnvelope(Message m) throws Exception
        {
            String a1="";
            String a2="";
            String a3="";
            String a4="";
        Date d = m.getSentDate();
            java.util.Date date = new java.util.Date();
        pr(" ");
        Address[] a;
        // FROM
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++)
               a1+=pr("FROM: " + a[j].toString())+",";
        }

        // TO
        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++) {
                a2+=pr("TO: " + a[j].toString())+",";
            }
        }

        // SUBJECT
        a3+=pr("SUBJECT: " + m.getSubject());

        // DATE
        a4+=pr("SendDate: " +
                (d != null ? d.toString() : "UNKNOWN"));

                return a1+"|"+a2+"|"+a3+"|"+a4+"|";
    }

    public static String pr(String s) {

        System.out.print(indentStr.substring(0, level * 2));
        return (s);
    }

}