package com.example.exam.repository;

import com.example.exam.model.entity.Mood;
import com.example.exam.model.entity.enums.MoodName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {
    Optional<Mood> getByMoodName(MoodName mood);
}
