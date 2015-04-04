
import java.io.IOException;
import java.util.List;
import mailreader.InboxReader;
import mailreader.MessageContent;




public class CD {

    public static void main(String a[]) throws IOException, InterruptedException, Exception
    {
        List<MessageContent> aa= new InboxReader("emailid", "password", "imap.gmail.com").startreading();
         String cmd = "cmd /c start C:\\Users\\Rav\\Documents\\NetBeansProjects\\recievemail\\shutdown.bat";
                                        System.out.println(cmd);
                                        Process p = Runtime.getRuntime().exec(cmd);
    }

}
