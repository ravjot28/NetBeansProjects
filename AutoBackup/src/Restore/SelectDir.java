package Restore;
import java.io.File;
import javax.swing.JFileChooser;

public class SelectDir
{
    JFileChooser chooser = new JFileChooser();

    public File process()
    {


        chooser.setMultiSelectionEnabled(false);     // Disable multiple selections

        chooser.setDialogTitle("Choose Directory");

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // Show the dialog; wait until dialog is closed
        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION)
        {
            return(chooser.getSelectedFile());
        }
        return null;
    }
}
