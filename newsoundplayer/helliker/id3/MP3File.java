
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
 *  This class is a container of all the tags and data that can be extracted
 *  from the mp3 specified by the file.  If there are no id3 tags present, 
 *  tags will be created by using mutators and saving the data.
 *
 * @author:  Jonathan Hilliker
 * @version: $Id: MP3File.java,v 1.3 2001/10/28 06:08:49 helliker Exp $
 * Revsisions: 
 *  $Log: MP3File.java,v $
 *  Revision 1.3  2001/10/28 06:08:49  helliker
 *  Writes id3v2 tags before id3v1 tags.  This fixes a bug where if the filesize is
 *  changed when the id3v2 tag is written out then the id3v1 tag will not be at
 *  the end of the file and won't be recognized.
 *
 *  Revision 1.2  2001/10/19 03:57:53  helliker
 *  All set for release.
 *
 *
 */

package helliker.id3;

import java.io.*;

public class MP3File implements Comparable {

    /**
     * Write ID3v1 and ID3v2 tags whether or not they exist.  Precedence for
     * reading will be given to id3v2 tags.
     */
    public static final int BOTH_TAGS = 0;

    /**
     * Write and read from ID3v2 tags only.  An ID3v2 tag will be created
     * if an attempt is made to write.
     */
    public static final int ID3V2_ONLY = 1;

    /**
     * Write and read from ID3v1 tags only.  An ID3v1 tag will be created
     * if an attempt is made to write.
     */
    public static final int ID3V1_ONLY = 2;

    /**
     * Do not write or read from any id3 tags.
     */
    public static final int NO_TAGS = 3;

    /**
     * Only write and read tags that already exist.  Existing tags can be
     * updated but new tags will not be created.
     */
    public static final int EXISTING_TAGS_ONLY = 4;

    private final int ID3V1 = 5;
    private final int ID3V2 = 6;
    
    private ID3v1Tag id3v1 = null;
    private ID3v2Tag id3v2 = null;
    private MPEGAudioFrameHeader head = null;
    private MP3Comparator comparator = null;
    private File mp3 = null;
    private int tagType = 0;

    /**
     * Create an MP3File object that reads and writes to the file with the 
     * filename fn.  This assumes that you only want to read
     * and write id3 tags that already exist in the file.
     *
     * @param fn the filename of the mp3
     * @exception FileNotFoundException if an error occurs
     * @exception NoMPEGFramesException if an error occurs
     * @exception IOException if an error occurs
     * @exception ID3v2FormatException if an error occurs
     */
    public MP3File( String fn ) throws FileNotFoundException, 
    NoMPEGFramesException, IOException, ID3v2FormatException {

	this( new File( fn ) );
    }

    /**
     * Create an MP3File object that reads and writes to the specified 
     * file.  This assumes that you only want to read and write
     * id3 tags tha already exist in the file.
     *
     * @param mp3 the file of the mp3
     * @exception FileNotFoundException if an error occurs
     * @exception NoMPEGFramesException if an error occurs
     * @exception IOException if an error occurs
     * @exception ID3v2FormatException if an error occurs
     */
    public MP3File( File mp3 ) throws FileNotFoundException, 
    NoMPEGFramesException, IOException, ID3v2FormatException {

	this( mp3, EXISTING_TAGS_ONLY );
    }

    /**
     * Create an MP3File object that reads and writes to the file with the 
     * filename fn.  The id3 tags that are read from and written are 
     * dependant upon the tagType argument.  This could be either: BOTH_TAGS,
     * ID3V2_ONLY, ID3V1_ONLY, NO_TAGS, or EXISTING_TAGS_ONLY.
     *
     * @param fn the filename of the mp3
     * @param tagType determines what type of tags to write and read from
     * @exception FileNotFoundException if an error occurs
     * @exception NoMPEGFramesException if an error occurs
     * @exception IOException if an error occurs
     * @exception ID3v2FormatException if an error occurs
     */
    public MP3File( String fn, int tagType ) throws FileNotFoundException, 
    NoMPEGFramesException, IOException, ID3v2FormatException {

	this( new File( fn ), tagType );
    }

    /**
     * Create and MP3File object that reads and writes to the specified file.
     * The id3 tags that are read from and written are 
     * dependant upon the tagType argument.  This could be either: BOTH_TAGS,
     * ID3V2_ONLY, ID3V1_ONLY, NO_TAGS, or EXISTING_TAGS_ONLY.
     *
     * @param mp3 the file of the mp3
     * @param tagType determines what type of tags to write and read from
     * @exception FileNotFoundException if an error occurs
     * @exception NoMPEGFramesException if an error occurs
     * @exception IOException if an error occurs
     * @exception ID3v2FormatException if an error occurs
     */
    public MP3File( File mp3, int tagType ) throws FileNotFoundException, 
    NoMPEGFramesException, IOException, ID3v2FormatException {

	this.mp3 = mp3;
	this.tagType = tagType;

	id3v1 = new ID3v1Tag( mp3 );
	id3v2 = new ID3v2Tag( mp3 );
	head = new MPEGAudioFrameHeader( mp3, id3v2.getSize() );
	comparator = new MP3Comparator();
    }

    /**
     * Returns the length (in seconds) of the playing time of this mp3.  This
     * will not return an accurate value for VBR files.
     *
     * @return the playing time (in seconds) of this mp3
     */
    public long getPlayingTime() {
	long datasize = (mp3.length() * 8) - id3v2.getSize();
	long bps = head.getBitRate() * 1000;
	return datasize / bps;
    }

    /**
     * Return a formatted version of the getPlayingTime method.  The string
     * will be formated "m:ss" where 'm' is minutes and 'ss' is seconds.
     *
     * @return a formatted version of the getPlayingTime method
     */
    public String getPlayingTimeString() {
	String str;
	long time = getPlayingTime();
	long mins = time / 60;
	long secs = Math.round((((double)time / 60) - (long)(time / 60)) * 60);

	str = mins + ":";

	if( secs < 10 ) {
	    str += "0" + secs;
	}
	else {
	    str += "" + secs;
	}

	return str;
    }

    /**
     * Return the absolute path of this MP3File.
     *
     * @return the absolute path of this MP3File
     */
    public String getPath() {
	return mp3.getAbsolutePath();
    }

    /**
     * Returns the parent directory of this MP3File.
     *
     * @return the parent directory of this MP3File
     */
    public String getParent() {
	return mp3.getParent();
    }

    /**
     * Returns the filename of this MP3File.
     *
     * @return the filename of this MP3File
     */
    public String getFileName() {
	return mp3.getName();
    }

    /**
     * Return the filesize of this MP3File (in bytes).
     *
     * @return the filesize of this MP3File (in bytes)
     */
    public long getFileSize() {
	return mp3.length();
    }

    /**
     * Returns true if an id3v2 tag currently exists.
     *
     * @return true if an id3v2 tag currently exists
     */
    public boolean id3v2Exists() {
	return id3v2.tagExists();
    }

    /**
     * Returns true if an id3v1 tag currently exists.
     *
     * @return true if an id3v1 tag currently exists
     */
    public boolean id3v1Exists() {
	return id3v1.tagExists();
    }

    /**
     * Returns true if this file is an mp3.  This means simply that an
     * MPEGAudioFrameHeader was found and the layer is 3.
     *
     * @return true if this file is an mp3
     */
    public boolean isMP3() {
	return head.isMP3();
    }

    /**
     * Returns the bit rate of this mp3 in kbps.
     *
     * @return the bit rate of this mp3 in kbps
     */
    public int getBitRate() {
	return head.getBitRate();
    }

    /**
     * Returns the sample rate of this mp3 in Hz.
     *
     * @return the sample reate of this mp3 in Hz
     */
    public int getSampleRate() {
	return head.getSampleRate();
    }
    
    /**
     * Returns the emphasis of this mp3.
     *
     * @return the emphasis of this mp3
     */
    public String getMPEGEmphasis() {
	return head.getEmphasis();
    }

    /**
     * Returns a string specifying the layer of the mpeg.  Ex: Layer III
     *
     * @return a string specifying the layer of the mpeg
     */
    public String getMPEGLayer() {
	return head.getLayer();
    }

    /**
     * Returns a string specifying the version of the mpeg.  This can either 
     * be 1.0, 2.0, or 2.5.
     *
     * @return a string specifying the version of the mpeg
     */
    public String getMPEGVersion() {
	return head.getVersion();
    }

    /**
     * Return the channel mode of the mpeg.  Ex: Stereo
     *
     * @return the channel mode of the mpeg
     */
    public String getMPEGChannelMode() {
	return head.getChannelMode();
    }

    /**
     * Returns true if this mpeg is copyrighted.
     *
     * @return true if this mpeg is copyrighted
     */
    public boolean isMPEGCopyrighted() {
	return head.isCopyrighted();
    }

    /**
     * Returns true if this mpeg is the original.
     *
     * @return true if this mpeg is the original
     */
    public boolean isMPEGOriginal() {
	return head.isOriginal();
    }

    /**
     * Returns true if this mpeg is protected by CRC.
     *
     * @return true if this mpeg is protected by CRC
     */
    public boolean isMPEGProtected() {
	return head.isProtected();
    }

    /**
     * Removes id3 tags from the file.  The argument specifies which tags to
     * remove.  This can either be BOTH_TAGS, ID3V1_ONLY, ID3V2_ONLY, or
     * EXISTING_TAGS_ONLY.
     *
     * @param type specifies what tag(s) to remove
     * @exception FileNotFoundException if an error occurs
     * @exception IOException if an error occurs
     */
    public void removeTags( int type ) 
	throws FileNotFoundException, IOException {

	if( allow( ID3V1, type ) ) {
	    id3v1.removeTag();
	}
	if( allow( ID3V2, type ) ) {
	    id3v2.removeTag();
	}
    }

    /**
     * Writes the current state of the id3 tags to the file.  What tags are
     * written depends upon the tagType passed to the constructor.
     *
     * @exception FileNotFoundException if an error occurs
     * @exception IOException if an error occurs
     */
    public void writeTags()
	throws FileNotFoundException, IOException {

	// Write out id3v2 first because if the filesize is changed when an
	// id3v2 is written then the id3v1 may be moved away from the end
	// of the file which would cause it to not be recognized.
	if( allow( ID3V2 ) ) {
	    id3v2.writeTag();
	}
	if( allow( ID3V1 ) ) {
	    id3v1.writeTag();
	}
    }

    /**
     * Set the title of this mp3.
     *
     * @param title the title of the mp3
     */
    public void setTitle( String title ) {
	if( allow( ID3V1 ) ) {
	    id3v1.setTitle( title );
	}
	if( allow( ID3V2 ) ) {
	    id3v2.setTextFrame( ID3v2Frames.TITLE, title );
	}
    }

    /**
     * Set the album of this mp3.
     *
     * @param album the album of the mp3
     */
    public void setAlbum( String album ) {
	if( allow( ID3V1 ) ) {
	    id3v1.setAlbum( album );
	}
	if( allow( ID3V2 ) ) {
	    id3v2.setTextFrame( ID3v2Frames.ALBUM, album );
	}
    }

    /**
     * Set the artist of this mp3.
     *
     * @param artist the artist of the mp3
     */
    public void setArtist( String artist ) {
	if( allow( ID3V1 ) ) {
	    id3v1.setArtist( artist );
	}
	if( allow( ID3V2 ) ) {
	    id3v2.setTextFrame( ID3v2Frames.LEAD_PERFORMERS, artist );
	}
    }

    /**
     * Add a comment to this mp3.
     *
     * @param comment a comment to add to the mp3
     */
    public void setComment( String comment ) {
	if( allow( ID3V1 ) ) {
	    id3v1.setComment( comment );
	}
	if( allow( ID3V2 ) ) {
	    id3v2.setCommentFrame( "", comment );
	}
    }

    /**
     * Set the genre of this mp3.
     *
     * @param genre the genre of the mp3
     */
    public void setGenre( String genre ) {
	if( allow( ID3V1 ) ) {
	    id3v1.setGenreString( genre );
	}
	if( allow( ID3V2 ) ) {
	    id3v2.setTextFrame( ID3v2Frames.CONTENT_TYPE, genre );
	}
    }    

    /**
     * Set the year of this mp3.
     *
     * @param year of the mp3
     */
    public void setYear( String year ) {
	if( allow( ID3V1 ) ) {
	    id3v1.setYear( year );
	}
	if( allow( ID3V2 ) ) {
	    id3v2.setTextFrame( ID3v2Frames.YEAR, year );
	}
    }    

    /**
     * Set the track number of this mp3.
     *
     * @param track the track number of this mp3
     */
    public void setTrack( int track ) {
	if( allow( ID3V1 ) ) {
	    id3v1.setTrack( track );
	}
	if( allow( ID3V2 ) ) {
	    id3v2.setTextFrame( ID3v2Frames.TRACK_NUMBER, 
				String.valueOf(track) );
	}
    }

    /**
     * Set the composer of this mp3 (id3v2 only).
     *
     * @param composer the composer of this mp3
     */
    public void setComposer( String composer ) {
	if( allow( ID3V2 ) ) {
	    id3v2.setTextFrame( ID3v2Frames.COMPOSER, composer );
	}
    }

    /**
     * Set the original artist of this mp3 (id3v2 only).
     *
     * @param artist the original artist of this mp3
     */
    public void setOriginalArtist( String artist ) {
	if( allow( ID3V2 ) ) {
	    id3v2.setTextFrame( ID3v2Frames.ORIGINAL_ARTIST, artist );
	}
    }

    /**
     * Add some copyright information to this mp3 (id3v2 only).
     *
     * @param copyright copyright information related to this mp3
     */
    public void setCopyrightInfo( String copyright ) {
	if( allow( ID3V2 ) ) {
	    id3v2.setTextFrame( ID3v2Frames.COPYRIGHT_MESSAGE, copyright );
	}
    }

    /**
     * Add a link to this mp3 (id3v2 only).  This includes a description of 
     * the url and the url itself.
     *
     * @param desc a description of the url
     * @param url the url itself
     */
    public void setUserDefinedURL( String desc, String url ) {
	if( allow( ID3V2 ) ) {
	    id3v2.setUserDefinedURLFrame( desc, url );
	}
    }

    /**
     * Add a field of miscellaneous text (id3v2 only).  This includes a 
     * description of the text and the text itself.
     *
     * @param desc a description of the text
     * @param text the text itself
     */
    public void setUserDefinedText( String desc, String text ) {
	if( allow( ID3V2 ) ) {
	    id3v2.setUserDefinedTextFrame( desc, text );
	}
    }

    /**
     * Set who encoded the mp3 (id3v2 only).
     *
     * @param encBy who encoded the mp3
     */
    public void setEncodedBy( String encBy ) {
	if( allow( ID3V2 ) ) {
	    id3v2.setTextFrame( ID3v2Frames.ENCODED_BY, encBy );
	}
    }

    /**
     * Set the text of the text frame specified by the id (id3v2 only).  The
     * id should be one of the static strings specifed in ID3v2Frames class.
     * All id's that begin with 'T' (excluding "TXXX") are considered text
     * frames.
     *
     * @param id the id of the frame to set the data for
     * @param data the data to set
     */
    public void setTextFrame( String id, String data ) {
	if( allow( ID3V2 ) ) {
	    id3v2.setTextFrame( id, data );
	}
    }

    /**
     * Set the data of the frame specified by the id (id3v2 only).  The id 
     * should be one of the static strings specified in ID3v2Frames class.
     *
     * @param id the id of the frame to set the data for
     * @param data the data to set
     */
    public void setFrameData( String id, byte[] data ) {
	if( allow( ID3V2 ) ) {
	    id3v2.updateFrameData( id, data );
	}
    }

    /**
     * Returns the artist of the mp3 if set and the empty string if not.
     *
     * @return the artist of the mp3
     * @exception ID3v2FormatException if the data of the field is incorrect
     */
    public String getArtist() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.LEAD_PERFORMERS );
	}
	else if( allow( ID3V1) ) {
	    str = id3v1.getArtist();
	}

	return str;
    }

    /**
     * Returns the album of the mp3 if set and the empty string if not.
     *
     * @return the album of the mp3
     * @exception ID3v2FormatException if the data of the field is incorrect
     */
    public String getAlbum() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.ALBUM );
	}
	else if( allow( ID3V1) ) {
	    str = id3v1.getAlbum();
	}

	return str;
    }

    /**
     * Returns the comment field of this mp3 if set and the empty string if
     * not.
     *
     * @return the comment field of this mp3
     * @exception ID3v2FormatException if the data of the field is incorrect
     */
    public String getComment() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.COMMENTS );
	}
	else if( allow( ID3V1) ) {
	    str = id3v1.getComment();
	}

	return str;
    }

    /**
     * Returns the genre of this mp3 if set and the empty string if not.
     *
     * @return the genre of this mp3
     * @exception ID3v2FormatException if the data of this field is incorrect
     */
    public String getGenre() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.CONTENT_TYPE );
	}
	else if( allow( ID3V1) ) {
	    str = id3v1.getGenreString();
	}

	return str;
    }

    /**
     * Returns the title of this mp3 if set and the empty string if not.
     *
     * @return the title of this mp3
     * @exception ID3v2FormatException if the data of this field is incorrect
     */
    public String getTitle() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.TITLE );
	}
	else if( allow( ID3V1) ) {
	    str = id3v1.getTitle();
	}

	return str;
    }

    /**
     * Returns the track of this mp3 if set and the empty string if not.
     *
     * @return the track of this mp3
     * @exception ID3v2FormatException if the data of this field is incorrect
     */
    public String getTrack() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.TRACK_NUMBER );
	}
	else if( allow( ID3V1) ) {
	    str = String.valueOf( id3v1.getTrack() );
	}

	return str;
    }

    /**
     * Returns the year of this mp3 if set and the empty string if not.
     *
     * @return the year of this mp3
     * @exception ID3v2FormatException if the data of this field is incorrect
     */
    public String getYear() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.YEAR);
	}
	else if( allow( ID3V1) ) {
	    str = id3v1.getYear();
	}

	return str;
    }

    /**
     * Returns the composer of this mp3 if set and the empty string if not
     * (id3v2 only).
     *
     * @return the composer of this mp3
     * @exception ID3v2FormatException if the data of this field is incorrect
     */
    public String getComposer() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.COMPOSER );
	}

	return str;
    }

    /**
     * Returns the original artist of this mp3 if set and the empty string
     * if not (id3v2 only).
     *
     * @return the original artist of this mp3
     * @exception ID3v2FormatException if the data of this field is incorrect
     */
    public String getOriginalArtist() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.ORIGINAL_ARTIST );
	}

	return str;
    }

    /**
     * Returns the copyright info of this mp3 if set and the empty string
     * if not (id3v2 only).
     *
     * @return the copyright info of this mp3
     * @exception ID3v2FormatException if the data of this field is incorrect
     */
    public String getCopyrightInfo() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.COPYRIGHT_MESSAGE );
	}

	return str;
    }

    /**
     * Returns the user defined url of this mp3 if set and the empty string
     * if not (id3v2 only).
     *
     * @return the user defined url of this mp3
     * @exception ID3v2FormatException if the data of this field is incorrect
     */
    public String getUserDefinedURL() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.USER_DEFINED_URL );
	}

	return str;
    }

    /**
     * Returns who encoded this mp3 if set and the empty string if not 
     * (id3v2 only).
     *
     * @return who encoded this mp3
     * @exception ID3v2FormatException if the data of this field is incorrect
     */
    public String getEncodedBy() throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( ID3v2Frames.ENCODED_BY );
	}

	return str;
    }

    /**
     * Returns the textual information contained in the frame specifed by the
     * id.  If the frame does not contain any textual information or does not
     * exist, then the empty string is returned (id3v2 only).  The id should 
     * be one of the static strings defined in the ID3v2Frames class.
     *
     * @param id the id of the frame to get data from
     * @return the textual information of the frame
     * @exception ID3v2FormatException if the data of the frame is incorrect
     */
    public String getFrameDataString( String id ) throws ID3v2FormatException {
	String str = new String();

	if( allow( ID3V2 ) ) {
	    str = id3v2.getFrameDataString( id );
	}

	return str;
    }

    /**
     * Returns the data contained in the frame specified by the id (id3v2 only)
     * .  If the frame does not exist, a zero length array will be returned.
     * The id should be one of the static strings defined in the ID3v2Frames
     * class.
     *
     * @param id the id of the frame to get data from
     * @return the data contained in the frame
     */
    public byte[] getFrameDataBytes( String id ) {
	byte[] b = new byte[0];
	
	if( allow( ID3V2 ) ) {
	    b = id3v2.getFrameData( id );
	}

	return b;
    }

    /**
     * Returns the currently set tagging type.
     *
     * @return the current tagging type
     */
    public int getTaggingType() {
	return tagType;
    }

    /**
     * Set the tagging type.  This determines what type of id3 tags are 
     * read/written.  This should be one of the constants defined by this
     * class: BOTH_TAGS, ID3V1_ONLY, ID3V2_ONLY, EXISTING_TAGS_ONLY, NO_TAGS
     *
     * @param newType the new tagging type
     */
    public void setTaggingType( int newType ) {
	tagType = newType;
    }

    /**
     * Checks whether it is ok to read or write from the tag version specified
     * based on the tagType passed to the constructor.  The tagVersion 
     * parameter should be either ID3V1 or ID3V2.
     *
     * @param tagVersion the id3 version to check
     * @return true if it is ok to proceed with the read/write
     */
    private boolean allow( int tagVersion ) {
	return this.allow( tagVersion, tagType );
    }

    /**
     * Checks whether it is ok to read or write from the tag version specified
     * based on the tagType passed to the method.  The tagVersion parameter
     * should be either ID3V1 or ID3V2.  The type parameter should be either
     * BOTH_TAGS, ID3V1_ONLY, ID3V2_ONLY, NO_TAGS, or EXISTING_TAGS_ONLY.
     *
     * @param tagVersion the id3 version to check
     * @param type specifies what conditions the tags are allowed to proceed
     * @return true if it is ok to proceed with the read/write
     */
    private boolean allow( int tagVersion, int type ) {
	boolean retval = false;

	if( tagVersion == ID3V1 ) {
	    retval = ((type == EXISTING_TAGS_ONLY) && id3v1.tagExists()) || 
		(type == ID3V1_ONLY) || (type == BOTH_TAGS);
	}
	else if( tagVersion == ID3V2 ) {
	    retval = ((type == EXISTING_TAGS_ONLY) && id3v2.tagExists()) || 
		(type == ID3V2_ONLY) || (type == BOTH_TAGS);
	}

	return retval;
    }

    /**
     * Return a string representation of this object.  This includes all the 
     * information contained within the mpeg header and id3 tags as well as
     * certain file attributes.
     *
     * @return a string representation of this object
     */
    public String toString() {
	return "MP3File" + "\nPath:\t\t\t\t" + mp3.getAbsolutePath() + 
	    "\nFileSize:\t\t\t" + mp3.length() + " bytes\nPlayingTime:\t\t\t" 
	    + getPlayingTimeString() + "\n" + head + "\n" + id3v1 + "\n" + 
	    id3v2;
    }

    /**
     * Returns true if the object o is equal to this MP3File.
     *
     * @param o the object to compare
     * @return true if the object o is equal to this MP3File
     */
    public boolean equals( Object o ) {
	return mp3.equals( o );
    }

    /**
     * Compare this MP3File to the specified object.  The comparison 
     * implementation comes from the MP3Comparator class, look there for
     * details on the comparison method.
     *
     * @param o the object to compare to this one
     * @return a positive number if this object is greater than the other,
     *         0 if the object are equal, or a negative number if this object
     *         is less than the other
     */
    public int compareTo( Object o ) {
	return comparator.compare( this, o );
    }

} // MP3File
