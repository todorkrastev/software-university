package com.example.exam.model.entity;

import com.example.exam.model.entity.enums.MoodName;

import javax.persistence.*;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "mood_name", nullable = false, unique = true)
    private MoodName moodName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Mood() {
    }

    public MoodName getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodName moodName) {
        this.moodName = moodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
