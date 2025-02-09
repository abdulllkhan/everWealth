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

    // @Override
    // public String createUser(CreateUserPayload createUserPayload) {
    //     return null;
    // }

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

    public Boolean isSessionCodeValid(String sessionCode){
            
        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")){
            
            statement.setString(1, sessionCode);
            try(ResultSet resultSet = statement.executeQuery()){
                while(resultSet.next()){
                    return true;
                }
            }

        }catch(SQLException e){
            throw new CustomException("400", e.getMessage());
        }catch(RuntimeException e){
            throw new CustomException("500", e.getMessage());
        }
    
        return false;
    }
    
}
