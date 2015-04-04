public class D2BMail
{
    String by=null;
  D2BMail(int i)
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
