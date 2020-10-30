package com.example.assignments._spring_rest.repositories;

import com.example.assignments._spring_rest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT * FROM User user WHERE user.username = ?")
    User findByUsername(String username);
}
