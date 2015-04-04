import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SMTPSend {

public SMTPSend() {
}

public void msgsend() {
String username = "MySMSUsername";
String password = "MyPassword";
String smtphost = "MySMSHost.com";
String compression = "My SMS Compression Information";
String from = "mySMSUsername@MySMSHost.com";
String to = "PhoneNumberToText@sms.MySMSHost.com";
String body = "Hello SMS World!";
Transport myTransport = null;
try {
Properties props = System.getProperties();
props.put("mail.smtp.auth", "true");
Session mailSession = Session.getDefaultInstance(props, null);
Message msg = new MimeMessage(mailSession);
msg.setFrom(new InternetAddress(from));
InternetAddress[] address = {new InternetAddress(to)};
msg.setRecipients(Message.RecipientType.TO, address);
msg.setSubject(compression);
msg.setText(body);
msg.setSentDate(new Date());
myTransport = mailSession.getTransport("smtp");
myTransport.connect(smtphost, username, password);
msg.saveChanges();
myTransport.sendMessage(msg, msg.getAllRecipients());
myTransport.close();
} catch (Exception e) {
e.printStackTrace();
}
}

public static void main(String[] argv) {
SMTPSend smtpSend = new SMTPSend();
smtpSend.msgsend();
}
}

