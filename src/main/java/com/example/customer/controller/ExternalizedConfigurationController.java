package com.example.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalizedConfigurationController {

	@Value("${info.author.firstname}")
	private String firstname;
	
	@Value("${info.author.lastname}")
	private String lastname;
	
	@Value("${info.foo}")
	private String foo;
	
	
	Logger logger = LoggerFactory.getLogger(ExternalizedConfigurationController.class);

	
    @GetMapping("/whoami")
    public String hello() {
    	logger.debug("This is foo:{} global server config", foo);
        return lastname.concat(", ").concat(firstname);
    }

}
