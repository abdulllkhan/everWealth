package com.project.everWealth.users.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FetchUserDetailsResponse {

    private String userId;
    
    private String firstName;
    
    private String lastName;
    
    private String email;

    private String accountNumber;
    
}
