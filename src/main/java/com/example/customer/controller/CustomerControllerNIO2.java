package com.example.customer.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipInputStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControllerNIO2 {

    @GetMapping(value = "/files/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFileById(@PathVariable final String id) throws IOException {
    	Path path = Paths.get("src/main/resources/customer_".concat(id).concat(".json")); 
    	return new String(Files.readAllBytes(path));
    }
    
    @GetMapping(value = "/files/unzip/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String unzipFileById(@PathVariable final String id) throws IOException {
    	
    	Path path = Paths.get("src/main/resources/customer_".concat(id).concat(".json.zip")); 
		ZipInputStream zis = new ZipInputStream(new FileInputStream(path.toAbsolutePath().toString()));
		StringBuilder s = new StringBuilder();
		byte[] buffer = new byte[1024];
		int read = 0;
		while ((zis.getNextEntry()) != null) {
			while ((read = zis.read(buffer, 0, 1024)) >= 0) {
				s.append(new String(buffer, 0, read));
			}
		}
		zis.close();
		
		return s.toString();
		
    }

}
