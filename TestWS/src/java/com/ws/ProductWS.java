/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author Ravjot
 */
@WebService
public class ProductWS {
    
    public List<String> getProduct(){
        List<String> list = new ArrayList<>();
        list.add("Yo");
        list.add("Yo");
        list.add("Honey");
        list.add("Singh");
        return list;
    }
    
}
