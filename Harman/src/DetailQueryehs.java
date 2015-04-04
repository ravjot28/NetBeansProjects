import java.sql.*;
import java.util.StringTokenizer;
public class DetailQueryehs
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
                String pp=""+conf.charAt(0)+conf.charAt(1)+conf.charAt(2)+conf.charAt(3)+conf.charAt(4)+conf.charAt(5)+conf.charAt(6);
                if((pp.equalsIgnoreCase("0000000"))&&(!conf.equalsIgnoreCase("00000000")))
                {
                String data=res.getString("reason").trim();
                if(!data.equalsIgnoreCase("na"))
                {
                    a=a+res.getString("dor")+","+res.getString("emp_name")+" ("+res.getString("emp_id")+")|";
                }
                }
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {    }
      StringTokenizer t=new StringTokenizer(a,"|");
      String rec[][]=new String[t.countTokens()][3];
      int ap=0;
      while(t.hasMoreTokens())
      {
          String temp=t.nextToken();
          rec[ap][0]="     "+temp.substring(0,temp.lastIndexOf(","));
          rec[ap][1]="     "+temp.substring(temp.lastIndexOf(",")+1);
          rec[ap][2]="Send Mail";
          ap++;
      }
      return rec;
  }
}
