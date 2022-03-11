package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameIsStartingWith(String letters);

    Set<Ingredient> findAllByNameInOrderByPriceAsc(Set<String> names);

    int deleteIngredientByName(String name);

    // Second option for exercise 09. Delete Ingredients By Name

    // @Query("DELETE FROM Ingredient WHERE name = :name")
    // @Modifying
    // void deleteAllByName(String name);

    @Modifying
    @Query(value = "UPDATE Ingredient i " +
            "SET i.price = i.price + i.price * :multiplier / 100")
    int increasePriceByPercentage(@Param(value = "multiplier")
                                          BigDecimal percentage);

    @Modifying
    @Query("UPDATE Ingredient i " +
            "SET i.price = i.price + i.price * :percentage / 100 " +
            "WHERE i.name IN :names")
    int increasePricesWithGivenPercentageAndListOfNames(BigDecimal percentage, Collection<String> names);
}
