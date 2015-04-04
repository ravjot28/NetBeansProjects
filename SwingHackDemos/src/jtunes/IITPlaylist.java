package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITPlaylist Interface
 */
@IID("{3D5E072F-2A77-4B17-9E73-E03B77CCCCA9}")
public interface IITPlaylist extends IITObject {
    /**
     * Delete this playlist.
     */
    @VTID(15)
    void delete();

    /**
     * Start playing the first track in this playlist.
     */
    @VTID(16)
    void playFirstTrack();

    /**
     * Print this playlist.
     */
    @VTID(17)
    void print(
        boolean showPrintDialog,
        ITPlaylistPrintKind printKind,
        java.lang.String theme);

    /**
     * Search tracks in this playlist for the specified string.
     */
    @VTID(18)
    IITTrackCollection search(
        java.lang.String searchText,
        ITPlaylistSearchField searchFields);

    /**
     * The playlist kind.
     */
    @VTID(19)
    ITPlaylistKind kind();

    /**
     * The source that contains this playlist.
     */
    @VTID(20)
    IITSource source();

    /**
     * The total length of all songs in the playlist (in seconds).
     */
    @VTID(21)
    int duration();

    /**
     * True if songs in the playlist are played in random order.
     */
    @VTID(22)
    boolean shuffle();

    /**
     * True if songs in the playlist are played in random order.
     */
    @VTID(23)
    void shuffle(
        boolean isShuffle);

    /**
     * The total size of all songs in the playlist (in bytes).
     */
    @VTID(24)
    double size();

    /**
     * The playback repeat mode.
     */
    @VTID(25)
    ITPlaylistRepeatMode songRepeat();

    /**
     * The playback repeat mode.
     */
    @VTID(26)
    void songRepeat(
        ITPlaylistRepeatMode repeatMode);

    /**
     * The total length of all songs in the playlist (in MM:SS format).
     */
    @VTID(27)
    java.lang.String time();

    /**
     * True if the playlist is visible in the Source list.
     */
    @VTID(28)
    boolean visible();

    /**
     * Returns a collection of tracks in this playlist.
     */
    @VTID(29)
    IITTrackCollection tracks();

}
