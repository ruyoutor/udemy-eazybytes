package com.eazybytes.controller;

import com.eazybytes.model.AccountTransactions;
import com.eazybytes.model.Customer;
import com.eazybytes.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository repository;

    @PostMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer){

        List<AccountTransactions> transactions = repository.findByCustomerIdOrderByTransactionDtDesc(customer.getId());

        if (transactions != null){
            return transactions;
        }

        return null;
    }
}
