package messenger;

import java.io.*;
import java.net.*;

public class MessengerMainClient {

    Socket requestSocket = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;

    MessengerMainClient() {
    }

    void run() {
        try {
            requestSocket = new Socket("localhost", 5000);
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(requestSocket.getInputStream());
            
                message = (String) in.readObject();
                System.out.println("server " + message);
                out.writeObject("Puneeet hates Ronaldo");
                out.flush();
            } catch (Exception ee) {
                
            } finally {
            try {
                in.close();
                out.close();
                requestSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        MessengerMainClient server = new MessengerMainClient();
        
            server.run();
        
    }
}
