import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.awt.Color;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class FirstPageOfPaySlip
{
    private static Font f1 = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL,Color.BLACK);
    private static Font f2=FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new Color(0, 0,0));
    private static Font f3=FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, new Color(0, 0,0));
    private static Font redFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL,Color.RED);
    String rav;
    public void launch(String empid,String r) throws DocumentException, FileNotFoundException, BadElementException, MalformedURLException, IOException
    {
        rav=r;
        int sav[]=getempsaving(empid,rav);
        int pli[]=new SecondPageOfPaySlip().getpli(empid,rav);
        int detail[]=getempbasic(empid,rav);
        int deduct[]=getempdedcuct(empid,rav);
        int totsav=0;
        if((sav[0]+sav[1]+sav[2]+sav[3]+sav[4]+sav[5]+sav[6]+sav[7]+sav[8]+sav[9]+sav[10]+sav[11]+sav[12]+sav[13])<120000)
        {
            totsav=sav[0]+sav[1]+sav[2]+sav[3]+sav[4]+sav[5]+sav[6]+sav[7]+sav[8]+sav[9]+sav[10]+sav[11]+sav[12]+sav[13];
        }
        else
        {
            totsav=120000;
        }
        int detailtot=detail[0]+detail[1]+detail[2]+detail[3]+detail[4]+detail[5]+detail[6]+detail[7]+detail[8]+detail[9]+detail[10]+detail[11]+detail[12]+detail[13];
        int pli1=(pli[0]+pli[1]+pli[2]+pli[3]+pli[4]);
        int deducttot=deduct[0]+deduct[1]+deduct[2]+deduct[3]+deduct[4]+deduct[5]+deduct[6]+deduct[7]+deduct[8]+deduct[9];
         int d=new SecondPageOfPaySlip().getplidedcution(empid,rav);
         int netpay=(detailtot+pli1)*12;
         int taxpay=netpay-totsav;
         int tax=(deducttot+d)*12;
         int tot=netpay-tax;
        String name=new FirstPageOfPaySlip().getnam(empid,rav);
        String acc=new FirstPageOfPaySlip().getacc(empid,rav);
        String dob=new FirstPageOfPaySlip().getdob(empid,rav);
        String doj=new FirstPageOfPaySlip().getdoj(empid,rav);
        String sex=new FirstPageOfPaySlip().getsex(empid,rav);
        String s;
        if(sex.equalsIgnoreCase("m"))
        {
            s="MALE";
        }
        else
        {
            s="FEMALE";
        }
        String space="";
        int i=name.length();
        while(i!=17)
        {
            space=space+"  ";
            i++;
        }
        String head="\n                                             NACIL – NORTHERN REGION";
     String subhead="\n                                                                           PAYSLIP FOR   "+new GetMonthNameExample().name()+"/"+new CalendarExample().name();
        Document document=new Document(PageSize.A4, 20, 10, 10, 20);
        document.addTitle("Pay Slip");
		document.addSubject("Pay Slip");
		document.addKeywords("Java, PDF");
		document.addAuthor("Rav");
		document.addCreator("Rav");
        PdfWriter.getInstance(document,new FileOutputStream(new Dir().getdir()+"test/Temp2/Temp3/Temp4/Temp5/Temp6/Temp7/Temp8/Temp9/Temp10/Temp11/Temp12/Salary_Slips.pdf"));
        document.open();
        Image image = Image.getInstance ("Bin\\img\\airindia1.jpg");
        document.add(image);
        document.add(new Paragraph(head,f2));
        document.add(new Paragraph(subhead,f3));
        document.add(new Paragraph("\n        "+name+space+"                              Emp No: "+empid+"                                                 Desig: CH A/C Engg",f1));
        document.add(new Paragraph("       8130/200			                                          PAY SCL: 1600:23000	                                    PAN-No: AABPS8791R",f1));
        document.add(new Paragraph("       DOB: "+dob+"			                            DOJ: "+doj+"		                                             PENSION: 2.5%",f1));
        document.add(new Paragraph("       Bank: 1234567890		                           AC/NO: "+acc+"                                     *"+s+"*",f1));
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------------------",f1));
        document.add(new Paragraph("     ANN SLRY      "+netpay+"               LIC            "+sav[0]+"          IFB/FD          "+sav[5]+"                 H/RENT                "+sav[10],f1));
        document.add(new Paragraph("     TAXABLE       "+taxpay+"               VLIP          "+sav[1]+"          SOCCC       "+sav[6]+"                 MT FR/TO            "+sav[11],f1));
        document.add(new Paragraph("     PERKS                                           PPF               "+sav[2]+"          ELSS           "+sav[7]+"                 HRA-RLF              "+sav[12],f1));
        document.add(new Paragraph("     TAX ASSD       "+tax+"                NSC            "+sav[3]+"          NSS/JD         "+sav[8]+"                  H-LOAN                 "+sav[13],f1));
        document.add(new Paragraph("     NET PAY         "+tot+"                NSCINT       "+sav[4]+"         TUT-FEE     "+sav[9]+"                  TOT-SAV         "+totsav,f1));
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------------------",f1));
        document.add(new Paragraph("                        FULL MTH-EMOLUMENTS                                                         DEUCTIONS",f1));
        document.add(new Paragraph("\n         001  Basic Pay                             "+detail[0]+"                                                     001  P FUND SUBS                "+deduct[0],f1));
        document.add(new Paragraph("        003  VDA                                     "+detail[1]+"                                                    003  PF VOL MAX              "+deduct[1],f1));
        document.add(new Paragraph("        023  Shift ALC                                 "+detail[2]+"                                                    054  AIAEA SUBS                  "+deduct[2],f1));
        document.add(new Paragraph("        024  OVERTIME ALC                   "+detail[3]+"                                                   067  C F M S                           "+deduct[3],f1));
        document.add(new Paragraph("        036  PERS PAY Q-ALL                   "+detail[4]+"                                                   084  I TAX                            "+deduct[4],f1));
        document.add(new Paragraph("        040  CITY COMP ALC                    "+detail[5]+"                                                   085  EDU CESS - ITAX           "+deduct[5],f1));
        document.add(new Paragraph("        046  SAL ARRS NON-PF                "+detail[6]+"                                                    093  COOP CREDIT NDH       "+deduct[6],f1));
        document.add(new Paragraph("        054  TECHNICAL PAY                 "+detail[7]+"                                                   094  ACEC BANK BOM        "+deduct[7],f1));
        document.add(new Paragraph("        056  TAXYING ALC                       "+detail[8]+"                                                   099  SUSPENSE PRS                "+deduct[8],f1));
        document.add(new Paragraph("        057  QUALIFICATION PAY        "+detail[9]+"                                                   176  PENSION SUB                "+deduct[9],f1));
        document.add(new Paragraph("        086  HOUSE RENT ALC              "+detail[10]+"",f1));
        document.add(new Paragraph("        100  PROF DEV ALC                      "+detail[11]+"",f1));
        document.add(new Paragraph("        102  LECTURE ALC-FXD            "+detail[12]+"",f1));
        document.add(new Paragraph("        133  EDUCATIONAL ALC             "+detail[13]+"",f1));
        document.add(new Paragraph("\n\n      TOTALS IN RUPEES                      "+detailtot,f1));
        document.add(new Paragraph("                                                                                                                                                                        "+deducttot,f1)); //deduction total
        document.add(new Paragraph("                                                                                                                                                NET PAY          "+(detailtot-deducttot),f1));
        document.add(new Paragraph("\n",f1));
        document.add(new Paragraph("PLEASE CHECK PAN IN CASE OF MISSING OR WRONG \n PAN HIGHER RATE OF TAX WILL BE DEDUCATED AND NO \n CREDIT BE GIVEN BY  ITAX AUTHORITIES.",redFont));
        document.close();
   }

    public int[] getempbasic(String empid,String r)
    {
        int all[] = new int[14];
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
           Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM Empdetailpay where EMPID="+empid);
            if(res.next())
            {
                all[0]=Integer.parseInt(res.getString("basic"));
                all[1]=Integer.parseInt(res.getString("vda"));
                all[2]=Integer.parseInt(res.getString("shiftalc"));
                all[3]=Integer.parseInt(res.getString("overtimealc"));
                all[4]=Integer.parseInt(res.getString("perspayqall"));
                all[5]=Integer.parseInt(res.getString("citycompalc"));
                all[6]=Integer.parseInt(res.getString("salarrsnonpf"));
                all[7]=Integer.parseInt(res.getString("techpay"));
                all[8]=Integer.parseInt(res.getString("taxying"));
                all[9]=Integer.parseInt(res.getString("qualification"));
                all[10]=Integer.parseInt(res.getString("houserent"));
                all[11]=Integer.parseInt(res.getString("profdev"));
                all[12]=Integer.parseInt(res.getString("lecalc"));
                all[13]=Integer.parseInt(res.getString("edualc"));
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
        return all;
    }

    public String getnam(String empid,String r)
    {

      Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
           Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM EnggDept where EMPID="+empid);
            if(res.next())
            {
                return res.getString("EMPFNAME")+" "+res.getString("EMPMNAME")+" "+res.getString("EMPLNAME");
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }

        return "";
    }

    public String getacc(String empid,String r)
    {

      Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM EnggDept where EMPID="+empid);
            if(res.next())
            {
                return res.getString("ACCNO");
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }

        return "";
    }

    public String getdoj(String empid,String r)
    {

      Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM EnggDept where EMPID="+empid);
            if(res.next())
            {
                return res.getString("DOJ");
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }

        return "";
    }

    public String getdob(String empid,String r)
    {

      Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
           Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM EnggDept where EMPID="+empid);
            if(res.next())
            {
                return res.getString("DOB");
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }

        return "";
    }

    public String getsex(String empid,String r)
    {

      Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM EnggDept where EMPID="+empid);
            if(res.next())
            {
                return res.getString("SEX");
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }

        return "";
    }

     public int[] getempdedcuct(String empid,String r)
    {
        int all[] = new int[10];
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM Empdeduction where EMPID="+empid);
            if(res.next())
            {
                all[0]=Integer.parseInt(res.getString("PFS"));
                all[1]=Integer.parseInt(res.getString("PFV"));
                all[2]=Integer.parseInt(res.getString("AIAEA"));
                all[3]=Integer.parseInt(res.getString("CFMS"));
                all[4]=Integer.parseInt(res.getString("ITAX"));
                all[5]=Integer.parseInt(res.getString("EDU"));
                all[6]=Integer.parseInt(res.getString("COOP"));
                all[7]=Integer.parseInt(res.getString("ACEC"));
                all[8]=Integer.parseInt(res.getString("SUSPENSE"));
                all[9]=Integer.parseInt(res.getString("PENSION"));
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
        return all;
    }

      public int[] getempsaving(String empid,String r)
    {
        int all[] = new int[14];
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM Empsaving where EMPID="+empid);
            if(res.next())
            {
                all[0]=Integer.parseInt(res.getString("LIC"));
                all[1]=Integer.parseInt(res.getString("VLIP"));
                all[2]=Integer.parseInt(res.getString("PPF"));
                all[3]=Integer.parseInt(res.getString("NSC"));
                all[4]=Integer.parseInt(res.getString("NSCINT"));
                all[5]=Integer.parseInt(res.getString("IFB"));
                all[6]=Integer.parseInt(res.getString("SOCCC"));
                all[7]=Integer.parseInt(res.getString("ELSS"));
                all[8]=Integer.parseInt(res.getString("NSS"));
                all[9]=Integer.parseInt(res.getString("TUT"));
                all[10]=Integer.parseInt(res.getString("HRENT"));
                all[11]=Integer.parseInt(res.getString("MT"));
                all[12]=Integer.parseInt(res.getString("HRA"));
                all[13]=Integer.parseInt(res.getString("HLOAN"));
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
        return all;
    }
      public int[] getpli(String empid,String r)
    {
        int all[] = new int[5];
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM pli where EMPID="+empid);
            if(res.next())
            {
                all[0]=Integer.parseInt(res.getString("flyhr"));
                all[1]=Integer.parseInt(res.getString("tech"));
                all[2]=Integer.parseInt(res.getString("acon"));
                all[3]=Integer.parseInt(res.getString("fix"));
                all[4]=Integer.parseInt(res.getString("lufa"));
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
        return all;
    }

 public int getplideduction(String empid,String r)
    {
        int all=0;
        Connection con = null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driver="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+r;
            con = DriverManager.getConnection(driver,"","");
            Statement sta = con.createStatement();
            // getting the data back
            ResultSet res = sta.executeQuery("SELECT * FROM plideduction where EMPID="+empid);
            if(res.next())
            {
                all=Integer.parseInt(res.getString("adl"));
            }
      res.close();
      sta.close();
      con.close();
    } catch (Exception e) {
      System.err.println("Exception: "+e.getMessage());
    }
        return all;
    }



}