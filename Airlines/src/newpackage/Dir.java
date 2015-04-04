
package newpackage;

import java.io.*;
import java.util.StringTokenizer;

public class  Dir
{
  public String dir(String fname)
  {
    File dir = new File(fname);
    String[] chld = dir.list();
    if(chld == null){
      return("n");
    }else{
      return("y");
    }
  }
  
  public static void main(String[] args)
  {
      String a[]={"A","B","C","D","E","F","G","H","I","J",
                    "K","L","M","N","O","P","Q","R","S","T",
                    "U","V","W","X","Y","Z"};
      String name="";
      for(int i=0;i<26;i++)
      {
          if((new Dir().dir(a[i]+":\\").equalsIgnoreCase("y"))&&(!a[i].equalsIgnoreCase("c")))
          {
            name=name+"\""+a[i]+"\""+",";
          }
            else
          {
            continue;
          }
      }
      StringTokenizer t=new StringTokenizer(name.substring(0,name.lastIndexOf(",")),",");
      String b[]=new String[t.countTokens()];
      int c=0;
      while(t.hasMoreTokens())
      {
          b[c]=t.nextToken();
          c++;
      }
      for(int i=0;i<b.length;i++)
      {
          System.out.println(b[i]);
      }
    
  }
}