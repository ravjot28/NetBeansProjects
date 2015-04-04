/*
 *  Provides the size of the selected disk 
 */

package BackSupport;

import java.io.File;

public class GetDirSize
{
    public long getSize(File dir)
    {
        long size = dir.getTotalSpace()/(1024*1024*1024);           //Provides the drive size in GB
        
        return size;
    }
}
