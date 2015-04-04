package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITAudioCDPlaylist Interface
 */
@IID("{CF496DF3-0FED-4D7D-9BD8-529B6E8A082E}")
public interface IITAudioCDPlaylist extends IITPlaylist {
    /**
     * The artist of the CD.
     */
    @VTID(30)
    java.lang.String artist();

    /**
     * True if this CD is a compilation album.
     */
    @VTID(31)
    boolean compilation();

    /**
     * The composer of the CD.
     */
    @VTID(32)
    java.lang.String composer();

    /**
     * The total number of discs in this CD's album.
     */
    @VTID(33)
    int discCount();

    /**
     * The index of the CD disc in the source album.
     */
    @VTID(34)
    int discNumber();

    /**
     * The genre of the CD.
     */
    @VTID(35)
    java.lang.String genre();

    /**
     * The year the album was recorded/released.
     */
    @VTID(36)
    int year();

    /**
     * Reveal the CD playlist in the main browser window.
     */
    @VTID(37)
    void reveal();

}
