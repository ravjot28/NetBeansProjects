package getOSName;

public class GetOSName
{
  public static void main(String args[]) {
    try{
      String osName= System.getProperty("os.name");
      System.out.println("Operating system name =>"+ osName);
    }catch (Exception e){
      System.out.println("Exception caught ="+e.getMessage());
    }
  }
}