package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
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
    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findAllBySize(Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPriceAsc(Size size, long id);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Long countAllByPriceLessThan(BigDecimal price);

    @Query("SELECT DISTINCT s.brand " +
            "FROM Shampoo s " +
            "JOIN s.ingredients i " +
            "WHERE i.name in :ingredients")
    List<String> findAllByIngredientsNames(@Param("ingredients") Set<String> ingredientsNames);

    @Query("SELECT DISTINCT s.brand " +
            "FROM Shampoo s " +
            "WHERE s.ingredients.size < :ingredientsCount")
    List<String> findAllWithIngredientsCountLessThan(@Param("ingredientsCount") int ingredientsCount);
}
