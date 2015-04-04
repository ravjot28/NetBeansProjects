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
package calendar.theme;

import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.image.Image;

import calendar.view.FXCalendar;

public class Theme {
    public var background:Paint = LinearGradient {
        startX: 0.0,
        startY: 0.0,
        endX: 0.0,
        endY: FXCalendar.height
        proportional: false
        stops: [
            Stop {
                offset: 0
                color: Color.GRAY
            },
            Stop {
                offset: 0.2
                color: Color.BLACK
            }
        ]
    }

    public var stroke:Paint = LinearGradient {
        startX: 0.0,
        startY: 0.0,
        endX: 0.0,
        endY: FXCalendar.height
        proportional: false
        stops: [ 
            Stop { offset: 0 color: Color.BLACK },
            Stop { offset: 0.2 color: Color.GRAY }
        ]
    }

    public var cellFill:Paint = LinearGradient {
        startX: 0.0,
        startY: 0.3,
        endX: 0.0,
        endY: 28.0
        proportional: false
        stops: [
            Stop {
                offset: 0.0
                color: Color.GRAY
            },
            Stop {
                offset: 0.5
                color: Color.BLACK
            }
        ]
    }

    public var cellSelFill:Paint = LinearGradient {
        startX: 0.0,
        startY: 0.3,
        endX: 0.0,
        endY: 28.0
        proportional: false
        stops: [
            Stop {
                offset: 0.0
                color: Color.rgb(5, 53, 180)
            },
            Stop {
                offset: 0.5
                color: Color.rgb(25, 128, 229)
            },
            Stop {
                offset: 1.0
                color: Color.BLACK
            }
        ]
    }

    public var cellStroke:Paint = Color.TRANSPARENT;
    public var cell3DStroke:Paint = Color.TRANSPARENT;

    public var backArrowFill:Paint = LinearGradient {
        startX: 0.0,
        startY: 15.0,
        endX: 0.0,
        endY: 30.0
        proportional: false
        stops: [
            Stop {
                offset: 0.0
                color: Color.WHITE
            },
            Stop {
                offset: 0.5
                color: Color.GRAY
            },
            Stop {
                offset: 1.0
                color: Color.WHITE
            }
        ]
    }

    public var nextArrowFill:Paint = LinearGradient {
        startX: 0.0,
        startY: 15.0,
        endX: 0.0,
        endY: 30.0
        proportional: false
        stops: [
            Stop {
                offset: 0.0
                color: Color.WHITE
            },
            Stop {
                offset: 0.5
                color: Color.GRAY
            },
            Stop {
                offset: 1.0
                color: Color.WHITE
            }
        ]
    }
            
    public var foreground : Paint = Color.WHITE;
    public var selectedForeground : Paint = Color.WHITE;
    public var disabledForeground : Paint = Color.GRAY;
    public var dayForeground : Paint = Color.WHITE;
    public var titleForeground : Paint = Color.WHITE;

    public var bgImage = Image { url: "{__DIR__}images/bg_black.png" }
}
