/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author Rav
 */
public class Main {

    public static void main(String as[]) {

        CSVWriter csv = new CSVWriter();
        String message[] = new String[4];
        String information[] = new String[4];
        String name[] = {"GOA", "GOB", "GOC", "GOD"};
        String urlList[][] = {
            {"http://sbx-ci-goa.sap.astrazeneca.net:51000/rep/start/repository.jnlp", "http://sbx-ci-goa.sap.astrazeneca.net:51000/dir/start/directory.jnlp", "http://pisbx.sap.astrazeneca.net:51000/sld/index.html", "http://sbx-ci-goa.sap.astrazeneca.net:51000/dir/start/index.jsp"},
            {"http://pidev.sap.astrazeneca.net:50000/rep/start/repository.jnlp", "http://pidev.sap.astrazeneca.net:50000/dir/start/directory.jnlp", "http://pidev.sap.astrazeneca.net:50000/sld/index.html", "http://pidev.sap.astrazeneca.net:50000/dir/start/index.jsp"},
            {"http://pippd.sap.astrazeneca.net:8880/rep/start/repository.jnlp", "http://pippd.sap.astrazeneca.net:8880/dir/start/directory.jnlp", "http://pidev.sap.astrazeneca.net:50000/sld/index.html", "http://pippd.sap.astrazeneca.net:8880/dir/start/index.jsp"},
            {"http://piprod.sap.astrazeneca.net:8880/rep/start/repository.jnlp", "http://piprod.sap.astrazeneca.net:8880/dir/start/directory.jnlp", "http://piprod.sap.astrazeneca.net:8880/sld/index.html", "http://piprod.sap.astrazeneca.net:8880/dir/start/index.jsp"}};

        int j = 0;
        for (int i = 0; i < name.length; i++) {
            for (j = 0; j < urlList[i].length; j++) {
                try {
                    ResponseServerConnection rsc = ServerCheck.checkServerStatus(urlList[i][j]);
                    message[j] = rsc.getStatus();
                    information[j] = rsc.getConnectionInfo();
                } catch (MalformedURLException e) {
                    message[j] = "Not Reachable";
                    information[j] ="Issue at Client Side (Network not connected or internet not working)";
                } catch (IOException e) {
                    message[j] = "Error creating HTTP connection";
                    information[j] ="Issue at Client Side (Network not connected or internet not working)";
                    System.err.println("Error creating HTTP connection");
                } catch (Exception e) {
                    message[j] = "Error creating HTTP connection";
                    information[j] ="Issue at Client Side (Network not connected or internet not working)";
                    System.err.println("Error creating HTTP connection");
                }
            }
            csv.handleMessage(name[i], urlList[i][j-1], message, information);
        }
    }
}
