package com.example.exam.service.impl;

import com.example.exam.model.entity.Mood;
import com.example.exam.model.entity.enums.MoodName;
import com.example.exam.repository.MoodRepository;
import com.example.exam.service.MoodService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void initMoods() {
        if (this.moodRepository.findAll().isEmpty()) {
            Arrays
                    .stream(MoodName.values())
                    .forEach(moodName -> {
                        Mood mood = new Mood();
                        mood.setMoodName(moodName);
                        mood.setDescription("Description for " + moodName.name().toLowerCase());

                        this.moodRepository.save(mood);
                    });
        }
    }

    @Override
    public Mood getByName(MoodName mood) {
        return this.moodRepository
                .getByMoodName(mood)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("There is no such a mood [%s]", mood)
                ));
    }
}
