package com.example.exam.repository;

import com.example.exam.model.entity.Post;
import com.example.exam.model.view.CurrentUserPostView;
import com.example.exam.model.view.OtherUserPostView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT new com.example.exam.model.view.CurrentUserPostView(p.id, p.mood.moodName, p.content, size(p.userLikes), p.user.username) " +
            "FROM Post p ")
    List<CurrentUserPostView> findAllByIdAndUsernameAndMoodAndLikesAndContent();

    @Query("SELECT new com.example.exam.model.view.OtherUserPostView(p.id, p.user.username, p.content, p.mood.moodName, size(p.userLikes)) " +
            "FROM Post p ")
    List<OtherUserPostView> findAllOtherUsersPosts();
}
