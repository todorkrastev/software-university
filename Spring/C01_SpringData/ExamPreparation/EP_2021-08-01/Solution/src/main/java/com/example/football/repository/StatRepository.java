package com.example.football.repository;

import com.example.football.models.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {

    boolean existsByPassingAndShootingAndEndurance(Float passing, Float shooting, Float endurance);

    boolean existsById(Long id);
}
