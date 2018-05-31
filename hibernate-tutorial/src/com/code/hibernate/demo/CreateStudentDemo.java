package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student");
			
			session.beginTransaction();
			
			Student s = new Student("Rahul","Razdan","rahulrazdan@fico.com");
			
			session.save(s);
			
			session.getTransaction().commit();
			
			System.out.println("Created new Student");
		}finally {
			factory.close();
		}
	}
}
