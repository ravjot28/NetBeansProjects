public class D2Btwitter
{
    String by=null;
  D2Btwitter(int i)
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
