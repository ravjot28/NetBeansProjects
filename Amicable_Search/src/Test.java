public class Test
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
                System.out.println("("+i+","+s1+")");
            }
        }
        s.stop();
        return (s.getElapsedTime());
    }

    private int FastSum(int n)
    {
        int sum = 1;
        int sqrt = (int)Math.sqrt(n);

        for (int i = 2; i <= 1 + sqrt; i++)
            if (n % i == 0)
                sum = sum + i + n / i;
        return sum;
    }

    public static void main(String args[])
    {
        Test t = new Test();
        int a = 1;
        int b = 10000000;
        System.out.println("Time Elapsed: "+t.process(a,b));
    }
}