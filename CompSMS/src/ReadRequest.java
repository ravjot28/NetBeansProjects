import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;

public class ReadRequest
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

   ReadRequest(String u,String p)
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

        startreading();
   }


   public void startreading()
   {
       //System.out.println(store);
       try
       {
           Folder inbox = store.getFolder("Inbox");
           //Folder inbox = store.getFolder("Personal");
           //Folder inbox = store.getFolder("[Gmail]/Trash");
           //Folder inbox = store.getFolder("[Gmail]/Spam");
           //Folder inbox = store.getFolder("[Gmail]/Drafts");
           //Folder inbox = store.getFolder("[Gmail]/All Mail");
           //Folder inbox = store.getFolder("[Gmail]/Starred");
           //Folder inbox = store.getFolder("[Gmail]/Sent Mail");
           //Folder inbox = store.getFolder("Inbox");

           inbox.open(Folder.READ_WRITE);

           //Message messages[] = inbox.getMessages();
           FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
           Message messages[] = inbox.search(ft);
           java.util.Date date = new java.util.Date();
           String p="";

           for(Message message:messages)
           {
                   p+=dumpEnvelope(message)+"$$$";
                   int a=message.getMessageNumber();
                   //System.out.println("Message Number "+a);
                   message.setFlag(Flags.Flag.SEEN, true);
           }

           if(p.length()!=0)
           {
               StringTokenizer st = new StringTokenizer(p,"$$$");
               String cust[][] = new String[st.countTokens()][5];
               int rec = 0;
               while(st.hasMoreTokens())
               {
                   String email_string = st.nextToken();
                   StringTokenizer st1 = new StringTokenizer(email_string,"|");
                   String temp[] = new String[4];
                   int i=0;
                   while(st1.hasMoreTokens())
                   {
                       temp[i] = st1.nextToken();
                       i++;
                   }
                   String cust_info = temp[2].replace("SUBJECT: ","").trim();
                   StringTokenizer final_st = new StringTokenizer(cust_info,",");
                   int index = 0;
                   while(final_st.hasMoreTokens())
                   {
                       cust[rec][index] = final_st.nextToken();
                       index++;
                   }
                   rec++;
               }
               //return cust to register nd provide confirmation
               RegisterCust rc = new RegisterCust(cust);
               rc.create();
           }
       } catch (Exception e)
        {
           exception=true;
        }
       try
       {
           new Thread().sleep(100);
       }catch(Exception adf)
       {
           System.out.println("Sleep Exception");
       }

       if(exception)
       {
           try
           {
               store.close();
               new ReadRequest(uname,pname);
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
       new ReadRequest("ravjotsmssignup@gmail.com","docomo3401");
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
       if ((a = m.getFrom()) != null)
       {
            for (int j = 0; j < a.length; j++)
                a1+=pr("FROM: " + a[j].toString())+",";
       }

        // TO
       if ((a = m.getRecipients(Message.RecipientType.TO)) != null)
       {
           for (int j = 0; j < a.length; j++)
           {
               a2+=pr("TO: " + a[j].toString())+",";
           }
       }

       // SUBJECT
       a3+=pr("SUBJECT: " + m.getSubject());

       // DATE
       a4+=pr("SendDate: " + (d != null ? d.toString() : "UNKNOWN"));

       return a1+"|"+a2+"|"+a3+"|"+a4+"|";
   }

   public static String pr(String s)
   {
       System.out.print(indentStr.substring(0, level * 2));
       return (s);
   }
}