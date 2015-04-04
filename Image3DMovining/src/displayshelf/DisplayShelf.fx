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

import javafx.animation.*;
import javafx.scene.*;
import javafx.util.*;
import javafx.scene.effect.DropShadow;

public class DisplayShelf extends CustomNode {
    public var content:Node[];
    public-init var spacing = 110;
    public-init var leftOffset = -50;
    public-init var rightOffset = 50;
    public-init var perspective = false;
    public-init var scaleSmall = 0.5;

    var left:Group = Group { };
    var center:Group = Group { };
    var right:Group = Group { };
    public var centerIndex = 0;

    override public function create():Node {
        var half = content.size()/2-1;
        left.content = content[0..half-2];
        center.content = content[half-1];
        center.effect = DropShadow {};
        right.content = content[half..content.size()-1];
        right.content = Sequences.<<reverse>>(right.content) as Node[];
        centerIndex = half-1;
        myLayout();
        return Group {
            content: [
                left,
                right,
                center
            ]
        }
    }

    /**
     * "Reparents" the node sequence newContent to its new parent Group
     * newParent, replacing any previous content,
     * after first removing them from their previous parent Group.
     */
    public function reparent(newContent:Node[], newParent:Group):Void {
        for (n in newContent) {
            if (n.parent instanceof Group) {
                delete n from (n.parent as Group).content;
            }
        }
        newParent.content = newContent;
    }

    public function shift(offset:Integer):Void {
        if(centerIndex <= 0 and offset > 0 ) {
            return;
        }
        if(centerIndex >= content.size()-1 and offset < 0) {
            return;
        }

        centerIndex -= offset;
        reparent(content[0..centerIndex-1], left);
        reparent([content[centerIndex]], center);
        reparent(Sequences.<<reverse>>(content[centerIndex+1..content.size()-1]) as Node[], right);
        myLayout();
    }

    function myLayout() {
        var startKeyframes:KeyFrame[];
        var endKeyframes:KeyFrame[];
        var duration = 0.5s;

        for(n in content) {
            def it = n as Item;
            insert KeyFrame {
                time: 0s values: [
                    it.translateX => it.translateX,
                    it.scaleX => it.scaleX,
                    it.scaleY => it.scaleY,
                    it.angle => it.angle
                ]
            } into startKeyframes;
        }

        for(n in left.content) {
            def it = n as Item;
            var newX = -left.content.size()*spacing +  spacing*indexof n + leftOffset;
            insert KeyFrame {
                time: duration values: [
                    it.translateX => newX,
                    it.scaleX => scaleSmall,
                    it.scaleY => scaleSmall,
                    it.angle => 45
                ]
            } into endKeyframes;
        }

        for(n in center.content) {
            def it = n as Item;
            insert KeyFrame {
                time: duration values: [
                    it.translateX => 0,
                    it.scaleX => 1.0,
                    it.scaleY => 1.0,
                    it.angle => 90
                ]
            } into endKeyframes;
        }

        for(n in right.content) {
            def it = n as Item;
            var newX = right.content.size()*spacing -spacing*indexof n + rightOffset;
            insert KeyFrame {
                time: duration values: [
                    it.translateX => newX,
                    it.scaleX => scaleSmall,
                    it.scaleY => scaleSmall,
                    it.angle => 135
                ]
            } into endKeyframes;
        }

        var anim = Timeline {
            keyFrames: [
                startKeyframes,
                endKeyframes
            ]
        };
        anim.play();
    }

    public function shiftToCenter(item:Item):Void {
        for(n in left.content) {
            if(n == item) {
                var index = indexof n;
                var shiftAmount = left.content.size() - index;
                shift(shiftAmount);
                return;
            }
        }
        for(n in center.content) {
            if(n == item) {
                return;
            }
        }
        for(n in right.content) {
            if(n == item) {
                var index = indexof n;
                var shiftAmount = -(right.content.size() - index);
                shift(shiftAmount);
                return;
            }
        }
    }
}
