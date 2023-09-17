package com.example.exam.model.view;

import com.example.exam.model.entity.enums.MoodName;

public class OtherUserPostView {

    private Long id;
    private String username;
    private String content;
    private MoodName mood;
    private Integer likes;

    public OtherUserPostView() {
    }

    public OtherUserPostView(Long id, String username, String content, MoodName mood, Integer likes) {
        this.id = id;
        this.username = username;
        this.content = content;
        this.mood = mood;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodName getMood() {
        return mood;
    }

    public void setMood(MoodName mood) {
        this.mood = mood;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
