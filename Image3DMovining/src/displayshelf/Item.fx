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

import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.effect.*;
import javafx.scene.input.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;

import java.lang.Math;

public class Item extends CustomNode {
    public var position:Integer = 0;
    public var angle = 45.0;
    public var shelf:DisplayShelf;
    public-init var image:Image;

    def width = 200;
    def height = 200;
    def radius = width/2;
    def back = height/10;

    var lx = bind radius - Math.sin(Math.toRadians(angle))*radius - 1;
    var rx = bind radius + Math.sin(Math.toRadians(angle))*radius + 1;
    var uly = bind 0 - Math.cos(Math.toRadians(angle))*back;
    var ury = bind 0 + Math.cos(Math.toRadians(angle))*back;

    function getPT(t:Number):PerspectiveTransform {
        return PerspectiveTransform {
            ulx: lx
            uly: uly
            urx: rx
            ury: ury
            lrx: rx
            lry: height + uly
            llx: lx
            lly: height + ury
        }
    }

    override public function create():Node {
        return Group {
            content: [
                Group {
                    content: [
                        ImageView { image: image },
                        Rectangle {
                            width: image.width
                            height: image.height
                            fill: Color.TRANSPARENT
                            stroke: Color.BLACK
                            smooth: true
                        }
                    ]
                    effect: bind PerspectiveTransform {
                        ulx: lx
                        uly: uly
                        urx: rx
                        ury: ury
                        lrx: rx
                        lry: height + uly
                        llx: lx
                        lly: height + ury
                    }
                },
                Rectangle {
                    translateX: bind lx
                    width: bind rx-lx
                    height: height
                    fill: Color.TRANSPARENT
                    blocksMouse: true
                    onMousePressed:function(e:MouseEvent) {
                        shelf.shiftToCenter(this);
                    };
                }
            ]
        }
    }
}