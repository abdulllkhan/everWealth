package com.project.everWealth.users.service;

import com.project.everWealth.users.entity.CreateUserPayload;

import com.project.everWealth.users.entity.UserRepository;

import com.google.gson.Gson;

public class UserServiceImplementation implements UserService {

    private Gson gson = new Gson();
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository,
                                        Gson gson) {
        this.userRepository = userRepository;
        this.gson = gson;
    }

    // @Override
    // public String createUser(CreateUserPayload createUserPayload) {
        


    //     return null;
    // }
    
}
