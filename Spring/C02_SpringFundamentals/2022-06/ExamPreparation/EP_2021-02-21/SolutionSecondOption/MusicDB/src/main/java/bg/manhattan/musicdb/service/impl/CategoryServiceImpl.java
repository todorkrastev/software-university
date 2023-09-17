package bg.manhattan.musicdb.service.impl;


import bg.manhattan.musicdb.model.entity.Artist;
import bg.manhattan.musicdb.model.entity.enums.ArtistNameEnum;
import bg.manhattan.musicdb.repository.ArtistRepository;
import bg.manhattan.musicdb.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements ArtistService {

    private final ArtistRepository repository;

    public CategoryServiceImpl(ArtistRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Artist> findByName(ArtistNameEnum name) {
        return this.repository.findByName(name);
    }
}
