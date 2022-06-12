package com.todorkrastev.shoppinglist.repository;

import com.todorkrastev.shoppinglist.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
