package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student");
			
			session.beginTransaction();
			
			Student s = new Student("Murgesh","pallya","rahulrazdan@fico.com");
			Student s1 = new Student("Ramesh","Chaurasiya","rahulrazdan@fico.com");
			Student s2 = new Student("Billa","Mast","rahulrazdan@fico.com");
			
			session.save(s);
			session.save(s1);
			session.save(s2);
			
			session.getTransaction().commit();
			
			System.out.println("Created new Student");
		}finally {
			factory.close();
		}

	}

}
