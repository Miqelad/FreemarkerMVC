package com.site.mikeladze.repository;

import com.site.mikeladze.model.Login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    /* https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation */
    User findByUsername(String username);
}
