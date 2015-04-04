import java.util.*;
 class NewClass1{
 public int i;
 public NewClass1(int i) { this.i = i; }
 public boolean equals(Object o) { return i == ((NewClass1)o).i; }
 public int hashCode() { return i; }
 }
 public class NewClass {
 public static void main(String[] args) {
 Set<NewClass1> set = new HashSet<NewClass1>();
 NewClass1 k1 = new NewClass1(1);
 NewClass1 k2 = new NewClass1(2);
 set.add(k1); set.add(k1);
 set.add(k2); set.add(k2);

 System.out.print(set.size() + " "+"("+set+")");
 k2.i = 1;
 System.out.print(set.size() + " "+"("+set+")");
 set.remove(k1);
 System.out.print(set.size() + " "+"("+set+")");
 set.remove(k2);
 System.out.print(set.size() + " "+"("+set+")");
 set.remove(k2);
  System.out.print(set.size() + " "+"("+set+")");
 }
 }