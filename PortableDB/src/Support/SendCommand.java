package Support;

import java.security.Security;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendCommand {

    String email = "portabledboperations@gmail.com";
    String password = "guru3401";
    String subject;
    String body;

    public SendCommand(String data) {
        this.subject = "ravjot";
        this.body = data;
    }

    public boolean process() {
        String to[] = {"portabledboperations@gmail.com"};
        sending sm = new sending(email, password, subject, body, to);
        return sm.send();
    }

    class sending {

        private static final String SMTP_HOST_NAME = "smtp.gmail.com";
        private static final String SMTP_PORT = "465";
        private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        String MsgTxt = null;
        String Subject = null;
        String From = null;
        String pwd = null;
        String[] too;

        private sending(String fr, String p, String sub, String msg, String[] fro) {
            MsgTxt = msg;
            Subject = sub;
            From = fr;
            pwd = p;
            too = fro;

        }

        private boolean send() {
            String s = "";
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            try {
                sendSSLMessage(too, Subject, MsgTxt, From, pwd);
                return true;
            } catch (Exception e) {
            }

            return (false);
        }

        private void sendSSLMessage(String recipients[], String subject, String message, String from, String pwd) throws MessagingException {
            boolean debug = false;
            Properties props = new Properties();
            props.put("mail.smtp.host", SMTP_HOST_NAME);
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.smtp.port", SMTP_PORT);
            props.put("mail.smtp.socketFactory.port", SMTP_PORT);
            props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.debug", "false");
            final String from1 = from;
            final String pwd1 = pwd;

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from1, pwd1);

                }
            });
            session.setDebug(debug);
            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(from);
            msg.setFrom(addressFrom);

            InternetAddress[] addressTo = new InternetAddress[recipients.length];
            for (int i = 0; i < recipients.length; i++) {
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

        }
    }
}
