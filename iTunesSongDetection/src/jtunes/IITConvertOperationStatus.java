package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITConvertOperationStatus Interface
 */
@IID("{7063AAF6-ABA0-493B-B4FC-920A9F105875}")
public interface IITConvertOperationStatus extends IITOperationStatus {
    /**
     * Returns the current conversion status.
     */
    @VTID(9)
    void getConversionStatus(
        Holder<java.lang.String> trackName,
        Holder<Integer> progressValue,
        Holder<Integer> maxProgressValue);

    /**
     * Stops the current conversion operation.
     */
    @VTID(10)
    void stopConversion();

    /**
     * Returns the name of the track currently being converted.
     */
    @VTID(11)
    java.lang.String trackName();

    /**
     * Returns the current progress value for the track being converted.
     */
    @VTID(12)
    int progressValue();

    /**
     * Returns the maximum progress value for the track being converted.
     */
    @VTID(13)
    int maxProgressValue();

}
