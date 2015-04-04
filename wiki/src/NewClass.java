import java.io.*;
import java.net.URL;

public class NewClass
{
	public static BufferedReader read(String url) throws Exception
	{
		return new BufferedReader(new InputStreamReader(
				new URL(url).openStream()));
	}

	public static void main (String[] args) throws Exception
	{
		BufferedReader reader = read("http://www.lyricsreg.com/lyrics/jay+sean/Ride+It/");
		BufferedWriter writer = new BufferedWriter(new FileWriter("gtbit.org.html"));
		BufferedWriter writer1 = new BufferedWriter(new FileWriter("gtbit.hyperlinks.html"));
		String line = reader.readLine();

		while (line != null)
		{
			System.out.println(line);
			line = reader.readLine();
		}
	}

}
