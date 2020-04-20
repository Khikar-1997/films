package com.example.demo.persistance.repository.user;

import com.example.demo.persistance.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select p from User p where p.username = ?1")
    User findByUsername(String username);
}
