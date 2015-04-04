package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITArtworkCollection Interface
 */
@IID("{BF2742D7-418C-4858-9AF9-2981B062D23E}")
public interface IITArtworkCollection extends Com4jObject {
    /**
     * Returns the number of pieces of artwork in the collection.
     */
    @VTID(7)
    int count();

    /**
     * Returns an IITArtwork object corresponding to the given index (1-based).
     */
    @VTID(8)
    IITArtwork item(
        int index);

    /**
     * Returns an IEnumVARIANT object which can enumerate the collection.
     */
    @VTID(9)
    com4j.Com4jObject _NewEnum();

}
