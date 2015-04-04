package javaapplication4;

import java.awt.event.*;
import ravmail.SendMailWithAttachmentsGmail;
import java.io.*;
import ravmail.SendMailWithAttachmentsYahoo;

import RavBase64.Base64Decoder;
import java.util.*;


public class shared extends javax.swing.JFrame implements Runnable {

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
     Thread t;

     String song;

    public shared(String songLocation) {
        this.song = songLocation;
        initComponents();
    }


    private void initComponents() {


        setTitle("share..");

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        t=new Thread(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton1.setText("SHARE");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
              t.start();
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 310, 160, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("MESSAGE-");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 140, 100, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("TO :-");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 120, 50, 17);

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(50, 120, 170, 20);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel1.setText("WHERE WORDS FAIL...MUSIC SPEAKS !!!!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 40, 300, 26);

        jLabel5.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        jLabel5.setText("SHARE MUSIC...SHARE LIVES ....");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 70, 240, 20);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 230, 140);

        jLabel2.setIcon(new javax.swing.ImageIcon("share.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 420, 340);

       setSize(430,378);
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
            }


   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new shared("share.png").setVisible(true);
            }
        });
    }

public void run()
    {
    String emails = jTextField1.getText().trim();
     StringTokenizer s = new StringTokenizer(emails,",");
     String final_emails[] = new String[s.countTokens()];
     int i=0;
      while(s.hasMoreTokens())
      {
        final_emails[i] = s.nextToken();
        i++;

      }
    String msg=jTextArea1.getText();
    String decode,decode1;
     String attach[]={song};
     try
     {
         BufferedReader b=new BufferedReader(new FileReader("bin\\userdata\\mail.txt"));
         String data=b.readLine();
         Base64Decoder be=new Base64Decoder(data);
         decode=be.get();
         String data1=b.readLine();
         Base64Decoder be1=new Base64Decoder(data1);
         decode1=be1.get();
         b.close();
         System.out.println("email"+decode+decode1);
          if(decode.indexOf( "gmail" ) >= 0)
          {
          System.out.println("Gmail"+decode+decode1);
         SendMailWithAttachmentsGmail sm=new SendMailWithAttachmentsGmail(decode,decode1,"subject",msg,attach,final_emails);
          boolean b1=sm.send();
           System.out.println(b1);
          }
          else
              if(decode.indexOf( "yahoo" ) >= 0)
          {
              System.out.println("Yahoo"+decode+decode1);
          SendMailWithAttachmentsYahoo sm=new SendMailWithAttachmentsYahoo(decode,decode1,"subject",msg,attach,final_emails);
          boolean b1=sm.send();
          System.out.println(b1);
          }
 else
              {
             System.out.println("No");
 }





     }
     catch(Exception e)
     {
         System.out.println(e);
     }

}

}
