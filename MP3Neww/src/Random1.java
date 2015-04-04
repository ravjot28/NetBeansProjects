import java.util.Random;

public final class Random1
{
int p[];
  public int[] m(int n)
  {
      int p[]=new int[n];
    for (int idx = 0; idx <n; idx++)
    {
       do
       {
            p[idx]=new Random().nextInt(n);
       }while(doesExists(p[idx],p,idx));
    }
      return p;
  }

  private static boolean doesExists(int rand, int[] arr, int i)
	{
		if( i != 0)
		{
			for(int j = 0; j < i; j++)
			{
				if(rand == arr[j])
					return true;
			}
		}
		return false;
	}
}