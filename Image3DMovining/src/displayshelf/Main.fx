/* 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 * Copyright 2009 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms. 
 * 
 * This file is available and licensed under the following license:
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 *
 *   * Redistributions of source code must retain the above copyright notice, 
 *     this list of conditions and the following disclaimer.
 *
 *   * Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *   * Neither the name of Sun Microsystems nor the names of its contributors 
 *     may be used to endorse or promote products derived from this software 
 *     without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package displayshelf;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.text.*;

var stageDragInitialX:Number;
var stageDragInitialY:Number;

var inBrowser = (__PROFILE__ == "browser");
var draggable = if (__PROFILE__ == "tv") then false else AppletStageExtension.appletDragSupported;
var dragRect:Rectangle = Rectangle {
    x: 0
    y: 0
    width: 600
    height: 25
    fill: Color.DARKGRAY
    onMousePressed:function(e) {
        stageDragInitialX = e.screenX - stage.x;
        stageDragInitialY = e.screenY - stage.y;
    }
     onMouseDragged:function(e) {
        stage.x = e.screenX - stageDragInitialX;
        stage.y = e.screenY - stageDragInitialY;
     }
};
var dragTextVisible = bind inBrowser and draggable and dragRect.hover;
var dragControl:Group = Group {
    content: [
        Text {
            x: 430
            y: 17
            content: "Drag out of Browser"
            fill: Color.WHITE
            visible: bind dragTextVisible
        },
        ImageView {
            x: 570
            y: 8
            image:Image { url: "{__DIR__}images/close_rollover.png" }
            visible: bind not inBrowser
        },
        ImageView {
            x: 570
            y: 8
            image:Image { url: "{__DIR__}images/dragOut_rollover.png" }
            visible: bind inBrowser and draggable
        },
        Rectangle {
            x: 570
            y: 8
            width: 10
            height: 10
            fill: Color.TRANSPARENT
            onMouseClicked:function(e:MouseEvent):Void { stage.close(); }
        }
    ]
};

var images = [
    "DSC_0026_2.jpg",
    "DSC_0040_2.jpg",
    "DSC_0068_2.jpg",
    "DSC_0083_2.jpg",
    "DSC_0094_2.jpg",
    "DSC_0129_2.jpg",
    "DSC_0152_2.jpg",
    "DSC_0162_2.jpg",
    "DSC_0172_2.jpg",
    "DSC_0178_2.jpg",
    "DSC_0199_2.jpg",
    "DSC_0277_2.jpg",
    "DSC_0290_2.jpg",
    "DSC_0425_2.jpg"
];

var half = images.size()/2;

var shelf:DisplayShelf;
shelf = DisplayShelf {
    spacing: 50
    scaleSmall: 0.7
    leftOffset: -110
    rightOffset: 110
    perspective: true
    focusTraversable: true

    content: for(i in images) {
        var item:Item = Item {
            angle: 45
            position: indexof i - half
            image:Image { url: "{__DIR__}photos/{i}" }
            shelf: bind shelf
        };
        item;
    }

    onKeyPressed:function(e:KeyEvent):Void {
        if(e.code == KeyCode.VK_LEFT) {
            shelf.shift(1);
        }
        if(e.code == KeyCode.VK_RIGHT) {
            shelf.shift(-1);
        }
    }
}

var width = 600;
shelf.translateX = width/2 - 200/2;
shelf.translateY = 50;

var extension = 
    if (__PROFILE__ == "tv") 
        then null 
        else AppletStageExtension {
            shouldDragStart:function(e):Boolean {
                return inBrowser and e.primaryButtonDown and dragRect.hover;
            }
            onDragStarted:function() {
                inBrowser = false;
            }
            onAppletRestored:function() {
                inBrowser = true;
            }
            useDefaultClose: false
        }


var stage:Stage = Stage {
    title: "Display Shelf"
    visible: true
    resizable: false
    style: StageStyle.UNDECORATED
    scene:Scene {
        content: [
            Rectangle {
                width: width
                height: 300
                fill:LinearGradient {
                    startX: 0
                    startY: 0
                    endX: 0
                    endY: 1
                    proportional: true
                    stops: [
                        Stop {
                            offset: 0.0
                            color: Color.rgb(150,150,150)
                        }
                        Stop {
                            offset: 1.0
                            color: Color.rgb(30,30,30)
                        }
                    ]
                }
            },
            shelf,
            dragControl,
        ]
    }
    extensions: [ extension ]
}


insert dragRect before dragControl.content[0];      // Insert dragRect here to avoid possible cycle during initialization

shelf.requestFocus();
stage;
