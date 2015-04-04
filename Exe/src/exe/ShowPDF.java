package exe;
public class ShowPDF {
  public static void main(String[] args) throws Exception {
    Process p =
      Runtime.getRuntime()
        .exec("rundll32 url.dll,FileProtocolHandler E:\\My docs\\Programming\\JAVA\\J2ME\\J2ME BOOKS\\MOBILE GAME PROGRAMMING J2ME.pdf");
    
    //p.waitFor();
    //System.out.println("Done.");
  }
}