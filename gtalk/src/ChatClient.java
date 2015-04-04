import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromContainsFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;

public class ChatClient implements MessageListener,Runnable
{
     JPanel mainPanel;
     XMPPConnection connection;
     static Buddy budd[];
     static String buddlist="";
     ChatClient c;
     String chatbuddy;
     String checkbuddy="";
     String uname="";
     String pswd="";
     JFrame f;
     JScrollPane jScrollPane1;
     JScrollPane jScrollPane2;
     JTextArea jTextArea1;
     JTextArea jTextPane1;
     String incomingmessage="";
     boolean incomem=false;
     
     static String messageappend="";
     chatbox chat[]=new chatbox[100];
     static int chatno=-1;

       public void login(String userName, String password) throws XMPPException
       {
    	   ConnectionConfiguration config = new ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
           connection = new XMPPConnection(config);

           connection.connect();
           connection.login(userName, password);

           // Accept only messages from HQ
           PacketFilter filter= new AndFilter(new PacketTypeFilter(Message.class),new FromContainsFilter("."));

           PacketListener myListener = new PacketListener() {
                public void processPacket(Packet packet) {
                    if (packet instanceof Message) {
                        Message msg = (Message) packet;
                        // Process message
                        //System.out.println(msg.getFrom()+" "+msg.getBody());
                        String from = msg.getFrom();
                        String mess = msg.getBody();
                        int pp=-1;
                        int qq=-1;
                        for(int i=0;i<chatno;i++)
                        {
                            if(chat[i].getfname().equals(from.substring(0, from.lastIndexOf("/"))))
                            {
                                pp=26;
                                qq=i;
                                break;
                            }
                        }
                        if(pp==26)
                        {
                            if(chat[qq].open())
                            {
                                chat[qq].appendtext(mess);
                            }
                            else
                            {
                                chat(from, mess);
                                }
                        }
                        else
                        {
                            chat(from, mess);
                        }
                    }
                }
            };
            // Register the listener.
            connection.addPacketListener(myListener, filter);
       }

       

       public void displayBuddyList()
       {
    	   Roster roster = connection.getRoster();
    	   Collection entries = roster.getEntries();

    	   //System.out.println("\n\n" + entries.size() + " buddy(ies):");
    	   Iterator i = entries.iterator();

    	   while(i.hasNext())
    	   {
    		   RosterEntry r = (RosterEntry) i.next();
    		   //System.out.println(r.getUser());
    	   }
       }

       public String displayBuddyOnline()
       {
           String buddlisttemp="";
            Roster roster=connection.getRoster();
            roster.addRosterListener(new RosterListener() {

        public void entriesAdded(Collection arg0) {
           try {
                    check();
                } catch (XMPPException ex) {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void entriesDeleted(Collection arg0) {
            try {
                    check();
                } catch (XMPPException ex) {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void entriesUpdated(Collection arg0) {
           try {
                    check();
                } catch (XMPPException ex) {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

            public void presenceChanged(Presence presence) {
                try {
                    check();
                } catch (XMPPException ex) {
                    Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    });

            Collection enteries=roster.getEntries();
            Iterator i=enteries.iterator();
            while(i.hasNext())
            {
                String p=i.next().toString();
                String emails=p.substring(p.lastIndexOf(":")+1).trim();
                Presence presence = roster.getPresence(emails);
                
                if(presence.getType().toString().equalsIgnoreCase("available"))
                {
                    System.out.println("detaisl XML "+presence.toXML());
                    String mode = null;
                    if(presence.getMode()==null)
                    {
                            mode="available";
                    }
                    else
                    if((presence.getMode() == Presence.Mode.xa)||(presence.getMode() == Presence.Mode.away))
                    {
                        mode="away";
                    }
                    else
                    if((presence.getMode() == Presence.Mode.available)||(presence.getMode() == Presence.Mode.chat))
                    {
                        mode="available";
                    }
                    else
                    if(presence.getMode() == Presence.Mode.dnd)
                    {
                        mode="dnd";
                    }
                    else
                    {
                        mode="away";
                    }
                    if((mode==null)||(mode.equalsIgnoreCase("null")))
                    {
                        mode="away";
                    }
                    //System.out.print(mode);
                    if(presence.getStatus()!=null)
                    {
                        buddlisttemp += p.replaceAll(": "+emails,"")+"##"+emails+"##"+presence.getStatus()+"##"+mode+"§";
                    }
                    else
                    {
                        buddlisttemp += p.replaceAll(": "+emails,"")+"##"+emails+"##"+"."+"##"+mode+"§";
                    }
                }
            }
            return buddlisttemp;
       }

       public void disconnect()
       {
    	   connection.disconnect();
       }

       public void processMessage(Chat chat, Message message)
       {
       }

       public void begin(String u,String p) throws XMPPException
       {
           uname=u;
           pswd=p;
           c=new ChatClient();
             // turn on the enhanced debugger
           XMPPConnection.DEBUG_ENABLED = false;

           // provide your login information here
           c.login(uname,pswd);


          // c.displayBuddyList();
           //System.out.println("online");
           try
           {
               Thread.sleep(5000);
           }catch(Exception asd){}

           buddlist=c.displayBuddyOnline();
           //System.out.println(buddlist);

           StringTokenizer buddies = new StringTokenizer(buddlist,"§");
           //System.out.println(buddlist);
           int numberofbudd = buddies.countTokens();
           budd = new Buddy[numberofbudd];
           int count=0;
           while(buddies.hasMoreTokens())
           {
               StringTokenizer budddetails = new StringTokenizer(buddies.nextToken(),"##");
               String details[]=new String[4];
               int a=0;
               while(budddetails.hasMoreTokens())
               {
                        details[a]=budddetails.nextToken();
                        a++;
               }
               //System.out.println(details[0]+" "+details[1]+" "+details[2]+" "+details[3]);
               budd[count]=new Buddy(details[0],details[1],details[2],details[3]);
               count++;
           }

           mainPanel=new JPanel();
           mainPanel.setLayout(new GridLayout(budd.length,1));

           String a="";
           String d="";
           String i1="";
           for(int i=0;i<budd.length;i++)
           {
               if((budd[i].statuss()==null||(budd[i].statuss().equalsIgnoreCase("null"))||(budd[i].statuss().equalsIgnoreCase("available"))))
               {
                    a+=""+i+",";
               }
               else
               if(budd[i].statuss().equalsIgnoreCase("dnd"))
               {
                    d+=""+i+",";
               }
               else
               {
                  i1+=""+i+",";
               }
               //mainPanel.add(budd[i]);
           }
           StringTokenizer av = new StringTokenizer(a,",");
           while(av.hasMoreTokens())
           {
               mainPanel.add(budd[Integer.parseInt(av.nextToken())]);
           }
           StringTokenizer dn = new StringTokenizer(d,",");
           while(dn.hasMoreTokens())
           {
               mainPanel.add(budd[Integer.parseInt(dn.nextToken())]);
           }
           StringTokenizer id = new StringTokenizer(i1,",");
           while(id.hasMoreTokens())
           {
               mainPanel.add(budd[Integer.parseInt(id.nextToken())]);
           }
           //f.setSize(numberofbudd*50,numberofbudd*70);
           f=new JFrame("RGtalk");
           f.add(mainPanel);
           f.pack();
           f.setVisible(true);
           f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
       }

       public void chat(String name,String message)
       {
           if(!checkbuddy.contains(name))
           {
               if(name.contains("/"))
               {
                System.out.println(name.substring(0, name.lastIndexOf("/")));
                this.chatbuddy=name.substring(0, name.lastIndexOf("/"));
               }
 else
               {
               System.out.println(name);
               this.chatbuddy=name;
               }
            messageappend=message;
            Thread t=new Thread(this);
            t.start();
           }
       }

       public void check() throws XMPPException
       {
           String buddlisttemp="";
           buddlisttemp=displayBuddyOnline();
               //System.out.println("Not Same");
               buddlist=buddlisttemp;
               StringTokenizer buddies = new StringTokenizer(buddlist,"§");
           int numberofbudd = buddies.countTokens();
           budd = new Buddy[numberofbudd];
           int count=0;
           while(buddies.hasMoreTokens())
           {
               StringTokenizer budddetails = new StringTokenizer(buddies.nextToken(),"##");
               String details[]=new String[4];
               int a=0;
               while(budddetails.hasMoreTokens())
               {
                        details[a]=budddetails.nextToken();
                        a++;
               }

               budd[count]=new Buddy(details[0],details[1],details[2],details[3]);
               count++;
           }
           mainPanel=new JPanel();
           mainPanel.setLayout(new GridLayout(budd.length,1));
           String a="";
           String d="";
           String i1="";
           for(int i=0;i<budd.length;i++)
           {
               if((budd[i].statuss()==null||(budd[i].statuss().equalsIgnoreCase("null"))||(budd[i].statuss().equalsIgnoreCase("available"))))
               {
                    a+=""+i+",";
               }
               else
               if(budd[i].statuss().equalsIgnoreCase("dnd"))
               {
                    d+=""+i+",";
               }
               else
               {
                  i1+=""+i+",";
               }
               //mainPanel.add(budd[i]);
           }
           StringTokenizer av = new StringTokenizer(a,",");
           while(av.hasMoreTokens())
           {
               mainPanel.add(budd[Integer.parseInt(av.nextToken())]);
           }
           StringTokenizer dn = new StringTokenizer(d,",");
           while(dn.hasMoreTokens())
           {
               mainPanel.add(budd[Integer.parseInt(dn.nextToken())]);
           }
           StringTokenizer id = new StringTokenizer(i1,",");
           while(id.hasMoreTokens())
           {
               mainPanel.add(budd[Integer.parseInt(id.nextToken())]);
           }
           
           f.dispose();
           f=new JFrame("RGtalk");
           f.add(mainPanel);
           f.pack();
           f.setVisible(true);
           f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }

       public void run()
       {
          // System.out.println(chatbuddy);
           checkbuddy+=chatbuddy+"§";
           chat[chatno+1]=new chatbox(chatbuddy,messageappend);
           chatno+=1;
          
       }


            public void sendMessage(String message, String to)
       {
           try
           {
    	   Chat chat = connection.getChatManager().createChat(to,this);
    	   chat.sendMessage(message);
           }catch(Exception sd){System.out.println(sd);}
       }


       class Buddy extends JPanel
       {
            final String name;
            final String email;
            final String status;
            final String avail;
            JLabel jLabel1;
            JLabel jLabel2;
            JLabel jLabel3;

            public Buddy(String name, String email , String status , String available)
            {
                this.name=name;
                this.email=email;
                this.status=status;
                this.avail = available;
                initComponents();
            }

            private void initComponents()
            {
                setBackground(new java.awt.Color(255, 255, 255));
                setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
                jLabel1 = new JLabel();
                jLabel2 = new JLabel();
                jLabel3 = new JLabel();
                String fname;
                if((avail==null)||(avail.equalsIgnoreCase("null")))
                {
                    fname="Bin/Img/red.gif";
                    jLabel1.setToolTipText("Busy");
                }
                else
                if((avail.equalsIgnoreCase("available")))
                {
                   fname="Bin/Img/green.gif";
                    jLabel1.setToolTipText("Available");
                }
                else
                if(avail.equalsIgnoreCase("dnd"))
                {
                    fname="Bin/Img/red.gif";
                    jLabel1.setToolTipText("Busy");
                }
                else
                {
                     fname="Bin/Img/yellow.gif";
                    jLabel1.setToolTipText("Idel");
                }

                ImageIcon img = new ImageIcon(fname);
                jLabel1.setIcon(img);

                jLabel2.setFont(new java.awt.Font("American Typewriter", 1, 16));
                jLabel2.setForeground(new java.awt.Color(255, 51, 51));
                jLabel2.setText(name);
                String status1=status;

                if(status1.length()>30)
                {
                    status1=status1.substring(0,31)+"..";
                }
 else
     if(status1.equalsIgnoreCase("."))
                {
                    status1="";
 }
                System.out.println(status);
                
                jLabel3.setFont(new java.awt.Font("Rockwell", 1, 12));
                jLabel3.setText(status1);

                // Override the ToolTip.foreground color in Swing's defaults table.
                UIManager.put ("ToolTip.foreground", Color.darkGray);
                // Override the ToolTip.background color in Swing's defaults table.
                UIManager.put ("ToolTip.background", Color.white);
                UIManager.put("ToolTip.font",new FontUIResource("SansSerif", Font.BOLD, 12));
                setToolTipText("<html>"+name+" ("+avail+")"+"<br>"+status+"</html>");

                addMouseListener(new MouseAdapter()
                {
                    public void mousePressed(MouseEvent me)
                    {
                        chat(email,"");
                    }
                });

                setMaximumSize(new Dimension(250, 70));
                setMinimumSize(new Dimension(250, 70));
                setPreferredSize(new Dimension(250, 70));

                GroupLayout layout = new GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addContainerGap(215, Short.MAX_VALUE))
                    );
                layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                    .addContainerGap(48, Short.MAX_VALUE))
                );
            }

            public String statuss()
           {
                return avail;
            }
    }

       class chatbox
       {
           JFrame f;
           final String fname;
           NewJPanel cb ;
           chatbox(String n,String mess)
           {
               f=new JFrame(n);
               fname=n;
               cb=new NewJPanel(n,mess);
               f.add(cb);
               f.pack();
               f.setVisible(true);
               f.addWindowListener(new WindowAdapter()
                                {
                                    public void windowClosing(WindowEvent e)
                                    {
                                        f.dispose();
                                    }
                                });
           }

           public void appendtext(String m)
           {
                jTextPane1.append("\n"+m);

           }

           public String getfname()
           {
                return this.fname;
           }

           public boolean open()
           {
               return f.isShowing();
           }
           class NewJPanel extends javax.swing.JPanel
       {
           String name;
           String message;

            public NewJPanel(String n,String mess)
            {
                this.name=n;
                this.message=mess;
                initComponents();
            }

            private void initComponents()
            {
                jScrollPane1 = new javax.swing.JScrollPane();
                jTextPane1 = new javax.swing.JTextArea();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTextArea1 = new javax.swing.JTextArea();

                setBackground(new java.awt.Color(255, 255, 255));
                setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

                jTextPane1.setBackground(new java.awt.Color(153, 255, 255));
                jScrollPane1.setViewportView(jTextPane1);
                jTextPane1.setEditable(false);
                jTextArea1.setBackground(new java.awt.Color(255, 102, 102));
                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
                jScrollPane2.setViewportView(jTextArea1);
                jTextArea1.addKeyListener(new KeyListener()
                                            {
                                                public void keyPressed(KeyEvent ke)
                                                {
                                                    int keyCode=ke.getKeyCode();
                                                    if(keyCode==KeyEvent.VK_ENTER)
                                                    {

                            c.sendMessage(jTextArea1.getText().trim(), name);
                            jTextPane1.append("\n"+jTextArea1.getText().trim());
                            jTextArea1.setText("");

                                                    }
                                                }

                                                public void keyTyped(KeyEvent ke) {
                }

                                                public void keyReleased(KeyEvent ke) {
                }
                                            });

                org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 258, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
        );


    }
           }
       }

       



}