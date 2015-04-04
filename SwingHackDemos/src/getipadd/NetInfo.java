/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package getipadd;

public class NetInfo {
 public static void main(String[] args) {
    new NetInfo().say();
    }

 public void say() {
   try {
   java.net.InetAddress i = java.net.InetAddress.getLocalHost();
   System.out.println(i);                  // name and IP address
   System.out.println(i.getHostName());    // name
   System.out.println(i.getHostAddress()); // IP address only
   }
   catch(Exception e){e.printStackTrace();}
 }
}