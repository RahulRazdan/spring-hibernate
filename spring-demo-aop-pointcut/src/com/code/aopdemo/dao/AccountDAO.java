package com.code.aopdemo.dao;

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
}
