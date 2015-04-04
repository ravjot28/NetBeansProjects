import com.jscape.inet.ssh.*;
import com.jscape.inet.ssh.util.SshParameters;
import java.io.*;

public class SshTest implements SshListener {

	private boolean connected = false;

	public SshTest() {
		String hostname = null;
		String username = null;
		String password = null;
		Ssh ssh = null;

		try {
			BufferedReader bin =
				new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter SSH hostname: ");
			hostname = bin.readLine();

			System.out.print("Enter SSH username: ");
			username = bin.readLine();

			System.out.print("Enter SSH password: ");
			password = bin.readLine();

			SshParameters sshParams = new SshParameters(hostname,username,password);
			ssh = new Ssh(sshParams);

			ssh.addSshListener(this);

			System.out.println("Connecting please wait...");

			ssh.connect();

			OutputStream out = ssh.getOutputStream();

			String line = null;

			while (connected && (line = bin.readLine()) != null) {
				line += "\n";
				try {
				  out.write(line.getBytes());
				  out.flush();
				} catch(Exception ioe){
				  connected = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(connected) {
				  ssh.disconnect();
				}
			} catch(Exception e) {

			}
		}
	}

	public void connected(SshConnectedEvent ev) {
		System.out.println("Connected: " + ev.getHost());
		connected = true;
	}

	public void dataReceived(SshDataReceivedEvent ev) {
		System.out.print(ev.getData());
	}

	public void disconnected(SshDisconnectedEvent ev) {
		System.out.println("Disconnected: " + ev.getHost() + ". Press Enter to exit");
		connected = false;
	}

	public static void main(String[] args) {
		SshTest test = new SshTest();
	}

}
