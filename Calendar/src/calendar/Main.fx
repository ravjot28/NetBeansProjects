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
package calendar;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Transform;

import calendar.view.FXCalendar;
import calendar.theme.Theme;
import calendar.theme.GrayTheme;

var stageDragInitialX:Number;
var stageDragInitialY:Number;

var bgColor = Color.TRANSPARENT;

var fxCalendar = FXCalendar { 
    theme: Theme { };
};
// Fit screen for mobile
if("{__PROFILE__}" == "mobile") {
    var w = javafx.stage.Screen.primary.bounds.width;
    var h = javafx.stage.Screen.primary.bounds.height;
    def scaleW = w/221;
    def scaleH = h/249;
    bgColor = Color.BLACK;

    fxCalendar.transforms = Transform.scale(scaleW, scaleH);
}

// Drag Bar
var dragBar : Rectangle = Rectangle {
    width: fxCalendar.width
    height: 40
    fill: Color.TRANSPARENT
    visible: bind ("{__PROFILE__}" != "browser")
    onMousePressed: function(e) {
        stageDragInitialX = e.screenX - calendar.x;
        stageDragInitialY = e.screenY - calendar.y;
    }
     onMouseDragged: function(e) {
        calendar.x = e.screenX - stageDragInitialX;
        calendar.y = e.screenY - stageDragInitialY;
     }
}

var calendar = Stage {
    
    title: "Calendar"
    
    scene: Scene {
        content: [ dragBar, fxCalendar ]
        fill: bgColor
        width: fxCalendar.width
        height: fxCalendar.height
    }
    style: StageStyle.TRANSPARENT
}
fxCalendar.requestFocus();
