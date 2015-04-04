package messenger;

import java.io.*;
import java.net.*;

public class MessengerMainServer {

    ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;

    MessengerMainServer() {
    }

    void run() {
        try {
            providerSocket = new ServerSocket(5000);
            connection = providerSocket.accept();
            out = new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            in = new ObjectInputStream(connection.getInputStream());
           
            out.writeObject("Yes Ravjot also hates Ronaldo");
            out.flush();


            System.out.println("client " + (String) in.readObject());
        }catch (Exception ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                providerSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        MessengerMainServer server = new MessengerMainServer();
        
            server.run();
        
    }
}


