
import java.util.Random;
import java.util.Scanner;

public class IPL
{
	private int[] players;
	private int size;
        static int ar[];

	public void sort(int[] values)
        {
		if (values ==null || values.length==0)
                {
			return;
		}
		this.players = values;
		size = values.length;
		quicksort(0, size - 1);

                int sum=0;
                System.out.println("\n\nYour Players Shuld be-->\n");
                for(int i=(size/2)-1;i>=0;i--)
                {
                    System.out.print("Player No.:"+getPlayer(players[i])+" with Cost: "+players[i]+"\n");
                    sum+=players[i];
                }

                System.out.println("\n\nYou will pay in total "+sum);

	}

        public int getPlayer(int val)
        {
            for(int i=0;i<ar.length;i++)
            {
                if(ar[i]==val)
                {
                    return i+1;
                }
            }
            return -2;
        }



	private void quicksort(int low, int high)
        {
		int i = low, j = high;

		int pivot = players[high];

		while (i <= j)
                {

			while (players[i] < pivot)
                        {
				i++;
			}

			while (players[j] > pivot)
                        {
				j--;
			}

			if (i <= j)
                        {
                            exchange(i, j);
                            i++;
                            j--;
			}
		}

		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	private void exchange(int i, int j)
        {
		int temp = players[i];
		players[i] = players[j];
		players[j] = temp;
	}

        public static void main(String as[])
        {
            IPL is = new IPL();
            int n = new Scanner(System.in).nextInt();
            ar = new int[n];

            for(int i=0;i<n;i++)
            {
                ar[i] = new Random().nextInt()%100;
                if(ar[i]<0)
                {
                    ar[i]=ar[i]*(-1);
                }
            }

            System.out.println("List of Players-->");

            for(int i=0;i<n;i++)
                System.out.print("Player No."+(i+1)+" Cost: "+ar[i]+" \n");

            is.sort(ar);


        }
}