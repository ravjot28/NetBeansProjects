import java.io.IOException;
import java.util.StringTokenizer;

public class RegisterCust implements Runnable
{
    String[][] customers;
    String keys[];
    String emailid[];
    boolean verified[];
    String fname[];
    String lname[];
    String location[];
    String ph_no[];
    Thread th = new Thread(this);
    
    public RegisterCust(String[][] a)
    {
        this.customers = a;
    }

    public void create() throws IOException
    {
        emailid = new String[customers.length];
        keys = new String[customers.length];
        verified = new boolean[customers.length];
        fname = new String[customers.length];
        lname = new String[customers.length];
        location = new String[customers.length];
        ph_no = new String[customers.length];
        
        for(int i=0;i<customers.length;i++)
        {
            fname[i] = customers[i][0];
            String mname = customers[i][1];
            lname[i] = customers[i][2];
            emailid[i] = customers[i][3];
            location[i] = customers[i][4];
            GettingLocation gl = new GettingLocation(location[i]);
            gl.createMap();

            String loc = gl.getLocation();
            
            keys[i] = new GenSecretKey().key();
            StringTokenizer token = new StringTokenizer(fname[i],"##");
            if(token.countTokens()>1)
            {
                String emaill;
                StringTokenizer st = new StringTokenizer(emailid[i],"##");
                emaill = st.nextToken();
                String pp=new GetPhNo(loc,emaill).check();
                System.out.println(pp);
                ph_no[i]=pp;
                verified[i]=false;
            }
            else
            {
                if(new CheckFirstUse(loc).check())
                {
                    //System.out.println("First time in this location adding contacts");
                    CreateTable ct = new CreateTable(loc);
                    ct.create();
                    ph_no[i] = new GenNumber(loc).getlast4();
                    while(new CheckPhNo(loc,ph_no[i]).check())
                    {
                        ph_no[i] = new GenNumber(loc).getlast4();
                    }
                    String emaill;
                    StringTokenizer st = new StringTokenizer(emailid[i],"##");
                    emaill = st.nextToken();
                    InsertCust ic = new InsertCust(ph_no[i],fname[i],mname,lname[i],location[i],emaill.trim(),loc);
                    ic.insert();
                    UpdateFirstUse ufu = new UpdateFirstUse(loc);
                    ufu.insert();
                    //System.out.println("Done");
                    verified[i]=true;
                }
                else
                {
                    String emaill;
                    StringTokenizer st = new StringTokenizer(emailid[i],"##");
                    emaill = st.nextToken().trim();
                    if(!new CheckEmail(loc,emaill).check())
                    {
                        //System.out.println("Not First time in this location adding contacts");
                        String ph_no = new GenNumber(loc).getlast4();
                        while(new CheckPhNo(loc,ph_no).check())
                        {
                            ph_no = new GenNumber(loc).getlast4();
                        }

                        InsertCust ic = new InsertCust(ph_no,fname[i],mname,lname[i],location[i],emaill.trim(),loc);
                        ic.insert();
                        //System.out.println("Done");
                        verified[i]=true;
                    }
                    else
                    {
                        //System.out.println("repeat email");
                        verified[i]=false;
                    }
                }
            }
        }
        //System.out.println("Calling thread");
        
        th.start();
        
    }

    public void run()
    {
        //System.out.println("Sending mail");
        for(int j=0;j<keys.length;j++)
        {
            if(verified[j])
            {
                StringTokenizer st = new StringTokenizer(emailid[j],"##");
                String temp = st.nextToken();
                String ph = st.nextToken();
                String message = "Dear "+fname[j]+" "+lname[j]+"\n\n Your contact number for Rav SMS Service is -->"+ph_no[j]+"\n\nPlease enter the below code and to get access to Rav SMS Service\n\n Secret Code:"+keys[j]+"\n\n Enjoy!!!\n\n For any technical issues or suggestions please Contact Us at ravjot28@gmail.com";
                new SendSMS(ph,message);
                String to[] = {temp};
                new SendingQueue(to,message,"ravjotsmssignup@gmail.com","docomo3401").process();
                String to1[] = {"ravjotsingupkey@gmail.com"};
                GettingLocation gl = new GettingLocation(location[j]);
                gl.createMap();

                String loc = gl.getLocation();
                int a = Integer.parseInt(loc);
                int dir = a/100;
                int post = a%100;
                String rav = "";
                switch(dir)
                {
                    case 26:rav="ravjotnorth";
                        break;
                    case 27:rav="ravjoteast";
                        break;
                    case 28:rav="ravjotwest";
                        break;
                    case 29:rav="ravjotsouth";
                        break;
                }
                if(post>=10)
                {
                    rav+=post;
                }
                else
                {
                    rav+="0"+post;
                }
                new SendingQueueAdmin(to1,rav+","+emailid[j]+","+ph_no[j]+","+keys[j],"ravjotsmssignup@gmail.com","docomo3401").process();
            }
            else
            {
                StringTokenizer token = new StringTokenizer(fname[j],"##");
                if(token.countTokens()>1)
                {
                    StringTokenizer st = new StringTokenizer(emailid[j],"##");
                    String temp = st.nextToken();
                    String ph = st.nextToken();
                    String ravs = token.nextToken();
                    String Name = token.nextToken();
                    String message = "Dear "+Name+" "+lname[j]+"\n\n Your contact number for Rav SMS Service is -->"+ph_no[j]+"\n\nPlease enter the below code and to get access to Rav SMS Service\n\n Secret Code:"+keys[j]+"\n\n Enjoy!!!\n\n For any technical issues or suggestions please Contact Us at ravjot28@gmail.com";
                    new SendSMS(ph,message);
                    String to[] = {temp};
                    new SendingQueue(to,message,"ravjotsmssignup@gmail.com","docomo3401").process();
                    String to1[] = {"ravjotsingupkey@gmail.com"};
                    GettingLocation gl = new GettingLocation(location[j]);
                    gl.createMap();

                    String loc = gl.getLocation();
                    int a = Integer.parseInt(loc);
                    int dir = a/100;
                    int post = a%100;
                    String rav = "";
                    switch(dir)
                    {
                        case 26:rav="ravjotnorth";
                            break;
                        case 27:rav="ravjoteast";
                            break;
                        case 28:rav="ravjotwest";
                            break;
                        case 29:rav="ravjotsouth";
                            break;
                    }
                    if(post>=10)
                    {
                        rav+=post;
                    }
                    else
                    {
                        rav+="0"+post;
                    }
                    new SendingQueueAdmin(to1,rav+","+emailid[j]+","+ph_no[j]+","+keys[j],"ravjotsmssignup@gmail.com","docomo3401").process();
                }
            }
        }
    }
}
