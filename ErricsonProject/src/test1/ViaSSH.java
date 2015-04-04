package test1;

import com.jcraft.jsch.*;
import java.util.NoSuchElementException;
import javax.swing.*;

public class ViaSSH {
  public static void main(String[] arg)
    throws JSchException, InterruptedException
  {
    JSch jsch=new JSch();

    String[] proxyInfo = queryUserAndHost("proxy server",
                                          arg.length > 0 ? arg[0] : null);

    Session gateway=jsch.getSession(proxyInfo[0], proxyInfo[1]);
    
    UserInfo ui=new SwingDialogUserInfo();
    gateway.setUserInfo(ui);
    gateway.connect();

    String[] targetInfo = queryUserAndHost("target server",
                                           arg.length > 1 ? arg[1] : null);

    Session session=jsch.getSession(targetInfo[0], targetInfo[1]);
    
    session.setProxy(new ProxySSH(gateway));
    
    session.setUserInfo(ui);

    System.err.println("connecting session ...");
    session.connect();

    System.err.println("session connected.");
    System.err.println("opening shell channel ...");

    Channel channel=session.openChannel("shell");

    channel.setOutputStream(System.out, true);
    channel.setExtOutputStream(System.err, true);

    channel.setInputStream(System.in, true);
    

    channel.connect();

    System.err.println("shell channel connected.");

    do {
      Thread.sleep(100);
    } while(!channel.isEOF());
    System.err.println("exitcode: " + channel.getExitStatus());
    session.disconnect();
    Thread.sleep(50);

    gateway.disconnect();
  }
  
  private static String[] queryUserAndHost(String promptSuffix,
                                           String useThis) {
    if(useThis == null || !useThis.contains("@")) {
      useThis = JOptionPane.showInputDialog("Enter username@hostname for " +
                                            promptSuffix,
                                            System.getProperty("user.name") +
                                            "@localhost");
    }
    if(useThis == null) {
      throw new NoSuchElementException("User does not want!");
    }
    return useThis.split("@");
  }

}
