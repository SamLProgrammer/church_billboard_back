package com.example.churchbillboard2.services;

import org.springframework.stereotype.Service;
import com.example.churchbillboard2.DTOs.LoginDTO;
import com.example.churchbillboard2.models.User;
import com.example.churchbillboard2.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUserName(LoginDTO user) {
        return userRepository.validateUser(user.getUsername(), user.getPassword());
    }
}
