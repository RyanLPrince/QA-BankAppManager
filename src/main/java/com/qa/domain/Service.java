package com.qa.domain;

import java.util.HashMap;
import java.util.stream.Collectors;;
 
public class Service {

	private HashMap<Integer,Account> accountMap  = new HashMap<Integer, Account>();
	
	public void addAccount(Account account) {
		if(accountMap.containsKey(account.getAccountNumber())){
			System.out.println("Account number already exsits.");
		}
		else {
			accountMap.put(account.getAccountNumber(),account);
		}		
	}
		
	public void removeAccount(Account account) {
		if(accountMap.containsKey(account.getAccountNumber())) {
			accountMap.remove(account.getAccountNumber());
		}
		else {
			System.out.println("This account does not exsit.");
		}
	}
	
	public Account getAccount(Integer accountNumber) {
		return accountMap.get(accountNumber);
	}
	
	public HashMap<Integer, Account> getAccountMap(){
		return accountMap;
	}
	
	public int countAccountsWithSameFirstName(String name) {
		int count=0;
		for (Account account: accountMap.values()) {
			if (account.getFirstName().equals(name)) {
				++count;
			}
			
		}
		return count;
	}
	
	public int countAccountsWithSameFirstNameWithStream(String name) {
		
		return (int) accountMap.values().stream()
				.filter(Account -> Account.getFirstName().equals(name)).count();
	}
	
}

