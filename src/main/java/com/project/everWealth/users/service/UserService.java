package com.project.everWealth.users.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.everWealth.*;
import com.project.everWealth.users.entity.CreateUserPayload;
import com.project.everWealth.users.entity.UserLoginPayload;

@Service
@Component
public interface UserService {

    String loginUserPayload(UserLoginPayload userLoginPayload) throws RuntimeException, Exception;

    String createUser(CreateUserPayload createUserPayload) throws RuntimeException, Exception;

    String fetchUserDetailsById(String userId) throws RuntimeException, Exception;
    
}