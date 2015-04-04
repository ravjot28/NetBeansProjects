package temp;
//Demonstrate URLConnection. 

import java.net.*;
import java.io.*;

public class ServerCheck {

    public static ResponseServerConnection checkServerStatus(String inputURL) throws MalformedURLException, IOException {
        ResponseServerConnection rsc = new ResponseServerConnection(); 
        int status = -1;
        URL url = new URL(inputURL);
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        urlConn.connect();
        /*if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
         status = "UP";
         } else {
         status = "DOWN";
         }*/
        status = urlConn.getResponseCode();
        
        StatusCodeInfo sci = new StatusCodeInfo();
        rsc.setStatus(sci.getStatus(urlConn.getResponseCode()));
        rsc.setCode(status);
        rsc.setConnectionInfo(sci.getStatusCodeInfo(status));

        return rsc;
    }
}
