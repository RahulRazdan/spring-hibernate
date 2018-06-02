package com.code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Component
public class AccountDAO {

	private String namae;
	private String lavel;
	
	public String getNamae() {
		System.out.println("inside getName");
		return namae;
	}

	public void setNamae(String namae) {
		System.out.println("inside setName");
		this.namae = namae;
	}

	public String getLavel() {
		System.out.println("inside getlevel");
		return lavel;
	}

	public void setLavel(String lavel) {
		System.out.println("inside setLevel");
		this.lavel = lavel;
	}

	public void addAccount() {
		System.out.println("Testing AOP implementation.");
	}
	
	public void addAccount(Account account,boolean vipFlag) {
		System.out.println("Testing AOP implementation.--> " + account.getName());
	}
	
	public List<Account> findAccounts() throws InterruptedException {
		
		List<Account> accountList = new ArrayList<>();
		accountList.add(new Account("HIGH","Rahul"));
		accountList.add(new Account("LOW","Razdan"));
		accountList.add(new Account("MID","Ramesh"));
		
		TimeUnit.SECONDS.sleep(2);
		return accountList;
	}
}
