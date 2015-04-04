import java.io.*;

public class CheckDuplicates
{
    String name;
   String fname="Bin\\App\\Items\\DockItems.ravs";
   final int n=getNumberOfLines(fname);
   String items[]=new String[n];

    public boolean ch(String n)
    {
        name=n;
        load();
        return checkk();
    }

    public boolean checkk()
    {
        for(int i=0;i<n;i++)
        {
            if(name.equalsIgnoreCase(items[i]))
            {
                return true;
            }
        }
        return false;
    }

    public void load()
    {
        int a=0;
        try
        {
            BufferedReader b=new BufferedReader(new FileReader(fname));
            String data=b.readLine();
            while(data!=null)
            {
                items[a]=data;
                a++;
                data=b.readLine();
            }
            b.close();
        }catch(Exception e){}
    }

     public int getNumberOfLines(String name) {
		int numberOfLines = 0;


		LineNumberReader lineCounter = null;
		try {
			lineCounter = new LineNumberReader(new FileReader(name));
			while ((lineCounter.readLine()) != null) {
				continue;
			}
			numberOfLines = lineCounter.getLineNumber();

		} catch (IOException e)
                {
		}

		return numberOfLines;
	}
}
