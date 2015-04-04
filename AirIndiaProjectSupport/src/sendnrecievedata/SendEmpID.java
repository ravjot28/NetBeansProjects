package sendnrecievedata;

public class SendEmpID
{
    String email = "ravsoftsairindiaempcheck@gmail.com";
    String password = "docomo3401";

    String subject;
    String body;

    public SendEmpID(String heading,String data)
    {
        this.subject = heading;
        this.body = data;
    }

    public boolean process()
    {
        String to[] = {"ravsoftsairindiaempcheck@gmail.com"};
        sending sm = new sending(email,password,subject,body,to);
        return sm.send();
    }
}
