import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class Main implements Runnable
{
    private Thread t=new Thread(this);
    String[][] mails;
    int reading=1;
    static String messagess=",";
    static String indentStr = "                                               ";
    static int level = 0;


    public static void main(String r[])
    {
        new Main();
    }

    Main()
    {
        reading=1;
        t.start();
    }

    public void close(String[][] a,boolean check)
    {
        if(check)
        {
            mails=a;
        t=null;
        System.out.println("Sleep");
        try
        {
            Thread.sleep(100);
        }catch(Exception r){}
        st();
        }
 else
        {
            t=null;
            t=new Thread(this);
            reading=1;
            t.start();
 }
    }

    public void st()
    {
        reading=0;
        t=new Thread(this);
        t.start();
    }

    public void run()
    {
        Thread thisThread =Thread.currentThread();
        while(t==thisThread)
        {
            System.out.println("Reading value in run "+reading);
            if(reading!=1)
            {
                System.out.println("Sending");
                //to do after detecting the mail
                for(int i1=0;i1<mails.length;i1++)
                {
                    System.out.println(mails[i1][0]+"\n"+mails[i1][1]+"\n"+mails[i1][2]+"\n"+mails[i1][3]);
                    String to=mails[i1][0].substring(mails[i1][0].lastIndexOf("<")+1,mails[i1][0].lastIndexOf(">"));
                    System.out.println(to);
                    String too[]={to};
                    sending s=new sending("gtbitinfo@gmail.com","Hi "+mails[i1][2].replaceAll("SUBJECT:", ""),"Auto Reply Do Not Reply",too,"ravjotsingh21");
                    System.out.println(s.send());
                }
                close(null,false);
            }
            else
            if(reading==1)
            {
                System.out.println("Reading");
                try
        {
            Thread.sleep(100);
        }catch(Exception r){}
                new InboxReader();
            }
        }
     }

    class InboxReader
    {

        Session session;
   Store store;
   String aaa[][];
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
				store.connect("imap.gmail.com", "gtbitinfo@gmail.com", "ravjotsingh21");
            }catch(Exception adfasf){System.out.println(adfasf);}
		startreading();

	}

        public void startreading()
    {
           System.out.println(store);
try
{
				Folder inbox = store.getFolder("Inbox");
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
                                    try{ store.close();BufferedWriter b=new BufferedWriter(new FileWriter("id.ravs")); b.append(messagess); b.close();}catch(Exception asd){}
                                    System.out.println("saved details in id.ravs");
                                    System.out.println("calling close");
                                    close(aaa,true);
                                    System.out.println("called close");
    }
                     } catch (Exception e) {exception=true;}
                try
                                    {
                                            new Thread().sleep(100);
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


        public String dumpEnvelope(Message m) throws Exception
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


    /**
     * Print a, possibly indented, string.
     */
    public String pr(String s)
    {
        System.out.print(indentStr.substring(0, level * 2));
        return (s);
    }
}
}
