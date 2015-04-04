import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class MessengerPage extends JFrame implements Runnable
{
    Thread th=new Thread(this);
    JButton jButton1;
    JButton jButton2;
    JCheckBox jCheckBox1;
    JCheckBox jCheckBox2;
    JCheckBox jCheckBox3;
    JCheckBox jCheckBox4;
    JCheckBox jCheckBox5;
    JCheckBox jCheckBox6;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JRadioButton jRadioButton1;
    JRadioButton jRadioButton2;
    JRadioButton jRadioButton3;
    JRadioButton jRadioButton4;
    JRadioButton jRadioButton5;
    JRadioButton jRadioButton6;
    JRadioButton jRadioButton7;
    JRadioButton jRadioButton8;
    JRadioButton jRadioButton9;
    JScrollPane jScrollPane1;
    JTextArea jTextArea1;
    String surcode="";

    private InfiniteProgressPanel glassPane;
    private String tname;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();

    public MessengerPage(String t)
    {
        tname=t;
        initComponents();
    }
    
    private void initComponents() {

        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jRadioButton4 = new JRadioButton();
        jRadioButton5 = new JRadioButton();
        jRadioButton6 = new JRadioButton();
        jRadioButton7 = new JRadioButton();
        jRadioButton8 = new JRadioButton();
        jRadioButton9 = new JRadioButton();
        jCheckBox1 = new JCheckBox();
        jCheckBox2 = new JCheckBox();
        jCheckBox3 = new JCheckBox();
        jCheckBox4 = new JCheckBox();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jCheckBox5 = new JCheckBox();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel1 = new JLabel();
        jCheckBox6 = new JCheckBox();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();

        this.glassPane = new InfiniteProgressPanel();


        setName("GTBIT Messenger");
        setIconImage(new ImageIcon("img/r.gif").getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(724,535));
        setMinimumSize(new Dimension(724,535));
        setPreferredSize(new Dimension(724,535));
        setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);
        setGlassPane(glassPane);

        jRadioButton1.setText("CSE-1");
        
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(521, 65, 71, 23);

        jRadioButton2.setText("CSE-2");
        
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(610, 65, 71, 23);

        jRadioButton3.setText("ECE-1");
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(521, 106, 71, 23);

        jRadioButton4.setText("ECE-2");
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(610, 106, 71, 23);

        jRadioButton5.setText("IT-1");
        getContentPane().add(jRadioButton5);
        jRadioButton5.setBounds(521, 147, 60, 23);

        jRadioButton6.setText("IT-2");
        getContentPane().add(jRadioButton6);
        jRadioButton6.setBounds(610, 147, 60, 23);

        jRadioButton7.setText("EEE-1");
        getContentPane().add(jRadioButton7);
        jRadioButton7.setBounds(521, 188, 69, 23);

        jRadioButton8.setText("EEE-2");
        getContentPane().add(jRadioButton8);
        jRadioButton8.setBounds(610, 188, 69, 23);

        jRadioButton9.setText("All");
        getContentPane().add(jRadioButton9);
        jRadioButton9.setBounds(521, 229, 49, 23);
        jRadioButton9.addActionListener(new ActionListener()
                                            {
                                                public void actionPerformed(ActionEvent sd)
                                                {
                                                    if(jRadioButton9.isSelected())
                                                    {
                                                    jRadioButton1.setSelected(true);
                                                    jRadioButton2.setSelected(true);
                                                    jRadioButton3.setSelected(true);
                                                    jRadioButton4.setSelected(true);
                                                    jRadioButton5.setSelected(true);
                                                    jRadioButton6.setSelected(true);
                                                    jRadioButton7.setSelected(true);
                                                    jRadioButton8.setSelected(true);

                                                    jRadioButton1.setEnabled(false);
                                                    jRadioButton2.setEnabled(false);
                                                    jRadioButton3.setEnabled(false);
                                                    jRadioButton4.setEnabled(false);
                                                    jRadioButton5.setEnabled(false);
                                                    jRadioButton6.setEnabled(false);
                                                    jRadioButton7.setEnabled(false);
                                                    jRadioButton8.setEnabled(false);
                                                    }
                                                    else
                                                    {
                                                        jRadioButton1.setSelected(false);
                                                        jRadioButton2.setSelected(false);
                                                        jRadioButton3.setSelected(false);
                                                        jRadioButton4.setSelected(false);
                                                        jRadioButton5.setSelected(false);
                                                        jRadioButton6.setSelected(false);
                                                        jRadioButton7.setSelected(false);
                                                        jRadioButton8.setSelected(false);
                                                        jRadioButton1.setEnabled(true);
                                                        jRadioButton2.setEnabled(true);
                                                        jRadioButton3.setEnabled(true);
                                                        jRadioButton4.setEnabled(true);
                                                        jRadioButton5.setEnabled(true);
                                                        jRadioButton6.setEnabled(true);
                                                        jRadioButton7.setEnabled(true);
                                                        jRadioButton8.setEnabled(true);
                                                    }

                                                }
                                            });

        jCheckBox1.setText("1st Year");
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(521, 294, 83, 23);

        jCheckBox2.setText("2nd Year");
        getContentPane().add(jCheckBox2);
        jCheckBox2.setBounds(611, 294, 87, 23);

        jCheckBox3.setText("3rd Year");
        getContentPane().add(jCheckBox3);
        jCheckBox3.setBounds(521, 335, 84, 23);

        jCheckBox4.setText("4th Year");
        getContentPane().add(jCheckBox4);
        jCheckBox4.setBounds(612, 335, 84, 23);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setLineWrap(true);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 65, 495, 362);

        jCheckBox5.setText("Survey");
        getContentPane().add(jCheckBox5);
        jCheckBox5.setBounds(521, 427, 73, 23);

        jButton1.setText("Send");
        getContentPane().add(jButton1);
        jButton1.setBounds(232, 470, 75, 29);

        jButton2.setText("Log Out");
        getContentPane().add(jButton2);
        jButton2.setBounds(370, 470, 94, 29);

        jLabel1.setFont(new Font("Zapfino", 1, 18)); // NOI18N
        jLabel1.setText("Welcome To GTBIT Messenger");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(8, 0, 358, 61);

        jCheckBox6.setText("All");
        getContentPane().add(jCheckBox6);
        jCheckBox6.setBounds(521, 376, 49, 23);
        jCheckBox6.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent ae)
                                            {
                                                if(jCheckBox6.isSelected())
                                                    {
                                                    jCheckBox1.setSelected(true);
                                                    jCheckBox2.setSelected(true);
                                                    jCheckBox3.setSelected(true);
                                                    jCheckBox4.setSelected(true);
                                                   
                                                    jCheckBox1.setEnabled(false);
                                                    jCheckBox2.setEnabled(false);
                                                    jCheckBox3.setEnabled(false);
                                                    jCheckBox4.setEnabled(false);
                                                    }
                                                    else
                                                    {
                                                        jCheckBox1.setSelected(false);
                                                        jCheckBox2.setSelected(false);
                                                        jCheckBox3.setSelected(false);
                                                        jCheckBox4.setSelected(false);

                                                        jCheckBox1.setEnabled(true);
                                                        jCheckBox2.setEnabled(true);
                                                        jCheckBox3.setEnabled(true);
                                                        jCheckBox4.setEnabled(true);
                                                    }
                                            }
                                         });


        jLabel2.setText("Branch");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(521, 35, 42, 16);

        jLabel3.setText("Year");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(521, 274, 27, 16);
        getContentPane().add(jLabel4);
        jLabel4.setIcon(new ImageIcon("img/3.jpg"));
        jLabel4.setBounds(0, 0, 725, 513);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent sd)
                                        {
                                            th.start();
                                        }
                                    });

                      jButton2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent sd){
                      System.exit(0);}});

 setName("GTBIT Messenger");
        setIconImage(new ImageIcon("img/r.gif").getImage());
        setTitle("GTBIT Messenger");
        pack();
        setLocation(h/2,w/8);
    }

    public void run()
    {
        
        String year="";
                                            String branch="";
                                            String survey="";
                                            if(jCheckBox6.isSelected())
                                            {
                                                year="1,2,3,4,";
                                            }
                                            else
                                            {
                                                if(jCheckBox1.isSelected())
                                                {
                                                    year+="1,";
                                                }
                                                if(jCheckBox2.isSelected())
                                                {
                                                    year+="2,";
                                                }
                                                if(jCheckBox3.isSelected())
                                                {
                                                    year+="3,";
                                                }
                                                if(jCheckBox4.isSelected())
                                                {
                                                    year+="4,";
                                                }
                                            }
                                            if(jRadioButton9.isSelected())
                                            {
                                                branch="CSE-1,CSE-2,ECE-1,ECE-2,IT-1,IT-2,EEE-1,EEE-2,";
                                            }
                                            else
                                            {
                                                if(jRadioButton1.isSelected())
                                                {
                                                    branch+="CSE-1,";
                                                }

                                                if(jRadioButton2.isSelected())
                                                {
                                                    branch+="CSE-2,";
                                                }
                                                if(jRadioButton3.isSelected())
                                                {
                                                    branch+="ECE-1,";
                                                }

                                                if(jRadioButton4.isSelected())
                                                {
                                                    branch+="ECE-2,";
                                                }

                                                if(jRadioButton5.isSelected())
                                                {
                                                    branch+="IT-1,";
                                                }

                                                if(jRadioButton6.isSelected())
                                                {
                                                    branch+="IT-2,";
                                                }

                                                if(jRadioButton7.isSelected())
                                                {
                                                    branch+="EEE-1,";
                                                }

                                                if(jRadioButton8.isSelected())
                                                {
                                                    branch+="EEE-2,";
                                                }
                                            }

                                            if(jCheckBox5.isSelected())
                                            {
                                                survey="yes";
                                            }
                                            else
                                            {
                                                survey="no";
                                            }

                                            if(branch.equalsIgnoreCase(""))
                                            {
                                                JOptionPane.showMessageDialog(null,"OOPs!!! Select Branch(es)","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                                if(year.equalsIgnoreCase(""))
                                                {
                                                    JOptionPane.showMessageDialog(null,"OOPs!!! Select Year(s)","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                                else
                                                    if(jTextArea1.getText().trim().length()<=0)
                                                    {
                                                        if(survey.equalsIgnoreCase("no"))
                                                        {
                                                            JOptionPane.showMessageDialog(null,"OOPs!!! Please write the Notice","Error",JOptionPane.ERROR_MESSAGE);
                                                        }
                                                        else
                                                        {
                                                            JOptionPane.showMessageDialog(null,"OOPs!!! Please write the Survey","Error",JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    }
                                            else
                                            {
                                                //System.out.println("Branch Selected "+branch);
                                                //System.out.println("Year Selected "+year);
                                                //System.out.println("Survey "+survey);

                                                //System.out.println("Message --> \n");
                                                //String ln = System.getProperty("line.separator");

                                                //String as = text.replaceAll("\n", ln);
                                                //System.out.println(as);
                                                int answer=100;
                                                if(survey.equalsIgnoreCase("no"))
                                                {
                                                    answer =  JOptionPane.showConfirmDialog(null, "Should I send the notice?", "Confirmation", JOptionPane.YES_NO_OPTION);
                                                }
                                                else
                                                {
                                                   answer =  JOptionPane.showConfirmDialog(null, "Should I send the Survey?", "Confirmation", JOptionPane.YES_NO_OPTION);
                                                }

                                                if (answer == JOptionPane.YES_OPTION)
                                                {
                                                    String text = jTextArea1.getText();
                                                    surcode=DateUtils.now();
                                                    String sub = year+"##"+branch+"##"+(survey+tname+surcode)+"##"+new Calendar1().getdate()+"##"+tname+"##";
                                                    String to[]={"ravnotifier@gmail.com"};
                                                    glassPane.start();
                                                    sending s = new sending("gtbitinfo1@gmail.com",text,sub,to,"docomo3401");
                                                    String check=s.send();
                                                    if(check.equalsIgnoreCase("caught"))
                                                    {
                                                        glassPane.stop();
                                                         JOptionPane.showMessageDialog(null,"Network Problem Please check your internet connection","Error",JOptionPane.ERROR_MESSAGE);
                                                    }
                                                    else
                                                    {
                                                        if(survey.equalsIgnoreCase("yes"))
                                                        {
                                                            
                                                            try
                                                            {
                                                                BufferedWriter b = new BufferedWriter(new FileWriter("Bin/Data/Surveys/"+tname+surcode+".ravs"));
                                                                b.close();
                                                            }catch(Exception sdsdf){}
                                                            glassPane.stop();
                                                            JOptionPane.showMessageDialog(null,"Survey Sent","Confirmation",JOptionPane.INFORMATION_MESSAGE);
                                                        }
                                                        else
                                                        {
                                                            glassPane.stop();
                                                            JOptionPane.showMessageDialog(null,"Notice Sent","Confirmation",JOptionPane.INFORMATION_MESSAGE);
                                                        }
                                                    }
                                                }
                                            }
        
        jTextArea1.setText("");
        jCheckBox1.setSelected(false);
                                                        jCheckBox2.setSelected(false);
                                                        jCheckBox3.setSelected(false);
                                                        jCheckBox4.setSelected(false);
                                                        jCheckBox5.setSelected(false);

                                                        jCheckBox1.setEnabled(true);
                                                        jCheckBox2.setEnabled(true);
                                                        jCheckBox3.setEnabled(true);
                                                        jCheckBox4.setEnabled(true);
                                                        jRadioButton1.setSelected(false);
                                                        jRadioButton2.setSelected(false);
                                                        jRadioButton3.setSelected(false);
                                                        jRadioButton4.setSelected(false);
                                                        jRadioButton5.setSelected(false);
                                                        jRadioButton6.setSelected(false);
                                                        jRadioButton7.setSelected(false);
                                                        jRadioButton8.setSelected(false);
                                                        jRadioButton1.setEnabled(true);
                                                        jRadioButton2.setEnabled(true);
                                                        jRadioButton3.setEnabled(true);
                                                        jRadioButton4.setEnabled(true);
                                                        jRadioButton5.setEnabled(true);
                                                        jRadioButton6.setEnabled(true);
                                                        jRadioButton7.setEnabled(true);
                                                        jRadioButton8.setEnabled(true);
                                                        jRadioButton9.setSelected(false);
                                                        dispose();
                                                        new MessengerPage(tname).setVisible(true);
    }
}
