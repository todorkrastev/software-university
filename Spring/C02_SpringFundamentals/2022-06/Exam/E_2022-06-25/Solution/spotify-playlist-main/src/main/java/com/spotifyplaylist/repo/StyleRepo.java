package com.spotifyplaylist.repo;

import com.spotifyplaylist.model.entity.Style;
import com.spotifyplaylist.model.entity.Styles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StyleRepo extends JpaRepository<Style, Long> {

    Optional<Style> findByStyleName(Styles style);
}
