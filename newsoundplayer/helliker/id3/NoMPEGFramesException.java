
/**
 * Copyright (C) 2001 Jonathan Hilliker
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 * Description: 
 *  An exception to be thrown if the parser is unable to find an mpeg header.
 *
 * @author:  Jonathan Hilliker
 * @version: $Id: NoMPEGFramesException.java,v 1.2 2001/10/19 03:57:53 helliker Exp $
 * Revsisions: 
 *  $Log: NoMPEGFramesException.java,v $
 *  Revision 1.2  2001/10/19 03:57:53  helliker
 *  All set for release.
 *
 *
 */

package helliker.id3;

public class NoMPEGFramesException extends Exception {
    
    /**
     * Create a NoMPEGFramesException with a default message.
     *
     */
    public NoMPEGFramesException() {
	super("The file specified is not a valid MPEG.");
    }

    /**
     * Create a NoMPEGFramesException with a specified message.
     *
     * @param msg the message for this exception
     */
    public NoMPEGFramesException( String msg ) {
	super( msg );
    }
    
} // NoMPEGFramesException
