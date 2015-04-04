package newpackage;

import java.util.*;

public class empid
{
        public static List get(List numbers, int noOfRandomNumbers) {
                List<Integer> list = new ArrayList(numbers);
                List<Integer> randomList = new ArrayList();

                Random rd = new Random();
                for (int i = 0; i < noOfRandomNumbers; i++) {
                        int index = (int) (rd.nextDouble() * list.size());
                        randomList.add(list.get(index));
                        list.remove(index);
                }
                return randomList;
        }

        public String[] getempid()
        {
                String arr[] = new String[3684];
                Integer in[] = new Integer[3684];
                int count=111111;
                for (int i = 0; i < 3684; i++)
                {
                        count=count+1;
                        in[i] =count;
                }
                List<Integer> randomList = get(Arrays.asList(in), 3684);
                int c=0;
                for (Integer randomNumber : randomList)
                {
                        arr[c]=""+randomNumber;
                        c++;
                }
                return arr;
        }
}