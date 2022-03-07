package bg.softuni.springdataintrolab.repositories;

import bg.softuni.springdataintrolab.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
