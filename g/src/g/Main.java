/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package g;

import java.io.IOException;

/**
 *
 * @author Rav
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        String link="http://www.google.com";
        String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler" + " " + link;
        Process p = Runtime.getRuntime().exec(cmd);
    }

}
