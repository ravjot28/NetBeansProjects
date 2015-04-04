/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prep;

/**
 *
 * @author Rav
 */
public class Main
{
    public static void main(String[] args) 
    {
        boolean b2=false;
        boolean b1=true;
        System.out.println(b2);
        if ((b2 = true) && b1)
        {
            System.out.println("In if "+b2);
        }
    }

}
