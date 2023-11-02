package com.example.churchbillboard2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.churchbillboard2.models.User;
import com.example.churchbillboard2.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
