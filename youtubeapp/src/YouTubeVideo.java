import java.util.List;

public class YouTubeVideo {

     private List<String> thumbnails;
     private List<YouTubeMedia> medias;
     private String webPlayerUrl;
     private String embeddedWebPlayerUrl;

     public List<String> getThumbnails() {
          return thumbnails;
     }
     public void setThumbnails(List<String> thumbnails) {
          this.thumbnails = thumbnails;
     }

     public List<YouTubeMedia> getMedias() {
          return medias;
     }
     public void setMedias(List<YouTubeMedia> medias) {
         this.medias = medias;
     }

     public String getWebPlayerUrl() {
          return webPlayerUrl;
     }
     public void setWebPlayerUrl(String webPlayerUrl) {
            this.webPlayerUrl = webPlayerUrl;
     }

     public String getEmbeddedWebPlayerUrl() {
          return embeddedWebPlayerUrl;
     }
     public void setEmbeddedWebPlayerUrl(String embeddedWebPlayerUrl) {
          this.embeddedWebPlayerUrl = embeddedWebPlayerUrl;
     }

     public String retrieveHttpLocation() {
          if (medias==null || medias.isEmpty()) {
               return null;
          }
          for (YouTubeMedia media : medias) {
               String location = media.getLocation();
               if (location.startsWith("http")) {
                    return location;
               }
          }
          return null;
      }

}