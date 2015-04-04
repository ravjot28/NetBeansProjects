/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.animations;

/**
 *
 * @author Ravjot
 */
import com.messenger.constants.GlobalConstants;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.TimelineBuilder;
import javafx.scene.Node;
import javafx.util.Duration;

public class ShakeAnimation extends TimeLineTransition {
    
    public ShakeAnimation(final Node node) {
        super(
                node,
                TimelineBuilder.create()
                .keyFrames(
                new KeyFrame(Duration.millis(0), new KeyValue(node.translateXProperty(), 0, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(100), new KeyValue(node.translateXProperty(), -10, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(200), new KeyValue(node.translateXProperty(), 10, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(300), new KeyValue(node.translateXProperty(), -10, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(400), new KeyValue(node.translateXProperty(), 10, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(500), new KeyValue(node.translateXProperty(), -10, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(600), new KeyValue(node.translateXProperty(), 10, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(700), new KeyValue(node.translateXProperty(), -10, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(800), new KeyValue(node.translateXProperty(), 10, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(900), new KeyValue(node.translateXProperty(), -10, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(1000), new KeyValue(node.translateXProperty(), 0, GlobalConstants.WEB_EASE)))
                .build(),
                true);
        setCycleDuration(Duration.seconds(1));
        setDelay(Duration.seconds(0.2));
    }
}
