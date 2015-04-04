package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITEncoderCollection Interface
 */
@IID("{8862BCA9-168D-4549-A9D5-ADB35E553BA6}")
public interface IITEncoderCollection extends Com4jObject {
    /**
     * Returns the number of encoders in the collection.
     */
    @VTID(7)
    int count();

    /**
     * Returns an IITEncoder object corresponding to the given index (1-based).
     */
    @VTID(8)
    IITEncoder item(
        int index);

    /**
     * Returns an IITEncoder object with the specified name.
     */
    @VTID(9)
    IITEncoder itemByName(
        java.lang.String name);

    /**
     * Returns an IEnumVARIANT object which can enumerate the collection.
     */
    @VTID(10)
    com4j.Com4jObject _NewEnum();

}
