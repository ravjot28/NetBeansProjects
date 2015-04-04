package readmailgmail;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class MailReader
{
   static String messagess=",";
   Session session;
   Store store;
   String aaa[][];
   boolean exception=false;
   static String indentStr = "                                               ";
   static int level = 0;


   MailReader()
   {
       Properties props = System.getProperties();
       props.setProperty("mail.store.protocol", "imaps");
       try
       {
           session = Session.getDefaultInstance(props, null);
           store = session.getStore("imaps");
           store.connect("imap.gmail.com", "ravjot28@gmail.com", "mtdeoksgxiiuucol");
       }catch(Exception adfasf)
       {
           System.out.println("Constructor Catch: "+adfasf);
       }
   }


   public void process()
   {
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

           inbox.open(Folder.READ_ONLY);

           //Message messages[] = inbox.getMessages();
           FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
           Message messages[] = inbox.search(ft);
           //Message messages[] = inbox.getMessages();

           String p="";
           for(int i = messages.length-1;i>=0;i--)
           {
               p+=dumpEnvelope(messages[i])+"$$$";
               int a=messages[i].getMessageNumber();
               messagess=messagess+a+",";
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
           }
       } catch (Exception e)
       {
           System.out.println("Exception 1: "+e);
       }
   }

   public static String dumpEnvelope(Message m) throws Exception
   {
       String from="";
       String to="";
       String subject="";
       String sentDate="";
       
       Date d = m.getSentDate();
       Address[] a;

       // FROM
       if ((a = m.getFrom()) != null) {
           for (int j = 0; j < a.length; j++)
               from+=a[j].toString()+",";
       }

       // TO
       if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
           for (int j = 0; j < a.length; j++) {
               to+=a[j].toString()+",";
           }
       }

       // SUBJECT
       subject+=m.getSubject();

       
       Object content = m.getContent();
        
       if (content instanceof Multipart)
       {
           handleMultipart((Multipart)content);
       }
       else
       {
           handlePart(m);
       }
       
       // DATE
       sentDate+=(d != null ? d.toString() : "UNKNOWN");

       return from+"|"+to+"|"+subject+"|"+sentDate+"|";
   }

   public static void main(String asd[])
   {
       MailReader mr = new MailReader();
       mr.process();
   }

   public static void handleMultipart(Multipart multipart) throws MessagingException, IOException
   {
       for (int i=0, n=multipart.getCount(); i<n; i++)
       {
           handlePart(multipart.getBodyPart(i));
       }
   }

  
   public static void handlePart(Part part) throws MessagingException, IOException
   {

       String disposition = part.getDisposition();

       String contentType = part.getContentType();

       if (disposition == null)
       {
           // Check if plain
           if ((contentType.length() >= 10) &&(contentType.toLowerCase().substring(0, 10).equals("text/plain")))
           {
               System.out.println("text/plain.................................\n\n");
               String s = (String) part.getContent();
               System.out.println(s);
               //part.writeTo(System.out);
           } 
           else
           {
               System.out.println("text/html.................................\n\n");

               part.writeTo(System.out);
               //part.writeTo(new FileOutputStream("1.txt", true));
           }
    
       }
       else
           if (disposition.equalsIgnoreCase(Part.ATTACHMENT))
           {

               System.out.println("Attachment: " + part.getFileName() +" : " + contentType);

               saveFile(part.getFileName(), part.getInputStream());
    
           }
           else 
               if (disposition.equalsIgnoreCase(Part.INLINE))
               {

                   System.out.println("Inline: " +part.getFileName() +" : " + contentType);

                   saveFile(part.getFileName(), part.getInputStream());
    
               }
               else
               {
                    // Should never happen
                    System.out.println("Other: " + disposition);
               }

   }
  
   public static void saveFile(String filename,InputStream input) throws IOException
   {
    
       if (filename == null)
       {
           filename = File.createTempFile("xx", ".out").getName();
       }
       File file = new File(filename);
    
       /*for (int i=0; file.exists(); i++)
       {
           file = new File(filename+i);
       }*/

       FileOutputStream fos = new FileOutputStream(file);
       BufferedOutputStream bos = new BufferedOutputStream(fos);
       BufferedInputStream bis = new BufferedInputStream(input);
       int aByte;
    
       while ((aByte = bis.read()) != -1)
       {
           bos.write(aByte);
       }
       
       bos.flush();
       bos.close();
       bis.close();
   }
}
