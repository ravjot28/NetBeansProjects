/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fameden.experiments;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author ravjotsingh
 */
public class SpotLightTestFXMLController implements Initializable {
    
    @FXML
    Pane pane;

    @FXML
    Pane pane1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Light.Spot light = new Light.Spot(pane1.getPrefWidth()/2,pane1.getPrefHeight()/2,200,10.0,Color.WHITE);
        //light.setX(150);
        //light.setY(100);
        //light.setZ(80);
        light.setPointsAtX(0);
        light.setPointsAtY(0);
        light.setPointsAtZ(0);
        //light.setSpecularExponent(5.0);
        
        Lighting l = new Lighting();
        l.setLight(light);
        l.setBumpInput(null);
        l.setSurfaceScale(2.0);
        pane1.setEffect(l);
    }    
    
}
