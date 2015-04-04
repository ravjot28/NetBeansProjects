/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rvp.exception;

/**
 *
 * @author Rav
 */
public class NoBranchNamesFoundException extends Exception{
     public NoBranchNamesFoundException(){
        super("Branch Names Not Found!!");
    }
}
