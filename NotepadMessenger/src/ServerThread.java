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

class ServerThread extends Thread
{
	notepad sc;
	JTextField display;
	
	public ServerThread(notepad scParam)
	{
		sc=scParam;
	}
	
	public void run()
	{
		ServerSocket connectionSocket=null;
		
		try
		{
			connectionSocket=new ServerSocket(10007);
		}catch(Exception e){JOptionPane.showMessageDialog(sc,"Could not listen on port: 10007","Server",JOptionPane.PLAIN_MESSAGE);return;}
		
		JOptionPane.showMessageDialog(sc,"Server Socket is now activated","Server",JOptionPane.PLAIN_MESSAGE);
		
		Socket communicationSocket=null;
		
		try
		{
			communicationSocket=connectionSocket.accept();
		}catch(Exception e){JOptionPane.showMessageDialog(sc,"Accept failed","Server",JOptionPane.PLAIN_MESSAGE);return;}
		
		JOptionPane.showMessageDialog(sc,"Communication is now activated","Server",JOptionPane.PLAIN_MESSAGE);
		
		try
		{
			PrintWriter out=new PrintWriter(communicationSocket.getOutputStream(),true);
			BufferedReader in=new BufferedReader(new InputStreamReader(communicationSocket.getInputStream()));
			
			sc.setCommunicationSocket(communicationSocket);
			sc.setOutStream(out);
			sc.setInStream(in);
			
			sc.getData();
		}catch(Exception e){JOptionPane.showMessageDialog(sc,"Creation of Input/Output Streams failed","Server",JOptionPane.PLAIN_MESSAGE);return;}
	}
}