package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITVisualCollection Interface
 */
@IID("{88A4CCDD-114F-4043-B69B-84D4E6274957}")
public interface IITVisualCollection extends Com4jObject {
    /**
     * Returns the number of visual plug-ins in the collection.
     */
    @VTID(7)
    int count();

    /**
     * Returns an IITVisual object corresponding to the given index (1-based).
     */
    @VTID(8)
    IITVisual item(
        int index);

    /**
     * Returns an IITVisual object with the specified name.
     */
    @VTID(9)
    IITVisual itemByName(
        java.lang.String name);

    /**
     * Returns an IEnumVARIANT object which can enumerate the collection.
     */
    @VTID(10)
    com4j.Com4jObject _NewEnum();

}
