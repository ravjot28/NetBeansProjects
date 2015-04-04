package GuiTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

import java.util.ArrayList;
import java.util.List;
//import java.util.Vector;

import jxl.*;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.*;

public class new_mgw
{
    String filename="";
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

  public void processSteps(String fname) throws IOException, WriteException, BiffException
  {
      this.filename = fname;
	  try
	  {
	  
	  ArrayList<String> configList = getFileContentList("LOGS_7th_Feb.txt");
	  
	  WritableWorkbook workbook = Workbook.createWorkbook(new File("New_MGW.xls"));  //new File("C:\\Rav\\abc\\t.xls")

	  WritableSheet sheet = workbook.createSheet("Sheet 1", 0);
	  sheet.mergeCells(0, 0, 8, 0);
	  sheet.mergeCells(1, 1, 8, 1);
	  sheet.mergeCells(0, 2, 8, 2);
	  
	  WritableCellFormat wrappedText = new WritableCellFormat();
      wrappedText.setWrap(true);

      WritableFont bold_0 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true, UnderlineStyle.NO_UNDERLINE, Colour.WHITE);

      WritableCellFormat bold_1 = new WritableCellFormat (bold_0);
      bold_1.setAlignment(jxl.format.Alignment.CENTRE);
      bold_1.setWrap(true);
      
      WritableCellFormat color_blue = new WritableCellFormat(bold_0);
      color_blue.setBackground(jxl.format.Colour.BLUE);
      color_blue.setAlignment(jxl.format.Alignment.CENTRE);
      color_blue.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
      color_blue.setWrap(true);
      
      WritableCellFormat node = new WritableCellFormat(bold_0);
      node.setBackground(jxl.format.Colour.BLUE);

      WritableFont ca_b1 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
      WritableCellFormat ca_b = new WritableCellFormat(ca_b1);
      ca_b.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE); 
      ca_b.setWrap(true);
      
      WritableCellFormat color_l_blue = new WritableCellFormat();
      color_l_blue.setBackground(jxl.format.Colour.LIGHT_BLUE);
      color_l_blue.setAlignment(jxl.format.Alignment.CENTRE);
      color_l_blue.setWrap(true);
      
      WritableFont bold_y = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, true);
      WritableCellFormat yellow = new WritableCellFormat(bold_y);
      yellow.setBackground(jxl.format.Colour.YELLOW);
      yellow.setAlignment(jxl.format.Alignment.CENTRE);
      yellow.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
      yellow.setWrap(true);
	       
      WritableFont bold_g = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
      WritableCellFormat green = new WritableCellFormat(bold_g);
      green.setBackground(jxl.format.Colour.LIGHT_GREEN);
      green.setAlignment(jxl.format.Alignment.CENTRE);
      green.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
      green.setWrap(true);
	  
      WritableCellFormat va_c = new WritableCellFormat();
      va_c.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE); 
      va_c.setWrap(true);
      
      Label label0 = new Label(0, 0, "Proactive Support (PRS) Report :");
      Label label  = new Label(0, 1, "NODE", node);
      Label label1 = new Label(1, 1, "ADMGW1");
      Label label2 = new Label(0, 3, "Check Name", color_blue);
      Label label3 = new Label(1, 3, "Status", color_blue);
      Label label4 = new Label(2, 3, "Observation", color_blue);
      Label label5 = new Label(3, 3, "Node/Network Impact", color_blue);
      Label label6 = new Label(4, 3, "Action Recommended", color_blue);
      Label label7 = new Label(5, 3, "Severity", color_blue);
      Label label8 = new Label(6, 3, "First Reported", color_blue);
      Label label9 = new Label(7, 3, "Recipient Update", color_blue);
      Label label10 = new Label(0, 4, "Type of node", ca_b);
      Label label11 = new Label(0, 5, "Current software level", ca_b);
      Label label12 = new Label(0, 6, "End-Of-Support (EOS)", ca_b);
      Label label13 = new Label(0, 7, "End-Of-Maintenance (EOM)", ca_b);      
      Label label14 = new Label(0, 8, "Time", ca_b);      
      Label label15 = new Label(0, 9, "Alarm List analysis", ca_b);

      int row_index = 9; 
      
      sheet.addCell(label0);
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
      sheet.addCell(label13);
      sheet.addCell(label14);
      sheet.addCell(label15);
      
      sheet.setColumnView(0, 45);
      sheet.setColumnView(1, 10);
      sheet.setColumnView(2, 45);
      sheet.setColumnView(3, 30);
      sheet.setColumnView(4, 30);
      sheet.setColumnView(5, 30);
      sheet.setColumnView(6, 30);
      sheet.setColumnView(7, 30);
      
//====
   // Type of node, Current software level 
          
      int ind1=0;  
      for(String st : configList)
      {
    	  if(st.contains("ProductNumber:"))
    	  {
    		  ind1 = configList.indexOf(st);
    		  break;
    	  }
      }
      String ab[] = configList.get(ind1).replaceAll("\\s+", " ").split(" ");
      String cd[] = ab[1].split("_");
      
      Label node_type = new Label(2, 4, cd[0], va_c);
      sheet.addCell(node_type);
      
      Label sw_level = new Label(2, 5, cd[2], va_c);
      sheet.addCell(sw_level); 
      	
//====       
   // lh coremp readclock
          
      int lh_clk=0;  
      for(String st : configList)
      {
    	  if(st.contains("lh coremp readclock"))
    	  {
    		  lh_clk = configList.indexOf(st)+4;
    		  break;
    	  }
      }
      String lh_time = configList.get(lh_clk)+"\n"+configList.get(lh_clk+1)+"\n"+configList.get(lh_clk+3)+"\n"+configList.get(lh_clk+4);
      
      Label lh_clk_ok = new Label(1, 8, "OK", green);
      sheet.addCell(lh_clk_ok);
      
      Label lh_clk_obs = new Label(2, 8, lh_time, va_c);
      sheet.addCell(lh_clk_obs);
      
      sheet.setRowView(8, 1400);
      
//----
   // altkc       
      
      /*int as=0, ae=0;
      for(String alarms : configList)
      {
    	  if(alarms.contains("Date;Time;Severity;Object;Problem;Cause;AdditionalText;AckState;AlarmId;NotificationId"))
    	  {
    		  as = configList.indexOf(alarms)+1;
    		  break;
    	  }
      }	
      for(String alarme : configList)
      {
    	  if(alarme.contains(">>> Total: "))
    	  {
    		  ae = configList.lastIndexOf(alarme)-1;
//    		  break;
    	  }
      }
      
      Vector<String> alrmval = new Vector<String>();
//      Vector<String> alrm_date = new Vector<String>();
      
      ArrayList<String> alrm_date = new ArrayList<String>();
      
      String alarmse = null, nu = null, alm_date=null;

      for(int asl=as; asl<=ae; asl++)
      {
    	  alarmse = configList.get(asl); // from starting pt of alarm to end of alarm
    	  String alarm_name[] = alarmse.split(";");
    	  alm_date = alarm_name[0];
    	  nu = alarm_name[4]; // getting alarm names from log
//    	  System.out.println("nu is " + nu);
    	  alrmval.add(nu); // alarms present
    	  alrm_date.add(alm_date); // date of alarm
      }*/
      
//----------
      
//====	
  /*  // alarm
             
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
    	  if(alarme.contains("> ala"))
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
//    	  System.out.println("nu is " + nu);
    	  alrmval.add(nu); // alarms present
      }
      	   
      Workbook workbook1 = Workbook.getWorkbook(new File("MGW Alarm Details.xls"));
      Sheet sheet1 = workbook1.getSheet(0);
      
      Cell c[] = sheet1.getColumn(0);  // getting column 1
      List<String> cell = new ArrayList<String>();
      
      for(int i=0; i<c.length; i++)
      {
    	  if(!c[i].getContents().trim().equals(""))
    	  {
    		  cell.add(c[i].getContents().trim()); // values in column 1 
    	  }
      }
      
      ArrayList<String> e1 = new ArrayList<String>();
      ArrayList<String> e2 = new ArrayList<String>();
//      ArrayList<String> alm_d = new ArrayList<String>();
      
      for(String logalarm:alrmval) // checking from log, not from excel
      {
    	  String a[] = logalarm.split("\\s");
    	  
    	  ArrayList<String> t = new ArrayList<String>();
    	  
    	  for(String temp:a)
    	  {
    		  if(!temp.trim().equals(""))
    		  {
    			  t.add(temp); // entire alarm print out to alarm name alone
    		  }
    	  }
    	  
    	  boolean c1 = true;
    	  int index = -1;
    	  
    	  for(int k=0;k<cell.size();k++)
    	  {
    		  a = cell.get(k).split("\\s"); // getting values from col1
    		  ArrayList<String> t1 = new ArrayList<String>();
    		  
    		  for(String temp:a)
    		  {
    			  if(!temp.trim().equals(""))
    			  {
    				  t1.add(temp); // entire col1 of excel 
    			  }
    		  }
    		  
    		  // t -> log alarm
    		  // t1-> excel col1
    		  
    		  if(check(t,t1)) // checking if alarms are present in col1
    		  {
    			  c1 = true;
    			  index = k+1;
    			  break;
    		  }
    		  else
    		  {
    			  c1=false;
    		  }
    	  }
    	  	
    	  if(c1)
    	  {
    		  Cell temp = sheet1.getCell(3, index-1); // getting solution column
    		  String info = temp.getContents();
    		  temp = sheet1.getCell(0, index-1);
    		  String name = temp.getContents();
    		  e1.add(name); 
    		  e2.add(info);
//    		  alm_d.add(alrm_date.toString());
    	  }
    	  else
    	  {
//    		  System.out.println("Not found");
    	  }
      }
      
      WritableCellFormat cf = new WritableCellFormat();
      cf.setWrap(true);
      
      String alarm_date = null;
      for(int i=0; i<e1.size(); i++)  
      {
    	  String name = e1.get(i); // name
    	  String sol = e2.get(i);  // solution
    	  
    	  alarm_date = alrm_date.get(i);
    	  
    	  Label label_1 = new Label(1, 9+i, "Warning", yellow); 
    	  sheet.addCell(label_1);
    	  
    	  label = new Label(2, 9+i, name, va_c);
    	  sheet.addCell(label);
    	  
    	  label = new Label(3, 9+i, sol, va_c);
    	  sheet.addCell(label);
    	  
    	  label = new Label(6, 9+i, alarm_date, va_c);
    	  sheet.addCell(label);
    	  
//    	  sheet.setRowView(9+i, sol.length());
      }   
      
      sheet.mergeCells(0, 9, 0, 9+e1.size());
      
      row_index = row_index + e1.size();*/
      
//*****************
   // altkc
      
      int as=0, ae=0;
      for(String alarms : configList)
      {
    	  if(alarms.contains("Date;Time;Severity;Object;Problem;Cause;AdditionalText;AckState;AlarmId;NotificationId"))
    	  {
    		  as = configList.indexOf(alarms)+1;
    		  break;
    	  }
      }	
      for(String alarme : configList)
      {
    	  if(alarme.contains(">>> Total: "))
    	  {
    		  ae = configList.lastIndexOf(alarme)-1;
    	  }
      }
	  
      ArrayList<String> alrmval = new ArrayList<String>();
      
      String alarmse = null, nu = null, alm_date=null, alm_sev=null, alm_obj=null, alm_id=null;

      int ialm=0;
      for(int asl=as; asl<=ae; asl++)
      {
    	  alarmse = configList.get(asl); // from starting pt of alarm to end of alarm
    	  String alarm_name[] = alarmse.split(";");

    	  alm_date = alarm_name[0]; // date
    	  alm_sev = alarm_name[2]; // severity
    	  
    	  alm_obj = alarm_name[3]; // Object
    	  alm_id = alarm_name[8]; // AlarmId
    	  
    	  nu = alarm_name[4]; // getting alarm names from log
    	  
    	  alrmval.add(nu); // alarms present
    	  
    	  double alm_h = alm_obj.split(System.getProperty("line.separator")).length
    	  			   + alm_id.split(System.getProperty("line.separator")).length
    	  			   + "Object:\n\n\nAlarmId:\n".split(System.getProperty("line.separator")).length;
    	   
    	  String lines1[] = alm_obj.concat(alm_id).split("\\r?\\n");

    	  double count1 =0;
    	  for(String temp:lines1)
    	  {
    		  if(temp.length()>count1)
    			  count1 = temp.length();
    		  count1/=25;
    	  }
    	  
    	  Label date_ok= new Label(1, 9+ialm, alm_sev, yellow); // severity
    	  sheet.addCell(date_ok);

    	  Label alm_lab= new Label(2, 9+ialm, nu, va_c); // alarm name
    	  WritableCellFeatures alm_comm = new WritableCellFeatures();
    	  alm_comm.setComment("Object:\n"+alm_obj+"\n\n"+"AlarmId:\n"+alm_id, count1, alm_h);
    	  alm_lab.setCellFeatures(alm_comm);
    	  sheet.addCell(alm_lab);
    	  
    	  Label date_lab= new Label(5, 9+ialm, alm_sev, yellow); // severity
    	  sheet.addCell(date_lab);

    	  Label sev_lab= new Label(6, 9+ialm, alm_date, va_c); // first reported ie. alarm date
    	  sheet.addCell(sev_lab);
    	  
    	  ialm++;
      }
      
	  Workbook workbook1 = Workbook.getWorkbook(new File("MGW Alarm Details.xls"));
      Sheet sheet1 = workbook1.getSheet(0);
      
      Cell c[] = sheet1.getColumn(0);  // getting column 1
      List<String> cell = new ArrayList<String>();
      
  // getting col 1 values from excel
      
      for(int i=1; i<c.length; i++) 
      {
    	  if(!c[i].getContents().trim().equals(""))
    	  {
    		  cell.add(c[i].getContents().trim()); // values in column 1 
    	  }
      }
      
      ArrayList<String> alrm_xl = new ArrayList<String>(); 
      
      for(String alrm_chk : cell)
      {
    	  alrm_xl.add(alrm_chk);
      }
      
      for(int log=0; log<alrmval.size(); log++)
      {
    	  for(int xl=0; xl<=alrm_xl.size(); xl++)
	      {
    		  if(alrmval.get(log).equals(alrm_xl.get(xl)))
    		  {
    			  Cell temp = sheet1.getCell(3, xl+1); // getting solution column
        		  String info = temp.getContents();
        		  String e2_tst = info;
        		  
        		  Label sol_lab= new Label(3, 9+log, e2_tst, va_c); // solution for excel
    	    	  sheet.addCell(sol_lab);
        		  
        		  break;
    		  }
    		  else
    		  {
//    			  continue;
    		  }
	      }
      }
     
      sheet.mergeCells(0, 9, 0, 9+ialm-1);
      
      row_index = row_index + ialm-1;
      
//*****************      
      
//======      
    // protection group definition 
      
      row_index++;
      int hget=0, hget_def=0, cvcu=0;
	  
      for(String st : configList)
      {
    	  if(st.contains("> hget mspg switchMode|operationalState"))
    	  {
    		  hget = configList.indexOf(st);
    		  hget_def = hget+4;
    		  hget = hget+7;
    		  break;
	      }
      }
      String h1 = configList.get(hget_def)+"\n"+configList.get(hget_def+1)+"\n"+configList.get(hget_def+2)+"\n"; 
	    
      for(String st : configList)
      {
    	  if(st.contains("> cvcu"))
    	  {
    		  cvcu = configList.indexOf(st)-8;
    		  break;
    	  }
      }
	    
      String hget_str = null;
      String hget_val = "";

      for(int i=hget; i<=cvcu; i++)
      {
    	  hget_str = configList.get(i);
	    		
    	  if(hget_str.contains("ENABLED") && hget_str.contains("AUTOMATIC"))
    	  {
    		  Label hget_lab = new Label(1, row_index, "OK", green);
    		  sheet.addCell(hget_lab);
    	  }
    	  else
    	  {
    		  { 
    			  Label hget_val_str = new Label(1, row_index, "Warning", yellow);
    			  sheet.addCell(hget_val_str);
	    		
    			  hget_val+=hget_str+"\n";
    		  }
    		  
    		  double hget_h = h1.split(System.getProperty("line.separator")).length 
    		  				+ hget_val.split(System.getProperty("line.separator")).length;
    		  
    		  String lines[] =  h1.split("\\r?\\n");

              double count =0;
              for(String temp:lines)
              {
              	if(temp.length()>count)
                  count = temp.length();
              	count/=25;
              }
    		  
    		  Label hget_str1 = new Label(2, row_index, "Some of defined mspg are locked switchMode or/and in Disabled state", va_c);
    	      WritableCellFeatures cellFeatures = new WritableCellFeatures();
    	      cellFeatures.setComment(h1 + hget_val, count, hget_h);
    	      hget_str1.setCellFeatures(cellFeatures);
    	      sheet.addCell(hget_str1);
    	      
    	      sheet.setRowView(row_index, 1200);
    	  }
      }
      
      Label l1 = new Label(0, row_index, "Protection Group Definition", ca_b);
      sheet.addCell(l1);
	    
//==== 
	
	// get upgradePackage=R6_1_3_0 actionresult
		
    /*  row_index++;
      
      int inv_action=0, inv_action1=0;
      for(String st : configList)
      {
    	  if(st.contains(">>> 2.typeOfInvokedAction = 1 (VERIFY_UPGRADE)"))
    	  {
    		  inv_action = configList.indexOf(st);
    		  inv_action1 = inv_action+1;
    		  break;
    	  }
      }
      String inv_action_str  = configList.get(inv_action);
      String inv_action1_str = configList.get(inv_action1);
      
      if(inv_action1_str.contains("info = 0"))
      {
    	  Label inv_action_lab = new Label(1, row_index, "OK", green);
    	  sheet.addCell(inv_action_lab);
      }	
      else
      {
    	  Label inv_action_lab = new Label(1, row_index, "Warning", yellow);
    	  sheet.addCell(inv_action_lab);
    	  
    	  String inv_warn = inv_action_str + "\n" + inv_action1_str;
    	  
    	  double inv_warn_h = inv_warn.split(System.getProperty("line.separator")).length;
    	  
    	  Label inv_error = new Label(2, row_index, "error detected", va_c);		
    	  WritableCellFeatures cellFeatures_16 = new WritableCellFeatures();
    	  cellFeatures_16.setComment(inv_warn, 2, inv_warn_h);
    	  inv_error.setCellFeatures(cellFeatures_16);
    	  sheet.addCell(inv_error);
      }*/
      
      row_index++;
      int cvcu_s=0;
      for(String st : configList)
      {
    	  if(st.contains("Current UpgradePkg:     UpgradePackage="))
    	  {
    		  cvcu_s = configList.indexOf(st);
    		  break;
    	  }
      }
      String cv = configList.get(cvcu_s);
      
      String cv_spl[] = cv.split(" ");
//      System.out.println(cv_spl[6]); // upgrade pckg level
      
/*	  int cv1 = cv.indexOf("=")+1;
      int cv2 = cv.indexOf("CX");
      int cv12 = cv2-cv1;
      String cv_sw_pkg = cv.substring(cv1, cv2).trim();
*/

//      int cv_chk = configList.lastIndexOf(cv_spl[6]);	
//      System.out.println("last occurence " + cv_chk);
      
      int cvcu_lst=0;
      for(String st : configList)
      {
    	  if(st.contains(cv_spl[6]))
    	  {
    		  cvcu_lst = configList.lastIndexOf(st); // checks where it is in the next command
    	  }
      }
      String cvcu_str = configList.get(cvcu_lst+7); // checks whether struct[1] is present or not 
      												// and its index is cvcu_lst+7	
      
      if(cvcu_str.contains("Struct[1]"))
      {
    	  if(configList.get(cvcu_lst+9).endsWith("(VERIFY_UPGRADE)") && 
    			  configList.get(cvcu_lst+10).endsWith("(EXECUTED)") )
    	  {
    		  Label inv_action_lab = new Label(1, row_index, "OK", green);
        	  sheet.addCell(inv_action_lab);
    	  }
    	  else
    	  {
    		  Label inv_action_lab = new Label(1, row_index, "Warning", yellow);
        	  sheet.addCell(inv_action_lab);
        	  
        	  String sw_err = configList.get(cvcu_lst+9) + "\n" + configList.get(cvcu_lst+10);
        	  
        	  double sw_err_h = sw_err.split(System.getProperty("line.separator")).length;
        	  
        	  Label sw_obv = new Label(2, row_index, "", va_c);
    	      WritableCellFeatures sw_cmt = new WritableCellFeatures();
    	      sw_cmt.setComment(sw_err, 2, sw_err_h);
    	      sw_obv.setCellFeatures(sw_cmt);
    	      sheet.addCell(sw_obv);
    	  }
      }
      else
      {
    	  if(configList.get(cvcu_lst+3).endsWith("(VERIFY_UPGRADE)") && 
    			  configList.get(cvcu_lst+4).endsWith("(EXECUTED)") )
    	  {
    		  Label inv_action_lab = new Label(1, row_index, "OK", green);
        	  sheet.addCell(inv_action_lab);
    	  }
    	  else
    	  {
    		  Label inv_action_lab = new Label(1, row_index, "Warning", yellow);
        	  sheet.addCell(inv_action_lab);
        	  
        	  String sw_err = configList.get(cvcu_lst+3) + "\n" + configList.get(cvcu_lst+4);
        	  
        	  double sw_err_h = sw_err.split(System.getProperty("line.separator")).length;
        	  
        	  Label sw_obv = new Label(2, row_index, "", va_c);
    	      WritableCellFeatures sw_cmt = new WritableCellFeatures();
    	      sw_cmt.setComment(sw_err, 2, sw_err_h);
    	      sw_obv.setCellFeatures(sw_cmt);
    	      sheet.addCell(sw_obv);
    	  }
      }
    	  
      Label l2 = new Label(0, row_index, "Current upgrade package verified", ca_b);
      sheet.addCell(l2);
      
      
      
//==== st plug unit
		
      
      row_index++;
      int st_plug_unit=0, hget_cv_ver=0, st_plug_def=0;
      
      for(String st : configList)
      {
    	  if(st.contains("> st PlugInUnit="))
    	  {
    		  st_plug_unit = configList.indexOf(st);
    		  st_plug_def = st_plug_unit+3;
	    	  st_plug_unit= st_plug_unit+6;
	    	  break;
    	  }
      }
      
      //3 to 5
	    
      String p1 = configList.get(st_plug_def) + "\n" + configList.get(st_plug_def+1) + "\n" + configList.get(st_plug_def+2) + "\n"; 
      
      for(String st : configList)
      {
    	  if(st.contains("> hget ConfigurationVersion="))
    	  {
    		  hget_cv_ver = configList.indexOf(st);
    		  hget_cv_ver = hget_cv_ver-7;
    		  break;
	      }
      }
	    
      String plug_unit = null;
      String temp_plug = "";
      
      for(int i=st_plug_unit; i<=hget_cv_ver; i++)
      {
    	  plug_unit = configList.get(i);
    	  
    	  if(plug_unit.contains("UNLOCKED") && plug_unit.contains("ENABLED"))
    	  {
    		  Label plug_lab = new Label(1, row_index, "OK", green);
    		  sheet.addCell(plug_lab);
    	  }
    	  else
    	  {
    		  { 
    			  Label plug_lab = new Label(1, row_index, "warning", yellow);
    			  sheet.addCell(plug_lab);
    		  
    			  temp_plug+=plug_unit+"\n";
    		  }
    		  Label plug_lab_1 = new Label(2, row_index, "", va_c);
    		  
    		  double temp_plug_h = temp_plug.split(System.getProperty("line.separator")).length + 
    		  						      p1.split(System.getProperty("line.separator")).length;
    		  
    		  WritableCellFeatures st_comm = new WritableCellFeatures();
    		  st_comm.setComment(p1+temp_plug, 2, temp_plug_h);
    		  plug_lab_1.setCellFeatures(st_comm);
        	  sheet.addCell(plug_lab_1);
    	  }	
	    		
      }	
	    
      Label plug_lab1 = new Label(0, row_index, "Status of plug-in unit's", ca_b);
      sheet.addCell(plug_lab1);
      
//======= 
	
	// autoCreatedCVI
      
      row_index++;
      int cvi_start=0, cvi_chk=0;
      for(String st : configList)
      {
    	  if(st.contains("> hget ConfigurationVersion=1 autoCreatedCVIsTurnedOn|timeForA utoCreatedCV"))
    	  {
    		  cvi_start = configList.indexOf(st);
    		  cvi_chk   = cvi_start + 7; 
    		  cvi_start = cvi_start + 4;
    		  break;
	      }
      }
      String cvi_chk_str = configList.get(cvi_chk);
		
      if(cvi_chk_str.contains("true"))
      {
    	  Label cvi = new Label(1, row_index, "OK", green);
    	  sheet.addCell(cvi);
    	  
    	  String cvi_chk_split[] = cvi_chk_str.split(" ");
    	  String cvi_str = cvi_chk_split[cvi_chk_split.length - 1]; // last word
    	  Label cvi_lab = new Label(2, row_index, cvi_str, va_c);
    	  sheet.addCell(cvi_lab);
      }
      else
      {
    	  Label cvi = new Label(1, row_index, "Warning", yellow); //17
    	  sheet.addCell(cvi);
      }
      
      Label l3 = new Label(0, row_index, "Auto CV Creation check", ca_b);
      sheet.addCell(l3);
      
//-------      
	// > hget Aal2PathVccTp remoteBlockingState
		
      	row_index++;
		int rm_blk=0, rm_blk_end=0;
	    
		int rm_def=0;
		  
	    for(String st : configList)
	    {
	    	if(st.contains("> hget Aal2PathVccTp remoteBlockingState"))
	    	{
	    		rm_blk = configList.indexOf(st);
	    		rm_def = hget + 4;
		       
	    		rm_blk = rm_blk + 7;
	    		break;
		     }
	    }
	    
	    String rm_def_str = configList.get(rm_def) + "\n" + configList.get(rm_def+1) + "\n" + configList.get(rm_def+2); 
		    
	    for(String st : configList)
		{
	    	if( st.contains("cat ssc"))
	    	{
	    		rm_blk_end = configList.indexOf(st)-8;
//	    		rm_blk_end = rm_blk_end-4;
	    		break;
	    	}
		}
		    
	    String rm_blk_str = null;
	    String rm_blk_tmp = "";
	    
	    for(int i=rm_blk; i<=rm_blk_end; i++)
	    {
	    	rm_blk_str = configList.get(i);
	    	
	    	if(rm_blk_str.endsWith("(REMOTELY_UNBLOCKED)"))
	    	{
	    		Label hget_lab = new Label(1, row_index, "OK", green);
	    		sheet.addCell(hget_lab);
	    	}
	    	else
	    	{
	    		Label hget_lab = new Label(1, row_index, "warning", yellow);
	    		sheet.addCell(hget_lab);
		    		
	    		rm_blk_tmp+=rm_blk_str+"\n";
	    		
	    		double rm_blk_tmp_h = rm_def_str.split(System.getProperty("line.separator")).length 
	    							+ rm_blk_tmp.split(System.getProperty("line.separator")).length;
	    		
	    		Label rm_str = new Label(2, row_index, "NOT REMOTELY_UNBLOCKED", va_c);
	    	    WritableCellFeatures cellFeatures_18 = new WritableCellFeatures();
	    	    cellFeatures_18.setComment(rm_def_str + rm_blk_tmp, 2, rm_blk_tmp_h);
	    	    rm_str.setCellFeatures(cellFeatures_18);
	    	    sheet.addCell(rm_str);
	    	}
	    }
	    
	    Label aal2_rbs = new Label(0, row_index, "hget Aal2PathVccTp remoteBlockingState", ca_b);
	    sheet.addCell(aal2_rbs);
		    
/*//==== sys logs
		
	// AAL2 path remote operational state	
		
      	row_index++;
		int aal2=0;
		for(String st : configList)
	    {
	      if(st.contains("AAL2 path remote operational state"))
	      {
	    	  aal2 = configList.indexOf(st);
	    	  break;
	      }
	    }
		String aal2_str = configList.get(aal2);
		
		int att_dep=0;
		for(String st : configList)
	    {
	      if(st.contains("Attribute dependencies                           ["))
	      {
	    	  att_dep = configList.indexOf(st);
	    	  break;
	      }
	    }
		
		if(aal2_str.equals("AAL2 path remote operational state               [OK]"))
		{
			Label aal_lab1 = new Label(1, row_index, "OK", green);
			sheet.addCell(aal_lab1);
		}
		else if(aal2_str.equals("AAL2 path remote operational state               [WARNING]"))
		{
			Label aal_lab1 = new Label(1, row_index, "Warning", yellow);
			sheet.addCell(aal_lab1);
			
			String aal2_start = null;

			ArrayList<String> aal2_tmp = new ArrayList<String>(); 
			
			for(int i=aal2+2; i<=att_dep-4; i++)
			{
				aal2_start = configList.get(i);
				aal2_tmp.add(aal2_start);
				aal2_tmp.add("\n"); // warning and remedy 
			}
			
			int rem_ind=0;
			
			for(String warn : aal2_tmp)
			{
				if(warn.contains("REMEDY:"))
				{
					rem_ind = aal2_tmp.lastIndexOf(warn);
//					break;
				}
			}
				
			String warn_str = null;
			String warn_tmp = "";
				
			for(String warn : aal2_tmp)
			{
				for(int j=0; j<rem_ind; j++) // warning
				{
					warn_str = aal2_tmp.get(j);
					warn_tmp+=warn_str;
				}
				break;
			}
			
			double warn_tmp_h = warn_tmp.split(System.getProperty("line.separator")).length;
			
			warn_tmp.substring(0);
			
			String lines_w[] =  warn_tmp.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
			
			Label warn_lab1 = new Label(2, row_index, "Warning", va_c);
			WritableCellFeatures cellFeatures_1 = new WritableCellFeatures();
			cellFeatures_1.setComment(warn_tmp, count_w, warn_tmp_h);
            warn_lab1.setCellFeatures(cellFeatures_1);
			sheet.addCell(warn_lab1);
				
			String rem_str = null;
			String rem_tmp = "";
			
			for(int j=rem_ind; j<=aal2_tmp.lastIndexOf("\n"); j++)
			{
				rem_str = aal2_tmp.get(j); // remedy
				rem_tmp+=rem_str + "\n";
			}
			
			double rem_tmp_h = rem_tmp.split(System.getProperty("line.separator")).length;
			
			String lines_r[] =  rem_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
				
			Label rem_lab1 = new Label(3, row_index, "Remedy", va_c);
			WritableCellFeatures cellFeatures_2 = new WritableCellFeatures();
			cellFeatures_2.setComment(rem_tmp, count_r, rem_tmp_h);
			rem_lab1.setCellFeatures(cellFeatures_2);
			sheet.addCell(rem_lab1);
		}
		
		else if(aal2_str.startsWith("AAL2 path remote operational state") && aal2_str.endsWith("[INFO]"))
		{
			Label aal_lab1 = new Label(1, row_index, "Info", yellow);
			sheet.addCell(aal_lab1);
			
			String aal2_start = null;

			ArrayList<String> aal2_tmp = new ArrayList<String>(); 
			
			for(int i=aal2+2; i<=att_dep-4; i++)
			{
				aal2_start = configList.get(i);
				aal2_tmp.add(aal2_start);
				aal2_tmp.add("\n"); // warning and remedy 
			}
			
			int rem_ind=0;
			
			for(String warn : aal2_tmp)
			{
				if(warn.contains("REMEDY:"))
				{
					rem_ind = aal2_tmp.lastIndexOf(warn);
//					break;
				}
			}
				
			String warn_str = null;
			String warn_tmp = "";
				
			for(String warn : aal2_tmp)
			{
				for(int j=0; j<rem_ind; j++) // warning
				{
					warn_str = aal2_tmp.get(j);
					warn_tmp+=warn_str;
				}
				break;
			}
			
			double warn_tmp_h = warn_tmp.split(System.getProperty("line.separator")).length;
			
			warn_tmp.substring(0);
			
			String lines_w[] =  warn_tmp.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
			
			Label warn_lab1 = new Label(2, row_index, "Warning", va_c);
			WritableCellFeatures cellFeatures_1 = new WritableCellFeatures();
			cellFeatures_1.setComment(warn_tmp, count_w, warn_tmp_h);
            warn_lab1.setCellFeatures(cellFeatures_1);
			sheet.addCell(warn_lab1);
				
			String rem_str = null;
			String rem_tmp = "";
			
			for(int j=rem_ind; j<=aal2_tmp.lastIndexOf("\n"); j++)
			{
				rem_str = aal2_tmp.get(j); // remedy
				rem_tmp+=rem_str + "\n";
			}
			
			double rem_tmp_h = rem_tmp.split(System.getProperty("line.separator")).length;
			
			String lines_r[] =  rem_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
				
			Label rem_lab1 = new Label(3, row_index, "Remedy", va_c);
			WritableCellFeatures cellFeatures_2 = new WritableCellFeatures();
			cellFeatures_2.setComment(rem_tmp, count_r, rem_tmp_h);
			rem_lab1.setCellFeatures(cellFeatures_2);
			sheet.addCell(rem_lab1);
		}
		

		Label l5 = new Label(0, row_index, "AAL2 path remote operational state", ca_b);
		sheet.addCell(l5);
	      
//==========
		
	// Attribute Dependencies path remote operational state
	      
	    row_index++;  
		int aal3=0;
        for(String st : configList)
        {
          if(st.contains("Attribute dependencies"))
          {
              aal3 = configList.indexOf(st);
              break;
          }
        }
        String aal3_str = configList.get(aal3);

        int att_dep1=0;
        for(String st : configList)
        {
          if(st.contains("CMXB external configuration                      ["))
          {
              att_dep1 = configList.indexOf(st);
              break;
          }
        }
//        String att_dep1_str = configList.get(att_dep1);

        if(aal3_str.equals("Attribute dependencies               [OK]"))
        {
            Label aal_lab2 = new Label(1, row_index, "OK", green);
            sheet.addCell(aal_lab2);
        }
        else
        {
            Label aal_lab2 = new Label(1, row_index, "warning", yellow);
            sheet.addCell(aal_lab2);

            String aal3_start = null;

            ArrayList<String> aal3_tmp = new ArrayList<String>();

            for(int i=aal3+2; i<=att_dep1-4; i++)
            {
                aal3_start = configList.get(i);
                aal3_tmp.add(aal3_start);
                aal3_tmp.add("\n"); // warning and remedy
            }

            int rem_ind1=0;

            for(String warn : aal3_tmp)
            {
            	if(warn.contains("REMEDY:"))
                {
                    rem_ind1 = aal3_tmp.indexOf(warn);
//                  break;
                }
            }

            String warn_str1 = null;
            String warn_tmp1 = "";

            for(String warn : aal3_tmp)
            {
                for(int j=0; j<rem_ind1; j++) // warning
                {
                    warn_str1 = aal3_tmp.get(j);
                    warn_tmp1+=warn_str1;
                }
                break;
            }

            double warn_tmp1_h = warn_tmp1.split(System.getProperty("line.separator")).length;
            String lines1[] =  warn_tmp1.split("\\r?\\n");

            double count1 =0;
            for(String temp:lines1)
            {
            	if(temp.length()>count1)
                count1 = temp.length();
            	count1/=25;
            }

            Label warn_lab3 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_3 = new WritableCellFeatures();
            cellFeatures_3.setComment(warn_tmp1, count1, warn_tmp1_h);
            warn_lab3.setCellFeatures(cellFeatures_3);
            sheet.addCell(warn_lab3);

            String rem_str1 = null;
            String rem_tmp1 = "";

            for(int j=rem_ind1; j<=aal3_tmp.lastIndexOf("\n"); j++)
            {
                rem_str1 = aal3_tmp.get(j); // remedy
                rem_tmp1+=rem_str1 + "\n";
            }

//                System.out.println("remedy " + rem_tmp1);

            double rem_tmp1_h = rem_tmp1.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_tmp1.split("\\r?\\n");

            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count1)
                count_r = temp.length();
            	count_r/=25;
            }

            Label rem_lab3 = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_4 = new WritableCellFeatures();
            cellFeatures_4.setComment(rem_tmp1, count_r, rem_tmp1_h);
            rem_lab3.setCellFeatures(cellFeatures_4);
            sheet.addCell(rem_lab3);
        }
        
        Label l6 = new Label(0, row_index, "Attribute dependencies", ca_b);
        sheet.addCell(l6);
        
//==== 
        
     // CMXB external configuration

        row_index++;
		int cmxb=0;
        for(String st : configList)
        {
          if(st.contains("CMXB external configuration                      ["))
          {
              cmxb = configList.indexOf(st);
              break;
          }
        }
        String cmxb_str = configList.get(cmxb);

        int etmfg=0;
        for(String st : configList)
        {
          if(st.contains("ETMFG VLAN configuration                         ["))
          {
        	  etmfg = configList.indexOf(st);
              break;
          }
        }
//        String etmfg_str = configList.get(etmfg);

        if(cmxb_str.equals("CMXB external configuration                      [OK]"))
        {
            Label cmxb_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(cmxb_lab);
        }
        else
        {
            Label cmxb_lab1 = new Label(1, row_index, "warning", yellow);
            sheet.addCell(cmxb_lab1);

            String cmxb_start = null;

            ArrayList<String> cmxb_tmp = new ArrayList<String>();

            for(int i=cmxb+2; i<=etmfg-4; i++)
            {
            	cmxb_start = configList.get(i);
            	cmxb_tmp.add(cmxb_start);
            	cmxb_tmp.add("\n"); // warning and remedy
            }

            int rem_cmxb=0;
            for(String warn : cmxb_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                    rem_cmxb = cmxb_tmp.indexOf(warn);
                }
            }

            String warn_cmxb_str = null;
            String warn_tmp_str = "";

            for(String warn : cmxb_tmp)
            {
                for(int j=0; j<rem_cmxb; j++) // warning
                {
                    warn_cmxb_str = cmxb_tmp.get(j);
                    warn_tmp_str+=warn_cmxb_str;
                }
                break;
            }
            
            double warn_tmp_str_h = warn_tmp_str.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_tmp_str.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label warn_lab3 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_5 = new WritableCellFeatures();
            cellFeatures_5.setComment(warn_tmp_str, count_w, warn_tmp_str_h);
            warn_lab3.setCellFeatures(cellFeatures_5);
            sheet.addCell(warn_lab3);

            String rem_str_cmxb = null;
            String rem_tmp_cmxb = "";

            for(int j=rem_cmxb; j<=cmxb_tmp.lastIndexOf("\n"); j++)
            {
                rem_str_cmxb = cmxb_tmp.get(j); // remedy
                rem_tmp_cmxb+=rem_str_cmxb + "\n";
            }

            double rem_tmp_cmxb_h = rem_tmp_cmxb.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_tmp_cmxb.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_cmxb_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_4 = new WritableCellFeatures();
            cellFeatures_4.setComment(rem_tmp_cmxb, count_r, rem_tmp_cmxb_h);
            rem_cmxb_lab.setCellFeatures(cellFeatures_4);
            sheet.addCell(rem_cmxb_lab);
        }
        
        Label cmx_l = new Label(0, row_index, "CMXB external configuration", ca_b);
        sheet.addCell(cmx_l);
        
//=====

   // ETMFG VLAN configuration
        
        row_index++;
        int aal4=0;
        for(String st : configList)
        {
          if(st.contains("ETMFG VLAN configuration"))
          {
              aal4 = configList.indexOf(st);
              break;
          }
        }
        String aal4_str = configList.get(aal4);

        int att_dep2=0;
        for(String st : configList)
        {
          if(st.contains("Failed user plane devices                        ["))
          {
              att_dep2 = configList.indexOf(st);
              break;
          }
        }
//        String att_dep2_str = configList.get(att_dep2);

        if(aal4_str.equals("ETMFG VLAN configuration                         [OK]"))
        {
            Label aal_lab3 = new Label(1, row_index, "OK", green);
            sheet.addCell(aal_lab3);
        }
        else
        {
            Label aal_lab3 = new Label(1, row_index, "warning", yellow);
            sheet.addCell(aal_lab3);

            String aal4_start = null;

            ArrayList<String> aal4_tmp = new ArrayList<String>();

            for(int i=aal4+2; i<=att_dep2-4; i++)
            {
                aal4_start = configList.get(i);
                aal4_tmp.add(aal4_start);
                aal4_tmp.add("\n"); // warning and remedy
            }

//            int war_ind2=0; 
            int rem_ind2=0;

            for(String warn : aal4_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                    rem_ind2 = aal4_tmp.indexOf(warn);
                }
            }

            String warn_str2 = null;
            String warn_tmp2 = "";

            for(String warn : aal4_tmp)
            {
                for(int j=0; j<rem_ind2; j++) // warning
                {
                    warn_str2 = aal4_tmp.get(j);
                    warn_tmp2+=warn_str2;
                }
                break;
            }

            double warn_tmp2_h = warn_tmp2.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_tmp2.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label warn_lab3 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_5 = new WritableCellFeatures();
            cellFeatures_5.setComment(warn_tmp2, count_w, warn_tmp2_h);
            warn_lab3.setCellFeatures(cellFeatures_5);
            sheet.addCell(warn_lab3);

            String rem_str2 = null;
            String rem_tmp2 = "";

            for(int j=rem_ind2; j<=aal4_tmp.lastIndexOf("\n"); j++)
            {
                rem_str2 = aal4_tmp.get(j); // remedy
                rem_tmp2+=rem_str2 + "\n";
            }
            
            double rem_tmp2_h = rem_tmp2.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_tmp2.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

            Label rem_lab4 = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_6 = new WritableCellFeatures();
            cellFeatures_6.setComment(rem_tmp2, count_r, rem_tmp2_h);
            rem_lab4.setCellFeatures(cellFeatures_6);
            sheet.addCell(rem_lab4);
        }
        
        Label l8 = new Label(0, row_index, "ETMFG VLAN configuration", ca_b);
        sheet.addCell(l8);
//==== 
        
   // Failed user plane devices
        
        row_index++;
        int f_upd_start=0;
        for(String st : configList)
        {
          if(st.contains("Failed user plane devices                        ["))
          {
        	  f_upd_start = configList.indexOf(st);
              break;
          }
        }
        String f_upd_start_str = configList.get(f_upd_start);

        int f_upd_end=0;
        for(String st : configList)
        {
          if(st.contains("GigaBitEthernet link redundancy                  ["))
          {
        	  f_upd_end = configList.indexOf(st);
              break;
          }
        }
//        String f_upd_end_str = configList.get(f_upd_end);

        if(f_upd_start_str.equals("Failed user plane devices                        [OK]"))
        {
            Label f_upd_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(f_upd_lab);
        }
        else
        {
            Label f_upd_lab = new Label(1, row_index, "warning", yellow);
            sheet.addCell(f_upd_lab);

            String f_upd_str = null;

            ArrayList<String> f_upd_tmp = new ArrayList<String>();

            for(int i=f_upd_start+2; i<=f_upd_end-4; i++)
            {
            	f_upd_str = configList.get(i);
            	f_upd_tmp.add(f_upd_str);
            	f_upd_tmp.add("\n"); // warning and remedy
            }

//            int warn_f_upd=0; 
            int rem_f_upd=0;

            for(String warn : f_upd_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_f_upd = f_upd_tmp.indexOf(warn);
                }
            }

            String warn_f_upd_str = null;
            String warn_f_upd_tmp = "";

            for(String warn : f_upd_tmp)
            {
                for(int j=0; j<rem_f_upd; j++) // warning
                {
                	warn_f_upd_str = f_upd_tmp.get(j);
                	warn_f_upd_tmp+=warn_f_upd_str;
                }
                break;
            }

            double warn_f_upd_tmp_h = warn_f_upd_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_f_upd_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label f_upd_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_22 = new WritableCellFeatures();
            cellFeatures_22.setComment(warn_f_upd_tmp, count_w, warn_f_upd_tmp_h);
            f_upd_lab1.setCellFeatures(cellFeatures_22);
            sheet.addCell(f_upd_lab1);

            String rem_str2 = null;
            String rem_tmp2 = "";

            for(int j=rem_f_upd; j<=f_upd_tmp.lastIndexOf("\n"); j++)
            {
            	rem_str2 = f_upd_tmp.get(j); // remedy
                rem_tmp2+=rem_str2 + "\n";
            }
            
            double rem_tmp2_h = rem_tmp2.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_tmp2.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

            Label rem_f_upd_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_f = new WritableCellFeatures();
            cellFeatures_f.setComment(rem_tmp2, count_r, rem_tmp2_h);
            rem_f_upd_lab.setCellFeatures(cellFeatures_f);
            sheet.addCell(rem_f_upd_lab);
        }
        
        Label l9 = new Label(0, row_index, "Failed user plane devices", ca_b);
        sheet.addCell(l9);
        
//=======
    // GigaBitEthernet link redundancy
		
        row_index++;
    	int gb_start=0;
        for(String st : configList)
        {
          if(st.contains("GigaBitEthernet link redundancy                  ["))
          {
        	  gb_start = configList.indexOf(st);
              break;
          }
        }
        String gb_start_str = configList.get(gb_start);

        int gb_end=0;
        for(String st : configList)
        {
          if(st.contains("M3UA Signalling termination                      ["))
          {
        	  gb_end = configList.indexOf(st);
              break;
          }
        }
//        String gb_end_str = configList.get(gb_end);

        if(gb_start_str.equals("GigaBitEthernet link redundancy                  [OK]"))
        {
        	Label gb_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(gb_lab);
        }
        else
        {
        	Label gb_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(gb_lab);

            String gb_str = null;
            ArrayList<String> gb_tmp = new ArrayList<String>();

            for(int i=gb_start+2; i<=gb_end-4; i++)
            {
            	gb_str = configList.get(i);
            	gb_tmp.add(gb_str);
            	gb_tmp.add("\n"); // warning and remedy
            }

//            int warn_gb=0;  
            int rem_gb=0;

            for(String warn : gb_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_gb = gb_tmp.indexOf(warn);
                }
            }

            String warn_gb_str = null;
            String warn_gb_tmp = "";

            for(String warn : gb_tmp)
            {
                for(int j=0; j<rem_gb; j++) // warning
                {
                	warn_gb_str = gb_tmp.get(j);
                	warn_gb_tmp+=warn_gb_str;
                }
                break;
            }
            
            double warn_gb_tmp_h = warn_gb_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_gb_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }

            Label gb_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_23 = new WritableCellFeatures();
            cellFeatures_23.setComment(warn_gb_tmp, count_w, warn_gb_tmp_h);
            gb_lab1.setCellFeatures(cellFeatures_23);
            sheet.addCell(gb_lab1);

            String rem_gb_str = null;
            String rem_gb_tmp = "";

            for(int j=rem_gb; j<=gb_tmp.lastIndexOf("\n"); j++)
            {
            	rem_gb_str = gb_tmp.get(j); // remedy
                rem_gb_tmp+=rem_gb_str + "\n";
            }

            double rem_gb_tmp_h = rem_gb_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_gb_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_gb_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_gb = new WritableCellFeatures();
            cellFeatures_gb.setComment(rem_gb_tmp, count_r, rem_gb_tmp_h);
            rem_gb_lab.setCellFeatures(cellFeatures_gb);
            sheet.addCell(rem_gb_lab);
        }        
        
        Label l10= new Label(0, row_index, "GigaBitEthernet link redundancy", ca_b);
        sheet.addCell(l10);
        
//=======M3UA Signalling termination
        
        row_index++;
    	int m3uasig_start=0;
        for(String st : configList)
        {
          if(st.contains("M3UA Signalling termination                      ["))
          {
        	  m3uasig_start = configList.indexOf(st);
              break;
          }
        }
        String m3uasig_start_str = configList.get(m3uasig_start);
        
        
        int m3uasig_end=0;
        for(String st : configList)
        {
          if(st.contains("M3ua timer values                                ["))
          {
        	  m3uasig_end = configList.indexOf(st);
              break;
          }
        }
//        String m3uasig_end_str = configList.get(m3uasig_end);
        
        if(m3uasig_start_str.equals("M3UA Signalling termination                      [OK]"))
        {
        	Label m3uasig_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(m3uasig_lab);
        }
        else
        {
        	Label m3uasig_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(m3uasig_lab);

            String m3uasig_str = null;
            ArrayList<String> m3uasig_tmp = new ArrayList<String>();
            
            for(int i=m3uasig_start+2; i<=m3uasig_end-4; i++)
            {
            	m3uasig_str = configList.get(i);
            	m3uasig_tmp.add(m3uasig_str);
            	m3uasig_tmp.add("\n"); // warning and remedy
            }

//            int warn_m3uasig=0; 
            int rem_m3uasig=0;

            for(String warn : m3uasig_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_m3uasig = m3uasig_tmp.indexOf(warn);
                }
            }

            String warn_m3uasig_str = null;
            String warn_m3uasig_tmp = "";

            for(String warn : m3uasig_tmp)
            {
                for(int j=0; j<rem_m3uasig; j++) // warning
                {
                	warn_m3uasig_str = m3uasig_tmp.get(j);
                	warn_m3uasig_tmp+=warn_m3uasig_str;
                }
                break;
            }

            double warn_m3uasig_tmp_h = warn_m3uasig_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_m3uasig_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label m3uasig_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_24 = new WritableCellFeatures();
            cellFeatures_24.setComment(warn_m3uasig_tmp, count_w, warn_m3uasig_tmp_h);
            m3uasig_lab1.setCellFeatures(cellFeatures_24);
            sheet.addCell(m3uasig_lab1);

            String rem_m3uasig_str = null;
            String rem_m3uasig_tmp = "";

            for(int j=rem_m3uasig; j<=m3uasig_tmp.lastIndexOf("\n"); j++)
            {
            	rem_m3uasig_str = m3uasig_tmp.get(j); // remedy
                rem_m3uasig_tmp+=rem_m3uasig_str + "\n";
            }

            double rem_m3uasig_tmp_h = rem_m3uasig_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_m3uasig_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_m3uasig_lab = new Label(3, 24, "Remedy", va_c);
            WritableCellFeatures cellFeatures_m3uasig = new WritableCellFeatures();
            cellFeatures_m3uasig.setComment(rem_m3uasig_tmp, count_r, rem_m3uasig_tmp_h);
            rem_m3uasig_lab.setCellFeatures(cellFeatures_m3uasig);
            sheet.addCell(rem_m3uasig_lab);
        }   
        
        Label m3ua= new Label(0, row_index, "M3UA Signalling termination", ca_b);
        sheet.addCell(m3ua);
        
        
//=======M3ua timer values    
        
        row_index++;
        int m3uatimer_start=0;
        for(String st : configList)
        {
          if(st.contains("M3ua timer values                                ["))
          {
        	  m3uatimer_start = configList.indexOf(st);
              break;
          }
        }
        String m3uatimer_start_str = configList.get(m3uatimer_start);
        
        int m3uatimer_end=0;
        for(String st : configList)
        {
          if(st.contains("MTP3b Local termination                          ["))
          {
        	  m3uatimer_end = configList.indexOf(st);
              break;
          }
        }
//        String m3uatimer_end_str = configList.get(m3uatimer_end);
        
        
        if(m3uatimer_start_str.equals("M3ua timer values                                [OK]"))
        {
        	Label m3uatimer_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(m3uatimer_lab);
        }
        else
        {
        	Label m3uatimer_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(m3uatimer_lab);

            String m3uatimer_str = null;
            ArrayList<String> m3uatimer_tmp = new ArrayList<String>();
            
            for(int i=m3uatimer_start+2; i<=m3uatimer_end-4; i++)
            {
            	m3uatimer_str = configList.get(i);
            	m3uatimer_tmp.add(m3uatimer_str);
            	m3uatimer_tmp.add("\n"); // warning and remedy
            }

//            int warn_m3uatimer=0;
            int rem_m3uatimer=0;

            for(String warn : m3uatimer_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_m3uatimer = m3uatimer_tmp.indexOf(warn);
                }
            }

            String warn_m3uatimer_str = null;
            String warn_m3uatimer_tmp = "";

            for(String warn : m3uatimer_tmp)
            {
                for(int j=0; j<rem_m3uatimer; j++) // warning
                {
                	warn_m3uatimer_str = m3uatimer_tmp.get(j);
                	warn_m3uatimer_tmp+=warn_m3uatimer_str;
                }
                break;
            }

            double warn_m3uatimer_tmp_h = warn_m3uatimer_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_m3uatimer_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label m3uatimer_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_25 = new WritableCellFeatures();
            cellFeatures_25.setComment(warn_m3uatimer_tmp, count_w, warn_m3uatimer_tmp_h);
            m3uatimer_lab1.setCellFeatures(cellFeatures_25);
            sheet.addCell(m3uatimer_lab1);

            String rem_m3uatimer_str = null;
            String rem_m3uatimer_tmp = "";

            for(int j=rem_m3uatimer; j<=m3uatimer_tmp.lastIndexOf("\n"); j++)
            {
            	rem_m3uatimer_str = m3uatimer_tmp.get(j); // remedy
                rem_m3uatimer_tmp+=rem_m3uatimer_str + "\n";
            }

            double rem_m3uatimer_tmp_h = rem_m3uatimer_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_m3uatimer_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_m3uatimer_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_m3uatimer = new WritableCellFeatures();
            cellFeatures_m3uatimer.setComment(rem_m3uatimer_tmp, count_r, rem_m3uatimer_tmp_h);
            rem_m3uatimer_lab.setCellFeatures(cellFeatures_m3uatimer);
            sheet.addCell(rem_m3uatimer_lab);
        }  
        Label m3ua_1= new Label(0, row_index, "M3ua timer values", ca_b);
        sheet.addCell(m3ua_1);
        

//=======MTP3b Local termination
        
        row_index++;
    	int mtp3blocal_start=0;
        for(String st : configList)
        {
          if(st.contains("MTP3b Local termination                          ["))
          {
        	  mtp3blocal_start = configList.indexOf(st);
              break;
          }
        }
        String mtp3blocal_start_str = configList.get(mtp3blocal_start);
        
        
        int mtp3blocal_end=0;
        for(String st : configList)
        {
          if(st.contains("MTP3b Remote termination                         ["))
          {
        	  mtp3blocal_end = configList.indexOf(st);
              break;
          }
        }
//        String mtp3blocal_end_str = configList.get(mtp3blocal_end);
        
        if(mtp3blocal_start_str.equals("MTP3b Local termination                          [OK]"))
        {
        	Label mtp3blocal_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(mtp3blocal_lab);
        }
        else
        {
        	Label mtp3blocal_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(mtp3blocal_lab);

            String mtp3blocal_str = null;
            ArrayList<String> mtp3blocal_tmp = new ArrayList<String>();
            
            for(int i=mtp3blocal_start+2; i<=mtp3blocal_end-4; i++)
            {
            	mtp3blocal_str = configList.get(i);
            	mtp3blocal_tmp.add(mtp3blocal_str);
            	mtp3blocal_tmp.add("\n"); // warning and remedy
            }

//            int warn_mtp3blocal=0;
            int rem_mtp3blocal=0;

            for(String warn : mtp3blocal_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_mtp3blocal = mtp3blocal_tmp.indexOf(warn);
                }
            }

            String warn_mtp3blocal_str = null;
            String warn_mtp3blocal_tmp = "";

            for(String warn : mtp3blocal_tmp)
            {
                for(int j=0; j<rem_mtp3blocal; j++) // warning
                {
                	warn_mtp3blocal_str = mtp3blocal_tmp.get(j);
                	warn_mtp3blocal_tmp+=warn_mtp3blocal_str;
                }
                break;
            }

            double warn_mtp3blocal_tmp_h = warn_mtp3blocal_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_mtp3blocal_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label mtp3blocal_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_26 = new WritableCellFeatures();
            cellFeatures_26.setComment(warn_mtp3blocal_tmp, count_w, warn_mtp3blocal_tmp_h);
            mtp3blocal_lab1.setCellFeatures(cellFeatures_26);
            sheet.addCell(mtp3blocal_lab1);

            String rem_mtp3blocal_str = null;
            String rem_mtp3blocal_tmp = "";

            for(int j=rem_mtp3blocal; j<=mtp3blocal_tmp.lastIndexOf("\n"); j++)
            {
            	rem_mtp3blocal_str = mtp3blocal_tmp.get(j); // remedy
                rem_mtp3blocal_tmp+=rem_mtp3blocal_str + "\n";
            }

            double rem_mtp3blocal_tmp_h = rem_mtp3blocal_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_mtp3blocal_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_mtp3blocal_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_mtp3blocal = new WritableCellFeatures();
            cellFeatures_mtp3blocal.setComment(rem_mtp3blocal_tmp, count_r, rem_mtp3blocal_tmp_h);
            rem_mtp3blocal_lab.setCellFeatures(cellFeatures_mtp3blocal);
            sheet.addCell(rem_mtp3blocal_lab);
        }     
        Label mtp= new Label(0, row_index, "MTP3b Local termination", ca_b);
        sheet.addCell(mtp);
        

//=======MTP3b Remote termination  
        
        row_index++;
        int mtp3bremote_start=0;
        for(String st : configList)
        {
          if(st.contains("MTP3b Remote termination                         ["))
          {
        	  mtp3bremote_start = configList.indexOf(st);
              break;
          }
        }
        String mtp3bremote_start_str = configList.get(mtp3bremote_start);
        
        
        int mtp3bremote_end=0;
        for(String st : configList)
        {
          if(st.contains("Maximum NniSaalTp termination points per GPB     ["))
          {
        	  mtp3bremote_end = configList.indexOf(st);
              break;
          }
        }
//        String mtp3bremote_end_str = configList.get(mtp3bremote_end);
        
        if(mtp3bremote_start_str.equals("MTP3b Remote termination                         [OK]"))
        {
        	Label mtp3bremote_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(mtp3bremote_lab);
        }
        else
        {
        	Label mtp3bremote_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(mtp3bremote_lab);

            String mtp3bremote_str = null;
            ArrayList<String> mtp3bremote_tmp = new ArrayList<String>();
            
            for(int i=mtp3bremote_start+2; i<=mtp3bremote_end-4; i++)
            {
            	mtp3bremote_str = configList.get(i);
            	mtp3bremote_tmp.add(mtp3bremote_str);
            	mtp3bremote_tmp.add("\n"); // warning and remedy
            }

//            int warn_mtp3bremote=0; 
            int rem_mtp3bremote=0;

            for(String warn : mtp3bremote_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_mtp3bremote = mtp3bremote_tmp.indexOf(warn);
                }
            }

            String warn_mtp3bremote_str = null;
            String warn_mtp3bremote_tmp = "";

            for(String warn : mtp3bremote_tmp)
            {
                for(int j=0; j<rem_mtp3bremote; j++) // warning
                {
                	warn_mtp3bremote_str = mtp3bremote_tmp.get(j);
                	warn_mtp3bremote_tmp+=warn_mtp3bremote_str;
                }
                break;
            }

            double warn_mtp3bremote_tmp_h = warn_mtp3bremote_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_mtp3bremote_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label mtp3bremote_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_27 = new WritableCellFeatures();
            cellFeatures_27.setComment(warn_mtp3bremote_tmp, count_w, warn_mtp3bremote_tmp_h);
            mtp3bremote_lab1.setCellFeatures(cellFeatures_27);
            sheet.addCell(mtp3bremote_lab1);

            String rem_mtp3bremote_str = null;
            String rem_mtp3bremote_tmp = "";

            for(int j=rem_mtp3bremote; j<=mtp3bremote_tmp.lastIndexOf("\n"); j++)
            {
            	rem_mtp3bremote_str = mtp3bremote_tmp.get(j); // remedy
                rem_mtp3bremote_tmp+=rem_mtp3bremote_str + "\n";
            }
            
            double rem_mtp3bremote_tmp_h = rem_mtp3bremote_tmp.split(System.getProperty("line.separator")).length;

            String lines_r[] =  rem_mtp3bremote_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_mtp3bremote_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_mtp3bremote = new WritableCellFeatures();
            cellFeatures_mtp3bremote.setComment(rem_mtp3bremote_tmp, count_r, rem_mtp3bremote_tmp_h);
            rem_mtp3bremote_lab.setCellFeatures(cellFeatures_mtp3bremote);
            sheet.addCell(rem_mtp3bremote_lab);
        }      
        
        Label mtp_1= new Label(0, row_index, "MTP3b Remote termination", ca_b);
        sheet.addCell(mtp_1);
        
//=======Maximum NniSaalTp termination points per GPB
        
        row_index++;
        int MaxNni_start=0;
        for(String st : configList)
        {
          if(st.contains("Maximum NniSaalTp termination points per GPB     ["))
          {
        	  MaxNni_start = configList.indexOf(st);
              break;
          }
        }
        String MaxNni_start_str = configList.get(MaxNni_start);
        
        int MaxNni_end=0;
        for(String st : configList)
        {
          if(st.contains("Maximum SCTP associations per GPB                ["))
          {
        	  MaxNni_end = configList.indexOf(st);
              break;
          }
        }
//        String MaxNni_end_str = configList.get(MaxNni_end);
        
        if(MaxNni_start_str.equals("Maximum NniSaalTp termination points per GPB     [OK]"))
        {
        	Label MaxNni_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(MaxNni_lab);
        }
        else
        {
        	Label MaxNni_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(MaxNni_lab);

            String MaxNni_str = null;
            ArrayList<String> MaxNni_tmp = new ArrayList<String>();
            
            for(int i=MaxNni_start+2; i<=MaxNni_end-4; i++)
            {
            	MaxNni_str = configList.get(i);
            	MaxNni_tmp.add(MaxNni_str);
            	MaxNni_tmp.add("\n"); // warning and remedy
            }

//            int warn_MaxNni=0;
            int rem_MaxNni=0;

            for(String warn : MaxNni_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_MaxNni = MaxNni_tmp.indexOf(warn);
                }
            }

            String warn_MaxNni_str = null;
            String warn_MaxNni_tmp = "";

            for(String warn : MaxNni_tmp)
            {
                for(int j=0; j<rem_MaxNni; j++) // warning
                {
                	warn_MaxNni_str = MaxNni_tmp.get(j);
                	warn_MaxNni_tmp+=warn_MaxNni_str;
                }
                break;
            }

            double warn_MaxNni_tmp_h = warn_MaxNni_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_MaxNni_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label MaxNni_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_28 = new WritableCellFeatures();
            cellFeatures_28.setComment(warn_MaxNni_tmp, count_w, warn_MaxNni_tmp_h);
            MaxNni_lab1.setCellFeatures(cellFeatures_28);
            sheet.addCell(MaxNni_lab1);

            String rem_MaxNni_str = null;
            String rem_MaxNni_tmp = "";

            for(int j=rem_MaxNni; j<=MaxNni_tmp.lastIndexOf("\n"); j++)
            {
            	rem_MaxNni_str = MaxNni_tmp.get(j); // remedy
                rem_MaxNni_tmp+=rem_MaxNni_str + "\n";
            }

            double rem_MaxNni_tmp_h = rem_MaxNni_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_MaxNni_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_MaxNni_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_MaxNni = new WritableCellFeatures();
            cellFeatures_MaxNni.setComment(rem_MaxNni_tmp, count_r, rem_MaxNni_tmp_h);
            rem_MaxNni_lab.setCellFeatures(cellFeatures_MaxNni);
            sheet.addCell(rem_MaxNni_lab);
        }        
        
        Label nni = new Label(0, row_index, "Maximum NniSaalTp termination points per GPB", ca_b);
        sheet.addCell(nni);

//=======Maximum SCTP associations per GPB 
        
        row_index++;
    	int MaxSCTP_start=0;
        for(String st : configList)
        {
          if(st.contains("Maximum SCTP associations per GPB                ["))
          {
        	  MaxSCTP_start = configList.indexOf(st);
              break;
          }
        }
        String MaxSCTP_start_str = configList.get(MaxSCTP_start);
        
        
        int MaxSCTP_end=0;
        for(String st : configList)
        {
          if(st.contains("Maximum TDM connections on ETC41                 ["))
          {
        	  MaxSCTP_end = configList.indexOf(st);
              break;
          }
        }
//        String MaxSCTP_end_str = configList.get(MaxSCTP_end);
        
        if(MaxSCTP_start_str.equals("Maximum SCTP associations per GPB                [OK]"))
        {
        	Label MaxSCTP_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(MaxSCTP_lab);
        }
        else
        {
        	Label MaxSCTP_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(MaxSCTP_lab);

            String MaxSCTP_str = null;
            ArrayList<String> MaxSCTP_tmp = new ArrayList<String>();
            
            for(int i=MaxSCTP_start+2; i<=MaxSCTP_end-4; i++)
            {
            	MaxSCTP_str = configList.get(i);
            	MaxSCTP_tmp.add(MaxSCTP_str);
            	MaxSCTP_tmp.add("\n"); // warning and remedy
            }

//            int warn_MaxSCTP=0;
            int rem_MaxSCTP=0;

            for(String warn : MaxSCTP_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_MaxSCTP = MaxSCTP_tmp.indexOf(warn);
                }
            }

            String warn_MaxSCTP_str = null;
            String warn_MaxSCTP_tmp = "";

            for(String warn : MaxSCTP_tmp)
            {
                for(int j=0; j<rem_MaxSCTP; j++) // warning
                {
                	warn_MaxSCTP_str = MaxSCTP_tmp.get(j);
                	warn_MaxSCTP_tmp+=warn_MaxSCTP_str;
                }
                break;
            }
            
            double warn_MaxSCTP_tmp_h = warn_MaxSCTP_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_MaxSCTP_tmp.split("\\r?\\n");

    		double count_w =0;
    		for(String temp:lines_w)
    		{
    			if(temp.length()>count_w)
    				count_w = temp.length();
    			count_w/=25;
    		}

            Label MaxSCTP_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_29 = new WritableCellFeatures();
            cellFeatures_29.setComment(warn_MaxSCTP_tmp, count_w, warn_MaxSCTP_tmp_h);
            MaxSCTP_lab1.setCellFeatures(cellFeatures_29);
            sheet.addCell(MaxSCTP_lab1);

            String rem_MaxSCTP_str = null;
            String rem_MaxSCTP_tmp = "";

            for(int j=rem_MaxSCTP; j<=MaxSCTP_tmp.lastIndexOf("\n"); j++)
            {
            	rem_MaxSCTP_str = MaxSCTP_tmp.get(j); // remedy
                rem_MaxSCTP_tmp+=rem_MaxSCTP_str + "\n";
            }

            double rem_MaxSCTP_tmp_h = rem_MaxSCTP_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_MaxSCTP_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_MaxSCTP_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_MaxSCTP = new WritableCellFeatures();
            cellFeatures_MaxSCTP.setComment(rem_MaxSCTP_tmp, count_r, rem_MaxSCTP_tmp_h);
            rem_MaxSCTP_lab.setCellFeatures(cellFeatures_MaxSCTP);
            sheet.addCell(rem_MaxSCTP_lab);
        } 
        
        Label sctp = new Label(0, row_index, "Maximum SCTP associations per GPB", ca_b);
        sheet.addCell(sctp);
        

//=======Maximum TDM connections on ETC41     
        
        row_index++;
    	int MaxTDM_start=0;
        for(String st : configList)
        {
          if(st.contains("Maximum TDM connections on ETC41                 ["))
          {
        	  MaxTDM_start = configList.indexOf(st);
              break;
          }
        }
        String MaxTDM_start_str = configList.get(MaxTDM_start);
        
        
        int MaxTDM_end=0;
        for(String st : configList)
        {
          if(st.contains("Missing IpMux references                         ["))
          {
        	  MaxTDM_end = configList.indexOf(st);
              break;
          }
        }
//        String MaxTDM_end_str = configList.get(MaxTDM_end);
        
        if(MaxTDM_start_str.equals("Maximum TDM connections on ETC41                 [OK]"))
        {
        	Label MaxTDM_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(MaxTDM_lab);
        }
        else
        {
        	Label MaxTDM_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(MaxTDM_lab);

            String MaxTDM_str = null;
            ArrayList<String> MaxTDM_tmp = new ArrayList<String>();
            
            for(int i=MaxTDM_start+2; i<=MaxTDM_end-4; i++)
            {
            	MaxTDM_str = configList.get(i);
            	MaxTDM_tmp.add(MaxTDM_str);
            	MaxTDM_tmp.add("\n"); // warning and remedy
            }

//            int warn_MaxTDM=0;
            int rem_MaxTDM=0;

            for(String warn : MaxTDM_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_MaxTDM = MaxTDM_tmp.indexOf(warn);
                }
            }

            String warn_MaxTDM_str = null;
            String warn_MaxTDM_tmp = "";

            for(String warn : MaxTDM_tmp)
            {
                for(int j=0; j<rem_MaxTDM; j++) // warning
                {
                	warn_MaxTDM_str = MaxTDM_tmp.get(j);
                	warn_MaxTDM_tmp+=warn_MaxTDM_str;
                }
                break;
            }

            double warn_MaxTDM_tmp_h = warn_MaxTDM_tmp.split(System.getProperty("line.separator")).length;
            
            String lines[] = warn_MaxTDM_tmp.split("\\r?\\n");

            double count =0;
            for(String temp:lines)
            {
            	if(temp.length()>count)
                count = temp.length();
            	count/=25;
            }
            
            Label MaxTDM_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_30 = new WritableCellFeatures();
            cellFeatures_30.setComment(warn_MaxTDM_tmp, count, warn_MaxTDM_tmp_h);
            MaxTDM_lab1.setCellFeatures(cellFeatures_30);
            sheet.addCell(MaxTDM_lab1);

            String rem_MaxTDM_str = null;
            String rem_MaxTDM_tmp = "";

            for(int j=rem_MaxTDM; j<=MaxTDM_tmp.lastIndexOf("\n"); j++)
            {
            	rem_MaxTDM_str = MaxTDM_tmp.get(j); // remedy
                rem_MaxTDM_tmp+=rem_MaxTDM_str + "\n";
            }

            double rem_MaxTDM_tmp_h = rem_MaxTDM_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_MaxTDM_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_MaxTDM_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_MaxTDM = new WritableCellFeatures();
            cellFeatures_MaxTDM.setComment(rem_MaxTDM_tmp, count_r, rem_MaxTDM_tmp_h);
            rem_MaxTDM_lab.setCellFeatures(cellFeatures_MaxTDM);
            sheet.addCell(rem_MaxTDM_lab);
        }        
       
        Label tdm = new Label(0, row_index, "Maximum TDM connections on ETC41", ca_b);
        sheet.addCell(tdm);

//======= Missing IpMux references       
        
        row_index++;
    	int MissIp_start=0;
        for(String st : configList)
        {
          if(st.contains("Missing IpMux references                         ["))
          {
        	  MissIp_start = configList.indexOf(st);
              break;
          }
        }
        String MissIp_start_str = configList.get(MissIp_start);
        
        int MissIp_end=0;
        for(String st : configList)
        {
          if(st.contains("Mtp3bSp timer values                             ["))
          {
        	  MissIp_end = configList.indexOf(st);
              break;
          }
        }
//        String MissIp_end_str = configList.get(MissIp_end);
        
        if(MissIp_start_str.equals("Missing IpMux references                         [OK]"))
        {
        	Label MissIp_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(MissIp_lab);
        }
        else
        {
        	Label MissIp_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(MissIp_lab);

            String MissIp_str = null;
            ArrayList<String> MissIp_tmp = new ArrayList<String>();
            
            for(int i=MissIp_start+2; i<=MissIp_end-4; i++)
            {
            	MissIp_str = configList.get(i);
            	MissIp_tmp.add(MissIp_str);
            	MissIp_tmp.add("\n"); // warning and remedy
            }

            int rem_MissIp=0;
            for(String warn : MissIp_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_MissIp = MissIp_tmp.indexOf(warn);
                }
            }

            String warn_MissIp_str = null;
            String warn_MissIp_tmp = "";
            for(String warn : MissIp_tmp)
            {
                for(int j=0; j<rem_MissIp; j++) // warning
                {
                	warn_MissIp_str = MissIp_tmp.get(j);
                	warn_MissIp_tmp+=warn_MissIp_str;
                }
                break;
            }

            double warn_MissIp_tmp_h = warn_MissIp_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_MissIp_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label MissIp_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_31 = new WritableCellFeatures();
            cellFeatures_31.setComment(warn_MissIp_tmp, count_w, warn_MissIp_tmp_h);
            MissIp_lab1.setCellFeatures(cellFeatures_31);
            sheet.addCell(MissIp_lab1);

            String rem_MissIp_str = null;
            String rem_MissIp_tmp = "";

            for(int j=rem_MissIp; j<=MissIp_tmp.lastIndexOf("\n"); j++)
            {
            	rem_MissIp_str = MissIp_tmp.get(j); // remedy
                rem_MissIp_tmp+=rem_MissIp_str + "\n";
            }

            double rem_MissIp_tmp_h = rem_MissIp_tmp.split(System.getProperty("line.separator")).length;

            String lines_r[] =  rem_MissIp_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_MissIp_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_MissIp = new WritableCellFeatures();
            cellFeatures_MissIp.setComment(rem_MissIp_tmp, count_r, rem_MissIp_tmp_h);
            rem_MissIp_lab.setCellFeatures(cellFeatures_MissIp);
            sheet.addCell(rem_MissIp_lab);
        }   
        
        Label ipm = new Label(0, row_index, "Missing IpMux references", ca_b);
        sheet.addCell(ipm);
        
//======= Mtp3bSp timer values
        
        row_index++;
    	int Mtp3bSp_start=0;
        for(String st : configList)
        {
          if(st.contains("Mtp3bSp timer values                             ["))
          {
        	  Mtp3bSp_start = configList.indexOf(st);
              break;
          }
        }
        String Mtp3bSp_start_str = configList.get(Mtp3bSp_start);
        
        
        int Mtp3bSp_end=0;
        for(String st : configList)
        {
          if(st.contains("Not applicable MOs                               ["))
          {
        	  Mtp3bSp_end = configList.indexOf(st);
              break;
          }
        }
//        String Mtp3bSp_end_str = configList.get(Mtp3bSp_end);
        
        if(Mtp3bSp_start_str.equals("Mtp3bSp timer values                             [OK]"))
        {
        	Label Mtp3bSp_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(Mtp3bSp_lab);
        }
        else
        {
        	Label Mtp3bSp_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(Mtp3bSp_lab);

            String Mtp3bSp_str = null;
            ArrayList<String> Mtp3bSp_tmp = new ArrayList<String>();
            
            for(int i=Mtp3bSp_start+2; i<=Mtp3bSp_end-4; i++)
            {
            	Mtp3bSp_str = configList.get(i);
            	Mtp3bSp_tmp.add(Mtp3bSp_str);
            	Mtp3bSp_tmp.add("\n"); // warning and remedy
            }

            int rem_Mtp3bSp=0;

            for(String warn : Mtp3bSp_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_Mtp3bSp = Mtp3bSp_tmp.indexOf(warn);
                }
            }

            String warn_Mtp3bSp_str = null;
            String warn_Mtp3bSp_tmp = "";

            for(String warn : Mtp3bSp_tmp)
            {
                for(int j=0; j<rem_Mtp3bSp; j++) // warning
                {
                	warn_Mtp3bSp_str = Mtp3bSp_tmp.get(j);
                	warn_Mtp3bSp_tmp+=warn_Mtp3bSp_str;
                }
                break;
            }

            double warn_Mtp3bSp_tmp_h = warn_Mtp3bSp_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_Mtp3bSp_tmp.split("\\r?\\n");

    		double count_w =0;
    		for(String temp:lines_w)
    		{
    			if(temp.length()>count_w)
    				count_w = temp.length();
    				count_w/=25;
    		}
            
            Label Mtp3bSp_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_32 = new WritableCellFeatures();
            cellFeatures_32.setComment(warn_Mtp3bSp_tmp, count_w, warn_Mtp3bSp_tmp_h);
            Mtp3bSp_lab1.setCellFeatures(cellFeatures_32);
            sheet.addCell(Mtp3bSp_lab1);

            String rem_Mtp3bSp_str = null;
            String rem_Mtp3bSp_tmp = "";

            for(int j=rem_Mtp3bSp; j<=Mtp3bSp_tmp.lastIndexOf("\n"); j++)
            {
            	rem_Mtp3bSp_str = Mtp3bSp_tmp.get(j); // remedy
                rem_Mtp3bSp_tmp+=rem_Mtp3bSp_str + "\n";
            }

            double rem_Mtp3bSp_tmp_h = rem_Mtp3bSp_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_Mtp3bSp_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_Mtp3bSp_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_Mtp3bSp = new WritableCellFeatures();
            cellFeatures_Mtp3bSp.setComment(rem_Mtp3bSp_tmp, count_r, rem_Mtp3bSp_tmp_h);
            rem_Mtp3bSp_lab.setCellFeatures(cellFeatures_Mtp3bSp);
            sheet.addCell(rem_Mtp3bSp_lab);
        } 
        
        Label mtpt = new Label(0, row_index, "Mtp3bSp timer values", ca_b);
        sheet.addCell(mtpt);
        

//-----------Not applicable MOs
        
        row_index++;
    	int NaMO_start=0;
        for(String st : configList)
        {
          if(st.contains("Not applicable MOs                               ["))
          {
        	  NaMO_start = configList.indexOf(st);
              break;
          }
        }
        String NaMO_start_str = configList.get(NaMO_start);
        
        
        int NaMO_end=0;
        for(String st : configList)
        {
          if(st.contains("PIU usage                                        ["))
          {
        	  NaMO_end = configList.indexOf(st);
              break;
          }
        }
//        String NaMO_end_str = configList.get(NaMO_end);
        
        if(NaMO_start_str.equals("Not applicable MOs                               [OK]"))
        {
        	Label NaMO_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(NaMO_lab);
        }
        else
        {
        	Label NaMO_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(NaMO_lab);

            String NaMO_str = null;
            ArrayList<String> NaMO_tmp = new ArrayList<String>();
            
            for(int i=NaMO_start+2; i<=NaMO_end-4; i++)
            {
            	NaMO_str = configList.get(i);
            	NaMO_tmp.add(NaMO_str);
            	NaMO_tmp.add("\n"); // warning and remedy
            }

            int rem_NaMO=0;
            for(String warn : NaMO_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_NaMO = NaMO_tmp.indexOf(warn);
                }
            }

            String warn_NaMO_str = null;
            String warn_NaMO_tmp = "";
            for(String warn : NaMO_tmp)
            {
                for(int j=0; j<rem_NaMO; j++) // warning
                {
                	warn_NaMO_str = NaMO_tmp.get(j);
                	warn_NaMO_tmp+=warn_NaMO_str;
                }
                break;
            }

            double warn_NaMO_tmp_h = warn_NaMO_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_NaMO_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label NaMO_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_33 = new WritableCellFeatures();
            cellFeatures_33.setComment(warn_NaMO_tmp, count_w, warn_NaMO_tmp_h);
            NaMO_lab1.setCellFeatures(cellFeatures_33);
            sheet.addCell(NaMO_lab1);

            String rem_NaMO_str = null;
            String rem_NaMO_tmp = "";

            for(int j=rem_NaMO; j<=NaMO_tmp.lastIndexOf("\n"); j++)
            {
            	rem_NaMO_str = NaMO_tmp.get(j); // remedy
                rem_NaMO_tmp+=rem_NaMO_str + "\n";
            }

            double rem_NaMO_tmp_h = rem_NaMO_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_NaMO_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_NaMO_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_NaMO = new WritableCellFeatures();
            cellFeatures_NaMO.setComment(rem_NaMO_tmp, count_r, rem_NaMO_tmp_h);
            rem_NaMO_lab.setCellFeatures(cellFeatures_NaMO);
            sheet.addCell(rem_NaMO_lab);
        } 
        
        Label na = new Label(0, row_index, "Not applicable MOs", ca_b);
        sheet.addCell(na);
        
        
//-------PIU usage                          
        
        row_index++;
    	int PIU_start=0;
        for(String st : configList)
        {
          if(st.contains("PIU usage                                        ["))
          {
        	  PIU_start = configList.indexOf(st);
              break;
          }
        }
        String PIU_start_str = configList.get(PIU_start);
        
        int PIU_end=0;
        for(String st : configList)
        {
          if(st.contains("Reliable Program Uniters                         ["))
          {
        	  PIU_end = configList.indexOf(st);
              break;
          }
        }
        
        if(PIU_start_str.equals("PIU usage                                        [OK]"))
        {
        	Label PIU_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(PIU_lab);
        }
        else
        {
        	Label PIU_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(PIU_lab);

            String PIU_str = null;
            ArrayList<String> PIU_tmp = new ArrayList<String>();
            
            for(int i=PIU_start+2; i<=PIU_end-4; i++)
            {
            	PIU_str = configList.get(i);
            	PIU_tmp.add(PIU_str);
            	PIU_tmp.add("\n"); // warning and remedy
            }

            int rem_PIU=0;
            for(String warn : PIU_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_PIU = PIU_tmp.indexOf(warn);
                }
            }

            String warn_PIU_str = null;
            String warn_PIU_tmp = "";
            for(String warn : PIU_tmp)
            {
                for(int j=0; j<rem_PIU; j++) // warning
                {
                	warn_PIU_str = PIU_tmp.get(j);
                	warn_PIU_tmp+=warn_PIU_str;
                }
                break;
            }

            double warn_PIU_tmp_h = warn_PIU_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_PIU_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label PIU_lab1 = new Label(2, row_index, "Warning");
            WritableCellFeatures cellFeatures_34 = new WritableCellFeatures();
            cellFeatures_34.setComment(warn_PIU_tmp, count_w, warn_PIU_tmp_h);
            PIU_lab1.setCellFeatures(cellFeatures_34);
            sheet.addCell(PIU_lab1);

            String rem_PIU_str = null;
            String rem_PIU_tmp = "";

            for(int j=rem_PIU; j<=PIU_tmp.lastIndexOf("\n"); j++)
            {
            	rem_PIU_str = PIU_tmp.get(j); // remedy
                rem_PIU_tmp+=rem_PIU_str + "\n";
            }

            double rem_PIU_tmp_h = rem_PIU_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_PIU_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_PIU_lab = new Label(3, row_index, "Remedy");
            WritableCellFeatures cellFeatures_PIU = new WritableCellFeatures();
            cellFeatures_PIU.setComment(rem_PIU_tmp, count_r, rem_PIU_tmp_h);
            rem_PIU_lab.setCellFeatures(cellFeatures_PIU);
            sheet.addCell(rem_PIU_lab);
        }   
        Label piu = new Label(0, row_index, "PIU usage", ca_b);
        sheet.addCell(piu);
        

//------Reliable Program Uniters
        
        row_index++;
        int RelPro_start=0;
        for(String st : configList)
        {
          if(st.contains("Reliable Program Uniters                         ["))
          {
        	  RelPro_start = configList.indexOf(st);
              break;
          }
        }
        String RelPro_start_str = configList.get(RelPro_start);
        
        int RelPro_end=0;
        for(String st : configList)
        {
          if(st.contains("Security                                         ["))
          {
        	  RelPro_end = configList.indexOf(st);
              break;
          }
        }
        
        if(RelPro_start_str.equals("Reliable Program Uniters                         [OK]"))
        {
        	Label RelPro_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(RelPro_lab);
        }
        else
        {
        	Label RelPro_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(RelPro_lab);

            String RelPro_str = null;
            ArrayList<String> RelPro_tmp = new ArrayList<String>();
            
            for(int i=RelPro_start+2; i<=RelPro_end-4; i++)
            {
            	RelPro_str = configList.get(i);
            	RelPro_tmp.add(RelPro_str);
            	RelPro_tmp.add("\n"); // warning and remedy
            }

            int rem_RelPro=0;
            for(String warn : RelPro_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_RelPro = RelPro_tmp.indexOf(warn);
                }
            }
            String warn_RelPro_str = null;
            String warn_RelPro_tmp = "";

            for(String warn : RelPro_tmp)
            {
                for(int j=0; j<rem_RelPro; j++) // warning
                {
                	warn_RelPro_str = RelPro_tmp.get(j);
                	warn_RelPro_tmp+=warn_RelPro_str;
                }
                break;
            }
            
            double warn_RelPro_tmp_h = warn_RelPro_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_RelPro_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label RelPro_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_35 = new WritableCellFeatures();
            cellFeatures_35.setComment(warn_RelPro_tmp, count_w, warn_RelPro_tmp_h);
            RelPro_lab1.setCellFeatures(cellFeatures_35);
            sheet.addCell(RelPro_lab1);

            String rem_RelPro_str = null;
            String rem_RelPro_tmp = "";

            for(int j=rem_RelPro; j<=RelPro_tmp.lastIndexOf("\n"); j++)
            {
            	rem_RelPro_str = RelPro_tmp.get(j); // remedy
                rem_RelPro_tmp+=rem_RelPro_str + "\n";
            }

            double rem_RelPro_tmp_h = rem_RelPro_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_RelPro_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_RelPro_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_RelPro = new WritableCellFeatures();
            cellFeatures_RelPro.setComment(rem_RelPro_tmp, count_r, rem_RelPro_tmp_h);
            rem_RelPro_lab.setCellFeatures(cellFeatures_RelPro);
            sheet.addCell(rem_RelPro_lab);
        }
        
        Label rpu = new Label(0, row_index, "Reliable Program Uniters", ca_b);
        sheet.addCell(rpu);
        
//---------Security  
        
        row_index++;
    	int Sec_start=0;
        for(String st : configList)
        {
          if(st.contains("Security                                         ["))
          {
        	  Sec_start = configList.indexOf(st);
              break;
          }
        }
        String Sec_start_str = configList.get(Sec_start);
        
        int Sec_end=0;
        for(String st : configList)
        {
          if(st.contains("Signalling link set content                      ["))
          {
        	  Sec_end = configList.indexOf(st);
              break;
          }
        }
        
        if(Sec_start_str.equals("Security                                         [OK]"))
        {
        	Label Sec_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(Sec_lab);
        }
        else
        {
        	Label Sec_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(Sec_lab);

            String Sec_str = null;
            ArrayList<String> Sec_tmp = new ArrayList<String>();
            
            for(int i=Sec_start+2; i<=Sec_end-4; i++)
            {
            	Sec_str = configList.get(i);
            	Sec_tmp.add(Sec_str);
            	Sec_tmp.add("\n"); // warning and remedy
            }

            int rem_Sec=0;
            for(String warn : Sec_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_Sec = Sec_tmp.indexOf(warn);
                }
            }

            String warn_Sec_str = null;
            String warn_Sec_tmp = "";

            for(String warn : Sec_tmp)
            {
                for(int j=0; j<rem_Sec; j++) // warning
                {
                	warn_Sec_str = Sec_tmp.get(j);
                	warn_Sec_tmp+=warn_Sec_str;
                }
                break;
            }

            double warn_Sec_tmp_h = warn_Sec_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_Sec_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label Sec_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_36 = new WritableCellFeatures();
            cellFeatures_36.setComment(warn_Sec_tmp, count_w, warn_Sec_tmp_h);
            Sec_lab1.setCellFeatures(cellFeatures_36);
            sheet.addCell(Sec_lab1);

            String rem_Sec_str = null;
            String rem_Sec_tmp = "";

            for(int j=rem_Sec; j<=Sec_tmp.lastIndexOf("\n"); j++)
            {
            	rem_Sec_str = Sec_tmp.get(j); // remedy
                rem_Sec_tmp+=rem_Sec_str + "\n";
            }

            double rem_Sec_tmp_h = rem_Sec_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_Sec_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_Sec_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_Sec = new WritableCellFeatures();
            cellFeatures_Sec.setComment(rem_Sec_tmp, count_r, rem_Sec_tmp_h);
            rem_Sec_lab.setCellFeatures(cellFeatures_Sec);
            sheet.addCell(rem_Sec_lab);
        }
        
        Label sec = new Label(0, row_index, "Security", ca_b);
        sheet.addCell(sec);
 
//-------------Signalling link set content
        
        row_index++;
        int SigLink_start=0;
        for(String st : configList)
        {
          if(st.contains("Signalling link set content                      ["))
          {
        	  SigLink_start = configList.indexOf(st);
              break;
          }
        }
        String SigLink_start_str = configList.get(SigLink_start);
        
        int SigLink_end=0;
        for(String st : configList)
        {
          if(st.contains("Signalling loop                                  ["))
          {
        	  SigLink_end = configList.indexOf(st);
              break;
          }
        }
//        String SigLink_end_str = configList.get(SigLink_end);
        
        if(SigLink_start_str.equals("Signalling link set content                      [OK]"))
        {
        	Label SigLink_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(SigLink_lab);
        }
        else
        {
        	Label SigLink_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(SigLink_lab);

            String SigLink_str = null;

            ArrayList<String> SigLink_tmp = new ArrayList<String>();
            
            for(int i=SigLink_start+2; i<=SigLink_end-4; i++)
            {
            	SigLink_str = configList.get(i);
            	SigLink_tmp.add(SigLink_str);
            	SigLink_tmp.add("\n"); // warning and remedy
            }

            int rem_SigLink=0;
            for(String warn : SigLink_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_SigLink = SigLink_tmp.indexOf(warn);
                }
            }

            String warn_SigLink_str = null;
            String warn_SigLink_tmp = "";

            for(String warn : SigLink_tmp)
            {
                for(int j=0; j<rem_SigLink; j++) // warning
                {
                	warn_SigLink_str = SigLink_tmp.get(j);
                	warn_SigLink_tmp+=warn_SigLink_str;
                }
                break;
            }

            double warn_SigLink_tmp_h = warn_SigLink_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_SigLink_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label SigLink_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_37 = new WritableCellFeatures();
            cellFeatures_37.setComment(warn_SigLink_tmp, count_w, warn_SigLink_tmp_h);
            SigLink_lab1.setCellFeatures(cellFeatures_37);
            sheet.addCell(SigLink_lab1);

            String rem_SigLink_str = null;
            String rem_SigLink_tmp = "";

            for(int j=rem_SigLink; j<=SigLink_tmp.lastIndexOf("\n"); j++)
            {
            	rem_SigLink_str = SigLink_tmp.get(j); // remedy
                rem_SigLink_tmp+=rem_SigLink_str + "\n";
            }

            double rem_SigLink_tmp_h = rem_SigLink_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_SigLink_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_SigLink_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_SigLink = new WritableCellFeatures();
            cellFeatures_SigLink.setComment(rem_SigLink_tmp, count_r, rem_SigLink_tmp_h);
            rem_SigLink_lab.setCellFeatures(cellFeatures_SigLink);
            sheet.addCell(rem_SigLink_lab);
        }
        
        Label slse = new Label(0, row_index, "Signalling link set content", ca_b);
        sheet.addCell(slse);
        
//======= Signaling loop        

        row_index++;
    	int SigLoop_start=0;
        for(String st : configList)
        {
          if(st.contains("Signalling loop                                  ["))
          {
        	  SigLoop_start = configList.indexOf(st);
              break;
          }
        }
        String SigLoop_start_str = configList.get(SigLoop_start);
        
        int SigLoop_end=0;
        for(String st : configList)
        {
          if(st.contains("Unlocked and disabled MOs                        ["))
          {
        	  SigLoop_end = configList.indexOf(st);
              break;
          }
        }
        
        if(SigLoop_start_str.equals("Signalling loop                                  [OK]"))
        {
        	Label SigLoop_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(SigLoop_lab);
        }
        else
        {
        	Label SigLoop_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(SigLoop_lab);

            String SigLoop_str = null;
            ArrayList<String> SigLoop_tmp = new ArrayList<String>();
            
            for(int i=SigLoop_start+2; i<=SigLoop_end-4; i++)
            {
            	SigLoop_str = configList.get(i);
            	SigLoop_tmp.add(SigLoop_str);
            	SigLoop_tmp.add("\n"); // warning and remedy
            }

            int rem_SigLoop=0;
            for(String warn : SigLoop_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_SigLoop = SigLoop_tmp.indexOf(warn);
                }
            }

            String warn_SigLoop_str = null;
            String warn_SigLoop_tmp = "";

            for(String warn : SigLoop_tmp)
            {
                for(int j=0; j<rem_SigLoop; j++) // warning
                {
                	warn_SigLoop_str = SigLoop_tmp.get(j);
                	warn_SigLoop_tmp+=warn_SigLoop_str;
                }
                break;
            }

            double warn_SigLoop_tmp_h = warn_SigLoop_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_SigLoop_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label SigLoop_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_38 = new WritableCellFeatures();
            cellFeatures_38.setComment(warn_SigLoop_tmp, count_w, warn_SigLoop_tmp_h);
            SigLoop_lab1.setCellFeatures(cellFeatures_38);
            sheet.addCell(SigLoop_lab1);

            String rem_SigLoop_str = null;
            String rem_SigLoop_tmp = "";

            for(int j=rem_SigLoop; j<=SigLoop_tmp.lastIndexOf("\n"); j++)
            {
            	rem_SigLoop_str = SigLoop_tmp.get(j); // remedy
                rem_SigLoop_tmp+=rem_SigLoop_str + "\n";
            }

            double rem_SigLoop_tmp_h = rem_SigLoop_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_SigLoop_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_SigLoop_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_SigLoop = new WritableCellFeatures();
            cellFeatures_SigLoop.setComment(rem_SigLoop_tmp, count_r, rem_SigLoop_tmp_h);
            rem_SigLoop_lab.setCellFeatures(cellFeatures_SigLoop);
            sheet.addCell(rem_SigLoop_lab);
        } 
        Label slp = new Label(0, row_index, "Signalling loop", ca_b);
        sheet.addCell(slp);
        
//-----
     //   Unlocked and disabled MOs
        
        row_index++;
    	int UMO_start=0;
        for(String st : configList)
        {
          if(st.contains("Unlocked and disabled MOs                        ["))
          {
        	  UMO_start = configList.indexOf(st);
              break;
          }
        }
        String UMO_start_str = configList.get(UMO_start);
        
        int UMO_end=0;
        for(String st : configList)
        {
          if(st.contains("Value recommendations                            ["))
          {
        	  UMO_end = configList.indexOf(st);
              break;
          }
        }
        
        if(UMO_start_str.equals("Unlocked and disabled MOs                        [OK]"))
        {
        	Label UMO_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(UMO_lab);
        }
        else
        {
        	Label UMO_lab = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(UMO_lab);

            String UMO_str = null;
            ArrayList<String> UMO_tmp = new ArrayList<String>();
            
            for(int i=UMO_start+2; i<=UMO_end-4; i++)
            {
            	UMO_str = configList.get(i);
            	UMO_tmp.add(UMO_str);
            	UMO_tmp.add("\n"); // warning and remedy
            }

            int rem_UMO=0;
            for(String warn : UMO_tmp)
            {
                if(warn.contains("REMEDY:"))
                {
                	rem_UMO = UMO_tmp.indexOf(warn);
                }
            }

            String warn_UMO_str = null;
            String warn_UMO_tmp = "";

            for(String warn : UMO_tmp)
            {
                for(int j=0; j<rem_UMO; j++) // warning
                {
                	warn_UMO_str = UMO_tmp.get(j);
                	warn_UMO_tmp+=warn_UMO_str;
                }
                break;
            }

            double warn_UMO_tmp_h = warn_UMO_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_w[] =  warn_UMO_tmp.split("\\r?\\n");

    		double count_w =0;
                for(String temp:lines_w)
                {
                	if(temp.length()>count_w)
                    count_w = temp.length();
                	count_w/=25;
                }
            
            Label UMO_lab1 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_39 = new WritableCellFeatures();
            cellFeatures_39.setComment(warn_UMO_tmp, count_w, warn_UMO_tmp_h);
            UMO_lab1.setCellFeatures(cellFeatures_39);
            sheet.addCell(UMO_lab1);

            String rem_UMO_str = null;
            String rem_UMO_tmp = "";

            for(int j=rem_UMO; j<=UMO_tmp.lastIndexOf("\n"); j++)
            {
            	rem_UMO_str = UMO_tmp.get(j); // remedy
                rem_UMO_tmp+=rem_UMO_str + "\n";
            }

            double rem_UMO_tmp_h = rem_UMO_tmp.split(System.getProperty("line.separator")).length;
            
            String lines_r[] =  rem_UMO_tmp.split("\\r?\\n");

			double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
            Label rem_UMO_lab = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_UMO = new WritableCellFeatures();
            cellFeatures_UMO.setComment(rem_UMO_tmp, count_r, rem_UMO_tmp_h);
            rem_UMO_lab.setCellFeatures(cellFeatures_UMO);
            sheet.addCell(rem_UMO_lab);
        } 
        
        Label ud = new Label(0, row_index, "Unlocked and disabled MOs", ca_b);
        sheet.addCell(ud);
        

//===========        Value Recommendations 

        row_index++;
        ArrayList<String> VR_tmp = new ArrayList<String>();
        int VR_start=0;
        for(String st : configList)
        {
          if(st.contains("Value recommendations                            ["))
          {
        	  VR_start = configList.indexOf(st);
              break;
          }
        }
        String VR_start_str = configList.get(VR_start);

        int VR_end=0;
        for(String st : configList)
        {
          if(st.contains("System health:"))
          {
        	  VR_end = configList.indexOf(st);
              break;
          }
        }
//        String VR_end_str = configList.get(VR_end);

        if(VR_start_str.equals("Value recommendations                            [OK]"))
        {
        	Label VR_lab = new Label(1, row_index, "OK", green);
            sheet.addCell(VR_lab);
        }
        else
        {
        	String VR_str = null;
        	for(int i=VR_start+2; i<=VR_end-4; i++)
        	{
        		VR_str = configList.get(i);
        		VR_tmp.add(VR_str);
        		VR_tmp.add("\n"); // warning and remedy and info
        	}
        }
        String st1=VR_tmp.toString();

        int index_start_Rem = st1.indexOf("REMEDY:");
        int index_last_Rem=st1.lastIndexOf("REMEDY:");
        
        if(index_start_Rem == index_last_Rem)
        {
//        	Label VR_lab = new Label(1, 40, "OK", green);
//        	sheet.addCell(VR_lab);

        	int warn_VR=0,rem_VR=0;
        	
        	for(String warn : VR_tmp)
        	{
        		if(warn.contains("WARNING:"))
        		{
        			warn_VR=VR_tmp.indexOf(warn);
        		}
        	}

        	for(String warn : VR_tmp)
        	{
        		if(warn.contains("REMEDY:"))
        		{
        			rem_VR = VR_tmp.indexOf(warn);
        		}
        	}
//        	System.out.println(rem_VR);
        	
        	String warn_VR_string = null;
        	String warn_VR_temp = "";
        	
        	for(String warn : VR_tmp)
        	{
        		for(int j=0; j<rem_VR; j++) // warning
        		{
        			warn_VR_string = VR_tmp.get(j);
        			warn_VR_temp+=warn_VR_string;
        		}
        		break;
        	}
//        	System.out.println(warn_VR_temp);
        	
        	Label VR_lab1 = new Label(2, 40, "Warning");
        	WritableCellFeatures cellFeatures_40 = new WritableCellFeatures();
        	cellFeatures_40.setComment(warn_VR_temp);
        	VR_lab1.setCellFeatures(cellFeatures_40);
        	sheet.addCell(VR_lab1);
        	
        	String rem_VR_str = null;
        	String rem_VR_tmp = "";
        	
        	for(int j=rem_VR; j<=VR_tmp.lastIndexOf("\n"); j++)
        	{
        		rem_VR_str = VR_tmp.get(j); // remedy
        		rem_VR_tmp+=rem_VR_str + "\n";
        	}

//        	System.out.println(rem_VR_tmp);

        	            Label rem_VR_lab = new Label(3, 40, "Remedy");
        	            WritableCellFeatures cellFeatures_VR = new WritableCellFeatures();
        	            cellFeatures_VR.setComment(rem_VR_tmp);
        	            rem_VR_lab.setCellFeatures(cellFeatures_VR);
        	            sheet.addCell(rem_VR_lab);
        }
        else
        {	
        	for(String st : VR_tmp){}
//        		System.out.println(st);
        }
        */
	    
//**********************	    

//--- System health

        sys_healthfn sysfn = new sys_healthfn();
        
     // AAL2 path remote operational state     
        row_index++;
        String aal2_warn = sysfn.sys_hlth_fn_warn("AAL2 path remote operational state", "Attribute dependencies");
        String aal2_rem = sysfn.sys_hlth_fn_rem("AAL2 path remote operational state", "Attribute dependencies");
        
    	Label aal2lab = new Label(0, row_index, "AAL2 path remote operational state", ca_b);
        sheet.addCell(aal2lab);
        
    	int aal2_c = 0;
        for(String st : configList)
        {
        	if(st.contains("AAL2 path remote operational state"))
        	{
        		aal2_c = configList.indexOf(st);
        	}
        }
        
        if(aal2_warn.equals("OK") && aal2_rem.equals("OK"))
        {
        	Label aal2_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(aal2_ok);
        }
        else
        {
        	Label aal2_ok;
        	if(configList.get(aal2_c).endsWith("[WARNING]"))
        	{
        		aal2_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(aal2_c).endsWith("[INFO]"))
        	{
        		aal2_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(aal2_c).endsWith("[CRITICAL]"))
        	{
        		aal2_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		aal2_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(aal2_ok);
        	
    	    double aal2_w_h = aal2_warn.split(System.getProperty("line.separator")).length;
            double aal2_r_h = aal2_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  aal2_warn.split("\\r?\\n");
            String lines_r[] =  aal2_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label aal2_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures aal2_cmt = new WritableCellFeatures();
        	aal2_cmt.setComment(aal2_warn, count_w, aal2_w_h);
        	aal2_obs.setCellFeatures(aal2_cmt);
        	sheet.addCell(aal2_obs);

            Label aal2_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures aal2_rem_cmt = new WritableCellFeatures();
            aal2_rem_cmt.setComment(aal2_rem, count_r, aal2_r_h);
            aal2_lab_rem.setCellFeatures(aal2_rem_cmt);
            sheet.addCell(aal2_lab_rem);
        }
        
     // Attribute dependencies     
        row_index++;
        String att_warn = sysfn.sys_hlth_fn_warn("Attribute dependencies", "CMXB external configuration");
        String att_rem = sysfn.sys_hlth_fn_rem("Attribute dependencies", "CMXB external configuration");
        
    	Label attlab = new Label(0, row_index, "Attribute dependencies", ca_b);
        sheet.addCell(attlab);
        
    	int att_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Attribute dependencies"))
        	{
        		att_c = configList.indexOf(st);
        	}
        }
        
        if(att_warn.equals("OK") && att_rem.equals("OK"))
        {
        	Label att_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(att_ok);
        }
        else
        {
        	Label att_ok;
        	if(configList.get(att_c).endsWith("[WARNING]"))
        	{
        		att_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(att_c).endsWith("[INFO]"))
        	{
        		att_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(att_c).endsWith("[CRITICAL]"))
        	{
        		att_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		att_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(att_ok);
        	
    	    double att_w_h = att_warn.split(System.getProperty("line.separator")).length;
            double att_r_h = att_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  att_warn.split("\\r?\\n");
            String lines_r[] =  att_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label att_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures att_cmt = new WritableCellFeatures();
        	att_cmt.setComment(att_warn, count_w, att_w_h);
        	att_obs.setCellFeatures(att_cmt);
        	sheet.addCell(att_obs);

            Label att_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures att_rem_cmt = new WritableCellFeatures();
            att_rem_cmt.setComment(att_rem, count_r, att_r_h);
            att_lab_rem.setCellFeatures(att_rem_cmt);
            sheet.addCell(att_lab_rem);
        }
        
   // CMXB external configuration     
        row_index++;
        String cec_warn = sysfn.sys_hlth_fn_warn("CMXB external configuration", "ETMFG VLAN configuration");
        String cec_rem = sysfn.sys_hlth_fn_rem("CMXB external configuration", "ETMFG VLAN configuration");
        
    	Label ceclab = new Label(0, row_index, "CMXB external configuration", ca_b);
        sheet.addCell(ceclab);
        
    	int cec_c = 0;
        for(String st : configList)
        {
        	if(st.contains("CMXB external configuration"))
        	{
        		cec_c = configList.indexOf(st);
        	}
        }
        
        if(cec_warn.equals("OK") && cec_rem.equals("OK"))
        {
        	Label cec_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(cec_ok);
        }
        else
        {
        	Label cec_ok;
        	if(configList.get(cec_c).endsWith("[WARNING]"))
        	{
        		cec_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(cec_c).endsWith("[INFO]"))
        	{
        		cec_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(cec_c).endsWith("[CRITICAL]"))
        	{
        		cec_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		cec_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(cec_ok);
        	
    	    double cec_w_h = cec_warn.split(System.getProperty("line.separator")).length;
            double cec_r_h = cec_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  cec_warn.split("\\r?\\n");
            String lines_r[] =  cec_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label cec_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures cec_cmt = new WritableCellFeatures();
        	cec_cmt.setComment(cec_warn, count_w, cec_w_h);
        	cec_obs.setCellFeatures(cec_cmt);
        	sheet.addCell(cec_obs);

            Label cec_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cec_rem_cmt = new WritableCellFeatures();
            cec_rem_cmt.setComment(cec_rem, count_r, cec_r_h);
            cec_lab_rem.setCellFeatures(cec_rem_cmt);
            sheet.addCell(cec_lab_rem);
        }
        
     // ETMFG VLAN configuration     
        row_index++;
        String etmfg_warn = sysfn.sys_hlth_fn_warn("ETMFG VLAN configuration", "Failed user plane devices");
        String etmfg_rem = sysfn.sys_hlth_fn_rem("ETMFG VLAN configuration", "Failed user plane devices");
        
    	Label etmfglab = new Label(0, row_index, "ETMFG VLAN configuration", ca_b);
        sheet.addCell(etmfglab);
        
    	int etmfg_c = 0;
        for(String st : configList)
        {
        	if(st.contains("ETMFG VLAN configuration"))
        	{
        		etmfg_c = configList.indexOf(st);
        	}
        }
        
        if(etmfg_warn.equals("OK") && etmfg_rem.equals("OK"))
        {
        	Label etmfg_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(etmfg_ok);
        }
        else
        {
        	Label etmfg_ok;
        	if(configList.get(etmfg_c).endsWith("[WARNING]"))
        	{
        		etmfg_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(etmfg_c).endsWith("[INFO]"))
        	{
        		etmfg_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(etmfg_c).endsWith("[CRITICAL]"))
        	{
        		etmfg_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		etmfg_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(etmfg_ok);
        	
    	    double etmfg_w_h = etmfg_warn.split(System.getProperty("line.separator")).length;
            double etmfg_r_h = etmfg_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  etmfg_warn.split("\\r?\\n");
            String lines_r[] =  etmfg_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label etmfg_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures etmfg_cmt = new WritableCellFeatures();
        	etmfg_cmt.setComment(etmfg_warn, count_w, etmfg_w_h);
        	etmfg_obs.setCellFeatures(etmfg_cmt);
        	sheet.addCell(etmfg_obs);

            Label etmfg_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures etmfg_rem_cmt = new WritableCellFeatures();
            etmfg_rem_cmt.setComment(etmfg_rem, count_r, etmfg_r_h);
            etmfg_lab_rem.setCellFeatures(etmfg_rem_cmt);
            sheet.addCell(etmfg_lab_rem);
        }
        
     // Failed user plane devices     
        row_index++;
        String fupd_warn = sysfn.sys_hlth_fn_warn("Failed user plane devices", "GigaBitEthernet link redundancy");
        String fupd_rem = sysfn.sys_hlth_fn_rem("Failed user plane devices", "GigaBitEthernet link redundancy");
        
    	Label fupdlab = new Label(0, row_index, "Failed user plane devices", ca_b);
        sheet.addCell(fupdlab);
        
    	int fupd_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Failed user plane devices"))
        	{
        		fupd_c = configList.indexOf(st);
        	}
        }
        
        if(fupd_warn.equals("OK") && fupd_rem.equals("OK"))
        {
        	Label fupd_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(fupd_ok);
        }
        else
        {
        	Label fupd_ok;
        	if(configList.get(fupd_c).endsWith("[WARNING]"))
        	{
        		fupd_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(fupd_c).endsWith("[INFO]"))
        	{
        		fupd_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(fupd_c).endsWith("[CRITICAL]"))
        	{
        		fupd_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		fupd_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(fupd_ok);
        	
    	    double fupd_w_h = fupd_warn.split(System.getProperty("line.separator")).length;
            double fupd_r_h = fupd_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  fupd_warn.split("\\r?\\n");
            String lines_r[] =  fupd_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label fupd_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures fupd_cmt = new WritableCellFeatures();
        	fupd_cmt.setComment(fupd_warn, count_w, fupd_w_h);
        	fupd_obs.setCellFeatures(fupd_cmt);
        	sheet.addCell(fupd_obs);

            Label fupd_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures fupd_rem_cmt = new WritableCellFeatures();
            fupd_rem_cmt.setComment(fupd_rem, count_r, fupd_r_h);
            fupd_lab_rem.setCellFeatures(fupd_rem_cmt);
            sheet.addCell(fupd_lab_rem);
        }
        
     // GigaBitEthernet link redundancy     
        row_index++;
        String glr_warn = sysfn.sys_hlth_fn_warn("GigaBitEthernet link redundancy", "M3UA Signalling termination");
        String glr_rem = sysfn.sys_hlth_fn_rem("GigaBitEthernet link redundancy", "M3UA Signalling termination");
        
    	Label glrlab = new Label(0, row_index, "GigaBitEthernet link redundancy", ca_b);
        sheet.addCell(glrlab);
        
    	int glr_c = 0;
        for(String st : configList)
        {
        	if(st.contains("GigaBitEthernet link redundancy"))
        	{
        		glr_c = configList.indexOf(st);
        	}
        }
        
        if(glr_warn.equals("OK") && glr_rem.equals("OK"))
        {
        	Label glr_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(glr_ok);
        }
        else
        {
        	Label glr_ok;
        	if(configList.get(glr_c).endsWith("[WARNING]"))
        	{
        		glr_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(glr_c).endsWith("[INFO]"))
        	{
        		glr_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(glr_c).endsWith("[CRITICAL]"))
        	{
        		glr_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		glr_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(glr_ok);
        	
    	    double glr_w_h = glr_warn.split(System.getProperty("line.separator")).length;
            double glr_r_h = glr_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  glr_warn.split("\\r?\\n");
            String lines_r[] =  glr_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label glr_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures glr_cmt = new WritableCellFeatures();
        	glr_cmt.setComment(glr_warn, count_w, glr_w_h);
        	glr_obs.setCellFeatures(glr_cmt);
        	sheet.addCell(glr_obs);

            Label glr_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures glr_rem_cmt = new WritableCellFeatures();
            glr_rem_cmt.setComment(glr_rem, count_r, glr_r_h);
            glr_lab_rem.setCellFeatures(glr_rem_cmt);
            sheet.addCell(glr_lab_rem);
        }
        
     // M3UA Signalling termination     
        row_index++;
        String mst_warn = sysfn.sys_hlth_fn_warn("M3UA Signalling termination", "M3ua timer values");
        String mst_rem = sysfn.sys_hlth_fn_rem("M3UA Signalling termination", "M3ua timer values");
        
    	Label mstlab = new Label(0, row_index, "M3UA Signalling termination", ca_b);
        sheet.addCell(mstlab);
        
    	int mst_c = 0;
        for(String st : configList)
        {
        	if(st.contains("M3UA Signalling termination"))
        	{
        		mst_c = configList.indexOf(st);
        	}
        }
        
        if(mst_warn.equals("OK") && mst_rem.equals("OK"))
        {
        	Label mst_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(mst_ok);
        }
        else
        {
        	Label mst_ok;
        	if(configList.get(mst_c).endsWith("[WARNING]"))
        	{
        		mst_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(mst_c).endsWith("[INFO]"))
        	{
        		mst_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(mst_c).endsWith("[CRITICAL]"))
        	{
        		mst_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		mst_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(mst_ok);
        	
    	    double mst_w_h = mst_warn.split(System.getProperty("line.separator")).length;
            double mst_r_h = mst_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  mst_warn.split("\\r?\\n");
            String lines_r[] =  mst_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label mst_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures mst_cmt = new WritableCellFeatures();
        	mst_cmt.setComment(mst_warn, count_w, mst_w_h);
        	mst_obs.setCellFeatures(mst_cmt);
        	sheet.addCell(mst_obs);

            Label mst_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures mst_rem_cmt = new WritableCellFeatures();
            mst_rem_cmt.setComment(mst_rem, count_r, mst_r_h);
            mst_lab_rem.setCellFeatures(mst_rem_cmt);
            sheet.addCell(mst_lab_rem);
        }
        
     // M3ua timer values     
        row_index++;
        String mtv_warn = sysfn.sys_hlth_fn_warn("M3ua timer values", "MTP3b Local termination");
        String mtv_rem = sysfn.sys_hlth_fn_rem("M3ua timer values", "MTP3b Local termination");
        
    	Label mtvlab = new Label(0, row_index, "M3ua timer values", ca_b);
        sheet.addCell(mtvlab);
        
    	int mtv_c = 0;
        for(String st : configList)
        {
        	if(st.contains("M3ua timer values"))
        	{
        		mtv_c = configList.indexOf(st);
        	}
        }
        
        if(mtv_warn.equals("OK") && mtv_rem.equals("OK"))
        {
        	Label mtv_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(mtv_ok);
        }
        else
        {
        	Label mtv_ok;
        	if(configList.get(mtv_c).endsWith("[WARNING]"))
        	{
        		mtv_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(mtv_c).endsWith("[INFO]"))
        	{
        		mtv_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(mtv_c).endsWith("[CRITICAL]"))
        	{
        		mtv_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		mtv_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(mtv_ok);
        	
    	    double mtv_w_h = mtv_warn.split(System.getProperty("line.separator")).length;
            double mtv_r_h = mtv_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  mtv_warn.split("\\r?\\n");
            String lines_r[] =  mtv_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label mtv_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures mtv_cmt = new WritableCellFeatures();
        	mtv_cmt.setComment(mtv_warn, count_w, mtv_w_h);
        	mtv_obs.setCellFeatures(mtv_cmt);
        	sheet.addCell(mtv_obs);

            Label mtv_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures mtv_rem_cmt = new WritableCellFeatures();
            mtv_rem_cmt.setComment(mtv_rem, count_r, mtv_r_h);
            mtv_lab_rem.setCellFeatures(mtv_rem_cmt);
            sheet.addCell(mtv_lab_rem);
        }
        
     // MTP3b Local termination     
        row_index++;
        String mlt_warn = sysfn.sys_hlth_fn_warn("MTP3b Local termination", "MTP3b Remote termination");
        String mlt_rem = sysfn.sys_hlth_fn_rem("MTP3b Local termination", "MTP3b Remote termination");
        
    	Label mltlab = new Label(0, row_index, "MTP3b Local termination", ca_b);
        sheet.addCell(mltlab);
        
    	int mlt_c = 0;
        for(String st : configList)
        {
        	if(st.contains("MTP3b Local termination"))
        	{
        		mlt_c = configList.indexOf(st);
        	}
        }
        
        if(mlt_warn.equals("OK") && mlt_rem.equals("OK"))
        {
        	Label mlt_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(mlt_ok);
        }
        else
        {
        	Label mlt_ok;
        	if(configList.get(mlt_c).endsWith("[WARNING]"))
        	{
        		mlt_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(mlt_c).endsWith("[INFO]"))
        	{
        		mlt_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(mlt_c).endsWith("[CRITICAL]"))
        	{
        		mlt_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		mlt_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(mlt_ok);
        	
    	    double mlt_w_h = mlt_warn.split(System.getProperty("line.separator")).length;
            double mlt_r_h = mlt_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  mlt_warn.split("\\r?\\n");
            String lines_r[] =  mlt_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label mlt_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures mlt_cmt = new WritableCellFeatures();
        	mlt_cmt.setComment(mlt_warn, count_w, mlt_w_h);
        	mlt_obs.setCellFeatures(mlt_cmt);
        	sheet.addCell(mlt_obs);

            Label mlt_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures mlt_rem_cmt = new WritableCellFeatures();
            mlt_rem_cmt.setComment(mlt_rem, count_r, mlt_r_h);
            mlt_lab_rem.setCellFeatures(mlt_rem_cmt);
            sheet.addCell(mlt_lab_rem);
        }
        
     // MTP3b Remote termination     
        row_index++;
        String mrt_warn = sysfn.sys_hlth_fn_warn("MTP3b Remote termination", "Maximum NniSaalTp termination points per GPB");
        String mrt_rem = sysfn.sys_hlth_fn_rem("MTP3b Remote termination", "Maximum NniSaalTp termination points per GPB");
        
    	Label mrtlab = new Label(0, row_index, "MTP3b Remote termination", ca_b);
        sheet.addCell(mrtlab);
        
    	int mrt_c = 0;
        for(String st : configList)
        {
        	if(st.contains("MTP3b Remote termination"))
        	{
        		mrt_c = configList.indexOf(st);
        	}
        }
        
        if(mrt_warn.equals("OK") && mrt_rem.equals("OK"))
        {
        	Label mrt_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(mrt_ok);
        }
        else
        {
        	Label mrt_ok;
        	if(configList.get(mrt_c).endsWith("[WARNING]"))
        	{
        		mrt_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(mrt_c).endsWith("[INFO]"))
        	{
        		mrt_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(mrt_c).endsWith("[CRITICAL]"))
        	{
        		mrt_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		mrt_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(mrt_ok);
        	
    	    double mrt_w_h = mrt_warn.split(System.getProperty("line.separator")).length;
            double mrt_r_h = mrt_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  mrt_warn.split("\\r?\\n");
            String lines_r[] =  mrt_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label mrt_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures mrt_cmt = new WritableCellFeatures();
        	mrt_cmt.setComment(mrt_warn, count_w, mrt_w_h);
        	mrt_obs.setCellFeatures(mrt_cmt);
        	sheet.addCell(mrt_obs);

            Label mrt_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures mrt_rem_cmt = new WritableCellFeatures();
            mrt_rem_cmt.setComment(mrt_rem, count_r, mrt_r_h);
            mrt_lab_rem.setCellFeatures(mrt_rem_cmt);
            sheet.addCell(mrt_lab_rem);
        }
        
     // Maximum NniSaalTp termination points per GPB     
        row_index++;
        String max_nni_warn = sysfn.sys_hlth_fn_warn("Maximum NniSaalTp termination points per GPB", "Maximum SCTP associations per GPB");
        String max_nni_rem = sysfn.sys_hlth_fn_rem("Maximum NniSaalTp termination points per GPB", "Maximum SCTP associations per GPB");
        
    	Label max_nnilab = new Label(0, row_index, "Maximum NniSaalTp termination points per GPB", ca_b);
        sheet.addCell(max_nnilab);
        
    	int max_nni_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Maximum NniSaalTp termination points per GPB"))
        	{
        		max_nni_c = configList.indexOf(st);
        	}
        }
        
        if(max_nni_warn.equals("OK") && max_nni_rem.equals("OK"))
        {
        	Label max_nni_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(max_nni_ok);
        }
        else
        {
        	Label max_nni_ok;
        	if(configList.get(max_nni_c).endsWith("[WARNING]"))
        	{
        		max_nni_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(max_nni_c).endsWith("[INFO]"))
        	{
        		max_nni_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(max_nni_c).endsWith("[CRITICAL]"))
        	{
        		max_nni_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		max_nni_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(max_nni_ok);
        	
    	    double max_nni_w_h = max_nni_warn.split(System.getProperty("line.separator")).length;
            double max_nni_r_h = max_nni_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  max_nni_warn.split("\\r?\\n");
            String lines_r[] =  max_nni_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label max_nni_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures max_nni_cmt = new WritableCellFeatures();
        	max_nni_cmt.setComment(max_nni_warn, count_w, max_nni_w_h);
        	max_nni_obs.setCellFeatures(max_nni_cmt);
        	sheet.addCell(max_nni_obs);

            Label max_nni_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures max_nni_rem_cmt = new WritableCellFeatures();
            max_nni_rem_cmt.setComment(max_nni_rem, count_r, max_nni_r_h);
            max_nni_lab_rem.setCellFeatures(max_nni_rem_cmt);
            sheet.addCell(max_nni_lab_rem);
        }
        
     // Maximum SCTP associations per GPB     
        row_index++;
        String max_sctp_warn = sysfn.sys_hlth_fn_warn("Maximum SCTP associations per GPB", "Maximum TDM connections on ETC41");
        String max_sctp_rem = sysfn.sys_hlth_fn_rem("Maximum SCTP associations per GPB", "Maximum TDM connections on ETC41");
        
    	Label max_sctplab = new Label(0, row_index, "Maximum SCTP associations per GPB", ca_b);
        sheet.addCell(max_sctplab);
        
    	int max_sctp_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Maximum SCTP associations per GPB"))
        	{
        		max_sctp_c = configList.indexOf(st);
        	}
        }
        
        if(max_sctp_warn.equals("OK") && max_sctp_rem.equals("OK"))
        {
        	Label max_sctp_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(max_sctp_ok);
        }
        else
        {
        	Label max_sctp_ok;
        	if(configList.get(max_sctp_c).endsWith("[WARNING]"))
        	{
        		max_sctp_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(max_sctp_c).endsWith("[INFO]"))
        	{
        		max_sctp_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(max_sctp_c).endsWith("[CRITICAL]"))
        	{
        		max_sctp_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		max_sctp_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(max_sctp_ok);
        	
    	    double max_sctp_w_h = max_sctp_warn.split(System.getProperty("line.separator")).length;
            double max_sctp_r_h = max_sctp_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  max_sctp_warn.split("\\r?\\n");
            String lines_r[] =  max_sctp_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label max_sctp_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures max_sctp_cmt = new WritableCellFeatures();
        	max_sctp_cmt.setComment(max_sctp_warn, count_w, max_sctp_w_h);
        	max_sctp_obs.setCellFeatures(max_sctp_cmt);
        	sheet.addCell(max_sctp_obs);

            Label max_sctp_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures max_sctp_rem_cmt = new WritableCellFeatures();
            max_sctp_rem_cmt.setComment(max_sctp_rem, count_r, max_sctp_r_h);
            max_sctp_lab_rem.setCellFeatures(max_sctp_rem_cmt);
            sheet.addCell(max_sctp_lab_rem);
        }
        
     // Maximum TDM connections on ETC41     
        row_index++;
        String max_tdm_warn = sysfn.sys_hlth_fn_warn("Maximum TDM connections on ETC41", "Missing IpMux references");
        String max_tdm_rem = sysfn.sys_hlth_fn_rem("Maximum TDM connections on ETC41", "Missing IpMux references");
        
    	Label max_tdmlab = new Label(0, row_index, "Maximum TDM connections on ETC41", ca_b);
        sheet.addCell(max_tdmlab);
        
    	int max_tdm_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Maximum TDM connections on ETC41"))
        	{
        		max_tdm_c = configList.indexOf(st);
        	}
        }
        
        if(max_tdm_warn.equals("OK") && max_tdm_rem.equals("OK"))
        {
        	Label max_tdm_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(max_tdm_ok);
        }
        else
        {
        	Label max_tdm_ok;
        	if(configList.get(max_tdm_c).endsWith("[WARNING]"))
        	{
        		max_tdm_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(max_tdm_c).endsWith("[INFO]"))
        	{
        		max_tdm_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(max_tdm_c).endsWith("[CRITICAL]"))
        	{
        		max_tdm_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		max_tdm_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(max_tdm_ok);
        	
    	    double max_tdm_w_h = max_tdm_warn.split(System.getProperty("line.separator")).length;
            double max_tdm_r_h = max_tdm_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  max_tdm_warn.split("\\r?\\n");
            String lines_r[] =  max_tdm_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label max_tdm_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures max_tdm_cmt = new WritableCellFeatures();
        	max_tdm_cmt.setComment(max_tdm_warn, count_w, max_tdm_w_h);
        	max_tdm_obs.setCellFeatures(max_tdm_cmt);
        	sheet.addCell(max_tdm_obs);

            Label max_tdm_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures max_tdm_rem_cmt = new WritableCellFeatures();
            max_tdm_rem_cmt.setComment(max_tdm_rem, count_r, max_tdm_r_h);
            max_tdm_lab_rem.setCellFeatures(max_tdm_rem_cmt);
            sheet.addCell(max_tdm_lab_rem);
        }
        
     // Missing IpMux references     
        row_index++;
        String ipmux_warn = sysfn.sys_hlth_fn_warn("Missing IpMux references", "Mtp3bSp timer values");
        String ipmux_rem = sysfn.sys_hlth_fn_rem("Missing IpMux references", "Mtp3bSp timer values");
        
    	Label ipmuxlab = new Label(0, row_index, "Missing IpMux references", ca_b);
        sheet.addCell(ipmuxlab);
        
    	int ipmux_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Missing IpMux references"))
        	{
        		ipmux_c = configList.indexOf(st);
        	}
        }
        
        if(ipmux_warn.equals("OK") && ipmux_rem.equals("OK"))
        {
        	Label ipmux_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(ipmux_ok);
        }
        else
        {
        	Label ipmux_ok;
        	if(configList.get(ipmux_c).endsWith("[WARNING]"))
        	{
        		ipmux_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(ipmux_c).endsWith("[INFO]"))
        	{
        		ipmux_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(ipmux_c).endsWith("[CRITICAL]"))
        	{
        		ipmux_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		ipmux_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(ipmux_ok);
        	
    	    double ipmux_w_h = ipmux_warn.split(System.getProperty("line.separator")).length;
            double ipmux_r_h = ipmux_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  ipmux_warn.split("\\r?\\n");
            String lines_r[] =  ipmux_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label ipmux_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures ipmux_cmt = new WritableCellFeatures();
        	ipmux_cmt.setComment(ipmux_warn, count_w, ipmux_w_h);
        	ipmux_obs.setCellFeatures(ipmux_cmt);
        	sheet.addCell(ipmux_obs);

            Label ipmux_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures ipmux_rem_cmt = new WritableCellFeatures();
            ipmux_rem_cmt.setComment(ipmux_rem, count_r, ipmux_r_h);
            ipmux_lab_rem.setCellFeatures(ipmux_rem_cmt);
            sheet.addCell(ipmux_lab_rem);
        }
        
     // Mtp3bSp timer values     
        row_index++;
        String mtp_warn = sysfn.sys_hlth_fn_warn("Mtp3bSp timer values", "Not applicable MOs");
        String mtp_rem = sysfn.sys_hlth_fn_rem("Mtp3bSp timer values", "Not applicable MOs");
        
    	Label mtplab = new Label(0, row_index, "Mtp3bSp timer values", ca_b);
        sheet.addCell(mtplab);
        
    	int mtp_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Mtp3bSp timer values"))
        	{
        		mtp_c = configList.indexOf(st);
        	}
        }
        
        if(mtp_warn.equals("OK") && mtp_rem.equals("OK"))
        {
        	Label mtp_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(mtp_ok);
        }
        else
        {
        	Label mtp_ok;
        	if(configList.get(mtp_c).endsWith("[WARNING]"))
        	{
        		mtp_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(mtp_c).endsWith("[INFO]"))
        	{
        		mtp_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(mtp_c).endsWith("[CRITICAL]"))
        	{
        		mtp_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		mtp_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(mtp_ok);
        	
    	    double mtp_w_h = mtp_warn.split(System.getProperty("line.separator")).length;
            double mtp_r_h = mtp_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  mtp_warn.split("\\r?\\n");
            String lines_r[] =  mtp_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label mtp_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures mtp_cmt = new WritableCellFeatures();
        	mtp_cmt.setComment(mtp_warn, count_w, mtp_w_h);
        	mtp_obs.setCellFeatures(mtp_cmt);
        	sheet.addCell(mtp_obs);

            Label mtp_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures mtp_rem_cmt = new WritableCellFeatures();
            mtp_rem_cmt.setComment(mtp_rem, count_r, mtp_r_h);
            mtp_lab_rem.setCellFeatures(mtp_rem_cmt);
            sheet.addCell(mtp_lab_rem);
        }
        
     // Not applicable MOs     
        row_index++;
        String mos_warn = sysfn.sys_hlth_fn_warn("Not applicable MOs", "PIU usage");
        String mos_rem = sysfn.sys_hlth_fn_rem("Not applicable MOs", "PIU usage");
        
    	Label moslab = new Label(0, row_index, "Not applicable MOs", ca_b);
        sheet.addCell(moslab);
        
    	int mos_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Not applicable MOs"))
        	{
        		mos_c = configList.indexOf(st);
        	}
        }
        
        if(mos_warn.equals("OK") && mos_rem.equals("OK"))
        {
        	Label mos_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(mos_ok);
        }
        else
        {
        	Label mos_ok;
        	if(configList.get(mos_c).endsWith("[WARNING]"))
        	{
        		mos_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(mos_c).endsWith("[INFO]"))
        	{
        		mos_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(mos_c).endsWith("[CRITICAL]"))
        	{
        		mos_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		mos_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(mos_ok);
        	
    	    double mos_w_h = mos_warn.split(System.getProperty("line.separator")).length;
            double mos_r_h = mos_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  mos_warn.split("\\r?\\n");
            String lines_r[] =  mos_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label mos_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures mos_cmt = new WritableCellFeatures();
        	mos_cmt.setComment(mos_warn, count_w, mos_w_h);
        	mos_obs.setCellFeatures(mos_cmt);
        	sheet.addCell(mos_obs);

            Label mos_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures mos_rem_cmt = new WritableCellFeatures();
            mos_rem_cmt.setComment(mos_rem, count_r, mos_r_h);
            mos_lab_rem.setCellFeatures(mos_rem_cmt);
            sheet.addCell(mos_lab_rem);
        }
        
     // PIU usage     
        row_index++;
        String piu_warn = sysfn.sys_hlth_fn_warn("PIU usage", "Reliable Program Uniters");
        String piu_rem = sysfn.sys_hlth_fn_rem("PIU usage", "Reliable Program Uniters");
        
    	Label piulab = new Label(0, row_index, "PIU usage", ca_b);
        sheet.addCell(piulab);
        
    	int piu_c = 0;
        for(String st : configList)
        {
        	if(st.contains("PIU usage"))
        	{
        		piu_c = configList.indexOf(st);
        	}
        }
        
        if(piu_warn.equals("OK") && piu_rem.equals("OK"))
        {
        	Label piu_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(piu_ok);
        }
        else
        {
        	Label piu_ok;
        	if(configList.get(piu_c).endsWith("[WARNING]"))
        	{
        		piu_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(piu_c).endsWith("[INFO]"))
        	{
        		piu_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(piu_c).endsWith("[CRITICAL]"))
        	{
        		piu_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		piu_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(piu_ok);
        	
    	    double piu_w_h = piu_warn.split(System.getProperty("line.separator")).length;
            double piu_r_h = piu_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  piu_warn.split("\\r?\\n");
            String lines_r[] =  piu_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label piu_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures piu_cmt = new WritableCellFeatures();
        	piu_cmt.setComment(piu_warn, count_w, piu_w_h);
        	piu_obs.setCellFeatures(piu_cmt);
        	sheet.addCell(piu_obs);

            Label piu_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures piu_rem_cmt = new WritableCellFeatures();
            piu_rem_cmt.setComment(piu_rem, count_r, piu_r_h);
            piu_lab_rem.setCellFeatures(piu_rem_cmt);
            sheet.addCell(piu_lab_rem);
        }
        
     // Reliable Program Uniters     
        row_index++;
        String rpu_warn = sysfn.sys_hlth_fn_warn("Reliable Program Uniters", "Security");
        String rpu_rem = sysfn.sys_hlth_fn_rem("Reliable Program Uniters", "Security");
        
    	Label rpulab = new Label(0, row_index, "Reliable Program Uniters", ca_b);
        sheet.addCell(rpulab);
        
    	int rpu_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Reliable Program Uniters"))
        	{
        		rpu_c = configList.indexOf(st);
        	}
        }
        
        if(rpu_warn.equals("OK") && rpu_rem.equals("OK"))
        {
        	Label rpu_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(rpu_ok);
        }
        else
        {
        	Label rpu_ok;
        	if(configList.get(rpu_c).endsWith("[WARNING]"))
        	{
        		rpu_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(rpu_c).endsWith("[INFO]"))
        	{
        		rpu_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(rpu_c).endsWith("[CRITICAL]"))
        	{
        		rpu_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		rpu_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(rpu_ok);
        	
    	    double rpu_w_h = rpu_warn.split(System.getProperty("line.separator")).length;
            double rpu_r_h = rpu_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  rpu_warn.split("\\r?\\n");
            String lines_r[] =  rpu_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label rpu_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures rpu_cmt = new WritableCellFeatures();
        	rpu_cmt.setComment(rpu_warn, count_w, rpu_w_h);
        	rpu_obs.setCellFeatures(rpu_cmt);
        	sheet.addCell(rpu_obs);

            Label rpu_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures rpu_rem_cmt = new WritableCellFeatures();
            rpu_rem_cmt.setComment(rpu_rem, count_r, rpu_r_h);
            rpu_lab_rem.setCellFeatures(rpu_rem_cmt);
            sheet.addCell(rpu_lab_rem);
        }
        
     // Security     
        row_index++;
        String sec_warn = sysfn.sys_hlth_fn_warn("Security", "Signalling link set content");
        String sec_rem = sysfn.sys_hlth_fn_rem("Security", "Signalling link set content");
        
    	Label seclab = new Label(0, row_index, "Security", ca_b);
        sheet.addCell(seclab);
        
    	int sec_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Security"))
        	{
        		sec_c = configList.indexOf(st);
        	}
        }
        
        if(sec_warn.equals("OK") && sec_rem.equals("OK"))
        {
        	Label sec_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(sec_ok);
        }
        else
        {
        	Label sec_ok;
        	if(configList.get(sec_c).endsWith("[WARNING]"))
        	{
        		sec_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(sec_c).endsWith("[INFO]"))
        	{
        		sec_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(sec_c).endsWith("[CRITICAL]"))
        	{
        		sec_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		sec_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(sec_ok);
        	
    	    double sec_w_h = sec_warn.split(System.getProperty("line.separator")).length;
            double sec_r_h = sec_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  sec_warn.split("\\r?\\n");
            String lines_r[] =  sec_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label sec_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures sec_cmt = new WritableCellFeatures();
        	sec_cmt.setComment(sec_warn, count_w, sec_w_h);
        	sec_obs.setCellFeatures(sec_cmt);
        	sheet.addCell(sec_obs);

            Label sec_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures sec_rem_cmt = new WritableCellFeatures();
            sec_rem_cmt.setComment(sec_rem, count_r, sec_r_h);
            sec_lab_rem.setCellFeatures(sec_rem_cmt);
            sheet.addCell(sec_lab_rem);
        }
        
     // Signalling link set content     
        row_index++;
        String sig_lst_warn = sysfn.sys_hlth_fn_warn("Signalling link set content", "Signalling loop");
        String sig_lst_rem = sysfn.sys_hlth_fn_rem("Signalling link set content", "Signalling loop");
        
    	Label sig_lstlab = new Label(0, row_index, "Signalling link set content", ca_b);
        sheet.addCell(sig_lstlab);
        
    	int sig_lst_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Signalling link set content"))
        	{
        		sig_lst_c = configList.indexOf(st);
        	}
        }
        
        if(sig_lst_warn.equals("OK") && sig_lst_rem.equals("OK"))
        {
        	Label sig_lst_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(sig_lst_ok);
        }
        else
        {
        	Label sig_lst_ok;
        	if(configList.get(sig_lst_c).endsWith("[WARNING]"))
        	{
        		sig_lst_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(sig_lst_c).endsWith("[INFO]"))
        	{
        		sig_lst_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(sig_lst_c).endsWith("[CRITICAL]"))
        	{
        		sig_lst_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		sig_lst_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(sig_lst_ok);
        	
    	    double sig_lst_w_h = sig_lst_warn.split(System.getProperty("line.separator")).length;
            double sig_lst_r_h = sig_lst_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  sig_lst_warn.split("\\r?\\n");
            String lines_r[] =  sig_lst_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label sig_lst_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures sig_lst_cmt = new WritableCellFeatures();
        	sig_lst_cmt.setComment(sig_lst_warn, count_w, sig_lst_w_h);
        	sig_lst_obs.setCellFeatures(sig_lst_cmt);
        	sheet.addCell(sig_lst_obs);

            Label sig_lst_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures sig_lst_rem_cmt = new WritableCellFeatures();
            sig_lst_rem_cmt.setComment(sig_lst_rem, count_r, sig_lst_r_h);
            sig_lst_lab_rem.setCellFeatures(sig_lst_rem_cmt);
            sheet.addCell(sig_lst_lab_rem);
        }
        
     // Signalling loop     
        row_index++;
        String sig_loop_warn = sysfn.sys_hlth_fn_warn("Signalling loop", "Unlocked and disabled MOs");
        String sig_loop_rem = sysfn.sys_hlth_fn_rem("Signalling loop", "Unlocked and disabled MOs");
        
    	Label sig_looplab = new Label(0, row_index, "Signalling loop", ca_b);
        sheet.addCell(sig_looplab);
        
    	int sig_loop_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Signalling loop"))
        	{
        		sig_loop_c = configList.indexOf(st);
        	}
        }
        
        if(sig_loop_warn.equals("OK") && sig_loop_rem.equals("OK"))
        {
        	Label sig_loop_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(sig_loop_ok);
        }
        else
        {
        	Label sig_loop_ok;
        	if(configList.get(sig_loop_c).endsWith("[WARNING]"))
        	{
        		sig_loop_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(sig_loop_c).endsWith("[INFO]"))
        	{
        		sig_loop_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(sig_loop_c).endsWith("[CRITICAL]"))
        	{
        		sig_loop_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		sig_loop_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(sig_loop_ok);
        	
    	    double sig_loop_w_h = sig_loop_warn.split(System.getProperty("line.separator")).length;
            double sig_loop_r_h = sig_loop_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  sig_loop_warn.split("\\r?\\n");
            String lines_r[] =  sig_loop_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label sig_loop_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures sig_loop_cmt = new WritableCellFeatures();
        	sig_loop_cmt.setComment(sig_loop_warn, count_w, sig_loop_w_h);
        	sig_loop_obs.setCellFeatures(sig_loop_cmt);
        	sheet.addCell(sig_loop_obs);

            Label sig_loop_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures sig_loop_rem_cmt = new WritableCellFeatures();
            sig_loop_rem_cmt.setComment(sig_loop_rem, count_r, sig_loop_r_h);
            sig_loop_lab_rem.setCellFeatures(sig_loop_rem_cmt);
            sheet.addCell(sig_loop_lab_rem);
        }
        
     // Unlocked and disabled MOs     
        row_index++;
        String dis_mos_warn = sysfn.sys_hlth_fn_warn("Unlocked and disabled MOs", "Value recommendations");
        String dis_mos_rem = sysfn.sys_hlth_fn_rem("Unlocked and disabled MOs", "Value recommendations");
        
    	Label dis_moslab = new Label(0, row_index, "Unlocked and disabled MOs", ca_b);
        sheet.addCell(dis_moslab);
        
    	int dis_mos_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Unlocked and disabled MOs"))
        	{
        		dis_mos_c = configList.indexOf(st);
        	}
        }
        
        if(dis_mos_warn.equals("OK") && dis_mos_rem.equals("OK"))
        {
        	Label dis_mos_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(dis_mos_ok);
        }
        else
        {
        	Label dis_mos_ok;
        	if(configList.get(dis_mos_c).endsWith("[WARNING]"))
        	{
        		dis_mos_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(dis_mos_c).endsWith("[INFO]"))
        	{
        		dis_mos_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(dis_mos_c).endsWith("[CRITICAL]"))
        	{
        		dis_mos_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		dis_mos_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(dis_mos_ok);
        	
        	double dis_mos_w_h = dis_mos_warn.split(System.getProperty("line.separator")).length;
            double dis_mos_r_h = dis_mos_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  dis_mos_warn.split("\\r?\\n");
            String lines_r[] =  dis_mos_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
            		count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
            
        	Label dis_mos_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures dis_mos_cmt = new WritableCellFeatures();
        	dis_mos_cmt.setComment(dis_mos_warn, count_w, dis_mos_w_h);
        	dis_mos_obs.setCellFeatures(dis_mos_cmt);
        	sheet.addCell(dis_mos_obs);

            Label dis_mos_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures dis_mos_rem_cmt = new WritableCellFeatures();
            dis_mos_rem_cmt.setComment(dis_mos_rem, count_r, dis_mos_r_h);
            dis_mos_lab_rem.setCellFeatures(dis_mos_rem_cmt);
            sheet.addCell(dis_mos_lab_rem);
        }
        
     // Value recommendations     
        row_index++;
        String val_rec_warn = sysfn.sys_hlth_fn_warn("Value recommendations", "System health:");
        String val_rec_rem = sysfn.sys_hlth_fn_rem("Value recommendations", "System health:");
        
    	Label val_reclab = new Label(0, row_index, "Value recommendations", ca_b);
        sheet.addCell(val_reclab);
        
    	int val_rec_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Value recommendations"))
        	{
        		val_rec_c = configList.indexOf(st);
        	}
        }
        
        if(val_rec_warn.equals("OK") && val_rec_rem.equals("OK"))
        {
        	Label val_rec_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(val_rec_ok);
        }
        else
        {
        	Label val_rec_ok;
        	if(configList.get(val_rec_c).endsWith("[WARNING]"))
        	{
        		val_rec_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(val_rec_c).endsWith("[INFO]"))
        	{
        		val_rec_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(val_rec_c).endsWith("[CRITICAL]"))
        	{
        		val_rec_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		val_rec_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(val_rec_ok);
        	
    	    double val_rec_w_h = val_rec_warn.split(System.getProperty("line.separator")).length;
            double val_rec_r_h = val_rec_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  val_rec_warn.split("\\r?\\n");
            String lines_r[] =  val_rec_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label val_rec_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures val_rec_cmt = new WritableCellFeatures();
        	val_rec_cmt.setComment(val_rec_warn, count_w, val_rec_w_h);
        	val_rec_obs.setCellFeatures(val_rec_cmt);
        	sheet.addCell(val_rec_obs);

            Label val_rec_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures val_rec_rem_cmt = new WritableCellFeatures();
            val_rec_rem_cmt.setComment(val_rec_rem, count_r, val_rec_r_h);
            val_rec_lab_rem.setCellFeatures(val_rec_rem_cmt);
            sheet.addCell(val_rec_lab_rem);
        }
        
        
// ******* system check        
        
        
    // Active security mode
        row_index++;
        String asm_warn = sysfn.sys_hlth_fn_warn("Active security mode", "Board restarts and errors");
        String asm_rem = sysfn.sys_hlth_fn_rem("Active security mode", "Board restarts and errors");
        
        Label asmlab = new Label(0, row_index, "Active security mode", ca_b);
        sheet.addCell(asmlab);
        
        int asm_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Active security mode"))
        	{
        		asm_c = configList.indexOf(st);
        	}
        }
        
        if(asm_warn.equals("OK") && asm_rem.equals("OK"))
        {
        	Label asm_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(asm_ok);
        }
        else
        {
        	Label asm_ok;
        	if(configList.get(asm_c).endsWith("[WARNING]"))
        	{
        		asm_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(asm_c).endsWith("[INFO]"))
        	{
        		asm_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(asm_c).endsWith("[CRITICAL]"))
        	{
        		asm_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		asm_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(asm_ok);
        	
        	double asm_w_h = asm_warn.split(System.getProperty("line.separator")).length;
        	double asm_r_h = asm_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  asm_warn.split("\\r?\\n");
            String lines_r[] =  asm_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label asm_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures asm_cmt = new WritableCellFeatures();
        	asm_cmt.setComment(asm_warn, count_w, asm_w_h);
        	asm_obs.setCellFeatures(asm_cmt);
        	sheet.addCell(asm_obs);

            Label asm_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures asm_rem_cmt = new WritableCellFeatures();
            asm_rem_cmt.setComment(asm_rem, count_r, asm_r_h);
            asm_lab_rem.setCellFeatures(asm_rem_cmt);
            sheet.addCell(asm_lab_rem);
        }

   // Board restarts and errors    
        row_index++;
        String bre_warn = sysfn.sys_hlth_fn_warn("Board restarts and errors", "Board temperature");
        String bre_rem = sysfn.sys_hlth_fn_rem("Board restarts and errors", "Board temperature");
        
        Label brelab = new Label(0, row_index, "Board restarts and errors", ca_b);
        sheet.addCell(brelab);
        
        int bre_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Active security mode"))
        	{
        		bre_c = configList.indexOf(st);
        	}
        }
        
        if(bre_warn.equals("OK") && bre_rem.equals("OK"))
        {
        	Label bre_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(bre_ok);
        }
        else
        {
        	Label bre_ok;
        	if(configList.get(bre_c).endsWith("[WARNING]"))
        	{
        		bre_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(bre_c).endsWith("[INFO]"))
        	{
        		bre_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(bre_c).endsWith("[CRITICAL]"))
        	{
        		bre_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		bre_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(bre_ok);
        	
    	    double bre_w_h = bre_warn.split(System.getProperty("line.separator")).length;
            double bre_r_h = bre_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  bre_warn.split("\\r?\\n");
            String lines_r[] =  bre_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label bre_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures bre_cmt = new WritableCellFeatures();
        	bre_cmt.setComment(bre_warn, count_w, bre_w_h);
        	bre_obs.setCellFeatures(bre_cmt);
        	sheet.addCell(bre_obs);

            Label bre_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures bre_rem_cmt = new WritableCellFeatures();
            bre_rem_cmt.setComment(bre_rem, count_r, bre_r_h);
            bre_lab_rem.setCellFeatures(bre_rem_cmt);
            sheet.addCell(bre_lab_rem);
        }

   // Board temperature    
        row_index++;
        String bt_warn = sysfn.sys_hlth_fn_warn("Board temperature", "CMXB board spontaneous restarts");
        String bt_rem = sysfn.sys_hlth_fn_rem("Board temperature", "CMXB board spontaneous restarts");
        
        Label btlab = new Label(0, row_index, "Board temperature", ca_b);
        sheet.addCell(btlab);
        
        int bt_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Board temperature"))
        	{
        		bt_c = configList.indexOf(st);
        	}
        }
        
        if(bt_warn.equals("OK") && bt_rem.equals("OK"))
        {
        	Label bt_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(bt_ok);
        }
        else
        {
        	Label bt_ok;
        	if(configList.get(bt_c).endsWith("[WARNING]"))
        	{
        		bt_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(bt_c).endsWith("[INFO]"))
        	{
        		bt_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(bt_c).endsWith("[CRITICAL]"))
        	{
        		bt_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		bt_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(bt_ok);
        	
    	    double bt_w_h = bt_warn.split(System.getProperty("line.separator")).length;
            double bt_r_h = bt_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  bt_warn.split("\\r?\\n");
            String lines_r[] =  bt_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label bt_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures bt_cmt = new WritableCellFeatures();
        	bt_cmt.setComment(bt_warn, count_w, bt_w_h);
        	bt_obs.setCellFeatures(bt_cmt);
        	sheet.addCell(bt_obs);

            Label bt_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures bt_rem_cmt = new WritableCellFeatures();
            bt_rem_cmt.setComment(bt_rem, count_r, bt_r_h);
            bt_lab_rem.setCellFeatures(bt_rem_cmt);
            sheet.addCell(bt_lab_rem);
        }

   // CMXB board spontaneous restarts     
        row_index++;
        String cmxb_warn = sysfn.sys_hlth_fn_warn("CMXB board spontaneous restarts", "CPU load");
        String cmxb_rem = sysfn.sys_hlth_fn_rem("CMXB board spontaneous restarts", "CPU load");
        
    	Label cmxblab = new Label(0, row_index, "CMXB board spontaneous restarts", ca_b);
        sheet.addCell(cmxblab);
        
        int cmxb_c = 0;
        for(String st : configList)
        {
        	if(st.contains("CMXB board spontaneous restarts"))
        	{
        		cmxb_c = configList.indexOf(st);
        	}
        }
        
        if(cmxb_warn.equals("OK") && cmxb_rem.equals("OK"))
        {
        	Label cmxb_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(cmxb_ok);
        }
        else
        {
        	Label cmxb_ok;
        	if(configList.get(cmxb_c).endsWith("[WARNING]"))
        	{
        		cmxb_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(cmxb_c).endsWith("[INFO]"))
        	{
        		cmxb_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(cmxb_c).endsWith("[CRITICAL]"))
        	{
        		cmxb_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		cmxb_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(cmxb_ok);
        	
    	    double cmxb_w_h = cmxb_warn.split(System.getProperty("line.separator")).length;
            double cmxb_r_h = cmxb_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  cmxb_warn.split("\\r?\\n");
            String lines_r[] =  cmxb_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label cmxb_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures cmxb_cmt = new WritableCellFeatures();
        	cmxb_cmt.setComment(cmxb_warn, count_w, cmxb_w_h);
        	cmxb_obs.setCellFeatures(cmxb_cmt);
        	sheet.addCell(cmxb_obs);

            Label cmxb_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cmxb_rem_cmt = new WritableCellFeatures();
            cmxb_rem_cmt.setComment(cmxb_rem, count_r, cmxb_r_h);
            cmxb_lab_rem.setCellFeatures(cmxb_rem_cmt);
            sheet.addCell(cmxb_lab_rem);
        }

   // CPU load     
        row_index++;
        String cpu_warn = sysfn.sys_hlth_fn_warn("CPU load", "Capacity threshold alarms");
        String cpu_rem = sysfn.sys_hlth_fn_rem("CPU load", "Capacity threshold alarms");
        
    	Label cpulab = new Label(0, row_index, "CPU load", ca_b);
        sheet.addCell(cpulab);
        
        int cpu_c = 0;
        for(String st : configList)
        {
        	if(st.contains("CPU load"))
        	{
        		cpu_c = configList.indexOf(st);
        	}
        }
        
        if(cpu_warn.equals("OK") && cpu_rem.equals("OK"))
        {
        	Label cpu_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(cpu_ok);
        }
        else
        {
        	Label cpu_ok;
        	if(configList.get(cpu_c).endsWith("[WARNING]"))
        	{
        		cpu_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(cpu_c).endsWith("[INFO]"))
        	{
        		cpu_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(cpu_c).endsWith("[CRITICAL]"))
        	{
        		cpu_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		cpu_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(cpu_ok);
        	
    	    double cpu_w_h = cpu_warn.split(System.getProperty("line.separator")).length;
            double cpu_r_h = cpu_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  cpu_warn.split("\\r?\\n");
            String lines_r[] =  cpu_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label cpu_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures cpu_cmt = new WritableCellFeatures();
        	cpu_cmt.setComment(cpu_warn, count_w, cpu_w_h);
        	cpu_obs.setCellFeatures(cpu_cmt);
        	sheet.addCell(cpu_obs);

            Label cpu_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cpu_rem_cmt = new WritableCellFeatures();
            cpu_rem_cmt.setComment(cpu_rem, count_r, cpu_r_h);
            cpu_lab_rem.setCellFeatures(cpu_rem_cmt);
            sheet.addCell(cpu_lab_rem);
        }

   // Capacity threshold alarms     
        row_index++;
        String cta_warn = sysfn.sys_hlth_fn_warn("Capacity threshold alarms", "Disk status");
        String cta_rem = sysfn.sys_hlth_fn_rem("Capacity threshold alarms", "Disk status");
        
    	Label ctalab = new Label(0, row_index, "Capacity threshold alarms", ca_b);
        sheet.addCell(ctalab);
        
    	int cta_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Capacity threshold alarms"))
        	{
        		cta_c = configList.indexOf(st);
        	}
        }
        
        if(cta_warn.equals("OK") && cta_rem.equals("OK"))
        {
        	Label cta_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(cta_ok);
        }
        else
        {
        	Label cta_ok;
        	if(configList.get(cta_c).endsWith("[WARNING]"))
        	{
        		cta_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(cta_c).endsWith("[INFO]"))
        	{
        		cta_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(cta_c).endsWith("[CRITICAL]"))
        	{
        		cta_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		cta_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(cta_ok);
        	
    	    double cta_w_h = cta_warn.split(System.getProperty("line.separator")).length;
            double cta_r_h = cta_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  cta_warn.split("\\r?\\n");
            String lines_r[] =  cta_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label cta_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures cta_cmt = new WritableCellFeatures();
        	cta_cmt.setComment(cta_warn, count_w, cta_w_h);
        	cta_obs.setCellFeatures(cta_cmt);
        	sheet.addCell(cta_obs);

            Label cta_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cta_rem_cmt = new WritableCellFeatures();
            cta_rem_cmt.setComment(cta_rem, count_r, cta_r_h);
            cta_lab_rem.setCellFeatures(cta_rem_cmt);
            sheet.addCell(cta_lab_rem);
        }
        
   // Disk status     
        row_index++;
        String ds_warn = sysfn.sys_hlth_fn_warn("Disk status", "Disk usage");
        String ds_rem = sysfn.sys_hlth_fn_rem("Disk status", "Disk usage");
        
    	Label dslab = new Label(0, row_index, "Disk status", ca_b);
        sheet.addCell(dslab);
        
    	int ds_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Disk status"))
        	{
        		ds_c = configList.indexOf(st);
        	}
        }
        
        if(ds_warn.equals("OK") && ds_rem.equals("OK"))
        {
        	Label ds_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(ds_ok);
        }
        else
        {
        	Label ds_ok;
        	if(configList.get(ds_c).endsWith("[WARNING]"))
        	{
        		ds_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(ds_c).endsWith("[INFO]"))
        	{
        		ds_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(ds_c).endsWith("[CRITICAL]"))
        	{
        		ds_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		ds_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(ds_ok);
        	
    	    double ds_w_h = ds_warn.split(System.getProperty("line.separator")).length;
            double ds_r_h = ds_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  ds_warn.split("\\r?\\n");
            String lines_r[] =  ds_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label ds_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures ds_cmt = new WritableCellFeatures();
        	ds_cmt.setComment(ds_warn, count_w, ds_w_h);
        	ds_obs.setCellFeatures(ds_cmt);
        	sheet.addCell(ds_obs);

            Label ds_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures ds_rem_cmt = new WritableCellFeatures();
            ds_rem_cmt.setComment(ds_rem, count_r, ds_r_h);
            ds_lab_rem.setCellFeatures(ds_rem_cmt);
            sheet.addCell(ds_lab_rem);
        }
        
   // Disk Usage     
        row_index++;
        String du_warn = sysfn.sys_hlth_fn_warn("Disk usage", "Drive mirroring status");
        String du_rem = sysfn.sys_hlth_fn_rem("Disk usage", "Drive mirroring status");
        
    	Label dulab = new Label(0, row_index, "Disk usage", ca_b);
        sheet.addCell(dulab);
        
    	int du_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Disk usage"))
        	{
        		du_c = configList.indexOf(st);
        	}
        }
        
        if(du_warn.equals("OK") && du_rem.equals("OK"))
        {
        	Label du_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(du_ok);
        }
        else
        {
        	Label du_ok;
        	if(configList.get(du_c).endsWith("[WARNING]"))
        	{
        		du_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(du_c).endsWith("[INFO]"))
        	{
        		du_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(du_c).endsWith("[CRITICAL]"))
        	{
        		du_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		du_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(du_ok);
        	
    	    double du_w_h = du_warn.split(System.getProperty("line.separator")).length;
            double du_r_h = du_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = du_warn.split("\\r?\\n");
            String lines_r[] = du_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label du_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures du_cmt = new WritableCellFeatures();
        	du_cmt.setComment(du_warn, count_w, du_w_h);
        	du_obs.setCellFeatures(du_cmt);
        	sheet.addCell(du_obs);

            Label du_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures du_rem_cmt = new WritableCellFeatures();
            du_rem_cmt.setComment(du_rem, count_r, du_r_h);
            du_lab_rem.setCellFeatures(du_rem_cmt);
            sheet.addCell(du_lab_rem);
        }

   // Drive mirroring status     
        row_index++;
        String dms_warn = sysfn.sys_hlth_fn_warn("Drive mirroring status", "Emergency state");
        String dms_rem = sysfn.sys_hlth_fn_rem("Drive mirroring status", "Emergency state");
        
    	Label dmslab = new Label(0, row_index, "Drive mirroring status", ca_b);
        sheet.addCell(dmslab);
        
    	int dms_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Drive mirroring status"))
        	{
        		dms_c = configList.indexOf(st);
        	}
        }
        
        if(dms_warn.equals("OK") && dms_rem.equals("OK"))
        {
        	Label dms_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(dms_ok);
        }
        else
        {
        	Label dms_ok;
        	if(configList.get(dms_c).endsWith("[WARNING]"))
        	{
        		dms_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(dms_c).endsWith("[INFO]"))
        	{
        		dms_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(dms_c).endsWith("[CRITICAL]"))
        	{
        		dms_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		dms_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(dms_ok);
        	
    	    double dms_w_h = dms_warn.split(System.getProperty("line.separator")).length;
            double dms_r_h = dms_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  dms_warn.split("\\r?\\n");
            String lines_r[] =  dms_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label dms_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures dms_cmt = new WritableCellFeatures();
        	dms_cmt.setComment(dms_warn, count_w, dms_w_h);
        	dms_obs.setCellFeatures(dms_cmt);
        	sheet.addCell(dms_obs);

            Label dms_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures dms_rem_cmt = new WritableCellFeatures();
            dms_rem_cmt.setComment(dms_rem, count_r, dms_r_h);
            dms_lab_rem.setCellFeatures(dms_rem_cmt);
            sheet.addCell(dms_lab_rem);
        }
        
   // Emergency state     
        row_index++;
        String es_warn = sysfn.sys_hlth_fn_warn("Emergency state", "Fan alarms");
        String es_rem = sysfn.sys_hlth_fn_rem("Emergency state", "Fan alarms"); 
        
    	Label eslab = new Label(0, row_index, "Emergency state", ca_b);
        sheet.addCell(eslab);
        
    	int es_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Emergency state"))
        	{
        		es_c = configList.indexOf(st);
        	}
        }
        
        if(es_warn.equals("OK") && es_rem.equals("OK"))
        {
        	Label es_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(es_ok);
        }
        else
        {
        	Label es_ok;
        	if(configList.get(es_c).endsWith("[WARNING]"))
        	{
        		es_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(es_c).endsWith("[INFO]"))
        	{
        		es_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(es_c).endsWith("[CRITICAL]"))
        	{
        		es_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		es_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(es_ok);
        	
    	    double es_w_h = es_warn.split(System.getProperty("line.separator")).length;
            double es_r_h = es_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] =  es_warn.split("\\r?\\n");
            String lines_r[] =  es_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label es_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures es_cmt = new WritableCellFeatures();
        	es_cmt.setComment(es_warn, count_w, es_w_h);
        	es_obs.setCellFeatures(es_cmt);
        	sheet.addCell(es_obs);

            Label es_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures es_rem_cmt = new WritableCellFeatures();
            es_rem_cmt.setComment(es_rem, count_r, es_r_h);
            es_lab_rem.setCellFeatures(es_rem_cmt);
            sheet.addCell(es_lab_rem);
        }
        
//*******
     // Fan alarms     
        row_index++;
        String fan_warn = sysfn.sys_hlth_fn_warn("Fan alarms", "GCP Load control activations");
        String fan_rem = sysfn.sys_hlth_fn_rem("Fan alarms", "GCP Load control activations");
        
    	Label fanlab = new Label(0, row_index, "Fan alarms", ca_b);
        sheet.addCell(fanlab);
        
    	int fan_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Fan alarms"))
        	{
        		fan_c = configList.indexOf(st);
        	}
        }
        
        if(fan_warn.equals("OK") && fan_rem.equals("OK"))
        {
        	Label fan_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(fan_ok);
        }
        else
        {
        	Label fan_ok;
        	if(configList.get(fan_c).endsWith("[WARNING]"))
        	{
        		fan_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(fan_c).endsWith("[INFO]"))
        	{
        		fan_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(fan_c).endsWith("[CRITICAL]"))
        	{
        		fan_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		fan_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(fan_ok);
        	
    	    double fan_w_h = fan_warn.split(System.getProperty("line.separator")).length;
            double fan_r_h = fan_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = fan_warn.split("\\r?\\n");
            String lines_r[] = fan_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label fan_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures fan_cmt = new WritableCellFeatures();
        	fan_cmt.setComment(fan_warn, count_w, fan_w_h);
        	fan_obs.setCellFeatures(fan_cmt);
        	sheet.addCell(fan_obs);

            Label fan_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures fan_rem_cmt = new WritableCellFeatures();
            fan_rem_cmt.setComment(fan_rem, count_r, fan_r_h);
            fan_lab_rem.setCellFeatures(fan_rem_cmt);
            sheet.addCell(fan_lab_rem);
        }

     // GCP Load control activations     
        row_index++;
        String gcp_warn = sysfn.sys_hlth_fn_warn("GCP Load control activations", "Handling of Configuration Versions");
        String gcp_rem = sysfn.sys_hlth_fn_rem("GCP Load control activations", "Handling of Configuration Versions");
        
    	Label gcplab = new Label(0, row_index, "GCP Load control activations", ca_b);
        sheet.addCell(gcplab);
        
    	int gcp_c = 0;
        for(String st : configList)
        {
        	if(st.contains("GCP Load control activations"))
        	{
        		gcp_c = configList.indexOf(st);
        	}
        }
        
        if(gcp_warn.equals("OK") && gcp_rem.equals("OK"))
        {
        	Label gcp_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(gcp_ok);
        }
        else
        {
        	Label gcp_ok;
        	if(configList.get(gcp_c).endsWith("[WARNING]"))
        	{
        		gcp_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(gcp_c).endsWith("[INFO]"))
        	{
        		gcp_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(gcp_c).endsWith("[CRITICAL]"))
        	{
        		gcp_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		gcp_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(gcp_ok);

    	    double gcp_w_h = gcp_warn.split(System.getProperty("line.separator")).length;
            double gcp_r_h = gcp_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = gcp_warn.split("\\r?\\n");
            String lines_r[] = gcp_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
        	
        	Label gcp_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures gcp_cmt = new WritableCellFeatures();
        	gcp_cmt.setComment(gcp_warn, count_w, gcp_w_h);
        	gcp_obs.setCellFeatures(gcp_cmt);
        	sheet.addCell(gcp_obs);

            Label gcp_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures gcp_rem_cmt = new WritableCellFeatures();
            gcp_rem_cmt.setComment(gcp_rem, count_r, gcp_r_h);
            gcp_lab_rem.setCellFeatures(gcp_rem_cmt);
            sheet.addCell(gcp_lab_rem);
        }

     // Handling of Configuration Versions     
        row_index++;
        String hcv_warn = sysfn.sys_hlth_fn_warn("Handling of Configuration Versions", "Hanging MeSC instances");
        String hcv_rem = sysfn.sys_hlth_fn_rem("Handling of Configuration Versions", "Hanging MeSC instances");
        
    	Label hcvlab = new Label(0, row_index, "Handling of Configuration Versions", ca_b);
        sheet.addCell(hcvlab);
        
    	int hcv_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Handling of Configuration Versions"))
        	{
        		hcv_c = configList.indexOf(st);
        	}
        }
        
        if(hcv_warn.equals("OK") && hcv_rem.equals("OK"))
        {
        	Label hcv_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(hcv_ok);
        }
        else
        {
        	Label hcv_ok;
        	if(configList.get(hcv_c).endsWith("[WARNING]"))
        	{
        		hcv_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(hcv_c).endsWith("[INFO]"))
        	{
        		hcv_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(hcv_c).endsWith("[CRITICAL]"))
        	{
        		hcv_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		hcv_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(hcv_ok);
        	
    	    double hcv_w_h = hcv_warn.split(System.getProperty("line.separator")).length;
            double hcv_r_h = hcv_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = hcv_warn.split("\\r?\\n");
            String lines_r[] = hcv_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label hcv_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures hcv_cmt = new WritableCellFeatures();
        	hcv_cmt.setComment(hcv_warn, count_w, hcv_w_h);
        	hcv_obs.setCellFeatures(hcv_cmt);
        	sheet.addCell(hcv_obs);

            Label hcv_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures hcv_rem_cmt = new WritableCellFeatures();
            hcv_rem_cmt.setComment(hcv_rem, count_r,hcv_r_h);
            hcv_lab_rem.setCellFeatures(hcv_rem_cmt);
            sheet.addCell(hcv_lab_rem);
        }

     // Hanging MeSC instances     
        row_index++;
        String mesc_warn = sysfn.sys_hlth_fn_warn("Hanging MeSC instances", "Heap and Pool usage");
        String mesc_rem = sysfn.sys_hlth_fn_rem("Hanging MeSC instances", "Heap and Pool usage");
        
    	Label mesclab = new Label(0, row_index, "Hanging MeSC instances", ca_b);
        sheet.addCell(mesclab);
        
    	int mesc_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Hanging MeSC instances"))
        	{
        		mesc_c = configList.indexOf(st);
        	}
        }
        
        if(mesc_warn.equals("OK") && mesc_rem.equals("OK"))
        {
        	Label mesc_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(mesc_ok);
        }
        else
        {
        	Label mesc_ok;
        	if(configList.get(mesc_c).endsWith("[WARNING]"))
        	{
        		mesc_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(mesc_c).endsWith("[INFO]"))
        	{
        		mesc_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(mesc_c).endsWith("[CRITICAL]"))
        	{
        		mesc_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		mesc_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(mesc_ok);
        	
    	    double mesc_w_h = mesc_warn.split(System.getProperty("line.separator")).length;
            double mesc_r_h = mesc_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = mesc_warn.split("\\r?\\n");
            String lines_r[] = mesc_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label mesc_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures mesc_cmt = new WritableCellFeatures();
        	mesc_cmt.setComment(mesc_warn, count_w, mesc_w_h);
        	mesc_obs.setCellFeatures(mesc_cmt);
        	sheet.addCell(mesc_obs);

            Label mesc_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures mesc_rem_cmt = new WritableCellFeatures();
            mesc_rem_cmt.setComment(mesc_rem, count_r, mesc_r_h);
            mesc_lab_rem.setCellFeatures(mesc_rem_cmt);
            sheet.addCell(mesc_lab_rem);
        }
        
     // Heap and Pool usage     
        row_index++;
        String hpu_warn = sysfn.sys_hlth_fn_warn("Heap and Pool usage", "LED statuses");
        String hpu_rem = sysfn.sys_hlth_fn_rem("Heap and Pool usage", "LED statuses");
        
    	Label hpulab = new Label(0, row_index, "Heap and Pool usage", ca_b);
        sheet.addCell(hpulab);
        
    	int hpu_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Heap and Pool usage"))
        	{
        		hpu_c = configList.indexOf(st);
        	}
        }
        
        if(hpu_warn.equals("OK") && hpu_rem.equals("OK"))
        {
        	Label hpu_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(hpu_ok);
        }
        else
        {
        	Label hpu_ok;
        	if(configList.get(hpu_c).endsWith("[WARNING]"))
        	{
        		hpu_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(hpu_c).endsWith("[INFO]"))
        	{
        		hpu_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(hpu_c).endsWith("[CRITICAL]"))
        	{
        		hpu_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		hpu_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(hpu_ok);
        	
    	    double hpu_w_h = hpu_warn.split(System.getProperty("line.separator")).length;
            double hpu_r_h = hpu_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = hpu_warn.split("\\r?\\n");
            String lines_r[] = hpu_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label hpu_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures hpu_cmt = new WritableCellFeatures();
        	hpu_cmt.setComment(hpu_warn, count_w, hpu_w_h);
        	hpu_obs.setCellFeatures(hpu_cmt);
        	sheet.addCell(hpu_obs);

            Label hpu_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures hpu_rem_cmt = new WritableCellFeatures();
            hpu_rem_cmt.setComment(hpu_rem, count_r, hpu_r_h);
            hpu_lab_rem.setCellFeatures(hpu_rem_cmt);
            sheet.addCell(hpu_lab_rem);
        }
        
     // LED statuses     
        row_index++;
        String led_warn = sysfn.sys_hlth_fn_warn("LED statuses", "License usage");
        String led_rem = sysfn.sys_hlth_fn_rem("LED statuses", "License usage");
        
    	Label ledlab = new Label(0, row_index, "LED statuses", ca_b);
        sheet.addCell(ledlab);
        
    	int led_c = 0;
        for(String st : configList)
        {
        	if(st.contains("LED statuses"))
        	{
        		led_c = configList.indexOf(st);
        	}
        }
        
        if(led_warn.equals("OK") && led_rem.equals("OK"))
        {
        	Label led_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(led_ok);
        }
        else
        {
        	Label led_ok;
        	if(configList.get(led_c).endsWith("[WARNING]"))
        	{
        		led_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(led_c).endsWith("[INFO]"))
        	{
        		led_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(led_c).endsWith("[CRITICAL]"))
        	{
        		led_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		led_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(led_ok);
        	
    	    double led_w_h = led_warn.split(System.getProperty("line.separator")).length;
            double led_r_h = led_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = led_warn.split("\\r?\\n");
            String lines_r[] = led_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label led_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures led_cmt = new WritableCellFeatures();
        	led_cmt.setComment(led_warn, count_w, led_w_h);
        	led_obs.setCellFeatures(led_cmt);
        	sheet.addCell(led_obs);

            Label led_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures led_rem_cmt = new WritableCellFeatures();
            led_rem_cmt.setComment(led_rem, count_r, led_r_h);
            led_lab_rem.setCellFeatures(led_rem_cmt);
            sheet.addCell(led_lab_rem);
        }

     // License usage     
        row_index++;
        String lu_warn = sysfn.sys_hlth_fn_warn("License usage", "Login failures");
        String lu_rem = sysfn.sys_hlth_fn_rem("License usage", "Login failures");
        
    	Label lulab = new Label(0, row_index, "License usage", ca_b);
        sheet.addCell(lulab);
        
    	int lu_c = 0;
        for(String st : configList)
        {
        	if(st.contains("License usage"))
        	{
        		lu_c = configList.indexOf(st);
        	}
        }
        
        if(lu_warn.equals("OK") && lu_rem.equals("OK"))
        {
        	Label lu_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(lu_ok);
        }
        else
        {
        	Label lu_ok;
        	if(configList.get(lu_c).endsWith("[WARNING]"))
        	{
        		lu_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(lu_c).endsWith("[INFO]"))
        	{
        		lu_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(lu_c).endsWith("[CRITICAL]"))
        	{
        		lu_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		lu_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(lu_ok);
        	
    	    double lu_w_h = lu_warn.split(System.getProperty("line.separator")).length;
            double lu_r_h = lu_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = lu_warn.split("\\r?\\n");
            String lines_r[] = lu_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label lu_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures lu_cmt = new WritableCellFeatures();
        	lu_cmt.setComment(lu_warn, count_w, lu_w_h);
        	lu_obs.setCellFeatures(lu_cmt);
        	sheet.addCell(lu_obs);

            Label lu_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures lu_rem_cmt = new WritableCellFeatures();
            lu_rem_cmt.setComment(lu_rem, count_r, lu_r_h);
            lu_lab_rem.setCellFeatures(lu_rem_cmt);
            sheet.addCell(lu_lab_rem);
        }
        
     // Login failures     
        row_index++;
        String lf_warn = sysfn.sys_hlth_fn_warn("Login failures", "MeSC command block status");
        String lf_rem = sysfn.sys_hlth_fn_rem("Login failures", "MeSC command block status");
        
    	Label lflab = new Label(0, row_index, "Login failures", ca_b);
        sheet.addCell(lflab);
        
    	int lf_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Login failures"))
        	{
        		lf_c = configList.indexOf(st);
        	}
        }
        
        if(lf_warn.equals("OK") && lf_rem.equals("OK"))
        {
        	Label lf_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(lf_ok);
        }
        else
        {
        	Label lf_ok;
        	if(configList.get(lf_c).endsWith("[WARNING]"))
        	{
        		lf_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(lf_c).endsWith("[INFO]"))
        	{
        		lf_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(lf_c).endsWith("[CRITICAL]"))
        	{
        		lf_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		lf_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(lf_ok);

    	    double lf_w_h = lf_warn.split(System.getProperty("line.separator")).length;
            double lf_r_h = lf_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = lf_warn.split("\\r?\\n");
            String lines_r[] = lf_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }
        	
        	Label lf_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures lf_cmt = new WritableCellFeatures();
        	lf_cmt.setComment(lf_warn, count_w, lf_w_h);
        	lf_obs.setCellFeatures(lf_cmt);
        	sheet.addCell(lf_obs);

            Label lf_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures lf_rem_cmt = new WritableCellFeatures();
            lf_rem_cmt.setComment(lf_rem, count_r, lf_r_h);
            lf_lab_rem.setCellFeatures(lf_rem_cmt);
            sheet.addCell(lf_lab_rem);
        }

     // MeSC command block status     
        row_index++;
        String mcbs_warn = sysfn.sys_hlth_fn_warn("MeSC command block status", "Memory consumption");
        String mcbs_rem = sysfn.sys_hlth_fn_rem("MeSC command block status", "Memory consumption");
        
    	Label mcbslab = new Label(0, row_index, "MeSC command block status", ca_b);
        sheet.addCell(mcbslab);
        
    	int mcbs_c = 0;
        for(String st : configList)
        {
        	if(st.contains("MeSC command block status"))
        	{
        		mcbs_c = configList.indexOf(st);
        	}
        }
        
        if(mcbs_warn.equals("OK") && mcbs_rem.equals("OK"))
        {
        	Label mcbs_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(mcbs_ok);
        }
        else
        {
        	Label mcbs_ok;
        	if(configList.get(mcbs_c).endsWith("[WARNING]"))
        	{
        		mcbs_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(mcbs_c).endsWith("[INFO]"))
        	{
        		mcbs_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(mcbs_c).endsWith("[CRITICAL]"))
        	{
        		mcbs_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		mcbs_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(mcbs_ok);
        	
    	    double mcbs_w_h = mcbs_warn.split(System.getProperty("line.separator")).length;
            double mcbs_r_h = mcbs_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = mcbs_warn.split("\\r?\\n");
            String lines_r[] = mcbs_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label mcbs_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures mcbs_cmt = new WritableCellFeatures();
        	mcbs_cmt.setComment(mcbs_warn, count_w, mcbs_w_h);
        	mcbs_obs.setCellFeatures(mcbs_cmt);
        	sheet.addCell(mcbs_obs);

            Label mcbs_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures mcbs_rem_cmt = new WritableCellFeatures();
            mcbs_rem_cmt.setComment(mcbs_rem, count_r, mcbs_r_h);
            mcbs_lab_rem.setCellFeatures(mcbs_rem_cmt);
            sheet.addCell(mcbs_lab_rem);
        }

     // Memory consumption     
        row_index++;
        String mc_warn = sysfn.sys_hlth_fn_warn("Memory consumption", "Number of load modules");
        String mc_rem = sysfn.sys_hlth_fn_rem("Memory consumption", "Number of load modules");
        
    	Label mclab = new Label(0, row_index, "Memory consumption", ca_b);
        sheet.addCell(mclab);
        
    	int mc_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Memory consumption"))
        	{
        		mc_c = configList.indexOf(st);
        	}
        }
        
        if(mc_warn.equals("OK") && mc_rem.equals("OK"))
        {
        	Label mc_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(mc_ok);
        }
        else
        {
        	Label mc_ok;
        	if(configList.get(mc_c).endsWith("[WARNING]"))
        	{
        		mc_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(mc_c).endsWith("[INFO]"))
        	{
        		mc_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(mc_c).endsWith("[CRITICAL]"))
        	{
        		mc_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		mc_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(mc_ok);
        	
    	    double mc_w_h = mc_warn.split(System.getProperty("line.separator")).length;
            double mc_r_h = mc_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = mc_warn.split("\\r?\\n");
            String lines_r[] = mc_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label mc_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures mc_cmt = new WritableCellFeatures();
        	mc_cmt.setComment(mc_warn, count_w, mc_w_h);
        	mc_obs.setCellFeatures(mc_cmt);
        	sheet.addCell(mc_obs);

            Label mc_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures mc_rem_cmt = new WritableCellFeatures();
            mc_rem_cmt.setComment(mc_rem, count_r, mc_r_h);
            mc_lab_rem.setCellFeatures(mc_rem_cmt);
            sheet.addCell(mc_lab_rem);
        }

        
     // Number of load modules     
        row_index++;
        String nlb_warn = sysfn.sys_hlth_fn_warn("Number of load modules", "Post Mortem Dumps");
        String nlb_rem = sysfn.sys_hlth_fn_rem("Number of load modules", "Post Mortem Dumps");
        
    	Label nlblab = new Label(0, row_index, "Number of load modules", ca_b);
        sheet.addCell(nlblab);
        
    	int nlb_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Number of load modules"))
        	{
        		nlb_c = configList.indexOf(st);
        	}
        }
        
        if(nlb_warn.equals("OK") && nlb_rem.equals("OK"))
        {
        	Label nlb_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(nlb_ok);
        }
        else
        {
        	Label nlb_ok;
        	if(configList.get(nlb_c).endsWith("[WARNING]"))
        	{
        		nlb_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(nlb_c).endsWith("[INFO]"))
        	{
        		nlb_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(nlb_c).endsWith("[CRITICAL]"))
        	{
        		nlb_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		nlb_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(nlb_ok);
        	
    	    double nlb_w_h = nlb_warn.split(System.getProperty("line.separator")).length;
            double nlb_r_h = nlb_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = nlb_warn.split("\\r?\\n");
            String lines_r[] = nlb_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label nlb_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures nlb_cmt = new WritableCellFeatures();
        	nlb_cmt.setComment(nlb_warn, count_w, nlb_w_h);
        	nlb_obs.setCellFeatures(nlb_cmt);
        	sheet.addCell(nlb_obs);

            Label nlb_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures nlb_rem_cmt = new WritableCellFeatures();
            nlb_rem_cmt.setComment(nlb_rem, count_r, nlb_r_h);
            nlb_lab_rem.setCellFeatures(nlb_rem_cmt);
            sheet.addCell(nlb_lab_rem);
        }
        
     // Post Mortem Dumps     
        row_index++;
        String pmd_warn = sysfn.sys_hlth_fn_warn("Post Mortem Dumps", "Read DSP counters");
        String pmd_rem = sysfn.sys_hlth_fn_rem("Post Mortem Dumps", "Read DSP counters");
        
    	Label pmdlab = new Label(0, row_index, "Post Mortem Dumps", ca_b);
        sheet.addCell(pmdlab);
        
    	int pmd_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Post Mortem Dumps"))
        	{
        		pmd_c = configList.indexOf(st);
        	}
        }
        
        if(pmd_warn.equals("OK") && pmd_rem.equals("OK"))
        {
        	Label pmd_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(pmd_ok);
        }
        else
        {
        	Label pmd_ok;
        	if(configList.get(pmd_c).endsWith("[WARNING]"))
        	{
        		pmd_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(pmd_c).endsWith("[INFO]"))
        	{
        		pmd_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(pmd_c).endsWith("[CRITICAL]"))
        	{
        		pmd_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		pmd_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(pmd_ok);
        	
    	    double pmd_w_h = pmd_warn.split(System.getProperty("line.separator")).length;
            double pmd_r_h = pmd_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = pmd_warn.split("\\r?\\n");
            String lines_r[] = pmd_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label pmd_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures pmd_cmt = new WritableCellFeatures();
        	pmd_cmt.setComment(pmd_warn, count_w, pmd_w_h);
        	pmd_obs.setCellFeatures(pmd_cmt);
        	sheet.addCell(pmd_obs);

            Label pmd_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures pmd_rem_cmt = new WritableCellFeatures();
            pmd_rem_cmt.setComment(pmd_rem, count_r, pmd_r_h);
            pmd_lab_rem.setCellFeatures(pmd_rem_cmt);
            sheet.addCell(pmd_lab_rem);
        }
        
     // Read DSP counters   
        row_index++;
        String dsp_warn = sysfn.sys_hlth_fn_warn("Read DSP counters", "Read temperature of AMC cards");
        String dsp_rem = sysfn.sys_hlth_fn_rem("Read DSP counters", "Read temperature of AMC cards");
        
    	Label dsplab = new Label(0, row_index, "Read DSP counters", ca_b);
        sheet.addCell(dsplab);
        
    	int dsp_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Read DSP counters"))
        	{
        		dsp_c = configList.indexOf(st);
        	}
        }
        
        if(dsp_warn.equals("OK") && dsp_rem.equals("OK"))
        {
        	Label dsp_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(dsp_ok);
        }
        else
        {
        	Label dsp_ok;
        	if(configList.get(dsp_c).endsWith("[WARNING]"))
        	{
        		dsp_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(dsp_c).endsWith("[INFO]"))
        	{
        		dsp_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(dsp_c).endsWith("[CRITICAL]"))
        	{
        		dsp_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		dsp_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(dsp_ok);
        	
    	    double dsp_w_h = dsp_warn.split(System.getProperty("line.separator")).length;
            double dsp_r_h = dsp_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = dsp_warn.split("\\r?\\n");
            String lines_r[] = dsp_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label dsp_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures dsp_cmt = new WritableCellFeatures();
        	dsp_cmt.setComment(dsp_warn, count_w, dsp_w_h);
        	dsp_obs.setCellFeatures(dsp_cmt);
        	sheet.addCell(dsp_obs);

            Label dsp_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures dsp_rem_cmt = new WritableCellFeatures();
            dsp_rem_cmt.setComment(dsp_rem, count_r, dsp_r_h);
            dsp_lab_rem.setCellFeatures(dsp_rem_cmt);
            sheet.addCell(dsp_lab_rem);
        }
        
     // Read temperature of AMC cards     
        row_index++;
        String rt_warn = sysfn.sys_hlth_fn_warn("Read temperature of AMC cards", "Read temperature of carrier boards");
        String rt_rem = sysfn.sys_hlth_fn_rem("Read temperature of AMC cards", "Read temperature of carrier boards");
        
    	Label rtlab = new Label(0, row_index, "Read temperature of AMC cards", ca_b);
        sheet.addCell(rtlab);
        
    	int rt_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Read temperature of AMC cards"))
        	{
        		rt_c = configList.indexOf(st);
        	}
        }
        
        if(rt_warn.equals("OK") && rt_rem.equals("OK"))
        {
        	Label rt_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(rt_ok);
        }
        else
        {
        	Label rt_ok;
        	if(configList.get(rt_c).endsWith("[WARNING]"))
        	{
        		rt_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(rt_c).endsWith("[INFO]"))
        	{
        		rt_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(rt_c).endsWith("[CRITICAL]"))
        	{
        		rt_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		rt_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(rt_ok);
        	
    	    double rt_w_h = rt_warn.split(System.getProperty("line.separator")).length;
            double rt_r_h = rt_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = rt_warn.split("\\r?\\n");
            String lines_r[] = rt_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label rt_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures rt_cmt = new WritableCellFeatures();
        	rt_cmt.setComment(rt_warn, count_w, rt_w_h);
        	rt_obs.setCellFeatures(rt_cmt);
        	sheet.addCell(rt_obs);

            Label rt_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures rt_rem_cmt = new WritableCellFeatures();
            rt_rem_cmt.setComment(rt_rem, count_r, rt_r_h);
            rt_lab_rem.setCellFeatures(rt_rem_cmt);
            sheet.addCell(rt_lab_rem);
        }
        
     // Read temperature of carrier boards     
        row_index++;
        String rtcb_warn = sysfn.sys_hlth_fn_warn("Read temperature of carrier boards", "Replication of announcement files");
        String rtcb_rem = sysfn.sys_hlth_fn_rem("Read temperature of carrier boards", "Replication of announcement files");
        
    	Label rtcblab = new Label(0, row_index, "Read temperature of carrier boards", ca_b);
        sheet.addCell(rtcblab);
        
    	int rtcb_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Read temperature of carrier boards"))
        	{
        		rtcb_c = configList.indexOf(st);
        	}
        }
        
        if(rtcb_warn.equals("OK") && rtcb_rem.equals("OK"))
        {
        	Label rtcb_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(rtcb_ok);
        }
        else
        {
        	Label rtcb_ok;
        	if(configList.get(rtcb_c).endsWith("[WARNING]"))
        	{
        		rtcb_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(rtcb_c).endsWith("[INFO]"))
        	{
        		rtcb_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(rtcb_c).endsWith("[CRITICAL]"))
        	{
        		rtcb_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		rtcb_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(rtcb_ok);
        	
    	    double rtcb_w_h = rtcb_warn.split(System.getProperty("line.separator")).length;
            double rtcb_r_h = rtcb_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = rtcb_warn.split("\\r?\\n");
            String lines_r[] = rtcb_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label rtcb_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures rtcb_cmt = new WritableCellFeatures();
        	rtcb_cmt.setComment(rtcb_warn, count_w, rtcb_w_h);
        	rtcb_obs.setCellFeatures(rtcb_cmt);
        	sheet.addCell(rtcb_obs);

            Label rtcb_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures rtcb_rem_cmt = new WritableCellFeatures();
            rtcb_rem_cmt.setComment(rtcb_rem, count_r, rtcb_r_h);
            rtcb_lab_rem.setCellFeatures(rtcb_rem_cmt);
            sheet.addCell(rtcb_lab_rem);
        }

     // Replication of announcement files     
        row_index++;
        String rep_warn = sysfn.sys_hlth_fn_warn("Replication of announcement files", "Security server connection");
        String rep_rem = sysfn.sys_hlth_fn_rem("Replication of announcement files", "Security server connection");
        
    	Label replab = new Label(0, row_index, "Replication of announcement files", ca_b);
        sheet.addCell(replab);
        
    	int rep_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Replication of announcement files"))
        	{
        		rep_c = configList.indexOf(st);
        	}
        }
        
        if(rep_warn.equals("OK") && rep_rem.equals("OK"))
        {
        	Label rep_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(rep_ok);
        }
        else
        {
        	Label rep_ok;
        	if(configList.get(rep_c).endsWith("[WARNING]"))
        	{
        		rep_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(rep_c).endsWith("[INFO]"))
        	{
        		rep_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(rep_c).endsWith("[CRITICAL]"))
        	{
        		rep_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		rep_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(rep_ok);
        	
    	    double rep_w_h = rep_warn.split(System.getProperty("line.separator")).length;
            double rep_r_h = rep_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = rep_warn.split("\\r?\\n");
            String lines_r[] = rep_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label rep_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures rep_cmt = new WritableCellFeatures();
        	rep_cmt.setComment(rep_warn, count_w, rep_w_h);
        	rep_obs.setCellFeatures(rep_cmt);
        	sheet.addCell(rep_obs);

            Label rep_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures rep_rem_cmt = new WritableCellFeatures();
            rep_rem_cmt.setComment(rep_rem, count_r, rep_r_h);
            rep_lab_rem.setCellFeatures(rep_rem_cmt);
            sheet.addCell(rep_lab_rem);
        }
        
     // Security server connection     
        row_index++;
        String ssc_warn = sysfn.sys_hlth_fn_warn("Security server connection", "Space switching properties");
        String ssc_rem = sysfn.sys_hlth_fn_rem("Security server connection", "Space switching properties");
        
    	Label ssclab = new Label(0, row_index, "Security server connection", ca_b);
        sheet.addCell(ssclab);
        
    	int ssc_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Security server connection"))
        	{
        		ssc_c = configList.indexOf(st);
        	}
        }
        
        if(ssc_warn.equals("OK") && ssc_rem.equals("OK"))
        {
        	Label ssc_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(ssc_ok);
        }
        else
        {
        	Label ssc_ok;
        	if(configList.get(ssc_c).endsWith("[WARNING]"))
        	{
        		ssc_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(ssc_c).endsWith("[INFO]"))
        	{
        		ssc_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(ssc_c).endsWith("[CRITICAL]"))
        	{
        		ssc_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		ssc_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(ssc_ok);
        	
    	    double ssc_w_h = ssc_warn.split(System.getProperty("line.separator")).length;
            double ssc_r_h = ssc_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = ssc_warn.split("\\r?\\n");
            String lines_r[] = ssc_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label ssc_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures ssc_cmt = new WritableCellFeatures();
        	ssc_cmt.setComment(ssc_warn, count_w, ssc_w_h);
        	ssc_obs.setCellFeatures(ssc_cmt);
        	sheet.addCell(ssc_obs);

            Label ssc_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures ssc_rem_cmt = new WritableCellFeatures();
            ssc_rem_cmt.setComment(ssc_rem, count_r, ssc_r_h);
            ssc_lab_rem.setCellFeatures(ssc_rem_cmt);
            sheet.addCell(ssc_lab_rem);
        }
        
     // Space switching properties     
        row_index++;
        String ssp_warn = sysfn.sys_hlth_fn_warn("Space switching properties", "Synchronization status");
        String ssp_rem = sysfn.sys_hlth_fn_rem("Space switching properties", "Synchronization status");
        
    	Label ssplab = new Label(0, row_index, "Space switching properties", ca_b);
        sheet.addCell(ssplab);
        
    	int ssp_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Space switching properties"))
        	{
        		ssp_c = configList.indexOf(st);
        	}
        }
        
        if(ssp_warn.equals("OK") && ssp_rem.equals("OK"))
        {
        	Label ssp_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(ssp_ok);
        }
        else
        {
        	Label ssp_ok;
        	if(configList.get(ssp_c).endsWith("[WARNING]"))
        	{
        		ssp_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(ssp_c).endsWith("[INFO]"))
        	{
        		ssp_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(ssp_c).endsWith("[CRITICAL]"))
        	{
        		ssp_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		ssp_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(ssp_ok);
        	
    	    double ssp_w_h = ssp_warn.split(System.getProperty("line.separator")).length;
            double ssp_r_h = ssp_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = ssp_warn.split("\\r?\\n");
            String lines_r[] = ssp_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label ssp_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures ssp_cmt = new WritableCellFeatures();
        	ssp_cmt.setComment(ssp_warn, count_w, ssp_w_h);
        	ssp_obs.setCellFeatures(ssp_cmt);
        	sheet.addCell(ssp_obs);

            Label ssp_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures ssp_rem_cmt = new WritableCellFeatures();
            ssp_rem_cmt.setComment(ssp_rem, count_r, ssp_r_h);
            ssp_lab_rem.setCellFeatures(ssp_rem_cmt);
            sheet.addCell(ssp_lab_rem);
        }
        
     // Synchronization status     
        row_index++;
        String ss_warn = sysfn.sys_hlth_fn_warn("Synchronization status", "System redundancy");
        String ss_rem = sysfn.sys_hlth_fn_rem("Synchronization status", "System redundancy");
        
    	Label sslab = new Label(0, row_index, "Synchronization status", ca_b);
        sheet.addCell(sslab);
        
    	int ss_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Synchronization status"))
        	{
        		ss_c = configList.indexOf(st);
        	}
        }
        
        if(ss_warn.equals("OK") && ss_rem.equals("OK"))
        {
        	Label ss_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(ss_ok);
        }
        else
        {
        	Label ss_ok;
        	if(configList.get(ss_c).endsWith("[WARNING]"))
        	{
        		ss_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(ss_c).endsWith("[INFO]"))
        	{
        		ss_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(ss_c).endsWith("[CRITICAL]"))
        	{
        		ss_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		ss_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(ss_ok);
        	
    	    double ss_w_h = ss_warn.split(System.getProperty("line.separator")).length;
            double ss_r_h = ss_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = ss_warn.split("\\r?\\n");
            String lines_r[] = ss_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label ss_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures ss_cmt = new WritableCellFeatures();
        	ss_cmt.setComment(ss_warn, count_w, ss_w_h);
        	ss_obs.setCellFeatures(ss_cmt);
        	sheet.addCell(ss_obs);

            Label ss_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures ss_rem_cmt = new WritableCellFeatures();
            ss_rem_cmt.setComment(ss_rem, count_r, ss_r_h);
            ss_lab_rem.setCellFeatures(ss_rem_cmt);
            sheet.addCell(ss_lab_rem);
        }
        
     // System redundancy    
        row_index++;
        String sr_warn = sysfn.sys_hlth_fn_warn("System redundancy", "Upgrade package consistency");
        String sr_rem = sysfn.sys_hlth_fn_rem("System redundancy", "Upgrade package consistency");
        
    	Label srlab = new Label(0, row_index, "System redundancy", ca_b);
        sheet.addCell(srlab);
        
    	int sr_c = 0;
        for(String st : configList)
        {
        	if(st.contains("System redundancy"))
        	{
        		sr_c = configList.indexOf(st);
        	}
        }
        
        if(sr_warn.equals("OK") && sr_rem.equals("OK"))
        {
        	Label sr_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(sr_ok);
        }
        else
        {
        	Label sr_ok;
        	if(configList.get(sr_c).endsWith("[WARNING]"))
        	{
        		sr_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(sr_c).endsWith("[INFO]"))
        	{
        		sr_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(sr_c).endsWith("[CRITICAL]"))
        	{
        		sr_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		sr_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(sr_ok);
        	
    	    double sr_w_h = sr_warn.split(System.getProperty("line.separator")).length;
            double sr_r_h = sr_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = sr_warn.split("\\r?\\n");
            String lines_r[] = sr_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label sr_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures sr_cmt = new WritableCellFeatures();
        	sr_cmt.setComment(sr_warn, count_w, sr_w_h);
        	sr_obs.setCellFeatures(sr_cmt);
        	sheet.addCell(sr_obs);

            Label sr_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures sr_rem_cmt = new WritableCellFeatures();
            sr_rem_cmt.setComment(sr_rem, count_r, sr_r_h);
            sr_lab_rem.setCellFeatures(sr_rem_cmt);
            sheet.addCell(sr_lab_rem);
        }
        
     // Upgrade package consistency     
        row_index++;
        String upc_warn = sysfn.sys_hlth_fn_warn("Upgrade package consistency", "User plane services operation");
        String upc_rem = sysfn.sys_hlth_fn_rem("Upgrade package consistency", "User plane services operation");
        
    	Label upclab = new Label(0, row_index, "Upgrade package consistency", ca_b);
        sheet.addCell(upclab);
        
    	int upc_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Upgrade package consistency"))
        	{
        		upc_c = configList.indexOf(st);
        	}
        }
        
        if(upc_warn.equals("OK") && upc_rem.equals("OK"))
        {
        	Label upc_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(upc_ok);
        }
        else
        {
        	Label upc_ok;
        	if(configList.get(upc_c).endsWith("[WARNING]"))
        	{
        		upc_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(upc_c).endsWith("[INFO]"))
        	{
        		upc_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(upc_c).endsWith("[CRITICAL]"))
        	{
        		upc_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		upc_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(upc_ok);
        	
    	    double upc_w_h = upc_warn.split(System.getProperty("line.separator")).length;
            double upc_r_h = upc_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = upc_warn.split("\\r?\\n");
            String lines_r[] = upc_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label upc_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures upc_cmt = new WritableCellFeatures();
        	upc_cmt.setComment(upc_warn, count_w, upc_w_h);
        	upc_obs.setCellFeatures(upc_cmt);
        	sheet.addCell(upc_obs);

            Label upc_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures upc_rem_cmt = new WritableCellFeatures();
            upc_rem_cmt.setComment(upc_rem, count_r, upc_r_h);
            upc_lab_rem.setCellFeatures(upc_rem_cmt);
            sheet.addCell(upc_lab_rem);
        }
        
     // User plane services operation     
        row_index++;
        String upso_warn = sysfn.sys_hlth_fn_warn("User plane services operation", "VMGw usage");
        String upso_rem = sysfn.sys_hlth_fn_rem("User plane services operation", "VMGw usage");
        
    	Label upsolab = new Label(0, row_index, "User plane services operation", ca_b);
        sheet.addCell(upsolab);
        
    	int upso_c = 0;
        for(String st : configList)
        {
        	if(st.contains("User plane services operation"))
        	{
        		upso_c = configList.indexOf(st);
        	}
        }
        
        if(upso_warn.equals("OK") && upso_rem.equals("OK"))
        {
        	Label upso_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(upso_ok);
        }
        else
        {
        	Label upso_ok;
        	if(configList.get(upso_c).endsWith("[WARNING]"))
        	{
        		upso_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(upso_c).endsWith("[INFO]"))
        	{
        		upso_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(upso_c).endsWith("[CRITICAL]"))
        	{
        		upso_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		upso_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(upso_ok);
        	
    	    double upso_w_h = upso_warn.split(System.getProperty("line.separator")).length;
            double upso_r_h = upso_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = upso_warn.split("\\r?\\n");
            String lines_r[] = upso_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label upso_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures upso_cmt = new WritableCellFeatures();
        	upso_cmt.setComment(upso_warn, count_w, upso_w_h);
        	upso_obs.setCellFeatures(upso_cmt);
        	sheet.addCell(upso_obs);

            Label upso_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures upso_rem_cmt = new WritableCellFeatures();
            upso_rem_cmt.setComment(upso_rem, count_r, upso_r_h);
            upso_lab_rem.setCellFeatures(upso_rem_cmt);
            sheet.addCell(upso_lab_rem);
        }
        
     // VMGw usage     
        row_index++;
        String vu_warn = sysfn.sys_hlth_fn_warn("VMGw usage", "AAL connection setup status");
        String vu_rem = sysfn.sys_hlth_fn_rem("VMGw usage", "AAL connection setup status");
        
    	Label vulab = new Label(0, row_index, "VMGw usage", ca_b);
        sheet.addCell(vulab);
        
    	int vu_c = 0;
        for(String st : configList)
        {
        	if(st.contains("VMGw usage"))
        	{
        		vu_c = configList.indexOf(st);
        	}
        }
        
        if(vu_warn.equals("OK") && vu_rem.equals("OK"))
        {
        	Label vu_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(vu_ok);
        }
        else
        {
        	Label vu_ok;
        	if(configList.get(vu_c).endsWith("[WARNING]"))
        	{
        		vu_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(vu_c).endsWith("[INFO]"))
        	{
        		vu_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(vu_c).endsWith("[CRITICAL]"))
        	{
        		vu_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		vu_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(vu_ok);
        	
    	    double vu_w_h = vu_warn.split(System.getProperty("line.separator")).length;
            double vu_r_h = vu_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = vu_warn.split("\\r?\\n");
            String lines_r[] = vu_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label vu_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures vu_cmt = new WritableCellFeatures();
        	vu_cmt.setComment(vu_warn, count_w, vu_w_h);
        	vu_obs.setCellFeatures(vu_cmt);
        	sheet.addCell(vu_obs);

            Label vu_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures vu_rem_cmt = new WritableCellFeatures();
            vu_rem_cmt.setComment(vu_rem, count_r, vu_r_h);
            vu_lab_rem.setCellFeatures(vu_rem_cmt);
            sheet.addCell(vu_lab_rem);
        }
        
     // AAL connection setup status     
        row_index++;
        String aal_warn = sysfn.sys_hlth_fn_warn("AAL connection setup status", "GCP success rate and error codes");
        String aal_rem = sysfn.sys_hlth_fn_rem("AAL connection setup status", "GCP success rate and error codes");
        
    	Label aallab = new Label(0, row_index, "AAL connection setup status", ca_b);
        sheet.addCell(aallab);
        
    	int aal_c = 0;
        for(String st : configList)
        {
        	if(st.contains("AAL connection setup status"))
        	{
        		aal_c = configList.indexOf(st);
        	}
        }
        
        if(aal_warn.equals("OK") && aal_rem.equals("OK"))
        {
        	Label aal_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(aal_ok);
        }
        else
        {
        	Label aal_ok;
        	if(configList.get(aal_c).endsWith("[WARNING]"))
        	{
        		aal_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(aal_c).endsWith("[INFO]"))
        	{
        		aal_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(aal_c).endsWith("[CRITICAL]"))
        	{
        		aal_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		aal_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(aal_ok);
        	
    	    double aal_w_h = aal_warn.split(System.getProperty("line.separator")).length;
            double aal_r_h = aal_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = aal_warn.split("\\r?\\n");
            String lines_r[] = aal_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label aal_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures aal_cmt = new WritableCellFeatures();
        	aal_cmt.setComment(aal_warn, count_w, aal_w_h);
        	aal_obs.setCellFeatures(aal_cmt);
        	sheet.addCell(aal_obs);

            Label aal_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures aal_rem_cmt = new WritableCellFeatures();
            aal_rem_cmt.setComment(aal_rem, count_r, aal_r_h);
            aal_lab_rem.setCellFeatures(aal_rem_cmt);
            sheet.addCell(aal_lab_rem);
        }
        
     // GCP success rate and error codes     
        row_index++;
        String gcpse_warn = sysfn.sys_hlth_fn_warn("GCP success rate and error codes", "IPBCP connection setup status");
        String gcpse_rem = sysfn.sys_hlth_fn_rem("GCP success rate and error codes", "IPBCP connection setup status");
        
    	Label gcpselab = new Label(0, row_index, "GCP success rate and error codes", ca_b);
        sheet.addCell(gcpselab);
        
    	int gcpse_c = 0;
        for(String st : configList)
        {
        	if(st.contains("GCP success rate and error codes"))
        	{
        		gcpse_c = configList.indexOf(st);
        	}
        }
        
        if(gcpse_warn.equals("OK") && gcpse_rem.equals("OK"))
        {
        	Label gcpse_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(gcpse_ok);
        }
        else
        {
        	Label gcpse_ok;
        	if(configList.get(gcpse_c).endsWith("[WARNING]"))
        	{
        		gcpse_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(gcpse_c).endsWith("[INFO]"))
        	{
        		gcpse_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(gcpse_c).endsWith("[CRITICAL]"))
        	{
        		gcpse_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		gcpse_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(gcpse_ok);
        	
    	    double gcpse_w_h = gcpse_warn.split(System.getProperty("line.separator")).length;
            double gcpse_r_h = gcpse_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = gcpse_warn.split("\\r?\\n");
            String lines_r[] = gcpse_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label gcpse_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures gcpse_cmt = new WritableCellFeatures();
        	gcpse_cmt.setComment(gcpse_warn, count_w, gcpse_w_h);
        	gcpse_obs.setCellFeatures(gcpse_cmt);
        	sheet.addCell(gcpse_obs);

            Label gcpse_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures gcpse_rem_cmt = new WritableCellFeatures();
            gcpse_rem_cmt.setComment(gcpse_rem, count_r, gcpse_r_h);
            gcpse_lab_rem.setCellFeatures(gcpse_rem_cmt);
            sheet.addCell(gcpse_lab_rem);
        }
        
     // IPBCP connection setup status     
        row_index++;
        String ip_warn = sysfn.sys_hlth_fn_warn("IPBCP connection setup status", "Iu and Nb initialization success");
        String ip_rem = sysfn.sys_hlth_fn_rem("IPBCP connection setup status", "Iu and Nb initialization success");
        
    	Label iplab = new Label(0, row_index, "IPBCP connection setup status", ca_b);
        sheet.addCell(iplab);
        
    	int ip_c = 0;
        for(String st : configList)
        {
        	if(st.contains("IPBCP connection setup status"))
        	{
        		ip_c = configList.indexOf(st);
        	}
        }
        
        if(ip_warn.equals("OK") && ip_rem.equals("OK"))
        {
        	Label ip_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(ip_ok);
        }
        else
        {
        	Label ip_ok;
        	if(configList.get(ip_c).endsWith("[WARNING]"))
        	{
        		ip_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(ip_c).endsWith("[INFO]"))
        	{
        		ip_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(ip_c).endsWith("[CRITICAL]"))
        	{
        		ip_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		ip_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(ip_ok);
        	
    	    double ip_w_h = ip_warn.split(System.getProperty("line.separator")).length;
            double ip_r_h = ip_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = ip_warn.split("\\r?\\n");
            String lines_r[] = ip_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label ip_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures ip_cmt = new WritableCellFeatures();
        	ip_cmt.setComment(ip_warn, count_w, ip_w_h);
        	ip_obs.setCellFeatures(ip_cmt);
        	sheet.addCell(ip_obs);

            Label ip_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures ip_rem_cmt = new WritableCellFeatures();
            ip_rem_cmt.setComment(ip_rem, count_r, ip_r_h);
            ip_lab_rem.setCellFeatures(ip_rem_cmt);
            sheet.addCell(ip_lab_rem);
        }
        
     // Iu and Nb initialization success     
        row_index++;
        String iu_warn = sysfn.sys_hlth_fn_warn("Iu and Nb initialization success", "TDM connection setup status");
        String iu_rem = sysfn.sys_hlth_fn_rem("Iu and Nb initialization success", "TDM connection setup status");
        
    	Label iulab = new Label(0, row_index, "Iu and Nb initialization success", ca_b);
        sheet.addCell(iulab);
        
    	int iu_c = 0;
        for(String st : configList)
        {
        	if(st.contains("Iu and Nb initialization success"))
        	{
        		iu_c = configList.indexOf(st);
        	}
        }
        
        if(iu_warn.equals("OK") && iu_rem.equals("OK"))
        {
        	Label iu_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(iu_ok);
        }
        else
        {
        	Label iu_ok;
        	if(configList.get(iu_c).endsWith("[WARNING]"))
        	{
        		iu_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(iu_c).endsWith("[INFO]"))
        	{
        		iu_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(iu_c).endsWith("[CRITICAL]"))
        	{
        		iu_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		iu_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(iu_ok);
        	
    	    double iu_w_h = iu_warn.split(System.getProperty("line.separator")).length;
            double iu_r_h = iu_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = iu_warn.split("\\r?\\n");
            String lines_r[] = iu_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label iu_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures iu_cmt = new WritableCellFeatures();
        	iu_cmt.setComment(iu_warn, count_w, iu_w_h);
        	iu_obs.setCellFeatures(iu_cmt);
        	sheet.addCell(iu_obs);

            Label iu_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures iu_rem_cmt = new WritableCellFeatures();
            iu_rem_cmt.setComment(iu_rem, count_r, iu_r_h);
            iu_lab_rem.setCellFeatures(iu_rem_cmt);
            sheet.addCell(iu_lab_rem);
        }
        
     // TDM connection setup status     
        row_index++;
        String tdm_warn = sysfn.sys_hlth_fn_warn("TDM connection setup status", "User plane devices services pool status");
        String tdm_rem = sysfn.sys_hlth_fn_rem("TDM connection setup status", "User plane devices services pool status");
        
    	Label tdmlab = new Label(0, row_index, "TDM connection setup status", ca_b);
        sheet.addCell(tdmlab);
        
    	int tdm_c = 0;
        for(String st : configList)
        {
        	if(st.contains("TDM connection setup status"))
        	{
        		tdm_c = configList.indexOf(st);
        	}
        }
        
        if(tdm_warn.equals("OK") && tdm_rem.equals("OK"))
        {
        	Label tdm_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(tdm_ok);
        }
        else
        {
        	Label tdm_ok;
        	if(configList.get(tdm_c).endsWith("[WARNING]"))
        	{
        		tdm_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(tdm_c).endsWith("[INFO]"))
        	{
        		tdm_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(tdm_c).endsWith("[CRITICAL]"))
        	{
        		tdm_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		tdm_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(tdm_ok);
        	
    	    double tdm_w_h = tdm_warn.split(System.getProperty("line.separator")).length;
            double tdm_r_h = tdm_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = tdm_warn.split("\\r?\\n");
            String lines_r[] = tdm_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label tdm_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures tdm_cmt = new WritableCellFeatures();
        	tdm_cmt.setComment(tdm_warn, count_w, tdm_w_h);
        	tdm_obs.setCellFeatures(tdm_cmt);
        	sheet.addCell(tdm_obs);

            Label tdm_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures tdm_rem_cmt = new WritableCellFeatures();
            tdm_rem_cmt.setComment(tdm_rem, count_r, tdm_r_h);
            tdm_lab_rem.setCellFeatures(tdm_rem_cmt);
            sheet.addCell(tdm_lab_rem);
        }
        
     // User plane devices services pool status     
        row_index++;
        String usr_warn = sysfn.sys_hlth_fn_warn("User plane devices services pool status", "Summary:");
        String usr_rem = sysfn.sys_hlth_fn_rem("User plane devices services pool status", "Summary:");
        
    	Label usrlab = new Label(0, row_index, "User plane devices services pool status", ca_b);
        sheet.addCell(usrlab);
        
    	int usr_c = 0;
        for(String st : configList)
        {
        	if(st.contains("User plane devices services pool status"))
        	{
        		usr_c = configList.indexOf(st);
        	}
        }
        
        if(usr_warn.equals("OK") && usr_rem.equals("OK"))
        {
        	Label usr_ok = new Label(1, row_index, "OK", green);
        	sheet.addCell(usr_ok);
        }
        else
        {
        	Label usr_ok;
        	if(configList.get(usr_c).endsWith("[WARNING]"))
        	{
        		usr_ok = new Label(1, row_index, "Warning", yellow);
        	}
        	else if(configList.get(usr_c).endsWith("[INFO]"))
        	{
        		usr_ok = new Label(1, row_index, "Info", yellow);
        	}
        	else if(configList.get(usr_c).endsWith("[CRITICAL]"))
        	{
        		usr_ok = new Label(1, row_index, "Critical", yellow);
        	}
        	else
        	{
        		usr_ok = new Label(1, row_index, "Problem", yellow);
        	}
        	sheet.addCell(usr_ok);
        	
    	    double usr_w_h = usr_warn.split(System.getProperty("line.separator")).length;
            double usr_r_h = usr_rem.split(System.getProperty("line.separator")).length;
        	
            String lines_w[] = usr_warn.split("\\r?\\n");
            String lines_r[] = usr_rem.split("\\r?\\n");

			double count_w =0;
            for(String temp:lines_w)
            {
            	if(temp.length()>count_w)
                count_w = temp.length();
            	count_w/=25;
            }
            
            double count_r =0;
            for(String temp:lines_r)
            {
            	if(temp.length()>count_r)
                count_r = temp.length();
            	count_r/=25;
            }

        	Label usr_obs = new Label(2, row_index, "Warning", va_c);
        	WritableCellFeatures usr_cmt = new WritableCellFeatures();
        	usr_cmt.setComment(usr_warn, count_w, usr_w_h);
        	usr_obs.setCellFeatures(usr_cmt);
        	sheet.addCell(usr_obs);

            Label usr_lab_rem = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures usr_rem_cmt = new WritableCellFeatures();
            usr_rem_cmt.setComment(usr_rem, count_r, usr_r_h);
            usr_lab_rem.setCellFeatures(usr_rem_cmt);
            sheet.addCell(usr_lab_rem);
        }
        
//*********
        
        
		/*int asm=0;
        for(String st : configList)
        {
          if(st.contains("Active security mode"))
          {
              asm = configList.indexOf(st);
              break;
          }
        }
        String asm_str = configList.get(asm);

        int asm_end=0;
        for(String st : configList)
        {
          if(st.contains("Board restarts and errors                        ["))
          {
              asm_end= configList.indexOf(st);
              break;
          }
        }
//        String as,_str = configList.get(asm_end);

        if(asm_str.equals("Active security mode                             [OK]"))
        {
            Label asm_label = new Label(1, row_index, "OK", green);
            sheet.addCell(asm_label);
        }
        else
        {
            Label asm_label = new Label(1, row_index, "warning", yellow);
            sheet.addCell(asm_label);

            String asm_start = null;

            ArrayList<String> asm_tmp = new ArrayList<String>();

            for(int i=asm+2; i<=asm_end-4; i++)
            {
                asm_start = configList.get(i);
                asm_tmp.add(asm_start);
                asm_tmp.add("\n"); // warning and remedy
            }

//            int war_ind1=0;
            int rem_asm=0;

            for(String warn : asm_tmp)
            {
            	if(warn.contains("REMEDY:"))
                {
                    rem_asm = asm_tmp.indexOf(warn);
//                  break;
                }
            }

            String asm_str1 = null;
            String asm_tmp1 = "";

            for(String warn : asm_tmp)
            {
                for(int j=0; j<rem_asm; j++) // warning
                {
                    asm_str1 = asm_tmp.get(j);
                    asm_tmp1+=asm_str1;
                }
                break;
            }

            Label asm_lab3 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_asm = new WritableCellFeatures();
            cellFeatures_asm.setComment(asm_tmp1);
            asm_lab3.setCellFeatures(cellFeatures_asm);
            sheet.addCell(asm_lab3);

            String asm_str12 = null;
            String asm_tmp12 = "";

            for(int j=rem_asm; j<=asm_tmp.lastIndexOf("\n"); j++)
            {
                asm_str12 = asm_tmp.get(j); // remedy
                asm_tmp12+=asm_str12 + "\n";
            }

//                System.out.println("remedy " + rem_tmp1);

                Label asm_lab31 = new Label(3, row_index, "Remedy", va_c);
                WritableCellFeatures cellFeatures_asm12 = new WritableCellFeatures();
                cellFeatures_asm12.setComment(asm_tmp12);
                asm_lab31.setCellFeatures(cellFeatures_asm12);
                sheet.addCell(asm_lab31);
        }

        Label asmlab = new Label(0, row_index, "Active security mode", ca_b);
        sheet.addCell(asmlab);
*/       
        
        
        /*row_index++;  
		int bre=0;
        for(String st : configList)
        {
          if(st.contains("Board restarts and errors"))
          {
              bre = configList.indexOf(st);
              break;
          }
        }
        String bre_str = configList.get(bre);

        int bre_end=0;
        for(String st : configList)
        {
          if(st.contains("Board temperature                                ["))
          {
              bre_end= configList.indexOf(st);
              break;
          }
        }
//        String as,_str = configList.get(asm_end);

        if(bre_str.equals("Board restarts and errors                        [OK]"))
        {
            Label bre_label = new Label(1, row_index, "OK", green);
            sheet.addCell(bre_label);
        }
        else
        {
            Label bre_label = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(bre_label);

            String bre_start = null;

            ArrayList<String> bre_tmp = new ArrayList<String>();

            for(int i=bre+2; i<=bre_end-4; i++)
            {
                bre_start = configList.get(i);
                bre_tmp.add(bre_start);
                bre_tmp.add("\n"); // warning and remedy
            }

//            int war_ind1=0;
            int rem_bre=0;

            for(String warn : bre_tmp)
            {
            	if(warn.contains("REMEDY:"))
                {
                    rem_bre = bre_tmp.indexOf(warn);
//                  break;
                }
            }

            String bre_str1 = null;
            String bre_tmp1 = "";

            for(String warn : bre_tmp)
            {
                for(int j=0; j<rem_bre; j++) // warning
                {
                    bre_str1 = bre_tmp.get(j);
                    bre_tmp1+=bre_str1;
                }
                break;
            }


            Label bre_lab3 = new Label(2, row_index, "Warning", va_c);
            WritableCellFeatures cellFeatures_bre = new WritableCellFeatures();
            cellFeatures_bre.setComment(bre_tmp1);
            bre_lab3.setCellFeatures(cellFeatures_bre);
            sheet.addCell(bre_lab3);

            String bre_str12 = null;
            String bre_tmp12 = "";

            for(int j=rem_bre; j<=bre_tmp.lastIndexOf("\n"); j++)
            {
                bre_str12 = bre_tmp.get(j); // remedy
                bre_tmp12+=bre_str12 + "\n";
            }

//                System.out.println("remedy " + rem_tmp1);

            Label bre_lab31 = new Label(3, row_index, "Remedy", va_c);
            WritableCellFeatures cellFeatures_bre12 = new WritableCellFeatures();
            cellFeatures_bre12.setComment(bre_tmp12);
            bre_lab31.setCellFeatures(cellFeatures_bre12);
            sheet.addCell(bre_lab31);
        }

        Label brelab = new Label(0, row_index, "Board restarts and errors", ca_b);
        sheet.addCell(brelab);*/
        
       /* row_index++;  
  		int btp=0;
          for(String st : configList)
          {
            if(st.contains("Board temperature"))
            {
                btp = configList.indexOf(st);
                break;
            }
          }
          String btp_str = configList.get(btp);

          int btp_end=0;
          for(String st : configList)
          {
            if(st.contains("CMXB board spontaneous restarts                  ["))
            {
                btp_end= configList.indexOf(st);
                break;
            }
          }
//          String as,_str = configList.get(btp_end);

          if(btp_str.equals("Board temperature                                [OK]"))
          {
              Label btp_label = new Label(1, row_index, "OK", green);
              sheet.addCell(btp_label);
          }
          else
          {
              Label btp_label = new Label(1, row_index, "Warning", yellow);
              sheet.addCell(btp_label);

              String btp_start = null;

              ArrayList<String> btp_tmp = new ArrayList<String>();

              for(int i=btp+2; i<=btp_end-4; i++)
              {
                  btp_start = configList.get(i);
                  btp_tmp.add(btp_start);
                  btp_tmp.add("\n"); // warning and remedy
              }

//              int war_ind1=0;
              int rem_btp=0;

              for(String warn : btp_tmp)
              {
              	if(warn.contains("REMEDY:"))
                  {
                      rem_btp = btp_tmp.indexOf(warn);
//                    break;
                  }
              }

              String btp_str1 = null;
              String btp_tmp1 = "";

              for(String warn : btp_tmp)
              {
                  for(int j=0; j<rem_btp; j++) // warning
                  {
                      btp_str1 = btp_tmp.get(j);
                      btp_tmp1+=btp_str1;
                  }
                  break;
              }

              Label btp_lab3 = new Label(2, row_index, "Warning", va_c);
              WritableCellFeatures cellFeatures_btp = new WritableCellFeatures();
              cellFeatures_btp.setComment(btp_tmp1);
              btp_lab3.setCellFeatures(cellFeatures_btp);
              sheet.addCell(btp_lab3);

              String btp_str12 = null;
              String btp_tmp12 = "";

              for(int j=rem_btp; j<=btp_tmp.lastIndexOf("\n"); j++)
              {
                  btp_str12 = btp_tmp.get(j); // remedy
                  btp_tmp12+=btp_str12 + "\n";
              }

//                  System.out.println("remedy " + rem_tmp1);

                  Label btp_lab31 = new Label(3, row_index, "Remedy", va_c);
                  WritableCellFeatures cellFeatures_btp12 = new WritableCellFeatures();
                  cellFeatures_btp12.setComment(btp_tmp12);
                  btp_lab31.setCellFeatures(cellFeatures_btp12);
                  sheet.addCell(btp_lab31);
          }

          Label btplab = new Label(0, row_index, "Board Temperature", ca_b);
          sheet.addCell(btplab);
        
        
        //CMXB board spontaneous restarts  
          row_index++;  
  		int cmxbb=0;
          for(String st : configList)
          {
            if(st.contains("CMXB board spontaneous restarts"))
            {
                cmxbb = configList.indexOf(st);
                break;
            }
          }
          String cmxbb_str = configList.get(cmxbb);

          int cmxbb_end=0;
          for(String st : configList)
          {
            if(st.contains("CPU load                                         ["))
            {
                cmxbb_end= configList.indexOf(st);
                break;
            }
          }

          if(cmxbb_str.equals("CMXB board spontaneous restarts                  [OK]"))
          {
              Label cmxbb_label = new Label(1, row_index, "OK", green);
              sheet.addCell(cmxbb_label);
          }
          else
          {
              Label cmxbb_label = new Label(1, row_index, "Warning", yellow);
              sheet.addCell(cmxbb_label);

              String cmxbb_start = null;

              ArrayList<String> cmxbb_tmp = new ArrayList<String>();

              for(int i=cmxbb+2; i<=cmxbb_end-4; i++)
              {
                  cmxbb_start = configList.get(i);
                  cmxbb_tmp.add(cmxbb_start);
                  cmxbb_tmp.add("\n"); // warning and remedy
              }

              int rem_cmxbb=0;

              for(String warn : cmxbb_tmp)
              {
              	if(warn.contains("REMEDY:"))
                  {
                      rem_cmxbb = cmxbb_tmp.indexOf(warn);
//                    break;
                  }
              }

              String cmxbb_str1 = null;
              String cmxbb_tmp1 = "";

              for(String warn : cmxbb_tmp)
              {
                  for(int j=0; j<rem_cmxbb; j++) // warning
                  {
                      cmxbb_str1 = cmxbb_tmp.get(j);
                      cmxbb_tmp1+=cmxbb_str1;
                  }
                  break;
              }

              Label cmxbb_lab3 = new Label(2, row_index, "Warning", va_c);
              WritableCellFeatures cellFeatures_cmxbb = new WritableCellFeatures();
              cellFeatures_cmxbb.setComment(cmxbb_tmp1);
              cmxbb_lab3.setCellFeatures(cellFeatures_cmxbb);
              sheet.addCell(cmxbb_lab3);

              String cmxbb_str12 = null;
              String cmxbb_tmp12 = "";

              for(int j=rem_cmxbb; j<=cmxbb_tmp.lastIndexOf("\n"); j++)
              {
                  cmxbb_str12 = cmxbb_tmp.get(j); // remedy
                  cmxbb_tmp12+=cmxbb_str12 + "\n";
              }

//                  System.out.println("remedy " + rem_tmp1);

                  Label cmxbb_lab31 = new Label(3, row_index, "Remedy", va_c);
                  WritableCellFeatures cellFeatures_cmxbb12 = new WritableCellFeatures();
                  cellFeatures_cmxbb12.setComment(cmxbb_tmp12);
                  cmxbb_lab31.setCellFeatures(cellFeatures_cmxbb12);
                  sheet.addCell(cmxbb_lab31);
          }

          Label cmxbblab = new Label(0, row_index, "CMXB board spontaneous restarts ", ca_b);
          sheet.addCell(cmxbblab);
          
          //CPU load  
          row_index++;  
  		int cpul=0;
          for(String st : configList)
          {
            if(st.contains("CPU load"))
            {
                cpul = configList.indexOf(st);
                break;
            }
          }
          String cpul_str = configList.get(cpul);

          int cpul_end=0;
          for(String st : configList)
          {
            if(st.contains("Capacity threshold alarms                        ["))
            {
                cpul_end= configList.indexOf(st);
                break;
            }
          }
//          String as,_str = configList.get(cpul_end);

          if(cpul_str.equals("CPU load                                         [OK]"))
          {
              Label cpul_label = new Label(1, row_index, "OK", green);
              sheet.addCell(cpul_label);
          }
          else
          {
              Label cpul_label = new Label(1, row_index, "Warning", yellow);
              sheet.addCell(cpul_label);

              String cpul_start = null;

              ArrayList<String> cpul_tmp = new ArrayList<String>();

              for(int i=cpul+2; i<=cpul_end-4; i++)
              {
                  cpul_start = configList.get(i);
                  cpul_tmp.add(cpul_start);
                  cpul_tmp.add("\n"); // warning and remedy
              }

//              int war_ind1=0;
              int rem_cpul=0;

              for(String warn : cpul_tmp)
              {
              	if(warn.contains("REMEDY:"))
                  {
                      rem_cpul = cpul_tmp.indexOf(warn);
//                    break;
                  }
              }

              String cpul_str1 = null;
              String cpul_tmp1 = "";

              for(String warn : cpul_tmp)
              {
                  for(int j=0; j<rem_cpul; j++) // warning
                  {
                      cpul_str1 = cpul_tmp.get(j);
                      cpul_tmp1+=cpul_str1;
                  }
                  break;
              }

              Label cpul_lab3 = new Label(2, row_index, "Warning", va_c);
              WritableCellFeatures cellFeatures_cpul = new WritableCellFeatures();
              cellFeatures_cpul.setComment(cpul_tmp1);
              cpul_lab3.setCellFeatures(cellFeatures_cpul);
              sheet.addCell(cpul_lab3);

              String cpul_str12 = null;
              String cpul_tmp12 = "";

              for(int j=rem_cpul; j<=cpul_tmp.lastIndexOf("\n"); j++)
              {
                  cpul_str12 = cpul_tmp.get(j); // remedy
                  cpul_tmp12+=cpul_str12 + "\n";
              }

//                  System.out.println("remedy " + rem_tmp1);

                  Label cpul_lab31 = new Label(3, row_index, "Remedy", va_c);
                  WritableCellFeatures cellFeatures_cpul12 = new WritableCellFeatures();
                  cellFeatures_cpul12.setComment(cpul_tmp12);
                  cpul_lab31.setCellFeatures(cellFeatures_cpul12);
                  sheet.addCell(cpul_lab31);
          }

          Label cpullab = new Label(0, row_index, "CPU Load ", ca_b);
          sheet.addCell(cpullab);
          
          
          //Capacity threshold alarms
          row_index++;  
  		int cthal=0;
          for(String st : configList)
          {
            if(st.contains("Capacity threshold alarms"))
            {
                cthal = configList.indexOf(st);
                break;
            }
          }
          String cthal_str = configList.get(cthal);

          int cthal_end=0;
          for(String st : configList)
          {
            if(st.contains("Disk status                                      ["))
            {
                cthal_end= configList.indexOf(st);
                break;
            }
          }
//          String as,_str = configList.get(cthal_end);

          if(cthal_str.equals("Capacity threshold alarms                        [OK]"))
          {
              Label cthal_label = new Label(1, row_index, "OK", green);
              sheet.addCell(cthal_label);
          }
          else
          {
              Label cthal_label = new Label(1, row_index, "Warning", yellow);
              sheet.addCell(cthal_label);

              String cthal_start = null;

              ArrayList<String> cthal_tmp = new ArrayList<String>();

              for(int i=cthal+2; i<=cthal_end-4; i++)
              {
                  cthal_start = configList.get(i);
                  cthal_tmp.add(cthal_start);
                  cthal_tmp.add("\n"); // warning and remedy
              }

//              int war_ind1=0;
              int rem_cthal=0;

              for(String warn : cthal_tmp)
              {
              	if(warn.contains("REMEDY:"))
                  {
                      rem_cthal = cthal_tmp.indexOf(warn);
//                    break;
                  }
              }

              String cthal_str1 = null;
              String cthal_tmp1 = "";

              for(String warn : cthal_tmp)
              {
                  for(int j=0; j<rem_cthal; j++) // warning
                  {
                      cthal_str1 = cthal_tmp.get(j);
                      cthal_tmp1+=cthal_str1;
                  }
                  break;
              }

              Label cthal_lab3 = new Label(2, row_index, "Warning", va_c);
              WritableCellFeatures cellFeatures_cthal = new WritableCellFeatures();
              cellFeatures_cthal.setComment(cthal_tmp1);
              cthal_lab3.setCellFeatures(cellFeatures_cthal);
              sheet.addCell(cthal_lab3);

              String cthal_str12 = null;
              String cthal_tmp12 = "";

              for(int j=rem_cthal; j<=cthal_tmp.lastIndexOf("\n"); j++)
              {
                  cthal_str12 = cthal_tmp.get(j); // remedy
                  cthal_tmp12+=cthal_str12 + "\n";
              }

//                  System.out.println("remedy " + rem_tmp1);

                  Label cthal_lab31 = new Label(3, row_index, "Remedy", va_c);
                  WritableCellFeatures cellFeatures_cthal12 = new WritableCellFeatures();
                  cellFeatures_cthal12.setComment(cthal_tmp12);
                  cthal_lab31.setCellFeatures(cellFeatures_cthal12);
                  sheet.addCell(cthal_lab31);
          }

          Label cthallab = new Label(0, row_index, "Capacity threshold alarms", ca_b);
          sheet.addCell(cthallab);
          
        //Disk status Corrected  
          row_index++;  
  		int disk_st=0;
          for(String st : configList)
          {
            if(st.contains("Disk status"))
            {
                disk_st = configList.indexOf(st);
                break;
            }
          }
          String disk_st_str = configList.get(disk_st);

          int disk_st_end=0;
          for(String st : configList)
          {
            if(st.contains("Disk usage                                       ["))
            {
                disk_st_end= configList.indexOf(st);
                break;
            }
          }
//          String as,_str = configList.get(disk_st_end);

          if(disk_st_str.equals("Disk usage                                      [OK]"))
          {
              Label disk_st_label = new Label(1, row_index, "OK", green);
              sheet.addCell(disk_st_label);
          }
          else
          {
              Label disk_st_label = new Label(1, row_index, "Warning", yellow);
              sheet.addCell(disk_st_label);

              String disk_st_start = null;

              ArrayList<String> disk_st_tmp = new ArrayList<String>();

              for(int i=disk_st+2; i<=disk_st_end-4; i++)
              {
                  disk_st_start = configList.get(i);
                  disk_st_tmp.add(disk_st_start);
                  disk_st_tmp.add("\n"); // warning and remedy
              }

//              int war_ind1=0;
              int rem_disk_st=0;

              for(String warn : disk_st_tmp)
              {
              	if(warn.contains("REMEDY:"))
                  {
                      rem_disk_st = disk_st_tmp.indexOf(warn);
//                    break;
                  }
              }

              String disk_st_str1 = null;
              String disk_st_tmp1 = "";

              for(String warn : disk_st_tmp)
              {
                  for(int j=0; j<rem_disk_st; j++) // warning
                  {
                      disk_st_str1 = disk_st_tmp.get(j);
                      disk_st_tmp1+=disk_st_str1;
                  }
                  break;
              }

              Label disk_st_lab3 = new Label(2, row_index, "Warning", va_c);
              WritableCellFeatures cellFeatures_disk_st = new WritableCellFeatures();
              cellFeatures_disk_st.setComment(disk_st_tmp1);
              disk_st_lab3.setCellFeatures(cellFeatures_disk_st);
              sheet.addCell(disk_st_lab3);

              String disk_st_str12 = null;
              String disk_st_tmp12 = "";

              for(int j=rem_disk_st; j<=disk_st_tmp.lastIndexOf("\n"); j++)
              {
                  disk_st_str12 = disk_st_tmp.get(j); // remedy
                  disk_st_tmp12+=disk_st_str12 + "\n";
              }

//                  System.out.println("remedy " + rem_tmp1);

                  Label disk_st_lab31 = new Label(3, row_index, "Remedy", va_c);
                  WritableCellFeatures cellFeatures_disk_st12 = new WritableCellFeatures();
                  cellFeatures_disk_st12.setComment(disk_st_tmp12);
                  disk_st_lab31.setCellFeatures(cellFeatures_disk_st12);
                  sheet.addCell(disk_st_lab31);
          }

          Label disk_stlab = new Label(0, row_index, "Disk status", ca_b);
          sheet.addCell(disk_stlab);
          
    // Disk Usage
          
          row_index++;  
    		int disku=0;
            for(String st : configList)
            {
              if(st.contains("Disk usage"))
              {
                  disku = configList.indexOf(st);
                  break;
              }
            }
            String disku_str = configList.get(disku);

            int disku_end=0;
            for(String st : configList)
            {
              if(st.contains("Drive mirroring status                           ["))
              {
                  disku_end= configList.indexOf(st);
                  break;
              }
            }
//            String as,_str = configList.get(disku_end);

            if(disku_str.equals("Disk usage                                      [OK]"))
            {
                Label disku_label = new Label(1, row_index, "OK", green);
                sheet.addCell(disku_label);
            }
            else
            {
                Label disku_label = new Label(1, row_index, "Warning", yellow);
                sheet.addCell(disku_label);

                String disku_start = null;

                ArrayList<String> disku_tmp = new ArrayList<String>();

                for(int i=disku+2; i<=disku_end-4; i++)
                {
                    disku_start = configList.get(i);
                    disku_tmp.add(disku_start);
                    disku_tmp.add("\n"); // warning and remedy
                }

//                int war_ind1=0;
                int rem_disku=0;

                for(String warn : disku_tmp)
                {
                	if(warn.contains("REMEDY:"))
                    {
                        rem_disku = disku_tmp.indexOf(warn);
//                      break;
                    }
                }

                String disku_str1 = null;
                String disku_tmp1 = "";

                for(String warn : disku_tmp)
                {
                    for(int j=0; j<rem_disku; j++) // warning
                    {
                        disku_str1 = disku_tmp.get(j);
                        disku_tmp1+=disku_str1;
                    }
                    break;
                }

                Label disku_lab3 = new Label(2, row_index, "Warning", va_c);
                WritableCellFeatures cellFeatures_disku = new WritableCellFeatures();
                cellFeatures_disku.setComment(disku_tmp1);
                disku_lab3.setCellFeatures(cellFeatures_disku);
                sheet.addCell(disku_lab3);

                String disku_str12 = null;
                String disku_tmp12 = "";

                for(int j=rem_disku; j<=disku_tmp.lastIndexOf("\n"); j++)
                {
                    disku_str12 = disku_tmp.get(j); // remedy
                    disku_tmp12+=disku_str12 + "\n";
                }

//                    System.out.println("remedy " + rem_tmp1);

                    Label disku_lab31 = new Label(3, row_index, "Remedy", va_c);
                    WritableCellFeatures cellFeatures_disku12 = new WritableCellFeatures();
                    cellFeatures_disku12.setComment(disku_tmp12);
                    disku_lab31.setCellFeatures(cellFeatures_disku12);
                    sheet.addCell(disku_lab31);
            }

            Label diskulab = new Label(0, row_index, "Disk usage", ca_b);
            sheet.addCell(diskulab);
          */
                  
//=============       
        
//=======        
    // signaling loop        
        
    /*    row_index++;
        int sig_loop=0;
        for(String st : configList)
	    {
        	if(st.contains("Signalling loop                                  ["))
        	{
        		sig_loop = configList.indexOf(st);
        		break;
        	}
	    }
        String sig_loop_str = configList.get(sig_loop);
        
        if(sig_loop_str.equals("Signalling loop                                  [OK]"))
        {
        	Label sig_loop_lab = new Label(1, row_index, "OK", green);
        	sheet.addCell(sig_loop_lab);
        }
        else
        {
        	Label sig_loop_lab = new Label(1, row_index, "Warning", yellow);
        	sheet.addCell(sig_loop_lab);
        	
        	Label sig_loop_lab1 = new Label(2, row_index, sig_loop_str, va_c);
        	sheet.addCell(sig_loop_lab1);
        }
        Label l19 = new Label(0, row_index, "Signalling loop", ca_b);
        sheet.addCell(l19);*/
        
//===========        
       
      //not complete  
        
     // Unlocked and disabled MOs
    
    /* 	int mos=0;
        for(String st : configList)
	    {
	      if(st.contains("Unlocked and disabled MOs                        ["))
	      {
	    	  mos = configList.indexOf(st);
	    	  break;
	      }
	    }
        
        if(configList.get(mos).equals("Unlocked and disabled MOs                        [OK]"))
        {
        	Label mos_lab = new Label(1, 33, "OK", green);
        	sheet.addCell(mos_lab);
        }
        else
        {
        	Label mos_lab = new Label(1, 33, "Warning", yellow);
        	sheet.addCell(mos_lab);
        	
        	String mos_err = "There are unlocked and disabled MOs" + "\n" + "(please check the comment for detailed informations)";
        	
        	Label mos_err_lab = new Label(2, 33, mos_err);
        	sheet.addCell(mos_err_lab);
        	
        	int mos_end=0;
            for(String st : configList)
    	    {
    	      if(st.contains("Value recommendations                            ["))
    	      {
    	    	  mos_end = configList.indexOf(st);
    	    	  break;
    	      }
    	    }
            for(int i=mos; i<mos_end; i++)
            {
            }
        }
     */
//        Label l4 = new Label(0, row_index++, "Auto CV Creation check", ca_b);
//        sheet.addCell(l4);
     // alarm

        /*int as=0, ae=0;

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
        if(alarme.contains("> ala"))
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
        System.out.println("nu is " + nu);
        alrmval.add(nu); // alarms present
        }

        Workbook workbook1 = Workbook.getWorkbook(new File("MGW Alarm Details.xls"));
        Sheet sheet1 = workbook1.getSheet(0);

        Cell c[] = sheet1.getColumn(0); // getting column 1
        List<String> cell = new ArrayList<String>();

        for(int i=0; i<c.length; i++)
        {
        if(!c[i].getContents().trim().equals(""))
        {
        cell.add(c[i].getContents().trim()); // values in column 1
        }
        }

        ArrayList<String> e1 = new ArrayList<String>();
        ArrayList<String> e2 = new ArrayList<String>();

        for(String logalarm:alrmval)
        {
        String a[] = logalarm.split("\\s");
        ArrayList<String> t = new ArrayList<String>();

        for(String temp:a)
        {
        if(!temp.trim().equals(""))
        {
        t.add(temp);
        }
        }

        boolean c1 = true;
        int index = -1;

        for(int k=0;k<cell.size();k++)
        {
        a = cell.get(k).split("\\s"); // getting values from col1
        ArrayList<String> t1 = new ArrayList<String>();

        for(String temp:a)
        {
        if(!temp.trim().equals(""))
        {
        t1.add(temp);
        }
        }

        if(check(t,t1)) // checking if alarms are present in col1
        {
        c1 = true;
        index = k+1;
        break;
        }
        else
        {
        c1=false;
        }
        }

        if(c1)
        {
        Cell temp = sheet1.getCell(3, index-1); // getting solution column
        String info = temp.getContents();
        temp = sheet1.getCell(0, index-1);
        String name = temp.getContents();
        e1.add(name);
        e2.add(info);
        }
        else
        {
        // System.out.println("Not found");
        }
        }
        WritableCellFormat cf = new WritableCellFormat();
        cf.setWrap(true);

        for(int i=0; i<e1.size(); i++)
        {
        String name = e1.get(i); // name
        String sol = e2.get(i); // solution

        Label label_1 = new Label(1, 9+i, "Warning", yellow);
        sheet.addCell(label_1);

        label = new Label(2, 9+i, name, va_c);
        sheet.addCell(label);

        label = new Label(3, 9+i, sol, va_c);
        sheet.addCell(label);
        }

        sheet.mergeCells(0, 9, 0, 9+e1.size());

        row_index = row_index + e1.size();     */
        
//----        
  // clock        
        
        row_index++;
        Label l7 = new Label(0, row_index, "Clock", ca_b);
        sheet.addCell(l7);
        
        int clk=0;
        for(String st : configList)
	    {
	      if(st.contains("get synch"))
	      {
	    	  clk = configList.indexOf(st)+8;
	    	  break;
	      }
	    }
        
        if(configList.get(clk).endsWith("(LOCKED_MODE)"))
        {
        	Label lck_ok = new Label(1, row_index, "OK", green);
            sheet.addCell(lck_ok);
        }
        else
        {
        	String lck_err = configList.get(clk+8);
        	Label lck_ok = new Label(1, row_index, "Warning", yellow);
            sheet.addCell(lck_ok);
            
            double lck_err_h = lck_err.split(System.getProperty("line.separator")).length;

            Label lck_obs = new Label(2, row_index, "", va_c);
            WritableCellFeatures cellFeatures_lckc = new WritableCellFeatures();
            cellFeatures_lckc.setComment(lck_err, 2, lck_err_h);
            lck_obs.setCellFeatures(cellFeatures_lckc);
            sheet.addCell(lck_obs);
        }
        
//----- sys health
        
        workbook.write();
        workbook.close();
	  }
	   	
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  
  public static boolean check(ArrayList<String> t, ArrayList<String> t1)
  {
	  for(int i=0;i<t1.size();i++)
	  {
		  if(t.get(i).equals(t1.get(i)))
		  {
			  continue;
		  }
		  else
		  {
			  return false;
		  }	
	  }
	  return true;
  }
  
//  static ArrayList<String> configList = getFileContentList("LOGS_7th_Feb.txt");
  /*public static String sys_hlth_fn(String start, String end)
  {
	  int asm=0;
      for(String st : configList)
      {
        if(st.contains(start))
        {
            asm = configList.indexOf(st);
            break;
        }
      }
      String asm_str = configList.get(asm);

      int asm_end=0;
      for(String st : configList)
      {
        if(st.contains(end))
        {
            asm_end= configList.indexOf(st);
            break;
        }
      }

      if(asm_str.startsWith("Active security mode") && asm_str.endsWith("[OK]"))
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

          int rem_asm=0;

          for(String warn : asm_tmp)
          {
          	if(warn.contains("REMEDY:"))
              {
                  rem_asm = asm_tmp.indexOf(warn);
              }
          }

          String asm_str1 = null;
          String asm_tmp1 = "";

          for(String warn : asm_tmp)
          {
              for(int j=0; j<rem_asm; j++) // warning
              {
                  asm_str1 = asm_tmp.get(j);
                  asm_tmp1+=asm_str1;
              }
              break;
          }
          
          String asm_str12 = null;
          String asm_tmp12 = "";

          for(int j=rem_asm; j<=asm_tmp.lastIndexOf("\n"); j++)
          {
              asm_str12 = asm_tmp.get(j); // remedy
              asm_tmp12+=asm_str12 + "\n";
          }

          return asm_tmp1; // warning
      }
      
  }
*/  
}
