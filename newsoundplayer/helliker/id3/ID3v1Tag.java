
/**
 * This class extracts and writes ID3v1 tags to files
 *//**
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
 *  This class reads and writes id3v1 tags from/to files.
 *
 * @author:  Jonathan Hilliker
 * @version: $Id: ID3v1Tag.java,v 1.2 2001/10/19 03:57:53 helliker Exp $
 * Revsisions: 
 *  $Log: ID3v1Tag.java,v $
 *  Revision 1.2  2001/10/19 03:57:53  helliker
 *  All set for release.
 *
 *
 */

package helliker.id3;

import java.io.*;

public class ID3v1Tag  {

    private final int TAG_SIZE = 128;
    private final int TITLE_SIZE = 30;
    private final int ARTIST_SIZE = 30;
    private final int ALBUM_SIZE = 30;
    private final int YEAR_SIZE = 4;
    private final int COMMENT_SIZE = 29;
    private final int TRACK_LOCATION = 126;
    private final int GENRE_LOCATION = 127;
    private final int MAX_GENRE = 255;
    private final int MAX_TRACK = 255;
    private final String ENC_TYPE = "Cp437";
    private final String TAG_START = "TAG";

    private File mp3 = null;
    private boolean headerExists = false;
    private String title = null;
    private String artist = null;
    private String album = null;
    private String year = null;
    private String comment = null;
    private int genre;
    private int track;
    
    /**
     * Create an id3v1tag from the file specified.  If the file contains a 
     * tag, the information is automatically extracted.
     *
     * @param mp3 the file to read/write the tag to
     * @exception FileNotFoundException if an error occurs
     * @exception IOException if an error occurs
     */
    public ID3v1Tag( File mp3 ) throws FileNotFoundException, IOException {
	this.mp3 = mp3;

	title = new String();
	artist = new String();
	album = new String();
	year = new String();
	comment = new String();
	genre = (int)'\0';
	track = (int)'\0';

	headerExists = checkHeader();

	if( headerExists ) {
	    readTag();
	}
    }

    /**
     * Checks whether a header for the id3 tag exists yet
     *
     * @return true if a tag is found
     * @exception FileNotFoundException if an error occurs
     * @exception IOException if an error occurs
     */
    private boolean checkHeader() throws FileNotFoundException, IOException {
	RandomAccessFile raf = new RandomAccessFile( mp3, "r" );
	boolean retval = false;

	if( raf.length() > TAG_SIZE ) {
	    raf.seek( raf.length() - TAG_SIZE );
	    byte[] buf = new byte[3];
	    
	    if( raf.read( buf ) != 3 ) {
		throw new IOException("Error encountered reading ID3 header");
	    }
	    else {
		String result = new String( buf, 0, 3, ENC_TYPE );
		retval = result.equals( TAG_START );
	    }
	}

	raf.close();

	return retval;
    }

    /**
     * Reads the data from the id3v1 tag
     *
     * @exception FileNotFoundException if an error occurs
     * @exception IOException if an error occurs
     */
    private void readTag() throws FileNotFoundException, IOException {
	RandomAccessFile raf = new RandomAccessFile( mp3, "r" );
	raf.seek( raf.length() - TAG_SIZE );
	byte[] buf = new byte[TAG_SIZE];
	raf.read( buf, 0, TAG_SIZE );
	String tag = new String( buf, 0, TAG_SIZE, ENC_TYPE ); 
	int start = TAG_START.length();
	title = tag.substring( start, start += TITLE_SIZE );
	artist = tag.substring( start, start += ARTIST_SIZE );
	album = tag.substring( start, start += ALBUM_SIZE );
	year = tag.substring( start, start += YEAR_SIZE );
	comment = tag.substring( start, start += COMMENT_SIZE );
	track = (int)tag.charAt( TRACK_LOCATION );
	genre = (int)tag.charAt( GENRE_LOCATION );
	raf.close();
    }

    /**
     * Writes the information in this tag to the file specified in the 
     * constructor.  If a tag does not exist, one will be created.  If a tag
     * already exists, it will be overwritten.
     *
     * @exception FileNotFoundException if an error occurs
     * @exception IOException if an error occurs
     */
    public void writeTag() throws FileNotFoundException, IOException {

	RandomAccessFile raf = new RandomAccessFile( mp3, "rw" );
	
	if( headerExists ) {
	    raf.seek( raf.length() - TAG_SIZE );
	}
	else {
	    raf.seek( raf.length() );
	}

	try {
	    raf.write( TAG_START.getBytes( ENC_TYPE ) );
	    raf.write( getFieldBytes( title, TITLE_SIZE ) );
	    raf.write( getFieldBytes( artist, ARTIST_SIZE ) );
	    raf.write( getFieldBytes( album, ALBUM_SIZE ) );
	    raf.write( getFieldBytes( year, YEAR_SIZE ) );
	    raf.write( getFieldBytes( comment, COMMENT_SIZE ) );
	    raf.write( (byte)track );
	    raf.write( (byte)genre );
	}
	catch( UnsupportedEncodingException e ) {
	    // Do nothing, this shouldn't happen
	}

	raf.close();
	headerExists = true;
    }

    /**
     * Converts a string to an array of bytes with the length specified
     *
     * @param str the string to convert
     * @param length the size of the byte array
     * @return the array of bytes converted from the string
     */
    private byte[] getFieldBytes( String str, int length ) 
	throws UnsupportedEncodingException {

	StringBuffer buf = new StringBuffer( str );
	
	for( int i = str.length(); i < length; i++ ) {
	    buf.append( '\0' );
	}

	return buf.toString().getBytes( ENC_TYPE );
    }

    /**
     * Removes the id3v1 tag from the file specified in the constructor
     *
     * @return true if the tag was removed successfully
     * @exception FileNotFoundException if an error occurs
     * @exception IOException if an error occurs
     */
    public void removeTag() throws FileNotFoundException, IOException {
	if( headerExists ) {
	    RandomAccessFile raf = new RandomAccessFile( mp3, "rw" );
	    Long bufSize = new Long( raf.length() - TAG_SIZE );
	    // Possible loss of precision here, but I doubt there will be a 
	    // 2 billion byte mp3 out there
	    byte[] buf = new byte[bufSize.intValue()];

	    if( raf.read( buf ) != bufSize.intValue() ) {
		throw new IOException( "Error encountered while removing tag");
	    }

	    raf.setLength( bufSize.longValue() );
	    raf.seek( 0 );
	    raf.write( buf );
	    raf.close();

	    headerExists = false;
	}
    }

    /**
     * Return the genre name based on the ID3/Nullsoft standards.  If the genre
     * value is not valid, null is returned.
     *
     * @return return the genre name or null if the genre value is not valid
     */
    public String getGenreString() {
	return NullsoftID3GenreTable.getGenre( genre );
    }

    /**
     * Attempt to set the genre value of this tag from the string specified.  
     * The value returned is based on the ID3/Nullsoft standards.  Returns 
     * true if a match is found in the table and false otherwise.
     *
     * @param str the string value of the genre to attempt to set
     * @return true if a match is found, false otherwise
     */
    public boolean setGenreString( String str ) {
	int result = NullsoftID3GenreTable.getGenre( str );
	boolean retval = false;

	if( result != -1 ) {
	    genre = result;
	    retval = true;
	}

	return retval;
    }

    /**
     * Checks if a tag exists
     *
     * @return true if a tag exists
     */
    public boolean tagExists() {
	return headerExists;
    }

    /**
     * Return the title field of the tag
     *
     * @return the title field of the tag
     */
    public String getTitle() {
	return title.trim();;
    }

    /**
     * Set the title field of the tag.  The maximum size of the String is 30.
     * If the size exceeds the maximum size, the String will be truncated.
     *
     * @param newTitle the title for the tag
     */
    public void setTitle( String newTitle ) {
	if( newTitle.length() > TITLE_SIZE ) {
	    title = newTitle.substring( 0, TITLE_SIZE );
	}
	else {
	    title = newTitle;
	}
    }

    /**
     * Return the artist field of the tag
     *
     * @return the artist field of the tag
     */
    public String getArtist() {
	return artist.trim();
    }

    /**
     * Set the artist field of the tag.  The maximum size of the String is 30.
     * If the size exceeds the maximum size, the String will be truncated.
     *
     * @param newArtist the artist for the tag
     */
    public void setArtist( String newArtist ) {
	if( newArtist.length() > ARTIST_SIZE ) {
	    artist = newArtist.substring( 0, ARTIST_SIZE );
	}
	else {
	    artist = newArtist;
	}
    }

    /**
     * Return the album field of the tag
     *
     * @return the album field of the tag
     */
    public String getAlbum() {
	return album.trim();
    }

    /**
     * Set the album field of the tag.  The maximum size of the String is 30.
     * If the size exceeds the maximum size, the String will be truncated.
     *
     * @param newAlbum the album for the tag
     */
    public void setAlbum( String newAlbum ) {
	if( newAlbum.length() > ALBUM_SIZE ) {
	    album = newAlbum.substring( 0, ALBUM_SIZE );
	}
	else {
	    album = newAlbum;
	}
    }

    /**
     * Return the year field of the tag
     *
     * @return the year field of the tag
     */
    public String getYear() {
	return year.trim();
    }

    /**
     * Set the year field of the tag.  The maximum size of the String is 4.
     * If the size exceeds the maximum size, the String will be truncated.
     *
     * @param newYear the year for the tag
     */
    public void setYear( String newYear ) {
	if( newYear.length() > YEAR_SIZE ) {
	    year = newYear.substring( 0, YEAR_SIZE );
	}
	else {
	    year = newYear;
	}
    }

    /**
     * Return the comment field of the tag
     *
     * @return the comment field of the tag
     */
    public String getComment() {
	return comment.trim();
    }

    /**
     * Set the comment field of the tag.  The maximum size of the String is 30.
     * If the size exceeds the maximum size, the String will be truncated.
     *
     * @param newComment the comment of the tag
     */
    public void setComment( String newComment ) {
	if( comment.length() > COMMENT_SIZE ) {
	    comment = newComment.substring( 0, COMMENT_SIZE );
	}
	else {
	    comment = newComment;
	}
    }

    /**
     * Return the track field of the tag
     *
     * @return the track field of the tag
     */
    public int getTrack() {
	return track;
    }

    /**
     * Set the track field of the tag.  The track number has to be between 0
     * and 255.  If it is not, nothing will happen.
     *
     * @param newTrack the track of the tag
     */
    public void setTrack( int newTrack ) {
	if( (newTrack <= MAX_TRACK) && (newTrack >= 0) ) {
	    track = newTrack;
	}
    }

    /**
     * Return the genre field of the tag
     *
     * @return the genre field of the tag
     */
    public int getGenre() {
	return genre;
    }

    /**
     * Set the genre field of the tag.  This probably should not be greater
     * than 115, but supports values from 0-255.
     *
     * @param newGenre the genre of the tag
     * @exception ID3FieldDataException if the value supplie is invalid
     */
    public void setGenre( int newGenre ) throws ID3FieldDataException {
	if( (newGenre <= MAX_GENRE) && (newGenre >= 0) ) {
	    genre = newGenre;
	}
	else {
	    throw new ID3FieldDataException( 
	       "Invalid genre value.  Must be between 0 and 255." );
	}
    }

    /**
     * Return the size in bytes of the tag.  This returns 128 if the tag exists
     * and 0 otherwise.
     *
     * @return the size of the tag in bytes
     */
    public int getSize() {
	int retval = 0;

	if( headerExists ) {
	    retval = TAG_SIZE;
	}

	return retval;
    }
    
    public String toString() {
	return "ID3v1.0\nTagSize:\t\t\t" + getSize() + " bytes\nTitle:\t\t\t\t"
	    + getTitle() + "\nArtist:\t\t\t\t" + getArtist() + 
	    "\nAlbum:\t\t\t\t" + getAlbum() + "\nYear:\t\t\t\t" + getYear() + 
	    "\nComment:\t\t\t" + getComment() + "\nTrack:\t\t\t\t" + 
	    getTrack() + "\nGenre:\t\t\t\t" + getGenreString();
    }

} // ID3v1Tag








