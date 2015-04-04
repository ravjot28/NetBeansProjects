import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordGenerator
{

    public String gen() throws NoSuchAlgorithmException
    {
        String args[]={"-a","8"};
        String pswd="";
        int passLength = 0;
        SecureRandom wheel = SecureRandom.getInstance("SHA1PRNG");
        char[] alphaNumberic = new char[]
                                {
                                    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                                    'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                                    'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                                    '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                passLength = Integer.parseInt(args[1]);
                for (int i = 0; i < passLength; i++)
                {
                    int random = wheel.nextInt(alphaNumberic.length);
                    pswd=pswd+alphaNumberic[random];
                }
         return pswd;
    }
}