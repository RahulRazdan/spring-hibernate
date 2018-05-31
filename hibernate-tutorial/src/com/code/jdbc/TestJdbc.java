package com.code.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbc = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connection to database : " + jdbc);
			Connection myconn = DriverManager.getConnection(jdbc, user, pass);
			System.out.println("Connection Successful");
		}catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
