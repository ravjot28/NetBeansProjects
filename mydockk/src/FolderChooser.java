import javax.swing.*;
import java.awt.event.*;


public class FolderChooser extends JPanel implements ActionListener
{
   JButton go;
   JFileChooser chooser;
   String choosertitle;

 public String go()
 {
    String r=null;
    chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle(choosertitle);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    //
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
    {
      //System.out.println("getCurrentDirectory():"+  chooser.getCurrentDirectory());
      //System.out.println("getSelectedFile():"+  chooser.getSelectedFile());
      r=chooser.getSelectedFile().toString();
      }
    else
    {
      //System.out.println("No Selection ");
        r="No";
    }
    return(r);
     }

 public void close()
 {
     chooser.setVisible(false);
 }

    public void actionPerformed(ActionEvent e)
    {

    }

}