package GuiTest;

import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.swing.GroupLayout;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;


public class GUI extends javax.swing.JFrame {

    String absolutePathOfFile ="";
    String absolutePathOfFile1 ="";
    
    public GUI() {
        initComponents();
    }


    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(getTimeZones()));

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(5, 28, 400, 35);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"-Select-", "Mediagateway", "MSS"}));
        jComboBox2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                check(e);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(0, 110, 150, 27);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 110, 436, 260);

        jLabel1.setText("Select Time Zone of Target Country (Location Of Node)");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(8, 9, 383, 20);

        jLabel2.setText("Copy the Commands below and run in appropriate Node");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 90, 353, 16);

        jLabel4.setText("Select Node Type");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 90, 123, 16);
        jButton2.setIcon(new javax.swing.ImageIcon("Excel.gif"));
        jButton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                Object o[] = jComboBox2.getSelectedObjects();
                String selected = o[0].toString();

                if (selected.equalsIgnoreCase("Mediagateway")) {
                    //load mediagateway class
                    new_mgw nm = new new_mgw();
                    try {
                        nm.processSteps(absolutePathOfFile);
                    } catch (WriteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (BiffException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else if (selected.equalsIgnoreCase("MSS")) {
                    apg_new a = new apg_new();
                    try {
                        a.processSteps(absolutePathOfFile,absolutePathOfFile1);
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE).addContainerGap(19, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(62, 62, 62).addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE).addContainerGap(183, Short.MAX_VALUE)));



        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 150, 140, 340);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField5.setText("Input log file");

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // jButton1ActionPerformed(evt);
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Open file");

                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    jTextField5.setText(file.getName());
                    absolutePathOfFile = file.getAbsolutePath();
                }

                Object o[] = jComboBox2.getSelectedObjects();
                String selected = o[0].toString();

                if (selected.equalsIgnoreCase("Mediagateway")) {
                    if(absolutePathOfFile.trim().equals("")){
                        jButton2.setEnabled(true);
                    }
                    else{
                        jButton2.setEnabled(false);
                    }
                }else if (selected.equalsIgnoreCase("MSS")) {
                    if(absolutePathOfFile.trim().equals("") && absolutePathOfFile1.trim().equals("")){
                        jButton2.setEnabled(true);
                    }
                    else{
                        jButton2.setEnabled(false);
                    }
                }
            }
        });

        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // jButton1ActionPerformed(evt);
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Open file");

                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    jTextField1.setText(file.getName());
                    absolutePathOfFile1 = file.getAbsolutePath();
                }

                 Object o[] = jComboBox2.getSelectedObjects();
                String selected = o[0].toString();

                if (selected.equalsIgnoreCase("Mediagateway")) {
                    if(absolutePathOfFile.trim().equals("")){
                        jButton2.setEnabled(true);
                    }
                    else{
                        jButton2.setEnabled(false);
                    }
                }else if (selected.equalsIgnoreCase("MSS")) {
                    if(absolutePathOfFile.trim().equals("") && absolutePathOfFile1.trim().equals("")){
                        jButton2.setEnabled(true);
                    }
                    else{
                        jButton2.setEnabled(false);
                    }
                }

            }
        });
        jTextField1.setText("Input ALAN file");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(jTextField1).addComponent(jTextField5, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jButton3).addComponent(jButton1)).addContainerGap(22, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(jButton1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jButton3).addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(220, 390, 440, 100);

        jMenu1.setText("Menu");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("About");
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Feedback");
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        setSize(800, 600);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    public void check(ActionEvent ie) {
        Object s[] = ((ItemSelectable) ie.getSource()).getSelectedObjects();


        if (s[0].toString().equalsIgnoreCase("Mediagateway")) {
            jTextArea1.setText("A");
            jButton3.setEnabled(false);
            jPanel2.repaint();
            jPanel2.revalidate();

            jPanel1.repaint();
            jPanel1.revalidate();
        } else if (s[0].toString().equalsIgnoreCase("MSS")) {
            jTextArea1.setText("B");
            jButton3.setEnabled(true);
            jPanel2.repaint();
            jPanel2.revalidate();

            jButton3.repaint();
            jButton3.revalidate();

        } else {
            jTextArea1.setText("");
            jButton3.setEnabled(true);
            jPanel1.repaint();
            jPanel1.revalidate();

            jPanel2.repaint();
            jPanel2.revalidate();
        }
    }

    public Object[] getTimeZones() {
        List<String> timezones = new ArrayList<String>();
        Date date = new Date();
        String TimeZoneIds[] = TimeZone.getAvailableIDs();
        for (int i = 0; i < TimeZoneIds.length; i++) {
            TimeZone tz = TimeZone.getTimeZone(TimeZoneIds[i]);
            String tzName = tz.getDisplayName(tz.inDaylightTime(date), TimeZone.LONG);
            int rawOffset = tz.getRawOffset();
            int hour = rawOffset / (60 * 60 * 1000);
            int minute = Math.abs(rawOffset / (60 * 1000)) % 60;
            timezones.add(tzName + " " + hour + ":" + minute);
        }

        return timezones.toArray();
    }
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration
}
