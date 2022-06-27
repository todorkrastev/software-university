package bg.manhattan.shoppinglist.repository;

import bg.manhattan.shoppinglist.model.entity.Product;
import bg.manhattan.shoppinglist.model.view.ShoppingItemViewModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new bg.manhattan.shoppinglist.model.view.ShoppingItemViewModel(p.id, p.name, p.price, c.name) " +
            "FROM Product p " +
            "JOIN p.category c")
    List<ShoppingItemViewModel> findAllShoppingItems();
}
