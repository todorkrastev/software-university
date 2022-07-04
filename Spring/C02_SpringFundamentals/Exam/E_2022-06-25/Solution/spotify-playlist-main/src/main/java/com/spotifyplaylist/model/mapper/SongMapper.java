package com.spotifyplaylist.model.mapper;

import com.spotifyplaylist.model.dto.AddSongDTO;
import com.spotifyplaylist.model.dto.SongDTO;
import com.spotifyplaylist.model.entity.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {

    SongDTO toSongDTO(Song song);

    Song toSong(AddSongDTO addSongDTO);
}
