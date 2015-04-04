import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDB
{
    String d[];
    String a="";

    CreateDB(String[] db,String loc)
    {
        d=db;
        a=loc;
    }

    public void create()
    {
        String dir=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/"+a+"/";
        mk(dir);
        String dir1=new Dir().getdir()+"PayRollBin/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/";
        File ff=new File(dir1+"MDB/"+"Emp.mdb");
        if(!ff.exists())
        {
            mk(dir1+"MDB");
           copyfile("Bin/Data/Emp.mdb",dir1+"MDB/"+"Emp.mdb");
            createtable(dir1+"MDB/"+"Emp.mdb");
        }
        int i=1;
        do
        {
            if(d[i].substring(8, 14).equalsIgnoreCase(d[i+1].substring(8, 14)))
            {
                if(d[i].substring(8, 14).equalsIgnoreCase(d[i+2].substring(8, 14)))
                {
                    File f=new File(dir+d[i].charAt(0));
                    if(f.exists())
                        {
                            try
                            {
                                BufferedWriter b=new BufferedWriter(new FileWriter((dir+d[i].charAt(0)+"/"+d[i].substring(8, 14)+".ravs")));
                                b.append(new Base64Encoder(d[i]).get());
                                b.newLine();
                                b.append(new Base64Encoder(d[i+1]).get());
                                b.newLine();
                                b.append(new Base64Encoder(d[i+2]).get());
                                b.close();
                                String ravp=new EmailQuery(d[i].substring(8, 14)).search(dir1+"MDB/"+"Emp.mdb");
                                if(ravp.equalsIgnoreCase(""))
                                {
                                    insert(Integer.parseInt(d[i].substring(8, 14)),d[i].charAt(0)+"/"+d[i].substring(8, 14)+".ravs",dir1+"MDB/"+"Emp.mdb");
                                }
                             }catch(Exception sad){}
                        }
                        else
                        {
                            mk(dir+d[i].charAt(0));
                            try
                            {
                                BufferedWriter b=new BufferedWriter(new FileWriter((dir+d[i].charAt(0)+"/"+d[i].substring(8, 14)+".ravs")));
                                b.append(new Base64Encoder(d[i]).get());
                                b.newLine();
                                b.append(new Base64Encoder(d[i+1]).get());
                                b.newLine();
                                b.append(new Base64Encoder(d[i+2]).get());
                                b.close();
                                String ravp=new EmailQuery(d[i].substring(8, 14)).search(dir1+"MDB/"+"Emp.mdb");
                                if(ravp.equalsIgnoreCase(""))
                                {
                                    insert(Integer.parseInt(d[i].substring(8, 14)),d[i].charAt(0)+"/"+d[i].substring(8, 14)+".ravs",dir1+"MDB/"+"Emp.mdb");
                                }
                            }catch(Exception sad){}
                        }
                        i=i+3;
                }
                else
                {
                    File f=new File(dir+d[i].charAt(0));
                    if(f.exists())
                        {
                            try
                            {
                                BufferedWriter b=new BufferedWriter(new FileWriter((dir+d[i].charAt(0)+"/"+d[i].substring(8, 14)+".ravs")));
                                b.append(new Base64Encoder(d[i]).get());
                                b.newLine();
                                b.append(new Base64Encoder(d[i+1]).get());
                                b.close();
                                String ravp=new EmailQuery(d[i].substring(8, 14)).search(dir1+"MDB/"+"Emp.mdb");
                                if(ravp.equalsIgnoreCase(""))
                                {
                                insert(Integer.parseInt(d[i].substring(8, 14)),d[i].charAt(0)+"/"+d[i].substring(8, 14)+".ravs",dir1+"MDB/"+"Emp.mdb");
                                }
                             }catch(Exception sad){}
                        }
                        else
                        {
                            mk(dir+d[i].charAt(0));
                            try
                            {
                                BufferedWriter b=new BufferedWriter(new FileWriter((dir+d[i].charAt(0)+"/"+d[i].substring(8, 14)+".ravs")));
                                b.append(new Base64Encoder(d[i]).get());
                                b.newLine();
                                b.append(new Base64Encoder(d[i+1]).get());
                                b.close();
                                String ravp=new EmailQuery(d[i].substring(8, 14)).search(dir1+"MDB/"+"Emp.mdb");
                                if(ravp.equalsIgnoreCase(""))
                                {
                                insert(Integer.parseInt(d[i].substring(8, 14)),d[i].charAt(0)+"/"+d[i].substring(8, 14)+".ravs",dir1+"MDB/"+"Emp.mdb");
                                }
                            }catch(Exception sad){}
                        }
                        i=i+2;
                }
            }
            else
            {
                File f=new File(dir+d[i].charAt(0));
                    if(f.exists())
                        {
                            try
                            {
                                BufferedWriter b=new BufferedWriter(new FileWriter((dir+d[i].charAt(0)+"/"+d[i].substring(8, 14)+".ravs")));
                                b.append(new Base64Encoder(d[i]).get());
                                b.close();
                                String ravp=new EmailQuery(d[i].substring(8, 14)).search(dir1+"MDB/"+"Emp.mdb");
                                if(ravp.equalsIgnoreCase(""))
                                {
                                insert(Integer.parseInt(d[i].substring(8, 14)),d[i].charAt(0)+".ravs",dir1+"MDB/"+"Emp.mdb");
                                }
                             }catch(Exception sad){}
                        }
                        else
                        {
                            mk(dir+d[i].charAt(0));
                            try
                            {
                                BufferedWriter b=new BufferedWriter(new FileWriter((dir+d[i].charAt(0)+"/"+d[i].substring(8, 14)+".ravs")));
                                b.append(new Base64Encoder(d[i]).get());
                                b.close();
                                String ravp=new EmailQuery(d[i].substring(8, 14)).search(dir1+"MDB/"+"Emp.mdb");
                                if(ravp.equalsIgnoreCase(""))
                                {
                                    insert(Integer.parseInt(d[i].substring(8, 14)),d[i].charAt(0)+".ravs",dir1+"MDB/"+"Emp.mdb");
                                }
                            }catch(Exception sad){}
                        }
                        i=i+1;
            }
            
        }while(i<d.length);

        
    }

    public void mk(String strManyDirectories)
   {
       boolean success = (new File(strManyDirectories)).mkdir();
   }

    public void createtable(String rav)
    {
         Connection con = null;
    try
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+rav);
        // Creating a database table
        Statement sta = con.createStatement();
        int count = sta.executeUpdate("CREATE TABLE EMP (EMPID INT,EMAIL VARCHAR(100),PASS VARCHAR(100),DOB VARCHAR(10),DOJ VARCHAR(10),LOC VARCHAR(1))");
        sta.close();
        con.close();
    } catch (Exception e) {    }
    }

    public void insert(int emp,String loc,String rav)
    {
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+rav);
            Statement sta = con.createStatement();
            int c = sta.executeUpdate("INSERT INTO EMP"+ " " +"(EMPID,EMAIL,PASS,LOC)"+ " VALUES " +
                        "("+emp+",'xyz@abc.com','guest','"+loc+"')");
            sta.close();
            con.close();
        } catch (Exception e) {    }
    }

    private static void copyfile(String srFile, String dtFile){
    try{
      File f1 = new File(srFile);
      File f2 = new File(dtFile);
      InputStream in = new FileInputStream(f1);
      OutputStream out = new FileOutputStream(f2);

      byte[] buf = new byte[1024];
      int len;
      while ((len = in.read(buf)) > 0){
        out.write(buf, 0, len);
      }
      in.close();
      out.close();
    }
    catch(FileNotFoundException ex){    }
    catch(IOException e){
    }
  }
}
