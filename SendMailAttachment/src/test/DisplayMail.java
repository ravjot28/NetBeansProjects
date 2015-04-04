import java.net.*;
import java.io.*;

public class DisplayMail {

  public static void main(String arg[]) {
       //
       //  usage :
       //  DisplayMail [mailServer] [user] [password]
       //     (will not delete mail on the server)
       //
       try {
         // connect on port 110 (POP3)
         System.out.println("Connect to " + arg[0] + ":465");
         Socket s = new Socket(arg[0], 465);
         BufferedReader in  = new BufferedReader(
             new InputStreamReader(s.getInputStream()));
         BufferedWriter out = new BufferedWriter(
             new OutputStreamWriter(s.getOutputStream()));
         DisplayMail mail = new DisplayMail();
         mail.login(in, out, arg[1], arg[2]);
         int i = mail.check(in,out);
         if (i==0) {
           System.out.println("No mail waiting.");
         }
         else {
           for (int j=1; j <= i; j++) {
              String msg = mail.get(in, out, j);
              System.out.println("*****");
              System.out.println(msg);
              System.out.println("*****");
           }
           //
           // If the mail was removed from the server
           // (see getMail()) then we must COMMIT with
           // the "QUIT" command :
           //   send(out, "QUIT");
           //
         }
       }
       catch (Exception e) {
         e.printStackTrace();
       }
    }

  public String get(BufferedReader in, BufferedWriter out, int i)
       throws IOException {
       String s = "";
       String t = "";
       send(out, "RETR "+i);
       while (((s = in.readLine()) != null)
           &&(!(s.equals(".")))) {
             t += s + "\n";
       }
       //
       // To remove the mail on the server :
       //   send(out, "DELE "+i);
       //   receive(in);
       //
       return t;
  }


  private void send(BufferedWriter out, String s)
    throws IOException {
       System.out.println(s);
       out.write(s+"\n");
       out.flush();
  }

  private String receive(BufferedReader in)
    throws IOException {
       String s =  in.readLine();
       System.out.println(s);
       return s;
  }

  private void login(BufferedReader in, BufferedWriter out, String user, String pass) throws IOException 
  {
       receive(in);
       send(out, "HELO theWorld");
       receive(in);
       send(out, "USER " + user);
       receive(in);
       send(out, "PASS " + pass);
       receive(in);
  }

  private int check(BufferedReader in, BufferedWriter out)
      throws IOException {
      return getNumberOfMessages(in, out);
  }

  public int getNumberOfMessages(BufferedReader in, BufferedWriter out)      throws IOException 
  {
       int i = 0;
       String s;
       send(out, "LIST");
       receive(in);
       while((s = receive(in)) != null) {
          if (!(s.equals("."))) {
              i++;
          }
          else {
              return i;
          }
       }
       return 0;
  }
}