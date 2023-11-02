package com.example.churchbillboard2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.churchbillboard2.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    User findUserByUserName(@Param("userName") String userName);
}

