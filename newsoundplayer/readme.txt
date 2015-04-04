-----------------------------------------------------------------------
jd3Lib - first release alpha1
-----------------------------------------------------------------------

Well, here it is.  All you need to do is compile everything
in the helliker/id3 directory.  The documentation is in the 
javadoc folder.  The main object for the library is the MP3File
object.  This ties together all the different versions of the 
id3 tags for you.  It also gets MPEG information.  I have done very 
little testing right now, but most of what I have tested has worked 
fine.  I haven't been able to find a sample tag or an mp3 with an 
extended header or a footer, so I haven't tested that at all.  If 
someone has one, please send it to me!  As of right now, this
library only works with id3v1 and id3v2.3-4 tags.  I plan on 
adding support for the reading of id3v2.2 tags.  Also it seems
that the MP3File object is really big.  I tried storing about 100
of them in a Playlist object and I got an out of memory exception!
It may have been jacked and read too much though because the mp3s
I was trying to read was id3v2.2 and at that time I didn't block out
tags with that version. 

Here's a list of features:
- Reads, creates, updates, and removes id3v2.3 and id3v2.4 tags
- Reads, creates, updates, and removes id3v1 tags
- Extracts MPEG data such as bit rate, sample rate, channel mode, etc.
- Calculates playing time of mp3 from mpeg information (no good w/VBR)
- Can read and create Winamp styled playlists
- Offers other utility classes such as MP3FileFilter and MP3Comparator
- NullsoftID3GenreTable object keeps a list of genres for you and can
  automatically determine the id3v1 genre from an id3v2 string or the
  other way around

Planned updates:
- Add support for reading of id3v2.2
- Improve Playlist class (it doesn't work well right now)
- Test and fix bugs!

Contact Info:
helliker13@hotmail.com
jd3lib.sourceforge.net
-----------------------------------------------------------------------
(c) 2001 Jonathan Hilliker