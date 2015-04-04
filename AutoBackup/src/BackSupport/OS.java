/*
 *  Provides the OS name of the user's system
 */

package BackSupport;

public class OS                 // Provides the OS name
{
    public String getOS()
    {
        if(isWindows())
        {
            return("Win");
        }
        else
            if(isMac())
            {
                return("Mac");
            }
            else
                if(isUnix())
                {
                    return("Linux");
		}
                else
                {
                    return("NA");
                }

    }

    public static boolean isWindows()       //Checks for Windows OS
    {
	String os = System.getProperty("os.name").toLowerCase();
	return (os.indexOf( "win" ) >= 0);

    }

    public static boolean isMac()       //Checks for Mac OS
    {
	String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf( "mac" ) >= 0);
    }

    public static boolean isUnix()      //Checks for Linux/Unix
    {
	String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0);
    }
}
