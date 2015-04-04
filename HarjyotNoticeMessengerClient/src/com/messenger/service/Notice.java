package com.messenger.service;

/*     */ import com.sun.net.ssl.internal.ssl.Provider;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.security.Security;
/*     */ import java.util.Properties;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.mail.Authenticator;
/*     */ import javax.mail.Message;
/*     */ import javax.mail.PasswordAuthentication;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Transport;
/*     */ import javax.mail.internet.InternetAddress;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */
/*     */ public class Notice
        /*     */ implements Runnable /*     */ {
    /*  29 */ String m = "";
    /*  30 */ String tn = "";
    /*  31 */ String sur = "";
    /*  32 */ String d = "";
    /*  33 */ String y = "";
    /*  34 */ String b = "";
    /*  35 */ Thread thr = new Thread(this);
    /*     */
    /*  37 */ Toolkit tk = Toolkit.getDefaultToolkit();
    /*  38 */ int w = (int) this.tk.getScreenSize().getWidth();
    /*  39 */ int h = (int) this.tk.getScreenSize().getHeight();
    /*     */
    /*     */ Notice(String survey, String tname, String mess, String date, String year, String branch) /*     */ {
        /*  44 */ this.y = year;
        /*  45 */ this.b = branch;
        /*  46 */ this.m = mess;
        /*  47 */ this.d = date;
        /*  48 */ this.sur = survey;
        /*  49 */ this.tn = tname;
        /*     */ try /*     */ {
            /*  53 */ File f = new File("Notices\\");
            /*     */
            /*  55 */ BufferedWriter bb = new BufferedWriter(new FileWriter("Notices\\" + (f.list().length + 1) + ".ravs"));
            /*  56 */ if (this.sur.contains("yes")) /*     */ {
                /*  58 */ bb.append("Survey");
                /*     */            } /*     */ else /*     */ {
                /*  62 */ bb.append("Notice");
                /*     */            }
            /*  64 */ bb.newLine();
            /*  65 */ bb.append("From-->" + tname);
            /*  66 */ bb.newLine();
            /*  67 */ bb.append("Date-->" + date);
            /*  68 */ bb.newLine();
            /*  69 */ bb.append("Message-->");
            /*  70 */ bb.newLine();
            /*  71 */ bb.append(mess);
            /*  72 */ bb.close();
        } catch (Exception asdsa) {
            /*     */        }
        /*  74 */ this.thr.start();
        /*     */    }
    /*     */
    /*     */ public void run() /*     */ {
        /*  79 */ EventQueue.invokeLater(new Runnable() {
            /*     */ public void run() {
                /*  81 */ new Notice.NewJFrame1().setVisible(true);
                /*     */            }
            /*     */        });
        /*     */    }
    /*     */
    /*     */ public class sending1 /*     */ {
        /*     */ private static final String SMTP_HOST_NAME = "smtp.gmail.com";
        /*     */ private static final String SMTP_PORT = "465";
        /*     */ private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        /* 228 */ String MsgTxt = null;
        /* 229 */ String Subject = null;
        /* 230 */ String From = null;
        /* 231 */ String pwd = null;
        /*     */ String[] too;
        /* 233 */ String ss = "";
        /*     */
        /*     */ public sending1(String fr, String msg, String sub, String[] fro, String p) /*     */ {
            /* 237 */ this.MsgTxt = msg;
            /* 238 */ this.Subject = sub;
            /* 239 */ this.From = fr;
            /* 240 */ this.pwd = p;
            /* 241 */ this.too = fro;
            /*     */        }
        /*     */
        /*     */ public String send() /*     */ {
            /* 246 */ String s = "";
            /* 247 */ Security.addProvider(new Provider());
            /*     */ try /*     */ {
                /* 250 */ sendSSLMessage(this.too, this.Subject, this.MsgTxt, this.From, this.pwd);
                /*     */            } /*     */ catch (Exception e) {
                /* 253 */ s = e.getMessage();
                /*     */            }
            /* 255 */ if (s.equals("")) /*     */ {
                /* 257 */ s = "Your message is successfully mailed";
                /*     */            }
            /* 259 */ return this.ss;
            /*     */        }
        /*     */
        /*     */ public void sendSSLMessage(String[] recipients, String subject, String message, String from, String pwd) /*     */ {
            /*     */ try /*     */ {
                /* 267 */ boolean debug = false;
                /* 268 */ Properties props = new Properties();
                /* 269 */ props.put("mail.smtp.host", "smtp.gmail.com");
                /* 270 */ props.put("mail.smtp.auth", "true");
                /* 271 */ props.put("mail.debug", "true");
                /* 272 */ props.put("mail.smtp.port", "465");
                /* 273 */ props.put("mail.smtp.socketFactory.port", "465");
                /* 274 */ props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                /* 275 */ props.put("mail.smtp.socketFactory.fallback", "false");
                /* 276 */ final String from1 = from;
                /* 277 */ final String pwd1 = pwd;
                /* 278 */ Session session = Session.getInstance(props, new Authenticator() {
                    /*     */ protected PasswordAuthentication getPasswordAuthentication() {
                        /* 280 */ return new PasswordAuthentication(from1, pwd1);
                        /*     */                    }
                    /*     */                });
                /* 282 */ session.setDebug(debug);
                /*     */
                /* 284 */ Message msg = new MimeMessage(session);
                /* 285 */ InternetAddress addressFrom = new InternetAddress(from);
                /* 286 */ msg.setFrom(addressFrom);
                /*     */
                /* 288 */ InternetAddress[] addressTo = new InternetAddress[recipients.length];
                /* 289 */ for (int i = 0; i < recipients.length; i++) /*     */ {
                    /* 291 */ addressTo[i] = new InternetAddress(recipients[i]);
                    /*     */                }
                /* 293 */ msg.setRecipients(Message.RecipientType.TO, addressTo);
                /*     */
                /* 295 */ msg.setSubject(subject);
                /* 296 */ msg.setContent(message, "text/plain");
                /* 297 */ Transport.send(msg);
                /* 298 */ from = null;
                /* 299 */ recipients = null;
                /* 300 */ pwd = null;
                /* 301 */ subject = null;
                /* 302 */ message = null;
            } catch (Exception asda) {
                /* 303 */ this.ss = "caught";
                /*     */            }
            /*     */        }
        /*     */    }
    /*     */
    /*     */ class NewJFrame1 extends JFrame
            /*     */ implements Runnable /*     */ {
        /*     */ public InfiniteProgressPanel glassPane;
        /*  89 */ int total = 0;
        /*  90 */ Thread thread = new Thread(this);
        /*     */ JButton jButton1;
        /*     */ JButton jButton2;
        /*     */ JLabel jLabel1;
        /*     */ JLabel jLabel2;
        /*     */ JLabel jLabel3;
        /*     */ JLabel jLabel4;
        /*     */ JScrollPane jScrollPane1;
        /*     */ JTextArea jTextArea1;
        /*     */
        /*     */ public NewJFrame1() /*     */ {
            /* 104 */ initComponents();
            /*     */        }
        /*     */
        /*     */ private void initComponents() /*     */ {
            /* 110 */ this.jLabel1 = new JLabel();
            /* 111 */ this.jLabel2 = new JLabel();
            /* 112 */ this.jLabel3 = new JLabel();
            /* 113 */ this.jScrollPane1 = new JScrollPane();
            /* 114 */ this.jTextArea1 = new JTextArea();
            /* 115 */ this.jButton1 = new JButton();
            /* 116 */ this.jButton2 = new JButton();
            /* 117 */ this.jLabel4 = new JLabel();
            /*     */
            /* 119 */ this.glassPane = new InfiniteProgressPanel();
            /*     */
            /* 121 */ setName("GTBIT Messenger");
            /*     */
            /* 123 */ setIconImage(new ImageIcon("img\\r.gif").getImage());
            /* 124 */ setDefaultCloseOperation(1);
            /* 125 */ setMaximumSize(new Dimension(704, 474));
            /* 126 */ setMinimumSize(new Dimension(704, 474));
            /* 127 */ setPreferredSize(new Dimension(704, 474));
            /* 128 */ getContentPane().setLayout(null);
            /* 129 */ setGlassPane(this.glassPane);
            /*     */
            /* 131 */ this.jLabel1.setFont(new Font("Zapfino", 1, 18));
            /* 132 */ this.jLabel1.setText("GTBIT Messenger");
            /* 133 */ getContentPane().add(this.jLabel1);
            /* 134 */ this.jLabel1.setBounds(250, 20, 413, 61);
            /*     */
            /* 136 */ this.jLabel2.setText("From " + Notice.this.tn);
            /* 137 */ getContentPane().add(this.jLabel2);
            /* 138 */ this.jLabel2.setBounds(50, 80, 400, 16);
            /*     */
            /* 140 */ this.jLabel3.setText("Date " + Notice.this.d);
            /* 141 */ getContentPane().add(this.jLabel3);
            /* 142 */ this.jLabel3.setBounds(530, 80, 229, 16);
            /*     */
            /* 144 */ this.jTextArea1.setColumns(20);
            /* 145 */ this.jTextArea1.setRows(5);
            /* 146 */ this.jTextArea1.setWrapStyleWord(true);
            /* 147 */ this.jTextArea1.setLineWrap(true);
            /* 148 */ this.jTextArea1.setEditable(false);
            /* 149 */ this.jTextArea1.setText(Notice.this.m);
            /* 150 */ this.jScrollPane1.setViewportView(this.jTextArea1);
            /*     */
            /* 152 */ getContentPane().add(this.jScrollPane1);
            /* 153 */ this.jScrollPane1.setBounds(40, 110, 616, 274);
            /*     */
            /* 155 */ this.jButton1.setText("Yes");
            /* 156 */ getContentPane().add(this.jButton1);
            /* 157 */ this.jButton1.setBounds(230, 420, 75, 29);
            /* 158 */ this.jButton1.addActionListener(new ActionListener() /*     */ {
                /*     */ public void actionPerformed(ActionEvent ae) /*     */ {
                    /* 162 */ System.out.println(Notice.this.sur.substring(3));
                    /* 163 */ StringTokenizer yr = new StringTokenizer(Notice.this.y, ",");
                    /* 164 */ int year = yr.countTokens();
                    /* 165 */ StringTokenizer br = new StringTokenizer(Notice.this.b, ",");
                    /* 166 */ int branch = br.countTokens();
                    /* 167 */ System.out.println(year + "  " + branch);
                    /* 168 */ Notice.NewJFrame1.this.total = (branch * 60 * year);
                    /* 169 */ Notice.NewJFrame1.this.thread.start();
                    /*     */                }
                /*     */            });
            /* 173 */ this.jButton2.setText("No");
            /* 174 */ getContentPane().add(this.jButton2);
            /* 175 */ this.jButton2.setBounds(390, 420, 75, 29);
            /* 176 */ this.jButton2.addActionListener(new ActionListener() /*     */ {
                /*     */ public void actionPerformed(ActionEvent ae) /*     */ {
                    /* 180 */ Notice.NewJFrame1.this.dispose();
                    /*     */                }
                /*     */            });
            /* 185 */ this.jLabel4.setIcon(new ImageIcon("img\\4.jpg"));
            /* 186 */ getContentPane().add(this.jLabel4);
            /* 187 */ this.jLabel4.setBounds(0, 0, 710, 470);
            /* 188 */ if (Notice.this.sur.contains("no")) /*     */ {
                /* 190 */ this.jButton1.setVisible(false);
                /* 191 */ this.jButton2.setVisible(false);
                /*     */            }
            /*     */
            /* 194 */ setName("GTBIT Messenger");
            /* 195 */ setIconImage(new ImageIcon("img/r.gif").getImage());
            /* 196 */ setTitle("GTBIT Messenger");
            /* 197 */ pack();
            /* 198 */ setLocation(Notice.this.h / 2, Notice.this.w / 8);
            /*     */        }
        /*     */
        /*     */ public void run() /*     */ {
            /* 203 */ this.glassPane.start();
            /* 204 */ String[] to = {"ravsurvey@gmail.com"};
            /* 205 */ Notice.sending1 s = new Notice.sending1("gtbitinfo1@gmail.com", "" + this.total, Notice.this.sur.substring(3), to, "docomo3401");
            /* 206 */ String check = s.send();
            /* 207 */ if (check.equalsIgnoreCase("caught")) /*     */ {
                /* 209 */ this.glassPane.stop();
                /* 210 */ JOptionPane.showMessageDialog(null, "Network Problem Please check your internet connection", "Error", 0);
                /*     */            } /*     */ else /*     */ {
                /* 214 */ this.glassPane.stop();
                /* 215 */ JOptionPane.showMessageDialog(null, "Survey Response Sent", "Confirmation", 1);
                /*     */            }
            /* 217 */ dispose();
            /*     */        }
        /*     */    }
    /*     */ }