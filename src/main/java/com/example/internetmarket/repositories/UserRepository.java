package com.example.internetmarket.repositories;

import com.example.internetmarket.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(final String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
