package com.spotifyplaylist.model.dto;

public class SongDTO implements Comparable<SongDTO> {

    private Long id;
    private String performer;
    private String title;
    private int duration;

    public SongDTO() {
    }

    public Long getId() {
        return id;
    }

    public SongDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public SongDTO setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public int compareTo(SongDTO o) {
        return Integer.compare(this.getDuration(), o.getDuration());
    }
}
