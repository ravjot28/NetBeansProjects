/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import com.sun.mail.pop3.POP3SSLStore;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.ParseException;

public class GmailUtilities {

    private Session session = null;
    private Store store = null;
    private String username, password;
    private Folder folder;

    public GmailUtilities() {

    }

    public void setUserPass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void connect() throws Exception {

        String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        Properties pop3Props = new Properties();

        pop3Props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
        pop3Props.setProperty("mail.pop3.socketFactory.fallback", "false");
        pop3Props.setProperty("mail.pop3.port",  "995");
        pop3Props.setProperty("mail.pop3.socketFactory.port", "995");

        URLName url = new URLName("pop3", "pop.gmail.com", 995, "",
                username, password);

        session = Session.getInstance(pop3Props, null);
        store = new POP3SSLStore(session, url);
        store.connect();

    }

    public void openFolder(String folderName) throws Exception {

        // Open the Folder
        folder = store.getDefaultFolder();

        folder = folder.getFolder(folderName);

        if (folder == null) {
            throw new Exception("Invalid folder");
        }

        // try to open read/write and if that fails try read-only
        try {

            folder.open(Folder.READ_WRITE);

        } catch (MessagingException ex) {

            folder.open(Folder.READ_ONLY);

        }
    }

    public void closeFolder() throws Exception {
        folder.close(false);
    }

    public int getMessageCount() throws Exception {
        return folder.getMessageCount();
    }

    public int getNewMessageCount() throws Exception {
        return folder.getNewMessageCount();
    }

    public void disconnect() throws Exception {
        store.close();
    }

    public void printMessage(int messageNo) throws Exception {
        System.out.println("Getting message number: " + messageNo);

        Message m = null;

        try {
            m = folder.getMessage(messageNo);
            dumpPart(m);
        } catch (IndexOutOfBoundsException iex) {
            System.out.println("Message number out of range");
        }
    }

    public void printAllMessageEnvelopes() throws Exception {

        // Attributes & Flags for all messages ..
        Message[] msgs = folder.getMessages();

        // Use a suitable FetchProfile
        FetchProfile fp = new FetchProfile();
        fp.add(FetchProfile.Item.ENVELOPE);
        folder.fetch(msgs, fp);

        for (int i = 0; i < msgs.length; i++) {
            System.out.println("--------------------------");
            System.out.println("MESSAGE #" + (i + 1) + ":");
            dumpEnvelope(msgs[i]);

        }

    }

    public void printAllMessages() throws Exception {

        // Attributes & Flags for all messages ..
        Message[] msgs = folder.getMessages();

        // Use a suitable FetchProfile
        FetchProfile fp = new FetchProfile();
        fp.add(FetchProfile.Item.ENVELOPE);
        folder.fetch(msgs, fp);

        for (int i = 0; i < msgs.length; i++)
        {
            System.out.println("--------------------------");
            System.out.println("MESSAGE #" + (i + 1) + ":");
            dumpPart(msgs[i]);
        }


    }


    public static void dumpPart(Part p) throws Exception {
        if (p instanceof Message)
            dumpEnvelope((Message)p);

        String ct = p.getContentType();
        try {
            pr("CONTENT-TYPE: " + (new ContentType(ct)).toString());
        } catch (ParseException pex) {
            pr("BAD CONTENT-TYPE: " + ct);
        }

        /*
         * Using isMimeType to determine the content type avoids
         * fetching the actual content data until we need it.
         */
        if (p.isMimeType("text/plain")) {
            pr("This is plain text");
            pr("---------------------------");
            System.out.println((String)p.getContent());
        } else {

            // just a separator
            pr("---------------------------");

        }
    }

    public static void dumpEnvelope(Message m) throws Exception {
        pr(" ");
        Address[] a;
        // FROM
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++)
                pr("FROM: " + a[j].toString());
        }

        // TO
        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++) {
                pr("TO: " + a[j].toString());
            }
        }

        // SUBJECT
        pr("SUBJECT: " + m.getSubject());

        // DATE
        Date d = m.getSentDate();
        pr("SendDate: " +
                (d != null ? d.toString() : "UNKNOWN"));


    }

    static String indentStr = "                                               ";
    static int level = 0;

    /**
     * Print a, possibly indented, string.
     */
    public static void pr(String s) {

        System.out.print(indentStr.substring(0, level * 2));
        System.out.println(s);
    }

}