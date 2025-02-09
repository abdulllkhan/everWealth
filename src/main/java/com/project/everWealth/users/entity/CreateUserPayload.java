package com.project.everWealth.users.entity;


import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class CreateUserPayload {

    @NotBlank(message = "Username is required")
    private String userName;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Street number is required")
    private String streetNumber;

    @NotBlank(message = "Street name is required")
    private String streetName;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "ZIP code is required")
    private String zip;

    @NotBlank(message = "Nessie ID is required")
    private String nessieId;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @NotBlank(message = "Password is required")
    private String password;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String emailId;
}
