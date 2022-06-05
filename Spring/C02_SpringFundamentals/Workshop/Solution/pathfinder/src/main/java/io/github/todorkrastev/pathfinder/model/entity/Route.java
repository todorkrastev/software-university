package io.github.todorkrastev.pathfinder.model.entity;

import io.github.todorkrastev.pathfinder.model.entity.enums.LevelName;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {

    private String gpxCoordinates;
    private String description;
    private LevelName levelName;
    private String name;
    private User author;
    private String videoUrl;
    private Set<Picture> pictures;
    private Set<Category> categories;

    public Route() {
        this.categories = new HashSet<>();
        this.pictures = new HashSet<>();
    }

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    public LevelName getLevelEnum() {
        return levelName;
    }

    public void setLevelEnum(LevelName levelEnum) {
        this.levelName = levelEnum;
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Column(name = "video_url")
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
