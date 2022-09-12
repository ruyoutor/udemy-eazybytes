package com.eazybytes.config;

import com.eazybytes.model.Customer;
import com.eazybytes.model.SecurityCustomer;
import com.eazybytes.repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EazyBankUserDetails implements UserDetailsService {


    private CustomerRepository repository;

    public EazyBankUserDetails(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<Customer> customers = repository.findByEmail(username);

        if (customers == null || customers.isEmpty()) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        }

        return new SecurityCustomer(customers.get(0));
    }


}
