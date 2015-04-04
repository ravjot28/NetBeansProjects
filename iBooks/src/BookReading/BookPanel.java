package BookReading;


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.GroupLayout;

public class BookPanel extends javax.swing.JFrame
{
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();
    String fpath;
    public BookPanel(String s)
    {
        fpath=s;
        initComponents();
    }
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new JBookPanel(fpath,d.height,d.width);

        setUndecorated(true);

        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton1.setFocusable(false);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
                .addComponent(jButton1,GroupLayout.PREFERRED_SIZE, 23,GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 20,GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0,0,d.width,d.height);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {
        System.exit(0);
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
}