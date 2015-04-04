/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.start;

import com.messenger.constants.GlobalConstants;
import com.messenger.service.InboxReader;
import com.messenger.ui.ScreenController;
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
import java.io.File;
import java.io.FileReader;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Ravjot
 */
public class Main extends Application {

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
            Task task = new Task<Void>() {
                @Override
                public Void call() {
                    callReader();
                    return null;
                }
            };
            new Thread(task).start();
        }

    }

    public void callReader() {
        String yr = "";
        String br = "";
        try {
            BufferedReader b = new BufferedReader(new FileReader("Notices\\UserInfo\\userinfo.ravs"));
            br = b.readLine().trim();
            yr = b.readLine().trim();
            b.close();
        } catch (Exception as) {
        }
        
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
