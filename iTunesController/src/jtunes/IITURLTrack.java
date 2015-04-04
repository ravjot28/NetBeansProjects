package jtunes;

// GENERATED. DO NOT MODIFY
import com4j.*;

/**
 * IITURLTrack Interface
 */
@IID("{1116E3B5-29FD-4393-A7BD-454E5E327900}")
public interface IITURLTrack extends IITTrack {
    /**
     * The URL of the stream represented by this track.
     */
    @VTID(72)
    java.lang.String uRL();

    /**
     * The URL of the stream represented by this track.
     */
    @VTID(73)
    void uRL(
        java.lang.String uRL);

    /**
     * True if this is a podcast track.
     */
    @VTID(74)
    boolean podcast();

    /**
     * Update the podcast feed for this track.
     */
    @VTID(75)
    void updatePodcastFeed();

    /**
     * Start downloading the podcast episode that corresponds to this track.
     */
    @VTID(76)
    void downloadPodcastEpisode();

    /**
     * Category for the track.
     */
    @VTID(77)
    java.lang.String category();

    /**
     * Category for the track.
     */
    @VTID(78)
    void category(
        java.lang.String category);

    /**
     * Description for the track.
     */
    @VTID(79)
    java.lang.String description();

    /**
     * Description for the track.
     */
    @VTID(80)
    void description(
        java.lang.String description);

    /**
     * Long description for the track.
     */
    @VTID(81)
    java.lang.String longDescription();

    /**
     * Long description for the track.
     */
    @VTID(82)
    void longDescription(
        java.lang.String longDescription);

    /**
     * Reveal the track in the main browser window.
     */
    @VTID(83)
    void reveal();

    /**
     * The user or computed rating of the album that this track belongs to (0 to 100).
     */
    @VTID(84)
    int albumRating();

    /**
     * The user or computed rating of the album that this track belongs to (0 to 100).
     */
    @VTID(85)
    void albumRating(
        int rating);

    /**
     * The album rating kind.
     */
    @VTID(86)
    ITRatingKind albumRatingKind();

    /**
     * The track rating kind.
     */
    @VTID(87)
    ITRatingKind ratingKind();

    /**
     * Returns a collection of playlists that contain the song that this track represents.
     */
    @VTID(88)
    IITPlaylistCollection playlists();

}
