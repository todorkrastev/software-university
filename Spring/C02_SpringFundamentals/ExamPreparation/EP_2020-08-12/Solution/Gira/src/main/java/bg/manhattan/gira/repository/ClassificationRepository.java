package bg.manhattan.gira.repository;


import bg.manhattan.gira.model.entity.Classification;
import bg.manhattan.gira.model.entity.enums.ClassificationNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    Optional<Classification> findByName(ClassificationNameEnum classification);
}
