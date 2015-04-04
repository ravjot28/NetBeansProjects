package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITBrowserWindow Interface
 */
@IID("{C999F455-C4D5-4AA4-8277-F99753699974}")
public interface IITBrowserWindow extends IITWindow {
    /**
     * True if window is in Mini Player mode.
     */
    @VTID(32)
    boolean miniPlayer();

    /**
     * True if window is in Mini Player mode.
     */
    @VTID(33)
    void miniPlayer(
        boolean isMiniPlayer);

    /**
     * Returns a collection containing the currently selected track or tracks.
     */
    @VTID(34)
    IITTrackCollection selectedTracks();

    /**
     * The currently selected playlist in the Source list.
     */
    @VTID(35)
    IITPlaylist selectedPlaylist();

    /**
     * The currently selected playlist in the Source list.
     */
    @VTID(36)
    void selectedPlaylist(
        java.lang.Object iPlaylist);

}
