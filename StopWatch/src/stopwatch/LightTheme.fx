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
package stopwatch;

import javafx.scene.effect.*;
import javafx.scene.effect.light.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;
import javafx.scene.transform.*;


public class LightTheme extends Theme {
     var resetPressedAmount:Integer = 7;
     var startPressedAmount:Integer = 7;

    init {
        var numOfMarks = 12;
        var numOfMinorMarks = 60;
        var minutesNumOfMarks = 10;
        var minutesNumOfMinorMarks = 50;
        var tenthsNumOfMarks = 10;
        var tenthsNumOfMinorMarks = 50;
        
        frontContent = Group {
            id: "Front"
            content: [
                // MAIN DIAL
                Group {
                    translateX: 40
                    translateY: 60
                    cache: true
                    content: [
                            ImageView {
                                translateX: 0
                                translateY: 0
                                image: Image {url: "{__DIR__}stopwatch.png"}
                            },
                        Circle {
                            centerX: 140
                            centerY: 140
                            radius: 140
                            fill: null
                            stroke: Color.web("#818a89")
                        },
                        // Tick Marks
                        Circle {
                            centerX: 140
                            centerY: 140
                            radius: 120
                            fill: null
                            strokeWidth: 0.5
                            stroke: Color.web("#0A0A0A")
                        },
                        Circle {
                            centerX: 140
                            centerY: 140
                            radius: 118
                            fill: null
                            strokeWidth: 0.5
                            stroke: Color.web("#0A0A0A")
                        },
                        for (i in [ 1..numOfMinorMarks ]) {
                            Line {
                                startX: 0
                                startY: 120
                                endX: 0 endY: 114
                                stroke: Color.rgb(10,10,10)
                                transforms: Transform.rotate((360/numOfMinorMarks)*i,0,0)
                                translateX: 140
                                translateY: 140
                            }
                        },
                        for (i in [ 1..numOfMarks ]) {
                            Line{
                                startX: 0
                                startY: 122
                                endX: 0
                                endY: 110
                                stroke: Color.rgb(10,10,10)
                                strokeWidth: 1.5
                                transforms: Transform.rotate((360/numOfMarks)*i,0,0)
                                translateX: 140
                                translateY: 140
                            }
                        },
//                        for (i in [1..numOfMinorMarks]) {
//                            Line{startX: 0 startY: 120 endX: 0 endY: 114
//                                    stroke: Color.web("#FFFFFF")
//                                    rotate: (360/numOfMinorMarks)*i
//                                    translateX: 140
//                                    translateY: 140}
//                        },
                        // Numbers
                        Text {
                            font:Font{
                                name: "Arial"
                                size: 16
                            }
                            x: 132
                            y: 244
                            content: "30"
                            textAlignment: TextAlignment.CENTER
                            fill: Color.web("#0A0A0A")
                        },
                        Text {
                            font:Font {
                                name: "Arial"
                                size: 16
                            }
                            x: 136
                            y: 47
                            content: "0"
                            textAlignment: TextAlignment.CENTER
                            fill: Color.web("#0A0A0A")
                        },
                        Text {
                            font:Font {
                                name: "Arial"
                                size: 16
                            }
                            x: 38
                            y: 145
                            content: "45"
                            textOrigin: TextOrigin.BASELINE
                            fill: Color.web("#0A0A0A")
                        },
                        Text {
                            font:Font {
                                name: "Arial"
                                size: 16
                            }
                            x: 225
                            y: 145
                            content: "15"
                            textOrigin: TextOrigin.BASELINE
                            fill: Color.web("#0A0A0A")
                        },
                        // Tenths Dial
                        Group {
                            content: [
                                Text {
                                    font:Font {
                                        name: "Arial"
                                        size: 9
                                    }
                                    x: -10
                                    y: 10
                                    content: "10ths"
                                    textAlignment: TextAlignment.CENTER
                                    textOrigin: TextOrigin.TOP
                                    fill: Color.web("#0A0A0A")
                                },
                                // Tick Marks
                                for (i in [ 1..tenthsNumOfMarks ]) {
                                    Line {
                                        startX: 0
                                        startY: 30
                                        endX: 0
                                        endY: 26
                                        strokeWidth: 1.5
                                        stroke: Color.web("#0A0A0A")
                                        transforms: Transform.rotate((360/tenthsNumOfMarks)*i,0,0) }
                                },
                                for (i in [1..tenthsNumOfMinorMarks]) {
                                    Line {
                                        startX: 0
                                        startY: 30
                                        endX: 0
                                        endY: 28
                                        stroke: Color.web("#0A0A0A")
                                        transforms: Transform.rotate((360/tenthsNumOfMinorMarks)*i,0,0)}
                                },
                            ]
                            translateX: 180
                            translateY: 100
                        },
                        // Minutes Dial
                        Group {
                            content: [
                                Text {
                                    font:Font{
                                        name: "Arial"
                                        size: 9
                                    }
                                    x: -15
                                    y: 10
                                    content: "Minutes"
                                    textAlignment: TextAlignment.CENTER
                                    textOrigin: TextOrigin.TOP
                                    fill: Color.web("#0A0A0A")
                                },
                                // Tick Marks
                                for (i in [ 1..minutesNumOfMarks ]) {
                                    Line {
                                        startX: 0
                                        startY: 30
                                        endX: 0
                                        endY: 26
                                        strokeWidth: 1.5
                                        stroke: Color.web("#0A0A0A")
                                        transforms: Transform.rotate((360/tenthsNumOfMarks)*i,0,0) }
                                },
                                for (i in [ 1..minutesNumOfMinorMarks ]) {
                                    Line {
                                        startX: 0
                                        startY: 30
                                        endX: 0
                                        endY: 28
                                        stroke: Color.web("#0A0A0A")
                                        transforms: Transform.rotate((360/tenthsNumOfMinorMarks)*i,0,0)}
                                },
                            ]
                            translateX: 100
                            translateY: 100
                        },
                        // Digits Cells
                        Group {
                            effect: Lighting {}
                            content: [
                                Group {
                                    content: [
                                        Rectangle {
                                            x: -7
                                            y: -9
                                            width: 15
                                            height: 19
                                            fill: Color.web("#a39f91")
                                        },
                                        Rectangle {
                                            x: -5
                                            y: -7
                                            width: 11
                                            height: 15
                                            fill: Color.web("#FFFFFF")
                                        },
                                    ]
                                    translateX: 91
                                    translateY: 210
                                },
                                Group {
                                    content: [
                                        Rectangle {
                                            x: -7
                                            y: -9
                                            width: 15
                                            height: 19
                                            fill: Color.web("#a39f91")
                                        },
                                        Rectangle {
                                            x: -5
                                            y: -7
                                            width: 11
                                            height: 15
                                            fill: Color.web("#FFFFFF")
                                        },
                                    ]
                                    translateX: 107
                                    translateY: 210
                                },
                                Group {
                                    content: [
                                        Rectangle {
                                            x: -7
                                            y: -9
                                            width: 15
                                            height: 19
                                            fill: Color.web("#bdbeb3")
                                        },
                                        Rectangle {
                                            x: -5
                                            y: -7
                                            width: 11
                                            height: 15
                                            fill: Color.web("#FFFFFF")
                                        },
                                    ]
                                    translateX: 130
                                    translateY: 210
                                },
                                Group {
                                    content: [
                                        Rectangle {
                                            x: -7
                                            y: -9
                                            width: 15
                                            height: 19
                                            fill: Color.web("#bdbeb3")
                                        },
                                        Rectangle {
                                            x: -5
                                            y: -7
                                            width: 11
                                            height: 15
                                            fill: Color.web("#FFFFFF")
                                        },
                                    ]
                                    translateX: 146
                                    translateY: 210
                                },
                                Group {
                                    content: [
                                        Rectangle {
                                            x: -7
                                            y: -9
                                            width: 15
                                            height: 19
                                            fill: Color.web("#bdbeb3")
                                        },
                                        Rectangle {
                                            x: -5
                                            y: -7
                                            width: 11
                                            height: 15
                                            fill: Color.web("#FF0000")
                                        },
                                    ]
                                    translateX: 168
                                    translateY: 210
                                },
                                Group {
                                    content: [
                                        Rectangle {
                                            x: -7
                                            y: -9
                                            width: 15
                                            height: 19
                                            fill: Color.web("#bdbeb3")
                                        },
                                        Rectangle {
                                            x: -5
                                            y: -7
                                            width: 11
                                            height: 15
                                            fill: Color.web("#FF0000")
                                        },
                                    ]
                                    translateX: 184
                                    translateY: 210
                                },
                            ]
                        }
                    ]
                },
                Group {
                    translateX: 40
                    translateY: 60
                    content: [
                    // Digits
                        Group {
                            content: [
                                Text {
                                    font:Font.font("Courier", FontWeight.BOLD, 16)
                                    x: -4
                                    y: 6
                                    content: bind model.timeString.substring(0,1)
                                    fill: Color.web("#000000")
                                },
                            ]
                        translateX: 91
                        translateY: 210
                    },
                    Group {
                        content: [
                            Text {
                                font:Font.font("Courier", FontWeight.BOLD, 16)
                                x: -4
                                y: 6
                                content: bind model.timeString.substring(1,2)
                                fill: Color.web("#000000")
                            },
                        ]
                        translateX: 107
                        translateY: 210
                    },
                    Text {
                        font:Font {
                            name: "Courier"
                            size: 16
                        }
                        x: 114
                        y: 214
                        content: ":"
                        fill: Color.web("#FFFFFF")
                    },
                    Group {
                        content: [
                            Text {
                                font:Font.font("Courier", FontWeight.BOLD, 16)
                                x: -4
                                y: 6
                                content: bind model.timeString.substring(3,4)
                                fill: Color.web("#000000")
                            },
                        ]
                        translateX: 130 translateY: 210
                    },
                    Group {
                        content: [
                            Text {
                                font:Font.font("Courier", FontWeight.BOLD, 16)
                                x: -4
                                y: 6
                                content: bind model.timeString.substring(4,5)
                                fill: Color.web("#000000")
                            },
                        ]
                        translateX: 146
                        translateY: 210
                    },
                    Text {
                        font:Font {
                            name: "Courier"
                            size: 16
                        }
                        x: 153
                        y: 214
                        content: "."
                        fill: Color.web("#FFFFFF")
                    },
                    Group {
                        content: [
                            Text {
                                font:Font.font("Courier", FontWeight.BOLD, 16)
                                x: -4
                                y: 6
                                content: bind model.timeString.substring(6,7)
                                fill: Color.web("#FFFFFF")
                            },
                        ]
                        translateX: 168
                        translateY: 210
                    },
                    Group {
                        content: [
                            Text {
                                font:Font.font("Courier", FontWeight.BOLD, 16)
                                x: -4
                                y: 6
                                content: bind model.timeString.substring(7,8)
                                fill: Color.web("#FFFFFF")
                            },
                        ]
                        translateX: 184
                        translateY: 210
                    },
                    // Tenths Hand
                    Group {
                        content: [
                            Group {
                                content: [
                                    Circle {
                                        centerX: 0
                                        centerY: 0
                                        radius: 3
                                        fill: Color.web("#0A0A0A")
                                    },
                                    Rectangle {
                                        x: -1
                                        y: -8
                                        width: 2
                                        height: 35
                                        fill: Color.web("#0A0A0A")
                                        transforms: bind [ Transform.rotate(model.tenthsHandAngle,0,0)]
                                    },
                                ]
                            }
                        ]
                        translateX: 182
                        translateY: 100
                    },
                    // Minutes Hand
                    Group {
                        content: [
                            Group {
                                content: [
                                    Circle {
                                        centerX: 0
                                        centerY: 0
                                        radius: 3
                                        fill: Color.web("#0A0A0A")
                                    },
                                    Rectangle{
                                        x: -1
                                        y: -8
                                        width: 2
                                        height: 35
                                        fill: Color.web("#0A0A0A")
                                        //rotate: bind model.minutesHandAngle
                                        transforms: bind [Transform.rotate(model.minutesHandAngle,0,0)]
                                    },
                                ]
                            }
                        ]
                        translateX: 102
                        translateY: 100
                    },
                    // Hand
                    Group {
                        content: [
                            Group {
                                content: [
                                    Circle {
                                        centerX: 142
                                        centerY: 140
                                        radius: 8
                                        fill: Color.web("#FF0000")
                                    },
                                    Rectangle {
                                        x: -1.5
                                        y: -20
                                        width: 3
                                        height: 120
                                        fill: Color.web("#FF0000")
                                        transforms: bind [Transform.rotate(model.handAngle,0,0)]
                                        //rotate: bind model.handAngle
                                        translateX: 142
                                        translateY: 140
                                    },
                                ]
                                effect: Lighting{
                                    light: DistantLight {azimuth: 225}
                                }
                            },
                            Rectangle {
                                x: -1.5
                                y: -40
                                width: 3
                                height: 20
                                fill: Color.web("#FFFFFF")
                                //rotate: bind model.handAngle
                                transforms: bind [Transform.rotate(model.handAngle,0,0)]
                                translateX: 142
                                translateY: 140
                            }
                        ]
                        effect: DropShadow {
                            offsetX: 4
                            offsetY: 4
                            radius: 6
                            color: Color.web("#000000")
                        }
                    },
                    // Highlight
                    Group {
                        cache: true
                        content: [
                            Ellipse {
                                centerX: 140
                                centerY: 95
                                radiusX: 180
                                radiusY: 95
                                clip: Circle {
                                    centerX: 140
                                    centerY: 140
                                    radius: 140
                                }
                                fill: Color.web("#535450")
                                stroke: null
                                effect: GaussianBlur{ radius: 10 }
                                opacity: 0.1
                            },
                        ]
                    },
                ]
            },
                // Reset Button
                Group {
                    content: [
                        Rectangle {
                            x: -7
                            y: bind -(150+resetPressedAmount)
                            width: 14
                            height: 7
                            fill:LinearGradient {
                                startX: 0
                                startY: 0
                                endX: 1
                                endY: 0
                                stops: [
                                    Stop {
                                        offset:0
                                        color: Color.web("#AA0000")
                                    },
                                    Stop {
                                        offset:0.5
                                        color: Color.web("#660000")
                                    },
                                    Stop {
                                        offset:1
                                        color: Color.web("#AA0000")
                                    }
                                ]
                            }
                        },
                        Rectangle {
                            x: -12
                            y: -150
                            width: 24
                            height: 14
                            fill:LinearGradient {
                                startX:0
                                startY:0
                                endX:1
                                endY:0
                                stops: [
                                    Stop {
                                        offset: 0
                                        color: Color.web("#4e605f")
                                    },
                                    Stop {
                                        offset: 0.2
                                        color: Color.web("#c3d6d5")
                                    },
                                    Stop {
                                        offset: 0.5
                                        color: Color.web("#f9ffff")
                                    },
                                    Stop {
                                        offset: 0.8
                                        color: Color.web("#c3d6d5")
                                    },
                                    Stop {
                                        offset: 1
                                        color: Color.web("#4e605f")
                                    }
                                ]
                            }
                        },
                        Rectangle {
                            x: -14
                            y: bind -(155 + resetPressedAmount)
                            width: 28
                            height: 5
                            fill:LinearGradient {
                                startX: 0
                                startY: 0
                                endX: 1
                                endY: 0
                                stops: [
                                    Stop {
                                        offset: 0
                                        color: Color.web("#FF0000")
                                    },
                                    Stop {
                                        offset:0.5
                                        color: Color.web("#AA0000")
                                    },
                                    Stop {
                                        offset:1
                                        color: Color.web("#FF0000")
                                    }
                                ]
                            }
                        },
                    ]
                    transforms: Transform.rotate(-360/12,0,0)
                    translateX: 180 translateY: 200
                    onMousePressed: function(e:MouseEvent) {
                        resetPressedAmount=0;
                    }
                    onMouseReleased: function(e:MouseEvent) {
                        resetPressedAmount=7;
                    }
                    onMouseClicked: function(e:MouseEvent) {
                        model.reset();
                    }
                    cursor: Cursor.HAND
                },
                // Start/Stop Button
                Group {
                    content: [
                        Rectangle {
                            x: -7
                            y: bind -(150+startPressedAmount)
                            width: 14
                            height: 7
                            fill:LinearGradient {
                                startX: 0
                                startY: 0
                                endX: 1
                                endY: 0
                                stops: [
                                    Stop {
                                        offset: 0
                                        color: Color.web("#8cc700")
                                    },
                                    Stop {
                                        offset: 0.5
                                        color: Color.web("#71a000")
                                    },
                                    Stop {
                                        offset: 1
                                        color: Color.web("#8cc700")
                                    }
                                ]
                            }
                        },
                        Rectangle {
                            x: -12
                            y: -150
                            width: 24
                            height: 14
                            fill:LinearGradient {
                                startX: 0
                                startY: 0
                                endX: 1
                                endY: 0
                                stops: [
                                       Stop {
                                        offset: 0
                                    color: Color.web("#4e605f")
                                    },
                                    Stop {
                                        offset: 0.2
                                        color: Color.web("#c3d6d5")
                                    },
                                    Stop {
                                        offset: 0.5
                                        color: Color.web("#f9ffff")
                                    },
                                    Stop {
                                        offset: 0.8
                                        color: Color.web("#c3d6d5")
                                    },
                                    Stop {
                                        offset: 1
                                        color: Color.web("#4e605f")
                                    }
                                ]
                            }
                        },
                        Rectangle {
                            x: -14
                            y: bind -(155 + startPressedAmount)
                            width: 28
                            height: 5
                            fill:LinearGradient {
                                startX: 0
                                startY: 0
                                endX: 1
                                endY: 0
                                stops: [
                                    Stop {
                                        offset:0
                                        color: Color.web("#b4FF00")
                                    },
                                    Stop {
                                        offset:0.5
                                        color: Color.web("#8cc700")
                                    },
                                    Stop {
                                        offset:1
                                        color: Color.web("#b4FF00")
                                    }
                                ]
                            }
                        },
                    ]
                    transforms: Transform.rotate(360/12,0,0)
                    translateX: 180 translateY: 200
                    onMousePressed: function(e:MouseEvent) {
                        startPressedAmount=0;
                    }
                    onMouseReleased: function(e:MouseEvent) {
                        startPressedAmount=7;
                    }
                    onMouseClicked: function(e:MouseEvent) {
                        model.startStop();
                    }
                    cursor: Cursor.HAND
                },
            ]
        };
    }
}