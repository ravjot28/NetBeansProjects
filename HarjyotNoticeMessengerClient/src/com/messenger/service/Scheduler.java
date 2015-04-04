/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.service;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Rav
 */
public class Scheduler implements Runnable {

    Thread th;

    public void start() {
        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        callReader();
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
        System.out.println("br " + br + " " + yr);
        InboxReader ir = new InboxReader(yr,
                br);
    }
}
