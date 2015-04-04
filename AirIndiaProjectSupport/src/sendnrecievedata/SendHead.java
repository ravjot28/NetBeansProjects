package sendnrecievedata;

public class SendHead
{
    String subject;
    String body;

    public SendHead(String heading,String data)
    {
        this.subject = heading;
        this.body = data;
    }

    public boolean process(String e)
    {
        String email[] = {"amebenevolent@gmail.com",e};
        sending sm = new sending("rravsofts@gmail.com","guru1111",subject,body,email);
        return sm.send();
    }
}
