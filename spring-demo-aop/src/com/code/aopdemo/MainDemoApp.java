package com.code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.dao.AccountDAO;
import com.code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO dao = context.getBean(AccountDAO.class);
		dao.addAccount();
		
		dao.addAccount(new Account("level 1","mainaccount"),true);
		
		MembershipDAO member = context.getBean(MembershipDAO.class);
		member.addAccount();
		
		context.close();
	}
}
