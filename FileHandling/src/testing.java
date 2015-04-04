import java.util.*;
public class testing
{
    Scanner s;
    public static void main(String ar[])
    {
        new testing();
    }
    testing()
    {
        String result="";
        s=new Scanner(System.in);
        System.out.println("Enter the file name");
        String name=s.next();
        System.out.println("Enter the data");
        String d="";
        while(!d.equalsIgnoreCase("quit"))
        {
            result=result+d+"\n";
            d=s.next();
        }
        new FileWriting(name,result);
        System.out.println("File output");
        new FileWriting("abcd");
    }

}
