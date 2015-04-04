package GuiTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class sys_healthfn 
{
	public static ArrayList<String> getFileContentList(String fileName)
	{
		ArrayList<String> data = new ArrayList<String>();
	    BufferedReader input = null;
	    
	    try
	    {
	    	input = new BufferedReader(new FileReader(fileName));
	    	String line = null;
	    	while((line = input.readLine()) != null)
	    	{
	    		data.add(line);
	    	}
	    }
	    catch(IOException ex)
	    {
	      data = new ArrayList<String>();
	    }
	    finally
	    {
	      if(null != input)
	      {
	    	  try
	    	  {
	    		  input.close();
	    	  }
	    	  catch(Exception e)
	    	  {
	    		  data = new ArrayList<String>();
	    	  }
	      }
	    }
	    return data;
	}
	
	static ArrayList<String> configList = getFileContentList("LOGS_7th_Feb.txt");
	
	int asm=0, asm_end=0;
	String asm_str12 = null;
	String asm_tmp12 = "";
	
	public String sys_hlth_fn_warn(String start, String end)
	{
		for(String st : configList)
		{
			if(st.contains(start))
			{
	            asm = configList.indexOf(st);
	            break;
	        }
		}
		String asm_str = configList.get(asm);
		
		for(String st : configList)
		{
			if(st.contains(end))
			{
	            asm_end= configList.indexOf(st);
	            break;
	        }
		}

		if(asm_str.startsWith(start) && asm_str.endsWith("[OK]"))
		{
			return "OK";
		}	
		else
		{
			String asm_start = null;
			ArrayList<String> asm_tmp = new ArrayList<String>();

			for(int i=asm+2; i<=asm_end-4; i++)
			{
				asm_start = configList.get(i);
				asm_tmp.add(asm_start);
				asm_tmp.add("\n"); // warning and remedy
			}
			
			int rem_asm_s=0, rem_asm_e=0;
			for(String warn : asm_tmp)
			{
				if(warn.contains("REMEDY:"))
				{
	                  rem_asm_s = asm_tmp.indexOf(warn);
	                  rem_asm_e = asm_tmp.lastIndexOf(warn);
				}
			}

			String asm_str1 = null;
			String asm_tmp1 = "";
			
			for(String warn : asm_tmp)
			{
				for(int j=0; j<rem_asm_e; j++) // warning
				{
					asm_str1 = asm_tmp.get(j);
					if(asm_str1.trim().startsWith("REMEDY:") || asm_str1.equals("\n"))
					{
						continue;
					}
					else
					{
						asm_tmp1+=asm_str1+"\n";
					}
				}
				break;
			}
			
//			for(int j=rem_asm_s; j<=rem_asm_e; j++)
			
			for(int j=rem_asm_s; j<=asm_tmp.lastIndexOf("\n"); j++)
			{
				asm_str12 = asm_tmp.get(j); // remedy
				
				if(asm_str12.trim().startsWith("REMEDY:"))
				{
					asm_tmp12+=asm_str12 + "\n"; // remedy
				}
				else
				{
					continue;
				}
				
//				}
			}
			return asm_tmp1; // warning
		}
	}
	
	public String sys_hlth_fn_rem(String start, String end)
	{
		int asm=0, asm_end=0;
		String asm_str12 = null;
		String asm_tmp12 = "";
		
		for(String st : configList)
		{
			if(st.contains(start))
			{
	            asm = configList.indexOf(st);
	            break;
	        }
		}
		String asm_str = configList.get(asm);
		
		for(String st : configList)
		{
			if(st.contains(end))
			{
	            asm_end= configList.indexOf(st);
	            break;
	        }
		}

		if(asm_str.startsWith(start) && asm_str.endsWith("[OK]"))
		{
			return "OK";
		}	
		else
		{
			String asm_start = null;
			ArrayList<String> asm_tmp = new ArrayList<String>();

			for(int i=asm+2; i<=asm_end-4; i++)
			{
				asm_start = configList.get(i);
				asm_tmp.add(asm_start);
				asm_tmp.add("\n"); // warning and remedy
			}
			
			int rem_asm_s=0;
//			int rem_asm_e=0;
			for(String warn : asm_tmp)
			{
				if(warn.contains("REMEDY:"))
				{
	                  rem_asm_s = asm_tmp.indexOf(warn);
//	                  rem_asm_e = asm_tmp.lastIndexOf(warn);
				}
			}

			for(int j=rem_asm_s; j<=asm_tmp.lastIndexOf("\n"); j++)
			{
				asm_str12 = asm_tmp.get(j); // remedy
				
				if(asm_str12.trim().startsWith("REMEDY:"))
				{
					asm_tmp12+=asm_str12 + "\n"; // remedy
				}
				else
				{
					continue;
				}
			}
		}
		return asm_tmp12; // remedy
	}
}