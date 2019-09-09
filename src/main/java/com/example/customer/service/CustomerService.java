package com.example.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.domain.Customer;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	CustomerRepository customerRepository;

    public Customer save(Customer customer) {
    	//var uuid = new UUID(mostSigBits, leastSigBits)
        return customerRepository.save(customer);
    }
    
    public Customer findById(String id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }
    
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

}
