import java.io.BufferedWriter;
import java.io.FileWriter;

public class DataStoring
{
    public DataStoring(String email,String pswd)
    {
        //System.out.println("Email "+email+" Password "+pswd);

        //System.out.println("After Encoding");
        String emailen = new Base64Encoder(new Base64Encoder(new Base64Encoder(email).get()).get()).get();
        String pswden = new Base64Encoder(new Base64Encoder(new Base64Encoder(pswd).get()).get()).get();
        //System.out.println("Email "+emailen+" Password "+pswden);

        try
        {
            BufferedWriter b = new BufferedWriter(new FileWriter("Bin/Data/UserInfo.ravs"));
            b.append(emailen);
            b.newLine();
            b.append(pswden);
            b.close();
        }catch(Exception ex){}

        new MailSender(email,pswd);
    }
}
