package com.example.churchbillboard2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.churchbillboard2.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    @Query(value = "SELECT * FROM Users u WHERE u.userName = ?1 AND u.password = ?2", nativeQuery = true)
    User validateUser(String userName, String password);
}
