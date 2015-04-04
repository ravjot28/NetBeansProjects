package openfilesinmac;

import java.io.IOException;

public class Main
{
    public static void main(String asd[])
    {
        try
        {
            Runtime rt=Runtime.getRuntime();
            rt.exec("open r.gif");
        }catch(Exception as){System.out.println(as);}
    }
}
