import java.security.Security;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

public class sendingYahoo1
{
    MimeMessage msg;
    private static final String SMTP_HOST_NAME = "smtp.mail.yahoo.com";
    private static final String SMTP_PORT = "465";
    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    String MsgTxt=null;
    String Subject=null;
    String From=null;
    String pwd=null;
    String[] too;
    String[] sss;
    static int count=0;

    public sendingYahoo1(String fr,String msg,String sub,String[] fro,String p,String[] ss)
    {
        MsgTxt=msg;
        Subject=sub;
        From=fr;
        pwd=p;
        too=fro;
        sss=ss;
        send();
    }

    public String send()
    {
        String s="";
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            try
            {
                sendSSLMessage(too,Subject,MsgTxt,From,pwd,sss);

                Transport.send(msg);
            }catch(Exception e)
            {
                s=e.getMessage();
            }
            if(s.equals(""))
            {
                s="Your message is successfully mailed";
            }
            return(s);
    }



    public void sendSSLMessage(String[] recipients, String subject,String message, String from,String pwd,String[] ssss) throws MessagingException
    {
        boolean debug = false;
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        final String from1=from;
        final String pwd1=pwd;
        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator()
        {protected PasswordAuthentication getPasswordAuthentication()
            {return new PasswordAuthentication(from1,pwd1);}});
        session.setDebug(debug);
        msg = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);
        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i <recipients.length; i++)
        {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);
        msg.setSubject(subject);
        MimeBodyPart mbp1 = new MimeBodyPart (  ) ;
        mbp1.setText ( message ) ;
        MimeBodyPart attachment[]=new MimeBodyPart[sss.length];
        Multipart mp = new MimeMultipart (  ) ;
        mp.addBodyPart ( mbp1 ) ;
        for(int i=0;i<sss.length;i++)
        {
            attachment[i] = new MimeBodyPart() ;
            DataSource fds = new FileDataSource ( sss[i] ) ;
            attachment[i].setDataHandler ( new DataHandler ( fds )  ) ;
            attachment[i].setFileName ( fds.getName() ) ;
            mp.addBodyPart(attachment[i]);
        }

          // msg.setContent(message, "text/plain");
        msg.setContent(mp);


        from=null;
        recipients=null;
        pwd=null;
        subject=null;
        message=null;

    }
}

