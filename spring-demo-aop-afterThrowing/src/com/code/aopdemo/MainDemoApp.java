package com.code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO dao = context.getBean(AccountDAO.class);
		
		try {
			System.out.println("findAccounts --> "+dao.findAccounts(true));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		context.close();
	}
}
