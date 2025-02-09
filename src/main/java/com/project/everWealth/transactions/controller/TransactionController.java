package com.project.everWealth.transactions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.project.everWealth.transactions.service.TransactionService;
import com.project.everWealth.users.entity.CreateUserPayload;
import com.project.everWealth.users.entity.UserLoginPayload;
import com.project.everWealth.users.service.UserService;

@RestController
public class TransactionController {

    private Gson gson = new Gson();
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(Gson gson,
                                TransactionService transactionService
                                ) {
        this.gson = gson;
        this.transactionService = transactionService;
    }

    @GetMapping("api/transaction/id/{userId}")
    public String getTransactionById(@PathVariable Long userId) throws Throwable{
        return transactionService.fetchTransactionsByUserId(userId);
    }


    
}
