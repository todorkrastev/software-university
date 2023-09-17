package com.example.exam.model.binding;

import com.example.exam.model.entity.enums.MoodName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostBindingModel {

    @NotNull(message = "Content is required")
    @Size(min = 2, max = 150, message = "Content length must be between 2 and 150 characters (inclusive of 2 and 150).")
    private String content;

    @NotNull(message = "You must select a Mood!")
    private MoodName mood;

    public PostBindingModel() {
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
