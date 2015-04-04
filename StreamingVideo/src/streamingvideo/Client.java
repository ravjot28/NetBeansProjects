package streamingvideo;


/* ------------------
   Client v3.1
   usage: java Client [Server hostname] [Server RTSP listening port] [Video file requested]
   ---------------------- */

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class Client{

  //GUI
  //----
  JFrame f = new JFrame("Client v4");
  JButton setupButton = new JButton("Connect");
  JButton playButton = new JButton("Play");
  JButton pauseButton = new JButton("Pause");
  JButton tearButton = new JButton("Teardown");
  JPanel mainPanel = new JPanel();
  JPanel infoPanel = new JPanel();
 
  JPanel statPanel = new JPanel();
  JPanel buttonPanel = new JPanel();
  JLabel iconLabel = new JLabel();
      //add label for host
  JLabel hostLabel = new JLabel("Server");
  
  //add text field for server hostname
  JTextField hostname=new JTextField("healy.ece.orst.edu");  
      //add label for port
  JLabel portLabel = new JLabel("Port");
  
  //add text field for server port
  JTextField portnb=new JTextField("2000");  
 //add label for file
  JLabel vLabel = new JLabel("File");
  
 //add text field for file
  JTextField vfile=new JTextField("movie.Mjpeg");  
  ImageIcon icon;
      JLabel countpkt= new JLabel("Statistics");
    JLabel status= new JLabel("Status"); 


  //RTP variables:
  //----------------
  DatagramPacket rcvdp; //UDP packet received from the server
  static DatagramSocket RTPsocket; //socket to be used to send and receive UDP packets
  static int RTP_RCV_PORT = 25000; //port where the client will receive the RTP packets
  
  Timer timer; //timer used to receive data from the UDP socket
  byte[] buf; //buffer used to store data received from the server 
    static int countpk=0;
 
  //RTSP variables
  //----------------
  //rtsp states
    static String value="idle"; 
  final static int INIT = 0;
  final static int READY = 1;
  final static int PLAYING = 2;
  static int state; //RTSP state == INIT or READY or PLAYING
  Socket RTSPsocket; //socket used to send/receive RTSP messages
  //input and output stream filters
  static BufferedReader RTSPBufferedReader;
  static BufferedWriter RTSPBufferedWriter;
  static String VideoFileName; //video file to request to the server
  static int RTSPSeqNb = 0; //Sequence number of RTSP messages within the session
  int RTSPid = 0; //ID of the RTSP session (given by the RTSP Server)
  final static String CRLF = "\r\n";
  static   int setupstage= 0;
    static int sizem;
    static int tc=1;
    static int dt=1;

  //Video constants:
  //------------------
  static int MJPEG_TYPE = 26; //RTP payload type for MJPEG video
 
  //--------------------------
  //Constructor
  //--------------------------
  public Client() {

    //build GUI
    //--------------------------
 
    //Frame
    f.addWindowListener(new WindowAdapter() {
       public void windowClosing(WindowEvent e) {
	 System.exit(0);
       }
    });
	//Infos and settings

	// add hostname textbox and label
	infoPanel.add(hostLabel);
	infoPanel.add(hostname);
	infoPanel.add(portLabel);
	infoPanel.add(portnb);
	infoPanel.add(vLabel);
	infoPanel.add(vfile);
	statPanel.add(status);
	statPanel.add(countpkt);

	    // Tool Tip text
	statPanel.setToolTipText("Streaming Statistics: video bandwidth streaming usage: average and peak");
	portnb.setToolTipText("Enter Server port number");
	hostname.setToolTipText("Enter Server address: Ip address XXX.XXX.XXX.XXX or server name (ex: healy.ece.orst.edu)");
	vfile.setToolTipText("Enter MJPEG file name");	
	portLabel.setToolTipText("Enter Server port number");
	hostLabel.setToolTipText("Enter Server address: Ip address XXX.XXX.XXX.XXX or server name (ex: healy.ece.orst.edu)");
	vLabel.setToolTipText("Enter MJPEG file name");
	tearButton.setToolTipText("Break the connection and close the program");

    //Buttons
    buttonPanel.setLayout(new GridLayout(1,0));
    infoPanel.add(setupButton);
    buttonPanel.add(playButton);
    buttonPanel.add(pauseButton);
    buttonPanel.add(tearButton);
    setupButton.addActionListener(new setupButtonListener());
    playButton.addActionListener(new playButtonListener());
    pauseButton.addActionListener(new pauseButtonListener());
    tearButton.addActionListener(new tearButtonListener());

    //Image display label
    iconLabel.setIcon(null);
    
    //frame layout
    mainPanel.setLayout(null);
    mainPanel.add(infoPanel);	
    mainPanel.add(statPanel);
    mainPanel.add(iconLabel);
    mainPanel.add(buttonPanel);
    infoPanel.setBounds(0,0,440,30);
    iconLabel.setBounds(20,35,380,280);
    buttonPanel.setBounds(0,320,440,50);
    statPanel.setBounds(20,370,380,20);

    f.getContentPane().add(mainPanel, BorderLayout.CENTER);
    f.setSize(new Dimension(450,420));
    f.setVisible(true);

    //init timer
    //--------------------------
    timer = new Timer(20, new timerListener());
    timer.setInitialDelay(0);
    timer.setCoalesce(true);

    //allocate enough memory for the buffer used to receive data from the server
    buf = new byte[15000];    
  }

  //------------------------------------
  //main
  //------------------------------------
  public static void main(String argv[]) throws Exception
  {
    //Create a Client object
    Client theClient = new Client();

     theClient.mainPanel.setToolTipText("Enter Server parameters,filename and press Connect");	

	do{
	    state=-1;
	}while (setupstage==0);
	
    //get server RTSP port and IP address from the command line
    //------------------
    int RTSP_server_port = Integer.parseInt(theClient.portnb.getText());//Integer.parseInt(argv[1]);
    String ServerHost = theClient.hostname.getText();
    InetAddress ServerIPAddr = InetAddress.getByName(ServerHost);

    //get video filename to request:
    VideoFileName = theClient.vfile.getText();
    

//Establish a TCP connection with the server to exchange RTSP messages
    //------------------
    theClient.RTSPsocket = new Socket(ServerIPAddr,RTSP_server_port);

  System.out.println("Create Socket !");  
    //Set input and output stream filters:
    RTSPBufferedReader = new BufferedReader(new InputStreamReader(theClient.RTSPsocket.getInputStream()) );
    RTSPBufferedWriter = new BufferedWriter(new OutputStreamWriter(theClient.RTSPsocket.getOutputStream()) );

   
    //init RTSP state:
    state = INIT;
    theClient.mainPanel.setToolTipText("Connection successful, ready to start playing");	


	  //Init non-blocking RTPsocket that will be used to receive data
	      System.out.println("INIT state");
 
	  try{
	    //construct a new DatagramSocket to receive RTP packets from the server, on port RTP_RCV_PORT
	      RTPsocket =new DatagramSocket(RTP_RCV_PORT);

	    //set TimeOut value of the socket to 5msec.
	      RTPsocket.setSoTimeout(5);
	  

	  }
	  catch (SocketException se)
	    {
	      System.out.println("Socket exception: "+se);
	      System.exit(0);
	    }
	
	
	  //init RTSP sequence number
	  RTSPSeqNb = 1;
	 
	  //Send SETUP message to the server
	  
	  theClient.send_RTSP_request("SETUP");
	  theClient.send_RTSP_request("DESCRIBE");

	  //Wait for the response 
	  if (theClient.parse_server_response() != 200)
	    System.out.println("Invalid Server Response");
	  else 
	    {
	      //change RTSP state and print new state 
		state = READY;
	      System.out.println("New RTSP state: READY");
	    }


  }


  //------------------------------------
  //Handler for buttons
  //------------------------------------


  //Handler for Setup button
  //-----------------------
  class setupButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){

    
   
      System.out.println("Setup Button pressed !");
      setupstage++;
      countpk=0;
      setupButton.setText("OK");

      // if (state == INIT) 
      //{
      //	}//else if state != INIT then do nothing but change label
     
    }
  }
  
  //Handler for Play button
  //-----------------------
  class playButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e){

      //System.out.println("Play Button pressed !"); 

      if (state == READY) 
	{
	  //increase RTSP sequence number
	    RTSPSeqNb++;


	  //Send PLAY message to the server
	  send_RTSP_request("PLAY");

	  //Wait for the response 
	  if (parse_server_response() != 200)
		  System.out.println("Invalid Server Response");
	  else 
	    {
	      //change RTSP state and print out new state
		state= PLAYING;
		System.out.println("New RTSP state:PLAYING");

	      //start the timer
	      timer.start();
	    }
	}//else if state != READY then do nothing
    }
  }


  //Handler for Pause button
  //-----------------------
  class pauseButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e){

      //System.out.println("Pause Button pressed !");   

      if (state == PLAYING) 
	{
	  //increase RTSP sequence number
	    RTSPSeqNb ++;

	  //Send PAUSE message to the server
	  send_RTSP_request("PAUSE");
	
	  //Wait for the response 
	 if (parse_server_response() != 200)
		  System.out.println("Invalid Server Response");
	  else 
	    {
	      //change RTSP state and print out new state
		state= READY;
	      System.out.println("New RTSP state:READY");
	      
	      //stop the timer
	      timer.stop();
	    }
	}
      //else if state != PLAYING then do nothing
    }
  }

  //Handler for Teardown button
  //-----------------------
  class tearButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e){

      //System.out.println("Teardown Button pressed !");  

      //increase RTSP sequence number
	RTSPSeqNb ++;
      

      //Send TEARDOWN message to the server
      send_RTSP_request("TEARDOWN");

      //Wait for the response 
      if (parse_server_response() != 200)
	System.out.println("Invalid Server Response");
      else 
	{     
	  //change RTSP state and print out new state
	    state=INIT;
	  System.out.println("New RTSP state:INIT");

	  //stop the timer
	  timer.stop();

	  //exit
	  System.exit(0);
	}
    }
  }


  //------------------------------------
  //Handler for timer
  //------------------------------------
  
  class timerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      
      //Construct a DatagramPacket to receive data from the UDP socket
      rcvdp = new DatagramPacket(buf, buf.length);
	

      try{
	//receive the DP from the socket:
	RTPsocket.receive(rcvdp);

	  
	//create an RTPpacket object from the DP
	RTPpacket rtp_packet = new RTPpacket(rcvdp.getData(), rcvdp.getLength());

	    //print total packet loss
	sizem=sizem+rtp_packet.getpayload_length();
	dt=tc-rtp_packet.gettimestamp();
	tc=rtp_packet.gettimestamp();

	countpkt.setText(" Transmission rate: "+(sizem/tc)+" KB/s - Burst rate: "+(rtp_packet.getpayload_length()/(-dt))+ "KB/s");
   

	switch (state)
	    {
	case 0:
	    value="INIT";
	    break;
	case 1:
	    value="READY";
	    break;
	case 2:
	    value="PLAYING";
	    break;
	default:
	    value="IDLE";
	    }
	status.setText(value);

	//print important header fields of the RTP packet received: 
	System.out.println("Got RTP packet with SeqNum # "+rtp_packet.getsequencenumber()+" TimeStamp "+rtp_packet.gettimestamp()+" ms, of type "+rtp_packet.getpayloadtype());
	
	//print header bitstream:
	rtp_packet.printheader();

	//get the payload bitstream from the RTPpacket object
	int payload_length = rtp_packet.getpayload_length();
	byte [] payload = new byte[payload_length];
	rtp_packet.getpayload(payload);

	//get an Image object from the payload bitstream
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Image image = toolkit.createImage(payload, 0, payload_length);
	
	//display the image as an ImageIcon object
	icon = new ImageIcon(image);
	iconLabel.setIcon(icon);
      }
      catch (InterruptedIOException iioe){
	//System.out.println("Nothing to read");
      }
      catch (IOException ioe) {
	System.out.println("Exception caught: "+ioe);
      }
    }
  }

  //------------------------------------
  //Parse Server Response
  //------------------------------------
  private int parse_server_response() 
  {
    int reply_code = 0;

    try{
      //parse status line and extract the reply_code:
      String StatusLine = RTSPBufferedReader.readLine();
      //System.out.println("RTSP Client - Received from Server:");
      System.out.println(StatusLine);
 
    
      StringTokenizer tokens = new StringTokenizer(StatusLine);
      tokens.nextToken(); //skip over the RTSP version
      reply_code = Integer.parseInt(tokens.nextToken());
      
      //if reply code is OK get and print the 2 other lines
      if (reply_code == 200)
	{
	  String SeqNumLine = RTSPBufferedReader.readLine();
	  System.out.println(SeqNumLine);
	  
	  String SessionLine = RTSPBufferedReader.readLine();
	  System.out.println(SessionLine);
	
	  //if state == INIT gets the Session Id from the SessionLine
	  tokens = new StringTokenizer(SessionLine);
	  tokens.nextToken(); //skip over the Session:
	  RTSPid = Integer.parseInt(tokens.nextToken());
	}
    }
    catch(Exception ex)
      {
	System.out.println("Exception caught: "+ex);
	System.exit(0);
      }
    
    return(reply_code);
  }

  //------------------------------------
  //Send RTSP Request
  //------------------------------------

  //.............
  //TO COMPLETE
  //.............
  
  private void send_RTSP_request(String request_type)
  {
    try{
      //Use the RTSPBufferedWriter to write to the RTSP socket

      //write the request line:
      RTSPBufferedWriter.write(request_type+" "+VideoFileName+" "+"RTSP/1.0"+CRLF);

      //write the CSeq line: 
      RTSPBufferedWriter.write("Cseq: "+RTSPSeqNb+CRLF);

      //check if request_type is equal to "SETUP" and in this case write the Transport: line advertising to the server the port used to receive the RTP packets RTP_RCV_PORT
      if (state == INIT) 
	  {
	      RTSPBufferedWriter.write("TRANSPORT: RTP/UDP; client_port= "+RTP_RCV_PORT+CRLF);
	  }
      //otherwise, write the Session line from the RTSPid field
	  else {
	      RTSPBufferedWriter.write("Session: "+RTSPid+CRLF);
	  }
	      RTSPBufferedWriter.flush();
	  
    }
    catch(Exception ex)
      {
	System.out.println("Exception caught: "+ex);
	System.exit(0);
      }
  }

}//end of Class Client

