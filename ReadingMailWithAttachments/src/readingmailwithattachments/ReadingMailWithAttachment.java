/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingmailwithattachments;

/**
 *
 * @author ravjotsingh
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class ReadingMailWithAttachment {

    static String messagess = ",";
    Session session;
    Store store;
    String aaa[][];
    boolean exception = false;
    static String indentStr = "                                               ";
    static int level = 0;

    public static void main(String as[]) {
        ReadingMailWithAttachment r = new ReadingMailWithAttachment();
        r.startreading();
    }

    ReadingMailWithAttachment() {

        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            session = Session.getDefaultInstance(props, null);
            store = session.getStore("imaps");
            store.connect("imap.gmail.com", "ravjot28@gmail.com", "ybmcownmwohmmkcd");
        } catch (Exception adfasf) {
            System.out.println(adfasf);
        }
    }

    public void startreading() {
        System.out.println(store);
        try {
            Folder inbox = store.getFolder("Inbox");//Folder inbox = store.getFolder("Personal");//Folder inbox = store.getFolder("[Gmail]/Trash");//Folder inbox = store.getFolder("[Gmail]/Spam");//Folder inbox = store.getFolder("[Gmail]/Drafts");//Folder inbox = store.getFolder("[Gmail]/All Mail");//Folder inbox = store.getFolder("[Gmail]/Starred");//Folder inbox = store.getFolder("[Gmail]/Sent Mail");//Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_ONLY);
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message messages[] = inbox.search(ft);
            List<File> attachments = new ArrayList<>();

            for (Message message : messages) {
                if (message.getContent() instanceof Multipart) {
                    Multipart multipart = (Multipart) message.getContent();
                    for (int i = 0; i < multipart.getCount(); i++) {
                        BodyPart bodyPart = multipart.getBodyPart(i);
                        if (!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())) {
                            continue; 
                        }
                        InputStream is = bodyPart.getInputStream();
                        File f = new File("/tmp/" + bodyPart.getFileName());
                        FileOutputStream fos = new FileOutputStream(f);
                        byte[] buf = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = is.read(buf)) != -1) {
                            fos.write(buf, 0, bytesRead);
                        }
                        fos.close();
                        attachments.add(f);
                    }
                }
            }

            System.out.println(attachments);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
