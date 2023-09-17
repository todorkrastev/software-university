package bg.manhattan.gira.repository;

import bg.manhattan.gira.model.entity.Task;
import bg.manhattan.gira.model.entity.enums.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByName(String taskName);

    List<Task> findAllByProgressLessThan(Progress progress);
}
