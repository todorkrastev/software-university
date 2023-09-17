package com.spotifyplaylist.service.impl;

import com.spotifyplaylist.model.dto.SongDTO;
import com.spotifyplaylist.model.dto.SongsByGenreDTO;
import com.spotifyplaylist.model.entity.Style;
import com.spotifyplaylist.model.entity.Styles;
import com.spotifyplaylist.service.HomeService;
import com.spotifyplaylist.service.SongService;
import com.spotifyplaylist.service.StyleService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HomeServiceImpl implements HomeService {

    private final SongService songService;
    private final StyleService styleService;

    public HomeServiceImpl(SongServiceImpl songService, StyleService styleService) {
        this.songService = songService;
        this.styleService = styleService;
    }

    @Override
    public SongsByGenreDTO getSongs() {
        SongsByGenreDTO songs = new SongsByGenreDTO();
        songs.setPopSongs(this.getSongsByGenre(this.styleService.getStyle(Styles.POP)));
        songs.setJazzSongs(this.getSongsByGenre(this.styleService.getStyle(Styles.JAZZ)));
        songs.setRockSongs(this.getSongsByGenre(this.styleService.getStyle(Styles.ROCK)));
        return songs;
    }

    private Set<SongDTO> getSongsByGenre(Style style) {
        return this.songService.getSongsByStyle(style);
    }
}
