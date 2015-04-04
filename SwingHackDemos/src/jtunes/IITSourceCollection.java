package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITSourceCollection Interface
 */
@IID("{2FF6CE20-FF87-4183-B0B3-F323D047AF41}")
public interface IITSourceCollection extends Com4jObject {
    /**
     * Returns the number of sources in the collection.
     */
    @VTID(7)
    int count();

    /**
     * Returns an IITSource object corresponding to the given index (1-based).
     */
    @VTID(8)
    IITSource item(
        int index);

    /**
     * Returns an IITSource object with the specified name.
     */
    @VTID(9)
    IITSource itemByName(
        java.lang.String name);

    /**
     * Returns an IEnumVARIANT object which can enumerate the collection.
     */
    @VTID(10)
    com4j.Com4jObject _NewEnum();

    /**
     * Returns an IITSource object with the specified persistent ID.
     */
    @VTID(11)
    IITSource itemByPersistentID(
        int highID,
        int lowID);

}
