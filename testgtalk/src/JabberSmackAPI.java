import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromContainsFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;

public class JabberSmackAPI implements MessageListener
{

    XMPPConnection connection;
    JScrollPane jScrollPane1;
    JScrollPane jScrollPane2;
    JTextArea jTextArea1;
    JTextArea jTextPane1;
    JabberSmackAPI c;
    String email;
    JFrame f;
    private ChatPanel cp;

    public void login(String userName, String password,String em) throws XMPPException
    {
        email=em;
    ConnectionConfiguration config = new ConnectionConfiguration("talk.google.com",5222, "Work");
    connection = new XMPPConnection(config);

    connection.connect();
    connection.login(userName, password);
    PacketFilter filter= new AndFilter(new PacketTypeFilter(Message.class),new FromContainsFilter(email));

           PacketListener myListener = new PacketListener() {
                public void processPacket(Packet packet) {
                    if (packet instanceof Message) {
                        Message msg = (Message) packet;
                        // Process message
                        String temp = msg.getFrom();
                        String emailid = temp.substring(0,temp.lastIndexOf("/"));
                        String mess=msg.getBody();
                        System.out.println(emailid+" "+mess);
                        jTextPane1.append(emailid+" "+mess);
                        //jTextPane1.setText("Adfadsfadsfadfasdfdasadff");

                    }
                }
            };
            connection.addPacketListener(myListener, filter);
     
    }

    public void sendMessage(String message, String to) throws XMPPException
    {
    Chat chat = connection.getChatManager().createChat(email, this);
    chat.sendMessage(message);
    }

    public void displayBuddyList()
    {
    Roster roster = connection.getRoster();
    Collection<RosterEntry> entries = roster.getEntries();

    System.out.println("\n\n" + entries.size() + " buddy(ies):");
    for(RosterEntry r:entries)
    {
    System.out.println(r.getUser());
    }
    }

    public void disconnect()
    {
    connection.disconnect();
    }


    public void begin(String u,String p,String to) throws XMPPException, IOException
    {
    // declare variables
    c = new JabberSmackAPI();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String msg;


    // turn on the enhanced debugger
    XMPPConnection.DEBUG_ENABLED = false;
email=to;

    // Enter your login information here
    c.login(u, p,to);
    String talkTo =to;

   // c.displayBuddyList();

    /*System.out.println("-----");

    System.out.println("Who do you want to talk to? - Type contacts full email address:");
    String talkTo =to;

    System.out.println("-----");
    System.out.println("All messages will be sent to " + talkTo);
    System.out.println("Enter your message in the console:");
    System.out.println("-----\n");*/

   /* while( !(msg=br.readLine()).equals("bye"))
    {
        c.sendMessage(msg, talkTo);
    }*/
    f = new JFrame(talkTo);
    cp=new ChatPanel();
    f.add(cp);
    f.addWindowListener(new WindowAdapter()
                        {
                            public void windowClosing(WindowEvent e)
                            {
                                 c.disconnect();
                                 f.dispose();
                            }
                        });
    f.pack();
    f.setVisible(true);
    }

    public void processMessage(Chat chat, Message msg) {    }

    class ChatPanel extends javax.swing.JPanel
    {

    public ChatPanel() throws XMPPException
    {
        initComponents();
    }

    void set(String m)
    {
        jTextPane1.append("ala re");
    }

    private void initComponents() throws XMPPException
    {     
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jTextPane1.setBackground(new java.awt.Color(153, 255, 255));
        jScrollPane1.setViewportView(jTextPane1);

        jTextArea1.setBackground(new java.awt.Color(255, 102, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);
        jTextPane1.setEditable(false);
        jTextArea1.addKeyListener(new KeyListener()
                                            {
                                                public void keyPressed(KeyEvent ke)
                                                {
                                                    int keyCode=ke.getKeyCode();
                                                    if(keyCode==KeyEvent.VK_ENTER)
                                                    {
                        try {
                            c.sendMessage(jTextArea1.getText().trim(), email);
                        } catch (XMPPException ex) {
                            Logger.getLogger(JabberSmackAPI.class.getName()).log(Level.SEVERE, null, ex);
                        }
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