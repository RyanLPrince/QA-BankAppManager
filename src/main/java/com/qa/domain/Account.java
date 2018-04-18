package com.qa.domain;


public class Account {
	private String firstName;
	private String lastName;
	private Integer accountNumber;
	
	public Account(String firstName, String lastName, Integer accountNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		
		
	}

	public Integer getAccountNumber() {
		
		return accountNumber;
	}
	
	
}
