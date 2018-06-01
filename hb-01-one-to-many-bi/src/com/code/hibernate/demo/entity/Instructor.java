package com.code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class Instructor.
 */
@Table
@Entity(name="instructor")
public class Instructor {

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/** The first name. */
	@Column(name="first_name")
	private String firstName;
	
	/** The last name. */
	@Column(name="last_name")
	private String lastName;
	
	/** The email. */
	@Column(name="email")
	private String email;
	
	/** The instructor detail. */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;

	/** The courses. */
	@OneToMany(mappedBy="instructor",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Course> courses;
	
	/**
	 * Gets the course.
	 *
	 * @return the course
	 */
	public List<Course> getCourse() {
		return courses;
	}

	/**
	 * Sets the course.
	 *
	 * @param courses the new course
	 */
	public void setCourse(List<Course> courses) {
		this.courses = courses;
	}

	/**
	 * Adds the.
	 *
	 * @param tempCourse the temp course
	 */
	public void add(Course tempCourse) {
		
		if(courses==null)
			courses = new ArrayList<>();
		
		courses.add(tempCourse);
		
		tempCourse.setInstructor(this);
	}
	/**
	 * Instantiates a new instructor.
	 */
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new instructor.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param email the email
	 */
	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the instructor detail.
	 *
	 * @return the instructor detail
	 */
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	/**
	 * Sets the instructor detail.
	 *
	 * @param instructorDetail the new instructor detail
	 */
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	
}
