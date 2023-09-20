package com.bassure.springboot.main.controller;

import com.bassure.springboot.main.dto.UserRequest;
import com.bassure.springboot.main.entity.User;
import com.bassure.springboot.main.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody @Valid UserRequest userRequest) {
        System.out.println("--------");

        LOGGER.info("--------inside addUser()--------");
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {

        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {

        return ResponseEntity.ok(userService.findUserById(id));
    }

    @GetMapping("/checking")
    public String checking() {

        return "api working fine";

    }

}
