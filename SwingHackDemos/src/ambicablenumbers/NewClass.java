/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ambicablenumbers;

/**
 *
 * @author Rav
 */
public class NewClass {

    public static void main(String[] args)
{
    int s1, s2;
    //for (int i = 1000000; i < 2000000; i++)
    for(int i=1;i<16384000;i++)
    {
        s1 = FastSum(i);
        s2 = (s1 > i) ? FastSum(s1) : 0;
        if (s2 == i)
            System.out.println(i+"    "+s1);
    }
}

public static int FastSum(int n)
{
    int sum = 1;
    int sqrt = (int)Math.sqrt(n);
    for (int i = 2; i <= 1 + sqrt; i++)
        if (n % i == 0) sum = sum + i + n / i;
            return sum;
}

}
