package bg.softuni.pathfinder.model.views;

import java.util.List;
import java.util.Set;

public class RouteDetailsView {
    private Long id;
    private String gpxCoordinates;
    private String level;
    private String name;
    private String description;
    private String authorName;
    private String videoUrl;
    private List<String> pictureUrls;

    public RouteDetailsView(Long id, String gpxCoordinates, String level, String name,
                            String description, String authorName, String videoUrl, List<String> pictureUrls) {
        this.id = id;
        this.gpxCoordinates = gpxCoordinates;
        this.level = level;
        this.name = name;
        this.description = description;
        this.authorName = authorName;
        this.videoUrl = videoUrl;
        this.pictureUrls = pictureUrls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }
}
