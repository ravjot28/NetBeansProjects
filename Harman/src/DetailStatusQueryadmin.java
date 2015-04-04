import java.sql.*;
import java.util.StringTokenizer;
public class DetailStatusQueryadmin
{

  public String[][] search(String rav)
  {
      String a="";
      Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+rav;
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM exitmanag");
            while(res.next())
            {
                String conf=res.getString("confirmation");
                if(((""+conf.charAt(5)).equalsIgnoreCase("1")))
                {
                String data=res.getString("reason").trim();
                if(!data.equalsIgnoreCase("na"))
                {
                    a=a+conf+","+res.getString("emp_name")+" ("+res.getString("emp_id")+")|";
                }
                }
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {    }
      StringTokenizer t=new StringTokenizer(a,"|");
      String rec[][]=new String[t.countTokens()][7];
      int ap=0;
      while(t.hasMoreTokens())
      {
          String temp=t.nextToken();
          String ar=temp.substring(0,temp.lastIndexOf(","));
          rec[ap][6]=data(""+ar.charAt(6));
          //rec[ap][5]=data(""+ar.charAt(5));
          rec[ap][5]=data(""+ar.charAt(4));
          rec[ap][4]=data(""+ar.charAt(3));
          rec[ap][3]=data(""+ar.charAt(2));
          rec[ap][2]=data(""+ar.charAt(1));
          rec[ap][1]=data(""+ar.charAt(0));
          rec[ap][0]="     "+temp.substring(temp.lastIndexOf(",")+1);
          //System.out.println(rec[ap][0]+"\n"+rec[ap][1]+rec[ap][2]+"\n"+rec[ap][3]+rec[ap][4]+"\n"+rec[ap][5]+rec[ap][6]);
          ap++;
      }
      return rec;
  }

  public String data(String p)
  {
      if(p.trim().equalsIgnoreCase("0"))
      {
          return "     Accepted";
      }
      else
      if(p.trim().equalsIgnoreCase("1"))
      {
        return "     UC";
      }
      else
      if(p.trim().equalsIgnoreCase("2"))
      {
        return "     Rejected";
      }
      return "";
  }
}
