import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.jscape.inet.ssh.Ssh;
import com.jscape.inet.ssh.SshAdapter;
import com.jscape.inet.ssh.SshConnectedEvent;
import com.jscape.inet.ssh.SshDataReceivedEvent;
import com.jscape.inet.ssh.SshDisconnectedEvent;
import com.jscape.inet.ssh.SshException;
import com.jscape.inet.ssh.SshScript;
import com.jscape.inet.ssh.SshTask;

import com.jscape.inet.ssh.util.SshParameters;

public class SshScriptTutorial extends SshAdapter {
   public SshScriptTutorial() {}

   public void executeSshScript(String hostname, String username, String password)
      throws SshException, IOException
   {
      // assumes that SSH shell prompt is "$" .. this MUST match exactly
      String shellPrompt = ">";

      // initialize and create new Ssh instance
      SshParameters sshParams = new SshParameters(hostname,username,password);
      Ssh ssh = new Ssh(sshParams);

      // register this class to receive Ssh events
      ssh.addSshListener(this);

      // create new script object and bind to the given ssh object
      SshScript script = new SshScript(ssh);

      // add tasks to script object
      script.addTask(new SshTask(shellPrompt, "show host", shellPrompt));
      
      ssh.connect();

      // wait until last task is complete
      while(!script.isComplete()) {
         try {
            Thread.sleep(100);
         } catch(Exception e) {}
      }

      // disconnect from server
//      ssh.disconnect();
   }

   public void connected(SshConnectedEvent event) {
      System.out.println("Connected to host: " + event.getHost());
   }

   public void disconnected(SshDisconnectedEvent event) {
      System.out.println("Disconnected from host: " + event.getHost());
   }

   public void dataReceived(SshDataReceivedEvent event) {
      System.out.print(event.getData());
   }

   public static void main(String[] args) {
      try {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//         System.out.print("Enter SSH hostname: ");
//         String hostname = reader.readLine();
//         System.out.print("Enter SSH username: ");
//         String username = reader.readLine();
         String hostname = "150.236.14.11";
         String username = "equwxyb";

         System.out.print("Enter SSH password: ");
         String password = reader.readLine();

         SshScriptTutorial tutorial = new SshScriptTutorial();
         tutorial.executeSshScript(hostname, username, password);

         String cus_pass = reader.readLine();

      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}
