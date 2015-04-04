/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.util;

import com.messenger.animations.ShakeAnimation;
import com.messenger.animations.WobbleAnimation;
import javafx.scene.Node;

/**
 *
 * @author Ravjot
 */
public class InvokeAnimation {

    public static void attentionSeekerShake(Node node) {
        ShakeAnimation shakeTransition;
        shakeTransition = new ShakeAnimation(node);
        shakeTransition.play();
    }

    public static void attentionSeekerWobble(Node node) {
        WobbleAnimation wobbleTransition;
        wobbleTransition = new WobbleAnimation(node);
        wobbleTransition.play();
    }
}
