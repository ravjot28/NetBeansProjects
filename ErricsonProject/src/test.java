
import com.jscape.inet.ssh.SshException;
import com.jscape.inet.ssh.SshSession;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class test {

    public static void main(String ar[]) throws SshException{
        String shellPrompt = "$";
        SshSession session = new SshSession("hostname","username","password");
        session.setShellPrompt(shellPrompt);
        session.connect();
        log("log_file.txt",session.sendWait("command",shellPrompt));
        log("log_file.txt",session.sendWait("command",shellPrompt));
        session.disconnect();
    }

    public static void log(String fname,String data){
        try{
            BufferedWriter b = new BufferedWriter(new FileWriter(fname,true));
            b.append(data);
            b.newLine();
            b.close();
        }catch(Exception e){

        }
    }
}
