import java.security.Security;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class informer implements Runnable
{
    String en;
    String em;
    String mes;
    Thread th = new Thread(this);

    informer(String enroll,String email,String mess)
    {
        en=enroll;
        em=email;
        mes=mess;
        th.start();
    }

    public void run()
    {
        String to[]={em,"gtbitinfo1@gmail.com"};
        sending s = new sending("gtbitinfo1@gmail.com",mes,en+" Do not reply",to,"docomo3401");
        s.send();
    }
    
    class sending
    {
        private static final String SMTP_HOST_NAME = "smtp.gmail.com";
        private static final String SMTP_PORT = "465";
        private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        String MsgTxt=null;
        String Subject=null;
        String From=null;
        String pwd=null;
        String[] too;

        public sending(String fr,String msg,String sub,String[] fro,String p)
        {
            MsgTxt=msg;
            Subject=sub;
            From=fr;
            pwd=p;
            too=fro;
        }

        public String send()
        {
            String s="";
                Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                try
                {
                    sendSSLMessage(too,Subject,MsgTxt,From,pwd);
                }catch(Exception e)
                {
                    e.printStackTrace();
                    s=e.getMessage();
                }
                if(s.equals(""))
                {
                    s="Your message is successfully mailed";
                }
                return(s);
        }

        public void sendSSLMessage(String recipients[], String subject,String message, String from,String pwd)
        {
            try
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

                final String from1 = from;
                final String pwd1 = pwd;
                Session session = Session.getInstance(props, new javax.mail.Authenticator()
                                    {
                                        protected PasswordAuthentication getPasswordAuthentication()
                                        {
                                            return new PasswordAuthentication(from1, pwd1);
                                        }
                                    });
                session.setDebug(debug);

                Message msg = new MimeMessage(session);
                InternetAddress addressFrom = new InternetAddress(from);
                msg.setFrom(addressFrom);
                InternetAddress[] addressTo = new InternetAddress[recipients.length];
                for (int i = 0; i < recipients.length; i++)
                {
                    addressTo[i] = new InternetAddress(recipients[i]);
                }
                msg.setRecipients(Message.RecipientType.TO, addressTo);
                msg.setSubject(subject);
                msg.setContent(message, "text/plain");
                Transport.send(msg);
                from = null;
                recipients = null;
                pwd = null;
                subject = null;
                message = null;
            } catch (MessagingException ex)
            {
                ex.printStackTrace();
            }
        }
    }

}
