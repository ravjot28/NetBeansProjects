package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITFileOrCDTrack Interface
 */
@IID("{00D7FE99-7868-4CC7-AD9E-ACFD70D09566}")
public interface IITFileOrCDTrack extends IITTrack {
    /**
     * The full path to the file represented by this track.
     */
    @VTID(72)
    java.lang.String location();

    /**
     * Update this track's information with the information stored in its file.
     */
    @VTID(73)
    void updateInfoFromFile();

    /**
     * True if this is a podcast track.
     */
    @VTID(74)
    boolean podcast();

    /**
     * Update the podcast feed for this track.
     */
    @VTID(75)
    void updatePodcastFeed();

    /**
     * True if playback position is remembered.
     */
    @VTID(76)
    boolean rememberBookmark();

    /**
     * True if playback position is remembered.
     */
    @VTID(77)
    void rememberBookmark(
        boolean rememberBookmark);

    /**
     * True if track is skipped when shuffling.
     */
    @VTID(78)
    boolean excludeFromShuffle();

    /**
     * True if track is skipped when shuffling.
     */
    @VTID(79)
    void excludeFromShuffle(
        boolean excludeFromShuffle);

    /**
     * Lyrics for the track.
     */
    @VTID(80)
    java.lang.String lyrics();

    /**
     * Lyrics for the track.
     */
    @VTID(81)
    void lyrics(
        java.lang.String lyrics);

    /**
     * Category for the track.
     */
    @VTID(82)
    java.lang.String category();

    /**
     * Category for the track.
     */
    @VTID(83)
    void category(
        java.lang.String category);

    /**
     * Description for the track.
     */
    @VTID(84)
    java.lang.String description();

    /**
     * Description for the track.
     */
    @VTID(85)
    void description(
        java.lang.String description);

    /**
     * Long description for the track.
     */
    @VTID(86)
    java.lang.String longDescription();

    /**
     * Long description for the track.
     */
    @VTID(87)
    void longDescription(
        java.lang.String longDescription);

    /**
     * The bookmark time of the track (in seconds).
     */
    @VTID(88)
    int bookmarkTime();

    /**
     * The bookmark time of the track (in seconds).
     */
    @VTID(89)
    void bookmarkTime(
        int bookmarkTime);

    /**
     * The video track kind.
     */
    @VTID(90)
    ITVideoKind videoKind();

    /**
     * The video track kind.
     */
    @VTID(91)
    void videoKind(
        ITVideoKind videoKind);

    /**
     * The number of times the track has been skipped.
     */
    @VTID(92)
    int skippedCount();

    /**
     * The number of times the track has been skipped.
     */
    @VTID(93)
    void skippedCount(
        int skippedCount);

    /**
     * The date and time the track was last skipped.  A value of zero means no skipped date.
     */
    @VTID(94)
    java.util.Date skippedDate();

    /**
     * The date and time the track was last skipped.  A value of zero means no skipped date.
     */
    @VTID(95)
    void skippedDate(
        java.util.Date skippedDate);

    /**
     * True if track is part of a gapless album.
     */
    @VTID(96)
    boolean partOfGaplessAlbum();

    /**
     * True if track is part of a gapless album.
     */
    @VTID(97)
    void partOfGaplessAlbum(
        boolean partOfGaplessAlbum);

    /**
     * The album artist of the track.
     */
    @VTID(98)
    java.lang.String albumArtist();

    /**
     * The album artist of the track.
     */
    @VTID(99)
    void albumArtist(
        java.lang.String albumArtist);

    /**
     * The show name of the track.
     */
    @VTID(100)
    java.lang.String show();

    /**
     * The show name of the track.
     */
    @VTID(101)
    void show(
        java.lang.String showName);

    /**
     * The season number of the track.
     */
    @VTID(102)
    int seasonNumber();

    /**
     * The season number of the track.
     */
    @VTID(103)
    void seasonNumber(
        int seasonNumber);

    /**
     * The episode ID of the track.
     */
    @VTID(104)
    java.lang.String episodeID();

    /**
     * The episode ID of the track.
     */
    @VTID(105)
    void episodeID(
        java.lang.String episodeID);

    /**
     * The episode number of the track.
     */
    @VTID(106)
    int episodeNumber();

    /**
     * The episode number of the track.
     */
    @VTID(107)
    void episodeNumber(
        int episodeNumber);

    /**
     * The high 32-bits of the size of the track (in bytes).
     */
    @VTID(108)
    int size64High();

    /**
     * The low 32-bits of the size of the track (in bytes).
     */
    @VTID(109)
    int size64Low();

    /**
     * True if track has not been played.
     */
    @VTID(110)
    boolean unplayed();

    /**
     * True if track has not been played.
     */
    @VTID(111)
    void unplayed(
        boolean isUnplayed);

    /**
     * The album used for sorting.
     */
    @VTID(112)
    java.lang.String sortAlbum();

    /**
     * The album used for sorting.
     */
    @VTID(113)
    void sortAlbum(
        java.lang.String album);

    /**
     * The album artist used for sorting.
     */
    @VTID(114)
    java.lang.String sortAlbumArtist();

    /**
     * The album artist used for sorting.
     */
    @VTID(115)
    void sortAlbumArtist(
        java.lang.String albumArtist);

    /**
     * The artist used for sorting.
     */
    @VTID(116)
    java.lang.String sortArtist();

    /**
     * The artist used for sorting.
     */
    @VTID(117)
    void sortArtist(
        java.lang.String artist);

    /**
     * The composer used for sorting.
     */
    @VTID(118)
    java.lang.String sortComposer();

    /**
     * The composer used for sorting.
     */
    @VTID(119)
    void sortComposer(
        java.lang.String composer);

    /**
     * The track name used for sorting.
     */
    @VTID(120)
    java.lang.String sortName();

    /**
     * The track name used for sorting.
     */
    @VTID(121)
    void sortName(
        java.lang.String name);

    /**
     * The show name used for sorting.
     */
    @VTID(122)
    java.lang.String sortShow();

    /**
     * The show name used for sorting.
     */
    @VTID(123)
    void sortShow(
        java.lang.String showName);

    /**
     * Reveal the track in the main browser window.
     */
    @VTID(124)
    void reveal();

    /**
     * The user or computed rating of the album that this track belongs to (0 to 100).
     */
    @VTID(125)
    int albumRating();

    /**
     * The user or computed rating of the album that this track belongs to (0 to 100).
     */
    @VTID(126)
    void albumRating(
        int rating);

    /**
     * The album rating kind.
     */
    @VTID(127)
    ITRatingKind albumRatingKind();

    /**
     * The track rating kind.
     */
    @VTID(128)
    ITRatingKind ratingKind();

    /**
     * Returns a collection of playlists that contain the song that this track represents.
     */
    @VTID(129)
    IITPlaylistCollection playlists();

    /**
     * The full path to the file represented by this track.
     */
    @VTID(130)
    void location(
        java.lang.String location);

    /**
     * The release date of the track.  A value of zero means no release date.
     */
    @VTID(131)
    java.util.Date releaseDate();

}
