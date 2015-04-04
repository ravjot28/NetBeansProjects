package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITIPodSource Interface
 */
@IID("{CF4D8ACE-1720-4FB9-B0AE-9877249E89B0}")
public interface IITIPodSource extends IITSource {
    /**
     * Update the contents of the iPod.
     */
    @VTID(19)
    void updateIPod();

    /**
     * Eject the iPod.
     */
    @VTID(20)
    void ejectIPod();

    /**
     * The iPod software version.
     */
    @VTID(21)
    java.lang.String softwareVersion();

}
