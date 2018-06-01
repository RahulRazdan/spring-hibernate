package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Course;
import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetail;
import com.code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			Course course = new Course("PacMan");
			
			course.addReview(new Review("Awesome game.."));
			course.addReview(new Review("Wow game.."));
			course.addReview(new Review("Nice game.."));
			course.addReview(new Review("Dumb game.."));
			
			session.save(course);
			
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
