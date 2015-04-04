package sendnrecievedata;

public class SendAdminRequest
{
    private String subject;
    private String body;

    public SendAdminRequest(String heading,String data)
    {
        this.subject = heading;
        this.body = data;
    }

    public boolean process()
    {
        String to[] = {"ravsoftsairindiaadm@gmail.com"};
        sending sm = new sending("ravsoftsairindiaadm@gmail.com","docomo3401",subject,body,to);
        return sm.send();
    }
}
