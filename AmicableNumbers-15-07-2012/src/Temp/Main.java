package Temp;

import Support.StopWatch;

public class Main
{
    public long process(int a,int b)
    {
        StopWatch s= new StopWatch();
        s.start();

        int s1, s2;

        for (int i = a; i <b; i++)
        {
            s1 = FastSum(i);
            s2 = (s1 > i) ? FastSum(s1) : 0;
            if (s2 == i)
            {
                //System.out.println("("+i+","+s1+")");
            }
        }
        s.stop();
        return (s.getElapsedTime());
    }

    private static int FastSum(int n)
    {
        int sum = 1;
        int sum1 = 1;
        System.out.println("Number is "+n);
        int sqrt = (int)Math.sqrt(n);

        for (int i = 2; i <= 1 + sqrt; i++){
            if (n % i == 0){
                int a = i;
                int b = n/i;
                sum = sum + a + b;
                System.out.println("Factors of "+n+" "+a+"  "+b);
                System.out.println("Factors of "+n*2+" "+a+"  "+b);
                System.out.println("Factors of "+n*2+" "+((n*2)/a)+"  "+((n*2)/b));
            }
        }
        if(n%2 != 0){
            System.out.println("Factors of "+n*2+" 2");
            System.out.println("Factors of "+n*2+" "+n);
        }
        System.out.println();
        System.out.println("Sum: "+sum);
        return sum;
    }

    public Main(int initial,int last)
    {
        System.out.println("Approach1: "+process(initial,last));
    }

    public static void main(String as[]){
        FastSum(1234567);
    }
}