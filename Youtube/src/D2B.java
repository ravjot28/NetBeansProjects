/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class D2B
{
    String by=null;
  D2B(int i)
  {
     by= Integer.toBinaryString(i);
  }
  public String by()
  {
      if(by.length()!=8)
      {
          while(by.length()!=8)
          {
              by="0"+by;
          }
      }
      return(by);
  }
}
