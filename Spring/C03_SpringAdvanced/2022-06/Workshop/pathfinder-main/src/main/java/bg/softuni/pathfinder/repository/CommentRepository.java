package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.Comment;
import bg.softuni.pathfinder.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findAllByRoute(Route route);
}
