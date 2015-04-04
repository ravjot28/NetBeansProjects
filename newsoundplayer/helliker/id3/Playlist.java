
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
 *  This class is treated as a winamp styled playlist.  It is essentially a
 *  collection of MP3Files that can be initalised from a file.  Playlists
 *  can also be written based on it's data.
 *
 * @author:  Jonathan Hilliker
 * @version: $Id: Playlist.java,v 1.2 2001/10/19 03:57:53 helliker Exp $
 * Revsisions: 
 *  $Log: Playlist.java,v $
 *  Revision 1.2  2001/10/19 03:57:53  helliker
 *  All set for release.
 *
 *
 */

package helliker.id3;

import java.io.*;
import java.util.*;

public class Playlist extends LinkedList {
    
    /**
     * Reads in mp3s from a directory and adds them to the this playlist.  The
     * recurse parameter should be set if you wish to grab mp3s from 
     * directories as well.
     *
     * @param dir the directory to look for mp3s in
     * @param recurse whether or not to recurse subdirectories
     * @exception IOException if the file specified is not a directory
     */
    public void loadFromDirectory( File dir, boolean recurse ) 
	throws IOException {

	if( dir.isDirectory() ) {
	    File[] files = dir.listFiles( new MP3FileFilter(true) );
	    MP3File mp3 = null;

	    for( int i = 0; i < files.length; i++ ) {
		if( files[i].isFile() ) {
		    try {
			mp3 = new MP3File( files[i] );
			this.add( mp3 );
		    }
		    catch( Exception e ) {
			// Do nothing.  Bad mp3, don't add.
		    }
		}
		else if( recurse ) {
		    loadFromDirectory( files[i], recurse );
		}
	    }
	}
	else {
	    throw new IOException( "Error loading playlist from a directory: "
				   + dir.getAbsolutePath() + " is not a " +
				   "directory" );
	}
    }

    /**
     * Reads from an existing winamp playlist and reads in the files contained
     * in that playlist.
     *
     * @param m3uFile the playlist file
     * @exception PlaylistException if the file is corrupt
     * @exception FileNotFoundException if an error occurs
     * @exception IOException if an error occurs
     */
    public void loadFromFile( File m3uFile ) 
	throws PlaylistException, FileNotFoundException, IOException {

	FileReader in = new FileReader( m3uFile );
	BufferedReader reader = new BufferedReader( in );
	String str = reader.readLine();
	MP3File mp3 = null;
	
	if( !str.equals( "#EXTM3U\r\n" ) ) {
	    while( (str = reader.readLine()) != null ) {
		if( str.indexOf( "EXTINF:" ) != -1 ) {
		    str = reader.readLine();

		    try {
			mp3 = new MP3File( str );
			this.add( mp3 );
		    }
		    catch( Exception e ) {
			// Do nothing, just don't add it
		    }
		}
		else {
		    throw new PlaylistException();
		}
	    }   
	}
	else {
	    throw new PlaylistException();
	}

	reader.close();
	in.close();
    }

    /**
     * Creates a winamp styled playlist from the MP3Files contained in this
     * playlist.  If the destination is a directory, then the file will be
     * created in that directory with the same name as the directory with a
     * ".m3u" extension added.  If the destination is a file then the playlist
     * will be saved to that file.
     *
     * @param dest where to save the playlist
     * @exception IOException if an error occurs
     */
    public void writeToFile( File dest ) throws IOException {
	File m3u = dest;

	if( dest.isDirectory() ) {
	    m3u = new File( dest, dest.getName() + ".m3u" );
	}

	FileOutputStream out = new FileOutputStream( m3u );
	PrintWriter printer = new PrintWriter( out );
	printer.print( this.toString() );
	printer.close();
	out.close();
    }

    /**
     * Return a string representation of this object.  Actually returns the
     * the text as it would be written to a playlist file.
     *
     * @return a string representation of this object
     */
    public String toString() {
//	Collections.sort( this );
	String str = "#EXTM3U\r\n";
	Iterator it = this.iterator();
	MP3File mp3 = null;
	String artist = new String();
	String title = new String();

	while( it.hasNext() ) {
	    mp3 = (MP3File)it.next();
	    str += "#EXTINF:" + mp3.getPlayingTime() + ",";

	    try {
		artist = mp3.getArtist();
	    }
	    catch( ID3v2FormatException e ) {
	    }

	    try {
		title = mp3.getTitle();
	    }
	    catch( ID3v2FormatException e ) {
	    }

	    if( (artist.trim().length() == 0) || 
		(title.trim().length() == 0) ) {

		artist = mp3.getFileName();
		artist = artist.substring( 0, artist.length() - 4 );
	    }

	    str += artist + " - " + title + "\r\n";
	    str += mp3.getPath() + "\r\n";
	}

	return str;
    }

} // Playlist
																			