package com.spotifyplaylist.service.impl;

import com.spotifyplaylist.model.dto.AddSongDTO;
import com.spotifyplaylist.model.dto.SongDTO;
import com.spotifyplaylist.model.entity.Song;
import com.spotifyplaylist.model.entity.Style;
import com.spotifyplaylist.model.mapper.SongMapper;
import com.spotifyplaylist.repo.SongRepo;
import com.spotifyplaylist.service.SongService;
import com.spotifyplaylist.service.StyleService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepo repo;
    private final StyleService styleService;
    private final SongMapper songMapper;

    public SongServiceImpl(SongRepo repo, StyleService styleService, SongMapper songMapper) {
        this.repo = repo;
        this.styleService = styleService;
        this.songMapper = songMapper;
    }

    @Override
    public void addSong(AddSongDTO addSongDTO) {
        Song song = this.songMapper.toSong(addSongDTO);
        song.setStyle(this.styleService.getStyle(addSongDTO.getStyle()));
        this.repo.save(song);
    }

    @Override
    public Song getSongById(Long id) {
        return this.repo.findById(id).orElseThrow();
    }

    @Override
    public Set<SongDTO> getSongsByStyle(Style style) {
        return this.repo.findByStyle(style)
                .stream()
                .map(this.songMapper::toSongDTO)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Set<SongDTO> getPlaylist(Long id) {
        return this.repo.findAllByUserId(id)
                .stream()
                .map(this.songMapper::toSongDTO)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    /*
    private SongDTO mapSongDTO(Song song) {
        return new SongDTO()
                .setId(song.getId())
                .setDuration(song.getDuration())
                .setPerformer(song.getPerformer())
                .setTitle(song.getTitle());
    }

    private Song mapSong(AddSongDTO addSongDTO) {
        return new Song()
                .setDuration(addSongDTO.getDuration())
                .setPerformer(addSongDTO.getPerformer())
                .setStyle(this.styleService.findStyle(addSongDTO.getStyle()))
                .setTitle(addSongDTO.getTitle())
                .setReleaseDate(addSongDTO.getReleaseDate());
    }
     */
}
