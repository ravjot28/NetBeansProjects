/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package checkinternetconnecction;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Rav
 */
public class NewClass1 {
    public static void main(String asp[])
    {
        System.setProperty("sun.net.inetaddr.ttl", "0");
        try
        {
            InetAddress addr = InetAddress.getByName( "http://www.ravjot.blog.co.in" );
            System.out.println("Online");
        }
        catch( UnknownHostException ex )
        {
            System.out.println( "offline" );
        }
    }

}
