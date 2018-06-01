package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetail;

/**
 * The Class GetInstuctorDetailDemo.
 */
public class GetInstuctorDetailDemo {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {		
			session.beginTransaction();
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 2);
			
			if(instructorDetail!=null) {
				System.out.println(instructorDetail);
				System.out.println(instructorDetail.getInstructor());
			}
			session.getTransaction().commit();
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
