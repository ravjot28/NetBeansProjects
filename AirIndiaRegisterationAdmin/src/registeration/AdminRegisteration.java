package registeration;

import RavCustomizedProgressBar.InfiniteProgressPanel;
import customizedtextfields.IntegerField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import process.GetAdmin;
import sendnrecievedata.SendAdminRequest;
import support.CheckInternetConnection;
import support.DateChooser;

public class AdminRegisteration extends javax.swing.JFrame implements Runnable
{
    Thread th;
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();

    private javax.swing.JTextField DOB;
    private javax.swing.JTextField FullName;
    private javax.swing.JTextField StaffNo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    InfiniteProgressPanel ipp;
    
    public AdminRegisteration()
    {
        initComponents();
    }

    private void initComponents()
    {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FullName = new javax.swing.JTextField();
        StaffNo = new IntegerField();
        DOB = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ipp = new InfiniteProgressPanel("Checking Admin List.Please Wait.....");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BSAEIA Admin Registeration");
        setResizable(false);

        setIconImage(new ImageIcon("img"+System.getProperty("file.separator")+"rav.gif").getImage());

        setGlassPane(ipp);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BSAEIA Admin Registeration");

        jLabel2.setText("Staff No.");

        jLabel3.setText("Email ID");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("img"+System.getProperty("file.separator")+"logo.png")); // NOI18N

        jLabel5.setText("Date Of Birth");

        DOB.setEditable(false);

        jButton1.setIcon(new javax.swing.ImageIcon("img"+System.getProperty("file.separator")+"calendar.png")); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            dob();
                                        }
                                    });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(StaffNo)
                                .addComponent(FullName, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(FullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(StaffNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, 0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(DOB)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jButton2.setText("Submit");
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            if(!FullName.getText().trim().equals(""))
                                            {
                                                if(!StaffNo.getText().trim().equals(""))
                                                {
                                                    if(!DOB.getText().trim().equals(""))
                                                    {
                                                        String dob = DOB.getText().trim();
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
                                                                JOptionPane.showMessageDialog(null,"Oops!! No Internet. Please Check Your Net Connection", "Error",JOptionPane.ERROR_MESSAGE);
                                                        }
                                                        else
                                                        {
                                                            JOptionPane.showMessageDialog(null,"Oops!! Invalid Age", "Error",JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    }
                                                    else
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Oops!! Please Enter Date Of Birth Field","Error",JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                                else
                                                {
                                                    JOptionPane.showMessageDialog(null,"Oops!! Please Enter Staff No. Field","Error",JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(null,"Oops!! Please Enter Email ID Field","Error",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            dispose();
                                        }
                                    });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(11, 11, 11))
        );

        pack();

        int frame_x = getSize().height;
        int frame_y = getSize().width;


        setLocation((d.width - frame_y)/2,(d.height - frame_x)/2);
    }

    public void process()
    {
        th = new Thread(this);
        th.start();
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
            DOB.setText(date1+"/"+month+"/"+year);
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

    public boolean check_admin(String[] s)
    {
        for(String temp:s)
            if(temp.trim().equals(StaffNo.getText().trim()))
                return false;
        return true;
    }

    public void run()
    {
        ipp.start();
        String admin_list[] = new GetAdmin().process();
        if(admin_list == null)
        {
            ipp.setText("Please Wait.Sending Your Request....");
            ipp.revalidate();
            ipp.repaint();
            String subject = StaffNo.getText().trim();
            String body = FullName.getText().trim()+"$$$"+DOB.getText().trim();
            SendAdminRequest sar = new SendAdminRequest(subject,body);

            if(sar.process())
            {
                try
                {
                    BufferedWriter b = new BufferedWriter(new FileWriter(System.getProperty("user.home")+System.getProperty("file.separator")+"RavSoftsData"+System.getProperty("file.separator")+"Admin.admin"));
                    b.append(subject);
                    b.close();
                    JOptionPane.showMessageDialog(null,"Request Sent. Now, BSAEIA will process your request","Success",JOptionPane.INFORMATION_MESSAGE);
                }catch(Exception as)
                {
                    JOptionPane.showMessageDialog(null,"Oops!! Cannot Process the request.", "Error",JOptionPane.ERROR_MESSAGE);
                }
                ipp.stop();
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Oops!! No Internet. Please Check Your Net Connection", "Error",JOptionPane.ERROR_MESSAGE);
                ipp.stop();
                dispose();
            }
        }
        else
        {
            StringTokenizer s1 = new StringTokenizer(admin_list[0],",");
            System.out.println(admin_list[0]);
            if(s1.countTokens()<5)
            {
                String admin[] = new String[s1.countTokens()];
                int i=0;
                while(s1.hasMoreTokens())
                {
                    admin[i] = s1.nextToken();
                    i++;
                }


                if(check_admin(admin))
                {
                    ipp.setText("Please Wait.Sending Your Request....");
                    ipp.revalidate();
                    ipp.repaint();

                    String subject = StaffNo.getText().trim();
                    String body = FullName.getText().trim()+"$$$"+DOB.getText().trim();

                    SendAdminRequest sar = new SendAdminRequest(subject,body);

                    if(sar.process())
                    {
                        try
                        {
                            BufferedWriter b = new BufferedWriter(new FileWriter(System.getProperty("user.home")+System.getProperty("file.separator")+"RavSoftsData"+System.getProperty("file.separator")+"Admin.admin"));
                            b.append(subject);
                            b.close();
                            JOptionPane.showMessageDialog(null,"Request Sent. Now, BSAEIA will process your request","Success",JOptionPane.INFORMATION_MESSAGE);
                        }catch(Exception as)
                        {
                            JOptionPane.showMessageDialog(null,"Oops!! Cannot Process the request.", "Error",JOptionPane.ERROR_MESSAGE);
                        }
                        ipp.stop();
                        dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Oops!! No Internet. Please Check Your Net Connection", "Error",JOptionPane.ERROR_MESSAGE);
                        ipp.stop();
                        dispose();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Oops!! This staff No is already Admin. Thank You","Error",JOptionPane.ERROR_MESSAGE);
                    ipp.stop();
                    dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Oops!! There is no requirement for Admin. Thank You","Error",JOptionPane.ERROR_MESSAGE);
                ipp.stop();
                dispose();
            }
        }
    }
}
