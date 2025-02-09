package com.project.everWealth.users.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmailId(String emailId);

    Optional<User> findByUserName(String userName);
    
    // Optional<User> findById(Long id);
    
}
