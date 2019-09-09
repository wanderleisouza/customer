package com.example.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.customer.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {}
