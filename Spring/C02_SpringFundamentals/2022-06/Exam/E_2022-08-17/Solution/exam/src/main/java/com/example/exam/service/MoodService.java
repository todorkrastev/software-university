package com.example.exam.service;

import com.example.exam.model.entity.Mood;
import com.example.exam.model.entity.enums.MoodName;

public interface MoodService {
    void initMoods();

    Mood getByName(MoodName mood);
}
