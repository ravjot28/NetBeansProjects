package bouncingdock;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.animation.transition.TranslateTransition;
import javafx.animation.Timeline;
import javafx.scene.input.MouseEvent;


var icon: ImageView;
     icon = ImageView
     {
        image: Image 
                {
                    url: "{__DIR__}resources/mailIcon.png"
                }

        translateX: 133
        translateY: 30
        
        onMouseClicked: function(e: MouseEvent): Void
        {
                transition.play()
        }
}

var icon1: ImageView;
     icon1 = ImageView
     {
        image: Image
                {
                    url: "{__DIR__}resources/mailIcon.png"
                }

        translateX: 33
        translateY: 30

        onMouseClicked: function(e: MouseEvent): Void
        {
                transition1.play()
        }
}


var icon2: ImageView;
     icon2 = ImageView
     {
        image: Image
                {
                    url: "{__DIR__}resources/mailIcon.png"
                }

        translateX: 233
        translateY: 30

        onMouseClicked: function(e: MouseEvent): Void
        {
                transition2.play()
        }
}



def backGround = ImageView
                {
                    image: Image
                            {
                                url:"{__DIR__}resources/dock.jpg"
                            }
                }

var transition = TranslateTransition
{
	duration: 250ms
	node: icon
	byY:-25
	repeatCount: Timeline.INDEFINITE
        autoReverse: true
}


var transition1 = TranslateTransition
{
	duration: 250ms
	node: icon1
	byY:-25
	repeatCount: Timeline.INDEFINITE
        autoReverse: true
}


var transition2 = TranslateTransition
{
	duration: 250ms
	node: icon2
	byY:-25
	repeatCount: Timeline.INDEFINITE
        autoReverse: true
}



Stage
{
    title: "First JavaFX App"
    scene: Scene
            {
                width: 362
                height: 150
                content:
                [
                    backGround,
                    icon1,
                    icon,
                    icon2
                ]
            }
}