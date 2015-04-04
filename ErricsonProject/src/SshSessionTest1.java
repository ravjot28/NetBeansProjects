import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.jscape.inet.ssh.SshException;
import com.jscape.inet.ssh.SshSession;
import com.jscape.inet.ssh.SshTask;
import com.jscape.inet.ssh.SshTaskTimeoutException;
import com.jscape.inet.telnet.TelnetException;
import com.jscape.inet.telnet.TelnetListener;
import com.jscape.inet.telnet.TelnetSession;


public class SshSessionTest1
{

      public static void main(String ar[]) throws SshException, IOException, SshTaskTimeoutException, TelnetException
      {
              String shellPrompt = ">";

              BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
              System.out.print("Password: ");
              String tmpPass = reader.readLine();

              SshSession session = new SshSession("150.236.14.11","equwxyb", tmpPass);
              session.setShellPrompt(shellPrompt);
              session.connect();
              System.out.println("connecting");
          String output = session.sendWait("show host", shellPrompt);
          System.out.println(output);
          output = session.sendWait("ssh ssgpun",":");
          System.out.println(output);
          output = session.sendWait("equwxyb11",shellPrompt);
          System.out.println(output);
          output = session.sendWait("net 10.136.197.82",":");
          System.out.println(output);
          output = session.sendWait("els", ":");
          System.out.println(output);
          output = session.sendWait("dec@12345", ">");
          System.out.println(output);
          String shell_prompt = session.getShellPrompt();   //This gets the shellprompt and stores in the string

              session.disconnect();
      }
}