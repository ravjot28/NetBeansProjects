
import RavBase64.Base64Encoder;
import RavBase64.Base64Decoder;

public class Main
{
    public static void main(String arg[])
    {
        RavBase64.Base64Encoder be = new Base64Encoder("Testing My API");
        String encode = be.get();
        System.out.println("Encode "+encode);
        
        RavBase64.Base64Decoder bd = new Base64Decoder(encode);
        String decode = bd.get();
        System.out.println("Decode "+decode.trim());
    }
}