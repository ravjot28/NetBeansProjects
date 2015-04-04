
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;

public class Main extends javax.swing.JFrame implements Runnable
{
    Thread th = new Thread(this);
    String news;
    String events;
    InfiniteProgressPanel glassPane;

    boolean newss = false;

    boolean eventss = true;

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();

    public void look()
    {
         try
         {
             UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
         }catch(Exception e){}
    }

    public Main()
    {
        look();
        initComponents();
    }

    public void run()
    {
        glassPane.start();
        GetNewsNEvents g = new GetNewsNEvents();
        String n[] = g.getNews();
        String e[] = g.getEvents();
        news = "              News\n\n";
        for(int i=0;i<n.length;i++)
        {
            news+=(i+1)+". "+n[i]+"\n\n";
        }

        events = "              Events\n\n";
        for(int i=0;i<n.length;i++)
        {
            events+=(i+1)+". "+e[i]+"\n\n";
        }
        jTextArea1.setText(events);
        eventss = true;
        jScrollPane1.repaint();
        glassPane.stop();
    }

    private void initComponents()
    {
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        glassPane = new InfiniteProgressPanel("Connecting gtbit.org Please Wait...");

        setTitle("GTBIT RSS Feed");

        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\rssicon.png"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setGlassPane(glassPane);

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Palatino Linotype", 1, 14));
        jButton1.setText("Events");
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ar)
                                        {
                                            if(eventss)
                                            {

                                            }
                                            else
                                            {
                                                jTextArea1.setText(events);
                                                jScrollPane1.repaint();
                                                newss = false;
                                                eventss = true;
                                            }
                                        }
                                    });

        jButton2.setFont(new java.awt.Font("Palatino Linotype", 1, 14));
        jButton2.setText("News");
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ar)
                                        {
                                            if(newss)
                                            {

                                            }
                                            else
                                            {
                                                jTextArea1.setText(news);
                                                jScrollPane1.repaint();
                                                newss = true;
                                                eventss = false;
                                            }
                                        }
                                    });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setResizable(false);

        pack();
        int w = getSize().width;

        int h = getSize().height;

        int x = (d.width-w)/2;

        int y = (d.height-h)/2;

        setLocation(x, y);
        th.start();
    }

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Main().setVisible(true);
                
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
}
