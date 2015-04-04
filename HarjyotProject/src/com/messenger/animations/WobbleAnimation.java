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

public class WobbleAnimation extends TimeLineTransition {

    public WobbleAnimation(final Node node) {
        super(
                node,
                TimelineBuilder.create()
                .keyFrames(
                new KeyFrame(Duration.millis(0),
                new KeyValue(node.translateXProperty(), 0, GlobalConstants.WEB_EASE),
                new KeyValue(node.rotateProperty(), 0, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(150),
                new KeyValue(node.translateXProperty(), -0.25 * node.getBoundsInParent().getWidth(), GlobalConstants.WEB_EASE),
                new KeyValue(node.rotateProperty(), -5, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(300),
                new KeyValue(node.translateXProperty(), 0.2 * node.getBoundsInParent().getWidth(), GlobalConstants.WEB_EASE),
                new KeyValue(node.rotateProperty(), 3, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(450),
                new KeyValue(node.translateXProperty(), -0.15 * node.getBoundsInParent().getWidth(), GlobalConstants.WEB_EASE),
                new KeyValue(node.rotateProperty(), -3, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(600),
                new KeyValue(node.translateXProperty(), 0.1 * node.getBoundsInParent().getWidth(), GlobalConstants.WEB_EASE),
                new KeyValue(node.rotateProperty(), 2, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(750),
                new KeyValue(node.translateXProperty(), -0.05 * node.getBoundsInParent().getWidth(), GlobalConstants.WEB_EASE),
                new KeyValue(node.rotateProperty(), -1, GlobalConstants.WEB_EASE)),
                new KeyFrame(Duration.millis(1000),
                new KeyValue(node.translateXProperty(), 0, GlobalConstants.WEB_EASE),
                new KeyValue(node.rotateProperty(), 0, GlobalConstants.WEB_EASE)))
                .build(),
                true);
        setCycleDuration(Duration.seconds(1));
        setDelay(Duration.seconds(0.2));
    }
}
