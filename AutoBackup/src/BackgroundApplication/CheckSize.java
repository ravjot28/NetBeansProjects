/*
 *  Checks the size of the pen drive or external attached to the system
    with the size band set by the developers
 */

package BackgroundApplication;

import BackSupport.GetDirSize;
import Interfaces.BackgroundApplicationVariables;
import java.io.File;

public class CheckSize implements BackgroundApplicationVariables
{
    static String dir;

    public CheckSize(String a)
    {
        this.dir = a;           //Gets the disk location
    }

    public boolean validateSize()
    {
        return new GetDirSize().getSize(new File(dir))>= SIZE_BAND;     //Compares the disk size with the size band selected by the developer
    }
}
