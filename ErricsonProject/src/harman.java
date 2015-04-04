import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.*;
import jxl.format.CellFormat;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

public class harman
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
        if(isIgnore(line))
        {
          continue; //ignoring blank lines and lines starting with #
        }
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

  public static boolean isBlank(String data)
  {
    for(int i = 0;i < data.length();i++)
    {
      if(!Character.isWhitespace(data.charAt(i)))
      {
        return false;
      }
    }
    return true;
  }

  private static boolean isIgnore(String data)
  {
    return (data.startsWith("#") );
  }

  public static void main(String[] args) throws IOException, WriteException
  {
    ArrayList<String> configList = getFileContentList("pro active support.log");

    int ind1=0;

//  try
//  {
      WritableWorkbook workbook = Workbook.createWorkbook(new File("Harman_1_New.xls"));

      WritableSheet sheet = workbook.createSheet("Sheet 1", 0);

      Label label = new Label(0, 1, "NODE");  //storing string Test
      Label label1 = new Label(1, 1, "ADMGW1");
      Label label2 = new Label(0, 3, "Check Name");
      Label label3 = new Label(1, 3, "Status");
      Label label4 = new Label(2, 3, "Observation");
      Label label5 = new Label(3, 3, "Node/Network Impact");
      Label label6 = new Label(4, 3, "Action Recommended");
      Label label7 = new Label(5, 3, "Severity");
      Label label8 = new Label(6, 3, "First Reported");
      Label label9 = new Label(7, 3, "Recipient Update");
      Label label10 = new Label(0, 4, "Type of node");
      Label label11 = new Label(0, 5, "Current software level");
      Label label12 = new Label(0, 6, "Alarm List analysis");

      sheet.addCell(label);
      sheet.addCell(label1);
      sheet.addCell(label2);
      sheet.addCell(label3);
      sheet.addCell(label4);
      sheet.addCell(label5);
      sheet.addCell(label6);
      sheet.addCell(label7);
      sheet.addCell(label8);
      sheet.addCell(label9);
      sheet.addCell(label10);
      sheet.addCell(label11);
      sheet.addCell(label12);

//      Number number = new Number(1,0,26);  //storing number 26
//      sheet.addCell(number);

      // (column, row) A1 being represented by (0,0), B1 by (1,0), A2 by (0,1)


    for(String st : configList)
    {
      if(st.contains("productNumber"))
      {
       ind1 = configList.indexOf(st);
       break;
      }
    }
    String ab = configList.get(ind1);
    String ab1 = ab.substring(37, 42);
    String ab2 = ab.substring(47);

    System.out.println("productNumber is " + ab1 );
    System.out.println("current s/w level is " +ab2);

    Vector<String> agm = new Vector<String>();
    agm.add(ab1);

    Label label13 = new Label(2, 4, ab1);
    sheet.addCell(label13);

    Label label14 = new Label(2, 5, ab2);
    sheet.addCell(label14);

//--
    int alarmno=0;
    for(String alarm : configList)
    {
      if(alarm.contains("Nr of active alarms are:"))
      {
        alarmno = configList.indexOf(alarm);
        break;
      }
    }

    String alarm0 = configList.get(alarmno);
    System.out.println(alarm0);

    String alarm = alarm0.substring(24); // contains number of alarms in string

//    int al = Integer.parseInt(alarm); // number of alarm
//    System.out.println("al val is" +al);

    System.out.println("number of alarms are" + alarm );

    Vector<String> alrm = new Vector<String>();
    alrm.add(alarm);
//    System.out.println(alrm);

    Label label15 = new Label(1, 6, "warning");
    sheet.addCell(label15);

    Label label16 = new Label(2, 6, alarm + " alarm(s) found in 4 different type(s). See comment for alarm list.");
    sheet.addCell(label16);

//----

    int as=0, ae=0;

    for(String alarms : configList)
    {
      if(alarms.contains("Date & Time (Local) S Specific Problem"))
      {
        as = configList.indexOf(alarms);
        as = as+2;
        break;
      }
    }

    for(String alarme : configList)
    {
        if(alarme.contains("MGWG031> ala"))
        {
          ae = configList.indexOf(alarme);
          ae = ae-7;
          break;
        }
    }

    Vector<String> alrmval = new Vector<String>();

    String alarmse = null;
    String nu = null;

    for(int asl=as; asl<ae; asl++)
    {
        alarmse = configList.get(asl); // from starting pt of alarm to end of alarm
        nu = alarmse.substring(22); // getting alarm names from log
        System.out.println("nu is" +nu);
        alrmval.add(nu);
    }

   

    try{
        Workbook workbook1 = Workbook.getWorkbook(new File("MGW Alarm Details.xls"));
        Sheet sheet1 = workbook1.getSheet(0);

        Cell c[] = sheet1.getColumn(0);
        List<String> cell = new ArrayList<String>();
        for(int i=0;i<c.length;i++){
            if(!c[i].getContents().trim().equals("")){
                cell.add(c[i].getContents().trim());
            }
        }

        ArrayList<String> e1 = new ArrayList<String>();
        ArrayList<String> e2 = new ArrayList<String>();
        for(String logalarm:alrmval){
            String a[] = logalarm.split("\\s");
            ArrayList<String> t = new ArrayList<String>();
            for(String temp:a){
                if(!temp.trim().equals("")){
                    t.add(temp);
                }
            }
            boolean c1 = true;
            int index = -1;
            for(int k=0;k<cell.size();k++){
                a = cell.get(k).split("\\s");
                ArrayList<String> t1 = new ArrayList<String>();
                for(String temp:a){
                    if(!temp.trim().equals("")){
                        t1.add(temp);
                    }
                }
                if(check(t,t1)){
                    c1 = true;
                    index = k+1;
                    break;
                }
                else{
                    c1=false;
                }
            }

            if(c1){
                Cell temp = sheet1.getCell(3, index-1);
                String info = temp.getContents();
                temp = sheet1.getCell(0, index-1);
                String name = temp.getContents();
                e1.add(name);
                e2.add(info);
            }
            else{
                System.out.println("Not found");
            }

        }
    WritableCellFormat cf = new WritableCellFormat();
            cf.setWrap(true);
        for(int i=0;i<e1.size();i++){

            
                String name = e1.get(i);
                String sol = e2.get(i);
                label = new Label(2, 7+i,name,cf);
                sheet.addCell(label);
                label = new Label(3, 7+i,sol,cf);
                sheet.addCell(label);

      }

         workbook.write();
        workbook.close();
      }catch(Exception e){
          e.printStackTrace();
      }
  }

  

  public static boolean check(ArrayList<String> t,ArrayList<String> t1){

      for(int i=0;i<t1.size();i++){
          if(t.get(i).equals(t1.get(i))){
              continue;
          }
            else
          {
              return false;
            }
      }
      return true;
  }
}
