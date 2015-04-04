
import javax.jws.WebMethod;
import javax.jws.WebService;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rav
 */
@WebService(targetNamespace = "http://yoyohoneysingh.org")
public class NewClass {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getName")
    public String getName(String rav) {
        //TODO write your implementation code here:
        return rav;
    }
    
}
