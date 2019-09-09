package com.example.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.domain.Customer;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.repository.CustomerRepository;

@RestController
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerRepository customerService;

    @PostMapping("/")
    public Customer save(@RequestBody final Customer customer) {
        logger.debug("Saving customer {}", customer);
        return customerService.save(customer);
    }
    
    @GetMapping("/{id}")
    public Customer findById(@PathVariable final String id) {
        logger.debug("finding customer {}", id);
        return customerService.findById(id).orElseThrow(CustomerNotFoundException::new);
    }
    
    @GetMapping("/")
    public Iterable<Customer> findAll() {
        logger.debug("listing all consumers");
        return customerService.findAll();
    }

}
