/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rvp.util;

import javax.swing.UIManager;

/**
 *
 * @author Rav
 */
public class LookAndFeel {

    public static void look() {
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
        }
    }
}
