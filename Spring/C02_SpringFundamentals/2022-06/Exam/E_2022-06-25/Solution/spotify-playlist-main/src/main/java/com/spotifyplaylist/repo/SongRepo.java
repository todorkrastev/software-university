package com.spotifyplaylist.repo;

import com.spotifyplaylist.model.entity.Song;
import com.spotifyplaylist.model.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SongRepo extends JpaRepository<Song, Long> {

    Set<Song> findByStyle(Style style);

    @Query("select s, u from Song s join s.users u on u.id = :id")
    Set<Song> findAllByUserId(@Param("id") Long id);
}
