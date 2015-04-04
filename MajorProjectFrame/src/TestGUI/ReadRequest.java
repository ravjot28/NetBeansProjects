/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestGUI;

import java.util.ArrayList;
import javax.mail.*;
import javax.mail.search.FlagTerm;
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

   ArrayList<String> apps;

   ReadRequest(String u,String p)
   {
       apps = new ArrayList();
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


   public String[] startreading()
   {
       try
       {
           Folder inbox = store.getFolder("Inbox");

           inbox.open(Folder.READ_WRITE);

           //Message messages[] = inbox.getMessages();
           FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
           Message messages[] = inbox.search(ft);
           String p="";

                   
                   StringTokenizer final_st = new StringTokenizer(messages[0].getContent().toString(),"##");
                   
                   while(final_st.hasMoreTokens())
                   {
                       String temp = final_st.nextToken();
                       if(temp.trim().length()>1)
                        apps.add(temp);
                   }

                   messages[0].setFlag(Flags.Flag.SEEN, false);
                   String ravs[] = new String[apps.size()];
                   for(int j=0;j<ravs.length;j++)
                       ravs[j] = apps.get(j);
                   
                   return ravs;
               
           
       } catch (Exception e)
        {
           exception=true;
        }
       return null;
   }

   public static void main(String as[])
    {
       String a[] = new ReadRequest("rapplicationstore@gmail.com","docomo3401").startreading();

       for(int i=0;i<a.length;i++)
           System.out.println(a[i]);

   }
}