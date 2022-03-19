package bg.softuni.productshop.repositories;

import bg.softuni.productshop.models.dtos.CategoriesByProductsDto;
import bg.softuni.productshop.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT NEW bg.softuni.productshop.models.dtos.CategoriesByProductsDto(c.name,  COUNT(p), AVG(p.price), SUM(p.price)) " +
            "FROM Category c JOIN c.products p " +
            "GROUP BY c " +
            "ORDER BY SIZE(c.products) ")
    List<CategoriesByProductsDto> findAllOrderByProductCount();
}
