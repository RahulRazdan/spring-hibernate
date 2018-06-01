package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {		
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			
			session.delete(instructor);
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}
}
