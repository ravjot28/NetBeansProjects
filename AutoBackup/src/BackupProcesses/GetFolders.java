package BackupProcesses;

import java.io.File;
import javax.swing.JFileChooser;

public class GetFolders
{
    JFileChooser chooser = new JFileChooser();
    
    public String[] process()
    {
        

        chooser.setMultiSelectionEnabled(true);     // Enable multiple selections
        
        chooser.setDialogTitle("Choose Folders");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // Show the dialog; wait until dialog is closed
        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION)
        {
            File[] file = chooser.getSelectedFiles();  // Retrieve the selected files. This method returns empty
            String files[] = new String[file.length];
            int i=0;
            for(File f:file)
            {
                files[i] = f.getAbsolutePath();
                i++;
            }
            return files;
        }
        return null;
    }
}
