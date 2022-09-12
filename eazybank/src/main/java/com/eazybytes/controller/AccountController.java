package com.eazybytes.controller;

import com.eazybytes.model.Account;
import com.eazybytes.model.Customer;
import com.eazybytes.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository repository;

    @RequestMapping("/myAccount")
    public Account getAccountDetails(@RequestBody Customer customer){

        Account account = repository.findByCustomerId(customer.getId());

        if (account != null){
            return account;
        }

        return null;
    }
}
