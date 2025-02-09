package com.project.everWealth.transactions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionListForUser{
    
    private Long transactionId;

    private Double transactionAmount;
    
    private TransactionType transactionType;
    
    private Long transactionDate;

}
