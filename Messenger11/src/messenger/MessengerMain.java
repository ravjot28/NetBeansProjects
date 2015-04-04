/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

import java.net.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import sun.swing.PrintColorUIResource;

/**
 *
 * @author puneet
 */
public class MessengerMain {

    InputStreamReader streamReader;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;
    JTextArea incomingMessageWindow;
    JTextField outgoingMessageWindow;

    public void drawChatWindow() {
        JFrame  messengerFrame = new JFrame("My Dark Messenger");
        JPanel  messengerPanel = new JPanel();
        incomingMessageWindow = new JTextArea(15,50);
        incomingMessageWindow.setLineWrap(true);
        incomingMessageWindow.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(incomingMessageWindow);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoingMessageWindow = new JTextField(20);
        JButton sendButton = new JButton("Send Message");
        sendButton.addActionListener(new SendButtonActionListener());
        messengerPanel.add(scrollPane);
        messengerPanel.add(outgoingMessageWindow);
        messengerPanel.add(sendButton);
        System.out.println("set up before");
        setupNetworking();
        Thread t = new Thread(new messageReader());
        t.start();
        System.out.println("set up after");
        messengerFrame.getContentPane().add(messengerPanel);
        messengerFrame.setSize(600, 500);
        messengerFrame.setVisible(true);


    }

    public void setupNetworking() {
        try {
             sock = new Socket("localhost", 5000);
            streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
        } catch (IOException ex) {
            ex.getStackTrace();

        }
    }

    public class SendButtonActionListener implements ActionListener
    {

        public void actionPerformed(ActionEvent e) {
            try{
            writer.println(outgoingMessageWindow.getText());
            writer.flush();
            }
            catch (Exception ex )
            {
            ex.getStackTrace();
            }
            incomingMessageWindow.append(outgoingMessageWindow.getText() + "\n");
            outgoingMessageWindow.setText("");
            outgoingMessageWindow.requestFocus();
        }


    }

    public void sendText(String textToSend) {
        try {

            writer.print(textToSend);

        } catch (Exception ex) {
            ex.getStackTrace();

        }

    }
public class messageReader implements Runnable
    {
       public void run() {
        try {
            String msg = reader.readLine();
            while ( msg != null) {
                incomingMessageWindow.append(msg+"\n");
                System.out.println(msg);

            }
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MessengerMain obj = new MessengerMain();
        obj.drawChatWindow();

        // TODO code application logic here
        // obj.ClientRead();
    }
}
