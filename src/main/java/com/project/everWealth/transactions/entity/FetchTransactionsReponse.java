package com.project.everWealth.transactions.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchTransactionsReponse {

    private Integer totalTransactions;

    private String accountNumber;

    private Double totalBalance;

    private ArrayList<TransactionListForUser> userTransactions = new ArrayList<>();
    
}
