interface MinMax<R extends Comparable<R>> {
  R min();
  R max();
}

class MyClass<R extends Comparable<R>> implements MinMax<R> {
  R[] vals;

  MyClass(R[] o) { vals = o; }

  public R min() {
    R v = vals[0];
    for(int i=1; i < vals.length; i++)
      if(vals[i].compareTo(v) < 0) v = vals[i];

    return v;
  }

  public R max() {
    R v = vals[0];

    for(int i=1; i < vals.length; i++)
      if(vals[i].compareTo(v) > 0) v = vals[i];

    return v;
  }
}

public class rav {
  public static void main(String args[]) 
  {
     Integer inums[] = {3, 6, 2, 8, 6 };
    Character chs[] = {'b', 'r', 'p', 'w' };

    MyClass<Integer> iob = new MyClass<Integer>(inums);
    MyClass<Character> cob = new MyClass<Character>(chs);

    System.out.println("Max value in inums: " + iob.max());
    System.out.println("Min value in inums: " + iob.min());

    System.out.println("Max value in chs: " + cob.max());
    System.out.println("Min value in chs: " + cob.min());
  }
}
