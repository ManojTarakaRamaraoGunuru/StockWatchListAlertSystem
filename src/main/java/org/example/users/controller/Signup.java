package org.example.users.controller;

import org.example.users.entity.User;
import org.example.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Signup {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = userService.signUp(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/signin")
    public ResponseEntity<User> validateUSer(@RequestBody User user) {
        User savedUser = userService.signIn(user);
        return ResponseEntity.ok(savedUser);
    }
}
