package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITObject Interface
 */
@IID("{9FAB0E27-70D7-4E3A-9965-B0C8B8869BB6}")
public interface IITObject extends Com4jObject {
    /**
     * Returns the four IDs that uniquely identify this object.
     */
    @VTID(7)
    void getITObjectIDs(
        Holder<Integer> sourceID,
        Holder<Integer> playlistID,
        Holder<Integer> trackID,
        Holder<Integer> databaseID);

    /**
     * The name of the object.
     */
    @VTID(8)
    java.lang.String name();

    /**
     * The name of the object.
     */
    @VTID(9)
    void name(
        java.lang.String name);

    /**
     * The index of the object in internal application order (1-based).
     */
    @VTID(10)
    int index();

    /**
     * The source ID of the object.
     */
    @VTID(11)
    int sourceID();

    /**
     * The playlist ID of the object.
     */
    @VTID(12)
    int playlistID();

    /**
     * The track ID of the object.
     */
    @VTID(13)
    int trackID();

    /**
     * The track database ID of the object.
     */
    @VTID(14)
    int trackDatabaseID();

}
