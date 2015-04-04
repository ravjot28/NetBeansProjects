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
package calculator.view;

import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.CustomNode;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.TextOrigin;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class FXCalculator extends CustomNode {

    var transY = 44.0;
    var border = 7.0;

    var selIndex = 0;

    public var width = Key.width * 4 + border * 2.0;
    public var height = Key.height * 5 + border * 2.0 + transY;

    def backFill = LinearGradient {
        endX: 0.0
        endY: height
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

    def dispFill = LinearGradient {
        endX: 0.0
        endY: height
        proportional: false
        stops: [
            Stop {
                offset: 0
                color: Color.GRAY
            },
            Stop {
                offset: 0.2
                color: Color.WHITE
            }
        ]
    }

    def lineFill = LinearGradient {
        startX: 0.0,
        startY: 0.0,
        endX: 0.0,
        endY: height
        proportional: false
        stops: [
            Stop {
                offset: 0
                color: Color.BLACK
            },
            Stop {
                offset: 0.2
                color: Color.GRAY
            }
        ]
    }

    var bgRect = Rectangle {
        x: 3
        y: 3
        width: width
        height: height
        fill: backFill
        stroke: lineFill
        strokeWidth: 3.0
        arcWidth: 20
        arcHeight: 20
    };

    var numberBackground = Rectangle {
        x: 3 + border
        y: 3 + border
        width: width - border * 2.0
        height: 35
        fill: dispFill
        stroke: lineFill
        strokeWidth: 1.0
        arcWidth: 10
        arcHeight: 10
    };

    var number: String = "0";
    var numberText : Text = Text {
        translateX: bind width - numberText.layoutBounds.width - 20
        translateY: 8 + border
        font:Font {
            name: "monospaced"
            size: 25
        }
        fill: Color.BLACK
        content: bind format(number);
        textOrigin: TextOrigin.TOP
    };

    var operation: String = "";
    var operationText : Text = Text {
        translateX: 8 + border
        translateY: 13 + border
        font:Font {
            name: "monospaced"
            size: 10
        }
        fill: Color.BLACK
        content: bind operation;
        textOrigin: TextOrigin.TOP
    };

    var memory: String = "";
    var memoryText : Text = Text {
        translateX: 8 + border
        translateY: 24 + border
        font:Font {
            name: "monospaced"
            size: 10
        }
        fill: Color.BLACK
        content: bind memory;
        textOrigin: TextOrigin.TOP
    };

    function format(num:String):String {
        var temp = "{num}";
        var dotIndex = temp.indexOf(".");

        if((dotIndex != -1) and (temp.length() > (dotIndex + 3))) {
            var eIndex = temp.indexOf("E");
            var eTemp = "";
            if(eIndex != -1) {
                eTemp = "{temp.substring(eIndex)}";
            }
            temp = "{temp.substring(0, (dotIndex + 3))}{eTemp}";
        } else if (temp == "0") {
            temp = "0.";
        }
        if(temp.length() >= 12) { return "Error"; }
        return num;
    }

    var calcKeys:Key[];
    override function create():Node {
        // Set Calculator Keyboard Layout
        var keyText = [
            "M+", "M-", "M", "/",
            "7", "8", "9", "X",
            "4", "5", "6", "+",
            "1", "2", "3", "-",
            "0", ".", "C", "="
        ];
        var keyCode = [
            10, 11, 12, 13,
            7, 8, 9, 14,
            4, 5, 6, 15,
            1, 2, 3, 16,
            0, 19, 18, 17
        ];

        for(row in [0..4]) {
            for(col in [0..3]) {
                insert Key {
                    x: bgRect.x + ((Key.width + 1) * col) + border
                    y: bgRect.y + ((Key.height + 1) * row) + border
                    content: keyText[(sizeof calcKeys)]
                    code: keyCode[(sizeof calcKeys)]
                    onMousePressed: function(e:MouseEvent) {
                        onMousePressed(e);
                    }
                } into calcKeys;
            }
        }

        return Group {
            content:  [
                bgRect,
                numberBackground,
                numberText,
                operationText,
                memoryText,
                Group {
                    translateY: transY
                    content: [ calcKeys ]
                }
            ]
        }
    }

    var opCode = -1; // No Operation
    var opNum1 : Number = 0; // First Number
    var opNum2 : Number = 0; // Second Number
    var memNum : Number = 0 on replace { // Memory
        if(memNum != 0) {
            memory = "M";
        } else {
            memory = "";
        }
    }
    var decimal = false; // Is decimal key pressed?
    var reset = false on replace {
        if(reset) { decimal = false; }
    }

    public function getResult() : String {
        return numberText.content;
    }

    /**
     * Handle Mouse Events
     */
    function onMousePressed(e:MouseEvent) : Void {
        var key = e.node as Key;
        key.setCellFill(true);
        onKey(key);
    }

    function onKey(key: Key) {
        if(key.code >= 0 and key.code <= 9) { // Digits
            onDigit(key.code);
        } else if(key.code >= 10 and key.code <= 12) { // Memory Operations
            onMemory(key.code);
        } else if(key.code == 19) { // Decimal Point
            onDecimal();
        } else if(key.code == 17) { // Equals
            onEquals();
        } else if(key.code == 18) { // Cancel
            onCancel();
        } else if(key.code >= 13 and key.code <= 16) { // Operations
            onOperations(key);
        }
    }

    function onDigit(keyCode : Integer) {

        // Reset the display
        if(reset) {
            number = "";
            reset = false;
        }
        var tempText = "{number}";
        if(tempText == "0") {
            tempText = "";
        }
        number = "{tempText}{keyCode}";
    }

    function onDecimal() {

        // Reset the display
        if(reset) {
            number = "0";
            reset = false;
        }
        if(not decimal) {
            number = "{number}.";
        }
        decimal = true;
    }

    function onCancel() {
        reset = true;
        opCode = -1;
        opNum1 = 0;
        opNum2 = 0;
        number = "0";
        operation = "";
        memNum = 0;
    }

    function onEquals() {
        performMathsOperation();
        opCode = -1;
        reset = true;
        operation = "";
    }

    function onOperations(key : Key) {
        operation = key.content;
        if(opCode == -1) {
            try {
                opNum1 = java.lang.Float.parseFloat(number);
            } catch (exp:java.lang.Exception) { }
            reset = true;
        } else {
            performMathsOperation();
        }
        opCode = key.code;
    }

    //Perform specified mathematical operation
    function performMathsOperation():Void {
        reset = true;

        try {
            opNum2 = java.lang.Float.parseFloat(number);
        } catch (exp:java.lang.Exception) { }

        if(opCode == 13) { // Divide
            opNum1 = opNum1 / opNum2;
        } else if(opCode == 14) { // Multiply
            opNum1 = opNum1 * opNum2;
        } else if(opCode == 15) { // Addition
            opNum1 = opNum1 + opNum2;
        } else if(opCode == 16) { // Subtraction
            opNum1 = opNum1 - opNum2;
        }

        number = "{opNum1}";
    }

    //Perform specified memory operation
    function onMemory(keyCode:Integer):Void {
        var tempNum = 0.0;
        try {
            tempNum = java.lang.Float.parseFloat(number);
        } catch (exp:java.lang.Exception) { }

        if(keyCode == 12) { // M

            if(opCode == -1) {
                opNum1 = memNum;
            } else {
                opNum2 = memNum;
            }
            number = "{memNum}";
            return;

        } else if(keyCode == 10) { // M+
            memory = "M";
            memNum = memNum + tempNum;
        } else if(keyCode == 11) { // M-
            memory = "M";
            memNum = memNum - tempNum;
        }

        opCode = -1;
        reset = true;
        operation = "";
    }

    override var onKeyPressed = function(e : KeyEvent) {
        if(e.code == KeyCode.VK_0)      { onDigit(0); }
        else if(e.code == KeyCode.VK_1) { onDigit(1); }
        else if(e.code == KeyCode.VK_2) { onDigit(2); }
        else if(e.code == KeyCode.VK_3) { onDigit(3); }
        else if(e.code == KeyCode.VK_4) { onDigit(4); }
        else if(e.code == KeyCode.VK_5) { onDigit(5); }
        else if(e.code == KeyCode.VK_6) { onDigit(6); }
        else if(e.code == KeyCode.VK_7) { onDigit(7); }
        else if(e.code == KeyCode.VK_8) { onDigit(8); }
        else if(e.code == KeyCode.VK_9) { onDigit(9); }
        else if(e.code == KeyCode.VK_LEFT) {
            selIndex--;
            if(selIndex < 0) { selIndex = 19; }
            setSelKey(selIndex);
        } else if(e.code == KeyCode.VK_RIGHT) {
            selIndex++;
            if(selIndex > 19) { selIndex = 0; }
            setSelKey(selIndex);
        } else if(e.code == KeyCode.VK_UP) {
            selIndex = selIndex - 4;
            if(selIndex < 0) { selIndex = 20 + selIndex; }
            setSelKey(selIndex);
        } else if(e.code == KeyCode.VK_DOWN) {
            selIndex = selIndex + 4;
            if(selIndex > 19) { selIndex = selIndex - 20; }
            setSelKey(selIndex);
        } else if(e.code == KeyCode.VK_ENTER) {
            var key = calcKeys[selIndex];
            onKey(key);
        }
    }

    function setSelKey(index:Integer) {
        for(key in calcKeys) {
            key.selected = false;
        }
        calcKeys[index].selected = true;
    }
}
