package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITEQPreset Interface
 */
@IID("{5BE75F4F-68FA-4212-ACB7-BE44EA569759}")
public interface IITEQPreset extends Com4jObject {
    /**
     * The name of the the EQ preset.
     */
    @VTID(7)
    java.lang.String name();

    /**
     * True if this EQ preset can be modified.
     */
    @VTID(8)
    boolean modifiable();

    /**
     * The equalizer preamp level (-12.0 db to +12.0 db).
     */
    @VTID(9)
    double preamp();

    /**
     * The equalizer preamp level (-12.0 db to +12.0 db).
     */
    @VTID(10)
    void preamp(
        double level);

    /**
     * The equalizer 32Hz band level (-12.0 db to +12.0 db).
     */
    @VTID(11)
    double band1();

    /**
     * The equalizer 32Hz band level (-12.0 db to +12.0 db).
     */
    @VTID(12)
    void band1(
        double level);

    /**
     * The equalizer 64Hz band level (-12.0 db to +12.0 db).
     */
    @VTID(13)
    double band2();

    /**
     * The equalizer 64Hz band level (-12.0 db to +12.0 db).
     */
    @VTID(14)
    void band2(
        double level);

    /**
     * The equalizer 125Hz band level (-12.0 db to +12.0 db).
     */
    @VTID(15)
    double band3();

    /**
     * The equalizer 125Hz band level (-12.0 db to +12.0 db).
     */
    @VTID(16)
    void band3(
        double level);

    /**
     * The equalizer 250Hz band level (-12.0 db to +12.0 db).
     */
    @VTID(17)
    double band4();

    /**
     * The equalizer 250Hz band level (-12.0 db to +12.0 db).
     */
    @VTID(18)
    void band4(
        double level);

    /**
     * The equalizer 500Hz band level (-12.0 db to +12.0 db).
     */
    @VTID(19)
    double band5();

    /**
     * The equalizer 500Hz band level (-12.0 db to +12.0 db).
     */
    @VTID(20)
    void band5(
        double level);

    /**
     * The equalizer 1KHz band level (-12.0 db to +12.0 db).
     */
    @VTID(21)
    double band6();

    /**
     * The equalizer 1KHz band level (-12.0 db to +12.0 db).
     */
    @VTID(22)
    void band6(
        double level);

    /**
     * The equalizer 2KHz band level (-12.0 db to +12.0 db).
     */
    @VTID(23)
    double band7();

    /**
     * The equalizer 2KHz band level (-12.0 db to +12.0 db).
     */
    @VTID(24)
    void band7(
        double level);

    /**
     * The equalizer 4KHz band level (-12.0 db to +12.0 db).
     */
    @VTID(25)
    double band8();

    /**
     * The equalizer 4KHz band level (-12.0 db to +12.0 db).
     */
    @VTID(26)
    void band8(
        double level);

    /**
     * The equalizer 8KHz band level (-12.0 db to +12.0 db).
     */
    @VTID(27)
    double band9();

    /**
     * The equalizer 8KHz band level (-12.0 db to +12.0 db).
     */
    @VTID(28)
    void band9(
        double level);

    /**
     * The equalizer 16KHz band level (-12.0 db to +12.0 db).
     */
    @VTID(29)
    double band10();

    /**
     * The equalizer 16KHz band level (-12.0 db to +12.0 db).
     */
    @VTID(30)
    void band10(
        double level);

    /**
     * Delete this EQ preset.
     */
    @VTID(31)
    void delete(
        boolean updateAllTracks);

    /**
     * Rename this EQ preset.
     */
    @VTID(32)
    void rename(
        java.lang.String newName,
        boolean updateAllTracks);

}
