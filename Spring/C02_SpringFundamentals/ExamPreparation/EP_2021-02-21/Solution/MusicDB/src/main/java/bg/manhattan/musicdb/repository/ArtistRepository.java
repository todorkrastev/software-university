package bg.manhattan.musicdb.repository;


import bg.manhattan.musicdb.model.entity.Artist;
import bg.manhattan.musicdb.model.entity.enums.ArtistNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByName(ArtistNameEnum name);
}
