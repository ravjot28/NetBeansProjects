/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package First;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Rav
 */
@WebService()
public class Hello {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTime")
    public String getTime(String name) {
        return "Hello "+name;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public String operation() {
        //TODO write your implementation code here:
        return "FUB";
    }

}
