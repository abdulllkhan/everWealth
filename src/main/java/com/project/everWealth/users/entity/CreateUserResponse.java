package com.project.everWealth.users.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {

    private String userName;

    private String accountNumber;

    private String userId;

    private String message;

    
}
