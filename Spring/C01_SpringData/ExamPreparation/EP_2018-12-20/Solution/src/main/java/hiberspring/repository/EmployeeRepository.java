package hiberspring.repository;

import hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    boolean existsEmployeeByCardNumber(String cardNumber);

    @Query("SELECT e " +
            "FROM Employee e JOIN e.branch b " +
            "WHERE SIZE(b.products) > 0 " +
            "ORDER BY CONCAT(e.firstName, ' ', e.lastName), LENGTH(e.position) DESC")
    List<Employee> findAllByBranchHavingAtLeastOneProduct();
}
