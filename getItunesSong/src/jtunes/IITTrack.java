package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITTrack Interface
 */
@IID("{4CB0915D-1E54-4727-BAF3-CE6CC9A225A1}")
public interface IITTrack extends IITObject {
    /**
     * Delete this track.
     */
    @VTID(15)
    void delete();

    /**
     * Start playing this track.
     */
    @VTID(16)
    void play();

    /**
     * Add artwork from an image file to this track.
     */
    @VTID(17)
    IITArtwork addArtworkFromFile(
        java.lang.String filePath);

    /**
     * The track kind.
     */
    @VTID(18)
    ITTrackKind kind();

    /**
     * The playlist that contains this track.
     */
    @VTID(19)
    IITPlaylist playlist();

    /**
     * The album containing the track.
     */
    @VTID(20)
    java.lang.String album();

    /**
     * The album containing the track.
     */
    @VTID(21)
    void album(
        java.lang.String album);

    /**
     * The artist/source of the track.
     */
    @VTID(22)
    java.lang.String artist();

    /**
     * The artist/source of the track.
     */
    @VTID(23)
    void artist(
        java.lang.String artist);

    /**
     * The bit rate of the track (in kbps).
     */
    @VTID(24)
    int bitRate();

    /**
     * The tempo of the track (in beats per minute).
     */
    @VTID(25)
    int bPM();

    /**
     * The tempo of the track (in beats per minute).
     */
    @VTID(26)
    void bPM(
        int beatsPerMinute);

    /**
     * Freeform notes about the track.
     */
    @VTID(27)
    java.lang.String comment();

    /**
     * Freeform notes about the track.
     */
    @VTID(28)
    void comment(
        java.lang.String comment);

    /**
     * True if this track is from a compilation album.
     */
    @VTID(29)
    boolean compilation();

    /**
     * True if this track is from a compilation album.
     */
    @VTID(30)
    void compilation(
        boolean isCompilation);

    /**
     * The composer of the track.
     */
    @VTID(31)
    java.lang.String composer();

    /**
     * The composer of the track.
     */
    @VTID(32)
    void composer(
        java.lang.String composer);

    /**
     * The date the track was added to the playlist.
     */
    @VTID(33)
    java.util.Date dateAdded();

    /**
     * The total number of discs in the source album.
     */
    @VTID(34)
    int discCount();

    /**
     * The total number of discs in the source album.
     */
    @VTID(35)
    void discCount(
        int discCount);

    /**
     * The index of the disc containing the track on the source album.
     */
    @VTID(36)
    int discNumber();

    /**
     * The index of the disc containing the track on the source album.
     */
    @VTID(37)
    void discNumber(
        int discNumber);

    /**
     * The length of the track (in seconds).
     */
    @VTID(38)
    int duration();

    /**
     * True if the track is checked for playback.
     */
    @VTID(39)
    boolean enabled();

    /**
     * True if the track is checked for playback.
     */
    @VTID(40)
    void enabled(
        boolean isEnabled);

    /**
     * The name of the EQ preset of the track.
     */
    @VTID(41)
    java.lang.String eQ();

    /**
     * The name of the EQ preset of the track.
     */
    @VTID(42)
    void eQ(
        java.lang.String eQ);

    /**
     * The stop time of the track (in seconds).
     */
    @VTID(43)
    void finish(
        int finish);

    /**
     * The stop time of the track (in seconds).
     */
    @VTID(44)
    int finish();

    /**
     * The music/audio genre (category) of the track.
     */
    @VTID(45)
    java.lang.String genre();

    /**
     * The music/audio genre (category) of the track.
     */
    @VTID(46)
    void genre(
        java.lang.String genre);

    /**
     * The grouping (piece) of the track.  Generally used to denote movements within classical work.
     */
    @VTID(47)
    java.lang.String grouping();

    /**
     * The grouping (piece) of the track.  Generally used to denote movements within classical work.
     */
    @VTID(48)
    void grouping(
        java.lang.String grouping);

    /**
     * A text description of the track.
     */
    @VTID(49)
    java.lang.String kindAsString();

    /**
     * The modification date of the content of the track.
     */
    @VTID(50)
    java.util.Date modificationDate();

    /**
     * The number of times the track has been played.
     */
    @VTID(51)
    int playedCount();

    /**
     * The number of times the track has been played.
     */
    @VTID(52)
    void playedCount(
        int playedCount);

    /**
     * The date and time the track was last played.  A value of zero means no played date.
     */
    @VTID(53)
    java.util.Date playedDate();

    /**
     * The date and time the track was last played.  A value of zero means no played date.
     */
    @VTID(54)
    void playedDate(
        java.util.Date playedDate);

    /**
     * The play order index of the track in the owner playlist (1-based).
     */
    @VTID(55)
    int playOrderIndex();

    /**
     * The rating of the track (0 to 100).
     */
    @VTID(56)
    int rating();

    /**
     * The rating of the track (0 to 100).
     */
    @VTID(57)
    void rating(
        int rating);

    /**
     * The sample rate of the track (in Hz).
     */
    @VTID(58)
    int sampleRate();

    /**
     * The size of the track (in bytes).
     */
    @VTID(59)
    int size();

    /**
     * The start time of the track (in seconds).
     */
    @VTID(60)
    int start();

    /**
     * The start time of the track (in seconds).
     */
    @VTID(61)
    void start(
        int start);

    /**
     * The length of the track (in MM:SS format).
     */
    @VTID(62)
    java.lang.String time();

    /**
     * The total number of tracks on the source album.
     */
    @VTID(63)
    int trackCount();

    /**
     * The total number of tracks on the source album.
     */
    @VTID(64)
    void trackCount(
        int trackCount);

    /**
     * The index of the track on the source album.
     */
    @VTID(65)
    int trackNumber();

    /**
     * The index of the track on the source album.
     */
    @VTID(66)
    void trackNumber(
        int trackNumber);

    /**
     * The relative volume adjustment of the track (-100% to 100%).
     */
    @VTID(67)
    int volumeAdjustment();

    /**
     * The relative volume adjustment of the track (-100% to 100%).
     */
    @VTID(68)
    void volumeAdjustment(
        int volumeAdjustment);

    /**
     * The year the track was recorded/released.
     */
    @VTID(69)
    int year();

    /**
     * The year the track was recorded/released.
     */
    @VTID(70)
    void year(
        int year);

    /**
     * Returns a collection of artwork.
     */
    @VTID(71)
    IITArtworkCollection artwork();

}
