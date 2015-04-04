
import java.util.Random;

public class Island
{
	private int[] islandAreas;
	private int size;

	public void sort(int[] values)
        {
		if (values ==null || values.length==0)
                {
			return;
		}
		this.islandAreas = values;
		size = values.length;
		quicksort(0, size - 1);

                System.out.println("\n\nSorted Array is-->");

                for(int i=0;i<islandAreas.length;i++)
                    System.out.print(islandAreas[i]+" ");

                int sum=0;
                for(int i=(size/2);i<islandAreas.length;i++)
                    sum+=islandAreas[i];

                System.out.println("\n\n Max Area will be "+sum);
                
	}

	private void quicksort(int low, int high)
        {
		int i = low, j = high;

		int pivot = islandAreas[high];

		while (i <= j) 
                {

			while (islandAreas[i] < pivot)
                        {
				i++;
			}

			while (islandAreas[j] > pivot)
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
		int temp = islandAreas[i];
		islandAreas[i] = islandAreas[j];
		islandAreas[j] = temp;
	}

        public static void main(String as[])
        {
            Island is = new Island();
            int n=2;
            int ar[] = new int[n];
            
            for(int i=0;i<n;i++)
            {
                ar[i] = new Random().nextInt()%100;
                if(ar[i]<0)
                {
                    ar[i]=ar[i]*(-1);
                }
            }

            System.out.println("Array is-->");

            for(int i=0;i<n;i++)
                System.out.print(ar[i]+" ");
            
            is.sort(ar);

            
        }
}