package com.qa.domain;

import java.util.HashMap;
 

public class Service {

	private HashMap<Integer,Account> accountMap  = new HashMap<Integer, Account>();
	
	public void addAccount(Account account) {
		if(accountMap.containsKey(account.getAccountNumber())){
			System.out.println("Account already exsits");
		}
		else {
			accountMap.put(account.getAccountNumber(),account);
		}
		
		
	}
	public Account getAccount(Integer accountNumber) {
		return accountMap.get(accountNumber);
	}
	
	public void removeAccount(Account account) {
		if(accountMap.containsKey(account.getAccountNumber())) {
			accountMap.remove(account.getAccountNumber());
		}
		else {
			System.out.println("This account does not exsit");
		}
	}
	public HashMap<Integer, Account> getAccountMap(){
		return accountMap;
	}
	
}

