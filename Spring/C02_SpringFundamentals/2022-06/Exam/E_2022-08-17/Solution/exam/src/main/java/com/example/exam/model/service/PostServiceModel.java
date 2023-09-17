package com.example.exam.model.service;

import com.example.exam.model.entity.enums.MoodName;

public class PostServiceModel {

    private Long id;
    private String content;
    private MoodName mood;

    public PostServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
