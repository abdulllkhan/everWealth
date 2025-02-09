package com.project.everWealth.users.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.Instant;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName; 

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "street_number", nullable = false)
    private String streetNumber;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false, length = 10)
    private String state;

    @Column(name = "zip", nullable = false, length = 10)
    private String zip;

    @Column(name = "email_id", unique = true, nullable = false)
    private String emailId;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_date", nullable = false)
    private Long createdDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = Instant.now().getEpochSecond(); // Set Unix timestamp before persisting
    }
}
