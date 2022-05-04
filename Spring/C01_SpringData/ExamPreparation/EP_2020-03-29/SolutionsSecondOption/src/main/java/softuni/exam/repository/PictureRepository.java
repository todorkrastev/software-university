package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long> {
}
