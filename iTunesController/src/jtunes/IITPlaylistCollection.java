package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITPlaylistCollection Interface
 */
@IID("{FF194254-909D-4437-9C50-3AAC2AE6305C}")
public interface IITPlaylistCollection extends Com4jObject {
    /**
     * Returns the number of playlists in the collection.
     */
    @VTID(7)
    int count();

    /**
     * Returns an IITPlaylist object corresponding to the given index (1-based).
     */
    @VTID(8)
    IITPlaylist item(
        int index);

    /**
     * Returns an IITPlaylist object with the specified name.
     */
    @VTID(9)
    IITPlaylist itemByName(
        java.lang.String name);

    /**
     * Returns an IEnumVARIANT object which can enumerate the collection.
     */
    @VTID(10)
    com4j.Com4jObject _NewEnum();

    /**
     * Returns an IITPlaylist object with the specified persistent ID.
     */
    @VTID(11)
    IITPlaylist itemByPersistentID(
        int highID,
        int lowID);

}
