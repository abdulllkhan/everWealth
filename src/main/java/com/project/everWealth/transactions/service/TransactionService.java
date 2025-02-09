package com.project.everWealth.transactions.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface TransactionService {

    String fetchTransactionsByUserId(Long userId) throws RuntimeException, Exception;
    
}
