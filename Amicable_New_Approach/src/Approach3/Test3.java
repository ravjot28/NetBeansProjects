package Approach3;

import Support.StopWatch;

public class Test3 {
    
  int duplicates = 0;

  public int findAddFactors(int num)
  {
    int factorSum = 1;
    for (int i=2; i<=(num /2); i++)
    {
      if ((num%i)==0)
	factorSum+=i;
    }
    return factorSum;
  }
  
  public String areAmicable(int num)
  {
    if (num!=duplicates)
    {
      int pair1 = findAddFactors(num);
      int pair2 = findAddFactors(pair1);
      if ((num==pair2) && (pair1!=pair2))
      {
	duplicates = pair1;
	return "("+pair2+","+pair1+")";
      }
      else
	return null;
    }
    else
      return null;
  }

  public Test3(int initial,int last)
  {
      StopWatch s= new StopWatch();
      s.start();
      for (int i=initial; i<=last;i++)
      {
          String res = areAmicable(i);
          //if (res!=null)
              //System.out.println(res);
      }
      s.stop();
      System.out.println("Approach3: "+s.getElapsedTime());
  }
}
