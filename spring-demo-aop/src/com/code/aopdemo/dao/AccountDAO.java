package com.code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println("Testing AOP implementation.");
	}
	
	public void addAccount(Account account,boolean vipFlag) {
		System.out.println("Testing AOP implementation.--> " + account.getName());
	}
}
