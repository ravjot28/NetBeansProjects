package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

public enum ITEvent implements ComEnum {
    ITEventDatabaseChanged(1),
    ITEventPlayerPlay(2),
    ITEventPlayerStop(3),
    ITEventPlayerPlayingTrackChanged(4),
    ITEventUserInterfaceEnabled(5),
    ITEventCOMCallsDisabled(6),
    ITEventCOMCallsEnabled(7),
    ITEventQuitting(8),
    ITEventAboutToPromptUserToQuit(9),
    ITEventSoundVolumeChanged(10),
    ;

    private final int value;
    ITEvent(int value) { this.value=value; }
    public int comEnumValue() { return value; }
}
