package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.model.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
