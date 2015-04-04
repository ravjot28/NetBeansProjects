package amicable;
public class NewClass
{

    public static int FastSum(int n)
    {
        int sum = 1;
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= 1 + sqrt; i++)
            if (n % i == 0) sum = sum + i + n / i;
        return sum;
    }

    public static void main(String ap[])
    {
        int s1, s2;
        for (int i = 1; i <=3000000; i++)
        {
            s1 = FastSum(i);
            s2 = (s1 > i) ? FastSum(s1) : 0;
            if (s2 == i)
                System.out.println("Pair --> "+i+","+s1);
        }
    }

}
