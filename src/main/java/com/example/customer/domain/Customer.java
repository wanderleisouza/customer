package com.example.customer.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class Customer {
	
	private final String id;
	private final String name;
	private Category category = Category.MEMBER;
	
}
