/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

/**
 *
 * @author Rav
 */
public class Test {
    
    public static void main(String as[]){
        
        String a[] = {"C:\\Users\\Rav\\Documents\\NetBeansProjects\\Rasav\\System_Availability.csv"};
        String t[] = {"amandeep_ghuman@infosys.com","ravjot28@gmail.com"};
        SendMail sm = new SendMail("smtp.gmail.com", "465", "true", "true", "ravjot.singh.28@gmail.com", "docomo3401", "Sending Mail from the code", "Hi All", a, t);
        sm.send();
    }
}
