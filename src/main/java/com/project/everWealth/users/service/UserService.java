package com.project.everWealth.users.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.everWealth.*;
import com.project.everWealth.users.entity.CreateUserPayload;

@Service
@Component
public interface UserService {

    // String createUser(CreateUserPayload createUserPayload);

    String fetchUserDetailsById(String userId);
    
}