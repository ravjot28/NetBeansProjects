package TestingPDFConverter;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.TransferHandler;

public class Dropper extends JFrame {

    
  public Dropper() {
    super("Drop Target");

    JComponent cp = (JComponent) getContentPane();
    cp.setTransferHandler(new MyFileTransferHandler()); // see below

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(150, 150);
  }

  public static void main(String[] args) {
    new Dropper().setVisible(true);
  }
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