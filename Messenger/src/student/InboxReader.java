/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package student;

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

public class InboxReader
{
   static String messagess=",";
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
				store.connect("imap.gmail.com", "ravnotifier@gmail.com", "ravjotsingh");
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
                                    String aa[][]=new String[t.countTokens()][3];
                                    int i=0;
                                    while(t.hasMoreTokens())
                                    {
                                        String temp=t.nextToken();
                                        StringTokenizer t1=new StringTokenizer(temp,"|");
                                        int j=0;
                                        while(t1.hasMoreTokens())
                                        {
                                            String temp1=t1.nextElement().toString();
                                            if(!temp1.contains("TO:"))
                                            {
                                            aa[i][j]=temp1;
                                            j++;
                                            }
                                        }
                                        i++;
                                    }
                                    aaa=aa;
                                    for(int i2=0;i2<aaa.length;i2++)
                                    {
                                        StringTokenizer tt = new StringTokenizer(aaa[i2][1],"##");
                                        String year = tt.nextToken();
                                        String branch = tt.nextToken();
                                        String survey=tt.nextToken();
                                        String date1 = tt.nextToken();
                                        String tname=tt.nextToken();
                                        if((year.contains("4"))&&(branch.contains("CSE-1")))
                                        {
                                            year=year.replaceAll("SUBJECT: ","");
                                            System.out.println("Year"+year);
                                            System.out.println("Branch"+branch);
                                            System.out.println("Survey"+survey);
                                            System.out.println("Date"+date1);
                                            System.out.println("Teacher Name"+tname);
                                            System.out.println("Message\n"+aaa[i2][2]);
                                            new Notice(survey,tname,aaa[i2][2],date1,year,branch);
                                        }
                                    }
                                    //thread.start();
//                                    new TestSlideInNotification(aaa);
                                   /* for(int i1=0;i1<aa.length;i1++)
                                    {
                                        System.out.println(aa[i1][0]+"\n"+aa[i1][1]+"\n"+aa[i1][2]+"\n"+aa[i1][3]);
                                        System.out.println("\n\n");
                                    }*/
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
        public static void main(String asd[])
    {
            new InboxReader();
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

        a4=m.getContent().toString();

        // DATE
        /*a4+=pr("SendDate: " +
                (d != null ? d.toString() : "UNKNOWN"));*/

                return a1+"|"+a2+"|"+a3+"|"+a4+"|";
    }

    static String indentStr = "                                               ";
    static int level = 0;

    /**
     * Print a, possibly indented, string.
     */
    public static String pr(String s) {

        System.out.print(indentStr.substring(0, level * 2));
        return (s);
    }




}