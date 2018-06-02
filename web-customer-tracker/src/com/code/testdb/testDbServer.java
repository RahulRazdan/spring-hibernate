package com.code.testdb;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testDbServer
 */
@WebServlet("/testDbServer")
public class testDbServer extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		
		String drivevr = "com.mysql.jdbc.Driver";
		
		Connection conn = null;
		try {
			PrintWriter out = response.getWriter();
			Class.forName(drivevr);
			conn = DriverManager.getConnection(jdbcURL, user, pass);
			out.println("SUCCESS!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
