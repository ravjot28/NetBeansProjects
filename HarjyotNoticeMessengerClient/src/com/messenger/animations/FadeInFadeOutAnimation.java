/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.animations;

import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author puneet
 */
public class FadeInFadeOutAnimation extends Transition {

    private FadeTransition fader;
    
    public FadeInFadeOutAnimation(Node node, boolean shouldFadeOut) {
        
        if (shouldFadeOut) {
            fadeOut(node);
        } else {
            fadeIn(node);
            
        }
    }

    private void fadeOut(Node node) {
        fader = new FadeTransition(new Duration(1000), node);
        fader.setFromValue(1.0);
        fader.setToValue(0.0);
        System.out.println("FadeOut   "+ node+"   " + node.getOpacity());
        fader.setAutoReverse(false);
        fader.play();
        
    }

    private void fadeIn(Node node) {
        fader = new FadeTransition(new Duration(1000), node);
        fader.setFromValue(0.0);
        fader.setToValue(1.0);
        System.out.println("FadeIN   "+ node+"   " + node.getOpacity());
        fader.setAutoReverse(false);
        fader.play();
        
    }

    @Override
    protected void interpolate(double d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
