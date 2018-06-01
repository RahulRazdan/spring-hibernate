package com.code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class InstructorDetail.
 */
@Table
@Entity(name="instructor_detail")
public class InstructorDetail {

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	/** The youtube channel. */
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	/** The hobby. */
	@Column(name="hobby")
	private String hobby;
	
	/**
	 * Instantiates a new instructor detail.
	 */
	public InstructorDetail() {
		super();
	}

	/**
	 * Instantiates a new instructor detail.
	 *
	 * @param id the id
	 * @param youtubeChannel the youtube channel
	 * @param hobby the hobby
	 */
	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
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
	 * Gets the youtube channel.
	 *
	 * @return the youtube channel
	 */
	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	/**
	 * Sets the youtube channel.
	 *
	 * @param youtubeChannel the new youtube channel
	 */
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	/**
	 * Gets the hobby.
	 *
	 * @return the hobby
	 */
	public String getHobby() {
		return hobby;
	}

	/**
	 * Sets the hobby.
	 *
	 * @param hobby the new hobby
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
