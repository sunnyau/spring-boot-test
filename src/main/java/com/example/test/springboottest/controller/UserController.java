package com.example.test.springboottest.controller;

import com.example.test.springboottest.model.UserView;
import com.example.test.springboottest.repository.User;
import com.example.test.springboottest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
