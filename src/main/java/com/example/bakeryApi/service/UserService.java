package com.example.bakeryApi.service;

import com.example.bakeryApi.User;
import com.example.bakeryApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }
    public User addUser(User newUser){
        return userRepository.save(newUser);
    }

    public void removeUser(String userId){
        userRepository.deleteById(userId);
    }

}
