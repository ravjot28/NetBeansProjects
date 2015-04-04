import java.util.Random;

/** Generate random integers in a certain range. */
public final class RandomRange
{
    int a[]=new int[100];
    static int count=0;

    public static void main(String asd[])
    {
        new RandomRange().launch(47000,51000);
    }

 public void launch(int s,int l)
 {
     int START = s;
    int END = l;
    Random random = new Random();
    for (int idx = 1; idx <= 100; ++idx){
      showRandomInteger(START, END, random);
    }
for(int i=0;i<100;i++)
{
    System.out.print(a[i]+",");
}
   
  }

  public void showRandomInteger(int aStart, int aEnd, Random aRandom)
  {
    //get the range, casting to long to avoid overflow problems
    long range = (long)aEnd - (long)aStart + 1;
    // compute a fraction of the range, 0 <= frac < range
    long fraction = (long)(range * aRandom.nextDouble());
    a[count]=(int)(fraction + aStart);
    count++;
  }


}
