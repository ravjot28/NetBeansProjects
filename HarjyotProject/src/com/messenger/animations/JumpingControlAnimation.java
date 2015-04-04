/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.messenger.animations;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author puneet
 */
public class JumpingControlAnimation {

    private Timeline timeline;
    
    public JumpingControlAnimation(Node node){
     timeline = new Timeline();
    //set frames
    timeline.getKeyFrames().addAll(
            getKeyFrame(node,new Duration(0),0,0,1,1.0),
            getKeyFrame(node,new Duration(250),0,node.getTranslateY() - 15.0, 1.0, 1.0),
            getKeyFrame(node,new Duration(500),0,node.getTranslateY()-30.0,0.87,1.1),
            getKeyFrame(node,new Duration(750),0,node.getTranslateY() + 15.0,0.93,1.2),
            getKeyFrame(node,new Duration(1000),0,node.getTranslateY() + 30,1.1,0.93),
            getKeyFrame(node,new Duration(1250),0,node.getTranslateY()+ 0,1.0,1.0)
            );
    timeline.setCycleCount(1);
    timeline.play();
    //Play in invoking class.
    }
    
    
    private KeyFrame getKeyFrame(Node node,Duration duration, double translateXProperty,double translateYProperty,double scaleXProperty,double scaleYProperty)
    {
    KeyFrame keyframe = new KeyFrame(duration,
            new KeyValue(node.translateXProperty(), translateXProperty),
            new KeyValue(node.translateYProperty(), translateYProperty),
            new KeyValue(node.scaleXProperty(), scaleXProperty),
            new KeyValue(node.scaleYProperty(), scaleYProperty)
            );
    System.out.println("GetKeyFrames");
        return keyframe;
        
    }

    
}
