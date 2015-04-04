package javaapplication4;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import ravmail.SendMailGmail;
import ravmail.SendMailYahoo;
import java.util.*;
import RavCustomizedProgressBar.InfiniteProgressPanel;
import RavBase64.Base64Encoder;


public class mailSend extends javax.swing.JFrame implements Runnable
{
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    Thread th;
    InfiniteProgressPanel ipp;

    public mailSend() {
        initComponents();
    }

    private void initComponents() {

        setTitle("   MAIL SENDER   ");

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        th= new Thread(this);

        ipp=new InfiniteProgressPanel("please wait...");

        setGlassPane(ipp);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Sybil Green", 1, 18)); // NOI18N
        jRadioButton1.setText("yahoo !!!");


        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(210, 50, 130, 40);

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Sybil Green", 1, 18)); // NOI18N
        jRadioButton2.setText("GMail...");


        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(50, 50, 120, 40);

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(190, 170, 125, 16);

        jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(190, 200, 125, 16);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButton1.setText("LOGIN");
         jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if((!jRadioButton1.isSelected())&&(!jRadioButton2.isSelected()))
                {
                    JOptionPane.showMessageDialog(null,"Please Select the Email ID domain","Error",JOptionPane.ERROR_MESSAGE);
                }
                else
                 if(jTextField1.getText().trim().equals(""))
                 {
                        JOptionPane.showMessageDialog(null,"Please enter the username","Blank field",JOptionPane.ERROR_MESSAGE);

                 }

                 else
                     if(jPasswordField1.getText().trim().equals(""))
                     {
                         JOptionPane.showMessageDialog(null,"Please enter the password","Blank field",JOptionPane.ERROR_MESSAGE);
                     }
                else
                {
                    th.start();
                }

            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 260, 151, 24);


        jButton2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
              dispose();
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(57, 242, 100, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200,242, 115, 31);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("USERNAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 170, 113, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel2.setText("PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 200, 110, 22);

        jLabel3.setIcon(new javax.swing.ImageIcon("mailback.png")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 400, 300);

        setSize(400,330);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();

    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mailSend().setVisible(true);


            }
        });
    }

    public void run()
    {
        ipp.start();
        boolean authenticate = false;

        if(jRadioButton1.isSelected())
        {
            String to[]={"ishneetd212@gmail.com"};
            //System.out.println(jTextField1.getText().trim()+" "+jPasswordField1.getText().trim());

            SendMailYahoo sm=new SendMailYahoo(jTextField1.getText().trim(),jPasswordField1.getText().trim(),"subject","body",to);

            authenticate =sm.send();
        }

        else
        {
            String to[]={"ishneetd212@gmail.com"};

            //System.out.println(jTextField1.getText().trim()+" "+jPasswordField1.getText().trim());
            SendMailGmail sm=new SendMailGmail(jTextField1.getText().trim(),jPasswordField1.getText().trim(),"hello","bie",to);

            authenticate = sm.send();
        }

        if(authenticate)
        {


            try

            {

                File f=new File("bin");

                f.mkdir();

                File f1=new File("bin\\userdata");

                f1.mkdir();

                BufferedWriter b=new BufferedWriter(new FileWriter("bin\\userdata\\mail.txt"));

                if(((jTextField1.getText().trim()).isEmpty()==false)&&(jPasswordField1.getText().trim().isEmpty()==false))

                {
                     Base64Encoder be=new Base64Encoder(jTextField1.getText().trim());
                     String encode=be.get();
                     
                    b.append(encode);

                    b.newLine();
                     Base64Encoder be1=new Base64Encoder(jPasswordField1.getText().trim());
                     String encode1=be1.get();
                     
                    b.append(encode1);
                    

                   
                }
                b.close();
        }
        catch(Exception e)
        {
            System.out.println(e);

        }
        JOptionPane.showMessageDialog(null,"Successful Registeration","Congrats",JOptionPane.INFORMATION_MESSAGE);
         
        dispose();
        
        }
        else
        {

            JOptionPane.showMessageDialog(null,"Oops!! Incorrect email ID or password. Please Try Again(Also check net connectivity)", null, WIDTH);
            jTextField1.setText("");
            jPasswordField1.setText("");
        }
        ipp.stop();
    }
}
