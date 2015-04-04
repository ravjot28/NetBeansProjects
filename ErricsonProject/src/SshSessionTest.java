import java.io.*;

import com.jscape.inet.ssh.*;
import com.jscape.inet.ssh.util.SshParameters;

public class SshSessionTest extends SshAdapter {

	private String shellPrompt = "$";

	private String hostname;
	private String username;
	private String password;
	private SshSession session;

	public SshSessionTest(String hostname, String username, String password) throws SshException {
		this.hostname = hostname;
		this.username = username;
		this.password = password;
		SshParameters sshParams = new SshParameters(hostname,username,password);
		session = new SshSession(sshParams);
		session.setShellPrompt(shellPrompt);
		session.addSshListener(this);
	}
        
	public void printDirListing() throws SshException {
		session.connect();
		String dirListing = session.send("<write the login command here and tell me the output>");
		System.out.println(dirListing);
		session.disconnect();
	}

	public void connected(SshConnectedEvent evt) {
		System.out.println("Connected to host: " + evt.getHost());
	}

	public void disconnected(SshDisconnectedEvent evt) {
		System.out.println("Disconnected from host: " + evt.getHost());
	}
        
	public static void main(String[] args) {
		try {
			String tmpHost = null;
			String tmpUser = null;
			String tmpPass = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Hostname: ");
			tmpHost = reader.readLine();
			System.out.print("Username: ");
			tmpUser = reader.readLine();
			System.out.print("Password: ");
			tmpPass = reader.readLine();
			SshSessionTest ss = new SshSessionTest(tmpHost,tmpUser,tmpPass);
			ss.printDirListing();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
