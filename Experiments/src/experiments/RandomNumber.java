package experiments;
import java.util.*;
import javax.swing.JOptionPane;
public class RandomNumber
{
	public static void main(String[] args)
	{

		String output="";
		int[] arrayRan=new int[6];
		int rand;
		for(int i=0;i<arrayRan.length;i++)
		{
			do
			{
				rand =(int)(Math.random()*20)+1;
			}while(doesExists(rand, arrayRan, i)); //while return is true
			arrayRan[i] = rand;
		}
		Arrays.sort(arrayRan);
		for(int i=0;i<arrayRan.length;i++)
		{
			System.out.println(arrayRan[i]);
		}

	}

	private static boolean doesExists(int rand, int[] arr, int i)
	{
		if( i != 0)
		{
			for(int j = 0; j < i; j++)
			{
				if(rand == arr[j])
					return true;	// number already in the array
			}
		}
		return false;
	}
}