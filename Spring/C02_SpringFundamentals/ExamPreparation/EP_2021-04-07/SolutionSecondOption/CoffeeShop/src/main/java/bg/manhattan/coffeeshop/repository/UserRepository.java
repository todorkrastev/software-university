package bg.manhattan.coffeeshop.repository;

import bg.manhattan.coffeeshop.model.entity.User;
import bg.manhattan.coffeeshop.model.view.UserOrdersViewModel;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT new bg.manhattan.coffeeshop.model.view.UserOrdersViewModel(u.username, size(u.orders) ) " +
            "FROM User u " +
            "ORDER BY size(u.orders) DESC")
    List<UserOrdersViewModel> findOrdersUsersWithTheirOrdersCountOrderByCountDesc();
}
