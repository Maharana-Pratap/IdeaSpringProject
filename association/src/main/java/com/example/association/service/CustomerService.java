package com.example.association.service;

import com.example.association.dao.CustomerRepository;
import com.example.association.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
