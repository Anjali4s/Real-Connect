package com.real_connect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.real_connect.entity.User;
import com.real_connect.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Trim and convert email to lowercase
        user.setEmail(user.getEmail().trim().toLowerCase());

        // Encode the password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);  // Set the encoded password

        // Save the user
        return userRepository.save(user);
    }

//    public User registerUser(User user) {
//    	user.setEmail(user.getEmail().trim().toLowerCase());
//        return userRepository.save(user);
//    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email.trim().toLowerCase());
    }
}
