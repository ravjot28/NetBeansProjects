package sendnrecievedata;

public class SendEmployeeRequest
{
    private String subject;
    private String body;

    public SendEmployeeRequest(String heading,String data)
    {
        this.subject = heading;
        this.body = data;
    }

    public boolean process()
    {
        String to[] = {"ravsoftsairindia@gmail.com"};
        sending sm = new sending("ravsoftsairindia@gmail.com","docomo3401",subject,body,to);
        return sm.send();
    }
}
