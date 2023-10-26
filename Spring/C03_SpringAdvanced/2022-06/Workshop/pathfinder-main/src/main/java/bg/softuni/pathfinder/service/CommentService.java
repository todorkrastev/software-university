package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.exceptions.RouteNotFoundException;
import bg.softuni.pathfinder.model.Comment;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.CommentCreationDto;
import bg.softuni.pathfinder.model.views.CommentDisplayView;
import bg.softuni.pathfinder.repository.CommentRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private RouteRepository routeRepository;
    private UserRepository userRepository;
    private CommentRepository commentRepository;

    public CommentService(RouteRepository routeRepository, UserRepository userRepository,
                          CommentRepository commentRepository) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public List<CommentDisplayView> getAllCommentsForRoute(Long routeId) {
        Route route = routeRepository.findById(routeId).orElseThrow(RouteNotFoundException::new);

        List<Comment> comments = commentRepository.findAllByRoute(route).get();
        return comments.stream().map(comment -> new CommentDisplayView(comment.getId(), comment.getAuthor().getFullName(),
            comment.getText())).collect(Collectors.toList());
    }

    public CommentDisplayView createComment(CommentCreationDto commentDto) {
        User author = userRepository.findByUsername(commentDto.getUsername()).get();

        Comment comment = new Comment();
        comment.setCreated(LocalDateTime.now());
        comment.setRoute(routeRepository.getById(commentDto.getRouteId()));
        comment.setAuthor(author);
        comment.setApproved(true);
        comment.setText(commentDto.getMessage());

        commentRepository.save(comment);

        return new CommentDisplayView(comment.getId(), author.getFullName(), comment.getText());
    }
}
