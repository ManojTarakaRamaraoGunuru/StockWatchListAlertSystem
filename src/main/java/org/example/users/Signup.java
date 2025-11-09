package org.example.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Signup {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = userService.signUp(user);
        return ResponseEntity.ok(savedUser);
    }
}
