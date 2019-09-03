package com.example.customer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.domain.Customer;

@RestController
public class CustomerController {

    @RequestMapping("/{id}")
    public Customer customer(@PathVariable String id) {
        return new Customer(id, "Jane Doe");
    }

}
