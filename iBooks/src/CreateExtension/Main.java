package CreateExtension;

import Main.MainFrame;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;

public class Main extends javax.swing.JFrame implements Runnable
{
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;

    Thread th = new Thread(this);

    InfiniteProgressPanel glassPane;

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();

    static String filepath="";
    
    public Main()
    {
        super("iBooks Converter");
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        glassPane = new InfiniteProgressPanel("Processing the File.Please Wait..");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        this.setGlassPane(glassPane);

        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\icon.png"));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 18));
        jLabel1.setText("iBooks Converter");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Please Select Your PDF file");

        jButton1.setIcon(new javax.swing.ImageIcon("Bin\\img\\filechooser.gif"));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);

        jButton1.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            fileChooser();
                                        }
                                    });

        jButton2.setIcon(new javax.swing.ImageIcon("Bin\\img\\convert.gif"));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            th.start();
                                        }
                                    });

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12));

        jButton3.setIcon(new javax.swing.ImageIcon("Bin\\img\\mainmenu.png"));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            EventQueue.invokeLater(new Runnable()
                                            {
                                                public void run()
                                                {
                                                    dispose();
                                                    new MainFrame().setVisible(true);
                                                }
                                            });
                                        }
                                    });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        setResizable(false);

        setLocation(d.height/2,d.width/9);

        pack();
    }

    public void fileChooser()
    {
        int retVal;
        JFileChooser fc = new JFileChooser();                                                
        fc.addChoosableFileFilter(new TextFilter());
        fc.setMultiSelectionEnabled(true);
        retVal = fc.showOpenDialog(fc);
        if (retVal == JFileChooser.APPROVE_OPTION)
        {
            filepath = fc.getSelectedFile().toString();
            jLabel3.setText("File Selected");
        }
    }

    public void run()
    {
        glassPane.start();
        try {
            ImageMain.setup(filepath);
            glassPane.setText("Converting File.Please Wait..");
            glassPane.revalidate();
            //glassPane.repaint();
            ZipFolder z = new ZipFolder();
            String fname = filepath.substring(filepath.lastIndexOf("\\")+1, filepath.lastIndexOf(".pdf"));
            z.process(fname);
            glassPane.setText("Finishing...");
            glassPane.revalidate();
            Copy c = new Copy();
            c.copyfile("Bin\\Data\\"+fname+".zip",filepath.substring(0,filepath.lastIndexOf("\\"))+"\\"+fname+".rpub");
            
            File f = new File("Bin\\Data\\"+fname+".zip");
            f.delete();
            glassPane.stop();
            JOptionPane.showMessageDialog(null, "File is Converted and stored at your PDF file Location.", "Success", JOptionPane.INFORMATION_MESSAGE);
            EventQueue.invokeLater(new Runnable()
                                            {
                                                public void run()
                                                {
                                                    dispose();
                                                    new MainFrame().setVisible(true);
                                                }
                                            });
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    class TextFilter extends FileFilter
    {
        public boolean accept(File f)
        {
            if (f.isDirectory())
                return true;
            String s = f.getName();
            int i = s.lastIndexOf('.');
            if (i > 0 && i < s.length() - 1)
                if (s.substring(i + 1).toLowerCase().equals("pdf"))
                    return true;
            return false;
        }

        public String getDescription()
        {
            return "Accepts only PDF files.";
        }
    }

}
