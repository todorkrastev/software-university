package bg.softuni.productshop.repositories;

import bg.softuni.productshop.models.dtos.CategoryViewRootDto;
import bg.softuni.productshop.models.dtos.CategoryViewWithProductsCountAvgPriceAndTotalRevenue;
import bg.softuni.productshop.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /*
    SELECT c.name, COUNT(p.id), AVG(p.price), SUM(p.price) FROM categories c
    JOIN products_categories pc on c.id = pc.categories_id
    JOIN products p on p.id = pc.products_id
    GROUP BY c.name
    ORDER BY COUNT(p.id) DESC
     */
    @Query("SELECT c " +
            "FROM Category c " +
            "JOIN c.products p " +
            "GROUP BY c.id " +
            "ORDER BY COUNT(p.id) DESC ")
    List<Category> findAllOrderedByProductsCountDesc();
}
