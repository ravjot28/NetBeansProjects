package testing;

import sendnrecievedata.SendAdmin;

public class NewClass {
public static void main(String as[])
    {
    /*System.out.println("Rav Softs");
    JOptionPane.showMessageDialog(null,"Rav Softs. Production","Rav Softs.",JOptionPane.INFORMATION_MESSAGE);*/
    SendAdmin se = new SendAdmin("1","1234");
    System.out.println(se.process());
    }
}
