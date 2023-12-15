package com.example.youDobackend.controller;

// Path: src/main/java/com/example/demo/controller/UserController.java

import com.example.youDobackend.model.User;
import com.example.youDobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        // Add validation logic, e.g., check if the username is unique
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (new BCryptPasswordEncoder().matches(user.getPassword(), existingUser.getPassword())) {
            return "Authentication successful";
        } else {
            throw new RuntimeException("Authentication failed");
        }
    }

    // Add other user-related operations as needed
}

