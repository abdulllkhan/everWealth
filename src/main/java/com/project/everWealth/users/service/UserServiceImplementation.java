package com.project.everWealth.users.service;

import com.project.everWealth.exceptions.CustomException;
import com.project.everWealth.exceptions.ErrorMessage;
import com.project.everWealth.exceptions.ErrorResponse;
import com.project.everWealth.users.entity.CreateUserPayload;
import com.project.everWealth.users.entity.CreateUserResponse;
import com.project.everWealth.users.entity.User;
import com.project.everWealth.users.entity.UserLoginPayload;
import com.project.everWealth.users.entity.UserRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;

import javax.sql.DataSource;

import org.apache.coyote.BadRequestException;
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
    public String createUser(CreateUserPayload createUserPayload) throws RuntimeException, Exception {

        try{
            if(createUserPayload == null) {
                throw new BadRequestException("Payload is empty");
            }
    
            if(createUserPayload.getUserName().isBlank() && createUserPayload.getPassword().isBlank() && createUserPayload.getEmailId().isBlank()) {
                throw new BadRequestException("username, password, emailId are mandatory fields");
            }
    
            Optional<User> user = userRepository.findByUserName(createUserPayload.getUserName());
            if (user.isPresent()) {
                throw new BadRequestException("User already exists");
            }

            Random random = new Random();
            Integer min = 10000;
            Integer max = 15000;
            Double randomNumber = (double) (random.nextInt(max - min) + min);
    
            User temp = User.builder()
                    .userName(createUserPayload.getUserName())
                    .firstName(createUserPayload.getFirstName())
                    .lastName(createUserPayload.getLastName())
                    .emailId(createUserPayload.getEmailId())
                    .accountNumber(generateRandomString(10))
                    .password(getSHA(createUserPayload.getPassword()))
                    .createdDate(System.currentTimeMillis())
                    .totalAmount(randomNumber)
                    .build();
                
            userRepository.save(temp);

            User savedOne = userRepository.findByUserName(createUserPayload.getUserName()).get();

            CreateUserResponse response = new CreateUserResponse();
            response.setUserName(temp.getUserName());
            response.setAccountNumber(temp.getAccountNumber());
            response.setUserId(savedOne.getId().toString());
            response.setMessage("User Created Successfully");
            
            return gson.toJson(response);
        //    return gson.toJson(userRepository.save(temp));
        }
        catch (Exception e) {
            throw new BadRequestException(e.toString());
        }

    }

    @Override
    public String fetchUserDetailsById(String userId) {

        try {
            userId.isBlank();
        } catch (NullPointerException e) {
            throw new CustomException("400", "username are mandatory fields");
        }

        try{
            Optional<User> user = userRepository.findById(Long.parseLong(userId));
            if (!user.isPresent()) {
                throw new CustomException("404", "User not found, invalid userId");
            } else {
                return gson.toJson(user.get());
            }
        } catch (Exception e) {
            throw new CustomException("400", e.getMessage());
        }

        // return null;
    }


    public static String getSHA(String input) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(input.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) 
                  hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
           throw new RuntimeException(ex);
        }
    }

    public static String generateRandomString(int length) {
        String characters = "0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        
        return sb.toString();
    }

    @Override
    public String loginUserPayload(UserLoginPayload userLoginPayload) throws RuntimeException, Exception {
        
        try{

            if(userLoginPayload == null) {
                throw new BadRequestException("Payload is empty");
            }
    
            if(userLoginPayload.getEmailId().isBlank() && userLoginPayload.getPassword().isBlank()) {
                throw new BadRequestException("username, password are mandatory fields");
            }
    
            Optional<User> user = userRepository.findByEmailId(userLoginPayload.getEmailId());
            if (!user.isPresent()) {
                throw new BadRequestException("User not found, invalid emailId");
            }

            User temp = user.get();
            String hashedPassword = getSHA(userLoginPayload.getPassword());
            if(!temp.getPassword().equals(hashedPassword)) {
                throw new BadRequestException("Invalid Password");
            }

            CreateUserResponse response = new CreateUserResponse();
            response.setUserName(temp.getUserName());
            response.setAccountNumber(temp.getAccountNumber());
            response.setUserId(temp.getId().toString());
            response.setMessage("Login Successful");

            return gson.toJson(response);

        } catch (Exception e) {
            throw new BadRequestException(e.toString());
        }
    }

    
}
