package com.example.churchbillboard2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.churchbillboard2.controllers.LoginDTO;
import com.example.churchbillboard2.models.User;
import com.example.churchbillboard2.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUserName(LoginDTO user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return userRepository.findUserByUserName(user.getUsername(), user.getPassword());
    }
}
