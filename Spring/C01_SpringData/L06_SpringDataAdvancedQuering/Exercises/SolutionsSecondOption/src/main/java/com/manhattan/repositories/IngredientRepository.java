package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String nameStart);
    List<Ingredient> findAllByNameInOrderByPriceAsc(Set<String> names);

    @Transactional
    @Modifying
    int deleteByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE Ingredient i " +
            "SET i.price = i.price * (100 + :percent) / 100")
    int updateAllBy(int percent);

    @Transactional
    @Modifying
    @Query("UPDATE Ingredient i " +
            "SET i.price = i.price * (100 + :percent) / 100 " +
            "WHERE i.name IN :names")
    int updateAllInList(Set<String> names, int percent);


}
