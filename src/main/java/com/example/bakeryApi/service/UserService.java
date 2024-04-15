package com.example.bakeryApi.service;

import com.example.bakeryApi.User;
import com.example.bakeryApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User addUser(User newUser){
        return userRepository.save(newUser);
    }
}
