
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rav
 */
public class NewClass {

    public static void main(String as[]){
        String rav = "hpsmhd            13132   73300   18720   12140   18100   119118    216  125";
        rav = rav.replaceAll("\\s+", " ");
        StringTokenizer s = new StringTokenizer(rav," ");
        while(s.hasMoreElements()){
            System.out.println(s.nextElement());
        }
    }

}
