package bg.manhattan.musicdb.service;


import bg.manhattan.musicdb.model.entity.Artist;
import bg.manhattan.musicdb.model.entity.enums.ArtistNameEnum;

import java.util.Optional;

public interface ArtistService {
    Optional<Artist> findByName(ArtistNameEnum category);
}
