package com.example.customer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalizedConfigurationController {

	@Value("${info.author.firstname}")
	private String firstname;
	
	@Value("${info.author.lastname}")
	private String lastname;
	
    @GetMapping("/whoami")
    public String hello() {
        return lastname.concat(", ").concat(firstname);
    }

}
