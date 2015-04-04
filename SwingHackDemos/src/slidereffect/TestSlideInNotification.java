
package slidereffect;

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
     String d[];
     int count;
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
         d=new String[a1.length];
         for(int i=0;i<a1.length;i++)
         {
             a[i]=a1[i][0];
             b[i]=a1[i][1];
             c[i]=a1[i][2];
             d[i]=a1[i][3];
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

         int i=1;
         try
         {
             for(int i1=1;i1<count;i1++)
             {
                thread.sleep(5000);
                jLabel1.setText(c[i1]);
                jLabel2.setText("<HTML>"+a[i1]+"<BR>"+b[i1]+"<BR>"+d[i1]+"<HTML>");
                jLabel4.setText(""+(i1+1)+"/"+count);
             }
             thread.sleep(5000);
             System.exit(0);
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
         jLabel2.setText("<HTML>"+a[0]+"<BR>"+b[0]+"<BR>"+d[0]+"<HTML>");
         jLabel4.setText(""+(0+1)+"/"+count);
    }
}

     public static void main(String er[])
    {
         String p[][]=new String[5][4];
         p[0][0]="First Subject";
         p[0][1]="From : abc";
         p[0][2]="To: xyz";
         p[0][3]="20/07/2010";
         p[1][0]="Second Subject";
         p[1][1]="From : def";
         p[1][2]="To: xyz";
         p[1][3]="21/07/2010";
         p[2][0]="Third Subject";
         p[2][1]="From : ghi";
         p[2][2]="To: xyz";
         p[2][3]="22/07/2010";
         p[3][0]="Fourth Subject";
         p[3][1]="From : jkl";
         p[3][2]="To: xyz";
         p[3][3]="23/07/2010";
         p[4][0]="Fifth Subject";
         p[4][1]="From : mno";
         p[4][2]="To: xyz";
         p[4][3]="24/07/2010";
         new TestSlideInNotification(p);
     }

}
