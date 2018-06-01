package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Course;
import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetail;
import com.code.hibernate.demo.entity.Review;
import com.code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			Student student = session.get(Student.class, 2);
			
			System.out.println("Courses currently : " + student.getCourses());
			
			Course course = new Course("Rubik Cube");
			Course course2 = new Course("Contra");
			
			course.addStudent(student);
			course2.addStudent(student);
			
			session.save(course);
			session.save(course2);
			
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
