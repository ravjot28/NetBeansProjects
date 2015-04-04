import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestSlideInNotification
{
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    Toolkit tk = Toolkit.getDefaultToolkit();
    int w=(int) tk.getScreenSize().getWidth();
    int h=(int) tk.getScreenSize().getHeight();
     String a[];
     String b[];
     String c[];
     int count;
     static int i=1;
    Thread thread;

    /* public static void main (String[] args)
     {
         new TestSlideInNotification();
         
     }*/
     TestSlideInNotification(String[][] a1)
    {
         a=new String[a1.length];
         b=new String[a1.length];
         c=new String[a1.length];
         for(int i=0;i<a1.length;i++)
         {
             a[i]=a1[i][0];
             b[i]=a1[i][1];
             c[i]=a1[i][2];
         }
         count=a1.length;
         thread=new Thread();
         //Icon errorIcon = UIManager.getIcon ("OptionPane.informationIcon");
         //ImageIcon errorIcon=new ImageIcon("D:\\My World\\My Elements\\Programming\\JAVA\\Projects\\Air India Project\\Air India\\Pay Roll\\Bin\\img\\r.gif");
         //JLabel label = new JLabel ("<HTML>Your application asplode <BR><BR><BR>asdfadfadf<BR><BR><BR></HTML>", errorIcon,
           //                         SwingConstants.LEFT);
         //SlideInNotification slider = new SlideInNotification (label);
         SlideInNotification slider = new SlideInNotification (new notification());
         slider.showAt (h/2);
         try
         {
             while(i<count)
             {
                thread.sleep(5000);
                System.out.println(c[i]+"\n"+a[i]+"\n"+b[i]+"\n");
                jLabel2.setText(c[i]);
                jLabel3.setText("<HTML>"+a[i]+"<BR>"+b[i]+"<BR>"+"<HTML>");
                jLabel4.setText(""+(i+1)+"/"+count);
                i++;
             }
             thread.sleep(5000);
             slider.closing();
         }catch(Exception asd){System.out.println(asd);}
     }

     class notification extends javax.swing.JPanel
{


    public notification() {
        initComponents();
    }

    private void initComponents() {

       jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("mini_cal_icon_left_arrow.png")); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("mini_cal_icon_right_arrow.png")); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);

        jLabel2.setText("jLabel2");

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("close_red_10.gif")); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setMaximumSize(new java.awt.Dimension(10, 10));
        jButton3.setMinimumSize(new java.awt.Dimension(10, 10));
        jButton3.setPreferredSize(new java.awt.Dimension(10, 10));
        jButton3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){System.exit(0);}});

        jLabel3.setIcon(new javax.swing.ImageIcon("MailIcon.png")); // NOI18N

        jLabel4.setText("jLabel4");

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addContainerGap(288, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel2)
                .addContainerGap(233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(141, Short.MAX_VALUE))))
        );
         jLabel1.setText(c[0]);
         jLabel2.setText("<HTML>"+a[0]+"<BR>"+b[0]+"<BR>"+"<HTML>");
         jLabel4.setText(""+(0+1)+"/"+count);
    }
}


     /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*class notification extends javax.swing.JPanel
{

    /** Creates new form Notification */
/*    public notification()
    {
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("Mail");

        jLabel2.setText("From:");

        jLabel3.setText("Time:");

        jLabel4.setText("Subject:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addContainerGap(69, Short.MAX_VALUE))
        );

         jLabel2.setText(c[0]);
         jLabel3.setText("<HTML>"+a[0]+"<BR>"+b[0]+"<BR>"+d[0]+"<HTML>");
         jLabel4.setText(""+(0+1)+"/"+count);
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;

}*/


}
