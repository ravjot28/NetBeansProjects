package exe;
import java.io.*;

public class Main{
public static void main(String args[])throws IOException{
Runtime r=Runtime.getRuntime();
Process p=null;
try
{
String s="E:\\My docs\\Programming\\JAVA\\My Codes\\Dock\\Comp.exe";
p=r.exec(s);
}
catch(Exception e){
System.out.println("error==="+e.getMessage());
e.printStackTrace();
}
}
}