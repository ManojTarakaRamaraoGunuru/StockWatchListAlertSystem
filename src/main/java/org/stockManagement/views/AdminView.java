package org.stockManagement.views;

import groovy.util.logging.Slf4j;
import org.springframework.http.HttpStatus;
import org.stockManagement.users.User;
import org.stockManagement.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@lombok.extern.slf4j.Slf4j
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminView {

    @Autowired
    public UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        log.info("All users fetched");
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
