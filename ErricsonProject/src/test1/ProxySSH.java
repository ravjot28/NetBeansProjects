package test1;

import java.net.Socket;
import java.io.*;

import com.jcraft.jsch.*;

public class ProxySSH implements Proxy {

  public ProxySSH(Session gateway) {
    this.gateway = gateway;
  }

  private Session gateway;


  private ChannelDirectTCPIP channel;
  private InputStream iStream;
  private OutputStream oStream;

  
  public void close() {
    channel.disconnect();
  }

  public void connect(SocketFactory ignore, String host,
                      int port, int timeout)
    throws Exception
  {
    channel = (ChannelDirectTCPIP)gateway.openChannel("direct-tcpip");
    channel.setHost(host);
    channel.setPort(port);
    
    iStream = channel.getInputStream();
    oStream = channel.getOutputStream();
    channel.connect();
  }
  
  public InputStream getInputStream()
  {
    return iStream;
  }

  public OutputStream getOutputStream()
  {
    return oStream;
  }

  public Socket getSocket() {
    return null;
  }

}
