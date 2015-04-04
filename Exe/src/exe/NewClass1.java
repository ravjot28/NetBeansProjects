/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exe;

import java.io.IOException;

/**
 *
 * @author Rav
 */
public class NewClass1 {
    public static void main(String args[]) throws IOException
    {
        String cmd = "rundll32" + " " + "url.dll,FileProtocolHandler" + " D:\\Softwares\\Softwares";
                                        System.out.println(cmd);
                                        Process p = Runtime.getRuntime().exec(cmd);
    }

}
