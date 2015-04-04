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
package calendar.view;

import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.CustomNode;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.TextOrigin;
import javafx.scene.text.TextAlignment;
import javafx.scene.shape.Path;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

import calendar.theme.Theme;
import calendar.theme.GrayTheme;

import java.util.Calendar;

public def width = 221;
public def height = 249;

public class FXCalendar extends CustomNode {
    
    public var theme = Theme { };
    var themeToggle = true;
    
    var insets = 10.0;
        
    var calendar : Calendar = Calendar.getInstance();
    
    var date: Integer;
    var month: Integer;
    var year: Integer;
    var selCellIndex = 0;

    var themeRect : Rectangle = Rectangle {
        x: 5 
	y: 5
        width: bind width - 10
        height: 8
        fill: Color.WHITE
        strokeWidth: 3.0
        arcWidth: 5
        arcHeight: 5
        opacity: 0.2
        onMouseEntered: function(e:MouseEvent) {
            themeRect.opacity = 0.5;
        }
        onMouseExited: function(e:MouseEvent) {
            themeRect.opacity = 0.2;
        }
        onMousePressed: function(e:MouseEvent) {
            if(themeToggle) {
                theme = GrayTheme{};    
            } else {
                theme = Theme{};
            }
            themeToggle = not themeToggle;
        }
    };
            
    var bgRect = Rectangle {
        x: 2 
	y: 2
        width: bind width - 4
        height: bind height - 4
        fill: bind theme.background
        stroke: bind theme.stroke
        strokeWidth: 3.0
        arcWidth: 10
        arcHeight: 10
    };
    
    var monthYearText : Text = Text { 
        translateX: 35
        translateY: insets*1.8
        font:Font {
            name: "Bitstream Vera Sans Bold"
            size: 14
        }
        fill: bind theme.titleForeground
        textOrigin: TextOrigin.TOP
    };
    
    var backButton : Path = Path {
        elements: [
            MoveTo { x: 15  y: 22 },
            LineTo { x: 26  y: 15 },
            LineTo { x: 26  y: 30 },
            LineTo { x: 15  y: 22 }            
        ]
        fill: bind theme.backArrowFill
        stroke: Color.TRANSPARENT
        smooth: true
        opacity: 0.5
        onMouseEntered:function(e:MouseEvent) {
            backButton.opacity = 1.0;
        }
        onMouseExited:function(e:MouseEvent) {
            backButton.opacity = 0.5;
        }
        onMousePressed:function(e:MouseEvent) {
            if(month == 0) {
                month = 11; year = year - 1;
            } else {
                month = month - 1;
            }
            set(year, month, 1);
        }
    };
    
    var nextButton : Path = Path {
        elements: [
            MoveTo { x: 194  y: 15 },
            LineTo { x: 205  y: 22 },
            LineTo { x: 194  y: 30 },
            LineTo { x: 194  y: 15 }            
        ]
        fill: bind theme.nextArrowFill
        stroke: Color.TRANSPARENT
        smooth: true
        opacity: 0.5
        onMouseEntered:function(e:MouseEvent) { 
            nextButton.opacity = 1.0;
        }
        onMouseExited:function(e:MouseEvent) { 
            nextButton.opacity = 0.5;
        }
        onMousePressed:function(e:MouseEvent) {
            if(month == 11) {
                month = 0; year = year + 1;
            } else {
                month = month + 1;
            }
            set(year, month, 1);
        }
    }

    var dateCells:Cell[];                                           // Date Cells
    //@return selected date in mm/d/yyyy format
    public function getDate():String {
        return "{(month + 1)}/{date}/{year}"
    }
    //Set specified date, month, year as selected date
    public function set(year:Integer, month:Integer, date:Integer) {
        this.date = date;
        this.month = month;
        this.year = year;
                
        // Set Calendar Date
        calendar.set(Calendar.DAY_OF_MONTH, date);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        
        // Set Month and Date
        monthYearText.content = "{toMonthText(month)} {year}";
        
        // Start days from Monday
        calendar.set(Calendar.DATE, 1);
        var dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        var dayOfMonth = dayOfWeek;

        if(dayOfWeek <= 1) { dayOfMonth = 7 + dayOfWeek; }          //If its Sunday/Monday, display one week from last month
        addDays(-dayOfMonth);
                
        // Populate Date Cells
        for(cell in dateCells) {
            addDays(1);
            cell.date = calendar.get(Calendar.DAY_OF_MONTH);
            cell.month = calendar.get(Calendar.MONTH);
            cell.year = calendar.get(Calendar.YEAR);
            cell.currentMonth = (calendar.get(Calendar.MONTH) == month);
            cell.selected = (calendar.get(Calendar.DATE) == date);
            if(cell.selected and cell.currentMonth) {
                selCellIndex = cell.index;
            }
        }
    }
        
    /**
     * Since Calendar.add(int field, int amount) is not available in MIDP (JSR 118),
     * we cannot use the API while writing application for Common Profile.
     * Below code provides implementation for add using set method.
     */
    function addDays(days : Integer) {
        calendar.setTime(new java.util.Date(
            calendar.getTime().getTime() + days * 86400000));
    }

    override function create():Node {
        var days = [ "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" ];    // Set Text Monday To Sunday
        var dayCells:Cell[];                                        // Initialize Calendar Day Cells
        for(i in [0..6]) {
            insert Cell { 
                x: bgRect.x + (Cell.width * i) + insets
                y: insets
                content: days[i]
                isDate: false
                theme: bind theme
            } into dayCells;
        }
        var index = 0;                                              // Initialize Calendar Date Cells

        for(row in [0..5]) {
            for(col in [0..6]) {
                insert Cell { 
                    x: bgRect.x + (Cell.width * col) + insets
                    y: (Cell.height * (row + 1)) + insets
                    index: index
                    theme: bind theme
                    onMousePressed: function(e:MouseEvent) {
                        var cell = e.node as Cell;
                        set(cell.year, cell.month, cell.date);
                    }
                } into dateCells;
                index++;
            }
        }
        
        // Set current date as selected date
        calendar.setTime(new java.util.Date());
        set(calendar.get(Calendar.YEAR), 
            calendar.get(Calendar.MONTH), 
            calendar.get(Calendar.DATE));
        
        return Group {
            content:  [ 
                bgRect, themeRect, monthYearText, backButton, nextButton,
                Group {
                    translateY: 30.0
                    content: [ dayCells, dateCells ]  
                }
            ]
        }
    }

    def monthText = [ 
        "January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December" 
    ];
    function toMonthText(m: Integer) {
        return monthText[m];
    }

    override var onKeyPressed = function(e : KeyEvent) {
        if(e.code == KeyCode.VK_LEFT) {
            selCellIndex--;
            var cell = dateCells[selCellIndex];
            set(cell.year, cell.month, cell.date);
        } else if(e.code == KeyCode.VK_RIGHT) {
            selCellIndex++;
            var cell = dateCells[selCellIndex];
            set(cell.year, cell.month, cell.date);
        } else if(e.code == KeyCode.VK_UP) {
            var tempIndex = selCellIndex - 7;
            if(tempIndex < 0) { return; }
            selCellIndex = tempIndex;
            var cell = dateCells[selCellIndex];
            set(cell.year, cell.month, cell.date);
        } else if(e.code == KeyCode.VK_DOWN) {
            var tempIndex = selCellIndex + 7;
            if(tempIndex > 41) { return; }
            selCellIndex = tempIndex;
            var cell = dateCells[selCellIndex];
            set(cell.year, cell.month, cell.date);
        }
    }
}
