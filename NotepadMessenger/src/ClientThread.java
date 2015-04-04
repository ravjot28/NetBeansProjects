import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;
import java.io.*;
import javax.print.attribute.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.undo.*;

class ClientThread extends Thread
{
	notepad sc;
	
	public ClientThread(notepad scParam)
	{
		sc=scParam;
	}
	
	public void run()
	{
		Socket echoSocket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		String ipAddress="169.254.214.232";
		
		try
		{
			echoSocket=new Socket(ipAddress,10007);
			out=new PrintWriter(echoSocket.getOutputStream(),true);
			in=new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		}catch(Exception e){JOptionPane.showMessageDialog(sc,"Couldnot get I/O for the connection to: "+ipAddress,"Client",JOptionPane.PLAIN_MESSAGE);return;}
		
		JOptionPane.showMessageDialog(sc,"Communication is now activated","Client",JOptionPane.PLAIN_MESSAGE);
		
		sc.setCommunicationSocket(echoSocket);
		sc.setOutStream(out);
		sc.setInStream(in);
		
		sc.getData();
	}
}