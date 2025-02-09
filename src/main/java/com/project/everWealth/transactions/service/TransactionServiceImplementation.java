package com.project.everWealth.transactions.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.hibernate.engine.profile.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.project.everWealth.transactions.entity.TransactionRepository;
import com.project.everWealth.users.entity.User;
import com.project.everWealth.users.entity.UserRepository;
import com.project.everWealth.users.service.UserService;
import com.project.everWealth.transactions.entity.FetchTransactionsReponse;
import com.project.everWealth.transactions.entity.Transaction;
import com.project.everWealth.transactions.entity.TransactionListForUser;

@Service
@Component
public class TransactionServiceImplementation implements TransactionService {

    private final UserService userService;
    private Gson gson = new Gson();
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    @Autowired
    public TransactionServiceImplementation(UserService userService,
                                Gson gson,
                                TransactionRepository transactionRepository,
                                UserRepository userRepository
                                ) {
        this.gson = gson;
        this.userService = userService;
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }


    @Override
    public String fetchTransactionsByUserId(Long userId) throws RuntimeException, Exception {

        try{
            if(userId == null) {
                throw new RuntimeException("User Id is empty");
            }

            Optional<User> user = userRepository.findById(userId);
            if(user.isEmpty()) {
                throw new RuntimeException("User does not exist");
            }

            List<Transaction> transactions = transactionRepository.findAll();

            // return the transactions in paginated format

            List<Transaction> transactionsForUser = transactions.stream().filter(transaction -> transaction.getUserId() == userId).toList();

            FetchTransactionsReponse fetchTransactionsReponse = new FetchTransactionsReponse();
            fetchTransactionsReponse.setTotalTransactions(transactionsForUser.size());
            fetchTransactionsReponse.setAccountNumber(user.get().getAccountNumber());

            Double totalBalance = user.get().getTotalAmount();
            if(totalBalance == null) {
                totalBalance = 0.0;
            }
            fetchTransactionsReponse.setTotalBalance(totalBalance);

            ArrayList<TransactionListForUser> transactionListForUser = new ArrayList<>();

            for(Transaction transaction : transactionsForUser) {
                TransactionListForUser transactionList = new TransactionListForUser();
                transactionList.setTransactionId(transaction.getTransactionId());
                transactionList.setTransactionAmount(transaction.getTransactionAmount());
                transactionList.setTransactionType(transaction.getTransactionType());
                transactionList.setTransactionDate(transaction.getTransactionDate());
                transactionListForUser.add(transactionList);
            }

            fetchTransactionsReponse.setUserTransactions(transactionListForUser);
            
            return gson.toJson(fetchTransactionsReponse);
            

        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }

    }


    
}
