/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.util;

import com.messenger.animations.FadeInFadeOutAnimation;
import com.messenger.animations.ShakeAnimation;
import com.messenger.animations.WobbleAnimation;
import com.messenger.constants.GlobalConstants;
import javafx.scene.Node;

/**
 *
 * @author Ravjot
 */
public class InvokeAnimation {

    public static void attentionSeekerShake(Node node) {
        ShakeAnimation shakeTransition;
        shakeTransition = new ShakeAnimation(node);
        node.getStyleClass().add(GlobalConstants.promptTextErrorCSSClass);
        shakeTransition.play();
    }

    public static void attentionSeekerWobble(Node node) {
        WobbleAnimation wobbleTransition;
        wobbleTransition = new WobbleAnimation(node);
        node.getStyleClass().add(GlobalConstants.promptTextErrorCSSClass);
        wobbleTransition.play();
    }
    
    public static void appearByFading(Node node){
        FadeInFadeOutAnimation fadeIn;
        fadeIn = new FadeInFadeOutAnimation(node, false);
        
    }
    public static void disappearByFading(Node node){
        FadeInFadeOutAnimation fadeIn;
        fadeIn = new FadeInFadeOutAnimation(node, true);
        
    }
    
}
