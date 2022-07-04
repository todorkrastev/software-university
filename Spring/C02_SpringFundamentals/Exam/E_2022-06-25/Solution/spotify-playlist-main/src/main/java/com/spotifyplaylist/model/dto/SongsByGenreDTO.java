package com.spotifyplaylist.model.dto;

import java.util.Set;

public class SongsByGenreDTO {

    private Set<SongDTO> popSongs;
    private Set<SongDTO> rockSongs;
    private Set<SongDTO> jazzSongs;

    public SongsByGenreDTO() {
    }

    public Set<SongDTO> getPopSongs() {
        return popSongs;
    }

    public SongsByGenreDTO setPopSongs(Set<SongDTO> popSongs) {
        this.popSongs = popSongs;
        return this;
    }

    public Set<SongDTO> getRockSongs() {
        return rockSongs;
    }

    public SongsByGenreDTO setRockSongs(Set<SongDTO> rockSongs) {
        this.rockSongs = rockSongs;
        return this;
    }

    public Set<SongDTO> getJazzSongs() {
        return jazzSongs;
    }

    public SongsByGenreDTO setJazzSongs(Set<SongDTO> jazzSongs) {
        this.jazzSongs = jazzSongs;
        return this;
    }
}
