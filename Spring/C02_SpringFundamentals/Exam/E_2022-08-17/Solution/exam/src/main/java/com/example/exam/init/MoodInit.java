package com.example.exam.init;

import com.example.exam.service.MoodService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MoodInit implements CommandLineRunner {

    private final MoodService moodService;

    public MoodInit(MoodService moodService) {
        this.moodService = moodService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.moodService.initMoods();
    }
}
