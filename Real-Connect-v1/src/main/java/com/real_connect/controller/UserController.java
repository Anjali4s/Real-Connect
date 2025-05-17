package com.real_connect.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.real_connect.entity.User;
import com.real_connect.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Name cannot be empty");
        }
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            return ResponseEntity.badRequest().body("Invalid email format");
        }
        if (user.getPassword() == null || user.getPassword().length() < 6) {
            return ResponseEntity.badRequest().body("Password must be at least 6 characters long");
        }

        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email) {
        if (email == null || !email.contains("@")) {
            return ResponseEntity.badRequest().body("Invalid email format");
        }

        Optional<User> user = userService.getUserByEmail(email);
        
        return user.isPresent() 
            ? ResponseEntity.ok(user.get()) 
            : ResponseEntity.badRequest().body("User not found");
    }


}