package com.project.everWealth.transactions.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // List<Transaction> findAllByUserId(Long userId);
    
}
