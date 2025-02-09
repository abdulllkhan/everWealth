package com.project.everWealth.users.service;

import com.project.everWealth.exceptions.CustomException;
import com.project.everWealth.users.entity.CreateUserPayload;
import com.project.everWealth.users.entity.User;
import com.project.everWealth.users.entity.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
@Component
public class UserServiceImplementation implements UserService {

    private Gson gson = new Gson();
    private final UserRepository userRepository;
    private DataSource dataSource;

    public UserServiceImplementation(UserRepository userRepository,
                                        Gson gson,
                                        DataSource dataSource) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.dataSource = dataSource;
    }

    @Override
    public String createUser(CreateUserPayload createUserPayload) {

        User user = User.builder()
                .userName(createUserPayload.getUserName())
                .firstName(createUserPayload.getFirstName())
                .lastName(createUserPayload.getLastName())
                .streetNumber(createUserPayload.getStreetNumber())
                .streetName(createUserPayload.getStreetName())
                .city(createUserPayload.getCity())
                .state(createUserPayload.getState())
                .zip(createUserPayload.getZip())
                .emailId(createUserPayload.getEmailId())
                .accountNumber(createUserPayload.getAccountNumber())
                .password(createUserPayload.getPassword())
                .createdDate(System.currentTimeMillis())
                .build();
            
        // userRepository.save(user);

        return gson.toJson(userRepository.save(user));

    }

    @Override
    public String fetchUserDetailsById(String userId) {

        try {
            userId.isBlank();
        } catch (NullPointerException e) {
            throw new CustomException("400", "username are mandatory fields");
        }

        Optional<User> user = userRepository.findById(Long.parseLong(userId));
        if (!user.isPresent()) {
            throw new CustomException("404", "User not found, invalid userId");
        } else {
            return gson.toJson(user.get());
        }
        // return null;
    }

    
}
