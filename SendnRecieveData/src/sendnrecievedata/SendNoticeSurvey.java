package sendnrecievedata;

import ravmail.SendMailGmail;

public class SendNoticeSurvey
{
    private String subject;
    private String body;

    public SendNoticeSurvey(String heading,String data)
    {
        this.subject = heading;
        this.body = data;
    }

    public boolean process()
    {
        String to[] = {"ravmessenger@gmail.com"};
        SendMailGmail sm = new SendMailGmail("ravmessenger@gmail.com","docomo3401",subject,body,to);
        return sm.send();
    }
}
