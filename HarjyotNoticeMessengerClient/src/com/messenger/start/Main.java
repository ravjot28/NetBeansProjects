/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.start;

import com.messenger.constants.GlobalConstants;
import com.messenger.dao.NoticeDAO;
import com.messenger.dao.SurveyDAO;
import com.messenger.service.InboxReader;
import static com.messenger.service.InboxReader.dumpEnvelope;
import static com.messenger.service.InboxReader.pr;
import com.messenger.service.LaunchNoticeSurvey;
import com.messenger.service.Scheduler;
import com.messenger.ui.ScreenController;
import com.messenger.util.SaveObject;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.StringTokenizer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

/**
 *
 * @author Ravjot
 */
public class Main extends Application {

    static String messagess = ",";
    static Session session;
    static Store store;
    static String[][] aaa;
    static boolean exception = false;
    static String yr;
    static String bran;
    static String indentStr = "                                               ";
    static int level = 0;

    public void setup() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Entered");
        ScreenController sceneNavigator = new ScreenController();
        sceneNavigator.loadScreen(GlobalConstants.registrationScene, GlobalConstants.registrationSceneFXML);

        String fname = "Notices\\UserInfo\\userinfo.ravs";
        File f = new File(fname);
        FullTray fullTray = new FullTray();
        if (!(f.exists()) && !(f.length() != 0L)) {
            sceneNavigator.setScreen(GlobalConstants.registrationScene);
            Group root = new Group();
            root.getChildren().addAll(sceneNavigator);


            Scene scene = new Scene(root);
            root.autosize();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.sizeToScene();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setTitle(GlobalConstants.registrationSceneTitle);

            //stage.getIcons().add(new Image(GlobalConstants.registrationLoginIconImage));
            stage.show();
        } else {
            File file = new File("id.ravs");
            if (file.exists()) {
                try {
                    BufferedReader b = new BufferedReader(new FileReader("id.ravs"));
                    messagess = b.readLine().trim();
                } catch (Exception ad) {
                }
            }
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    while (1 < 2) {
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        String a1 = "";
                        String bi = "";
                        try {
                            BufferedReader b = new BufferedReader(new FileReader("Notices\\UserInfo\\userinfo.ravs"));
                            bi = b.readLine().trim();
                            a1 = b.readLine().trim();
                            b.close();
                        } catch (Exception as) {
                        }
                        yr = a1;
                        bran = bi;
                        System.out.println("in InboxReader br " + a1 + " " + bi);


                        Properties props = System.getProperties();
                        props.setProperty("mail.store.protocol", "imaps");
                        try {
                            session = Session.getDefaultInstance(props, null);
                            store = session.getStore("imaps");
                            store.connect("imap.gmail.com", "ravnotifier@gmail.com", "ravjotsingh");
                        } catch (Exception adfasf) {
                            System.out.println(adfasf);
                        }

                        System.out.println(store);
                        try {
                            Folder inbox = store.getFolder("Inbox");
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
                                aaa = aa;
                                for (int i2 = 0; i2 < aaa.length; i2++) {
                                    StringTokenizer tt = new StringTokenizer(aaa[i2][1], "##");
                                    String year = tt.nextToken();
                                    String branch = tt.nextToken();
                                    String survey = tt.nextToken();
                                    String date1 = tt.nextToken();
                                    String tname = tt.nextToken();
                                    System.out.println(year + "  " + branch);
                                    System.out.println(yr.substring(0, 1) + "  " + bran);
                                    if ((year.contains(yr.substring(0, 1))) && (branch.contains(bran))) {
                                        year = year.replaceAll("SUBJECT: ", "");
                                        System.out.println("Year" + year);
                                        System.out.println("Branch" + branch);
                                        System.out.println("Survey" + survey);
                                        System.out.println("Date" + date1);
                                        System.out.println("Teacher Name" + tname);
                                        System.out.println("Message\n" + aaa[i2][2]);
                                        //new Notice(survey, tname, this.aaa[i2][2], date1, year, branch);
                                        SaveObject so = new SaveObject();
                                        LaunchNoticeSurvey lns = new LaunchNoticeSurvey();
                                        System.out.println("BEFORE IF SURVEY " + survey);
                                        if (survey.contains("yes")) {
                                            System.out.println("IN SURVEY");
                                            SurveyDAO sd = new SurveyDAO();
                                            sd.setBody(aaa[i2][2]);
                                            sd.setBranch(branch);
                                            sd.setDate(date1);
                                            sd.setFrom(tname);
                                            sd.setYear(year);
                                            so.saveSurveyObject(sd);
                                            Platform.runLater(new Runnable() {
                                                public void run() {
                                                    Stage stage = new Stage();
                                                    ScreenController sceneNavigator = new ScreenController();
                                                    sceneNavigator.loadScreen(GlobalConstants.surveyScene, GlobalConstants.surveySceneFXML);
                                                    sceneNavigator.setScreen(GlobalConstants.surveyScene);
                                                    Group root = new Group();
                                                    root.getChildren().addAll(sceneNavigator);
                                                    System.out.println("IN SURVEY THREAD");

                                                    Scene scene = new Scene(root);
                                                    root.autosize();
                                                    //stage.initStyle(StageStyle.UNDECORATED);
                                                    stage.sizeToScene();
                                                    stage.setScene(scene);
                                                    stage.setResizable(false);
                                                    stage.centerOnScreen();
                                                    stage.setTitle(GlobalConstants.surveySceneTitle);


                                                    //stage.getIcons().add(new Image(GlobalConstants.registrationLoginIconImage));
                                                    stage.show();
                                                }
                                            });
                                        } else {
                                            NoticeDAO nd = new NoticeDAO();
                                            nd.setBody(aaa[i2][2]);
                                            nd.setBranch(branch);
                                            nd.setDate(date1);
                                            nd.setFrom(tname);
                                            nd.setYear(year);
                                            so.saveNoticeObject(nd);
                                            Platform.runLater(new Runnable() {
                                                public void run() {
                                                    Stage stage = new Stage();
                                                    ScreenController sceneNavigator = new ScreenController();
                                                    sceneNavigator.loadScreen(GlobalConstants.noticeScene, GlobalConstants.noticeSceneFXML);
                                                    sceneNavigator.setScreen(GlobalConstants.noticeScene);
                                                    Group root = new Group();
                                                    root.getChildren().addAll(sceneNavigator);


                                                    Scene scene = new Scene(root);
                                                    root.autosize();
                                                    //stage.initStyle(StageStyle.UNDECORATED);
                                                    stage.sizeToScene();
                                                    stage.setScene(scene);
                                                    stage.setResizable(false);
                                                    stage.centerOnScreen();
                                                    stage.setTitle(GlobalConstants.noticeSceneTitle);

                                                    //stage.getIcons().add(new Image(GlobalConstants.registrationLoginIconImage));
                                                    stage.show();
                                                }
                                            });
                                        }
                                    }

                                }

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            exception = true;
                        }

                        if (exception) {
                            try {
                                store.close();
                                BufferedWriter b = new BufferedWriter(new FileWriter("id.ravs"));
                                b.append(messagess);
                                b.close();

                            } catch (Exception asd) {
                            }
                        }

                        System.out.println("Exception is" + exception);

                    }
                }
            };
            new Thread(task).start();
        }

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

    public static void main(String[] args) {
        launch();
    }

    class FullTray {

        TrayIcon trayIcon;
        final SystemTray tray = SystemTray.getSystemTray();

        FullTray() {
            Runnable runner = new Runnable() {
                public void run() {
                    if (SystemTray.isSupported()) {
                        Image image = Toolkit.getDefaultToolkit().getImage("img/icon.jpg");

                        PopupMenu popup = new PopupMenu();
                        final TrayIcon trayIcon = new TrayIcon(image, "GTBIT Messenger", popup);

                        MenuItem item = new MenuItem("Close");
                        item.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                tray.remove(trayIcon);
                                System.exit(0);
                            }
                        });
                        popup.add(item);

                        item = new MenuItem("About");
                        item.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                EventQueue.invokeLater(new Runnable() {
                                    public void run() {
                                    }
                                });
                            }
                        });
                        popup.add(item);
                        try {
                            tray.add(trayIcon);
                        } catch (Exception easd) {
                            System.err.println("Can't add to tray");
                        }
                    } else {
                        System.err.println("Tray unavailable");
                    }
                }
            };
            EventQueue.invokeLater(runner);
        }

        class ShowMessageListener
                implements ActionListener {

            TrayIcon trayIcon;
            String title;
            String message;
            TrayIcon.MessageType messageType;

            ShowMessageListener(TrayIcon trayIcon, String title, String message, TrayIcon.MessageType messageType) {
                this.trayIcon = trayIcon;
                this.title = title;
                this.message = message;
                this.messageType = messageType;
            }

            public void actionPerformed(ActionEvent e) {
                this.trayIcon.displayMessage(this.title, this.message, this.messageType);
            }
        }
    }
}
