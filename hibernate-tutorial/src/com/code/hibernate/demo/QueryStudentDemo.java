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
		
		
		
		try {
			
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			// Get all students
			System.out.println("Creating new Student");
			
			List<Student> allStudent = session.createQuery("from Student").getResultList();
			
			displayStudents(allStudent);
			
			//  Get specific student
			allStudent = session.createQuery("from Student s where s.firstName='YahiTo'").getResultList();
			
			displayStudents(allStudent);
			
			// Update student operation
			if(allStudent!=null && allStudent.size() > 0)
				allStudent.get(0).setFirstName("YahiTo");
			
			int count = session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			System.out.println("Number of query affected : "+count);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			// delete student object
			count = session.createQuery("delete from Student where id=2").executeUpdate();
			
			System.out.println("Number of record deleted : "+count);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student student = session.get(Student.class, 1);
			
			session.delete(student);
			
			session.getTransaction().commit();
			
			System.out.println("Created new Student");
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> allStudent) {
		if(allStudent!=null) {
			for(Student s : allStudent) {
				System.out.println("Found Student with Id: "+s);
			}
		}
	}

}
