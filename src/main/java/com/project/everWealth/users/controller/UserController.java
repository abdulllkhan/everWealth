package com.project.everWealth.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.everWealth.users.entity.CreateUserPayload;
import com.project.everWealth.users.service.UserService;

public class UserController {

    private final UserService UserService;

    @Autowired
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    // @PostMapping("user/create")
    // public String createUser(@RequestBody CreateUserPayload createUserPayload) {
    //     return UserService.createUser(createUserPayload);
    // }

    
}
