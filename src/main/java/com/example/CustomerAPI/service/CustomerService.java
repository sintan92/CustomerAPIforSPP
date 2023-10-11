package com.example.CustomerAPI.service;

import com.example.CustomerAPI.common.exception.CustomerException;
import com.example.CustomerAPI.restout.CustomerClient;
import com.example.CustomerAPI.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService{

    CustomerClient customerClient;

    @Autowired
    public CustomerService(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    public Customer getCustomer(String personOfficialId) throws CustomerException {
        return customerClient.getCustomer(personOfficialId);
    }

    public Customer createCustomer(Customer customer) throws CustomerException {
        return customerClient.createCustomer(customer).getBody();
    }

}
