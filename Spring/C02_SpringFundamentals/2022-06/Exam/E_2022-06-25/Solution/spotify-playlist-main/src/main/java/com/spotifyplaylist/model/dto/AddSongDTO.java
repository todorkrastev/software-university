package com.spotifyplaylist.model.dto;

import com.spotifyplaylist.model.entity.Styles;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

//todo: testing java record
public class AddSongDTO {
    private Long id;

    @Size(min = 3, max = 20)
    @NotNull
    private String performer;

    @Size(min = 2, max = 20)
    @NotNull
    private String title;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Positive
    @NotNull
    private int duration;

    @NotNull
    private Styles style;

    public AddSongDTO() {
    }

    public Long getId() {
        return id;
    }

    public AddSongDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public AddSongDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AddSongDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AddSongDTO setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public AddSongDTO setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public Styles getStyle() {
        return style;
    }

    public AddSongDTO setStyle(Styles style) {
        this.style = style;
        return this;
    }
}
