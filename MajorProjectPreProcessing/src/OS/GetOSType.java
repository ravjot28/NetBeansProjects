package OS;

public class GetOSType
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

    public static boolean isWindows()
    {
	String os = System.getProperty("os.name").toLowerCase();
	//windows
	return (os.indexOf( "win" ) >= 0);

    }

    public static boolean isMac()
    {
	String os = System.getProperty("os.name").toLowerCase();
	//Mac
        return (os.indexOf( "mac" ) >= 0);
    }

    public static boolean isUnix()
    {
	String os = System.getProperty("os.name").toLowerCase();
	//linux or unix
        return (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0);
    }
}
