import java.io.*;
import java.net.*;

public class SendSMS
{
	public static int  SendingSMS(String strAccountId,String strEmail,String strPassword,String strMSISDN,String strMessage,StringBuffer strResponse)
	{
		String  sRequestURL;
		String  sData;
		int nResult = -1;

		sRequestURL = "http://www.redoxygen.net/sms.dll?Action=SendSMS";

		try
		{

			sData  = ("AccountId="  + URLEncoder.encode(strAccountId,"UTF-8"));
			sData += ("&Email="     + URLEncoder.encode(strEmail,"UTF-8"));
			sData += ("&Password="  + URLEncoder.encode(strPassword,"UTF-8"));
			sData += ("&Recipient=" + URLEncoder.encode(strMSISDN,"UTF-8"));
			sData += ("&Message="   + URLEncoder.encode(strMessage,"UTF-8"));



			URL urlObject = new URL(sRequestURL);

			HttpURLConnection con = (HttpURLConnection) urlObject.openConnection();
			con.setRequestMethod("POST");
			con.setDoInput (true);
                        con.setDoOutput (true);


			DataOutputStream out;
    		        out = new DataOutputStream(con.getOutputStream());
    		        out.writeBytes (sData);
			out.flush();
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			StringBuffer responseBuffer = new StringBuffer();

			while ((inputLine = in.readLine()) != null)
			{
                              responseBuffer = responseBuffer.append(inputLine);
			      responseBuffer = responseBuffer.append("\n\n\n");
			}

			strResponse.replace(0,0,responseBuffer.toString());

			String sResultCode = strResponse.substring(0,4);
			nResult = Integer.parseInt(sResultCode);

			in.close();
		}

		catch (Exception e)
		{
			//System.out.println("Exception caught sending SMS\n");
			nResult = -2;
		}
		return nResult;
	}


	public SendSMS(String ph,String message)
        {
            String strAccountId  = "CI00063108";  // Put your AccountId here
		String strEmail      = "ravjot.singh.28@gmail.com";  // Put your Email address here (Used for authentication and replies)
		String strPassword   = "YM2pyto7";  // Put your Password here
		String strMSISDN     = "+91"+ph;  //"+919540140052";   // Put a recipient mobile number here
		String strMessage    = message+"\n\n"; //"1.Apple Store fifth Avenue,767 Fifth Ave., New York City, NY 10153 , (212) 336-144 \n\n2. Apple Store Upper West Side,1981 Broadway, New York City, NY 10023, (212) 209-3400\n\n3. Apple Store West 14th Street,401 W 14th Street, New York City, NY 10014, (212) 444-3400\n\n4. Apple Store SoHo,103 Prince Street, New York City, NY 10012, (212) 226-3126\n\n5. Apple Store Garden State Plaza Garden State Plaza, Space 1L A Paramus, NJ 07652, (201) 975-9500 Inderjeet Miss call me if u get this sms";  // Put your SMS message text here
		int nResult;
		StringBuffer strResponse = new StringBuffer();

		nResult = SendingSMS(strAccountId,strEmail,strPassword,strMSISDN,strMessage,strResponse);

                //System.out.println("Result Code = " + nResult + "\n");
		//System.out.println("Response Text = " + strResponse + "\n");
        }
}

