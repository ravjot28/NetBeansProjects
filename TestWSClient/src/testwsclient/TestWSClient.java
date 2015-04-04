/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testwsclient;

import com.ws.GetProduct;
import com.ws.ProductWS;
import com.ws.ProductWSService;

/**
 *
 * @author Ravjot
 */
public class TestWSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductWSService p =  new ProductWSService();
        ProductWS pws = p.getProductWSPort();
        System.out.println(pws.getProduct());
    }
}
