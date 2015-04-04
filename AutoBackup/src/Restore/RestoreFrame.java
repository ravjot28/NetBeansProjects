package Restore;

import BackSupport.OS;
import BackupProcesses.Decrypt;
import Interfaces.BackgroundApplicationVariables;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class RestoreFrame extends JFrame implements BackgroundApplicationVariables
{
    private JButton browsedir1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JTextField jTextField2;

    static String FileSeprator;

    private void setFileSeprator()      //Selects the File Seprator for the current OS of the user. "\" for Windows and "/" for Mac or Linux or Unix
    {
        OS os = new OS();

        String osName = os.getOS();

        if(osName.equalsIgnoreCase("win"))
            FileSeprator = "\\";
        else
            if(osName.equalsIgnoreCase("mac") || osName.equalsIgnoreCase("linux"))
                FileSeprator = "/";

    }
    
    public RestoreFrame()
    {
        setFileSeprator();
        initComponents();
    }

    private void initComponents()
    {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        browsedir1 = new JButton();
        jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jButton2 = new JButton();
        jButton3 = new JButton();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setTitle("Restore Backup");

        setIconImage(new ImageIcon("AutoBackup\\Files\\Pics\\The-Backup.icon.png").getImage());

        jPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jLabel1.setFont(new Font("Tahoma", 1, 18));
        jLabel1.setText("Restore Backup");

        jLabel2.setFont(new Font("Times New Roman", 0, 14));
        jLabel2.setText("Select the Pen Drive/External Hard Disk Containing rbackup");

        jTextField1.setEditable(false);

        browsedir1.setText("Browse");
        browsedir1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent evt)
                                        {
                                            jButton1ActionPerformed(evt);
                                        }
                                    });

        jLabel3.setText("Select the Location where you want to restore the Backup");

        jTextField2.setEditable(false);

        jButton2.setText("Browse");
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent evt)
                                        {
                                            jButton2ActionPerformed(evt);
                                        }
                                    });

        jButton3.setText("Begin");

        jButton3.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            if(!jTextField1.getText().trim().equalsIgnoreCase(""))
                                            {
                                                if(!jTextField2.getText().trim().equalsIgnoreCase(""))
                                                {
                                                    String fname = jTextField1.getText().trim()+"Backup.rbackup";
                                                    System.out.println(fname);
                                                    Decrypt d = new Decrypt(fname);
                                                    d.process(jTextField2.getText().trim());

                                                        JOptionPane.showMessageDialog(null, "Backup.zip is stored at "+jTextField2.getText().trim()+"Backup.zip", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                    
                                                    /*File f = new File("Bin"+FileSeprator+"Temp"+FileSeprator);
                                                    String files[] = f.list();

                                                    for(String fn:files)
                                                    {
                                                        System.out.println(new File(fn).getAbsoluteFile());
                                                        Decompress dc1 = new Decompress();
                                                        dc1.decompress(new File(fn).getAbsolutePath());
                                                    }*/
                                                    //copy the folder at the user's dir
                                                }
                                                else
                                                {
                                                    JOptionPane.showMessageDialog(null, "Oops!! Please Select the destination Directory.", "Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(null, "Oops!! Please Select the source Directory.", "Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(browsedir1))
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton3)
                                .addComponent(jLabel2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(browsedir1))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void jButton2ActionPerformed(ActionEvent evt)
    {
        SelectDir sd = new SelectDir();

        File f = sd.process();
        
        if(f!=null)
        {
            jTextField2.setText(f.getAbsolutePath());
        }
    }

    private void jButton1ActionPerformed(ActionEvent evt)
    {
        SelectDir sd = new SelectDir();

        File f = sd.process();

        if(f!=null)
        {
            try
            {
                String data = new BufferedReader(new FileReader(f.getAbsoluteFile() + markFileName)).readLine();
                if(new File(f.getAbsoluteFile()+data.trim()).exists())
                {
                    jTextField1.setText(f.getAbsolutePath());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Oops!! Cannot find the backup in the external disk", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception as)
            {
                JOptionPane.showMessageDialog(null, "Oops!! Cannot find the backup in the external disk", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

