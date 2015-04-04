package BookReading;

import CreateExtension.Copy;
import CreateExtension.InfiniteProgressPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;

public class MainFrameiBook extends javax.swing.JFrame implements Runnable
{
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;

    static String filename;
    
    Thread th = new Thread(this);

    InfiniteProgressPanel glassPane;

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();
    
    public MainFrameiBook()
    {
        super("iBooks");
        JComponent cp = (JComponent) getContentPane();
        cp.setTransferHandler(new MyFileTransferHandler());
        initComponents();
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        glassPane = new InfiniteProgressPanel("Processing the File.Please Wait..");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        this.setGlassPane(glassPane);

        setIconImage(Toolkit.getDefaultToolkit().getImage("Bin\\img\\icon.png"));

        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon("Bin\\img\\background.jpg"));
        jLabel1.setToolTipText("Drag .rpub file type to read");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-80, 0, 400, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        setResizable(false);

        setLocation(d.height/2,d.width/9);

        pack();
    }

    public void run() 
    {
        glassPane.start();
        glassPane.setText("Validating the File.PLease Wait....");
        glassPane.revalidate();
        Copy c = new Copy();
        c.copyfile(filename, "Bin\\Data\\temp.zip");
        UnzipFolder uf = new UnzipFolder();
        uf.unzipFolder("Bin\\Data\\temp.zip", "Bin\\Data\\Temp");
        glassPane.stop();
        
    }

    class MyFileTransferHandler extends TransferHandler {

  public boolean canImport(JComponent arg0, DataFlavor[] arg1) {
    for (int i = 0; i < arg1.length; i++) {
      DataFlavor flavor = arg1[i];
      if (flavor.equals(DataFlavor.javaFileListFlavor)) {
        return true;
      }
      if (flavor.equals(DataFlavor.stringFlavor)) {
        return true;
      }
    }
    // Didn't find any that match, so:
    return false;
  }

  public boolean importData(JComponent comp, Transferable t)
  {
    DataFlavor[] flavors = t.getTransferDataFlavors();
    for (int i = 0; i < flavors.length; i++) {
      DataFlavor flavor = flavors[i];
      try {
        if (flavor.equals(DataFlavor.javaFileListFlavor)) {

          List l = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
          Iterator iter = l.iterator();
          while (iter.hasNext())
          {
            File file = (File) iter.next();
            String fpath = file.getCanonicalPath();
            if(fpath.endsWith(".rpub"))
            {
                filename=fpath;
                th.start();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Only RPUB File Format Allowed", "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println("GOT FILE: "+ file.getCanonicalPath());
            return true;

          }
          return true;
        }
      } catch (IOException ex) {

      } catch (UnsupportedFlavorException e) {

      }
    }
    Toolkit.getDefaultToolkit().beep();
    return false;
  }
}



}

