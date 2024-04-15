package com.example.bakeryApi.controller;

import com.example.bakeryApi.User;
import com.example.bakeryApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User userBody) {
        return new ResponseEntity<>(userService.addUser(userBody), HttpStatus.OK);
    }

    @PostMapping("/removeUser/{userId}")
    public ResponseEntity<Void> removeUser(@PathVariable("userId") String userId) {
        userService.removeUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
