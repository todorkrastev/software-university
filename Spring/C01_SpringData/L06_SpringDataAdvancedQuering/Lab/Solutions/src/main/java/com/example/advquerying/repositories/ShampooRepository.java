package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPriceAsc(Size size, long label);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);

    @Query(value = "SELECT DISTINCT s FROM Shampoo s " +
            "JOIN s.ingredients i " +
            "WHERE i.name IN :ingredients")
    List<Shampoo> findByIngredientsNames(@Param(value = "ingredients")
                                                 Set<String> ingredients);

    @Query(value = "SELECT s FROM Shampoo s " +
            "WHERE size(s.ingredients) < :number")
    List<Shampoo> findByIngredientCountLessThan(@Param(value = "number")
                                                        int number);
}