package com.manhattan.repositories.carDealer;

import com.manhattan.models.carDealer.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part,Long> {
}
