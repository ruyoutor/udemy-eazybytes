package com.eazybytes.controller;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Principal user){
        List<Customer> customers = repository.findByEmail(user.getName());

        if (!customers.isEmpty()){
            return customers.get(0);
        }
        return null;
    }
}
