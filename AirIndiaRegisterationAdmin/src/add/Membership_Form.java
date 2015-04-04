package add;

import java.util.Calendar;
import java.util.GregorianCalendar;
import support.DateChooser;
import RavCustomizedProgressBar.InfiniteProgressPanel;
import customizedtextfields.IntegerField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import process.GetEmpID;
import support.CheckInternetConnection;

public class Membership_Form extends javax.swing.JFrame implements Runnable
{
    String imageURL = ("img/rav.gif");
    String imageURL1 = ("img/logo.png");
    String imageURL2 = ("img/calendar.png");
    
    private javax.swing.JTextArea Address;
    private javax.swing.JTextField City;
    private javax.swing.JTextField EmailId;
    private javax.swing.JTextField FullName;
    private javax.swing.JTextField LandlineNo;
    private javax.swing.JTextField MobileNo;
    private javax.swing.JTextField PinCode;
    private javax.swing.JTextField Staffno;
    private javax.swing.JTextField State;
    private javax.swing.JTextField TeleCode;
    private javax.swing.JTextField PinCode1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private InfiniteProgressPanel ipp;

    Thread th;

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d;
    

    public Membership_Form()
    {
        d = tk.getScreenSize();
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        FullName = new javax.swing.JTextField();
        Staffno = new IntegerField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Address = new javax.swing.JTextArea();
        City = new javax.swing.JTextField();
        State = new javax.swing.JTextField();
        PinCode = new IntegerField();
        TeleCode = new IntegerField();
        LandlineNo = new IntegerField();
        MobileNo = new IntegerField();
        EmailId = new javax.swing.JTextField();
        PinCode1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();

        ipp = new InfiniteProgressPanel("Please Wait.Verfying Data.....");

        setResizable(false);

        setGlassPane(ipp);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setIconImage(new ImageIcon(imageURL).getImage());
        setTitle("BSAEIA Membership Form");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Membership Form");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("Benevolent Society For Aircraft Engineers Of Indian Airlines (Regd.)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setText("Regn. No. 54832 of 2006 dated: 7th February,2006");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel4.setText("C-401, Plot No. 9, Sector-12, Dwarka, New Delhi - 110078");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel5.setText("Telephone No.: 011-28083160, 25672740");

        jLabel6.setText("To");

        jLabel7.setText("The General Secretary");

        jLabel9.setText("BSAEIA (Regd.)");

        jLabel8.setText("Delhi");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setText("Full Name");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel11.setText("Staff No.");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel12.setText("Address");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel13.setText("City");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel14.setText("State");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel15.setText("Pin Code");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel16.setText("Telephone No.");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel17.setText("Mobile No.");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel18.setText("Email ID");

        jButton1.setText("Cancel");
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            JOptionPane.showMessageDialog(null,"Thank You","Thanks",JOptionPane.INFORMATION_MESSAGE);
                                            dispose();
                                        }
                                    });

        jButton2.setText("Submit");
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            if(!FullName.getText().trim().equals(""))
                                            {
                                                if(!Staffno.getText().trim().equals(""))
                                                {
                                                    if(!Address.getText().trim().equals(""))
                                                    {
                                                        if(!City.getText().trim().equals(""))
                                                        {
                                                            if(!State.getText().trim().equals(""))
                                                            {
                                                                if(!PinCode.getText().trim().equals(""))
                                                                {
                                                                    if(!TeleCode.getText().trim().equals(""))
                                                                    {
                                                                        if(!LandlineNo.getText().trim().equals(""))
                                                                        {
                                                                            if(!MobileNo.getText().trim().equals(""))
                                                                            {
                                                                                if(!EmailId.getText().trim().equals(""))
                                                                                {
                                                                                    if(!PinCode1.getText().trim().equals(""))
                                                                                    {
                                                                                        String dob = PinCode1.getText().trim();
                                                                                        StringTokenizer s = new StringTokenizer(dob,"/");
                                                                                        int date = Integer.parseInt(s.nextToken());
                                                                                        int month = Integer.parseInt(s.nextToken())-1;
                                                                                        int year = Integer.parseInt(s.nextToken());

                                                                                        int age = age(year,month,date);

                                                                                        if(age<58 && age>=20)
                                                                                        {
                                                                                            if(new CheckInternetConnection().process())
                                                                                                process();
                                                                                            else
                                                                                                JOptionPane.showMessageDialog(null,"Oops!! No Internet. Please Check Your Net Connection", null, WIDTH);
                                                                                        }
                                                                                        else
                                                                                        {
                                                                                            JOptionPane.showMessageDialog(null,"Oops!! Invalid Age", null, WIDTH);
                                                                                        }
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Date Of Birth Field", null, WIDTH);
                                                                                    }
                                                                                }
                                                                                else
                                                                                {
                                                                                    JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Email ID Field", null, WIDTH);
                                                                                }
                                                                            }
                                                                            else
                                                                            {
                                                                                JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Mobile Number Field", null, WIDTH);
                                                                            }
                                                                        }
                                                                        else
                                                                        {
                                                                            JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Telephone Field", null, WIDTH);
                                                                        }
                                                                    }
                                                                    else
                                                                    {
                                                                        JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Telephone Code Field", null, WIDTH);
                                                                    }
                                                                }
                                                                else
                                                                {
                                                                    JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Pin Code Field", null, WIDTH);
                                                                }
                                                            }
                                                            else
                                                            {
                                                                JOptionPane.showMessageDialog(null,"Oops!! Please Enter the State Field", null, WIDTH);
                                                            }
                                                        }
                                                        else
                                                        {
                                                            JOptionPane.showMessageDialog(null,"Oops!! Please Enter the City Field", null, WIDTH);
                                                        }
                                                    }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Address Field", null, WIDTH);
                                                    }
                                                }
                                                else
                                                {
                                                    JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Staff No. Field", null, WIDTH);
                                                }
                                            }
                                            else
                                            {   
                                                JOptionPane.showMessageDialog(null,"Oops!! Please Enter the Full Name Field", null, WIDTH);
                                            }
                                        }
                                    });

        FullName.setFont(new java.awt.Font("Monospaced", 0, 12));

        Staffno.setFont(new java.awt.Font("Monospaced", 0, 12));

        Address.setColumns(20);
        Address.setFont(new java.awt.Font("Monospaced", 0, 12));
        Address.setLineWrap(true);
        Address.setRows(2);
        Address.setWrapStyleWord(true);
        jScrollPane1.setViewportView(Address);

        City.setFont(new java.awt.Font("Monospaced", 0, 12));

        State.setFont(new java.awt.Font("Monospaced", 0, 12));

        PinCode.setFont(new java.awt.Font("Monospaced", 0, 12));

        TeleCode.setColumns(3);
        TeleCode.setFont(new java.awt.Font("Monospaced", 0, 12));

        LandlineNo.setColumns(8);
        LandlineNo.setFont(new java.awt.Font("Monospaced", 0, 12));

        MobileNo.setColumns(10);
        MobileNo.setFont(new java.awt.Font("Monospaced", 0, 12));

        EmailId.setFont(new java.awt.Font("Monospaced", 0, 12));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("*");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("*");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("*");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("*");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("*");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("*");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("*");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("*");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("*");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel28.setText("-");

        jLabel29.setIcon(new javax.swing.ImageIcon(imageURL1)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel30.setText("R Softs.");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel31.setText("Date Of Birth");

        PinCode1.setFont(new java.awt.Font("Monospaced", 0, 11));
        PinCode1.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("*");


        jButton3.setIcon(new javax.swing.ImageIcon(imageURL2)); // NOI18N
        jButton3.setToolTipText("Select DOB");

        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);

        jButton3.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            dob();
                                        }
                                    });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(222, 222, 222)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel10)
                .addGap(29, 29, 29)
                .addComponent(FullName, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel19))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(36, 36, 36)
                .addComponent(Staffno, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel20))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel12)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel21))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addGap(61, 61, 61)
                .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel22))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel14)
                .addGap(52, 52, 52)
                .addComponent(State, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel23))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel17)
                .addGap(26, 26, 26)
                .addComponent(MobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel26))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addGap(37, 37, 37)
                .addComponent(EmailId, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel27))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton2)
                .addGap(128, 128, 128)
                .addComponent(jLabel30)
                .addGap(134, 134, 134)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(jLabel1)
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel3)
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel4)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel5)
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(35, 35, 35)
                        .addComponent(PinCode, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PinCode1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(4, 4, 4)
                        .addComponent(TeleCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel28)
                        .addGap(4, 4, 4)
                        .addComponent(LandlineNo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel25))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel9))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10))
                    .addComponent(FullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel19)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel11))
                    .addComponent(Staffno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel20)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel22)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel14))
                    .addComponent(State, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel15))
                    .addComponent(PinCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jLabel31)
                        .addComponent(PinCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel16))
                    .addComponent(TeleCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel28))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LandlineNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel17))
                    .addComponent(MobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18))
                    .addComponent(EmailId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addComponent(jLabel30))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();

        int frame_x = getSize().height;
        int frame_y = getSize().width;
        

        setLocation((d.width - frame_y)/2,(d.height - frame_x)/2);
    }
    
    public void run()
    {
        ipp.start();

        final String information[] = new String[10];
        information[0] = this.FullName.getText().trim();
        information[1] = this.Staffno.getText().trim();
        information[2] = this.Address.getText().trim();
        information[3] = this.City.getText().trim();
        information[4] = this.State.getText().trim();
        information[5] = this.PinCode.getText().trim();
        information[6] = this.TeleCode.getText().trim() +"-"+ this.LandlineNo.getText().trim();
        information[7] = this.MobileNo.getText().trim();
        information[8] = this.EmailId.getText().trim();
        information[9] = this.PinCode1.getText().trim();

        GetEmpID ge = new GetEmpID();

        String d[] = ge.process();

        if(d == null)
        {
            ipp.stop();

            dispose();
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                public void run()
                {
                    new Agreement_Form(information).setVisible(true);
                }
            });
        }
        else
        {
           if(check(d))
           {
               ipp.stop();
               dispose();
               java.awt.EventQueue.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new Agreement_Form(information).setVisible(true);
                    }
                });
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Oops!! Staff No."+Staffno.getText().trim()+" already registered", null, WIDTH);
               ipp.stop();
           }
        }
    }
 
   private static int age(int y, int m, int d)
    {

        Calendar cal = new GregorianCalendar(y, m, d);

        Calendar now = new GregorianCalendar();

        int res = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);

        if((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))

                || (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH)

                && cal.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH)))

        {

            res--;

        }
     return res;
   }

    public void dob()
    {
        GregorianCalendar date = new GregorianCalendar();
        DateChooser dc = new DateChooser(this, date);

        if (dc.showDateChooser() == DateChooser.OK_OPTION)
        {
            date = dc.getDate();

            int year = date.get(Calendar.YEAR);
            int month = date.get(Calendar.MONTH)+1;
            int date1 = date.get(Calendar.DATE);
            PinCode1.setText(date1+"/"+month+"/"+year);
        }
    }

    public void process()
    {
        th = new Thread(this);
        th.start();
    }

    public boolean check(String[] d)
    {
        StringTokenizer s = new StringTokenizer(d[0],",");
        while(s.hasMoreTokens())
        {
            if(Staffno.getText().trim().equals(s.nextToken().trim()))
            {
                return false;
            }
        }
        return true;
    }
}