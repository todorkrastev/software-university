package softuni.exam.service;

import softuni.exam.model.entity.Artist;
import softuni.exam.model.entity.enums.ArtistNameEnum;

public interface ArtistService {
    void initializeArtists();

    Artist findArtistByName(ArtistNameEnum artist);
}
