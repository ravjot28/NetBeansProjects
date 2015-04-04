import java.awt.Toolkit;
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
import javax.swing.JOptionPane;

public class NewJFrame extends javax.swing.JFrame implements Runnable
{
    Thread th = new Thread(this);
    String messagess=",";
    Session session;
    Store store;
    String aaa[][];
    boolean exception=false;
    InfiniteProgressPanel glass ;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    class InboxReader
{
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
				store.connect("imap.gmail.com", "appframeupdates@gmail.com", "appframe");
            }catch(Exception adfasf)
            {
                JOptionPane.showMessageDialog(null,"Oops!!! Connection Error","Error",JOptionPane.ERROR_MESSAGE);
            }
		startreading();

	}

        public void startreading()
    {
            String result="";
           System.out.println(store);
           try
            {
				Folder inbox = store.getFolder("Inbox");//Folder inbox = store.getFolder("Personal");//Folder inbox = store.getFolder("[Gmail]/Trash");//Folder inbox = store.getFolder("[Gmail]/Spam");//Folder inbox = store.getFolder("[Gmail]/Drafts");//Folder inbox = store.getFolder("[Gmail]/All Mail");//Folder inbox = store.getFolder("[Gmail]/Starred");//Folder inbox = store.getFolder("[Gmail]/Sent Mail");//Folder inbox = store.getFolder("Inbox");
				inbox.open(Folder.READ_ONLY);
				//Message messages[] = inbox.getMessages();
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
                                        glass.stop();
                                        result="ravjot";
                                        System.out.println(aaa[i2][1].replaceAll("SUBJECT: ", "").trim());
                                        int tmp = new StringTokenizer(aaa[i2][1].replaceAll("SUBJECT: ", "").trim()).countTokens();
                                        int answer =JOptionPane.showConfirmDialog(null, "Found "+tmp+" Update(s). Do you want to update?", "Confirmation", JOptionPane.YES_NO_OPTION);
                                        if(answer == JOptionPane.YES_OPTION)
                                        {
                                            System.out.println("Yes");
                                            dispose();
                                            GUI ss = new GUI("");
                                            ss.add(aaa[i2][1].replaceAll("SUBJECT: ", "").trim());
                                        }
                                        else
                                        {
                                            dispose();
                                        }
                                    }
                                }
                     } catch (Exception e) {result="error";exception=true;}
           
               try
               {
                   store.close();
                   BufferedWriter b=new BufferedWriter(new FileWriter("id.ravs"));
                   b.append(messagess);
                   b.close();

               }catch(Exception asd)
               {
                   glass.stop();
                   result="error";
                    JOptionPane.showMessageDialog(null,"Oops!!! Connection Error","Error",JOptionPane.ERROR_MESSAGE);
               }
           if(result.equals("ravjot"))
           {

           }
 else
     if(!result.equals("error"))
           {
               glass.stop();
           JOptionPane.showMessageDialog(null,"All Applications are up to date.","Notification",JOptionPane.INFORMATION_MESSAGE);
           dispose();
           System.exit(0);
        }
 else
     {
               dispose();
               System.exit(0);
 }
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

        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++) {
                a2+=pr("TO: " + a[j].toString())+",";
            }
        }

        a3+=pr("SUBJECT: " + m.getSubject());

        a4=m.getContent().toString();


                return a1+"|"+a2+"|"+a3+"|"+a4+"|";
    }

    String indentStr = "                                               ";
    int level = 0;

    public String pr(String s) {

        System.out.print(indentStr.substring(0, level * 2));
        return (s);
    }
}

     public static void main(String a[])
    {
        new NewJFrame().setVisible(true);   
    }


    public NewJFrame()
    {
        initComponents();
        th.start();
        
    }

    public void run()
    {
        new InboxReader();
    }
    private void initComponents() {
        glass= new InfiniteProgressPanel();
        setGlassPane(glass);
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("bg.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, Short.MAX_VALUE)
        );

        pack();
        setLocation(h/2,w/8);
        glass.start();
    }

    private javax.swing.JLabel jLabel1;
}