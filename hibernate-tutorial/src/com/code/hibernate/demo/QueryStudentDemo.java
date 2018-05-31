package com.code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			System.out.println("Creating new Student");
			
			List<Student> allStudent = session.createQuery("from Student").getResultList();
			
			displayStudents(allStudent);
			
			allStudent = session.createQuery("from Student s where s.firstName='Murgesh'").getResultList();
			
			displayStudents(allStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Created new Student");
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> allStudent) {
		if(allStudent!=null) {
			for(Student s : allStudent) {
				System.out.println("Found Student with Id: "+s.getId());
			}
		}
	}

}
