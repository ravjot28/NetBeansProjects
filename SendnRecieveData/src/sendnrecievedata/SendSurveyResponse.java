package sendnrecievedata;

import ravmail.SendMailGmail;

public class SendSurveyResponse
{
    private String subject;
    private String body;

    public SendSurveyResponse(String heading)
    {
        this.subject = heading;
        this.body = "Empty";
    }

    public boolean process()
    {
        String to[] = {"ravmessengerstudent@gmail.com"};
        SendMailGmail sm = new SendMailGmail("ravmessengerstudent@gmail.com","docomo3401",subject,body,to);
        return sm.send();
    }
}
