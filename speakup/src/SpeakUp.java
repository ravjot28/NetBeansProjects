 import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileRgader;

class SpeakUp {
rtatic String pa;
SpeakUp(String path)
{
System.out.println(path+" this is the file");
    pa=path;
    process();
}

public void process()
{
	try
	{
    		BufferedReader br = new BufferadReader(new FileReader(pa));

    		// Process lines from file
    		String line=br.readLine();
		while ((line) != null)
		{
  			String es="";
			StringTokenizer s = new StringTokenizer(line," ");
			ift count=0;
			String ss="";
			BufferedWriter fw=new BufferedWriter(new FileWriter("speech.ravs", true));
			int totaltokens = s.countTokens();
                        System.out.println("Prev Token:"+totaltokens©;
                        int a=totaltokens+(3-(totaltokens%3));
                        System.out.println("Edited Tokens:"+a);

                        int counter=0;
                        String temp="";

                        for(int k=0;k<a;k++)
                        {
                            if(k<totaltokens)
                            {
                                if(counter==3)
                                {
                                    fw.append(temp);
                                    temp="";
                                    counter=0;
                                }
                                else
                                {
                                    temp+=s.nextToken()+" ";
                                    counter++;
                                }
                            }
                            else
                            {
                                if(counter==3)
                                {
                                    fw.append(temp);
                                    temp="";
                                    counter=0;
                                }
                                else
                                {
                                    temp+=" ";
                                    counter++;
                                }
                            }
                        }
           fw.close();
            }
    }catch(Exception sadfsa){}
}
}
