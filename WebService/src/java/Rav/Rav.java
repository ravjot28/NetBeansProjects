/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Rav;

import javax.jws.WebMethod;
import javax.jws.WebService;
import DAO.Process;
import DTO.Flat;

/**
 *
 * @author Rav
 */
@WebService()
public class Rav {
    
    @WebMethod(operationName = "UpdateUdhar")
    public String UpdateUdhar(String name,String password,String nameUdhar,String value) {
        Process p = new Process();
        if(p.check(name, password)){
            if(p.updateUdhaar(name, nameUdhar, value)){
                return "Success";
            }else{
                return "Error Due to wrong udhari name or wrong value entered";
            }
        }
        else
            return "FUB";
    }

    @WebMethod(operationName = "CreateUser")
    public String CreateUser(String username,String password) {
        Process p = new Process() {};
        Flat f = new Flat();
        f.setUsername(username);
        f.setPassword(password);
        f.setBalMukul(null);
        f.setBalPankaj(null);
        f.setBalPuneet(null);
        f.setBalVijay(null);
        p.createUser(f);
        return "done";
    }

}
