package com.code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println("This is call from "+ this.getClass().getName());
	}
}
