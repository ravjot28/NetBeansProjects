import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpeningPage extends javax.swing.JFrame
{
    JButton Morning;
    JButton Evening;
    JButton Night;
    JButton Language;
    JLabel jLabel1;
    JPanel jPanel1;

    static boolean gurmukhi;
    static boolean english;

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();
    
    public OpeningPage(String l)
    {
        super("iNitnem");
        if(l.equalsIgnoreCase("gurmukhi"))
        {
            gurmukhi = true;
            english = false;
        }
        else
        {
            english=true;
            gurmukhi=false;
        }
        initComponents();
    }

    private void initComponents()
    {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Morning = new javax.swing.JButton();
        Evening = new javax.swing.JButton();
        Night = new javax.swing.JButton();
        Language = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\icon.jpg"));

        jPanel1.setLayout(null);
        if(gurmukhi)
        {
            jLabel1.setIcon(new javax.swing.ImageIcon("Bin\\img\\Opening.jpg"));
        }
        else
        {
            jLabel1.setIcon(new javax.swing.ImageIcon("Bin\\img\\OpeningE.jpg"));
        }
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 320, 420);

        Morning.setIcon(new javax.swing.ImageIcon("Bin\\img\\Morning.jpg"));
        Morning.setBorderPainted(false);
        Morning.setContentAreaFilled(false);
        Morning.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            Morning();
                                        }
                                    });

        Evening.setIcon(new javax.swing.ImageIcon("Bin\\img\\Evening.jpg"));
        Evening.setBorderPainted(false);
        Evening.setContentAreaFilled(false);
        Evening.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            Evening();
                                        }
                                    });

        Night.setIcon(new javax.swing.ImageIcon("Bin\\img\\Night.jpg"));
        Night.setBorderPainted(false);
        Night.setContentAreaFilled(false);
        Night.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            Night();
                                        }
                                    });

        Language.setIcon(new javax.swing.ImageIcon("Bin\\img\\Language.jpg"));
        Language.setBorderPainted(false);
        Language.setContentAreaFilled(false);
        Language.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            Language();
                                        }
                                    });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Morning, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Evening, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Night, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Language, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Morning, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Evening, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Night, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Language, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setResizable(false);

        setLocation(d.height/2,d.width/9);

        pack();
    }

    public void Morning()
    {
        dispose();
        new Banis().setVisible(true);
    }

    public void Evening()
    {

        dispose();
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                if(gurmukhi)
                {
                    //new Main("NitnemDatabase\\NitnemPunjabi\\r\\");
                }
                else
                {
                    //new Main("NitnemDatabase\\NitnemHindiEnglish\\r\\");
                }
            }
        });
    }

    public void Night()
    {
        dispose();
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                if(gurmukhi)
                {
                    //new Main("NitnemDatabase\\NitnemPunjabi\\s\\");
                }
                else
                {
                    //new Main("NitnemDatabase\\NitnemHindiEnglish\\s\\");
                }
            }
        });
    }

    public void Language()
    {
        if(gurmukhi)
        {
            new LangSetting(0).setVisible(true);
        }
        else
            if(english)
            {
                new LangSetting(1).setVisible(true);
            }
        else
        {
            new LangSetting(0).setVisible(true);
        }
    }

    class LangSetting extends JFrame
    {
        JButton save;
        JButton done;
        JComboBox langauges;
        JLabel head;
        JLabel firstline;
        JLabel choice;
        JLabel langg;

        String lang;

        public LangSetting(int a)
        {
            super("iNitnem Select Language");
            if(a==0)
            {
                lang="Gurmukhi";
            }
            else
            {
                lang="English";
            }
            initComponents();
        }

        private void initComponents()
        {
            head = new JLabel();
            firstline = new JLabel();
            choice = new javax.swing.JLabel();
            langauges = new javax.swing.JComboBox();
            langg = new javax.swing.JLabel();
            save = new javax.swing.JButton();
            done = new javax.swing.JButton();
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\icon.jpg"));

            head.setFont(new java.awt.Font("Palatino Linotype", 1, 18));
            head.setForeground(new java.awt.Color(102, 102, 102));
            head.setText("Language Setting");

            firstline.setFont(new java.awt.Font("Tahoma", 1, 12));
            firstline.setForeground(new java.awt.Color(51, 51, 51));
            firstline.setText("Your Current Language");


            choice.setFont(new java.awt.Font("Tahoma", 1, 12));
            choice.setForeground(new java.awt.Color(51, 51, 51));
            choice.setText("Choose Language");

            langauges.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Language", "English", "Gurmukhi" }));

            langg.setFont(new java.awt.Font("Tahoma", 1, 12));
            langg.setText(lang);

            save.setIcon(new javax.swing.ImageIcon("Bin\\img\\save.png"));
            save.setBorderPainted(false);
            save.setContentAreaFilled(false);
            save.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            save();
                                        }
                                    });

            done.setIcon(new javax.swing.ImageIcon("Bin\\img\\done.png"));
            done.setVisible(false);
            done.setBorderPainted(false);
            done.setContentAreaFilled(false);
            done.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            done();
                                        }
                                    });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    .addComponent(done, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(firstline)
                    .addGap(18, 18, 18)
                    .addComponent(langg))
                        .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(head))
                        .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(choice)
                        .addGap(18, 18, 18)
                        .addComponent(langauges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(17, Short.MAX_VALUE))
                        );

            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(head)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstline)
                    .addComponent(langg))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choice)
                    .addComponent(langauges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(done, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    );
            setResizable(false);
            setLocation(d.height/2,d.width/9);
            pack();
        }

        public void save()
        {
            if(langauges.getSelectedIndex()==2)
            {
                gurmukhi = true;
                english=false;
                addLang("gurmukhi");
                jLabel1.setIcon(new javax.swing.ImageIcon("Bin\\img\\Opening.jpg"));
                jPanel1.revalidate();
                jPanel1.repaint();
            }
            else
                if(langauges.getSelectedIndex()==1)
                {
                    gurmukhi = false;
                    english=true;
                    addLang("english");
                    jLabel1.setIcon(new javax.swing.ImageIcon("Bin\\img\\OpeningE.jpg"));
                    jPanel1.revalidate();
                    jPanel1.repaint();
                }
            dispose();
        }

        public void addLang(String s)
        {
            try
            {
                BufferedWriter b = new BufferedWriter(new FileWriter("Bin\\Data\\Lang.ravs"));
                b.append(s);
                b.close();
            }catch(Exception sd){}
        }

        public void done()
        {
            dispose();
        }
    }

    class Banis extends javax.swing.JFrame
    {

         private javax.swing.JButton jButton1;

         private javax.swing.JButton jButton2;

         private javax.swing.JButton jButton3;

         private javax.swing.JButton jButton4;

         private javax.swing.JButton jButton5;

         private javax.swing.JLabel jLabel1;

    public Banis()
    {
        super("Banis");
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\icon.jpg"));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Banis");

        jButton1.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jButton1.setText("Jap Ji Sahib");
        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            dispose();
                                            EventQueue.invokeLater(new Runnable()
                                            {
                                                public void run()
                                                {
                                                    if(gurmukhi)
                                                    {
                                                        //new Main("NitnemDatabase\\NitnemPunjabi\\jj\\");
                                                    }
                                                    else
                                                    {
                                                        //new Main("NitnemDatabase\\NitnemHindiEnglish\\jj\\");
                                                    }
                                                }
                                            });
                                        }
                                    });

        jButton2.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jButton2.setText("Jaap Sahib");
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            dispose();
                                            EventQueue.invokeLater(new Runnable()
                                            {
                                                public void run()
                                                {
                                                    if(gurmukhi)
                                                    {
                                                        //new Main("NitnemDatabase\\NitnemPunjabi\\j\\");
                                                    }
                                                    else
                                                    {
                                                        //new Main("NitnemDatabase\\NitnemHindiEnglish\\jenglish\\");
                                                    }
                                                }
                                            });
                                        }
                                    });

        jButton3.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jButton3.setText("Swayein Sahib");
        jButton3.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            dispose();
                                            EventQueue.invokeLater(new Runnable()
                                            {
                                                public void run()
                                                {
                                                    if(gurmukhi)
                                                    {
                                                        //new Main("NitnemDatabase\\NitnemPunjabi\\tps\\");
                                                    }
                                                    else
                                                    {
                                                        //new Main("NitnemDatabase\\NitnemHindiEnglish\\tvsenglish\\");
                                                    }
                                                }
                                            });
                                        }
                                    });

        jButton4.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jButton4.setText("Anand Sahib");
        jButton4.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            dispose();
                                            EventQueue.invokeLater(new Runnable()
                                            {
                                                public void run()
                                                {
                                                    if(gurmukhi)
                                                    {
                                                        //new Main("NitnemDatabase\\NitnemPunjabi\\as\\");
                                                    }
                                                    else
                                                    {
                                                        //new Main("NitnemDatabase\\NitnemHindiEnglish\\as\\");
                                                    }
                                                }
                                            });
                                        }
                                    });

        jButton5.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jButton5.setText("Ardaas");
        jButton5.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            dispose();
                                            EventQueue.invokeLater(new Runnable()
                                            {
                                                public void run()
                                                {
                                                    if(gurmukhi)
                                                    {
                                                        //new Main("NitnemDatabase\\NitnemPunjabi\\a\\");
                                                    }
                                                    else
                                                    {
                                                        //new Main("NitnemDatabase\\NitnemPunjabi\\a\\");
                                                    }
                                                }
                                            });
                                        }
                                    });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        setResizable(false);
        setLocation(d.height/2,d.width/9);

        pack();
    }
}


}
