package com.example.exam.model.view;

import com.example.exam.model.entity.enums.MoodName;

public class CurrentUserPostView {

    private Long id;
    private MoodName mood;
    private String content;
    private Integer likes;
    private String username;

    public CurrentUserPostView() {
    }

    public CurrentUserPostView(Long id, MoodName mood, String content, Integer likes, String username) {
        this.id = id;
        this.mood = mood;
        this.content = content;
        this.likes = likes;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MoodName getMood() {
        return mood;
    }

    public void setMood(MoodName mood) {
        this.mood = mood;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
