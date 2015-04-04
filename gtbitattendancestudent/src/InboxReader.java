import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
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
   String aaa[][];
   boolean exception=false;
   static String indentStr = "                                               ";
   static int level = 0;
   static boolean rav=true;
   String enroll;
   String mess1;
   Date d;


   InboxReader(String a)
   {
       enroll=a;
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
            session = Session.getInstance(props, null);
	    store = session.getStore("imaps");
            store.connect("imap.gmail.com", "gtbitinfo1@gmail.com", "docomo3401");
        }catch(Exception adfasf)
                {
                    System.out.println(adfasf);
                }
        startreading();
   }

   public void startreading()
   {
        System.out.println(store);
        try
        {
            Folder inbox = store.getFolder("Inbox");//Folder inbox = store.getFolder("Personal");//Folder inbox = store.getFolder("[Gmail]/Trash");//Folder inbox = store.getFolder("[Gmail]/Spam");//Folder inbox = store.getFolder("[Gmail]/Drafts");//Folder inbox = store.getFolder("[Gmail]/All Mail");//Folder inbox = store.getFolder("[Gmail]/Starred");//Folder inbox = store.getFolder("[Gmail]/Sent Mail");//Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_ONLY);
	    FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message messages[] = inbox.search(ft);
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
                String aa[][]=new String[t.countTokens()][2];
                int i=0;
                while(t.hasMoreTokens())
                {
                    String temp=t.nextToken();
                    StringTokenizer t1=new StringTokenizer(temp,"|");
                    int j=0;

                    while(t1.hasMoreTokens())
                    {
                        String temp1=t1.nextElement().toString();
                        aa[i][j]=temp1;
                        j++;
                    }
                    i++;
                }

                aaa=aa;
                mess1="";
                for(int i2=0;i2<aaa.length;i2++)
                {
                    String subject = aaa[i2][0].trim().replaceAll("SUBJECT: ", "").trim();
                    String mess = aaa[i2][1];
                    if((subject.contains(enroll))&&((new Date().after(d))||(new Date().equals(d))))
                    {
                        mess1=mess;
                    }
                 }
                if(mess1.length()!=0)
                {
                    System.out.println("Message "+mess1);
                    java.awt.EventQueue.invokeLater(new Runnable()
                    {
                        public void run()
                        {
                            System.out.println(d.toString());
                            new MessageDisplay(mess1).setVisible(true);
                        }
                    });
                    rav=false;
                }
             }
          } catch (Exception e)
                        {
                            exception=true;
                        }
        if(rav)
        {
          try
          {
            new Thread().sleep(100);
          }catch(Exception adf)
                    {
                        System.out.println("2");
                    }
           if(exception)
           {
               try
               {
                   store.close();
                   BufferedWriter b=new BufferedWriter(new FileWriter("id.ravs"));
                   b.append(messagess);
                   b.close();
                   new InboxReader(enroll);
               }catch(Exception asd){}
           }
           else
           {
                startreading();
           }

           System.out.println("Exception is"+exception);
       }
        else

       {
            System.out.println("Bye bye");
        }
        }

        public String dumpEnvelope(Message m) throws Exception
        {
            String a3="";
            String a4="";
            d = m.getSentDate();
            java.util.Date date = new java.util.Date();
            pr(" ");
            a3+=pr("SUBJECT: " + m.getSubject());
            a4+=m.getContent().toString();
            return a3+"|"+a4+"|";
        }

        public static String pr(String s)
        {
            System.out.print(indentStr.substring(0, level * 2));
            return (s);
        }

        public int getNumberOfLines(String name)
        {
            int numberOfLines = 0;
            LineNumberReader lineCounter = null;
            try
            {
                lineCounter = new LineNumberReader(new FileReader(name));
                while ((lineCounter.readLine()) != null)
                {
                    continue;
                }
                numberOfLines = lineCounter.getLineNumber();
            } catch (IOException e)
                        {}
            return numberOfLines;
        }
}
