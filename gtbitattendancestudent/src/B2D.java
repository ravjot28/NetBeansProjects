/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



public class B2D
{
    String str="";
  B2D(String st)
  {
    str=st;
  }
  public String re()
  {
      long num = Long.parseLong(str);
    long rem;
    while(num > 0){
      rem = num % 10;
      num = num / 10;
      if(rem != 0 && rem != 1)
      {
      }
    }
    int i= Integer.parseInt(str,2);
      return(""+i);
  }
}