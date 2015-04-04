/*
 * This class creates the marking on the pen drive so that the software can easily detect the pen drive or hard disk
 */

package BackgroundApplication;

import Interfaces.BackgroundApplicationVariables;
import Log.LogInput;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class MarkDisk implements BackgroundApplicationVariables
{
    static String fileName;

    public MarkDisk(String s)       //Takes the pen drive or hard disk path
    {
        this.fileName = s;
        System.out.println(fileName);
    }

    public boolean createHiddenFile(String fname) throws IOException    //Creates the File Hidden
    {
        String comando = "C:\\WINDOWS\\System32\\ATTRIB.EXE +H "+fname;     //Command to make the file Hidden

        Runtime.getRuntime().exec(comando );        //Executes the command at OS level

        return true;
    }

    public boolean createMarkFile(String s)
    {
        if(new File(fileName).exists())
        {
            return true;
        }
 else
        {
        try
        {
            BufferedWriter b = new BufferedWriter(new FileWriter(fileName));    //Creartes the marking file in the pen drive or hard disk
            b.append(s);
            b.close();
            if(createHiddenFile(fileName))
                return true;
            else
            {
                LogInput li = new LogInput();           //If the file was not made hidden
                li.input("File:"+fileName+"Error: Can not make the file hidden");
                return false;
            }
        }catch(Exception ae)
        {
            LogInput li = new LogInput();           //If the mark file is not created
            li.input("File:"+fileName+" Error:"+ae);
            JOptionPane.showMessageDialog(null,"Can not access the disk","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    }
}
