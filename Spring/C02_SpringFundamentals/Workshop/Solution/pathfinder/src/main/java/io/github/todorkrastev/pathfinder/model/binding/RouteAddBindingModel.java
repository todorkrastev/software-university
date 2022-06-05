package io.github.todorkrastev.pathfinder.model.binding;

import io.github.todorkrastev.pathfinder.model.entity.enums.CategoryName;
import io.github.todorkrastev.pathfinder.model.entity.enums.LevelName;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class RouteAddBindingModel {

    private String name;
    private String description;
    private MultipartFile gpxCoordinates;
    private LevelName levelName;
    private String videoUrl;
    private Set<CategoryName> categories;

    public RouteAddBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Route name must be between 3 and 20 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 3, message = "Description must be at least 3 characters!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    @NotNull
    public LevelName getLevel() {
        return levelName;
    }

    public void setLevel(LevelName level) {
        this.levelName = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<CategoryName> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryName> categories) {
        this.categories = categories;
    }
}
