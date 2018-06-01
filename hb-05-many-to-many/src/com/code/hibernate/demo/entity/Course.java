package com.code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Course.
 */
@Entity
@Table(name="course")
public class Course {

	/** The id. */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/** The title. */
	@Column(name="title")
	private String title;
	
	/** The instructor. */
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="course_student",
					joinColumns= @JoinColumn(name="course_id"),
					inverseJoinColumns = @JoinColumn(name="student_id"))
	private List<Student> students;
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addStudent(Student theStudent) {
		if(students==null)
			students = new ArrayList<>();
		
		students.add(theStudent);
	}
	
	public void addReview(Review theReview) {
		if(reviews==null)
			reviews = new ArrayList<>();
		
		reviews.add(theReview);
	}
	/**
	 * Instantiates a new course.
	 */
	public Course() {
		super();
	}

	/**
	 * Instantiates a new course.
	 *
	 * @param title the title
	 */
	public Course(String title) {
		super();
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the instructor.
	 *
	 * @return the instructor
	 */
	public Instructor getInstructor() {
		return instructor;
	}

	/**
	 * Sets the instructor.
	 *
	 * @param instructor the new instructor
	 */
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
}
