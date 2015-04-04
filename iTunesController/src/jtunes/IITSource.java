package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITSource Interface
 */
@IID("{AEC1C4D3-AEF1-4255-B892-3E3D13ADFDF9}")
public interface IITSource extends IITObject {
    /**
     * The source kind.
     */
    @VTID(15)
    ITSourceKind kind();

    /**
     * The total size of the source, if it has a fixed size.
     */
    @VTID(16)
    double capacity();

    /**
     * The free space on the source, if it has a fixed size.
     */
    @VTID(17)
    double freeSpace();

    /**
     * Returns a collection of playlists.
     */
    @VTID(18)
    IITPlaylistCollection playlists();

}
