package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
				
			Instructor instructor = new Instructor("Ross","Geller","test@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/dino","dino");
			
			instructor.setInstructorDetail(instructorDetail);
		
			session.beginTransaction();
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}
}
