package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IiTunes Interface
 */
@IID("{9DD6680B-3EDC-40DB-A771-E6FE4832E34A}")
public interface IiTunes extends Com4jObject {
    /**
     * Reposition to the beginning of the current track or go to the previous track if already at start of current track.
     */
    @VTID(7)
    void backTrack();

    /**
     * Skip forward in a playing track.
     */
    @VTID(8)
    void fastForward();

    /**
     * Advance to the next track in the current playlist.
     */
    @VTID(9)
    void nextTrack();

    /**
     * Pause playback.
     */
    @VTID(10)
    void pause();

    /**
     * Play the currently targeted track.
     */
    @VTID(11)
    void play();

    /**
     * Play the specified file path, adding it to the library if not already present.
     */
    @VTID(12)
    void playFile(
        java.lang.String filePath);

    /**
     * Toggle the playing/paused state of the current track.
     */
    @VTID(13)
    void playPause();

    /**
     * Return to the previous track in the current playlist.
     */
    @VTID(14)
    void previousTrack();

    /**
     * Disable fast forward/rewind and resume playback, if playing.
     */
    @VTID(15)
    void resume();

    /**
     * Skip backwards in a playing track.
     */
    @VTID(16)
    void rewind();

    /**
     * Stop playback.
     */
    @VTID(17)
    void stop();

    /**
     * Start converting the specified file path.
     */
    @VTID(18)
    IITOperationStatus convertFile(
        java.lang.String filePath);

    /**
     * Start converting the specified array of file paths. filePaths can be of type VT_ARRAY|VT_VARIANT, where each entry is a VT_BSTR, or VT_ARRAY|VT_BSTR.  You can also pass a JScript Array object.
     */
    @VTID(19)
    IITOperationStatus convertFiles(
        java.lang.Object filePaths);

    /**
     * Start converting the specified track.  iTrackToConvert is a VARIANT of type VT_DISPATCH that points to an IITTrack.
     */
    @VTID(20)
    IITOperationStatus convertTrack(
        java.lang.Object iTrackToConvert);

    /**
     * Start converting the specified tracks.  iTracksToConvert is a VARIANT of type VT_DISPATCH that points to an IITTrackCollection.
     */
    @VTID(21)
    IITOperationStatus convertTracks(
        java.lang.Object iTracksToConvert);

    /**
     * Returns true if this version of the iTunes type library is compatible with the specified version.
     */
    @VTID(22)
    boolean checkVersion(
        int majorVersion,
        int minorVersion);

    /**
     * Returns an IITObject corresponding to the specified IDs.
     */
    @VTID(23)
    IITObject getITObjectByID(
        int sourceID,
        int playlistID,
        int trackID,
        int databaseID);

    /**
     * Creates a new playlist in the main library.
     */
    @VTID(24)
    IITPlaylist createPlaylist(
        java.lang.String playlistName);

    /**
     * Open the specified iTunes Store or streaming audio URL.
     */
    @VTID(25)
    void openURL(
        java.lang.String uRL);

    /**
     * Go to the iTunes Store home page.
     */
    @VTID(26)
    void gotoMusicStoreHomePage();

    /**
     * Update the contents of the iPod.
     */
    @VTID(27)
    void updateIPod();

    @VTID(28)
    void authorize(
        int numElems,
        java.lang.Object data,
        Holder<java.lang.String> names);

    /**
     * Exits the iTunes application.
     */
    @VTID(29)
    void quit();

    /**
     * Returns a collection of music sources (music library, CD, device, etc.).
     */
    @VTID(30)
    IITSourceCollection sources();

    /**
     * Returns a collection of encoders.
     */
    @VTID(31)
    IITEncoderCollection encoders();

    /**
     * Returns a collection of EQ presets.
     */
    @VTID(32)
    IITEQPresetCollection eQPresets();

    /**
     * Returns a collection of visual plug-ins.
     */
    @VTID(33)
    IITVisualCollection visuals();

    /**
     * Returns a collection of windows.
     */
    @VTID(34)
    IITWindowCollection windows();

    /**
     * Returns the sound output volume (0 = minimum, 100 = maximum).
     */
    @VTID(35)
    int soundVolume();

    /**
     * Returns the sound output volume (0 = minimum, 100 = maximum).
     */
    @VTID(36)
    void soundVolume(
        int volume);

    /**
     * True if sound output is muted.
     */
    @VTID(37)
    boolean mute();

    /**
     * True if sound output is muted.
     */
    @VTID(38)
    void mute(
        boolean isMuted);

    /**
     * Returns the current player state.
     */
    @VTID(39)
    ITPlayerState playerState();

    /**
     * Returns the player's position within the currently playing track in seconds.
     */
    @VTID(40)
    int playerPosition();

    /**
     * Returns the player's position within the currently playing track in seconds.
     */
    @VTID(41)
    void playerPosition(
        int playerPos);

    /**
     * Returns the currently selected encoder (AAC, MP3, AIFF, WAV, etc.).
     */
    @VTID(42)
    IITEncoder currentEncoder();

    /**
     * Returns the currently selected encoder (AAC, MP3, AIFF, WAV, etc.).
     */
    @VTID(43)
    void currentEncoder(
        IITEncoder iEncoder);

    /**
     * True if visuals are currently being displayed.
     */
    @VTID(44)
    boolean visualsEnabled();

    /**
     * True if visuals are currently being displayed.
     */
    @VTID(45)
    void visualsEnabled(
        boolean isEnabled);

    /**
     * True if the visuals are displayed using the entire screen.
     */
    @VTID(46)
    boolean fullScreenVisuals();

    /**
     * True if the visuals are displayed using the entire screen.
     */
    @VTID(47)
    void fullScreenVisuals(
        boolean isFullScreen);

    /**
     * Returns the size of the displayed visual.
     */
    @VTID(48)
    ITVisualSize visualSize();

    /**
     * Returns the size of the displayed visual.
     */
    @VTID(49)
    void visualSize(
        ITVisualSize visualSize);

    /**
     * Returns the currently selected visual plug-in.
     */
    @VTID(50)
    IITVisual currentVisual();

    /**
     * Returns the currently selected visual plug-in.
     */
    @VTID(51)
    void currentVisual(
        IITVisual iVisual);

    /**
     * True if the equalizer is enabled.
     */
    @VTID(52)
    boolean eQEnabled();

    /**
     * True if the equalizer is enabled.
     */
    @VTID(53)
    void eQEnabled(
        boolean isEnabled);

    /**
     * Returns the currently selected EQ preset.
     */
    @VTID(54)
    IITEQPreset currentEQPreset();

    /**
     * Returns the currently selected EQ preset.
     */
    @VTID(55)
    void currentEQPreset(
        IITEQPreset iEQPreset);

    /**
     * The name of the current song in the playing stream (provided by streaming server).
     */
    @VTID(56)
    java.lang.String currentStreamTitle();

    /**
     * The URL of the playing stream or streaming web site (provided by streaming server).
     */
    @VTID(57)
    java.lang.String currentStreamURL();

    /**
     * Returns the main iTunes browser window.
     */
    @VTID(58)
    IITBrowserWindow browserWindow();

    /**
     * Returns the EQ window.
     */
    @VTID(59)
    IITWindow eQWindow();

    /**
     * Returns the source that represents the main library.
     */
    @VTID(60)
    IITSource librarySource();

    /**
     * Returns the main library playlist in the main library source.
     */
    @VTID(61)
    IITLibraryPlaylist libraryPlaylist();

    /**
     * Returns the currently targeted track.
     */
    @VTID(62)
    IITTrack currentTrack();

    /**
     * Returns the playlist containing the currently targeted track.
     */
    @VTID(63)
    IITPlaylist currentPlaylist();

    /**
     * Returns a collection containing the currently selected track or tracks.
     */
    @VTID(64)
    IITTrackCollection selectedTracks();

    /**
     * Returns the version of the iTunes application.
     */
    @VTID(65)
    java.lang.String version();

    @VTID(66)
    void setOptions(
        int options);

    /**
     * Start converting the specified file path.
     */
    @VTID(67)
    IITConvertOperationStatus convertFile2(
        java.lang.String filePath);

    /**
     * Start converting the specified array of file paths. filePaths can be of type VT_ARRAY|VT_VARIANT, where each entry is a VT_BSTR, or VT_ARRAY|VT_BSTR.  You can also pass a JScript Array object.
     */
    @VTID(68)
    IITConvertOperationStatus convertFiles2(
        java.lang.Object filePaths);

    /**
     * Start converting the specified track.  iTrackToConvert is a VARIANT of type VT_DISPATCH that points to an IITTrack.
     */
    @VTID(69)
    IITConvertOperationStatus convertTrack2(
        java.lang.Object iTrackToConvert);

    /**
     * Start converting the specified tracks.  iTracksToConvert is a VARIANT of type VT_DISPATCH that points to an IITTrackCollection.
     */
    @VTID(70)
    IITConvertOperationStatus convertTracks2(
        java.lang.Object iTracksToConvert);

    /**
     * True if iTunes will process APPCOMMAND Windows messages.
     */
    @VTID(71)
    boolean appCommandMessageProcessingEnabled();

    /**
     * True if iTunes will process APPCOMMAND Windows messages.
     */
    @VTID(72)
    void appCommandMessageProcessingEnabled(
        boolean isEnabled);

    /**
     * True if iTunes will force itself to be the foreground application when it displays a dialog.
     */
    @VTID(73)
    boolean forceToForegroundOnDialog();

    /**
     * True if iTunes will force itself to be the foreground application when it displays a dialog.
     */
    @VTID(74)
    void forceToForegroundOnDialog(
        boolean forceToForegroundOnDialog);

    /**
     * Create a new EQ preset.
     */
    @VTID(75)
    IITEQPreset createEQPreset(
        java.lang.String eqPresetName);

    /**
     * Creates a new playlist in an existing source.
     */
    @VTID(76)
    IITPlaylist createPlaylistInSource(
        java.lang.String playlistName,
        java.lang.Object iSource);

        /**
         * Simulate click on a player control button.
         */
        @VTID(78)
        void playerButtonClicked(
            ITPlayerButton playerButton,
            int playerButtonModifierKeys);

        /**
         * True if the Shuffle property is writable for the specified playlist.
         */
        @VTID(79)
        boolean canSetShuffle(
            java.lang.Object iPlaylist);

        /**
         * True if the SongRepeat property is writable for the specified playlist.
         */
        @VTID(80)
        boolean canSetSongRepeat(
            java.lang.Object iPlaylist);

        /**
         * Returns an IITConvertOperationStatus object if there is currently a conversion in progress.
         */
        @VTID(81)
        IITConvertOperationStatus convertOperationStatus();

        /**
         * Subscribe to the specified podcast feed URL.
         */
        @VTID(82)
        void subscribeToPodcast(
            java.lang.String uRL);

        /**
         * Update all podcast feeds.
         */
        @VTID(83)
        void updatePodcastFeeds();

        /**
         * Creates a new folder in the main library.
         */
        @VTID(84)
        IITPlaylist createFolder(
            java.lang.String folderName);

        /**
         * Creates a new folder in an existing source.
         */
        @VTID(85)
        IITPlaylist createFolderInSource(
            java.lang.String folderName,
            java.lang.Object iSource);

        /**
         * True if the sound volume control is enabled.
         */
        @VTID(86)
        boolean soundVolumeControlEnabled();

        /**
         * The full path to the current iTunes library XML file.
         */
        @VTID(87)
        java.lang.String libraryXMLPath();

        /**
         * Returns the high 32 bits of the persistent ID of the specified IITObject.
         */
        @VTID(88)
        int iTObjectPersistentIDHigh(
            java.lang.Object iObject);

        /**
         * Returns the low 32 bits of the persistent ID of the specified IITObject.
         */
        @VTID(89)
        int iTObjectPersistentIDLow(
            java.lang.Object iObject);

        /**
         * Returns the high and low 32 bits of the persistent ID of the specified IITObject.
         */
        @VTID(90)
        void getITObjectPersistentIDs(
            java.lang.Object iObject,
            Holder<Integer> highID,
            Holder<Integer> lowID);

    }
