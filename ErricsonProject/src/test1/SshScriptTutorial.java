package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import com.jscape.inet.ssh.Ssh;
import com.jscape.inet.ssh.SshAdapter;
import com.jscape.inet.ssh.SshConnectedEvent;
import com.jscape.inet.ssh.SshDataReceivedEvent;
import com.jscape.inet.ssh.SshDisconnectedEvent;
import com.jscape.inet.ssh.SshException;
import com.jscape.inet.ssh.SshScript;
import com.jscape.inet.ssh.SshSession;
import com.jscape.inet.ssh.SshTask;
import com.jscape.inet.ssh.connection.channels.SessionClient;
import com.jscape.inet.ssh.connection.channels.SessionRequests;
import com.jscape.inet.ssh.util.SshParameters;
import com.jscape.inet.telnet.Telnet;
import com.jscape.inet.telnet.TelnetException;
import com.jscape.inet.telnet.TelnetListener;
import com.jscape.inet.telnet.TelnetSession;
import com.jscape.inet.telnet.TelnetTask;

public class SshScriptTutorial extends SshAdapter {
   public SshScriptTutorial() {}

   public void executeSshScript(String hostname, String username, String password)
      throws SshException, IOException, InterruptedException, TelnetException
   {
      // assumes that SSH shell prompt is "$" .. this MUST match exactly
      String shellPrompt = ">";
      String shellPrompt1 = ":";

      // initialize and create new Ssh instance
      SshParameters sshParams = new SshParameters(hostname,username,password);
      Ssh ssh = new Ssh(sshParams);

      // register this class to receive Ssh events
      ssh.addSshListener(this);

      // create new script object and bind to the given ssh object
      SshScript script = new SshScript(ssh);

      

//      Scanner sn = new Scanner(System.in);
//      FileWriter f = new FileWriter("write.txt");

//      PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sn.getOutputStream())), true);


  /*    SshTask task2 = new SshTask(shellPrompt, "equwxyb11", shellPrompt);
	  script.addTask(task2);*/

      // add tasks to script object
      script.addTask(new SshTask(shellPrompt, "show host", shellPrompt));
      script.addTask(new SshTask(shellPrompt, "ssh ssgpun", shellPrompt1));
      script.addTask(new SshTask(shellPrompt1, "equwxyb11", shellPrompt));
      script.addTask(new SshTask(shellPrompt, "net 10.136.197.82", shellPrompt1));
      script.addTask(new SshTask(shellPrompt1, "els", shellPrompt1));
      script.addTask(new SshTask(shellPrompt1, "dec@12345", shellPrompt));
      
      script.addTask(new SshTask(shellPrompt, "telnet 10.228.128.33", shellPrompt1));
      script.addTask(new SshTask(">", "username", ":"));

      /*
//      String hostname_t = "10.0.0.2";
      String loginPrompt = "login name:";
      String passwordPrompt = "password:";

      // create new TelnetSession instance providing hostname as argument
      TelnetSession session = new TelnetSession("10.228.128.33");

      // set the expected login prompt
      session.setLoginPrompt(loginPrompt);

      // set the expected password prompt
      session.setPasswordPrompt(passwordPrompt);

      // set the expected shell prompt
      session.setShellPrompt(":");

      // connect and login using supplied username and password
      session.connect("switchind", "Indore123");
*/
      // send command to telnet server and wait for shell prompt
    /*  session.send("cd /user/logs");

      // send command to telnet server and wait for shell prompt
      session.send("rm *.log");

      // send command to telnet server and DO NOT wait for shell prompt
      session.sendNoWait("exit");

      // close connection with telnet server
      session.disconnect();

*/
//      TelnetTask tt = new TelnetTask(shellPrompt1, "switchind", shellPrompt1);

//      script.addTask(new SshTask(shellPrompt1, "switchind", shellPrompt1));
//      script.addTask(new SshTask(shellPrompt1, "Indore123", "\\"));

      // connect to SSH server and execute script
      ssh.connect();

      // wait until last task is complete
      while(!script.isComplete()) {
         try {
            Thread.sleep(500);
         } catch(Exception e) {
        	 System.err.println(e.getMessage());
         }
      }

      // disconnect from server
//      ssh.disconnect();

/*      String loginPrompt = ":";
      String passwordPrompt = ":";

      // create new TelnetSession instance providing hostname as argument
      TelnetSession session = new TelnetSession("10.228.128.33");

      // set the expected login prompt
      session.setLoginPrompt(loginPrompt);

      // set the expected password prompt
      session.setPasswordPrompt(passwordPrompt);

      // set the expected shell prompt
      session.setShellPrompt(":");

      // connect and login using supplied username and password
      session.connect("switchind", "Indore123");*/

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

      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}



