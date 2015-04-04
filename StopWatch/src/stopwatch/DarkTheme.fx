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
import javafx.scene.paint.*;
import javafx.scene.input.*;



public class DarkTheme extends Theme {
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
                        Circle {
                            centerX: 140
                            centerY: 140
                            radius: 140
                            fill:LinearGradient {
                                startX:0
                                startY:0
                                endX:1
                                endY:1
                                stops: [
                                    Stop {
                                        offset:0
                                        color: Color.web("#3c3c3c")
                                    },
                                    Stop {
                                        offset:1
                                        color: Color.web("#010101")
                                    }
                                ]
                            }
                        },
                        Circle {
                            centerX: 140
                            centerY: 140
                            radius: 134
                            fill:RadialGradient {
                                centerX:0.5
                                centerY:0.5
                                radius:0.5
                                stops: [
                                    Stop {
                                     offset:0
                                        color: Color.rgb(20,20,20)
                                    },
                                    Stop {
                                        offset:0.9499
                                        color: Color.rgb(20,20,20)
                                    },
                                    Stop {
                                        offset:0.95
                                        color: Color.rgb(20,20,20)
                                    },
                                    Stop {
                                        offset:0.975
                                        color: Color.rgb(20,20,20)
                                    },
                                    Stop {
                                        offset:1
                                        color: Color.rgb(84,84,84,0.0)
                                    }
                                ]
                            }
                        },
                        // Tick Marks
                        for (i in [ 1..numOfMarks ]) {
                            Rectangle {
                                x: 0-2
                                y: 108
                                width: 4
                                height: 13
                                fill: Color.web("#9fff81")
                                rotate: (360/numOfMarks)*i
                                translateX: 140
                                translateY: 140}
                        },
                        for (i in [ 1..numOfMinorMarks ]) {
                            Line {
                                startX: 0
                                startY: 120
                                endX: 0
                                endY: 114
                                stroke: Color.web("#FFFFFF")
                                rotate: (360/numOfMinorMarks)*i
                                translateX: 140
                                translateY: 140}
                        },
                        // Numbers
                        Text {
                            font:Font.font("Courier", FontWeight.BOLD, 16)
                            x: 141
                            y: 244
                            content: "30"
                            textAlignment: TextAlignment.CENTER
                            fill: Color.web("#FFFFFF")
                        },
                        Text {
                            font:Font.font("Courier", FontWeight.BOLD, 16)
                            x: 141
                            y: 47
                            content: "0"
                            textAlignment: TextAlignment.CENTER
                            fill: Color.web("#FFFFFF")
                        },
                        Text {
                            font:Font.font("Courier", FontWeight.BOLD, 16)
                            x: 38
                            y: 144
                            content: "45"
                            //verticalAlignment: VerticalAlignment.CENTER
                            textOrigin: TextOrigin.TOP
                            fill: Color.web("#FFFFFF")
                        },
                        Text {
                            font:Font.font("Courier", FontWeight.BOLD, 16)
                            x: 225
                            y: 145
                            content: "15"
                            //verticalAlignment: VerticalAlignment.CENTER
                            textOrigin: TextOrigin.TOP
                            fill: Color.web("#FFFFFF")
                        },
                        // Tenths Dial
                        Group {
                            content: [
                                Text {
                                    font:Font {
                                        name: "Arial"
                                        size: 9
                                    }
                                    x: 0
                                    y: 10
                                    content: "10ths"
                                    textAlignment: TextAlignment.CENTER
                                    textOrigin: TextOrigin.TOP
                                    fill: Color.web("#FFFFFF")
                                },
                                // Tick Marks
                                for (i in [ 1..tenthsNumOfMarks ]) {
                                    Rectangle {
                                        x: -1
                                        y: 24
                                        width: 2
                                        height: 6
                                        fill: Color.web("#9fff81")
                                        rotate: (360/tenthsNumOfMarks)*i}
                                },
                                for (i in [ 1..tenthsNumOfMinorMarks ]) {
                                    Line {
                                        startX: 0
                                        startY: 30
                                        endX: 0
                                        endY: 28
                                        stroke: Color.web("#FFFFFF")
                                        rotate: (360/tenthsNumOfMinorMarks)*i}
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
                                    x: 1
                                    y: 10
                                    content: "Minutes"
                                    textAlignment: TextAlignment.CENTER
                                    textOrigin: TextOrigin.TOP
                                    fill: Color.web("#FFFFFF")
                                },
                                // Tick Marks
                                for (i in [ 1..minutesNumOfMarks ]) {
                                    Rectangle {
                                        x: -1
                                        y: 24
                                        width: 2
                                        height: 6
                                        fill: Color.web("#9fff81")
                                        rotate: (360/minutesNumOfMarks)*i}
                                },
                                for (i in [ 1..minutesNumOfMinorMarks ]) {
                                    Line {
                                        startX: 0
                                        startY: 30
                                        endX: 0
                                        endY: 28
                                        stroke: Color.web("#FFFFFF")
                                        rotate: (360/minutesNumOfMinorMarks)*i}
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
                                            fill: Color.web("#000000")
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
                                            fill: Color.web("#000000")
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
                                            fill: Color.web("#000000")
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
                                            fill: Color.web("#000000")
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
                                            fill: Color.web("#000000")
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
                                            fill: Color.web("#000000")
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
                        font:Font.font("Courier", FontWeight.REGULAR, 16)
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
                                fill: Color.web("#000000")},]
                        translateX: 130
                        translateY: 210
                    },
                    Group {
                        content: [
                            Text {
                                font:Font.font("Courier", FontWeight.BOLD, 16)
                                x: -4
                                y: 6
                                content: bind model.timeString.substring(4,5)
                                fill: Color.web("#000000")},]
                        translateX: 146
                        translateY: 210
                    },
                    Text {
                        font:Font{
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
                                fill: Color.web("#FFFFFF")},]
                        translateX: 184
                        translateY: 210
                    },
                    // Tenths Hand
                    Group {
                        content: [
                            Group { content: [
                                    Circle {
                                        centerX: 0
                                        centerY: 0
                                        radius: 3
                                        fill: Color.web("#FFFFFF")
                                        },
                                    Rectangle {
                                            x: -1
                                            y: -8
                                            width: 2
                                            height: 35
                                            fill: Color.web("#FFFFFF")
                                            rotate: bind model.tenthsHandAngle},
                                ]
                            }
                        ]
                        translateX: 180
                        translateY: 100
                    },
                    // Minutes Hand
                    Group {
                        content: [
                            Group { content: [
                                    Circle {
                                        centerX: 0
                                        centerY: 0
                                        radius: 3
                                        fill: Color.web("#FFFFFF")},
                                    Rectangle {
                                        x: -1
                                        y: -8
                                        width: 2
                                        height: 35
                                        fill: Color.web("#FFFFFF")
                                        rotate: bind model.minutesHandAngle},
                                ]
                            }
                        ]
                        translateX: 100
                        translateY: 100
                    },
                    // Hand
                    Group {
                        content: [
                            Group {
                                content: [
                                    Circle {
                                        centerX: 140
                                        centerY: 140
                                        radius: 8
                                        fill: Color.web("#FF0000")},
                                    Rectangle {
                                        x: -1.5
                                        y: -20
                                        width: 3
                                        height: 120
                                        fill: Color.web("#FF0000")
                                        rotate: bind model.handAngle
                                        translateX: 140
                                        translateY: 140
                                        },
                                    Rectangle {
                                        x: -1.5
                                        y: -40
                                        width: 3
                                        height: 20
                                        fill: Color.web("#FFFFFF")
                                        rotate: bind model.handAngle
                                        translateX: 140
                                        translateY: 140
                                    }
                                ]
                                effect:Lighting{
                                    light: DistantLight {
                                        azimuth: 225
                                    }
                                }
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
                            Arc {
                                centerX: 140
                                centerY: 140
                                radiusX: 120
                                radiusY: 120
                                type: ArcType.CHORD
                                startAngle: 200
                                length: -130
                                fill: Color.WHITE
                            },
                            Arc {
                                centerX: 140
                                centerY: 140
                                radiusX:120
                                radiusY: 120
                                type: ArcType.CHORD
                                startAngle: 190
                                length: -122
                                fill: Color.WHITE
                            },
                        ]
                        effect: GaussianBlur{ radius: 2 }
                        opacity: 0.05
                    },
                ]},
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
                                startX: 0
                                startY: 0
                                endX: 1
                                endY: 0
                                stops: [
                                    Stop {
                                        offset:0
                                        color: Color.web("#DDDDDD")
                                    },
                                    Stop {
                                        offset:0.5
                                        color: Color.web("#AAAAAA")
                                    },
                                    Stop {
                                        offset:1
                                        color: Color.web("#DDDDDD")
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
                                        offset:0
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
                    rotate: -360/12
                    translateX: 180
                    translateY: 200
                    onMousePressed:function(e:MouseEvent) {
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
                            y: bind -(150 + startPressedAmount)
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
                                        color: Color.web("#DDDDDD")
                                    },
                                    Stop {
                                        offset: 0.5
                                        color: Color.web("#AAAAAA")
                                    },
                                    Stop {
                                        offset: 1
                                        color: Color.web("#DDDDDD")
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
                                        offset: 0
                                        color: Color.web("#b4FF00")
                                        },
                                    Stop {
                                    offset: 0.5
                                    color: Color.web("#8cc700")
                                    },
                                    Stop {
                                        offset: 1
                                        color: Color.web("#b4FF00")
                                    }
                                ]
                            }
                        },
                    ]
                    rotate: 360/12
                    translateX: 180
                    translateY: 200
                    onMousePressed:function(e:MouseEvent) {
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