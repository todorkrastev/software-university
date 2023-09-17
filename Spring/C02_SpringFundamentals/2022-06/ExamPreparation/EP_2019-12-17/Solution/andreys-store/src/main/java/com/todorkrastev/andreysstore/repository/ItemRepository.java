package com.todorkrastev.andreysstore.repository;

import com.todorkrastev.andreysstore.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

}
