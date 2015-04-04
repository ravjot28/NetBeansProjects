import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;

public class Verification
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

   static String mailfolder = "";
   static String search = "";

   static String inputPh = "";
   static String inputSecret = "";

   Verification(String folder,String find,String u,String p,String ip,String is)
   {
        inputPh = ip;
        inputSecret = is;
        mailfolder = folder;
        search = find;
        uname=u;
        pname=p;

        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");

        try
        {
            session = Session.getInstance(props, null);
            store = session.getStore("imaps");
            store.connect("imap.gmail.com",u,p);
        }catch(Exception adfasf)
            {
                System.out.println(adfasf);
            }
   }


   public boolean startreading()
   {
       //System.out.println(store);
       try
       {
           //Folder inbox = store.getFolder("Inbox");
           //System.out.println("Folder is "+mailfolder);
           Folder inbox = store.getFolder(mailfolder);
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
           String p="";

           for(Message message:messages)
           {
                   p+=dumpEnvelope(message)+"$$$";
                   //int a=message.getMessageNumber();
                   //System.out.println("Message Number "+a);
                   //message.setFlag(Flags.Flag.SEEN, true);
           }

           if(p.length()!=0)
           {
               StringTokenizer t=new StringTokenizer(p,"$$$");
               int i=0;
               //String secretcodes="";
               while(t.hasMoreTokens())
               {
                    String temp=t.nextToken();
                    StringTokenizer t1=new StringTokenizer(temp,"|");
                    String a = t1.nextElement().toString();
                    String a1 = t1.nextElement().toString();
                    String sub = t1.nextElement().toString();
                    sub = sub.replace("SUBJECT: ","").trim();
                    StringTokenizer check = new StringTokenizer(sub,",");
                    //ravjotnorth01,ravjot28@gmail.com##9540140052,5466
                    String tag = check.nextToken();
                    String id = check.nextToken();

                    if(id.equalsIgnoreCase(search.trim()))
                    {
                        String ph = check.nextToken();
                        if(inputPh.equalsIgnoreCase(ph))
                        {
                            String s = check.nextToken();
                            if(inputSecret.equalsIgnoreCase(s))
                            {
                                return true;
                            }
                            else
                            {
                                continue;
                            }
                        }
                        else
                        {
                            continue;
                        }
                    }
               }
               //System.out.println("Secret Codes "+secretcodes);
           }
       } catch (Exception e)
        {
           exception=true;
        }
       return false;
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