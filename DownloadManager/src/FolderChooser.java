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
    chooser.setAcceptAllFileFilterUsed(false);
    //
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
    {
      r=chooser.getSelectedFile().toString();
      }
    else
    {
        r="No";
    }
    return(r);
     }

    public void actionPerformed(ActionEvent e)
    {

    }

}