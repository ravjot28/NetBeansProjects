package Main;

import java.util.ArrayList;

public class Process {

    DS d1;

    private void getSumOfFactorsEven(int number, int limit) {
        //System.out.println("In even "+number+"  "+number*2);
        ArrayList sum = new ArrayList();
        int temp = 1;
        int temp1 = 1;
        int size = (int) Math.sqrt(number) + 1;
        //System.out.print(temp + " ");
        ArrayList s;
        if ((number * 2) <= limit) {
            s = new ArrayList();
            s.add(temp);
            for (int i = 2; i < size; i++) {
                if ((number % i) == 0) {
                    //System.out.print(i + " " + (number / i) + " ");
                    if (i != (number / i)) {
                        if (((number * 2) % i) == 0 && !s.contains(i)) {
                            temp1 += i;
                            s.add(i);
                        }
                        if (!s.contains(i * 2)) {
                            temp1 += i * 2;
                            s.add(i * 2);
                        }
                        if (number % i == 0 && !s.contains(number / i)) {
                            temp1 += (number / i);
                            s.add((number / i));
                        }
                        if ((number % i * 2) == 0 && !s.contains((number / i * 2))) {
                            temp1 += (number / i * 2);
                            s.add((number / i * 2));
                        }
                        if (number % i == 0 && !s.contains((number / i) * 2)) {
                            temp1 += (number / i) * 2;
                            s.add((number / i) * 2);
                        }
                        if (i % 2 == 0 && !s.contains(i / 2)) {
                            temp1 += i / 2;
                            s.add(i / 2);
                        }
                        temp = temp + i + number / i;
                    } else {
                        if (((number * 2) % i) == 0 && !s.contains(i)) {
                            temp1 += i;
                            s.add(i);
                        }
                        if (!s.contains(i * 2)) {
                            temp1 += i * 2;
                            s.add(i * 2);
                        }
                        if (i % 2 == 0 && !s.contains(i / 2)) {
                            temp1 += i / 2;
                            s.add(i / 2);
                        }
                        temp = temp + i;
                    }
                }
            }
            //sum.add(temp);
            //sum.add(temp1);
            d1.addValue(number,temp);
            d1.addValue((number*2),temp1);
            //System.out.println("Factors: "+(number*2)+" are "+temp1+"  "+s);
            //System.out.println("Factors: "+number+" are "+temp);
        } else {
            for (int i = 2; i < size; i++) {
                if ((number % i) == 0) {
                    //System.out.print(i + " " + (number / i) + " ");
                    if (i != (number / i)) {
                        temp = temp + i + number / i;
                    } else {
                        temp = temp + i;
                    }
                }
            }
            //sum.add(temp);
            d1.addValue(number,temp);
        }
    }

    public static void main(String sa[]){
        new Process().getSumOfFactorsEven(101,200);
    }
    private void getSumOfFactorsOdd(int number, int limit) {
        //System.out.println("In odd "+number+"  "+number*2);
        ArrayList sum = new ArrayList();
        int temp = 1;
        int temp1 = 1;
        int size = (int) Math.sqrt(number) + 1;
        //System.out.print(temp + " ");
        ArrayList s;
        if ((number * 2) <= limit) {
            s = new ArrayList();
            s.add(temp);
            s.add(number);
            s.add(2);
            temp1 += number;
            temp1 += 2;
            for (int i = 2; i < size; i++) {
                if ((number % i) == 0) {
                    //System.out.print(i + " " + (number / i) + " ");
                    if (i != (number / i)) {
                        if (((number * 2) % i) == 0 && !s.contains(i)) {
                            temp1 += i;
                            s.add(i);
                        }
                        if (!s.contains(i * 2)) {
                            temp1 += (i * 2);
                            s.add(i * 2);
                        }
                        if (number % i == 0 && !s.contains(number / i)) {
                            temp1 += (number / i);
                            s.add((number / i));
                        }
                        if ((number % i * 2) == 0 && !s.contains((number / i * 2))) {
                            temp1 += (number / i * 2);
                            s.add((number / i * 2));
                        }
                        if (number % i == 0 && !s.contains((number / i) * 2)) {
                            temp1 += (number / i) * 2;
                            s.add((number / i) * 2);
                        }
                        if (i % 2 == 0 && !s.contains(i / 2)) {
                            temp1 += i / 2;
                            s.add(i / 2);
                        }
                        temp = temp + i + number / i;
                    } else {
                        if (((number * 2) % i) == 0 && !s.contains(i)) {
                            temp1 += i;
                            s.add(i);
                        }
                        if (!s.contains(i * 2)) {
                            temp1 += i * 2;
                            s.add(i * 2);
                        }
                        if (i % 2 == 0 && !s.contains(i / 2)) {
                            temp1 += i / 2;
                            s.add(i / 2);
                        }
                        temp = temp + i;
                    }
                }
            }

            if (temp != 1) {
                //System.out.println("Factors: "+(number*2)+" are "+temp1+" "+s);
                //sum.add(temp);
                //sum.add(temp1);
                d1.addValue(number,temp);
                d1.addValue((number*2),temp1);
                //System.out.println("In if "+temp1);

                //System.out.println("Factors: "+number+" are "+temp);
            } else {
                //System.out.println("In else "+temp1);
                //sum.add(temp);
                //sum.add(temp1);
                d1.addValue(number,temp);
                d1.addValue((number*2),temp1);
            }
        } else {
            for (int i = 2; i < size; i++) {
                if ((number % i) == 0) {
                    //System.out.print(i + " " + (number / i) + " ");
                    if (i != (number / i)) {
                        temp = temp + i + number / i;
                    } else {
                        temp = temp + i;
                    }
                }
            }
            if (temp != 1) {
                //sum.add(temp);
                d1.addValue(number,temp);
                //System.out.println("Factors: "+number+" are "+temp);
            }
        }
    }

    /*public static void begin(int inital, int last, DS d) {
        Process p = new Process();
        ArrayList<Integer> sums;
        for (int i = inital; i <= last; i++) {
            if (!d1.isPresent(i)) {
                if (i % 2 == 0) {
                    sums = p.getSumOfFactorsEven(i, last);
                    if (sums.size() == 2) {
                        d1.addValue(i, sums.get(0));
                        d1.addValue(i * 2, sums.get(1));
                        if (d1.getValue(d1.getValue(i)) > 1 && d1.getValue(d1.getValue(i)) == i && d1.getValue(i) != i) {
                            //System.out.println(i + " " + d1.getValue(i));
                        }
                        if (d1.getValue(d1.getValue(i * 2)) > 1 && d1.getValue(d1.getValue(i * 2)) == i * 2 && d1.getValue(i * 2) != i * 2) {
                            //System.out.println(i * 2 + " " + d1.getValue(i * 2));
                        }
                    } else {
                        d1.addValue(i, sums.get(0));
                        if (d1.getValue(d1.getValue(i)) > 1 && d1.getValue(d1.getValue(i)) == i && d1.getValue(i) != i) {
                            //System.out.println(i + " " + d1.getValue(i));
                        }
                    }
                } else {
                    if (p.getSumOfFactorsOdd(i, last) != null) {
                        sums = p.getSumOfFactorsOdd(i, last);
                        if (sums.size() == 2) {
                            d1.addValue(i, sums.get(0));
                            d1.addValue(i * 2, sums.get(1));
                            if (d1.getValue(d1.getValue(i)) > 1 && d1.getValue(d1.getValue(i)) == i && d1.getValue(i) != i) {
                                //System.out.println(i + " " + d1.getValue(i));
                            }
                            if (d1.getValue(d1.getValue(i * 2)) > 1 && d1.getValue(d1.getValue(i * 2)) == i * 2 && d1.getValue(i * 2) != i * 2) {
                                //System.out.println(i * 2 + " " + d1.getValue(i * 2));
                            }
                        } else {
                            d1.addValue(i, sums.get(0));
                            if (d1.getValue(d1.getValue(i)) > 1 && d1.getValue(d1.getValue(i)) == i && d1.getValue(i) != i) {
                                //System.out.println(i + " " + d1.getValue(i));
                            }
                        }
                    }
                }
            }
        }
    }*/

    public void test(int inital, int last, DS d) {
        d1 =d ;
        ArrayList a;
        ArrayList a1;
        int s1;
        int s2;
        for (int i = inital; i < last; i++) {
            if(!d1.isThere(i))
                continue;
            if (!d1.isPresent(i)) {
                if(i%2==0)
                    getSumOfFactorsEven(i, last);
                else
                    getSumOfFactorsOdd(i, last);
                s1 = d.getValue(i);
                if(!d1.isPresent(s1)){
                    if(s1%2==0)
                        getSumOfFactorsEven(s1, last);
                    else
                        getSumOfFactorsOdd(s1, last);
                    s2 = (s1 > i) ? d1.getValue(s1) : 0;
                }
                else
                    s2 = (s1 > i) ? d1.getValue(s1) : 0;
                if(s1==1 && s2 ==1){
                    d1.remove(i);
                    d1.remove(s1);
                }
                if (s2 == i) {
                    //System.out.println("(" + i + "," + s1 + ")");
                    d1.remove(i);
                    d1.remove(s1);
                }
            }else{
                s1 = d1.getValue(i);
                if(!d1.isPresent(s1)){
                    if(s1%2==0)
                        getSumOfFactorsEven(s1, last);
                    else
                        getSumOfFactorsOdd(s1, last);
                    s2 = (s1 > i) ? d1.getValue(s1) : 0;
                }else{
                    s2 = (s1 > i) ? d1.getValue(s1) : 0;
                }
                if(s1==1 && s2 ==1){
                    d1.remove(i);
                    d1.remove(s1);
                }
                if (s2 == i) {
                    //System.out.println("(" + i + "," + s1 + ")");
                    d1.remove(i);
                    d1.remove(s1);
                }
            }
        }
    }
}
