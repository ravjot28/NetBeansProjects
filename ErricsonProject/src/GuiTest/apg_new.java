package GuiTest;

import java.io.BufferedReader;
//import java.io.DataInputStream;
//import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.util.StringTokenizer;
import java.io.File;
import java.util.Calendar;

import jxl.*;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.*;

public class apg_new
{
    String fileName = "";
    String fileName1 = "";
    
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
       /*if(isIgnore(line))
       {
         continue; //ignoring blank lines and lines starting with #
       }*/
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
   for(int i=0; i<data.length();i++)
   {
     if(!Character.isWhitespace(data.charAt(i)))
     {
       return false;
     }
   }
   return true;
 }

/* private static boolean isIgnore(String data)
 {
   return (data.startsWith("#") );
 }*/

 public void processSteps(String fname,String fname1) throws ParseException
 {
     this.fileName = fname;
     this.fileName1 = fname1;
     
       try 
       {
//     	   ArrayList<String> configList = getFileContentList("MSS_mine.log");
//         ArrayList<String> aptfile    = getFileContentList("apt_test.log");
    	   
    	   ArrayList<String> apgfile    = getFileContentList("apg.log");
           ArrayList<String> alanfile	= getFileContentList("Alan2.log");
           
           WritableWorkbook workbook = Workbook.createWorkbook(new File("PRS Report"+".xls"));  //new File("C:\\Rav\\abc\\t.xls")
           WritableSheet sheet = workbook.createSheet("Sheet 1", 0);
           sheet.setColumnView(0, 45);
           sheet.setColumnView(2, 40);
           sheet.setColumnView(3, 30);
           sheet.setColumnView(4, 35);
           sheet.setColumnView(5, 30);
           sheet.setColumnView(6, 30);
           sheet.setColumnView(7, 30);
           
           sheet.mergeCells(0, 0, 8, 0);
           sheet.mergeCells(1, 1, 8, 1);
           sheet.mergeCells(0, 2, 8, 2);
           
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
           color_l_blue.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
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
           
           WritableCellFormat na = new WritableCellFormat();
           na.setAlignment(jxl.format.Alignment.CENTRE);
           na.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE); 
           na.setFont(bold_g);
           na.setWrap(true);

           int apg_last=0;
           int apz_ver_val_0 = 0, apz_ver_val_1 = 0;
           for (String st : apgfile) 
           {
        	   if(st.contains(">"))
        	   {
        		   apg_last = apgfile.lastIndexOf(st);
        	   }
               if (st.contains("APZ TYPE")) 
               {
                   apz_ver_val_0 = apgfile.indexOf(st);
                   break;
               }
           }
           apz_ver_val_1 = apz_ver_val_0 + 1;

// for hwver
           
           int apg_ver=0;
           String hwver=null;
           for (String st : apgfile) 
           {
               if (st.contains("hwver")) 
               {
                   apg_ver = apgfile.indexOf(st);
                   break;
               }
           }
           
           for(int i=apg_ver+1; i<apg_last; i++)
           {
        	   if(apgfile.get(i).contains(">"))
        	   {
        		   break;
        	   }
        	   else if(apgfile.get(i).startsWith("APG"))
        	   {
        		   hwver = apgfile.get(i);
        	   }
           }

// for node name

           int ioexp=0;
           for (String st : apgfile) 
           {
               if (st.contains("<ioexp;")) 
               {
                   ioexp = apgfile.indexOf(st)+1;
                   break;
               }
           }

           String node_name=null;
           for(int i=ioexp; i<apg_last; i++)
           {
        	   if(apgfile.get(i).startsWith("END") && apgfile.get(i).equals("END"))
        	   {
        		   break;
        	   }
        	   else if(apgfile.get(i).trim().startsWith("EXCHANGE IDENTITY DATA") ||
        			   apgfile.get(i).trim().startsWith("IDENTITY") ||
        			   apgfile.get(i).trim().equals(""))
        	   {
        		   continue;
        	   }
        	   else
        	   {
        		   node_name = apgfile.get(i);
        	   }
           }
           
// prcstate
           
           int prc=0, prc_state=0, clus_node=0;
//           int prc_l=0;
           
           for (String st : apgfile) 
           {
               if (st.contains(">prcstate -l") || st.contains(">Prcstate -l") || st.contains(">PRCSTATE -L")) 
               {
            	   prc = apgfile.indexOf(st);
            	   prc_state = prc - 2; // active or passive		
                   break;
               }
           }
           
// cluster node
           
           for (String st : apgfile) 
           {
               if (st.contains(">cluster node") || st.contains(">Cluster node") 
            		   || st.contains(">cluster Node") || st.contains(">Cluster Node")
            		   || st.contains(">CLUSTER NODE"))
               {
            	   clus_node = apgfile.indexOf(st);
                   break;
               }
           }
           
           for(int i=clus_node; i<apg_last; i++)
           {
        	   
           }
           
           
           
           if( (apgfile.get(prc_state).equals("active") || apgfile.get(prc_state).equals("passive")) 
        	   && ( apgfile.get(prc+1).endsWith("up and working") && apgfile.get(prc+2).endsWith("up and working"))
        	   && (apgfile.get(clus_node+5).endsWith("Up") && apgfile.get(clus_node+6).endsWith("Up")) )
           {
        	   Label apg_status = new Label(1, 4, "OK", green);
        	   sheet.addCell(apg_status);
           }
           else
           {
        	   Label apg_status = new Label(1, 4, "Warning", yellow);
        	   sheet.addCell(apg_status);
        	   
        	   Label apg_status_act = new Label(4, 4, "Follow OPI: AP NOT REDUNDANT");
        	   sheet.addCell(apg_status_act);
        	   
        	   String apg_state = null;
        	   String apg_tmp   = "";
        	   
        	   for(int i=prc_state-1; i<=clus_node+6; i++)
        	   {
        		   apg_state = apgfile.get(i);
        		   apg_tmp+=apg_state;
        	   }

        	   double apg_tmp_h = apg_tmp.split(System.getProperty("line.separator")).length;
        	   
        	   Label apg_status_obs = new Label(2, 4, "");
        	   WritableCellFeatures apg_comm = new WritableCellFeatures();
        	   apg_comm.setComment(apg_tmp, 2, apg_tmp_h);
        	   apg_status_obs.setCellFeatures(apg_comm);
        	   sheet.addCell(apg_status_obs);
           }
           
//---
           String apz_ver = apgfile.get(apz_ver_val_0).substring(34, 37) + apgfile.get(apz_ver_val_1).substring(35, 37);

           Label prs = new Label(0, 0, "Proactive Support (PRS) Report");
           Label label = new Label(0, 1, "NODE", node);  
     	   Label label1 = new Label(1, 1, node_name + "     APZ: " + apz_ver + "    HARDWARE: " + hwver);
     	   Label label2 = new Label(0, 3, "Check Name", color_blue);
     	   Label label3 = new Label(1, 3, "Status", color_blue);
     	   Label label4 = new Label(2, 3, "Observation", color_blue);
     	   Label label5 = new Label(3, 3, "Node/Network Impact", color_blue);
     	   Label label6 = new Label(4, 3, "Action Recommended", color_blue);
     	   Label label7 = new Label(5, 3, "Severity", color_blue);
     	   Label label8 = new Label(6, 3, "First Reported", color_blue);
     	   Label label9 = new Label(7, 3, "Recipient Update", color_blue);
     	  
     	   Label label10 = new Label(0, 4, "APG status (active/passive)", ca_b);
     	   Label label11 = new Label(0, 5, "APG software level check", ca_b);
     	   Label clus_res_lab = new Label(0, 6, "Check APG cluster resources", ca_b);
     	   Label label12 = new Label(0, 7, "Check APG RAID", ca_b);
     	   Label apg_vol_lab = new Label(0, 8, "Check APG Volumes (name, attributes, and size)", ca_b);
     	   Label label13 = new Label(0, 9, "Check Number of MML Sessions opened", ca_b);
     	   Label chk_sys_dsk = new Label(0, 10, "Check System Disk", ca_b);
     	   Label chk_data_dsk = new Label(0, 11, "Check Data Disk", ca_b);
     	   Label up_time_l = new Label(0, 12, "Check the Uptime", ca_b);
     	   Label sts_l = new Label(0, 13, "STS functionality check", ca_b);
     	   Label rep_l = new Label(0, 14, "File Replication check", ca_b);
     	   Label adc_l = new Label(0, 15, "Active Directory check", ca_b);
     	   Label bkc_l = new Label(0, 16, "Check the date of the latest backup", ca_b);
     	   Label bsz_l = new Label(0, 17, "Check the size of backups \n(in GB)", ca_b);

     	   int row_index = 17;
     	   
     	   sheet.addCell(prs);
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
           sheet.addCell(clus_res_lab);
           sheet.addCell(apg_vol_lab);
           sheet.addCell(chk_sys_dsk);
           sheet.addCell(chk_data_dsk);
           sheet.addCell(up_time_l);
           sheet.addCell(sts_l);
           sheet.addCell(rep_l);
           sheet.addCell(adc_l);
           sheet.addCell(bkc_l);
           sheet.addCell(bsz_l);
           
           int swr_ver=0;
           for (String st : apgfile) 
           {
               if (st.contains("AP SOFTWARE CHARACTERISTICS")) 
               {
                   swr_ver = apgfile.indexOf(st);
                   swr_ver = swr_ver+2;
                   break;
               }
           }
           String sw_lev[] = apgfile.get(swr_ver).split(" ");

           if(sw_lev[6].equals("AGM021"))
           {
        	   Label sw_ver_ok = new Label(1, 5, "OK", green);
       	       sheet.addCell(sw_ver_ok);
           }
           else
           {
        	   Label sw_ver_ok = new Label(1, 5, "Warning", yellow);
       	       sheet.addCell(sw_ver_ok);  
           }
           
           Label sw_ver_lab = new Label(2, 5, sw_lev[6], va_c);
   	       sheet.addCell(sw_ver_lab);
   	       
// cluster res
   	       
   	       int clus_cmd=0, clus_start=0;
	    
   	       for(String st : apgfile)
   	       {
   	    	   if(st.contains("CLUSTER RES") || st.contains("cluster res"))
   	    	   {
   	    		   clus_cmd = apgfile.indexOf(st);
   	    		   clus_start = clus_cmd + 5;
   	    		   break;
   	    	   }
   	       }
   	       
   	       String header_clus_res = apgfile.get(clus_cmd+3) + "\n" + apgfile.get(clus_cmd+4) + "\n"; 
  	    
   	       int clus_end=0;
   	       
   	       for(String st : apgfile)
   	       {
   	    	   if(st.contains(">cluster res |findstr -ive online"))
   	    	   {
   	    		   clus_end = apgfile.indexOf(st);
//   	    		   clus_end = clus_end-2;
   	    		   break;
   	    	   }
   	       }
  	    
  	  	  String clus_str = null;
  	  	  String clus_tmp = "";
  	    
  	  	  for(int i=clus_start; i<clus_end; i++)
  	  	  {
  	  		  clus_str = apgfile.get(i);

  	  		  if(! (clus_str.startsWith("C:") || clus_str.startsWith("c:")) && clus_str.contains(">"))
  	  		  {
  	  			  if( (!clus_str.startsWith(" ")) && clus_str.endsWith("Online"))
	  	  		  {
	  	  			  Label clus_lab = new Label(1, 6, "OK", green);
	  	  			  sheet.addCell(clus_lab);
	  	  		  }
	  	  		  else
	  	  		  {
	  	  			  {
	  	  			  Label clus_lab = new Label(1, 6, "Warning", yellow);
	  	  			  sheet.addCell(clus_lab);
	  	  			  
	  	  			  Label clus_act = new Label(4, 6, "Follow OPI : AP PROCESS STOPPED", va_c);
		  			  sheet.addCell(clus_act);
	  	    		
	  	  			  clus_tmp+=clus_str+"\n";
	  	  			  }
  	  			  
	  	  			  double clus_tmp_h = clus_tmp.split(System.getProperty("line.separator")).length;
  	  			
	  	  			  Label clus_obs = new Label(2, 6, "Not all resources are Online", va_c);
		  	  		  WritableCellFeatures clus_res = new WritableCellFeatures();
		    	  	  clus_res.setComment(header_clus_res + clus_tmp, 2, clus_tmp_h);
		    	  	  clus_obs.setCellFeatures(clus_res);
		    	  	  sheet.addCell(clus_obs);
	  	  		  }
  	  		  }
  	  		  else
  	  		  {
  	  			  break;
  	  		  }
  	  	  }
  	    
//  raids of APG40C/4

  	  	  int raid40c2=0, raid40c2_e=0;
  	  	  String apg40c2_prob = null, apg40c2_tmp="", apg40c2_miss="";
  	  	  
  	  	  int raid0_chk=0, raid0=0, raid1=0, raid2=0, raid_end=0; // for APG40C/4
  	  	  
  	  	  int raid43_chk=0;
  	  	  String raid43_prob=null, raid43_tmp="";
  	  	  
  	  	  if(hwver.equals("APG40C/4"))
  	  	  {
  	  		  for(String st : apgfile)
  	  		  {
  	  			  if(st.contains("*******Information Of Logical Drive 0*******"))
  	  			  {
  	  				  raid0_chk = apgfile.indexOf(st);
  	  				  raid0 = raid0_chk + 2;
  	  				  break;
  	  			  }
  	  		  }	
  	  	  
  	  		  for(String st : apgfile)
  	  		  {
  	  			  if(st.contains("*******Information Of Logical Drive 1*******"))
  	  			  {
  	  				  raid1 = apgfile.indexOf(st);
  	  				  raid1 = raid1 + 2;
  	  				  break;
  	  			  }
  	  		  }
  	  	
  	  		  for(String st : apgfile)
  	  		  {
  	  			  if(st.contains("*******Information Of Logical Drive 2*******"))
  	  			  {
  	  				  raid_end = apgfile.indexOf(st);
  	  				  raid2 = raid_end + 2;
  	  				  break;
  	  			  }
  	  		  }
  	  	  
  	  		  if(apgfile.get(raid0).endsWith("OPTIMAL") && apgfile.get(raid1).endsWith("OPTIMAL") && apgfile.get(raid2).endsWith("OPTIMAL"))
  	  		  {
  	  			  Label raid = new Label(1, 7, "OK", green);
  	  			  sheet.addCell(raid);
  	  		  }
  	  		  else
  	  		  {
  	  			  Label raid = new Label(1, 7, "Warning", yellow);
  	  			  sheet.addCell(raid);
   	      	
  	  			  Label raid_act = new Label(4, 7, "Follow OPI AP Fault", va_c);
  	  			  sheet.addCell(raid_act);
   	    	
  	  			  String raid_err = null;
  	  			  String raid_tmp = "";
   	    	
  	  			  for(int i=raid0_chk; i<=raid_end+11; i++)
  	  			  {
  	  				  raid_err = apgfile.get(i);
  	  				  raid_tmp+=raid_err + "\n";
  	  			  }
   	    	
  	  			  double raid_tmp_h = raid_tmp.split(System.getProperty("line.separator")).length;
   	    	
  	  			  Label raid_obs = new Label(2, 7, "Not all RAID Status is not OPTIMAL", va_c);
  	  			  WritableCellFeatures raid_comm = new WritableCellFeatures();
  	  			  raid_comm.setComment(raid_tmp, 2, raid_tmp_h);
  	  			  raid_obs.setCellFeatures(raid_comm);
  	  			  sheet.addCell(raid_obs);

  	  		  }
  	  	  }
  	  	  else if(hwver.equals("APG43"))
  	  	  {
  	  		  for(String st : apgfile)
	  		  {
	  			  if(st.contains("vxdisk list"))
	  			  {
	  				  raid43_chk = apgfile.indexOf(st)+2;
	  				  break;
	  			  }
	  		  }
  	  		
  	  		  if(! apgfile.get(raid43_chk).contains("Uninitialized"))
  	  		  {
  	  			  raid43_prob = apgfile.get(raid43_chk);
  	  			  raid43_tmp+=raid43_prob + "\n";
  	  		  }
  	  		  if(! apgfile.get(raid43_chk+1).contains("Imported"))
	  		  {
	  			  raid43_prob = apgfile.get(raid43_chk);
	  			  raid43_tmp+=raid43_prob + "\n";
	  		  }
  	  		  if(! apgfile.get(raid43_chk+2).contains("Imported"))
	  		  {
	  			  raid43_prob = apgfile.get(raid43_chk);
	  			  raid43_tmp+=raid43_prob + "\n";
	  		  }
	  		  if(! apgfile.get(raid43_chk+3).contains("Uninitialized"))
	  		  {
	  			  raid43_prob = apgfile.get(raid43_chk);
	  			  raid43_tmp+=raid43_prob + "\n";
	  		  }
	  		  
	  		  if(raid43_tmp.equals(""))
	  		  {
	  			  Label raid = new Label(1, 7, "OK", green);
	  			  sheet.addCell(raid);
	  		  }
	  		  else
	  		  {
	  			  Label raid = new Label(1, 7, "Warning", yellow);
	  			  sheet.addCell(raid);
 	      	
	  			  Label raid_act = new Label(4, 7, "Follow OPI AP Fault", va_c);
	  			  sheet.addCell(raid_act);
	  			  
	  			  String raid43_header = "Name             MediaName   Diskgroup         DiskStyle  Size(MB)  FreeSpace(MB)   Status       EnclosureID      P#C#T#L# \n";

	  			  double raid43_tmp_h = raid43_tmp.split(System.getProperty("line.separator")).length
	  			  					  + raid43_header.split(System.getProperty("line.separator")).length;
	  			  
	  			  Label raid_obs = new Label(2, 7, "Raids satus is not ok", va_c);
	  			  WritableCellFeatures raid_cmt = new WritableCellFeatures();
	  			  raid_cmt.setComment(raid43_header + raid43_tmp, 2, raid43_tmp_h);
	  			  raid_obs.setCellFeatures(raid_cmt);
	  			  sheet.addCell(raid_obs);
	  		  }
  	  	  }
  	  	  else if(hwver.equals("APG40C/2"))
  	  	  {
  	  		  for(String st : apgfile)
	  		  {
	  			  if(st.contains("raidutil -L raid"))
	  			  {
	  				  raid40c2 = apgfile.indexOf(st)+3;
	  				  break;
	  			  }
	  		  }
  	  		  
  	  		  for(String st : apgfile)
	  		  {
	  			  if(st.contains(">diskpart"))
	  			  {
	  				  raid40c2_e = apgfile.indexOf(st)-2;
	  				  break;
	  			  }
	  		  }
  	  		  
  	  		  for(int i=raid40c2; i<=raid40c2_e; i++)
  	  		  {
  	  			  if(apgfile.get(i).trim().startsWith("d0b0t0d0      RAID 1"))
  	  			  {
  	  				  if(! apgfile.get(raid40c2).trim().endsWith("17522MB   Optimal"))
    	  			  {
  	  					  apg40c2_prob = apgfile.get(raid40c2);
    	  				  apg40c2_tmp+=apg40c2_prob + "\n";
    	  			  }
  	  			  }
  	  			  else if(! apgfile.get(i).trim().startsWith("d0b0t0d0      RAID 1"))
  	  			  {
  	  				  apg40c2_miss+="d0b0t0d0      RAID 1 is missing \n";
  	  			  }
  	  			  else if(apgfile.get(i).trim().startsWith("d0b0t0d0     Disk Drive"))
	  			  {
  	  				  if(! apgfile.get(raid40c2).trim().endsWith("17522MB   Optimal"))
  	  				  {
  	  					  apg40c2_prob = apgfile.get(raid40c2);
  	  					  apg40c2_tmp+=apg40c2_prob + "\n";
  	  				  }
	  			  }
  	  			  else if(! apgfile.get(i).trim().startsWith("d0b0t0d0     Disk Drive"))
	  			  {
	  				  apg40c2_miss+="d0b0t0d0     Disk Drive is missing \n";
	  			  }
  	  			  else if(apgfile.get(i).trim().startsWith("d0b1t0d0     Disk Drive"))
	  			  {
  	  				  if(! apgfile.get(raid40c2).trim().endsWith("17522MB   Optimal"))
  	  				  {
  	  					  apg40c2_prob = apgfile.get(raid40c2);
  	  					  apg40c2_tmp+=apg40c2_prob + "\n";
  	  				  }
	  			  }
  	  			  else if(! apgfile.get(i).trim().startsWith("d0b1t0d0     Disk Drive"))
	  			  {
	  				  apg40c2_miss+="d0b1t0d0     Disk Drive is missing \n";
	  			  }
	  			  else if(apgfile.get(i).trim().startsWith("d0b0t1d0      RAID 1")) 
	  			  {
	  				  if(! apgfile.get(raid40c2).trim().endsWith("17522MB   Optimal"))
	  				  {
	  					  apg40c2_prob = apgfile.get(raid40c2);
	  					  apg40c2_tmp+=apg40c2_prob + "\n";
	  				  }
	  			  }
	  			  else if(! apgfile.get(i).trim().startsWith("d0b0t1d0      RAID 1"))
	  			  {
	  				apg40c2_miss+="d0b0t1d0      RAID 1 is missing \n";
	  			  }
	  			  else if(apgfile.get(i).trim().startsWith("d0b0t1d0     Disk Drive")) 
	  			  {
  	  				  if(! apgfile.get(raid40c2).trim().endsWith("17522MB   Optimal"))
  	  				  {
	  					  apg40c2_prob = apgfile.get(raid40c2);
	  					  apg40c2_tmp+=apg40c2_prob + "\n";
  	  				  }
	  			  }
	  			  else if(! apgfile.get(i).trim().startsWith("d0b0t1d0     Disk Drive"))
	  			  {
	  				apg40c2_miss+="d0b0t1d0     Disk Drive is missing \n";
	  			  }
	  			  else if(apgfile.get(i).trim().startsWith("d0b1t1d0     Disk Drive")) 
	  			  {
	  				  if(! apgfile.get(raid40c2).trim().endsWith("17522MB   Optimal"))
	  				  {
	  					  apg40c2_prob = apgfile.get(raid40c2);
	  					  apg40c2_tmp+=apg40c2_prob + "\n";
	  				  }
	  			  }
	  			  else if(! apgfile.get(i).trim().startsWith("d0b1t1d0     Disk Drive"))
	  			  {
	  				apg40c2_miss+="d0b1t1d0     Disk Drive is missing \n";
	  			  }
	  			  else if(apgfile.get(i).trim().startsWith("d0b0t2d0      RAID 1"))
	  			  {
	  				  if(! apgfile.get(raid40c2).trim().endsWith("17522MB   Optimal"))
	  				  {
	  					  apg40c2_prob = apgfile.get(raid40c2);
	  					  apg40c2_tmp+=apg40c2_prob + "\n";
	  				  }
	  			  }
	  			  else if(! apgfile.get(i).trim().startsWith("d0b0t2d0      RAID 1"))
	  			  {
	  				apg40c2_miss+="d0b0t2d0      RAID 1 is missing \n";
	  			  }
	  			  else if(apgfile.get(i).trim().startsWith("d0b0t2d0     Disk Drive"))
	  			  {
	  				  if(! apgfile.get(raid40c2).trim().endsWith("17522MB   Optimal"))
	  				  {
	  					  apg40c2_prob = apgfile.get(raid40c2);
	  					  apg40c2_tmp+=apg40c2_prob + "\n";
	  				  }
	  			  }
	  			  else if(! apgfile.get(i).trim().startsWith("d0b0t2d0     Disk Drive"))
	  			  {
	  				apg40c2_miss+="d0b0t2d0     Disk Drive is missing \n";
	  			  }
	  			  else if(apgfile.get(i).trim().startsWith("d0b1t2d0     Disk Drive"))
	  			  {
	  				  if(! apgfile.get(raid40c2).trim().endsWith("17522MB   Optimal"))
	  				  {
	  					  apg40c2_prob = apgfile.get(raid40c2);
	  					  apg40c2_tmp+=apg40c2_prob + "\n";
	  				  }
	  			  }
	  			  else if(! apgfile.get(i).trim().startsWith("d0b1t2d0     Disk Drive"))
	  			  {
	  				apg40c2_miss+="d0b1t2d0     Disk Drive is missing \n";
	  			  }
  	  		  }
  	  		  
  	  		  if(apg40c2_tmp.equals("") && apg40c2_miss.equals(""))
	  		  {
	  			  Label raid = new Label(1, 7, "OK", green);
	  			  sheet.addCell(raid);
	  		  }
  	  		  else
  	  		  {
  	  			  Label raid = new Label(1, 7, "Warning", yellow);
	  			  sheet.addCell(raid);
	      	
	  			  Label raid_act = new Label(4, 7, "Follow OPI AP Fault", va_c);
	  			  sheet.addCell(raid_act);
  	  		  }
  	  		  
  	  		  String raid40c2_header = null;
  	  		
  	  		  if(!apg40c2_tmp.equals(""))
	  		  {
	  			  raid40c2_header = "Address       Type              Manufacturer/Model      Capacity  Status \n"
	  				  			  + "--------------------------------------------------------------------------- \n";

	  			  double raid40c2_tmp_h = apg40c2_tmp.split(System.getProperty("line.separator")).length
	  			  				        + raid40c2_header.split(System.getProperty("line.separator")).length;
	  			  
	  			  Label raid_obs = new Label(2, 7, "Raids satus is not ok", va_c);
	  			  WritableCellFeatures raid_cmt = new WritableCellFeatures();
	  			  raid_cmt.setComment(raid40c2_header + apg40c2_tmp, 2, raid40c2_tmp_h);
	  			  raid_obs.setCellFeatures(raid_cmt);
	  			  sheet.addCell(raid_obs);
	  		  }
  	  		  if(!apg40c2_miss.equals(""))
  	  		  {
  	  			  
  	  			  if(apg40c2_tmp.equals(""))
  	  			  {
  	  				double raid40c2_miss_h = apg40c2_miss.split(System.getProperty("line.separator")).length
  	  			  						   + raid40c2_header.split(System.getProperty("line.separator")).length;
  	  			  
  	  			  	Label raid1_obs = new Label(2, 7, "Raids satus is not ok", va_c);
  	  			  	WritableCellFeatures raid_miss_cmt = new WritableCellFeatures();
	  			  	raid_miss_cmt.setComment(raid40c2_header + apg40c2_miss, 2, raid40c2_miss_h);
	  			  	raid1_obs.setCellFeatures(raid_miss_cmt);
	  			  	sheet.addCell(raid1_obs);
	  			  }
  	  			  else
  	  			  {
  	  				double raid40c2_miss_h = apg40c2_miss.split(System.getProperty("line.separator")).length
  	  									   + raid40c2_header.split(System.getProperty("line.separator")).length 
  	  									   + apg40c2_tmp.split(System.getProperty("line.separator")).length;
  	  				
  	  				Label raid1_obs = new Label(2, 7, "Raids satus is not ok", va_c);
  	  				WritableCellFeatures raid_miss_cmt = new WritableCellFeatures();
  	  				raid_miss_cmt.setComment(raid40c2_header+apg40c2_tmp+apg40c2_miss, 2, raid40c2_miss_h);
  	  				raid1_obs.setCellFeatures(raid_miss_cmt);
  	  				sheet.addCell(raid1_obs); 
  	  			  }
  	  				  
  	  		  }
  	  		  
  	  	  } 
  	  		  
  	  		  
  	  /*
  	  		  
  	  		  if( apgfile.get(raid40c2).trim().startsWith("d0b0t0d0      RAID 1") )
  	  		  {
  	  			  if(! apgfile.get(raid40c2).trim().endsWith("17522MB   Optimal"))
  	  			  {
  	  				  apg40c2_prob = apgfile.get(raid40c2);
  	  				  apg40c2_tmp+=apg40c2_prob + "\n";
  	  			  }
  	  		  }
  	  		  else
  	  		  {
  	  			  apg40c2_miss = "d0b0t0d0      RAID 1 is missing";
  	  		  }
  	  	  }
  	  	 */ 
  	  	  
   	      
//===== DISKPART> list vol
   	      
   	      int disk_vol=0, disk_cmd=0;
   	      for(String st : apgfile)
	  	  {
   	    	  if(st.contains("DISKPART> list vol"))
	  		  {
   	    		  disk_cmd = apgfile.indexOf(st);
   	    		  disk_vol = disk_cmd + 4;
	  			  break;
	  		  }
	  	  }
   	      
   	      String disk_tmp = "";
   	      int disk_e=0;
   	      for(String st : apgfile)
   	      {
   	    	  if(st.contains("DISKPART> exit"))
   	    	  {
   	    		  disk_e = apgfile.indexOf(disk_e);
   	    		  disk_e = disk_e-2;
   	    		  break;
   	    	  }
   	      }
   	      
   	      if(hwver.equals("APG40C/4"))
   	      {
   	      for(int i=disk_vol; i<=disk_e; i++)
   	      {
   	    	  if(apgfile.get(i).contains("Disk Q"))
   	    	  {
   	    		  if(apgfile.get(i).endsWith("Healthy") && apgfile.get(i).contains("4001 MB")
   	    				  && apgfile.get(i).charAt(13) == 'Q')
   	    		  {}
   	    		  else
   	    		  {
   	    			disk_tmp+=apgfile.get(i) + "\n";
   	    		  }
   	    	  }
   	    	  else if(apgfile.get(i).contains("Disk Y"))
 	    	  {
 	    		  if(apgfile.get(i).endsWith("Healthy") && apgfile.get(i).contains("63 GB")
 	    				  && apgfile.get(i).charAt(13) == 'Y')
 	    		  {}
 	    		  else
 	    		  {
 	    			disk_tmp+=apgfile.get(i) + "\n";
 	    		  }
 	    	  }
   	    	  else if(apgfile.get(i).contains("Disk I"))
	    	  {
	    		  if(apgfile.get(i).endsWith("Healthy") && apgfile.get(i).contains("204 MB")
	    				  && apgfile.get(i).charAt(13) == 'I')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
   	    	  else if(apgfile.get(i).contains("Disk R"))
	    	  {
	    		  if(apgfile.get(i).endsWith("Healthy") && apgfile.get(i).contains("20 GB")
	    				  && apgfile.get(i).charAt(13) == 'R')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
 	    	  else if(apgfile.get(i).contains("Disk S"))
	    	  {
	    		  if(apgfile.get(i).endsWith("Healthy") && apgfile.get(i).contains("10 GB")
	    				  && apgfile.get(i).charAt(13) == 'S')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
 	    	  else if(apgfile.get(i).contains("Disk V"))
	    	  {
	    		  if(apgfile.get(i).endsWith("Healthy") && apgfile.get(i).contains("23 GB")
	    				  && apgfile.get(i).charAt(13) == 'V')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
  	    	  else if(apgfile.get(i).contains("Disk G"))
	    	  {
	    		  if(apgfile.get(i).endsWith("Healthy") && apgfile.get(i).contains("15 GB")
	    				  && apgfile.get(i).charAt(13) == 'G')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
  	    	  else if(apgfile.get(i).contains("ntboot"))
	    	  {
	    		  if(apgfile.get(i).endsWith("31 MB  Healthy    System") && apgfile.get(i).charAt(13) == 'E')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
	    	  else if(apgfile.get(i).contains("ntserv"))
	    	  {
	    		  if(apgfile.get(i).endsWith("14 GB  Healthy    Boot") && apgfile.get(i).charAt(13) == 'C')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
	    	  else if(apgfile.get(i).contains("ntbackup"))
	    	  {
	    		  if(apgfile.get(i).endsWith("14 GB  Healthy") && apgfile.get(i).charAt(13) == 'D')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
	    	  else if(apgfile.get(i).contains("ntdump"))
	    	  {
	    		  if(apgfile.get(i).endsWith("9 GB  Healthy") && apgfile.get(i).charAt(13) == 'F')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
	    	  else if(apgfile.get(i).contains("Disk K"))
	    	  {
	    		  if(apgfile.get(i).endsWith("Healthy") && apgfile.get(i).contains("10 GB")
	    				  && apgfile.get(i).charAt(13) == 'K')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
	    	  else if(apgfile.get(i).contains("Disk L"))
	    	  {
	    		  if(apgfile.get(i).endsWith("Healthy") && apgfile.get(i).contains("39 GB")
	    				  && apgfile.get(i).charAt(13) == 'L')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
  	    	  else if(apgfile.get(i).contains("Disk M"))
	    	  {
	    		  if(apgfile.get(i).endsWith("Healthy") && apgfile.get(i).contains("19 GB")
	    				  && apgfile.get(i).charAt(13) == 'M')
	    		  {}
	    		  else
	    		  {
	    			disk_tmp+=apgfile.get(i) + "\n";
	    		  }
	    	  }
   	      }
   	      
   	      	if(disk_tmp.equals(""))
   	      	{
   	    	  Label list_ok = new Label(1, 8, "OK", green);
   	    	  sheet.addCell(list_ok);
   	      	}
   	      	else
   	      	{
   	    	  Label list_ok = new Label(1, 8, "Warning", yellow);
 	    	  sheet.addCell(list_ok);
 	    	  
 	    	  Label disk_act = new Label(4, 8, "Follow OPI AP Fault", va_c);
	    	  sheet.addCell(disk_act);
 	    	  
 	    	  String lisvol_header = "Volume ###  Ltr  Label        Fs     Type        Size     Status     Info \n"
 	    	    				   + "----------  ---  -----------  -----  ----------  -------  ---------  -------- \n";

 	    	  double list_tmp_h = lisvol_header.split(System.getProperty("line.separator")).length
 	    	  				   + disk_tmp.split(System.getProperty("line.separator")).length;
 	    	  
 	    	  Label list_wrn = new Label(2, 8, "APG Volumes not correct", va_c);
 	    	  WritableCellFeatures listcmt = new WritableCellFeatures();
 	    	  listcmt.setComment(lisvol_header + disk_tmp, 2.1, list_tmp_h);
 	    	  list_wrn.setCellFeatures(listcmt);
 	    	  sheet.addCell(list_wrn);
   	      	}
   	      }
   	      else if(hwver.equals("APG43"))
	      {
   	    	  for(int i=disk_vol; i<=disk_e; i++)
   	    	  {
   	    		  if(! (apgfile.get(i).contains("DataDisk") && apgfile.get(i).trim().endsWith("Healthy")) )
     	    	  {
     	    		  disk_tmp+=apgfile.get(i) + "\n";
     	    	  }
   	    		  else if(! (apgfile.get(i).contains("QuorumDisk") && apgfile.get(i).trim().endsWith("Healthy")) )
   	    		  {
   	    			  disk_tmp+=apgfile.get(i) + "\n";
   	    		  }
   	    		  else if(! (apgfile.get(i).contains("WINPE") && apgfile.get(i).trim().endsWith("Healthy")) )
     	    	  {
     	    		  disk_tmp+=apgfile.get(i) + "\n";
     	    	  }
   	    		  else if(! (apgfile.get(i).contains("NTBOOT") && apgfile.get(i).trim().endsWith("Healthy    System")) )
   	    		  {
   	    			  disk_tmp+=apgfile.get(i) + "\n";
   	    		  }
   	    		  else if(! (apgfile.get(i).contains("NTSERV") && apgfile.get(i).trim().endsWith("Healthy")) )
 	    		  {
 	    			  disk_tmp+=apgfile.get(i) + "\n";
 	    		  }
 	    		  else if(! (apgfile.get(i).contains("NTBACKUP") && apgfile.get(i).trim().endsWith("Healthy    Boot")) )
 	    		  {
 	    			  disk_tmp+=apgfile.get(i) + "\n";
 	    		  }
 	    		  else if(! (apgfile.get(i).contains("NTDUMP") && apgfile.get(i).trim().endsWith("Healthy")) )
 	    		  {
 	    			  disk_tmp+=apgfile.get(i) + "\n";
 	    		  }
   	    	  }
   	    	  
   	    	  if(disk_tmp.equals(""))
   	    	  {
   	    		  Label list_ok = new Label(1, 8, "OK", green);
   	    		  sheet.addCell(list_ok);
   	    	  }
   	    	  else
   	    	  {
   	    		  Label list_ok = new Label(1, 8, "Warning", yellow);
   	    		  sheet.addCell(list_ok);
 	    	  
   	    		  Label disk_act = new Label(4, 8, "Follow OPI AP Fault", va_c);
   	    		  sheet.addCell(disk_act);
 	    	  
   	    		  String lisvol_header = "Volume ###  Ltr  Label        Fs     Type        Size     Status     Info \n"
   	    			  				   + "----------  ---  -----------  -----  ----------  -------  ---------  -------- \n";

   	    		  double list_tmp_h = lisvol_header.split(System.getProperty("line.separator")).length
 	    	  				   		+ disk_tmp.split(System.getProperty("line.separator")).length;
 	    	  
   	    		  Label list_wrn = new Label(2, 8, "APG Volumes not correct", va_c);
   	    		  WritableCellFeatures listcmt = new WritableCellFeatures();
   	    		  listcmt.setComment(lisvol_header + disk_tmp, 2.1, list_tmp_h);
   	    		  list_wrn.setCellFeatures(listcmt);
   	    		  sheet.addCell(list_wrn);
   	    	  }
	      }
   	      
   	    /*  String list_vol0 = "  Volume 0     Q   Disk Q       NTFS   Partition   4001 MB  Healthy            ".trim();            
   	      String list_vol1 = "  Volume 1     Y   Disk Y       NTFS   Partition     63 GB  Healthy            ".trim();            
   	      String list_vol2 = "  Volume 2     I   Disk I       NTFS   Partition    204 MB  Healthy            ".trim();            
   	      String list_vol3 = "  Volume 3     E   ntboot       NTFS   Partition     31 MB  Healthy    System  ".trim();  
   	      String list_vol4 = "  Volume 4     C   ntserv       NTFS   Partition     14 GB  Healthy    Boot    ".trim();    
   	      String list_vol5 = "  Volume 5     D   ntbackup     NTFS   Partition     14 GB  Healthy            ".trim();  
   	      String list_vol6 = "  Volume 6     F   ntdump       NTFS   Partition      9 GB  Healthy            ".trim();            
   	      String list_vol7 = "  Volume 7     K   Disk K       NTFS   Partition     10 GB  Healthy            ".trim();            
   	      String list_vol8 = "  Volume 8     L   Disk L       NTFS   Partition     39 GB  Healthy            ".trim();            
   	      String list_vol9 = "  Volume 9     M   Disk M       NTFS   Partition     19 GB  Healthy            ".trim();            
   	      String list_vol10 = "  Volume 10    R   Disk R       NTFS   Partition     20 GB  Healthy            ".trim();            
   	      String list_vol11 = "  Volume 11    S   Disk S       NTFS   Partition     10 GB  Healthy            ".trim();            
   	      String list_vol12 = "  Volume 12    V   Disk V       NTFS   Partition     23 GB  Healthy            ".trim();            
   	      String list_vol13 = "  Volume 13    G   Disk G       NTFS   Partition     15 GB  Healthy           ".trim();           
   	      
   	      if( apgfile.get(disk_vol).trim().equals(list_vol0) && apgfile.get(disk_vol+1).trim().equals(list_vol1) &&
   	    		apgfile.get(disk_vol+2).trim().equals(list_vol2) && apgfile.get(disk_vol+3).trim().equals(list_vol3) && 
   	    		apgfile.get(disk_vol+4).trim().equals(list_vol4) && apgfile.get(disk_vol+5).trim().equals(list_vol5) && 
   	    		apgfile.get(disk_vol+6).trim().equals(list_vol6) && apgfile.get(disk_vol+7).trim().equals(list_vol7) && 
   	    		apgfile.get(disk_vol+8).trim().equals(list_vol8) && apgfile.get(disk_vol+9).trim().equals(list_vol9) &&
   	    		apgfile.get(disk_vol+10).trim().equals(list_vol10) && apgfile.get(disk_vol+11).trim().equals(list_vol11) &&
   	    		apgfile.get(disk_vol+12).trim().equals(list_vol12) && apgfile.get(disk_vol+13).trim().equals(list_vol13) )
   	      {
   	    	  Label disk_ok = new Label(1, 8, "OK", green);
   	    	  sheet.addCell(disk_ok);
   	      }
   	      else
   	      {
   	    	  Label disk_ok = new Label(1, 8, "Warning", yellow);
 	    	  sheet.addCell(disk_ok);
 	    	  
 	    	  Label disk_act = new Label(4, 8, "Follow OPI AP Fault");
	    	  sheet.addCell(disk_act);
	    	  
	    	  String list_vol_header = apgfile.get(disk_cmd+2) + "\n" + apgfile.get(disk_cmd+3) + "\n";
	    	  
	    	  String disk_vol_str = null;
	    	  String disk_vol_tmp = "";
	    	  
	    	  for(int i=disk_vol; i<=disk_vol+13; i++)
	    	  {
	    		  disk_vol_str = apgfile.get(i);
	    		  
	    		  disk_vol_tmp+=disk_vol_str+"\n";
	    	  }
	    	  
	    	  double disk_vol_h = disk_vol_tmp.split(System.getProperty("line.separator")).length;
	    	  
	    	  Label disk_obs = new Label(2, 8, "APG Volumes not correct", va_c);
	  		  WritableCellFeatures disk_vol_com = new WritableCellFeatures();
	  		  disk_vol_com.setComment(list_vol_header + disk_vol_tmp, 2.1, disk_vol_h);
	  		  disk_obs.setCellFeatures(disk_vol_com);
	  		  sheet.addCell(disk_obs);
	    	  
   	      }
   	      
   	  */    
   	      
   //---- mml

          int sys_mml=0,sys1_mml=0,sys2_mml=0;
          for (String st : apgfile)
          {
       	   if (st.contains(">pstat |findstr -i mml"))
              {
       		   sys_mml = apgfile.indexOf(st);
       		   sys_mml++;
                  break;
              }
          }
          int cpd_lst=0;
          for (String st : apgfile)
          {
       	   if (st.contains(">cpdlist -a"))
              	{
                  sys1_mml = apgfile.indexOf(st);
                  cpd_lst  = sys1_mml+1;
                  break;
              }
          }
          
          for (String st : apgfile)
          {
       	   if (st.contains("wmic VOLUME GET Capacity, DriveLetter, FreeSpace, Label"))
       	   {
       		   sys2_mml = apgfile.indexOf(st);
       		   sys2_mml = sys2_mml-2;
                  break;
              }
          }
          
          int s_mml = sys1_mml-sys_mml;

          String str_mml=null;
          String temp_mml="";
   	
          if (s_mml<11)
          { 
       	   Label mml_lab = new Label(1, 9, "OK", green);
       	   sheet.addCell(mml_lab);
          }
          else
          {
       	   	Label mml_lab = new Label(1, 9, "Warning", yellow);
       	   	sheet.addCell(mml_lab);
       	   
       	   	Label mml_act = new Label(4, 9, "Follow OPI AP Fault", va_c);
       	   	sheet.addCell(mml_act);
       	   
       	   	for (int i=cpd_lst; i<=sys2_mml; i++)
       	   	{
       	   		str_mml=apgfile.get(i);
       	   		temp_mml+=str_mml+ "\n";
       	   	}
       	   
       	   	double temp_mml_h = temp_mml.split(System.getProperty("line.separator")).length;
       	   	
       	   	Label mml_lab1 = new Label(2, 9, "Too many mml sessions", va_c);
       	   	WritableCellFeatures mml_comm = new WritableCellFeatures();
       	   	mml_comm.setComment(temp_mml, 2, temp_mml_h);
       	   	mml_lab1.setCellFeatures(mml_comm);
       	   	sheet.addCell(mml_lab1);    
          }	

//====	      
	      
   // wmic VOLUME GET Capacity, DriveLetter, FreeSpace, Label
      
     // sys disk
          
          int fs_start=0;
          for (String st : apgfile)
          {
        	  if (st.contains("wmic VOLUME GET Capacity, DriveLetter, FreeSpace, Label"))
        	  {
        		  fs_start = apgfile.indexOf(st);
        		  fs_start = fs_start+2; // start for sys disk
        		  break;
        	  }
          }
          
          int fs_end=0, up_time=0;

          for (String st : apgfile)
          {
       	 	  if (st.contains(">systeminfo"))
       	 	  {
       	 		  fs_end = apgfile.indexOf(st);
       	 		  fs_end = fs_end-1; // end for data disk
       	 		  up_time = apgfile.indexOf(st);
       	 		  up_time= up_time+12;
       	 		  break;
       	 	  }
          }
     
          String fs_sys_tmp = "";
          for(int i=fs_start; i<=fs_end; i++)
          {
        	  if(apgfile.get(i).contains("C:")||apgfile.get(i).contains("D:")||apgfile.get(i).contains("E:")||apgfile.get(i).contains("F:"))
        	  {
        		  String fs_d[] = apgfile.get(i).replaceAll("\\s+", " ").split(" ");
        	  
        		  float fs_val1 = Float.parseFloat(fs_d[0]);
        		  float fs_val3 = 0;
        	  
        		  if(fs_d[2].startsWith("0") || fs_d[2].startsWith("1") || fs_d[2].startsWith("2")|| 
        		     fs_d[2].startsWith("3") || fs_d[2].startsWith("4") || fs_d[2].startsWith("5")||
        			 fs_d[2].startsWith("6") || fs_d[2].startsWith("7") || fs_d[2].startsWith("8")||
        			 fs_d[2].startsWith("9"))
        		  {
        			  fs_val3 = Float.parseFloat(fs_d[2]);
        		  }
        		  else
        		  {
        			  fs_val3 = Float.parseFloat(fs_d[1]);
        		  }
        	  
/*        		  String fs_start_tab[] = apgfile.get(i).split("           "); // tab
        	  	  String fs_word1[] = fs_start_tab[0].split("\\s");
        	  	  float fs_val1 = Float.parseFloat(fs_word1[0]); //0
        	      String fs_word3[] = fs_start_tab[1].split(" ");
        	      float fs_val3 = Float.parseFloat(fs_word3[0]); //2
*/        	  
        		  float fs_div = (fs_val3/fs_val1)*100;
        	  
        		  String fs_sys_err = null;
    		  
        		  if(fs_div >= 20)
        		  {}
        		  else
        		  {
        			  Label sys_dsk_act = new Label(4, 10, "Follow OPI AP SYSTEM ANALYSIS", va_c);
        			  sheet.addCell(sys_dsk_act);
       			 
        			  fs_sys_err = apgfile.get(i);
        			  fs_sys_tmp+=fs_sys_err;
           		 
        		  /*double fs_sys_tmp_h = fs_sys_tmp.split(System.getProperty("line.separator")).length
        		  					  + fs_sys_header.split(System.getProperty("line.separator")).length;
        		 
        		  Label sys_dsk_lab_1 = new Label(2, 10, "Free space is Less than 20% of total", va_c);
        		  WritableCellFeatures sys_fs_comm = new WritableCellFeatures();
        		  sys_fs_comm.setComment(fs_sys_header + fs_sys_tmp, 2, fs_sys_tmp_h );
        		  sys_dsk_lab_1.setCellFeatures(sys_fs_comm);
        		  sheet.addCell(sys_dsk_lab_1);*/
        		  }
        	  
        		  if(fs_sys_tmp.equals(""))
        		  {
        			  Label sys_dsk_lab = new Label(1, 10, "OK", green);
        			  sheet.addCell(sys_dsk_lab);
        		  }
        		  else
        		  {
        			  Label sys_dsk_lab = new Label(1, 10, "Warning", yellow);
        			  sheet.addCell(sys_dsk_lab);
        		  
        			  String fs_sys_header = "Capacity     DriveLetter  FreeSpace    Label" + "\n";
        		  
        			  double fs_sys_tmp_h = fs_sys_tmp.split(System.getProperty("line.separator")).length
					  					  + fs_sys_header.split(System.getProperty("line.separator")).length;

        			  Label sys_dsk_lab_1 = new Label(2, 10, "Free space is Less than 20% of total", va_c);
        			  WritableCellFeatures sys_fs_comm = new WritableCellFeatures();
        		  
        			  sys_fs_comm.setComment(fs_sys_header + fs_sys_tmp, 2, fs_sys_tmp_h );
        			  sys_dsk_lab_1.setCellFeatures(sys_fs_comm);
        			  sheet.addCell(sys_dsk_lab_1);
        		  }
        	  }
        	  else
        	  {}
          }
//----   
            
   // data disk
            
          String ds_sys_tmp = "";
          for(int i=fs_start; i<=fs_end; i++)
          {
        	  if(apgfile.get(i).contains("K:")||apgfile.get(i).contains("L:")||apgfile.get(i).contains("M:")||apgfile.get(i).contains("G:")||
        	     apgfile.get(i).contains("V:")||apgfile.get(i).contains("S:")||apgfile.get(i).contains("R:")||apgfile.get(i).contains("Q:")||
        	     apgfile.get(i).contains("Y:")||apgfile.get(i).contains("I:")||apgfile.get(i).contains("WINPE"))
        	  {
        		  String ds_d[] = apgfile.get(i).replaceAll("\\s+", " ").split(" ");
        		  
        		  float ds_val1 = Float.parseFloat(ds_d[0]);
        		  float ds_val3 = 0;
        		  
        		  if(ds_d[2].startsWith("0") || ds_d[2].startsWith("1") || ds_d[2].startsWith("2")|| 
             		 ds_d[2].startsWith("3") || ds_d[2].startsWith("4") || ds_d[2].startsWith("5")||
             		 ds_d[2].startsWith("6") || ds_d[2].startsWith("7") || ds_d[2].startsWith("8")||
             		 ds_d[2].startsWith("9"))
        		  {
        			  ds_val3 = Float.parseFloat(ds_d[2]);
        		  }
        		  else
        		  {
        			  ds_val3 = Float.parseFloat(ds_d[1]);
        		  }
        	  
        	  /*String ds_start_tab[] = apgfile.get(i).split("           "); // tab
        
        	  String ds_word1[] = ds_start_tab[0].split(" ");
        	  float ds_val1 = Float.parseFloat(ds_word1[0]);
        
        	  String ds_word3[] = ds_start_tab[1].split(" ");
        	  float ds_val3 = Float.parseFloat(ds_word3[0]); */
        
        		  float ds_div = (ds_val3/ds_val1)*100;

        		  String ds_sys_err = null;
        		  
        		  if(ds_div >= 20)
        		  {}
        		  else
        		  {
        			  Label ds_dsk_act = new Label(4, 11, "Follow OPI AP SYSTEM ANALYSIS", va_c);
        			  sheet.addCell(ds_dsk_act);
       			 
        			  ds_sys_err = apgfile.get(i);
        			  ds_sys_tmp+=ds_sys_err;
        		  }
        		  
        		  if (ds_sys_tmp.equals(""))
        		  {
        			  Label sys_dsk_lab = new Label(1, 11, "OK", green);
        			  sheet.addCell(sys_dsk_lab);
        		  }
        		  else
        		  {
        			  Label ds_dsk_lab = new Label(1, 11, "Warning", yellow);
        			  sheet.addCell(ds_dsk_lab);
        			  
        			  String ds_sys_header = "Capacity     DriveLetter  FreeSpace    Label\n";
        			  
        			  double ds_sys_tmp_h = ds_sys_tmp.split(System.getProperty("line.separator")).length
					      				  + ds_sys_header.split(System.getProperty("line.separator")).length;

        			  Label ds_dsk_lab_1 = new Label(2, 11, "Free space is Less than 20% of total", va_c);
        			  WritableCellFeatures ds_fs_comm = new WritableCellFeatures();
        			  
        			  ds_fs_comm.setComment(ds_sys_header + ds_sys_tmp, 2, ds_sys_tmp_h);
        			  ds_dsk_lab_1.setCellFeatures(ds_fs_comm);
        			  sheet.addCell(ds_dsk_lab_1);
        		  }
        	  }
        	  else
        	  {}
          }
	      
//-----          
   // system up
   	      
          String up_str = apgfile.get(up_time);
          
          if(up_str.contains("Days"))
          {
        	  String up_date_chk[] = up_str.replaceAll("\\s+", " ").split(" ");
        	  int date_cmp = Integer.parseInt(up_date_chk[3]);
        	  
//        	  String up_time_chk[] = up_str.split("            ");
//        	  String up_date_chk[] = up_time_chk[1].split(" "); //3
//        	  int date_cmp = Integer.parseInt(up_date_chk[0]);
        	  
        	  if(date_cmp < 90)
        	  {
        		  Label lab_up = new Label(1, 12, "OK", green);
                  sheet.addCell(lab_up);
        	  }
        	  else
        	  {
        		  Label lab_up = new Label(1, 12, "Warning", yellow);
                  sheet.addCell(lab_up);

                  double up_str_h = up_str.split(System.getProperty("line.separator")).length;
                  
                  Label lab_up1 = new Label(2, 12, "System uptime should be less than 90 days", va_c);
                  WritableCellFeatures up_tm_cmt = new WritableCellFeatures();
                  up_tm_cmt.setComment(up_str, 2, up_str_h);
                  lab_up1.setCellFeatures(up_tm_cmt);
                  sheet.addCell(lab_up1);
                  
                  Label lab_up_act = new Label(4, 12, "Follow OPI AP REBOOT", va_c);
                  sheet.addCell(lab_up_act);
        	  }
          }
          else
    	  {
        	  Label lab_up = new Label(1, 12, "OK", green);
              sheet.addCell(lab_up);
    	  }
          
//=====
    // STS      
          
          int stmmp_start=0, stmmp_end=0;
          for (String st : apgfile)
          {
              if (st.contains("stmmp -lL"))
              {
            	  stmmp_start = apgfile.indexOf(st);
            	  stmmp_start = stmmp_start+4; // chk for 1st ASN 
                  break;
              }
          }
          
          
          int stmrp_start=0;
          for (String st : apgfile)
          {
              if (st.contains("stmrp -lL"))
              {
            	  stmrp_start = apgfile.indexOf(st)+2;
            	  stmmp_end = stmrp_start-3;
                  break;
              }
          }
          
          int stmrp_end=0;
          for (String st : apgfile)
          {
              if (st.contains("C:\\Program files"))
              {
            	  stmrp_end = apgfile.indexOf(st)-2;
                  break;
              }
          }
          
          String stsm_err = "";
          String stsm_tmp = "";
          
          for(int i=stmrp_start; i<=stmrp_end; i++)
          {
        	  String st_spl[] = apgfile.get(i).replaceAll("\\s+", " ").split(" ");
        	  
//        	  String st_spl[] = apgfile.get(i).split("    ");
        	  
        	  if(! apgfile.get(i).startsWith(" "))
        	  {
        		  if(! st_spl[1].equals("yes"))
        		  {
        			  stsm_err = apgfile.get(i);
        			  stsm_tmp+=stsm_err+"\n";
        			  
        			  if(apgfile.get(i+1).startsWith(" "))
        			  {
//        				  stsm_err+="\n"+apgfile.get(i+1);
        				  
        				  stsm_err = apgfile.get(i+1);
        				  
        				  stsm_tmp+=stsm_err + "\n";
        				  
        				  if(apgfile.get(i+2).startsWith(" "))
        				  {
        					  stsm_err+="\n"+apgfile.get(i+2);
        					  stsm_tmp+=stsm_err + "\n";
        					  
        					  if(apgfile.get(i+3).startsWith(" "))
            				  {
            					  stsm_err+="\n"+apgfile.get(i+3);
            					  stsm_tmp+=stsm_err + "\n";
            				  }
        				  }
        			  }
        		  }
        	  }
          }
          
          String stmmp_run = null;
          String stm_t = "";
          for(int i=stmmp_start; i<=stmmp_end; i=i+7)
          {
        	  stmmp_run = apgfile.get(i);
        	  if(stmmp_run.contains("running"))
        	  {}
        	  else
        	  {
        		  String stmrp_err_s = null;
        		  for(int j=i-3; j<=i+3; j++)
        		  {
        			  stmrp_err_s = apgfile.get(j);
        			  stm_t+=stmrp_err_s+"\n";
        			  
        			  Label stsok = new Label(1, 13, "Warning", yellow);
            		  sheet.addCell(stsok);
            		  
            		  double stm_t_h = stm_t.split(System.getProperty("line.separator")).length;
            		  
            		  Label stsl = new Label(2, 13, "STS error", va_c);
            		  WritableCellFeatures stscom = new WritableCellFeatures();
            		  stscom.setComment(stm_t, 3, stm_t_h);
            		  stsl.setCellFeatures(stscom);
            		  sheet.addCell(stsl);
        		  }
        	  }
        	  
        	  if(stm_t.equals(""))
        	  {
        		  Label stm_ok = new Label(1, 13, "OK", green);
        		  sheet.addCell(stm_ok);
    		  }
        	  else
        	  {}
          }
          
//===== 
    // replication
          
    //---mine
          
          int repl_src=0;
          String repl_src_str = "";
          for (String st : apgfile)
          {
              if (st.contains("Source DC           largest delta  fails/total  %%  error"))
              {
                  repl_src = apgfile.indexOf(st);
                  break;
              }
          }
          
          if( apgfile.get(repl_src+1).trim().endsWith("0 /   5    0") && apgfile.get(repl_src+2).trim().endsWith("0 /   5    0") )
          {}
          else
          {
        	  repl_src_str = apgfile.get(repl_src) + "\n" + apgfile.get(repl_src+1) + "\n" + apgfile.get(repl_src+2) + "\n";
          }
          
          int repl_dst=0;
          String repl_dst_str = "";
          for (String st : apgfile)
          {
              if (st.contains("Destination DC    largest delta    fails/total  %%  error"))
              {
                  repl_dst = apgfile.indexOf(st);
                  break;
              }
          } 
          
          if( apgfile.get(repl_dst+1).trim().endsWith("0 /   5    0") && apgfile.get(repl_dst+2).trim().endsWith("0 /   5    0") )
          {}
          else
          {
        	  repl_dst_str = apgfile.get(repl_dst) + "\n" + apgfile.get(repl_dst+1) + "\n" + apgfile.get(repl_dst+2) + "\n";
          }
          
          String repl_str = repl_src_str + repl_dst_str;

          if(repl_str.equals(""))
          {
        	  Label sw_call_lab5 = new Label(1, 14, "OK", green);
        	  sheet.addCell(sw_call_lab5);
          }
          else
          {
        	  Label sw_call_lab5 = new Label(1, 14, "Warning", yellow);
        	  sheet.addCell(sw_call_lab5);
        	  
        	  Label rep_act = new Label(4, 14, "Follow OPI AP, System Restore, Initiate with good AP backup.", va_c);
        	  sheet.addCell(rep_act);
  
        	  sheet.setColumnView(4, 55);
        	  
        	  double repl_str_h = repl_str.split(System.getProperty("line.separator")).length;
       	   
        	  Label repl_obs = new Label(2, 14, "Replication Error", va_c);
        	  WritableCellFeatures repl_cmt = new WritableCellFeatures();
        	  repl_cmt.setComment(repl_str, 2, repl_str_h);
        	  repl_obs.setCellFeatures(repl_cmt);
        	  sheet.addCell(repl_obs);
        	  
          }
          
          
//------ old repl   	      
   	   /*int callbackm=0;
       for (String st : apgfile)
       {
           if (st.contains("CALLBACK MESSAGE: SyncAll Finished."))
           {
               callbackm = apgfile.indexOf(st);
               callbackm= callbackm+2;
               break;
           }
       }
       String call_back  = apgfile.get(callbackm);
       
       int comment_rep=0;
       for (String st : apgfile)
       {
           if (st.contains("Beginning data collection for replication summary, this may take awhile:"))
           {
               comment_rep = apgfile.indexOf(st);
               comment_rep= comment_rep+8;
               break;
           }
       }
       String call_back3 = apgfile.get(comment_rep) + apgfile.get(comment_rep+2) + apgfile.get(comment_rep+4);
       
       String compare1   = "SyncAll terminated with no errors.";

       if (call_back.equals(compare1))
       { 
    	   Label sw_call_lab5 = new Label(1, 14, "OK", green);
    	   sheet.addCell(sw_call_lab5);
       }
       else
       {	
    	   Label sw_call_lab5 = new Label(1, 14, "Warning", yellow);
    	   sheet.addCell(sw_call_lab5);
    	   
    	   Label rep_act = new Label(4, 14, "Follow OPI AP, System Restore, Initiate with good AP backup.", va_c);
    	   sheet.addCell(rep_act);
    	   
    	   double call_back3_h = call_back3.split(System.getProperty("line.separator")).length;
    	   
    	   Label sw_veri_lab10 = new Label(2, 14, "replication Error", va_c);
    	   WritableCellFeatures replica_comm = new WritableCellFeatures();
    	   replica_comm.setComment(call_back3, 2, call_back3_h);
    	   sw_call_lab5.setCellFeatures(replica_comm);
    	   sheet.addCell(sw_veri_lab10);
       }*/
       
//=====
       
       
     //-----
       // latest backup date
          
           /*String back_up_date_str    = apgfile.get(new_bk_date);
           System.out.println(back_up_date_str);
           
           String back_up_date_str1[] = back_up_date_str.split("  ");
           
           System.out.println(back_up_date_str1[0]);
           System.out.println(back_up_date_str1[1]);
           
           String dateString = "10/02/2012";
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       	Date convertedDate = dateFormat.parse(dateString); 
       	
       	System.out.println(convertedDate);
          */

   //--
       row_index++;
       int veri_b=0, new_bk_date=0;
       for (String st : apgfile)
       {
    	   if (st.contains("burverify -d"))
           {
    		   new_bk_date = apgfile.indexOf(st);
    		   new_bk_date = new_bk_date - 4;
    		   veri_b = apgfile.indexOf(st);
               veri_b = veri_b+2;
               break;
           }
       }
       
       Calendar currentDate = Calendar.getInstance();
       SimpleDateFormat formatter= new SimpleDateFormat("MM/dd/yyyy");
       String dateString = formatter.format(currentDate.getTime());
       String back_up_date_str = apgfile.get(new_bk_date);
       
       
       String back_up_date_str1[] = back_up_date_str.split("  ");
       
//       String back_up_date_str1[] = back_up_date_str.replaceAll("\\s+", " ").split(" ");
       
//       String bac_u=back_up_date_str1[3];
//       String back_up_date_str0[] = bac_u.split(" ");

      // int newOne = Integer.parseInt(back_up_date_str0[1].replaceAll(",",""));
      // newOne=newOne/1024;
      // newOne=newOne/1024;
      // newOne=newOne/1024;

       String date1= back_up_date_str1[0];
       SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
       Date obj1 = dateFormat.parse(dateString); 
       Date obj2 = dateFormat.parse(date1); 
       long diff = obj1.getTime() - obj2.getTime();
       int diffDays =  (int) (diff / (24* 1000 * 60 * 60));
           
       if(diffDays<30)
       { 
    	   Label date_cell = new Label(1, 16, "OK", green);
    	   sheet.addCell(date_cell);
       }
       else
       { 
    	   Label date_cell = new Label(1, 16, "Warning", yellow);
    	   sheet.addCell(date_cell);
           	
    	   Label date1_cell = new Label(2, 16, "Backup is " + diffDays +" days older");
    	   sheet.addCell(date1_cell);
       }
       	
//=====
    // backup size
       
       // backup size node A

          int bckp_start=0,bckup_end=0;
          for (String st : apgfile)
          {
              if (st.startsWith(" Directory of ") && (st.endsWith("Nodea") || st.endsWith("nodeA") || st.endsWith("NodeA")) )
              {
                  bckp_start = apgfile.indexOf(st);
                  bckp_start = bckp_start + 4;
                  break;
              }
          }

          for (String st : apgfile)
          {
              if (st.endsWith("cd .."))
              {
                  bckup_end = apgfile.indexOf(st);
                  bckup_end= bckup_end - 4;
                  break;
              }
          }

          int sub_bkup= bckup_end-bckp_start+1;
          float b_d_s[] = new float[10];
          
          for(int j=0; j<sub_bkup; j++)
          {
        	  String bk_up_date_str = apgfile.get(bckp_start+j);
        	  String bk_date_str1[] = bk_up_date_str.replaceAll("\\s+", " ").split(" ");
        	 
              float back_int = Float.parseFloat(bk_date_str1[3].replaceAll(",","")); // comma values

              b_d_s[j]=(float)(Math.round(back_int/1024/1024/1024*100.0f)/100.0f);
              String str15 = Float.toString(b_d_s[j]);
              int i = j+1;
              
              if(b_d_s[j]>1.00)
              {
            	  Label lab19_size = new Label(1, 17+j, "Warning", yellow);
            	  Label lab12_size = new Label(2, 17+j, "Backup image of node A is "+ str15, va_c);
            	  Label lab19_sizewa = new Label(3, 17+j, "Restoration Not possible", va_c);
              
            	  double back_u_date_str_h = bk_date_str1[4].split(System.getProperty("line.separator")).length;
            	  
            	  WritableCellFeatures cellFeatures_bksize = new WritableCellFeatures();
            	  cellFeatures_bksize.setComment(bk_date_str1[4], 1.25, back_u_date_str_h);
            	  lab12_size.setCellFeatures(cellFeatures_bksize);
            	  sheet.addCell(lab12_size);
            	  sheet.addCell(lab19_size);
            	  sheet.addCell(lab19_sizewa);
            	  
            	  Label size1_act = new Label(4, 17+j, "AP SYSTEM ANALYSIS, AP, System Backup and Verify, Initiate", va_c);
                  sheet.addCell(size1_act);
              }
              else
              { 
            	  Label lab19_sizeok = new Label(1, 17+j, "OK", green);
                  Label lab12_sizeok = new Label(2, 17+j, "Backup image of node A is "+str15, va_c);
                  
                  double back_u_date_str_h = bk_date_str1[4].split(System.getProperty("line.separator")).length;

                  WritableCellFeatures cellFeatures_bksize = new WritableCellFeatures();
                  cellFeatures_bksize.setComment(bk_date_str1[4], 1.25, back_u_date_str_h);
                  lab12_sizeok.setCellFeatures(cellFeatures_bksize);
                  sheet.addCell(lab12_sizeok);
                  sheet.addCell(lab19_sizeok);
              }
          }

    // back up size node B
          
          int bckp_startb=0,bckup_endb=0;
          for (String st : apgfile)
          {
              if (st.startsWith(" Directory of ") && (st.endsWith("nodeB") || st.endsWith("Nodeb") || st.endsWith("NodeB")) )
              {
            	  bckp_startb = apgfile.indexOf(st);
            	  bckp_startb = bckp_startb + 4;
                  break;
              }
          }

          for (String st : apgfile)
          {
              if (st.endsWith("burverify -d"))
              {
                  bckup_endb = apgfile.indexOf(st);
                  bckup_endb= bckup_endb - 4;
                  break;
              }
          }

          int sub_bkupb= bckup_endb-bckp_startb+1;
          float b_d_s_b[] = new float[10];
          
          for(int k=0; k<sub_bkupb; k++)
          {
        	  String bk_up_date_strb = apgfile.get(bckp_startb+k);
        	  
        	  String back_u_date_strb[] = bk_up_date_strb.replaceAll("\\s+", " ").split(" ");

//              String bk_date_str1b[] = bk_up_date_strb.split("  ");
//
//              String bc_ub=bk_date_str1b[3];
//              String back_u_date_strb[] = bc_ub.split(" ");
              
              float back_intb = Float.parseFloat(back_u_date_strb[3].replaceAll(",",""));

              b_d_s_b[k]=(float)(Math.round(back_intb/1024/1024/1024*100.0f)/100.0f);
              String str15b = Float.toString(b_d_s_b[k]);
              int i = k+1;
              
              if(b_d_s_b[k]>1.00)
              {
            	  Label lab19_sizeb = new Label(1, 17+k+sub_bkupb, "Warning", yellow);
            	  Label lab12_sizeb = new Label(2, 17+k+sub_bkupb, "Backup image of node B is "+str15b);
            	  Label lab19_sizewab = new Label(3, 17+k+sub_bkupb, "Restoration Not possible");
            	  
            	  double back_u_date_strb_h = back_u_date_strb[4].split(System.getProperty("line.separator")).length;
            	  
            	  WritableCellFeatures cellFeatures_bksizeb = new WritableCellFeatures();
            	  cellFeatures_bksizeb.setComment(back_u_date_strb[4], 1.25, back_u_date_strb_h);
            	  lab12_sizeb.setCellFeatures(cellFeatures_bksizeb);
            	  sheet.addCell(lab12_sizeb);
            	  sheet.addCell(lab19_sizeb);
            	  sheet.addCell(lab19_sizewab);
            	  
            	  Label size_act = new Label(4, 17+k+sub_bkupb, "AP SYSTEM ANALYSIS, AP, System Backup and Verify, Initiate", va_c);
                  sheet.addCell(size_act);
              }
              else
              { 
            	  Label lab19_sizeokb = new Label(1, 17+k+sub_bkupb, "OK", green);
                  Label lab12_sizeokb = new Label(2, 17+k+sub_bkupb, "Backup image of node B is "+str15b, yellow);

                  double back_u_date_strb_h = back_u_date_strb[4].split(System.getProperty("line.separator")).length;
                  
                  WritableCellFeatures cellFeatures_bksizeb = new WritableCellFeatures();
                  cellFeatures_bksizeb.setComment(back_u_date_strb[4], 1.25, back_u_date_strb_h);
                  lab12_sizeokb.setCellFeatures(cellFeatures_bksizeb);
                  sheet.addCell(lab12_sizeokb);
                  sheet.addCell(lab19_sizeokb);
              }
              row_index = 17 + k + sub_bkupb;
          }

          sheet.mergeCells(0, 17, 0, row_index);

//===== 
    // burverify
       
       row_index++;  
       int b_ver=0;
       for (String st : apgfile)
       {
           if (st.startsWith("Imagename:"))
           {
        	   b_ver = apgfile.indexOf(st)+3;
               break;
           }
       }
       
       String b_ver_str = apgfile.get(b_ver);
       if(b_ver_str.startsWith("Status:    OK"))
       {
    	   Label sw_veri_lab = new Label(1, row_index, "OK", green);
    	   sheet.addCell(sw_veri_lab);
       }
       else
       { 
    	   Label sw_veri_lab = new Label(1, row_index, "Warning", yellow);
    	   sheet.addCell(sw_veri_lab);

    	   String ver_err = apgfile.get(b_ver)+"\n"+apgfile.get(b_ver-1)+"\n"+apgfile.get(b_ver-2)+"\n"+apgfile.get(b_ver-3);

    	   double ver_err_h = ver_err.split(System.getProperty("line.separator")).length;
        	   
    	   Label ver_st = new Label(2, row_index, "Backup image is not OK", va_c);
    	   WritableCellFeatures ver_cmt = new WritableCellFeatures();
    	   ver_cmt.setComment(ver_err, 2, ver_err_h);
    	   ver_st.setCellFeatures(ver_cmt);
    	   sheet.addCell(ver_st);
    	   
    	   Label ver_act = new Label(4, row_index, "Follow OPI AP, System Backup and Verify, Initiate", va_c);
    	   sheet.addCell(ver_act);
       }
       
       /*String bac_ver = apgfile.get(veri_b);
       String lastWord = bac_ver.substring(bac_ver.lastIndexOf(" ")+1);

       if(lastWord.equals("OK."))
       { 
    	   Label sw_veri_lab = new Label(1, row_index, "OK", green);
    	   sheet.addCell(sw_veri_lab);
       }
       else
       { 
    	   Label sw_veri_lab = new Label(1, row_index, "Warning", yellow);
    	   sheet.addCell(sw_veri_lab);

    	   Label sw_veri_lab1 = new Label(2, row_index, apgfile.get(veri_b), va_c);
    	   sheet.addCell(sw_veri_lab1);
       }
*/       
       Label bkv_l = new Label(0, row_index, "Verify the backup", ca_b);
 	   sheet.addCell(bkv_l);

//---	   
   //--- ALAN 
 	   
 	   row_index++;
 	   
 	   Label aln_0 = new Label(0, row_index, "Faults from Audit", ca_b);
	   sheet.addCell(aln_0);

	   int alan_err_st = row_index;
	   
   // alan error
	   
 	   int err_s=0, err_e=0;
 	   for(String st : alanfile)
 	   {
 		   if(st.contains(">>>"))
 		   {
 			   err_s = alanfile.indexOf(st)+1;
 		   }
 		   if(st.startsWith("Warnings"))
 		   {
 			   err_e = alanfile.indexOf(st)-1;
 		   }
 	   }
		
 	   String err_val = "";
 	   int alan_j=0;
 	   for(int i=err_s; i<=err_e; i++)
 	   {
 		   if(alanfile.get(i).startsWith(">>>") || alanfile.get(i).startsWith("*"))
 		   {
 			   Label aln_err_ok = new Label(1, row_index+alan_j, "Error", yellow);
			   sheet.addCell(aln_err_ok);
 			   
 			   Label aln_err = new Label(2, row_index+alan_j, err_val, va_c);
 			   sheet.addCell(aln_err);
 			   alan_j++; 
 			   err_val="";
 		   }
 		   else
 		   {
 			   err_val+=alanfile.get(i)+"\n";
 		   }
 	   }
 	   
 	   row_index = row_index+alan_j-1; // end for alan error
 	   
   // alan warning
 	   
 	   row_index++;
 	   int warn_h=0, warn_e=0;
 	   for(String st : alanfile)
 	   {
		   if(st.startsWith("Warnings"))
		   {
			   warn_h = alanfile.indexOf(st);
		   }
		   if(st.startsWith("*"))
		   {
			   warn_e = alanfile.lastIndexOf(st); 
		   }
	   }
 	  
 	   int warn_s=0;
 	   for(int i=warn_h; i<=warn_e; i++)
 	   {
 		   if(alanfile.get(i).startsWith(">>>"))
 		   {
 			   warn_s = i;
 			   break;
 		   }
 	   }

 	   String warn_val = "";
	   int alan_k=0;
	   
	   for(int i=warn_s+1; i<=warn_e; i++)
	   {
		   if(alanfile.get(i).startsWith(">>>") || alanfile.get(i).startsWith("*"))
		   {
			   Label aln_warn_ok = new Label(1, row_index+alan_k, "Warning", yellow);
			   sheet.addCell(aln_warn_ok);
 			   
 			   Label aln_warn = new Label(2, row_index+alan_k, warn_val, va_c);
 			   sheet.addCell(aln_warn);
 			   alan_k++; 
 			   warn_val="";
		   }
		   else
		   {
			   warn_val+=alanfile.get(i)+"\n";
		   }
	   }
	   
	   row_index = row_index+alan_k-1;
	   int alan_warn_st = row_index;
	   
	   sheet.mergeCells(0, alan_err_st, 0, alan_warn_st);
	   
//---
   // APZ
 	   
 	   row_index = row_index + 2;
 	   	   
 	   Label label14 = new Label(0, row_index, "APZ HW/SW status", node);
 	   sheet.addCell(label14);

//-----
   // APZ alarm 	   
 	   
 	   row_index++;
 	   Label apz_alm = new Label(0, row_index, "Basic Alarm List analysis", ca_b);
 	   sheet.addCell(apz_alm);
     	
 	// A1
 	   int apz_A1_s = 0;
 	   for (String apz : apgfile) 
 	   {
 		   if (apz.contains("allip:alcat=apz,acl=a1;")) 
 		   {
 			   apz_A1_s = apgfile.indexOf(apz);
 			   apz_A1_s = apz_A1_s + 3;
 			   break;
 		   }
 	   }
    	
//A2     
 	   int apz_A1_e=0, apz_A2_s = 0;
 	   for (String apz : apgfile) 
 	   {
 		   if (apz.contains("allip:alcat=apz,acl=a2;")) 
 		   {
 			   apz_A2_s = apgfile.indexOf(apz);
 			   apz_A1_e = apz_A2_s - 2;
 			   apz_A2_s = apz_A2_s + 3;
 			   break;
 		   }
 	   }
    	
//A3     
 	   int apz_A2_e=0, apz_A3_s = 0;
 	   for (String apz : apgfile) 
 	   {
 		   if (apz.contains("allip:alcat=apz,acl=a3;")) 
 		   {
 			   apz_A3_s = apgfile.indexOf(apz);
 			   apz_A2_e = apz_A3_s - 2;
 			   apz_A3_s = apz_A3_s + 3;
 			   break;
 		   }
 	   }
    	
//ACL_O1
    	
 	   int apz_A3_e=0, apz_ACL_01_s=0;
 	   for (String apz : apgfile) 
 	   {
 		   if (apz.contains("allip:alcat=apz,acl=o1;")) 
 		   {
 			   apz_ACL_01_s = apgfile.indexOf(apz);
 			   apz_A3_e = apz_ACL_01_s - 2;
 			   apz_ACL_01_s = apz_ACL_01_s + 3;
 			   break;
 		   }
 	   }
    	
//ACL_O2
    	
 	   int apz_ACL_01_e=0, apz_ACL_02_s = 0;
 	   for (String apz : apgfile) 
 	   {
 		   if (apz.contains("allip:alcat=apz,acl=o2;")) 
 		   {
 			   apz_ACL_02_s = apgfile.indexOf(apz);
 			   apz_ACL_01_e = apz_ACL_02_s - 2;
 			   apz_ACL_02_s = apz_ACL_02_s + 3;
 			   break;
 		   }
 	   }
    	
// syrip:survey;
    	
    	int apz_ACL_02_e=0;
    	for (String apz : apgfile) 
    	{
    		if (apz.contains("syrip:survey;")) 
    		{
    			apz_ACL_02_e = apgfile.indexOf(apz)-2;
    			break;
    		}
    	}
    	
//A1 count
    	String A1_APZ_val = null;
    	int A1_APZ_count = 0;
    	for(int i=apz_A1_s; i<=apz_A1_e; i++)
    	{
    		A1_APZ_val = apgfile.get(i);
    		if(A1_APZ_val.contains("A1/APZ"))
    		{
    			A1_APZ_count++;
    		}
    		else
    		{}
    	}
    	
//A2 count       	
    	String A2_APZ_val = null;
    	int A2_APZ_count = 0;
    	for(int i=apz_A2_s; i<=apz_A2_e; i++)
    	{
    		A2_APZ_val = apgfile.get(i);
    		if(A2_APZ_val.contains("A2/APZ"))
    		{
    			A2_APZ_count++;
    		}
    		else
    		{}
    		
    	}
    	
//A3 count       	
    	String A3_APZ_val = null;
    	int A3_APZ_count = 0;
    	for(int i=apz_A3_s; i<=apz_A3_e; i++)
    	{
    		A3_APZ_val = apgfile.get(i);
    		if(A3_APZ_val.contains("A3/APZ"))
    		{
    			A3_APZ_count++;
    		}
    		else
    		{}
    	}
    	
    	
//ACL_01 count  
    	String ACL_01_APZ_val = null;
    	int ACL_01_APZ_count = 0;
    	for(int i=apz_ACL_01_s; i<=apz_ACL_01_e; i++)
    	{
    		ACL_01_APZ_val = apgfile.get(i);
    		if(ACL_01_APZ_val.contains("O1/APZ"))
    		{
    			ACL_01_APZ_count++;
    		}
    		else
    		{}
    	}
    	
//ACL_02 count  
    	String ACL_02_APZ_val = null;
    	int ACL_02_APZ_count = 0;
    	for(int i=apz_ACL_02_s; i<=apz_ACL_02_e; i++)
    	{
    		ACL_02_APZ_val = apgfile.get(i);
    		if(ACL_02_APZ_val.contains("O2/APZ"))
    		{
    			ACL_02_APZ_count++;
    		}
    		else
    		{}
    		
    	}
    	
    	if(A1_APZ_count+A2_APZ_count+A3_APZ_count+ACL_01_APZ_count+ACL_02_APZ_count >0)
    	{
    		Label alarm_ok = new Label(1, row_index, "Warning", yellow);
    		sheet.addCell(alarm_ok);
    		
    		
    		Label alarm_sev = new Label(5, row_index, "Warning", yellow);
    		sheet.addCell(alarm_sev);
    		
    		
    		String apz_com = "Number of alarms found: " + "\n" + "A1/APZ:	" + A1_APZ_count + "\n" + "A2/APZ:	" + A2_APZ_count
    						+ "\n" + "A3/APZ:	" + A3_APZ_count + "\n" + "01/APZ:	" + ACL_01_APZ_count + "\n" + "02/APZ:	" + ACL_02_APZ_count;            	

    		
    		double apz_com_h = apz_com.split(System.getProperty("line.separator")).length;
    		
    		Label alarm_details = new Label(2, row_index, "Alarms present", va_c);
    		WritableCellFeatures cellFeatures_apz = new WritableCellFeatures();
    		cellFeatures_apz.setComment(apz_com, 1, apz_com_h);
    		alarm_details.setCellFeatures(cellFeatures_apz);
    		sheet.addCell(alarm_details);
    	}
    	else
    	{
    		Label alarm_ok = new Label(1, row_index, "OK", green);
    		sheet.addCell(alarm_ok);
    	}
 	   
//------
    // syrip     
 	   row_index++;
 	   Label label15 = new Label(0, row_index, "Software Recovery Information analysis", ca_b);
 	   sheet.addCell(label15);
 	   
 	   int syrip_start=0, syrip_end=0;
 	   for (String st : apgfile) 
 	   {
 		   if (st.contains("EVENT CODE   INF1   INF2   INF3   INF4   SIDE STATE  DATE   TIME ACTIVE")) 
 		   {
 			   syrip_start = apgfile.indexOf(st)+1; // down portion 1st line
 			   
//            	   int fd = st.indexOf(st, syrip_start);
//            	   System.out.println("fd " + fd);
//            	   System.out.println("fd \n" + apgfile.get(fd));
//            	   syrip_start++; 
                   break;
 		   }
 	   }

 	   for (String st : apgfile) 
 	   {
 		   if (st.contains("<dircp;"))  
 		   {
 			   syrip_end = apgfile.indexOf(st)-7; // down portion last line
 			   break;
 		   }
 	   }

 	   int syrip_cmp_abv=0;
 	   for (String st : apgfile) 
 	   {
 		   if (st.contains("EVENT TYPE          EXPLANATION                         EVENTCNT  FRDEL")) 
 		   {
 			   syrip_cmp_abv = apgfile.indexOf(st);
 			   syrip_cmp_abv++; // up portion 1st line
 			   break;
 		   }
 	   }
           
 	   int syrip_cmp_ind = syrip_start-3; // up portion last line 
 	   
 	   String c1 = "";
 	   for(int i=syrip_start; i<=syrip_end; i++) // i=down portion 1st line, i<=down portion last line  
 	   {
 		   String syrip_str = apgfile.get(i); // down portion values
 		   
 		   if(syrip_str.endsWith("NO"))
 		   {
//        		   Label label16 = new Label(1, row_index, "OK", green);
//                 sheet.addCell(label16);
 		   }
 		   else
 		   {
 			   String a = syrip_str.substring(3, 6); // event number for which is yes
 			   
 			   for(int j=syrip_cmp_abv; j<=syrip_cmp_ind; j++) // j=up portion 1st line; j<=up last
 			   {
 				   String syrip_str_cmp = apgfile.get(j); // up portion all values
 				   
 				   String b = syrip_str_cmp.substring(3, 6);
 				   
 				   String c = null;
        			   
 				   if(a.equals(b))
 				   {
 					   c = syrip_str_cmp.substring(0);
 					   
 					   c1+=c + "\n";
 					   
 					   String c1_hr = "EVENT TYPE          EXPLANATION                         EVENTCNT  FRDEL \n";
 					   
 					   Label label16 = new Label(1, row_index, "Warning", yellow);
 					   sheet.addCell(label16);
 					   
 					   double c1_h = c1.split(System.getProperty("line.separator")).length
 					   			   + c1_hr.split(System.getProperty("line.separator")).length;
 					   
 					   Label label17 = new Label(2, row_index, "Active events present", va_c);
 					   WritableCellFeatures cellFeatures_act = new WritableCellFeatures();
 					   cellFeatures_act.setComment(c1_hr+c1, 2, c1_h);
 					   label17.setCellFeatures(cellFeatures_act);
 					   sheet.addCell(label17);
 				   }
 				   else
 				   {}
 			   }
 			   Label label16 = new Label(1, row_index, "Warning", yellow);
 			   sheet.addCell(label16);
 		   }
        	   
 		   if(syrip_str.equals("NO"))
 		   {
 			   Label label16 = new Label(1, row_index, "OK", green);
 			   sheet.addCell(label16);
 		   }
 	   }
           
 //============ chk
/*           String syrip_str = null;
           String tmp = "";
           String tmp_0 = "";
           
           for(int i=syrip_start; i<=syrip_end; i++ ) // i=down portion 1st line, i<=down portion last line  
           {
        	   syrip_str = apgfile.get(i); // down portion values
//        	   tmp+=syrip_str+"\n";
        	   tmp = syrip_str.substring(3, 6); // event number for which is yes
        	   tmp+="\n";
//        	   tmp_0+=a+"\n";
           }
           
           String syrip_str_cmp = null;
           String tmp_1 = "";
           String str_2 = "";
           
           for(int j=syrip_cmp_abv; j<=syrip_cmp_ind; j++) // j=up portion 1st line; j<=up last
		   {
			   syrip_str_cmp = apgfile.get(j); // up portion all values
			   str_2 = syrip_str_cmp + "\n";
			   tmp_1 = syrip_str_cmp.substring(3, 6);
			   tmp_1+="\n";
//			   tmp_1+=a+"\n";
		   }
           
        	   if(syrip_str.endsWith("NO"))
        	   {
        		   Label label16 = new Label(1, 41, "OK", green);
                   sheet.addCell(label16);
        	   }
        	   else
        	   {
        		   
        		   
        		   for(int j=syrip_cmp_abv; j<=syrip_cmp_ind; j++) // j=up portion 1st line; j<=up last
        		   {
        			   String syrip_str_cmp = apgfile.get(j); // up portion all values
        			   
//        			   System.out.println("up" + syrip_str_cmp);
        			   
        			   String b = syrip_str_cmp.substring(3, 6);
        			   
//        			   System.out.println(b);
        			   
        			   if(a.equals(b))
        			   {
        				   String c = syrip_str_cmp.substring(0);
//        				   System.out.println(c); // entire line of above if it matches
        				   
        				   Label label16 = new Label(1, 41, "warning", yellow);
                           sheet.addCell(label16);
        				   
                           Label label17 = new Label(2, 41, "Active events present");
                           
                           cellFeatures.setComment(c);
                           label17.setCellFeatures(cellFeatures);
                           sheet.addCell(label17);
        			   }
        			   else
        			   {}
        		   }
        		   Label label16 = new Label(1, 41, "warning");
                   sheet.addCell(label16);
        	   }
           }*/

//=========
     // dircp      
           
           row_index++;
/*           Label cp_label = new Label(0, row_index, "CP Event Record analysis", ca_b);
           sheet.addCell(cp_label);
           
           CP_event cp_e = new CP_event();
           
           ArrayList<String> cp_events = cp_e.getList();
           
           for(String cp_str:cp_events)
           {   
//        	   System.out.println("HI "+ cp_str);

        	   String str = "";
        	   str+=cp_str + "\n";
        	   
        	   System.out.println("HI" + str);

        	   if(str.equals(""))
        	   {
        		   Label cp_ok = new Label(1, row_index, "OK", va_c);
            	   sheet.addCell(cp_ok);
        	   }
        	   else
        	   {
            	   Label cp_ok = new Label(1, row_index, "Warning", va_c);
            	   sheet.addCell(cp_ok);
        	   
            	   double cp_err_h = str.split(System.getProperty("line.separator")).length;

            	   Label lck_obs = new Label(2, row_index, "CP events present", va_c);
            	   WritableCellFeatures cellFeatures_lckc = new WritableCellFeatures();
            	   cellFeatures_lckc.setComment(str, 3, cp_err_h);
            	   lck_obs.setCellFeatures(cellFeatures_lckc);
            	   sheet.addCell(lck_obs);
        	   }
           }
*/           
           
//====
           
   /*// <dirrp:rp=all;
         // ER WORKING      
           
           row_index++;
           int rp_start=0;
           for (String st : apgfile) 
           {
        	   if (st.contains("EVENT DATE   TIME    REASON     ETYPE  INF1    INF2")) 
               {
        		   rp_start = apgfile.indexOf(st);
        		   rp_start++;
        		   break;
               }
           }
           
           int syfdp_1=0, syfdp_2=0, syfdp_3=0, syfdp_s=0;
           int rp_end = 0;
           
           for (String st : apgfile) 
           {
        	   if (st.contains("<syfdp;")) 
        	   {
        		   rp_end = apgfile.indexOf(st);
        		   rp_end--;
        		   
        		   syfdp_1 = apgfile.indexOf(st);
        		   syfdp_s = syfdp_1 + 1;
        		   syfdp_1 = syfdp_1 + 4; // SUPERVISION OF LONG DURATION FOR ACTIVE FORLOPPS
        		   syfdp_2 = syfdp_1 + 9; // CONTINUOUS SUPERVISION
        		   syfdp_3 = syfdp_1 + 15;
        		   break;
        	   }
           }
           
           String rp_val_str = null;
           String rp_val_tmp = "";
           for(int i=rp_start; i<=rp_end; i++)
           {
        	   if(apgfile.get(i).contains("ERWORKING"))
        	   {
        		   rp_val_str = apgfile.get(i);
        	   }
        	   else
        	   {
        		   
        	   }
           }
           
           Label rp_label = new Label(0, row_index, "RP Event Record analysis", ca_b);
           sheet.addCell(rp_label);
           
           Label rp_label_1 = new Label(1, row_index, "OK/Cancel", green);
           sheet.addCell(rp_label_1);
           
           Label rp_label_2 = new Label(2, row_index, "RP Events", va_c);
           
           WritableCellFeatures cellFeatures_rp = new WritableCellFeatures();
           cellFeatures_rp.setComment(" ");
           rp_label_2.setCellFeatures(cellFeatures_rp);
           sheet.addCell(rp_label_2);

*/
 
//====== <dirrp:rp=all;
     // ER WORKING
           
           row_index++;
           int rp_start=0;
           for (String st : apgfile) 
           {
        	   if (st.contains("EVENT DATE   TIME    REASON     ETYPE  INF1    INF2")) 
               {
        		   rp_start = apgfile.indexOf(st);
        		   rp_start++;
        		   break;
               }
           }
           
           int syfdp_1=0, syfdp_2=0, syfdp_3=0, syfdp_s=0;
           int rp_end = 0;
           
           for (String st : apgfile) 
           {
        	   if (st.contains("<syfdp;")) 
        	   {
        		   rp_end = apgfile.indexOf(st);
        		   rp_end--;
        		   
        		   syfdp_1 = apgfile.indexOf(st);
        		   syfdp_s = syfdp_1 + 1;
        		   syfdp_1 = syfdp_1 + 4; // SUPERVISION OF LONG DURATION FOR ACTIVE FORLOPPS
        		   syfdp_2 = syfdp_1 + 9; // CONTINUOUS SUPERVISION
        		   syfdp_3 = syfdp_1 + 15;
        		   break;
        	   }
           }
           
           	
           int counter = 0;
           int counter1 = 0;
          
           for(String p:apgfile)
           {
        	   if(p.trim().equals("RP    TYPE      INTERFACE"))
        	   {
        		   for(int i = counter;i<apgfile.size();i++)
        		   {
        			   if(apgfile.get(i).trim().equals("END"))
        			   {
        				   counter1 = i;
        				   break;
        			   }
        		   }
        		   break;
        	   }
        	   counter++;
           }
           String rav="";
           for(int i=counter;i<counter1;i++)
           {
        	   if(apgfile.get(i).trim().equals("RP    TYPE      INTERFACE"))
        	   {
        		   rav+=",";
        	   }
        	   else
        	   {
        		   if(!apgfile.get(i).trim().equals(""))
        			   rav+=apgfile.get(i)+"$";
        	   }
           }

           StringTokenizer s = new StringTokenizer(rav,",");
           
           String er_wrk_val = null;
           String er_wrk_tmp = "";
           while(s.hasMoreElements())
           {
        	   StringTokenizer s1 = new StringTokenizer(s.nextElement().toString(),"$");
        	   String temp1 = s1.nextToken();
        	   while(s1.hasMoreElements())
        	   {
        		   String temp = s1.nextElement().toString();
        		   if(temp.contains("ERWORKING"))
        		   {
        			   er_wrk_val = " RP    TYPE      INTERFACE \n" + temp1+ "\n" + "EVENT DATE   TIME   EM REASON    ETYPE INF1   INF2   INF3   INF4 \n" + temp + "\n\n";
        			   er_wrk_tmp+=er_wrk_val;
        			   
        			   Label rp_label_1 = new Label(1, row_index, "Warning", yellow);
        			   sheet.addCell(rp_label_1);
        			   
        			   double er_wrk_tmp_h = er_wrk_tmp.split(System.getProperty("line.separator")).length;
        			   
        			   Label rp_label_2 = new Label(2, row_index, "RP Events present", va_c);
        	           WritableCellFeatures cellFeatures_rp = new WritableCellFeatures();
        	           cellFeatures_rp.setComment(er_wrk_tmp, 2, er_wrk_tmp_h);
        	           rp_label_2.setCellFeatures(cellFeatures_rp);
        	           sheet.addCell(rp_label_2);
        		   }
        		   else
        		   {
        			   Label rp_label_1 = new Label(1, row_index, "OK", green);
        			   sheet.addCell(rp_label_1);
        		   }
        	   }
           }
           
           Label rp_label = new Label(0, row_index, "RP Event Record analysis", ca_b);
           sheet.addCell(rp_label);
           
//==== syfdp and syfsp
           row_index++;
           Label label17 = new Label(0, row_index, "Forlopp Handling check", ca_b);
           sheet.addCell(label17);
           
   //==== syfsp

           int syfsp_1=0, syfsp_2=0, syfsp_3=0, syfsp_4=0;
           for (String st : apgfile) 
           {
               if (st.contains("<syfsp;")) 
               {
            	   syfsp_1 = apgfile.indexOf(st);
            	   syfsp_1 = syfsp_1 + 4;  // FORLOPP HANDLING
            	   syfsp_2 = syfsp_1 + 7;  // FORLOPP EXECUTION CONTROL FUNCTION (ECF) 
            	   syfsp_3 = syfsp_1 + 10; // FORLOPP ERROR FUNCTION (FLERROR)
            	   syfsp_4 = syfsp_1 + 13; // FORLOPP MODE   SUBMODE        LIMIT
                   break;
               }
           }
           
           int syfsp_e = 0;
           for (String st : apgfile) 
           {
               if (st.contains("<syrap;")) 
               {
            	   syfsp_e = apgfile.indexOf(st) - 1;
                   break;
               }
           }
           
           String syfdp_val = null;
           String syfdp_tmp = "";
           
           for(int i=syfdp_s; i<=syfsp_e; i++)
           {
        	   syfdp_val = apgfile.get(i);
        	   syfdp_tmp+=syfdp_val + "\n";
           }
           
           
           if(apgfile.get(syfdp_1).equals("PASSIVE") && apgfile.get(syfdp_2).equals("ACTIVE") && apgfile.get(syfdp_3).equals("PASSIVE")
        		   && apgfile.get(syfsp_1).equals("ACTIVE") && apgfile.get(syfsp_2).equals("OFF") && apgfile.get(syfsp_3).equals("ON") 
        		   && apgfile.get(syfsp_4).equals("OPERATION      REDUCED LOAD   NO LIMIT"))
           {
        	   Label label18 = new Label(1, row_index, "OK", green);
               sheet.addCell(label18);
           }
           else
           {
        	   Label label18 = new Label(1, row_index, "warning", yellow);
               sheet.addCell(label18);
               
               double syfdp_tmp_h = syfdp_tmp.split(System.getProperty("line.separator")).length;
               
               Label actpas = new Label(2, row_index, "", va_c);
               WritableCellFeatures cellFea_w = new WritableCellFeatures();
               cellFea_w.setComment(syfdp_tmp, 2, syfdp_tmp_h);
               actpas.setCellFeatures(cellFea_w);
               sheet.addCell(actpas);
           }
           
//==========
      // syrap
           
           row_index++;
           int syrap_cmp=0, syrap_0=0, syrap_1=0, syrap_2=0, syrap_3=0, syrap_4=0;
           for (String st : apgfile) 
           {
               if (st.contains("<syrap;")) 
               {
            	   syrap_1 = apgfile.indexOf(st);
            	   
            	   syrap_cmp = syrap_1 + 1;
            	   
            	   syrap_0 = syrap_1 + 4;  // FORLOPP RELEASE
            	   syrap_2 = syrap_1 + 7;  // SELECTIVE RESTART 
            	   syrap_3 = syrap_1 + 10; // SELECTIVE RESTART TYPE
            	   syrap_4 = syrap_1 + 13; // SIGNALLING ERRORS
                   break;
               }
           }
           Label syrap_lab = new Label(0, row_index, "System Recovery Setting check", ca_b);
           sheet.addCell(syrap_lab);
           
           if(apgfile.get(syrap_0).equals("ACTIVE") && apgfile.get(syrap_2).equals("ACTIVE") && apgfile.get(syrap_3).equals("SMALLDELAYED") && apgfile.get(syrap_4).equals("ACTIVE"))
           {
        	   Label label20 = new Label(1, row_index, "OK", green);
               sheet.addCell(label20);
           }
           else
           {
        	   Label label20 = new Label(1, row_index, "warning", yellow);
               sheet.addCell(label20);
               
               int dpwsp=0;
               for (String st : apgfile) 
               {
                   if (st.contains("<dpwsp;")) 
                   {
                	   dpwsp = apgfile.indexOf(st);
                	   dpwsp = dpwsp-2;  
                       break;
                   }
               }
               
               String syp = null;
               String syp_tmp = "";
               for(int i=syrap_cmp; i<=dpwsp; i++)
               {
            	   syp = apgfile.get(i);
            	   syp_tmp+=syp+"\n";
            	   
                   Label syp_lab = new Label(2, row_index, syp.toString());
                   sheet.addCell(syp_lab);
               }
               
               double syp_tmp_h = syp_tmp.split(System.getProperty("line.separator")).length;
               
               Label syrap_warn = new Label(2, row_index, "Not correct", va_c); 
               WritableCellFeatures cellFeatures_syrap = new WritableCellFeatures();
               cellFeatures_syrap.setComment(syp_tmp, 2, syp_tmp_h);
               syrap_warn.setCellFeatures(cellFeatures_syrap);
               sheet.addCell(syrap_warn);
           }
           
//============= dpwsp
           
           row_index++;
           Label cp_test = new Label(0, row_index, "Central Processor Test functionality check", ca_b);
           sheet.addCell(cp_test);
           
           int dpwsp=0, dpwsp_1=0;
           
           for (String st : apgfile) 
           {
               if (st.contains("MAU  SB SBSTATE      RPH-A       RPH-B       BUA STATE")) 
               {
            	   dpwsp = apgfile.indexOf(st);
            	   dpwsp_1 = dpwsp+1; 
            	   dpwsp++;  
                   break;
               }
           }
           
           String dpwsp_str = apgfile.get(dpwsp);
           String dpwsp_1_str = apgfile.get(dpwsp_1);
           
           String dpwsp_fn = dpwsp_str + "\n" + dpwsp_1_str;
           
           if ( dpwsp_str.equals("NRM  B  WO           -           -                   1") )
           {
        	   Label dpwsp_lab = new Label(1, row_index, "OK", green);
               sheet.addCell(dpwsp_lab);
           }
           else
           {
        	   Label dpwsp_lab = new Label(1, row_index, "warning", yellow);
               sheet.addCell(dpwsp_lab);
               
               double dpwsp_fn_h = dpwsp_fn.split(System.getProperty("line.separator")).length;
               
               Label dpwsp_1_lab = new Label(2, row_index, "CP state not correct", va_c);
               WritableCellFeatures cellFeatures_dp = new WritableCellFeatures();
               cellFeatures_dp.setComment(dpwsp_fn, 2, dpwsp_fn_h);
               dpwsp_1_lab.setCellFeatures(cellFeatures_dp);
               sheet.addCell(dpwsp_1_lab);
           }
         
//======  ptwsp
           
           int ptwsp=0;
           for (String st : apgfile) 
           {
               if (st.contains("CPT MESSAGE CP STATE")) 
               {
            	   ptwsp = apgfile.indexOf(st);
            	   ptwsp = ptwsp+2;  
                   break;
               }
           }
           
           String ptwsp_str = apgfile.get(ptwsp);
           
           if(ptwsp_str.equals("CP-A EX CP-B SBWO CON B: PHC:PAS"))
           {
        	   Label ptwsp_lab = new Label(1, row_index, "OK", green);
        	   sheet.addCell(ptwsp_lab);
        	   
        	   Label ptwsp_lab_1 = new Label(2, row_index, ptwsp_str, va_c);
        	   sheet.addCell(ptwsp_lab_1);
           }
           else
           {
        	   Label ptwsp_lab = new Label(1, row_index, "warning", yellow);
        	   sheet.addCell(ptwsp_lab);
        	   
        	   Label ptwsp_lab_1 = new Label(2, row_index, ptwsp_str, va_c);
        	   sheet.addCell(ptwsp_lab_1);
           }
           
//=============== plldp
           
           row_index++;
           Label ptwsp_lab_1 = new Label(0, row_index, "Check Processor load", ca_b);
    	   sheet.addCell(ptwsp_lab_1);
           
           int plldp_start=0, plldp_end=0, plsvp=0;
           
           for (String st : apgfile) 
           {
               if (st.contains("<plldp;")) 
               {
            	   plldp_start = apgfile.indexOf(st);
            	   plldp_start++;  
                   break;
               }
           }
           
           for (String st : apgfile) 
           {
               if (st.contains("<plsvp;")) 
               {
            	   plldp_end = apgfile.indexOf(st);
            	   plldp_end--;  

            	   plsvp = apgfile.indexOf(st);
                   break;
               }
           }
           
           String plldp_str = null;
           String plldp_tmp = "";
           
           for(int i=plldp_start; i<=plldp_end; i++)
           {
        	   plldp_str = apgfile.get(i);
        	   plldp_tmp+=plldp_str + "\n";
        	   
           }
           Label plldp_lab0 = new Label(1, row_index, "OK", green);
    	   sheet.addCell(plldp_lab0);
    	   
    	   double plldp_tmp_h = plldp_tmp.split(System.getProperty("line.separator")).length;
    	   
           Label plldp_lab1 = new Label(2, row_index, "", va_c);
    	   WritableCellFeatures cellFeatures_pl = new WritableCellFeatures();
    	   cellFeatures_pl.setComment(plldp_tmp, 2, plldp_tmp_h);
    	   plldp_lab1.setCellFeatures(cellFeatures_pl);
    	   sheet.addCell(plldp_lab1);

//==============
    	   
    	   row_index++;
           int plsvp_end=0, sybtp=0;
           for (String st : apgfile) 
           {
               if (st.contains("<sybtp;")) 
               {
            	   plsvp_end = apgfile.indexOf(st);
            	   sybtp = plsvp_end + 1; 
                   break;
               }
           }
           
           String plsvpse = null;
           String temp = "";
           
           Label plsvp_lab0 = new Label(0, row_index, "Processor Load Supervision Data check", ca_b);
    	   sheet.addCell(plsvp_lab0);
           
           for (int i = plsvp; i<=plsvp_end-2; i++) 
           {
               plsvpse = apgfile.get(i);
               temp+=plsvpse+"\n";
           }
           
           if(temp.contains("NO DATA LOADED"))
           {
        	   Label plsvp_lab1 = new Label(1, row_index, "warning", yellow);
        	   sheet.addCell(plsvp_lab1);
           
        	   Label pls_val2 = new Label(2, row_index, temp, va_c);
        	   
        	   double temp_h = temp.split(System.getProperty("line.separator")).length;
        	   
        	   WritableCellFeatures plsvp_cf = new WritableCellFeatures();
        	   plsvp_cf.setComment(temp, 1, temp_h/2);
        	   pls_val2.setCellFeatures(plsvp_cf);
        	   sheet.setRowView(row_index, 1200);
        	   sheet.addCell(pls_val2);
           }
           else
           {
        	   Label plsvp_lab1 = new Label(1, row_index, "OK", green);
        	   sheet.addCell(plsvp_lab1);
           }
           
//============
           row_index++;
           Label swcmp_lab = new Label(0, row_index, "Software Record comparison", ca_b); 
           sheet.addCell(swcmp_lab);
           	
           Label swcmp_lab1 = new Label(2, row_index, "Upload Tool", va_c); 
           sheet.addCell(swcmp_lab1);

//======= <sybtp;
           	
           row_index++;	
           int sybtp_end=0; 
           	
           for (String st : apgfile) 
           {
        	   if (st.contains("<sybfp:file;")) 
        	   {
        		   sybtp_end = apgfile.indexOf(st);
        		   sybtp_end = sybtp_end-3; 
        		   break;
                }
            }

            String sybtp_str = null;
            String sybtp_tmp = "";
            
            for(int i=sybtp+1; i<=sybtp_end; i++)
            {
            	sybtp_str = apgfile.get(i);
            	sybtp_tmp+=sybtp_str+"\n";
            	
            	Label sybtp_lab1 = new Label(1, row_index, "OK", green); 
               	sheet.addCell(sybtp_lab1);
               	
               	Label sybtp_lab2 = new Label(2, row_index, sybtp_str, va_c); 
               	sheet.addCell(sybtp_lab2);
            }
            
        	Label sybtp_label = new Label(2, row_index, sybtp_tmp ,va_c); 
        	sheet.addCell(sybtp_label);
            sheet.setRowView(row_index, 1400);
           	Label sysbackup = new Label(0, row_index, "System backup settings check", ca_b); 
           	sheet.addCell(sysbackup);
           	
//===============
           	// <sybfp:file;
           	
           	row_index++;
           	Label sybfp_label0 = new Label(0, row_index, "Check the date of the latest dump", ca_b); 
           	sheet.addCell(sybfp_label0);
           	
//===============
           	
//============= <lamip;
           	
           	row_index++;
           	
           	int lamip=0;
           	for (String st : apgfile) 
            {
                if (st.contains("<lamip;")) 
                {
                	lamip = apgfile.indexOf(st);
                    break;
                }
            }

           	Label lamip_lab = new Label(0, row_index, "Checksum the dump", ca_b); 
           	sheet.addCell(lamip_lab);
           	
           	Label lamip_lab_1 = new Label(1, row_index, "N/A", na); 
           	sheet.addCell(lamip_lab_1);
           	
//===============
           	
//=============== <OCINP:IPN=ALL;
           	row_index++;
           	Label OCINP_lab = new Label(0, row_index, "Check correct MW is loaded (212xx)", ca_b); 
           	sheet.addCell(OCINP_lab);
           	
//================ ipn
           	row_index++;
           	Label ipn_lab = new Label(0, row_index, "Check IPN links (only 2123x)", ca_b); 
           	sheet.addCell(ipn_lab);
           	
           	Label ipn_lab_1 = new Label(1, row_index, "N/A", na); 
           	sheet.addCell(ipn_lab_1);
  
//==========  <fcepp;
           	
           	row_index++;
           	Label fcepp_lab = new Label(0, row_index, "RP / CP function change state check", ca_b); 
           	sheet.addCell(fcepp_lab);
           	
           	int fcepp=0;
           	int fcepp_inc=0;
           	
           	for(String st : apgfile)
           	{
           		if(st.contains("<fcepp;"))
           		{
           			fcepp = apgfile.indexOf(st);
           			fcepp_inc = fcepp+4;
           			break;
           		}
           	}
           	
           	String fcepp_fch = apgfile.get(fcepp_inc);
           	
           	if(fcepp_fch.equals("NORM"))
           	{
           		Label fcepp_lab1 = new Label(1, row_index, "OK", green);
           		sheet.addCell(fcepp_lab1);
           	}
           	else
           	{
           		int fcepp_end=0;

           		for(String st : apgfile)
           		{
           		
           			if(st.contains("<SASTP:UNITS=MW;"))
           			{
           			fcepp_end = apgfile.indexOf(st);
           			fcepp_end--;
           			break;
           			}
           		}
           		
           		String fcepp_str = null;
           		String fcepp_tmp = "";
           	
           		for(int i=fcepp; i<fcepp_end; i++)
           		{
           			fcepp_str = apgfile.get(i);
           		
           			fcepp_tmp+=fcepp_str+"\n";
 
           			Label fcepp_lab1 = new Label(1, row_index, "warning", yellow); 
           			sheet.addCell(fcepp_lab1);
           		}
           		
           		double fcepp_tmp_h = fcepp_tmp.split(System.getProperty("line.separator")).length;
           		
           		Label fcepp_tmp_label = new Label(2, row_index, "FCH state is wrong", va_c); 
           		WritableCellFeatures cellFeatures_fc = new WritableCellFeatures();
           		cellFeatures_fc.setComment(fcepp_tmp, 2, fcepp_tmp_h);
           		fcepp_tmp_label.setCellFeatures(cellFeatures_fc);
           		sheet.addCell(fcepp_tmp_label);
           	}
           	
//========== <SASTP:UNITS=MW;
           	
           	row_index++;
           	int tca=0, tba=0, ps=0;
           	
           	for(String st : apgfile)
           	{
           		if(st.contains("TOTAL ALLOCATED AREAS"))
           		{
           			tca = apgfile.indexOf(st);
           			break;
           		}
           	}
           	String tca_str = apgfile.get(tca);
           	String tca_split[]  = tca_str.split(" ");
           	String tca_last_str = tca_split[tca_split.length - 1]; // last word
           	
           	int tca_int = Integer.parseInt(tca_last_str);
           	
           	for(String st : apgfile)
           	{
           		if(st.contains("TOTAL BACKUP AREA"))
           		{
           			tba = apgfile.indexOf(st);
           			break;
           		}
           	}
           	String tba_str = apgfile.get(tba);
           	String tba_split[] = tba_str.split(" ");
           	String tba_last_str = tba_split[tba_split.length-1];
           	
           	int tba_int = Integer.parseInt(tba_last_str);
           	
           	for(String st : apgfile)
           	{
           		if(st.contains("PHYSICAL STORE"))
           		{
           			ps = apgfile.indexOf(st);
           			break;
           		}
           	}
           	String ps_str = apgfile.get(ps);
           	String ps_split[] = ps_str.split(" ");
           	String ps_last_str = ps_split[ps_split.length-1];
           	
           	int ps_int = Integer.parseInt(ps_last_str);
           	float tca_tba_add = ( (tca_int + tba_int)*100 );

           	tca_tba_add = tca_tba_add/ps_int;
           	
           	String ds_str = Float.toString(tca_tba_add);

           	if(tca_tba_add >= 80.00)
           	{
           		Label sastp_lab1 = new Label(1, row_index, "Warning", yellow); 
               	sheet.addCell(sastp_lab1);
               	
               	int sastp_start=0;
               	
               	for(String st : apgfile)
               	{
               		if(st.contains("<SASTP:UNITS=MW;"))
               		{
               			sastp_start = apgfile.indexOf(st);
               			break;
               		}
               	}
               	
               	int sastp_end=0;
               	for(String st : apgfile)
               	{
               		if(st.contains("<labup;"))
               		{
               			sastp_end = apgfile.indexOf(st);
               			break;
               		}
               	}
               	
               	String sastp_cmp = null;
               	String sastp_val = "";
               	
               	for(int i=sastp_start; i<sastp_end; i++)
               	{
               		sastp_cmp = apgfile.get(i);
               		sastp_val+=sastp_cmp+"\n";
               	}
               	
               	double sastp_val_h = sastp_val.split(System.getProperty("line.separator")).length;
               	
               	Label sastp_1 = new Label(2, row_index, "DS utilization exceeded 80%" + "\n" + "DS utilization is " + ds_str, va_c);
               	WritableCellFeatures cellFeatures_ss = new WritableCellFeatures();
               	cellFeatures_ss.setComment(sastp_val, 2, sastp_val_h);
                sastp_1.setCellFeatures(cellFeatures_ss);
                sheet.addCell(sastp_1);
           	}
           	else
           	{
           		Label sastp_lab1 = new Label(1, row_index, "OK", green); 
               	sheet.addCell(sastp_lab1);
           	}
           	
           	Label sastp_lab = new Label(0, row_index, "Check Store Allocations", ca_b); 
           	sheet.addCell(sastp_lab);
           	
//========= <labup;
           	
           	row_index++;
           	int labup_start=0, labup_end=0, labup_start_val=0, labup_last_val=0;
           	
           	for(String st : apgfile)
           	{
           		if(st.startsWith("BANKTYPE") && st.contains("SIZE") && st.contains("NIU") && st.contains("MNIU") && st.endsWith("NCONG"))
           		{
           			labup_start = apgfile.indexOf(st);
           			break;
           		}
           	}
           	
           	for(String st : apgfile)
           	{
           		if(st.contains("pcorp:block=missra;"))
           		{
           			labup_end = apgfile.lastIndexOf(st)-3;
           			labup_last_val = apgfile.lastIndexOf(st);
           		}
           	}
           	
           	String labup_str = null;

           	for(int i=labup_start+1; i<=labup_end; i++)
           	{
           		labup_str = apgfile.get(i);
           		if(labup_str.endsWith("0"))
           		{
                   	Label labup_lab_1 = new Label(1, row_index, "OK", green); 
                   	sheet.addCell(labup_lab_1);
                   	
           		}
           		else
           		{
                   	Label labup_lab_1 = new Label(1, row_index, "Warning", yellow); 
                   	sheet.addCell(labup_lab_1);
                 
                   	for(String st : apgfile)
                   	{
                   		if(st.contains("<labup;"))
                   		{
                   			labup_start_val = apgfile.indexOf(st);
                   			break;
                   		}
                   	}
                   	
                   	String lab_val = null;
                   	String lab_tmp = "";
                   	
                   	for(int j=labup_start_val; j<=labup_last_val; j++)
                   	{
                   		lab_val = apgfile.get(j);
                   		lab_tmp+=lab_val+"\n";
                    }
                    
                   	double lab_tmp_h = lab_tmp.split(System.getProperty("line.separator")).length;
                   	
                    Label lab_warn = new Label(2, row_index, "Storage Bank congestion error!", va_c);
                    WritableCellFeatures cellFeatures_cg = new WritableCellFeatures();
                    cellFeatures_cg.setComment(lab_tmp, 2, lab_tmp_h);
                    lab_warn.setCellFeatures(cellFeatures_cg);
                    sheet.addCell(lab_warn);
           		}
           	}
           	
           	Label labup_lab = new Label(0, row_index, "Check Storage Bank congestion", ca_b); 
           	sheet.addCell(labup_lab);
           	
           	
//------- APT
           	
          row_index = row_index + 2;
          
          Label apt_s = new Label(0, row_index, "APT", node);
          sheet.addCell(apt_s);
           	
// =======    
      // <pcorp:block=missra;   
           	
           	row_index++;
           	int pcorp=0, ipa_val=0;
           	for (String apt : apgfile) 
            {
                if (apt.contains("pcorp")) 
                {
                    pcorp = apgfile.indexOf(apt);
                    ipa_val = pcorp + 9;
                    pcorp = pcorp + 14;
                    break;
                }
            }
           	
           	String rev = "R" + apgfile.get(pcorp).substring(4, 6) + "." + apgfile.get(pcorp).charAt(6); // R13.2
           	
           	String ipa_splt[] = apgfile.get(ipa_val).split(" ");
           	String ipa = ipa_splt[0].substring(0, 3); // IPA

           	String ipa_hex = ipa_splt[0].substring(3);
           	int iHex = Integer.parseInt(ipa_hex,16);
           	int ipa_bin =Integer.toBinaryString(iHex).length(); // binary value, and its length (7)
           	String ipa_bin_str = Integer.toString(ipa_bin);
           	
           	if(ipa_bin < 10)
           	{
           		ipa_bin_str = "0" +  ipa_bin;
           	}
           	
           	String sw_l_chk = rev + ", " + ipa + "-" + ipa_bin_str; // R13.2, IPA-07 

           	Label apt_status = new Label(0, row_index, "APT HW/SW status", ca_b);
           	sheet.addCell(apt_status);
           	
           	Label apt_ok = new Label(1, row_index, "OK", green);
           	sheet.addCell(apt_ok);

           	Label apt_sw_chk_obs = new Label(2, row_index, sw_l_chk, va_c);
           	sheet.addCell(apt_sw_chk_obs);

// EOS
           	row_index++;
           	Label eos = new Label(0, row_index, "End-Of-Support (EOS)", ca_b);
           	sheet.addCell(eos);
           	
// EOM
           	row_index++;
           	Label eom = new Label(0, row_index, "End-Of-Maintenance (EOM)", ca_b);
           	sheet.addCell(eom);
           	
//=====
    // Basic Alarm List analysis
           	row_index++;
           	Label apt_alm = new Label(0, row_index, "Basic Alarm List analysis", ca_b);
           	sheet.addCell(apt_alm);
           	
   // A1
           	int alm_A1_s = 0;
           	for (String apt : apgfile) 
            {
                if (apt.contains("<ALLIP:ALCAT=APT,ACL=A1;")) 
                {
                	alm_A1_s = apgfile.indexOf(apt);
                	alm_A1_s = alm_A1_s + 3;
                    break;
                }
            }
           	
   // A2     
           	int alm_A1_e=0, alm_A2_s = 0;
           	for (String apt : apgfile) 
            {
                if (apt.contains("<ALLIP:ALCAT=APT,ACL=A2;")) 
                {
                	alm_A2_s = apgfile.indexOf(apt);
                	alm_A1_e = alm_A2_s - 2;
                	alm_A2_s = alm_A2_s + 3;
                    break;
                }
            }
           	
   // A3     
           	int alm_A2_e=0, alm_A3_s = 0;
           	for (String apt : apgfile) 
            {
                if (apt.contains("<ALLIP:ALCAT=APT,ACL=A3;")) 
                {
                	alm_A3_s = apgfile.indexOf(apt);
                	alm_A2_e = alm_A3_s - 2;
                	alm_A3_s = alm_A3_s + 3;
                    break;
                }
            }
           	
   // ACL_O1
           	
           	int alm_A3_e=0, alm_ACL_01_s=0;
           	for (String apt : apgfile) 
            {
                if (apt.contains("<ALLIP:ALCAT=APT,ACL=O1;")) 
                {
                	alm_ACL_01_s = apgfile.indexOf(apt);
                	alm_A3_e = alm_ACL_01_s - 2;
                	alm_ACL_01_s = alm_ACL_01_s + 3;
                    break;
                }
            }
           	
   // ACL_O2
           	
           	int alm_ACL_01_e=0, alm_ACL_02_s = 0;
           	for (String apt : apgfile) 
            {
                if (apt.contains("<ALLIP:ALCAT=APT,ACL=O2;")) 
                {
                	alm_ACL_02_s = apgfile.indexOf(apt);
                	alm_ACL_01_e = alm_ACL_02_s - 2;
                	alm_ACL_02_s = alm_ACL_02_s + 3;
                    break;
                }
            }
           	
    // <gsstp;
           	
           	int alm_ACL_02_e=0, gsstp_s = 0;
           	for (String apt : apgfile) 
            {
                if (apt.contains("<gsstp;")) 
                {
                	gsstp_s = apgfile.indexOf(apt);
                	alm_ACL_02_e = gsstp_s - 2;
                	gsstp_s++;
                    break;
                }
            }
           	
           	
    // A1 count
           	String A1_val = null;
           	int A1_count = 0;
           	for(int i=alm_A1_s; i<=alm_A1_e; i++)
           	{
           		A1_val = apgfile.get(i);
           		if(A1_val.contains("A1/APT"))
           		{
           			A1_count++;
           		}
           		else
           		{}
           		
           	}
           	
    // A2 count       	
           	String A2_val = null;
           	int A2_count = 0;
           	for(int i=alm_A2_s; i<=alm_A2_e; i++)
           	{
           		A2_val = apgfile.get(i);
           		if(A2_val.contains("A2/APT"))
           		{
           			A2_count++;
           		}
           		else
           		{}
           		
           	}
           	
    // A3 count       	
           	String A3_val = null;
           	int A3_count = 0;
           	for(int i=alm_A3_s; i<=alm_A3_e; i++)
           	{
           		A3_val = apgfile.get(i);
           		if(A3_val.contains("A3/APT"))
           		{
           			A3_count++;
           		}
           		else
           		{}
           		
           	}
           	
           	
     // ACL_01 count  
           	String ACL_01_val = null;
           	int ACL_01_count = 0;
           	for(int i=alm_ACL_01_s; i<=alm_ACL_01_e; i++)
           	{
           		ACL_01_val = apgfile.get(i);
           		if(ACL_01_val.contains("O1/APT"))
           		{
           			ACL_01_count++;
           		}
           		else
           		{}
           	}
           	
     // ACL_02 count  
           	String ACL_02_val = null;
           	int ACL_02_count = 0;
           	for(int i=alm_ACL_02_s; i<=alm_ACL_02_e; i++)
           	{
           		ACL_02_val = apgfile.get(i);
           		if(ACL_02_val.contains("O2/APT"))
           		{
           			ACL_02_count++;
           		}
           		else
           		{}
           		
           	}
           	
           	if(A1_count+A2_count+A3_count+ACL_01_count+ACL_02_count >0)
           	{
           		Label alarm_ok = new Label(1, row_index, "Warning", yellow);
           		sheet.addCell(alarm_ok);
           		
           		
           		Label alarm_sev = new Label(5, row_index, "Warning", yellow);
           		sheet.addCell(alarm_sev);
           		
           		
           		String alm_com = "Number of alarms found: " + "\n" + "A1/APT:	" + A1_count + "\n" + "A2/APT:	" + A2_count
           						+ "\n" + "A3/APT:	" + A3_count + "\n" + "01/APT:	" + ACL_01_count + "\n" + "02/APT:	" + ACL_02_count;            	

           		
           		double alm_com_h = alm_com.split(System.getProperty("line.separator")).length;
           		
           		Label alarm_details = new Label(2, row_index, "Alarms present", va_c);
           		WritableCellFeatures cellFeatures_alm = new WritableCellFeatures();
           		cellFeatures_alm.setComment(alm_com, 1, alm_com_h);
           		alarm_details.setCellFeatures(cellFeatures_alm);
           		sheet.addCell(alarm_details);
           	}
           	else
           	{
           		Label alarm_ok = new Label(1, row_index, "OK", green);
           		sheet.addCell(alarm_ok);
           	}
           	
//----------
     // <gsstp;
           	
           	row_index++;
           	
           	if(apgfile.get(gsstp_s).equals("NOT ACCEPTED"))
           	{
           		Label gss_warn = new Label(1, row_index, "Warning", yellow);
           		sheet.addCell(gss_warn);
           		
           		String gss_er = null;
           		gss_er=apgfile.get(gsstp_s)+"\n"+apgfile.get(gsstp_s+1)+"\n"+apgfile.get(gsstp_s+2)+"\n";
           		
           		Label gss_os = new Label(2, row_index, gss_er, va_c);
           		sheet.addCell(gss_os);
           		
           		int gss_er_h = gss_er.split(System.getProperty("line.separator")).length;
           		sheet.setRowView(row_index, gss_er_h);
           	}
           	else
           	{
               	int clm_s1=0, clm_e1=0, spm_s=0, spm_e=0;
               	for(String st : apgfile)
               	{
               		if(st.contains("UNIT       STATE  BLSTATE   VARIANT   STATUS"))
               		{
               			clm_s1 = apgfile.indexOf(st);
               			clm_s1 = clm_s1 + 2;
               			break;
               		}
               	}
               	
               	for(String st : apgfile)
               	{
               		if(st.contains("UNIT       STATE  BLSTATE   VARIANT  UNIT       STATE  BLSTATE"))
               		{
               			spm_s = apgfile.indexOf(st);
               			clm_e1 = spm_s - 2;
               			spm_s = spm_s + 3;
               			break;
               		}
               	}
               	
               	for(String st : apgfile)
               	{
               		if(st.contains("<gdstp;"))
               		{
               			spm_e = apgfile.indexOf(st);
               			spm_e = spm_e - 3;
               			break;
               		}
               	}
               	
               	String spm_header = "", clm_header1 = "";

               	String spm_spl[] = null; 
               	String spm_val = null, clm_val1 = null;
               	
               	double clm_header1_h = 0.0;
               	
               	for(int i=clm_s1; i<=clm_e1; i++) // for CLM
               	{
               		
//               		String clm_spl1[] = apgfile.get(i).split("      ");
               		
               		String clm_spl1[] = apgfile.get(i).replaceAll("\\s+", " ").split(" ");
               		
               		if( clm_spl1[1].equals("WO")) 
               		{
               			Label gss = new Label(1, row_index, "OK", green);
               			sheet.addCell(gss);
               		}
               		else
               		{
               			Label gss = new Label(1, row_index, "Warning", yellow);
               			sheet.addCell(gss);
               				
               			clm_val1 = apgfile.get(i);	

               			clm_header1 = "UNIT       STATE  BLSTATE   VARIANT   STATUS" + "\n";
               			clm_header1+=clm_val1; // CLM values
               			
               			clm_header1_h = clm_header1.split(System.getProperty("line.separator")).length;
               		}
               	}
               		
               	for(int j=spm_s; j<=spm_e; j++) // for spm
               	{
//               		spm_spl = apgfile.get(j).split("     ");
               		
               		spm_spl = apgfile.get(j).replaceAll("\\s+", "").split(" ");
               		
//               		if( apgfile.get(j).endsWith("WO") && spm_spl[1].equals("WO") )
               		
               		if( spm_spl[1].equals("WO") && spm_spl[4].equals("WO") )
               		{}
               		else
               		{
               			spm_val = apgfile.get(j);
               			spm_header = "UNIT       STATE  BLSTATE   VARIANT  UNIT       STATE  BLSTATE" + "\n";
               			spm_header+=spm_val+"\n";
               			
               			String gsstp_values = clm_header1 + spm_header ;
               			
               			double spm_header_h = spm_header.split(System.getProperty("line.separator")).length;
               			
               			Label gss_obs = new Label(2, row_index, "", va_c);
               			WritableCellFeatures cellFeatures_65 = new WritableCellFeatures();
               			cellFeatures_65.setComment(gsstp_values, 2, clm_header1_h+spm_header_h);
               			gss_obs.setCellFeatures(cellFeatures_65);
               			sheet.addCell(gss_obs);
               		}
               	}
           	}
           	
           	Label gss_1 = new Label(0, row_index, "Group Switch Check", ca_b);
           	sheet.addCell(gss_1);
//----------
      // <gdstp;     	
           	
//           	int gdstp_na=0;
           	int gdstp_s=0;
           	
           	for(String st : apgfile)
           	{
           		if(st.contains("<gdstp;"))
           		{
           			gdstp_s = apgfile.indexOf(st);
           			break;
           		}
           	}
           	
           	if( apgfile.get(gdstp_s+1).equals("NOT ACCEPTED") )
           	{
           		Label gds_warn = new Label(1, row_index, "Warning", yellow);
           		sheet.addCell(gds_warn);
           		
           		String gds_er = null;
           		gds_er=apgfile.get(gdstp_s+1)+"\n"+apgfile.get(gdstp_s+2)+"\n"+apgfile.get(gdstp_s+3)+"\n";
           		
           		Label gss_os = new Label(2, row_index, gds_er, va_c);
           		sheet.addCell(gss_os);
           		
           		sheet.setRowView(row_index, 1800);
           	}
           	else
           	{
           		int clm_s=0, clm_e=0, xm_s=0, xm_e=0;
           		clm_s = apgfile.indexOf("UNIT         STATE  BLSTATE  VAR  STATUS");
           		clm_s = clm_s + 2;
           		
           		xm_s = apgfile.indexOf("UNIT         STATE  BLSTATE  VAR    UNIT         STATE  BLSTATE");
           		clm_e = xm_s - 2;
           		xm_s = xm_s + 2;
           		
           		String xm_header = "";
           		String clm_header = "";
           		
           		String clm_spl[] = null;
           		
           		for(String st : apgfile)
           		{
           			if(st.equals("<caclp;"))
           			{
           				xm_e = apgfile.indexOf(st);
           				xm_e = xm_e - 4;
           				break;
           			}
           		}
           		
           		String xm_spl[] = null; 
           		String xm_val = null;
           		String clm_val = null;
           		
           		double clm_header_h = 0.0;

           		for(int i=clm_s; i<=clm_e; i++)
           		{

//           		clm_spl = apgfile.get(i).split("        ");
           			
           			clm_spl = apgfile.get(i).replaceAll("\\s+", " ").split(" ");
           			
           			if( clm_spl[1].equals("WO")) 
           			{}
           			else
           			{
           				clm_val = apgfile.get(i);

           				clm_header = "UNIT         STATE  BLSTATE  VAR  STATUS" + "\n";
           				clm_header+=clm_val;
           				
           				clm_header_h = clm_header.split(System.getProperty("line.separator")).length;
           			}
           		}
           		
//           		for(int x=0;x<5;x++)
//           		{
//           		    CellView cell = sheet.getColumnView(x);
//           		    cell.setAutosize(true);
//           		    sheet.setColumnView(x, cell);
//           		}
           		
           		for(int j=xm_s; j<=xm_e; j++) // for xm
   				{
//   					xm_spl = apgfile.get(j).split("     ");
   					
   					xm_spl = apgfile.get(j).replaceAll("\\s+", " ").split(" ");
   	           		
//   					if( apgfile.get(j).endsWith("WO") && xm_spl[1].equals("WO") )
   					
   					if( xm_spl[1].equals("WO") && xm_spl[4].equals("WO"))
   	           		{}
   	           		else
   	           		{
   	           			xm_val = apgfile.get(j);
   	           			xm_header = "UNIT         STATE  BLSTATE  VAR    UNIT         STATE  BLSTATE" + "\n";
   	           			xm_header+=xm_val+"\n";
   	           			
   	           			String gdstp_values = clm_header + xm_header;
   	           			
   	           			double xm_header_h = xm_header.split(System.getProperty("line.separator")).length;
   	           			
   	           			Label gsc_obs = new Label(2, row_index, "", va_c);
   	           			WritableCellFeatures cellFeatures_64 = new WritableCellFeatures();
   	           			cellFeatures_64.setComment(gdstp_values, 2, clm_header_h + xm_header_h);
   	           			gsc_obs.setCellFeatures(cellFeatures_64);
   	           			sheet.addCell(gsc_obs);
   	           		}
   				}
           		
           		if(clm_header.equals("UNIT         STATE  BLSTATE  VAR  STATUS" + "\n")
           				&& xm_header.equals("UNIT         STATE  BLSTATE  VAR    UNIT         STATE  BLSTATE" + "\n"))
           		{
           			Label dgss = new Label(1, row_index, "OK", green);
       				sheet.addCell(dgss);
           		}
           		else
           		{
           			Label dgss = new Label(1, row_index, "Warning", yellow);
       				sheet.addCell(dgss);
           		}
           	}

           	Label grp_swt = new Label(0, row_index, "Distributed Group Switch Check", ca_b);
           	sheet.addCell(grp_swt);
           	
//-------           	
         //---  	
           	/*int clm_s=0, clm_e=0, xm_s=0, xm_e=0;
//           	if(apgfile.get(gsstp_s).equals("NOT ACCEPTED"))
           	{
           		clm_s = apgfile.indexOf("UNIT         STATE  BLSTATE  VAR  STATUS");
           		clm_s = clm_s + 2;
           		
           		xm_s = apgfile.indexOf("UNIT         STATE  BLSTATE  VAR    UNIT         STATE  BLSTATE");
           		clm_e = xm_s - 2;
           		xm_s = xm_s + 2;
           		
           		String xm_header = "";
           		String clm_header = "";
           		
           		String clm_spl[] = null;
           		for(String st : apgfile)
           		{
           			if(st.equals("GROUP SWITCH STATE"))
           			{
           				xm_e = apgfile.indexOf(st);
           				xm_e = xm_e - 5;
           				break;
           			}
           		}
           		String xm_spl[] = null; 
           		String xm_val = null;
           		String clm_val = null;

           		for(int i=clm_s; i<=clm_e; i++)
           		{
           			clm_spl = apgfile.get(i).split("        ");
           			
           			if( clm_spl[1].equals("WO")) 
           			{
           				Label dgss = new Label(1, row_index, "OK", green);
           				sheet.addCell(dgss);
           			}
           			else
           			{
           				Label dgss = new Label(1, row_index, "Warning", yellow);
           				sheet.addCell(dgss);
           				
           				clm_val = apgfile.get(i);

           				clm_header = "UNIT         STATE  BLSTATE  VAR  STATUS" + "\n";
           				clm_header+=clm_val;
           				
           				double clm_header_h = clm_header.split(System.getProperty("line.separator")).length;
           				
           				Label gsc_obs = new Label(2, row_index, "", va_c);
           				WritableCellFeatures cellFeatures_64 = new WritableCellFeatures();
           	            cellFeatures_64.setComment(clm_header, 2, clm_header_h);
           	            gsc_obs.setCellFeatures(cellFeatures_64);
           				sheet.addCell(gsc_obs);
           			}
           		}
           		
           		for(int j=xm_s; j<=xm_e; j++) // for xm
   				{
   					xm_spl = apgfile.get(j).split("     ");
   	           		
   					if( apgfile.get(j).endsWith("WO") && xm_spl[1].equals("WO") )
   	           		{}
   	           		else
   	           		{
   	           			xm_val = apgfile.get(j);
   	           			xm_header = "UNIT         STATE  BLSTATE  VAR    UNIT         STATE  BLSTATE" + "\n";
   	           			xm_header+=xm_val+"\n";
   	           		}
   				}
           	}*/
           	
           	
//----------
    // <GSStp;
    // GROUP SWITCH STATE       	
           	
 /*          	row_index++;
           	int clm_s1=0, clm_e1=0, spm_s=0, spm_e=0;
           	for(String st : apgfile)
           	{
           		if(st.contains("UNIT       STATE  BLSTATE   VARIANT   STATUS"))
           		{
           			clm_s1 = apgfile.indexOf(st);
           			clm_s1 = clm_s1 + 2;
           			break;
           		}
           	}
           	
           	for(String st : apgfile)
           	{
           		if(st.contains("UNIT       STATE  BLSTATE   VARIANT  UNIT       STATE  BLSTATE"))
           		{
           			spm_s = apgfile.indexOf(st);
           			clm_e1 = spm_s - 2;
           			spm_s = spm_s + 3;
           			break;
           		}
           	}
           	
           	for(String st : apgfile)
           	{
           		if(st.contains("<GDStp;"))
           		{
           			spm_e = apgfile.indexOf(st);
           			spm_e = spm_e - 3;
           			break;
           		}
           	}
           	
           	String spm_header = "", clm_header1 = "";

           	for(String st : apgfile)
           	{
           		if(st.equals("<GDStp;"))
           		{
           			spm_e = apgfile.lastIndexOf(st);
           			spm_e = spm_e - 3;
           			break;
           		}
           	}
           	String spm_spl[] = null; 
           	String spm_val = null, clm_val1 = null;
           	
           	
           	for(int i=clm_s1; i<=clm_e1; i++)
           	{
           			String clm_spl1[] = apgfile.get(i).split("      ");
           			System.out.println("chk " + clm_spl1[0]);
           			
           			if( clm_spl1[1].equals("WO")) 
           			{
           				Label gss = new Label(1, row_index, "OK", green);
           				sheet.addCell(gss);
           			}
           			else
           			{
           				Label gss = new Label(1, row_index, "Warning", yellow);
           				sheet.addCell(gss);
           				
           				clm_val1 = apgfile.get(i);

           				clm_header1 = "UNIT       STATE  BLSTATE   VARIANT   STATUS" + "\n";
           				clm_header1+=clm_val1;
           				
           				double clm_header1_h = clm_header1.split(System.getProperty("line.separator")).length;
           				
           				Label gss_obs = new Label(2, row_index, "", va_c);
           				WritableCellFeatures cellFeatures_65 = new WritableCellFeatures();
           	            cellFeatures_65.setComment(clm_header1, 2, clm_header1_h);
           	            gss_obs.setCellFeatures(cellFeatures_65);
           				sheet.addCell(gss_obs);
           			}
           		}
           		
           		for(int j=spm_s; j<=spm_e; j++) // for xm
   				{
   					spm_spl = apgfile.get(j).split("     ");
   	           		
   					if( apgfile.get(j).endsWith("WO") && spm_spl[1].equals("WO") )
   	           		{}
   	           		else
   	           		{
   	           			spm_val = apgfile.get(j);
   	           			spm_header = "UNIT       STATE  BLSTATE   VARIANT  UNIT       STATE  BLSTATE" + "\n";
   	           			spm_header+=spm_val+"\n";
   	           		}
   				}
           		
           	Label gss_1 = new Label(0, row_index, "Group Switch Check", ca_b);
           	sheet.addCell(gss_1);*/
           	
//----------
    /*// bck
           	
            int bckp_start=0,bckup_end=0; 
            for (String st : apgfile)
            {
            	if (st.startsWith(" Directory of M:") && st.endsWith("nodeA") )
            	{
            		bckp_start = apgfile.indexOf(st);
           			bckp_start = bckp_start + 4;
           			String b_up_date_str = apgfile.get(bckp_start);
            		break;
            	}
            }
           
            for (String st : apgfile)
            {
            	if (st.startsWith("M:") && st.endsWith("cd .."))
            	{
            		bckup_end = apgfile.indexOf(st);
            		bckup_end= bckup_end - 4;
            		String bk_u_date_str = apgfile.get(bckup_end);
            		break;
            	}
            }
          
            	int sub_bkup= bckup_end-bckp_start+1;
            	float b_d_s[] = new float[10];
            	
            	for(int j=0; j<sub_bkup; j++)
            	{
            	String bk_up_date_str = apgfile.get(bckp_start+j); 
            	String bk_date_str1[] = bk_up_date_str.split("  ");
            	String bc_u=bk_date_str1[5];
            	String back_u_date_str[] = bc_u.split(" ");
            	float back_int= Float.parseFloat(back_u_date_str[0].replaceAll(",",""));  
            		
            	b_d_s[j]=(float)(Math.round(back_int/1024/1024/1024*100.0f)/100.0f);
//            	System.out.println("Backup " + j + "is " +b_d_s[j]+ "gb"  );
            	}*/
            	
//------- 
            	
            	/*int indloc1,warnloc,indloc2; //for gathering index locations
             	int j=0;
             	
             	String[] Warnlist=new String[100];
             	
             	//warnloc has "Warnings" heading location
               	warnloc=logtostring.indexOf("********************************************************************************\n\n\nWarnings\n********************************************************************************",0)+171;
             	
               	//indloc1 has first location of ">>>" after Warning heading
             	indloc1=logtostring.indexOf(">>>",warnloc);
             	
             	while(indloc1<=logtostring.length())
             	{
             		if(indloc1==-1)
             			System.out.println("No Warnings Found");
             		else
             		{
             			
             			//indloc2 has next location of ">>>" after indloc1
             			indloc2=logtostring.indexOf(">>>",indloc1+3);
             			
             			if(indloc2==-1)
             			{
             				Warnlist[j++]=logtostring.substring(indloc1+2,(logtostring.length()-83));
                 			System.out.println(Warnlist[j-1]);
                 			
             			}
             			Warnlist[j++]=logtostring.substring(indloc1+1,indloc2);
             			indloc1=indloc2+3;
             			Label warn_l = new Label(2, 75, Warnlist[j-1]);
             			sheet.addCell(warn_l);
             			
             		}
             	}
             	
                int indloc_1=0,indloc_2=0,warnloc_1=0,errorloc;	//for gathering index locations
                int k=0;
              
                String[] ErrorList=new String[50];
               
              
                //errorloc has "Errors" heading location
                errorloc=logtostring.indexOf("********************************************************************************\n\n\nErrors\n********************************************************************************",0)+171;
               //indloc1 has first position of ">>>" after Error heading. 
                indloc_1=logtostring.indexOf(">>>",errorloc);
               
              //warnloc has "Warnings" heading location
                warnloc_1=logtostring.indexOf("********************************************************************************\n\n\nWarnings\n********************************************************************************",0);
                while(indloc_1<=warnloc_1)
                {
             	   if(indloc_1==-1)
             	       	System.out.println("No Errors Found");
             	   		       	   
             	   else
             	   		{	
             		   		//indloc2 has next location of ">>>" after indloc1
             	   			indloc_2=logtostring.indexOf(">>>",indloc_1+3);
             	   			if(indloc_2>warnloc_1)
             	   			{	
             	   				ErrorList[k++]=logtostring.substring(indloc_1+2,warnloc_1);
             	   				System.out.println(ErrorList[k-1]);
             	   				break;
             	   			}
             	   			ErrorList[k++]=logtostring.substring(indloc_1+2,indloc_2);
             	   			indloc_1=indloc_2+3;
             	   			System.out.println(ErrorList[k-1]);
             	   			
             	   		}
                }
 */         
           	
           	
//======= <caclp;
           	
           	row_index++;
           	int caclp_s=0, caclp_e=0, caclp_d=0;
            for (String st : apgfile)
            {
            	if (st.contains("<caclp;"))
            	{
            		caclp_s = apgfile.indexOf(st);
            		caclp_d = caclp_s + 5;
            		caclp_s = caclp_s + 12;
            		break;
            	}
            }
            
//            String ca_d[] = apgfile.get(caclp_d).split("  ");
            
            String ca_d[] = apgfile.get(caclp_d).replaceAll("\\s+", " ").split(" ");
            
            String ca_t = ca_d[1].trim();
            
            String d = "20" + ca_d[0].substring(0, 2) + "/" + ca_d[0].substring(2, 4) + "/" + ca_d[0].substring(4, 6);
            String t = ca_t.substring(0, 2) + ":" + ca_t.substring(2, 4) + ":" + ca_t.substring(4, 6);

            Label caclp_l = new Label(0, row_index, "System clock and synchronization check", ca_b);
            sheet.addCell(caclp_l);
            
    // <nsstp;
   
            int nsstp=0, nsstp_e=0;
            for (String st : apgfile)
            {
            	if (st.contains("<nsstp;"))
            	{
            		nsstp = apgfile.indexOf(st);
            		caclp_e = nsstp - 4;
            		break;
            	}
            }
            
            int mgepp=0;
            for (String st : apgfile)
            {
            	if (st.contains("<mgepp:id=all;"))
            	{
            		mgepp = apgfile.indexOf(st);
            		nsstp_e = mgepp - 2;
            		break;
            	}
            }
            
            String nsstp_val = null;
            String nsstp_tmp = "";
            for(int i=nsstp; i>=nsstp_e; i++)
            {
            	nsstp_val = apgfile.get(i);
            	nsstp_tmp+=nsstp_val + "\n";
            }
            
            String caclp_c = null;
            String caclp_t = "RC      DEV     STATE" + "\n";
            
            for(int i=caclp_s; i<=caclp_e; i++)
            {
            	caclp_c = apgfile.get(i);
            	if(caclp_c.endsWith("NOT CONNECTED"))
            	{}
            	else
            	{
            		caclp_t+=caclp_c +"\n";
            		String new_chk = caclp_t + "\n" + nsstp_tmp;
            		
            		double caclp_t_h = new_chk.split(System.getProperty("line.separator")).length;
            		
            		Label caclp_cm = new Label(2, row_index, d + ", " + t, va_c);
            		WritableCellFeatures cellFeatures = new WritableCellFeatures();
            		cellFeatures.setComment(caclp_t + "\n" + nsstp_tmp, 2, caclp_t_h);
            		caclp_cm.setCellFeatures(cellFeatures);
            		sheet.addCell(caclp_cm);
            	}
            }
            
            ArrayList<String> caclp_arr = new ArrayList<String>();
            caclp_arr.add(caclp_t);
//            System.out.println(caclp_arr);
            
            for(String st : caclp_arr)
            {
            	if(st.contains("NOT CONNECTED"))
            	{
            		Label ca_ok = new Label(1, row_index, "OK", green);
            		sheet.addCell(ca_ok);
            	}
            	else
            	{
            		Label ca_ok = new Label(1, row_index, "Warning", yellow);
            		sheet.addCell(ca_ok);
            	}
            }
//            Label ca_l = new Label(0, row_index, "System clock and synchronization check", va_c);
//    		sheet.addCell(ca_l);
    		
//-------
    		row_index++;
    		Label expc = new Label(0, row_index, "Exchange Properties check", ca_b);
    		sheet.addCell(expc);    		
    		
//-------
    		row_index++;
    		
    		Label src = new Label(0, row_index, "Software Record comparison", ca_b);
    		sheet.addCell(src);
    		
//------- 
    		row_index++;
    		
    		Label c7 = new Label(0, row_index, "C7 Signalling Link audit", ca_b);
    		sheet.addCell(c7);
    		
//------- dbtsp
    		
    		row_index++;
    		
    		Label saa = new Label(0, row_index, "Size Alterations actions, faults", ca_b);
    		sheet.addCell(saa);
    		
    		int dbtsp=0, dbtsp_e=0;
            for (String st : apgfile)
            {
            	if (st.contains("<dbtsp:tab=saactions;"))
            	{
            		dbtsp = apgfile.indexOf(st);
            		dbtsp = dbtsp + 4;
            		break;
            	}
            }
    		
            int exrrp_s=0;
            for (String st : apgfile)
            {
            	if (st.contains("<exrpp:rp=all;"))
            	{
            		dbtsp_e = apgfile.indexOf(st);
            		exrrp_s = dbtsp_e + 4;
            		dbtsp_e = dbtsp_e - 2;
            		break;
            	}
            }
            
            String dbtsp_val = null;
            String dbtsp_tmp = "";
            for(int i=dbtsp+1; i<dbtsp_e; i++)
            {
            	dbtsp_val = apgfile.get(i);
            	
            	if(dbtsp_val == null)
            	{}
            	else
            	{
            		String dbtsp_h = "DATABASE TABLE \n\n BLOCK   TAB             TABLE                           WRAPPED \n " +
            				"SAFTAB1 SAACTIONS                                       YES\n";
            		dbtsp_tmp+=dbtsp_val +"\n";
            		
            		double dbtsp_tmp_h = dbtsp_h.split(System.getProperty("line.separator")).length + dbtsp_tmp.split(System.getProperty("line.separator")).length;
            		
            		Label saa_ok = new Label(2, row_index, "", va_c);
            		WritableCellFeatures saa_cmt = new WritableCellFeatures();
            		saa_cmt.setComment(dbtsp_h + dbtsp_tmp, 2, dbtsp_tmp_h);
            		saa_ok.setCellFeatures(saa_cmt);
            		sheet.addCell(saa_ok);
            	}
            	
            }
            
            ArrayList<String> saa_arr = new ArrayList<String>();
            saa_arr.add(dbtsp_tmp);
            
            for(String st : saa_arr)
            {
            	if(st == null)
            	{
            		Label saa_ok = new Label(1, row_index, "OK", green);
            		sheet.addCell(saa_ok);
            	}
            	else
            	{
            		Label saa_ok = new Label(1, row_index, "Warning", yellow);
            		sheet.addCell(saa_ok);
            	}
            }
            
//-------
     // <exrpp:rp=all;
            
            row_index++;
            int exrpp_e = 0, exemp_s=0;
            for (String st : apgfile)
            {
            	if (st.contains("<EXEMP:RP=ALL,EM=ALL;"))
            	{
            		exrpp_e = apgfile.indexOf(st);
            		exemp_s = exrpp_e + 4;
            		exrpp_e = exrpp_e - 3;
            		break;
            	}
            }
            
            String exrpp_val = null;
            String exrpp_tmp = "";
            
            for(int i=exrrp_s; i<=exrpp_e; i++)
            {
            	exrpp_val = apgfile.get(i).trim();
            	String ex_spl[] = exrpp_val.split(" ");
//            	System.out.println(ex_spl[2]);
            	
            	if(ex_spl[2].equals("WO"))
            	{
            		Label exx_ok = new Label(1, row_index, "OK", green);
            		sheet.addCell(exx_ok);
            	}
            	else
            	{	
            		Label exx_ok = new Label(1, row_index, "Warning", yellow);
            		sheet.addCell(exx_ok);
            		
            		exrpp_tmp+=exrpp_val + "\n";
            		String exrpp_h = "RP    STATE  TYPE     TWIN  STATE   DS     MAINT.STATE \n";
            		
            		double exrpp_tmp_h = exrpp_tmp.split(System.getProperty("line.separator")).length;
            		
            		Label exrpp_2 = new Label(2, row_index, "", va_c);
            		WritableCellFeatures exrpp_cmt = new WritableCellFeatures();
            		exrpp_cmt.setComment(exrpp_h+exrpp_tmp, 3, exrpp_tmp_h);
            		sheet.addCell(exrpp_2);
            	}
            }
            Label exx_l = new Label(0, row_index, "Check the state of all RP's", ca_b);
    		sheet.addCell(exx_l);
    		
//-------
     // <EXEMP:RP=ALL,EM=ALL;	
    		
    		row_index++;
    		int exemp_e=0, ntstp_s=0;
    		for(String st : apgfile)
    		{
    			if(st.contains("<ntstp:snt=all;"))
    			{
    				exemp_e = apgfile.indexOf(st);
    				ntstp_s = exemp_e + 4;
    				exemp_e = exemp_e - 4;
    				break;
    			}
    		}
    		
    		String exemp_val = null;
    		String exemp_tmp = "EM DATA" + "\n\n" + "RP    TYPE   EM  EQM                       TWIN  CNTRL  PP     STATE" + "\n";
    		for(int i=exemp_s; i<=exemp_e; i++)
    		{
    			exemp_val = apgfile.get(i);
    			
    			if(exemp_val.endsWith("WO"))
    			{
    				Label exe_ok = new Label(1, row_index, "OK", green);
            		sheet.addCell(exe_ok);
            	}
            	else
            	{	
            		Label exe_ok = new Label(1, row_index, "Warning", yellow);
            		sheet.addCell(exe_ok);
            		
    				exemp_tmp+=exemp_val + "\n";
    			}
    			
    			double exemp_tmp_h = exemp_tmp.split(System.getProperty("line.separator")).length;
    			
    			Label exemp_obs = new Label(2, row_index, "", va_c);
        		WritableCellFeatures exemp_cmt = new WritableCellFeatures();
        		exemp_cmt.setComment(exemp_tmp, 3, exemp_tmp_h);
        		sheet.addCell(exemp_obs);
    		}
    		
    		Label em_l = new Label(0, row_index, "Check the state of all EM's", ca_b);
    		sheet.addCell(em_l);
    		
//-------
    // <ntstp:snt=all;
    		
    		int snt_sub_f=0, snt_sub_n=0;
    		for(String st : apgfile)
   		 	{
    			if(st.contains("SNT                SUBSNT  STATE     BLS LST              FCODE"))
    			{
    				snt_sub_f = apgfile.indexOf(st);
    				snt_sub_n = snt_sub_f + 1;
    				snt_sub_f = snt_sub_f - 1;
   		         	break;
    			}
   		 	}
    		
    		String nt = null;
//    		String sol[] = null; 
    		String ntstp_val = null;
    		String ntstp_tmp = "";
    		String ntstp_h = "";
    		
    		for(int i=ntstp_s; i<=snt_sub_f; i++)
    		{
//    			sol = apgfile.get(i).split(" ");
//    			nt = apgfile.get(i);
//    			if(sol.equals("WO"))

//    			if(nt.substring(19, 21).equals("WO"))
    			
    			String nts_spl[] = apgfile.get(i).replaceAll("\\s+", " ").split(" ");
    			if(nts_spl[1].equals("WO"))
    			{}
    			else
    			{
    				ntstp_val = apgfile.get(i);
    				ntstp_h = "SWITCHING NETWORK TERMINAL STATE \n\n SNT                STATE       BLS   LST              FCODE \n";
    				ntstp_tmp+=ntstp_val + "\n"; 
    			}
    		}
    		ntstp_tmp = ntstp_h + ntstp_tmp; //take 1
    		
    		int snt_s=0;
    		for(String st : apgfile)
   		 	{
    			if(st.contains("SNT                STATE       BLS   LST              FCODE"))
    			{
    				snt_s = apgfile.lastIndexOf(st);
   		         	break;
    			}
   		 	}
    		
    		String snt_sub_1[] = null;
    		String snt_sub_val = null;
    		String snt_sub_h = "";
    		
    		for(int i=snt_sub_n; i<=snt_s-1; i++)
    		{
//    			snt_sub_1 = apgfile.get(i).split("                   ");
    			
    			snt_sub_1 = apgfile.get(i).replaceAll("\\s+", " ").split(" ");
    			
    			if(snt_sub_1[1].endsWith("WO"))
    			{}
    			else
    			{
    				String snt_val = apgfile.get(i);
    				
//    				ntstp_tmp+=ntstp_val + "\n"; 
    				
    				snt_sub_h = "SNT                SUBSNT  STATE     BLS LST              FCODE \n";
    				ntstp_tmp+=snt_val + "\n"; // take2
    				ntstp_tmp=snt_sub_h+ntstp_tmp; 
    			}
    		}
    		
    		int dtstp_s=0, snt_se =0;
    		for(String st : apgfile)
    		{
    			if(st.contains("<dtstp:dip=all;"))
    			{
    				dtstp_s = apgfile.indexOf(st);
    				dtstp_s = dtstp_s + 4;
    				snt_se = snt_se - 4;
   		         	break;
    			}
    		}
    		
    		String snt_s_val = null;
    		String snt_s_h = "";
    		
    		for(int i=snt_s; i<=snt_se; i++)
    		{
    			if(apgfile.get(i).equals("WO"))
    			{}
    			else
    			{
    				snt_s_h = "SNT                STATE       BLS   LST              FCODE \n";
    				snt_s_val+=snt_s_h + "\n"; 
    				ntstp_tmp+=snt_s_val; // take 3
    			}
    		}
    		
    		if(ntstp_tmp == "")
    		{
    			Label snt_ok = new Label(1, row_index, "OK", green);
    			sheet.addCell(snt_ok);
    		}
    		else
    		{
    			Label snt_ok = new Label(1, row_index, "Warning", yellow);
    			sheet.addCell(snt_ok);
    			
    			double ntstp_tmp_h = ntstp_tmp.split(System.getProperty("line.separator")).length;
    			
    			Label snt_l1 = new Label(2, row_index, "", va_c);
    			WritableCellFeatures snt_cmt = new WritableCellFeatures();
    			snt_cmt.setComment(ntstp_tmp, 2, ntstp_tmp_h);
    			snt_l1.setCellFeatures(snt_cmt);
    			sheet.addCell(snt_l1);
    		}
    		
    		Label snt_l = new Label(0, row_index, "Check the state of all SNTs", ca_b);
    		sheet.addCell(snt_l);
    
//------
    // <dtstp:dip=all;		
    		row_index++;
    		int dtstp_e=0, tpstp=0, tpstp_s=0;
    		for(String st : apgfile)
   		 	{
    			if(st.contains("<tpstp:sdip=all;"))
    			{
    				tpstp = apgfile.indexOf(st);
    				tpstp_s = tpstp + 4;
    				dtstp_e = tpstp - 3;
   		         	break;
    			}
   		 	}
    		
    		String dtstp_h = "";
    		String dtstp_val = null;
    		String dtstp_tmp = "";
    		
    		for(int i=dtstp_s; i<=dtstp_e; i++)
    		{
    			dtstp_val = apgfile.get(i).trim();
    			if(dtstp_val.endsWith("WO"))
    			{}
    			else
    			{
    				dtstp_h = apgfile.get(tpstp+1)+"\n"+apgfile.get(tpstp+2)+"\n"+apgfile.get(tpstp+3)+"\n";
    				dtstp_tmp+=dtstp_val + "\n";
    				
    				double dtstp_t_h = dtstp_h.split(System.getProperty("line.separator")).length + dtstp_tmp.split(System.getProperty("line.separator")).length;
    				
    				Label dtstp_obs = new Label(2, row_index, "", va_c);
    				WritableCellFeatures dtstp_cmt = new WritableCellFeatures();
    				dtstp_cmt.setComment(dtstp_h + dtstp_tmp, 2, dtstp_t_h);
    				dtstp_obs.setCellFeatures(dtstp_cmt);
    				sheet.addCell(dtstp_obs);
    			}
    		}

    		if(dtstp_tmp.equals(""))
    		{
    			Label dtstp_ok = new Label(1, row_index, "OK", green);
    			sheet.addCell(dtstp_ok);
    		}
    		else
    		{
    			Label dtstp_ok = new Label(1, row_index, "Warning", yellow);
    			sheet.addCell(dtstp_ok);
    		}

    		Label dip_l = new Label(0, row_index, "Check the state of all DIP's", ca_b);
    		sheet.addCell(dip_l);
    		
//-------
    // <tpstp:sdip=all;
    		
    		row_index++;
    		
    		int tpstp_m1=0, sdip=0;
    		for(String st : apgfile)
    		{
    			if(st.contains("SDIP     LAYER    LST            ERDIINFO"))
    			{
    				sdip = apgfile.indexOf(st);
    				tpstp_m1 = sdip - 3;
    				break;
    			}
    		}
    		
    		String tpstp_val = null;
    		String tpstp_tmp = "";
    		for(int i=tpstp_s; i<=tpstp_m1; i++)
    		{
    			tpstp_val = apgfile.get(i);
    			
    			if(tpstp_val.substring(27, 29).equals("WO"))
    			{}
    			else
    			{
    				tpstp_tmp+=apgfile.get(i) + "\n";
    				
    				double tpstp_tmp_h = tpstp_tmp.split(System.getProperty("line.separator")).length + dtstp_tmp.split(System.getProperty("line.separator")).length;
    				
    				Label tpstp_l = new Label(2, row_index, "", va_c);
    				WritableCellFeatures tpstp_cmt = new WritableCellFeatures();
    				tpstp_cmt.setComment(tpstp_tmp, 2, tpstp_tmp_h);
    				tpstp_l.setCellFeatures(tpstp_cmt);
    				sheet.addCell(tpstp_l);
    			}
    		}
    		
    		if(tpstp_tmp.equals(""))
    		{
    			Label tpstp_ok = new Label(1, row_index, "OK", green);
    			sheet.addCell(tpstp_ok);
    		}
    		else
    		{
    			Label tpstp_ok = new Label(1, row_index, "Warning", yellow);
    			sheet.addCell(tpstp_ok);
    		}
    		
    		Label tpstp_l = new Label(0, row_index, "Check the state of all SDIP's", ca_b);
			sheet.addCell(tpstp_l);

//-------    		
    // choip		
    		
    		row_index++;
    		
    		 int choip_apt=0, chopp_apt=0;
    		 for(String st : apgfile)
    		 {
    		     if(st.contains("<CHOIP;"))
    		     {
    		         choip_apt = apgfile.indexOf(st);
    		         choip_apt = choip_apt + 1;
    		         break;
    		     }
    		 }

    		 for(String st : apgfile)
    		 {
    		     if(st.contains("<CHOPP;"))
    		     {
    		         chopp_apt = apgfile.indexOf(st);
    		         chopp_apt=chopp_apt-2;
    		         break;
    		     }
    		 }
    		 
    		 String split_chopp[] = apgfile.get(chopp_apt+6).split(" ");
 
    		 String first_split = split_chopp[0];
    		 String chopp_str = null;
    		 String chopp_tmp = "";

    		 for(int i=choip_apt; i<=chopp_apt; i++)
    		 {
    			 chopp_str = apgfile.get(i);
    			 chopp_tmp+=chopp_str+"\n";
    		 }

    		 if (first_split.equals("OPEN"))
    		 {
    			 Label last_apt1= new Label(1, row_index, "OK", green);
    			 sheet.addCell(last_apt1);

    			 Label last_apt = new Label(2, row_index, "Connection is open", va_c);
    			 WritableCellFeatures cellFeatures = new WritableCellFeatures();
    			 cellFeatures.setComment(chopp_tmp);
    			 last_apt.setCellFeatures(cellFeatures);
    			 sheet.addCell(last_apt);
    		 }
    		 else
    		 { 
    			 Label last_apt1 = new Label(1, row_index, "Warning", yellow);
    			 sheet.addCell(last_apt1);
    			 
    			 Label last_apt = new Label(2, row_index, "Connection is Closed", va_c);
    			 WritableCellFeatures cellFeatures = new WritableCellFeatures();
    			 cellFeatures.setComment(chopp_tmp);
    			 last_apt.setCellFeatures(cellFeatures);
    			 sheet.addCell(last_apt);
    		 }
    		 
    		 Label chp_l = new Label(0, row_index, "Check charging interface, settings", ca_b);
    		 sheet.addCell(chp_l);
    		 
//----end
    		 workbook.write();
    		 workbook.close();
           
       } catch (WriteException ex) {
           ex.printStackTrace();
       } catch (IOException ex) {
           ex.printStackTrace();
       }
 }
}