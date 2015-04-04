package mailreader;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class InboxReader {

    static String messagess = ",";
    Session session;
    Store store;
    String aaa[][];
    boolean exception = false;
    String uname;
    String pname;
    static String indentStr = "                                               ";
    static int level = 0;

    public InboxReader(String u, String p, String host) throws Exception {
        uname = u;
        pname = p;
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            session = Session.getDefaultInstance(props, null);
            store = session.getStore("imaps");
            store.connect(host, u, p);//store.connect("imap.gmail.com", u, p);
        } catch (Exception e) {
            throw e;
        }

    }

    public List<MessageContent> startreading() throws Exception {
        List<MessageContent> messageList = new ArrayList<MessageContent>();
        System.out.println(store);
        try {
            Folder inbox = store.getFolder("Inbox");//Folder inbox = store.getFolder("Personal");//Folder inbox = store.getFolder("[Gmail]/Trash");//Folder inbox = store.getFolder("[Gmail]/Spam");//Folder inbox = store.getFolder("[Gmail]/Drafts");//Folder inbox = store.getFolder("[Gmail]/All Mail");//Folder inbox = store.getFolder("[Gmail]/Starred");//Folder inbox = store.getFolder("[Gmail]/Sent Mail");//Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_ONLY);
            //Message messages[] = inbox.getMessages();
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.RECENT), false);//FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message messages[] = inbox.search(ft);
            for (Message message : messages) {
                MessageContent mc = new MessageContent();
                mc = dumpEnvelope(message);
                messageList.add(mc);
                System.out.println("From " + mc.getFrom());
                System.out.println("To " + mc.getTo());
                System.out.println("Sent Date " + mc.getSendDate());
                System.out.println("Subject " + mc.getSubject());
                System.out.println("Body " + mc.getBody());
            }

        } catch (Exception e) {
            throw e;
        }
        return messageList;
    }

    public static void main(String asd[]) throws Exception {
        List<MessageContent> list = new InboxReader("emailid", "password", "imap.gmail.com").startreading();
    }

    private MessageContent dumpEnvelope(Message m) throws Exception {
        MessageContent message = new MessageContent();
        Date d = m.getSentDate();
        Address[] a;
        String a1 = "";
        // FROM
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++) {
                a1 += a[j].toString() + ",";
            }
        }

        message.setFrom(a1);
        a1 = "";
        // TO
        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++) {
                a1 += a[j].toString() + ",";
            }
        }
        message.setTo(a1);
        a1 = "";
        // SUBJECT
        a1 += m.getSubject();

        message.setSubject(a1);
        a1 = "";
        // DATE
        a1 += (d != null ? d.toString() : "UNKNOWN");
        message.setSendDate(a1);
        a1 = "";
        a1 += m.getContent();
        message.setBody(a1);


        return message;
    }
}
