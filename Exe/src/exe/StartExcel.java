package exe;
import java.io.IOException;

public class StartExcel
{
    public static void main(String args[])
        throws IOException
    {
        Runtime.getRuntime().exec("cmd /c start explore.exe H:\\Users\\Rav\\Desktop\\Introduction.html");
    }
}
