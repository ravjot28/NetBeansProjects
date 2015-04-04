import java.awt.Toolkit;

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
         /*JFrame slider = new JFrame("Hi");
         slider.add(new notification());
         slider.pack();
         slider.setVisible(true);*/
         for(int i=0;i<a.length;i++)
         {
            System.out.println(a[i]+"\n"+b[i]+"\n"+c[i]+"\n"+d[i]);
         }
        /* try
         {
             while(i<count)
             {
                thread.sleep(5000);
                jLabel2.setText(c[i]);
                jLabel3.setText("<HTML>"+a[i]+"<BR>"+b[i]+"<BR>"+d[i]+"<HTML>");
                jLabel4.setText(""+(i+1)+"/"+count);
                i++;
             }
             thread.sleep(5000);
             //slider.dispose();
         }catch(Exception asd){System.out.println(asd);}*/
     }

   class notification extends javax.swing.JPanel
{

    /** Creates new form Notification */
    public notification()
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

}


}
