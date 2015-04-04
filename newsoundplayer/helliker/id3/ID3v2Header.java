
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
 *  This class reads all the information in the header of an id3v2 tag.
 *
 * @author:  Jonathan Hilliker
 * @version: $Id: ID3v2Header.java,v 1.2 2001/10/19 03:57:53 helliker Exp $
 * Revsisions: 
 *  $Log: ID3v2Header.java,v $
 *  Revision 1.2  2001/10/19 03:57:53  helliker
 *  All set for release.
 *
 *
 */

package helliker.id3;

import java.io.*;

public class ID3v2Header {
    
    private final String TAG_START = "ID3";
    private final String ENC_TYPE = "Cp437";
    private final int HEAD_SIZE = 10;
    private final int HEAD_LOCATION = 0;
    private final int NEW_MAJOR_VERSION = 3; // So winamp will accept it...
    private final int NEW_MINOR_VERSION = 0;

    private File mp3 = null;
    private boolean headerExists;
    private int majorVersion;
    private int minorVersion;
    private boolean unsynchronisation;
    private boolean extended;
    private boolean experimental;
    private boolean footer;
    private int tagSize;

    /**
     * Create an id3v2header linked to the file passed as a parameter.  An
     * attempt will be made to read the header from the file.  If a header
     * exists, then information in the header will be extracted.  If a header
     * doesn't exist, default data will be used.
     *
     * @param mp3 the file to attempt to read data from
     * @exception FileNotFoundException if an error occurs
     * @exception IOException if an error occurs
     */
    public ID3v2Header( File mp3 ) throws FileNotFoundException, IOException {
	this.mp3 = mp3;
	
	majorVersion = NEW_MAJOR_VERSION;
	minorVersion = NEW_MINOR_VERSION;
	unsynchronisation = false;
	extended = false;
	experimental = false;
	footer = false;
	tagSize = 0;

	headerExists = checkHeader();

	if( headerExists ) {
	    readHeader();
	}
    }

    /**
     * Checks to see if there is an id3v2 header in the file provided to the
     * constructor.
     *
     * @return true if an id3v2 header exists in the file
     * @exception FileNotFoundException if an error occurs
     * @exception IOException if an error occurs
     */
    private boolean checkHeader() throws FileNotFoundException, IOException {
	boolean exists = false;
	RandomAccessFile raf = new RandomAccessFile( mp3, "r" );
	raf.seek( HEAD_LOCATION );
	byte[] buf = new byte[HEAD_SIZE];

	if( raf.read( buf ) != HEAD_SIZE ) {
	    throw new IOException( "Error encountered finding id3v2 header" );
	}

	String result = new String( buf, ENC_TYPE );
	if( result.substring( 0, TAG_START.length() ).equals( TAG_START ) ) {
	    if( (buf[3] < 0xff) && (buf[4] < 0xff) ) {
		if( (buf[6] < 0x80) && (buf[7] < 0x80) && 
		    (buf[8] < 0x80) && (buf[9] < 0x80) ) {

		    exists = true;
		}
	    }
	}

	raf.close();

	return exists;
    }

    /**
     * Extracts the information from the header.
     *
     * @exception FileNotFoundException if an error occurs
     * @exception IOException if an error occurs
     */
    private void readHeader() throws FileNotFoundException, IOException {
	RandomAccessFile raf = new RandomAccessFile( mp3, "r" );
	raf.seek( HEAD_LOCATION );
	byte[] head = new byte[HEAD_SIZE];

	if( raf.read( head ) != HEAD_SIZE ) {
	    throw new IOException( "Error encountered reading id3v2 header" );
	}

	majorVersion = (int)head[3];

	if( majorVersion <= NEW_MAJOR_VERSION ) {
	    minorVersion = (int)head[4];
	    unsynchronisation = BinaryParser.bitSet( head[5], 7 );
	    extended = BinaryParser.bitSet( head[5], 6 );
	    experimental = BinaryParser.bitSet( head[5], 5 );
	    footer = BinaryParser.bitSet( head[5], 4 );
	    
	    byte[] size = { head[6], head[7], head[8], head[9] };
	    tagSize = BinaryParser.convertToInt( size );
	}

	raf.close();
    }

    /**
     * Return an array of bytes representing the header.  This can be used
     * to easily write the header to a file.
     *
     * @return a binary representation of this header
     */
    public byte[] getBytes() {
	byte[] b = new byte[HEAD_SIZE];
	int bytesCopied = 0;

	try {
	    System.arraycopy( TAG_START.getBytes(ENC_TYPE), 0, b, bytesCopied, 
			      TAG_START.length() );
	    bytesCopied += TAG_START.length();
	    b[bytesCopied++] = (byte)majorVersion;
	    b[bytesCopied++] = (byte)minorVersion;
	    b[bytesCopied++] = getFlagByte();
	    System.arraycopy( BinaryParser.convertToBytes(tagSize), 0, b, 
			      bytesCopied, 4 );
	    bytesCopied += 4;
	}
	catch( UnsupportedEncodingException e ) {
	    // This should never happend because the encoding is constant
	    e.printStackTrace();
	}

	return b;
    }

    /**
     * A helper function for the getBytes function that returns a byte with
     * the proper flags set.
     *
     * @return the flags byte of this header
     */
    private byte getFlagByte() {
	byte ret = 0;

	if( unsynchronisation ) {
	    ret = BinaryParser.setBit( ret, 7 );
	}
	if( extended ) {
	    ret = BinaryParser.setBit( ret, 6 );
	}
	if( experimental ) {
	    ret = BinaryParser.setBit( ret, 5 );
	}
	if( footer ) {
	    ret = BinaryParser.setBit( ret, 4 );
	}

	return ret;
    }

    /**
     * Returns true if a header exists
     *
     * @return true if a header exists
     */
    public boolean headerExists() {
	return headerExists;
    }

    /**
     * Returns the size (in bytes) of this header.  This is 10 if the header
     * exists and 0 otherwise
     *
     * @return the size of this header
     */
    public int getHeaderSize() {
	int retval = 0;

	if( headerExists ) {
	    retval = HEAD_SIZE;
	}

	return retval;
    }

    /**
     * Returns the size (in bytes) of the frames and/or extended header portion
     * of the id3v2 tag according to the size field in the header.
     *
     * @return the size field of the header
     */
    public int getTagSize() {
	return tagSize;
    }

    /**
     * Sets the size of the frames and/or extended header.  If this function
     * is called, the headerExists function will return true.  This is called
     * every time a frame is updated, added, or removed.
     *
     * @param size a value of type 'int'
     */
    public void setTagSize( int size ) {
	if( size > 0 ) {
	    tagSize = size;
	    headerExists = true;
	}
    }

    /**
     * Returns the major version of this id3v2 tag.
     *
     * @return the major version of this id3v2 tag.
     */
    public int getMajorVersion() {
	return majorVersion;
    }

    /**
     * Return the minor version/revision of this id3v2 tag.
     *
     * @return the minor version/revision of this id3v2 tag.
     */
    public int getMinorVersion() {
	return minorVersion;
    }

    /**
     * Returns true if the unsynchronisation bit is set in this header.
     *
     * @return true if the unsynchronisation bit is set in this header.
     */
    public boolean getUnsynchronisation() {
	return unsynchronisation;
    }

    /**
     * Set the unsynchronisation flag for this header.
     *
     * @param unsynch the new value of the unsynchronisation flag
     */
    public void setUnsynchronisation( boolean unsynch ) {
	unsynchronisation = unsynch;
    }

    /**
     * Returns true if this tag has an extended header.
     *
     * @return true if this tag has an extended header
     */
    public boolean getExtendedHeader() {
	return extended;
    }

    /**
     * Set the value of the extended header bit of this header.
     *
     * @param extend the new value of the extended header bit
     */
    public void setExtendedHeader( boolean extend ) {
	extended = extend;
    }

    /**
     * Returns true if the experimental bit of this header is set.
     *
     * @return true if the experimental bit of this header is set
     */
    public boolean getExperimental() {
	return experimental;
    }

    /**
     * Set the value of the experimental bit of this header.
     *
     * @param experiment the new value of the experimental bit
     */
    public void setExperimental( boolean experiment ) {
	experimental = experiment;
    }

    /**
     * Returns true if this tag has a footer.
     *
     * @return true if this tag has a footer
     */
    public boolean getFooter() {
	return footer;
    }

    /**
     * Sets the value of the footer bit for this header.
     *
     * @param foot the new value of the footer bit for this header
     */
    public void setFooter( boolean foot ) {
	footer = foot;
    }

    /**
     * Return a string representation of this object.  Contains all information
     * contained within.
     *
     * @return a string representation of this object
     */
    public String toString() {
	return "ID3v2." + getMajorVersion() + "." + getMinorVersion() + "\n" + 
	    "TagSize:\t\t\t" + getTagSize() + 
	    " bytes\nUnsynchronisation:\t\t" 
	    + getUnsynchronisation() + "\nExtended Header:\t\t" + 
	    getExtendedHeader() + "\nExperimental:\t\t\t" + getExperimental() +
	    "\nFooter:\t\t\t\t" + getFooter();
    }
    
} // ID3v2Header
