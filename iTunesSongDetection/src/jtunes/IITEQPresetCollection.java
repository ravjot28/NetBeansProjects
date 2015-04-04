package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITEQPresetCollection Interface
 */
@IID("{AEF4D111-3331-48DA-B0C2-B468D5D61D08}")
public interface IITEQPresetCollection extends Com4jObject {
    /**
     * Returns the number of EQ presets in the collection.
     */
    @VTID(7)
    int count();

    /**
     * Returns an IITEQPreset object corresponding to the given index (1-based).
     */
    @VTID(8)
    IITEQPreset item(
        int index);

    /**
     * Returns an IITEQPreset object with the specified name.
     */
    @VTID(9)
    IITEQPreset itemByName(
        java.lang.String name);

    /**
     * Returns an IEnumVARIANT object which can enumerate the collection.
     */
    @VTID(10)
    com4j.Com4jObject _NewEnum();

}
