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
package calculator;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Transform;

import calculator.view.FXCalculator;
var stageDragInitialX:Number;
var stageDragInitialY:Number;

var w:Number = 221;
var h:Number = 249;
var bgColor = Color.TRANSPARENT;

var fxCalculator = FXCalculator { };

// Fit screen for mobile
if("{__PROFILE__}" == "mobile") {
    w = javafx.stage.Screen.primary.bounds.width;
    h = javafx.stage.Screen.primary.bounds.height;
    def scaleW = w/221;
    def scaleH = h/249;
    bgColor = Color.BLACK;

    fxCalculator.transforms = Transform.scale(scaleW, scaleH);
}

// Drag Bar
var dragBar : Rectangle = Rectangle {
    width: bind fxCalculator.width
    height: 50
    fill: Color.TRANSPARENT
    visible: bind ("{__PROFILE__}" != "browser")
    onMousePressed: function(e) {
        stageDragInitialX = e.screenX - calculator.x;
        stageDragInitialY = e.screenY - calculator.y;
    }
     onMouseDragged: function(e) {
        calculator.x = e.screenX - stageDragInitialX;
        calculator.y = e.screenY - stageDragInitialY;
     }
}

var calculator = Stage {
    
    title: "Calculator"
    
    scene: Scene {
        content: [ dragBar, fxCalculator ]
        fill: bgColor
        width: w
        height: h
    }
    style: StageStyle.TRANSPARENT
}
fxCalculator.requestFocus();
