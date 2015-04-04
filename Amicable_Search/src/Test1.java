public class Test1 {
    
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

  public static void main(String args[])
  {
      Test1 test = new Test1();
      int a = 1;
        int b = 1000000;
      StopWatch s= new StopWatch();
      s.start();
      for (int i=a; i<=b;i++)
      {
          String res = test.areAmicable(i);
          if (res!=null)
              System.out.println(res);
      }
      s.stop();
      System.out.println("Elapsed Time: "+s.getElapsedTime());
  }
}