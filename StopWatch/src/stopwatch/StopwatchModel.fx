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

import java.lang.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;



/**
 * @author Jasper
 */
public class StopwatchModel {

    public var handAngle:Number = 180;
    public var tenthsHandAngle:Number = 180;
    public var minutesHandAngle:Number = 180;
    public var timeString:String = "00:00.00";

    public var time = Timeline {
    repeatCount: Timeline.INDEFINITE
        keyFrames: [
            KeyFrame {
                time: 47ms
                action: function() {
                        calculate();
                  }
            }
        ]
    }

    /**
    * The number of milliseconds which have elapsed while the stopwatch has
    * been running. That is, it is the total time kept on the stopwatch.
    */
    var elapsedMillis:Integer = 0;
    /**
    * Keeps track of the amount of the clock time (CPU clock) when the
    * stopwatch run plunger was pressed, or when the last tick even occurred.
    * This is used to calculate the elapsed time delta.
    */
    var lastClockTime:Integer = 0;

    function calculate(): Void {
        if (lastClockTime == 0) lastClockTime = System.currentTimeMillis() as Integer;
        var now:Integer = System.currentTimeMillis() as Integer;
        var delta = now - lastClockTime;
        elapsedMillis += delta;
        var elapsedHundredthsSecond:Integer = elapsedMillis/10;

        var hundredthsExact:Number = (elapsedMillis/10.0) mod 10;
        var tenthsExact:Number = (elapsedMillis/100.0) mod 100;
        var seconds:Integer = (elapsedHundredthsSecond/100) mod 3600;

        handAngle = 180 + ((360/60.0)*seconds);
        tenthsHandAngle = 180 + ((360/10.0)*tenthsExact);
        minutesHandAngle = 180 + ((360/3600.0)*seconds);

        var decimalSeconds:Number = (elapsedHundredthsSecond/100.0) mod 60.0;
        var mins:Integer = (elapsedHundredthsSecond/6000) mod 60;

        timeString = "{%02d mins}:{%05.2f decimalSeconds}";
        lastClockTime = now;
    }

public function startStop(){
        if (time.running){
            time.stop();
            lastClockTime = 0;
        } else {
            time.play();
        }
    }

    public function reset(){
        if (time.running){
            // if started, stop it
            time.stop();
        } else {
            // if stopped, reset it
            lastClockTime = 0;
            elapsedMillis = 0;
        }
        // update the model
        calculate();
    }
}
