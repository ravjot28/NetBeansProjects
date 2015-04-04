package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITPlaylistWindow Interface
 */
@IID("{349CBB45-2E5A-4822-8E4A-A75555A186F7}")
public interface IITPlaylistWindow extends IITWindow {
    /**
     * Returns a collection containing the currently selected track or tracks.
     */
    @VTID(32)
    IITTrackCollection selectedTracks();

    /**
     * The playlist displayed in the window.
     */
    @VTID(33)
    IITPlaylist playlist();

}
