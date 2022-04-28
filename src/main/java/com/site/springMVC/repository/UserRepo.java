package com.site.springMVC.repository;

import com.site.springMVC.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM USER where id>?",nativeQuery = true)
    List<User> listUserWhereParam(String id);

}
