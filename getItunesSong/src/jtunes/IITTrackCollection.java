package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITTrackCollection Interface
 */
@IID("{755D76F1-6B85-4CE4-8F5F-F88D9743DCD8}")
public interface IITTrackCollection extends Com4jObject {
    /**
     * Returns the number of tracks in the collection.
     */
    @VTID(7)
    int count();

    /**
     * Returns an IITTrack object corresponding to the given fixed index, where the index is independent of the play order (1-based).
     */
    @VTID(8)
    IITTrack item(
        int index);

    /**
     * Returns an IITTrack object corresponding to the given index, where the index is defined by the play order of the playlist containing the track collection (1-based).
     */
    @VTID(9)
    IITTrack itemByPlayOrder(
        int index);

    /**
     * Returns an IITTrack object with the specified name.
     */
    @VTID(10)
    IITTrack itemByName(
        java.lang.String name);

    /**
     * Returns an IEnumVARIANT object which can enumerate the collection.
     */
    @VTID(11)
    com4j.Com4jObject _NewEnum();

    /**
     * Returns an IITTrack object with the specified persistent ID.
     */
    @VTID(12)
    IITTrack itemByPersistentID(
        int highID,
        int lowID);

}
