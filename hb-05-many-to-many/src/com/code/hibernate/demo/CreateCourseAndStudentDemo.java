package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Course;
import com.code.hibernate.demo.entity.Instructor;
import com.code.hibernate.demo.entity.InstructorDetail;
import com.code.hibernate.demo.entity.Review;
import com.code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			Course course = new Course("PacMan");
			session.save(course);
			
			System.out.println("saved Course: "+ course);
			
			Student tempStudent = new Student("John","Doe","tes@gmail.com");
			Student tempStudent1 = new Student("Mary","Doe","tes@gmail.com");
			Student tempStudent2 = new Student("Mark","Doe","tes@gmail.com");
			
			course.addStudent(tempStudent);
			course.addStudent(tempStudent1);
			course.addStudent(tempStudent2);
			
			session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);
			
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
