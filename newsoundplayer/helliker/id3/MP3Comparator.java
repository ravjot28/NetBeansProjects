
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
 *  This class is a comparator that is ideal for sorting mp3s.  The MP3File 
 *  class uses this object to implement its compareTo method.  This
 *  works really well for playlists too because it has an order of precedence
 *  that attempts to sort the mp3s so that the tracks of the same artists and
 *  albums are together and that they are sorted by track number.  If an error
 *  occurs while doing the comparison, the paths of the mp3s are compared.
 *
 * @author:  Jonathan Hilliker
 * @version: $Id: MP3Comparator.java,v 1.2 2001/10/19 03:57:53 helliker Exp $
 * Revsisions: 
 *  $Log: MP3Comparator.java,v $
 *  Revision 1.2  2001/10/19 03:57:53  helliker
 *  All set for release.
 *
 *
 */

package helliker.id3;

public class MP3Comparator implements java.util.Comparator {
    
    /**
     * Returns true if the specified object is an MP3Comparator
     *
     * @param obj the object to test
     * @return true if the object is an MP3Comparator
     */
    public boolean equals( Object obj ) {
	return (obj instanceof MP3Comparator);
    }

    /**
     * Compares the objects.  Non-MP3File objects will always be less then
     * an MP3File object and if neither objects are MP3Files then they are
     * considered equal.  A series of tests are conducted to determine the
     * the outcome.  First the artist is tested, then the album, then the 
     * track, then the title, then the path.
     *
     * @param o1 one object to compare
     * @param o2 another object to compare
     * @return a positive number if o1 > o2, zero if o1 = o2, and a negative
     *         number if o1 < o2
     */
    public int compare( Object o1, Object o2 ) {
	int retval = 0;

	if( (o1 instanceof MP3File) && (o2 instanceof MP3File) ) {
	    MP3File m1 = (MP3File)o1;
	    MP3File m2 = (MP3File)o2;

	    try {
		if( accept( m1.getArtist(), m2.getArtist() ) ) {
		    retval = m1.getArtist().compareToIgnoreCase( 
							  m2.getArtist() );
		}
		else if( accept( m1.getAlbum(), m2.getAlbum() ) ) {
		    retval = m1.getAlbum().compareToIgnoreCase( m2.getAlbum());
		}
		else if( accept( m1.getTrack(), m2.getTrack() ) ) {
		    int i1, i2;
		    
		    try {
			i1 = Integer.parseInt( m1.getTrack() );
			i2 = Integer.parseInt( m2.getTrack() );
			retval = i1 - i2;
		    }
		    catch( NumberFormatException e ) {
			retval = m1.getPath().compareToIgnoreCase( 
							        m2.getPath() );
		    }
		}
		else if( accept( m1.getTitle(), m2.getTitle() ) ) {
		    retval = m1.getTitle().compareToIgnoreCase( m2.getTitle());
		}    
		else {
		    retval = m1.getPath().compareToIgnoreCase( m2.getPath() );
		}
	    }
	    catch( ID3v2FormatException e ) {
		retval = m1.getPath().compareToIgnoreCase( m2.getPath() );
	    }
	}
	else {
	    if( o1 instanceof MP3File ) {
		retval = 1;
	    }
	    else if( o2 instanceof MP3File ) {
		retval = -1;
	    }
	    else {
		retval = 0;
	    }
	}

	return retval;
    }
    
    /**
     * Returns true if the two parameters are acceptable comparison values.  
     * In order to be acceptable, both parameters must not be empty and they
     * must not be equal.
     *
     * @param str1 the first parameter
     * @param str2 the second parameter
     * @return true if the two parameters are acceptable comparison values
     */
    private boolean accept( String str1, String str2 ) {
	return ( !str1.equalsIgnoreCase(str2) && (str1.length() != 0) &&
		 (str2.length() != 0) );
    }

} // MP3Comparator
