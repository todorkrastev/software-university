package io.github.todorkrastev.pathfinder.model.view;

import io.github.todorkrastev.pathfinder.model.entity.Picture;
import io.github.todorkrastev.pathfinder.model.entity.enums.LevelName;

import java.util.Set;

public class RouteDetailsViewModel {

    private String gpxCoordinates;
    private String description;
    private LevelName levelName;
    private String name;
    private String videoUrl;
    private Set<Picture> pictures;

    public RouteDetailsViewModel() {
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LevelName getLevelName() {
        return levelName;
    }

    public void setLevelName(LevelName levelName) {
        this.levelName = levelName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
