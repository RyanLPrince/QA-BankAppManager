package com.qa.test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.qa.domain.Account;
import com.qa.domain.JSONUtil;
import com.qa.domain.Service;

public class AccountManagementSystemTest {
	 
	Service service;
	Account Ryan;
	Account Godwin;
	
	@Before
	public void setUp() {
		service = new Service();	
		Ryan= new Account("Ryan","Prince",1);
		Godwin = new Account("Godwin","Adeleke",2);
	}
	
	@Test
	public void addAccountTest() {
		service.addAccount(Ryan);
		Integer expected=1;
		Integer actual=service.getAccountMap().size();
		assertEquals(expected,actual);
		assertTrue(service.getAccountMap().containsValue(Ryan));
	}
	
	@Test
	public void preventDuplicateAccountNumbersTest() {
		Account Ryan2=new Account("Ryan","Prince",3);
		Account Joe=new Account("Joe","Bloggs",1);
		service.addAccount(Ryan);
		service.addAccount(Ryan2);
		service.addAccount(Joe);
		Integer expected=2;
		Integer actual=service.getAccountMap().size();
		assertEquals(expected,actual);
		boolean expectedAccountMapContents=service.getAccountMap().containsValue(Ryan)&&
				service.getAccountMap().containsValue(Ryan2)&&
				!(service.getAccountMap().containsValue(Joe));
		assertTrue(expectedAccountMapContents);
	}
	
	@Test
	public void removeAccountTest() {
		service.addAccount(Ryan);
		service.addAccount(Godwin);
		service.removeAccount(Godwin);
		Integer expected=1;
		Integer actual=service.getAccountMap().size();
		assertEquals(expected,actual);
		assertFalse(service.getAccountMap().containsValue(Godwin));
	}
	
	@Test
	public void getAccountTest() {
		service.addAccount(Ryan);
		service.addAccount(Godwin);
		Account expected = Ryan;
		Account actual = service.getAccount(1);
		assertEquals(expected,actual);	
	}
	
	@Test
	public void JSONconversionTest() {
		service.addAccount(Ryan);
		JSONUtil ju=new JSONUtil();
		String expected="{\"1\":{\"firstName\":\"Ryan\",\"lastName\":\"Prince\",\"accountNumber\":1}}";
		String actual=ju.getJSONForObject(service.getAccountMap());
		System.out.println(ju.getJSONForObject(service.getAccountMap()));
		assertEquals(expected,actual);
	}
	
}
