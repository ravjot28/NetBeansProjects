
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
 *  This file filter only accepts files with a ".mp3" extension.
 *
 * @author:  Jonathan Hilliker
 * @version: $Id: MP3FileFilter.java,v 1.2 2001/10/19 03:57:53 helliker Exp $
 * Revsisions: 
 *  $Log: MP3FileFilter.java,v $
 *  Revision 1.2  2001/10/19 03:57:53  helliker
 *  All set for release.
 *
 *
 */

package helliker.id3;

import java.io.*;

public class MP3FileFilter implements FileFilter {
    
    private boolean allowDirectories;

    /**
     * Create a default MP3FileFilter.  The allowDirectories field will 
     * default to false.
     *
     */
    public MP3FileFilter() {
	this( false );
    }

    /**
     * Create an MP3FileFilter.  If allowDirectories is true, then this filter
     * will accept directories as well as mp3 files.  If it is false then
     * only mp3 files will be accepted.
     *
     * @param allowDirectories whether or not to accept directories
     */
    public MP3FileFilter( boolean allowDirectories ) {
	this.allowDirectories = allowDirectories;
    }

    /**
     * Determines whether or not the file is an mp3 file.  If the file is 
     * a directory, whether or not is accepted depends upon the 
     * allowDirectories flag passed to the constructor.
     *
     * @param pathname the file to test
     * @return true if this file or directory should be accepted
     */
    public boolean accept( File pathname ) {
	boolean retval = false;

	if( pathname.isFile() ) {
	    retval = (pathname.getName().lastIndexOf(".mp3") == 
		      pathname.getName().length() - 4);
	}
	else {
	    retval = allowDirectories;
	}

	return retval;
    }

} // MP3FileFilter
