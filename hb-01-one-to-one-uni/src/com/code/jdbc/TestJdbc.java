package com.code.jdbc;


import java.sql.DriverManager;


/**
 * The Class TestJdbc.
 */
public class TestJdbc {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		String jdbc = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connection to database : " + jdbc);
			DriverManager.getConnection(jdbc, user, pass);
			System.out.println("Connection Successful");
		}catch(Exception exc) {
			exc.printStackTrace();
		}

	}

}
