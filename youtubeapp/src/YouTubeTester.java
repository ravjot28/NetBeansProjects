import java.util.List;

public class YouTubeTester {

    public static void main(String[] args) throws Exception {

        String clientID = "JavaCodeGeeks";
        String textQuery = "java code";
        int maxResults = 10;
        boolean filter = true;
        int timeout = 2000;

        YouTubeManager ym = new YouTubeManager(clientID);

        List<YouTubeVideo> videos = ym.retrieveVideos(textQuery, maxResults, filter, timeout);

        for (YouTubeVideo youtubeVideo : videos) {
            System.out.println(youtubeVideo.getWebPlayerUrl());
            System.out.println("Thumbnails");
            for (String thumbnail : youtubeVideo.getThumbnails()) {
                System.out.println("\t" + thumbnail);
            }
            System.out.println(youtubeVideo.getEmbeddedWebPlayerUrl());
            System.out.println("************************************");
        }

    }

}