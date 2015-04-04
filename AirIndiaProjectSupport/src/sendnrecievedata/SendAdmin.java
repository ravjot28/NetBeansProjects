package sendnrecievedata;

public class SendAdmin
{
    String email = "ravsoftsairindiaadmcheck@gmail.com";
    String password = "docomo3401";

    String subject;
    String body;

    public SendAdmin(String heading,String data)
    {
        this.subject = heading;
        this.body = data;
    }

    public boolean process()
    {
        String to[] = {"ravsoftsairindiaadmcheck@gmail.com"};
        sending sm = new sending(email,password,subject,body,to);
        return sm.send();
    }
}
