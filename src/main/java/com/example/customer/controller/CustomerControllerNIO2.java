package com.example.customer.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.repository.CustomerRepository;

@RestController
public class CustomerControllerNIO2 {

	Logger logger = LoggerFactory.getLogger(CustomerControllerNIO2.class);

	@Autowired
	CustomerRepository customerService;
    
    @GetMapping(value = "/jsontest", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findJsonFile() throws IOException {
    	Path path = Paths.get("src/main/resources/sample.json"); 
    	return new String(Files.readAllBytes(path));
    }

}
