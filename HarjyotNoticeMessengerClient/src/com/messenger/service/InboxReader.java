package com.messenger.service;

import com.messenger.constants.GlobalConstants;
import com.messenger.dao.NoticeDAO;
import com.messenger.dao.SurveyDAO;
import com.messenger.ui.ScreenController;
import com.messenger.util.SaveObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class InboxReader {

    static String messagess = ",";
    Session session;
    Store store;
    String[][] aaa;
    boolean exception = false;
    static String yr;
    static String bran;
    static String indentStr = "                                               ";
    static int level = 0;
    
    //

    public InboxReader(String a, String bi) {
        yr = a;
        bran = bi;
        System.out.println("in InboxReader br "+a+" "+bi);
        File f = new File("id.ravs");
        if (f.exists()) {
            try {
                BufferedReader b = new BufferedReader(new FileReader("id.ravs"));
                messagess = b.readLine().trim();
            } catch (Exception ad) {
            }
        }
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            this.session = Session.getDefaultInstance(props, null);
            this.store = this.session.getStore("imaps");
            this.store.connect("imap.gmail.com", "ravnotifier@gmail.com", "ravjotsingh");
        } catch (Exception adfasf) {
            System.out.println(adfasf);
        }
        startreading();
    }

    public void startreading() {
        System.out.println(this.store);
        try {
            Folder inbox = this.store.getFolder("Inbox");
            inbox.open(1);

            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message[] messages = inbox.search(ft);
            Date date = new Date();
            String p = "";
            for (Message message : messages) {
                if (!messagess.contains("," + message.getMessageNumber())) {
                    p = p + dumpEnvelope(message) + "$$$";
                    int a = message.getMessageNumber();
                    messagess = messagess + a + ",";
                }
            }
            if (p.length() != 0) {
                StringTokenizer t = new StringTokenizer(p, "$$$");
                String[][] aa = new String[t.countTokens()][3];
                int i = 0;
                while (t.hasMoreTokens()) {
                    String temp = t.nextToken();
                    StringTokenizer t1 = new StringTokenizer(temp, "|");
                    int j = 0;
                    while (t1.hasMoreTokens()) {
                        String temp1 = t1.nextElement().toString();
                        if (!temp1.contains("TO:")) {
                            aa[i][j] = temp1;
                            j++;
                        }
                    }
                    i++;
                }
                this.aaa = aa;
                for (int i2 = 0; i2 < this.aaa.length; i2++) {
                    StringTokenizer tt = new StringTokenizer(this.aaa[i2][1], "##");
                    String year = tt.nextToken();
                    String branch = tt.nextToken();
                    String survey = tt.nextToken();
                    String date1 = tt.nextToken();
                    String tname = tt.nextToken();
                    System.out.println(year+"  "+branch);
                    System.out.println(yr.substring(0,1)+"  "+bran);
                    if ((year.contains(yr.substring(0,1))) && (branch.contains(bran))) {
                        year = year.replaceAll("SUBJECT: ", "");
                        System.out.println("Year" + year);
                        System.out.println("Branch" + branch);
                        System.out.println("Survey" + survey);
                        System.out.println("Date" + date1);
                        System.out.println("Teacher Name" + tname);
                        System.out.println("Message\n" + this.aaa[i2][2]);
                        //new Notice(survey, tname, this.aaa[i2][2], date1, year, branch);
                        SaveObject so = new SaveObject();
                        LaunchNoticeSurvey lns = new LaunchNoticeSurvey();
                        if (survey.contains("yes")) {
                            SurveyDAO sd = new SurveyDAO();
                            sd.setBody(this.aaa[i2][2]);
                            sd.setBranch(branch);
                            sd.setDate(date1);
                            sd.setFrom(tname);
                            sd.setYear(year);
                            so.saveSurveyObject(sd);
                            lns.displaySurvey();
                        } else {
                            NoticeDAO nd = new NoticeDAO();
                            nd.setBody(this.aaa[i2][2]);
                            nd.setBranch(branch);
                            nd.setDate(date1);
                            nd.setFrom(tname);
                            nd.setYear(year);
                            so.saveNoticeObject(nd);
                            lns.displayNotice();
                        }
                    }

                }

            }

        } catch (Exception e) {
            this.exception = true;
        }
        try {
            new Thread();
            Thread.sleep(100L);
        } catch (Exception adf) {
            System.out.println("2");
        }
        if (this.exception) {
            try {
                this.store.close();
                BufferedWriter b = new BufferedWriter(new FileWriter("id.ravs"));
                b.append(messagess);
                b.close();
                new InboxReader(yr, bran);
            } catch (Exception asd) {
            }
        } else {
            startreading();
        }

        System.out.println("Exception is" + this.exception);
    }

   

    public static String dumpEnvelope(Message m) throws Exception {
        String a1 = "";
        String a2 = "";
        String a3 = "";
        String a4 = "";
        Date d = m.getSentDate();
        Date date = new Date();
        pr(" ");
        Address[] a;
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++) {
                a1 = a1 + pr(new StringBuilder().append("FROM: ").append(a[j].toString()).toString()) + ",";
            }
        }

        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++) {
                a2 = a2 + pr(new StringBuilder().append("TO: ").append(a[j].toString()).toString()) + ",";
            }

        }

        a3 = a3 + pr(new StringBuilder().append("SUBJECT: ").append(m.getSubject()).toString());

        a4 = m.getContent().toString();

        return a1 + "|" + a2 + "|" + a3 + "|" + a4 + "|";
    }

    public static String pr(String s) {
        System.out.print(indentStr.substring(0, level * 2));
        return s;
    }
}
