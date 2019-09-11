package com.example.customer.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControllerNIO2 {

    @GetMapping(value = "/files/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPathById(@PathVariable final String id) throws IOException {
    	Path path = Paths.get("src/main/resources/customer_".concat(id).concat(".json")); 
    	return new String(Files.readAllBytes(path));
    }

}
