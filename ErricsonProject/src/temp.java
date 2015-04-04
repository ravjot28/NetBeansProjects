
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class temp {

    public static ArrayList<String> getLines(String fname){
        ArrayList<String> lines = new ArrayList<String>();
        try{
            BufferedReader b = new BufferedReader(new FileReader(fname));
            String data = b.readLine();
            while(data!=null){
                if(data.trim().equals("NO  DATE   TIME ETYPE ACT REP BNR    CODE INF1   INF2   DINO")){
                    data = b.readLine();
                    while(!data.trim().equals("CODE INF1EXP                           INF2EXP")){
                        if(!data.trim().equals("")){
                            lines.add(data.trim());
                        }
                        data = b.readLine();
                    }
                }
                data = b.readLine();
            }
        }catch(Exception e){
            return null;
        }
        return lines;
    }

    public ArrayList<String> getList(){

        ArrayList<String> lines = getLines("MSS.log");
        ArrayList<String> flines = new ArrayList<String>();
        if(lines!=null){
            for(String p:lines){
                StringTokenizer s = new StringTokenizer(p," ");
                ArrayList<String> temp = new ArrayList<String>();
                while(s.hasMoreElements()){
                    String t = s.nextToken().trim();
                    if(!t.equals("")){
                        temp.add(t);
                    }
                }
                if(temp.size()>=8){
                    //String rav  = temp.get(1)+","+temp.get(5)+","+temp.get(3)+","+temp.get(4)+","+temp.get(2)+","+temp.get(6)+","+temp.get(7)+","+temp.get(0);
                    String rav = temp.get(1)+","+temp.get(5)+",";
                    int p1 = 0;
                    for(int i=0;i<temp.size()-2;i++){
                        if(p1 == 1)
                            p1 =2;
                        else
                            if(p1==5)
                                p1=6;
                        rav+=temp.get(p1)+",";
                        p1++;
                    }
                    flines.add(rav);
                }
            }

            String firstdate = flines.get(0);
            Date d = new Date(System.currentTimeMillis());
            String year = (""+d.getYear()).substring(0,2)+firstdate.substring(0,2);
            int month = Integer.parseInt(firstdate.substring(2,4))-1;
            int date = Integer.parseInt(firstdate.substring(4,6));
            d.setMonth(month);
            d.setDate(date);
            d.setYear(Integer.parseInt(year));
            Calendar cal = Calendar.getInstance();
            cal.setTime ( d );
            int daysToDecrement = -1;
            cal.add(Calendar.DATE, daysToDecrement);
            Date d1 = cal.getTime();
           
            String y = (""+d.getYear()).substring(2,4);
            int mo = d.getMonth()+1;
            String m = ""+mo;
            if(mo<10){
                m = "0"+mo;
            }
            int da = d.getDate();
            String dat =""+da;
            if(da<10){
                dat="0"+da;
            }
            String dateone = (y+""+m+""+dat);


            String y1 = (""+d1.getYear()).substring(2,4);
            int mo1 = d1.getMonth()+1;
            String m1 = ""+mo1;
            if(mo1<10){
                m1 = "0"+mo1;
            }
            int da1 = d1.getDate();
            String dat1 =""+da1;
            if(da1<10){
                dat1="0"+da1;
            }
            String datetwo = (y1+""+m1+""+dat1);
            ArrayList<String> result = new ArrayList<String>();

            //System.out.println("First Date "+dateone+"'s code(s)");
            for(String temp:flines){
                StringTokenizer s = new StringTokenizer(temp.trim(),",");
                String t = s.nextToken().trim();
                if(t.equals(dateone)){
                    String tt = s.nextToken();
                    if(!tt.equals("106")){
                        String tempo = t+" "+tt+" ";
                        while(s.hasMoreElements())
                            tempo+=(s.nextToken()+" ");
                        result.add(tempo);
                    }
                }
            }

            System.out.println("Second Date "+datetwo+"'s code(s)");
            for(String temp:flines){
                StringTokenizer s = new StringTokenizer(temp.trim(),",");
                String t = s.nextToken().trim();
                if(t.equals(datetwo)){
                    String tt = s.nextToken();
                    if(!tt.equals("106")){
                        String tempo = (t+" "+tt+" ");
                        while(s.hasMoreElements())
                            temp+=(s.nextToken()+" ");
                        result.add(tempo);
                    }
                }
            }
            return result;
        }
        return null;
    }
}
