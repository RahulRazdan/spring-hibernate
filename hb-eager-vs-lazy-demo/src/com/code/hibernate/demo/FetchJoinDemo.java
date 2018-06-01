package com.code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.code.hibernate.demo.entity.Course;
import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			Query<Instructor> query = session.createQuery("select i from instructor i JOIN FETCH i.courses where i.id=:theInstructorId",Instructor.class);
			
			query.setParameter("theInstructorId", 1);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println("Instructor : "+instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Session is now closed!@");
			System.out.println("Instructor Courses : "+instructor.getCourse());
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
