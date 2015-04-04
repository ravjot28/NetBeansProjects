import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileManager {
	private String fname;
	private String RAMfname;

	//the filename and ramfname are the command line parameters that will be provided while executing the java file.
	public FileManager(String filename,String ramfname) {
		this.fname = filename;
		this.RAMfname = ramfname;
	}

//to fetch the value of ram from the file
	private int getRAM() {
		try {
			BufferedReader b = new BufferedReader(new FileReader(RAMfname));
			String data = b.readLine();
			data = b.readLine();
			StringTokenizer s = new StringTokenizer(data, " ");
			String temp = s.nextToken();
			temp = s.nextToken();
			return Integer.parseInt(temp);
		} catch (Exception e) {
			return -1;
		}
	}

	//to fetch the value of service from the file
		private String getServer(String line) {
			return line.substring(line.length()-8,line.length()-1);
		}


                private ArrayList getData(){
                    ArrayList<String> data = new ArrayList<String>();
                    try{
                        BufferedReader b = new BufferedReader(new FileReader(fname));
                        String temp = b.readLine();
                        while(temp!=null){
                            if(!temp.trim().equals(""))
                                data.add(temp);
                            temp = b.readLine();
                        }
                    }catch(Exception e){
                        return null;
                    }
                    return data;
                }

                private int getRAMData(String line){
                    line = line.replaceAll("\\s+", " ");
                    StringTokenizer s = new StringTokenizer(line," ");
                    if(s.countTokens()==9){
                        String temp = s.nextToken();
                        temp = s.nextToken();
                        temp = s.nextToken();
                        try{
                            return Integer.parseInt(temp);
                        }catch(NumberFormatException e){
                            return -1;
                        }
                    }else{
                        return -1;
                    }
                }

                 private int getPIDData(String line){
                    line = line.replaceAll("\\s+", " ");
                    StringTokenizer s = new StringTokenizer(line," ");
                    if(s.countTokens()==9){
                        String temp = s.nextToken();
                        temp = s.nextToken();
                        try{
                            return Integer.parseInt(temp);
                        }catch(NumberFormatException e){
                            return -1;
                        }
                    }else{
                        return -1;
                    }
                }

//the file reading function which checks for Ram threshold in server usage record file and fetches out parameters from the process.txt file
	public void process() {
		int gram = getRAM();
		if (gram != -1) {
                        String server_name=null;
			ArrayList<String> data = getData();
                        for(String temp:data){
                            if(temp.startsWith("Process memory")){
                                server_name= getServer(temp);
                            }else{
                                int dram = getRAMData(temp);
                                int dpid = getPIDData(temp);
                                if(dram == -1){
                                    continue;
                                }else{
                                    if(dram>gram){
                                        System.out.println("Issue server_name "+server_name+" pid "+dpid);
                                    }else{
                                        System.out.println("Cool server_name "+server_name+" pid "+dpid);
                                    }
                                }
                            }
                        }
		} else {
			System.out.println("Can not take the RAM from the process file");
		}
	}

	public static void main(String as[]){
		new FileManager("C:\\2012-27-05-08.41.txt","C:\\process.txt").process();
	}
}