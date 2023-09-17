package com.spotifyplaylist.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Song extends BaseEntity {

    @Column(nullable = false)
    private String performer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int duration;

    @Column
    private LocalDate releaseDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_style")
    private Style style;

    @ManyToMany(mappedBy = "playlist")
    private Set<User> users;

    public Song() {
    }

    public String getPerformer() {
        return performer;
    }

    public Song setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Song setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public Song setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Song setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Style getStyle() {
        return style;
    }

    public Song setStyle(Style style) {
        this.style = style;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Song setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return getId().equals(song.getId())
                && getDuration() == song.getDuration()
                && getPerformer().equals(song.getPerformer())
                && getTitle().equals(song.getTitle())
                && Objects.equals(getReleaseDate(), song.getReleaseDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPerformer(), getTitle(), getDuration(), getReleaseDate());
    }

    @Override
    public String toString() {
        return "Song{" +
                "performer='" + getPerformer() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", duration=" + getDuration() +
                ", releaseDate=" + getReleaseDate() +
                '}';
    }
}
