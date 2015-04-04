package myformula;

/*
if p,q,r are prime numbers then  are amicable numbers.

E.g. :
	n=2
		3*(2^2 - 1) = 11    3*(2^2 -1) = 5     9*(2^(4-1) - 1) = 71

2^2(3*2^2-1)*(3*2^(2-1)-1) = 220            2^2*(9*2^(4-1)-1) = 284
 */
public class Main 
{
    public int getP(int n)
    {
        //System.out.println("N value "+n+"  P value "+(int) (3*(Math.pow(2, (n-1))-1)));
        return (int) (3*(Math.pow(2, (n-1))))-1;  //p = 3 x (2^(n-1) - 1)
    }

    public int getQ(int n)
    {
        //System.out.println("N value "+n+"  Q value "+(int) (3*(Math.pow(2, n)-1)));
        return (int) (3*(Math.pow(2, n)))-1;  //q = 3 x (2^(n) - 1)
    }

    public int getR(int n)
    {
        //System.out.println("N value "+n+"  R value "+(int) (9*(Math.pow(2, ((2*n)-1))-1)));
        return (int) (9*(Math.pow(2, ((2*n)-1))))-1;  //r = 9 x (2^(2n-1) - 1)
    }

    public int[] getPairs(int n)
    {
         int p[] = new int[2];
         p[0] = (int) (Math.pow(2, n) * getP(n) * getQ(n));     //(2^(n) * p * q)
         p[1] = (int) (Math.pow(2, n) * getR(n));     //(2^(n) * r)
         return p;
    }

    boolean isPrime(int n)
    {
        for(int i=2;i<n;i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public void startFinding(int start,int end)
    {
        for(int i=2;i<999999999;i++)
        {
            if(isPrime((int) getP(i)))
            {
                if(isPrime((int) getQ(i)))
                {
                    if(isPrime((int)getR(i)))
                    {
                        int result[]=getPairs(i);
                        System.out.println(result[0]+"  "+result[1]);
                    }
                }
            }
        }
    }

    public static void main(String s[])
    {
        Main m = new Main();
        m.startFinding(1, 1);
    }
}
