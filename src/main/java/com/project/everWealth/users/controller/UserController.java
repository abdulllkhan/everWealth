package com.project.everWealth.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import com.google.gson.Gson;
import com.project.everWealth.users.entity.CreateUserPayload;
import com.project.everWealth.users.entity.UserLoginPayload;
import com.project.everWealth.users.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class UserController {

    @Autowired
    private final UserService userService;
    // @Autowired
    // private Gson gson = new Gson();

    // @Autowired
    public UserController(UserService userService
                            // Gson gson
                            ) {
        this.userService = userService;
        // this.gson = gson;
    }

    @PostMapping("api/user/login")
    public String loginUserPayload(@RequestBody UserLoginPayload userLoginPayload) throws Throwable{
        return userService.loginUserPayload(userLoginPayload);
    }

    @PostMapping("api/user/create")
    public String createUser(@RequestBody CreateUserPayload createUserPayload) throws Throwable{
        return userService.createUser(createUserPayload);
    }

    @GetMapping("api/user/id/{userId}")
    public String getUserById(@PathVariable String userId) throws Throwable{
        return userService.fetchUserDetailsById(userId);
        // return 
    }

    
}
