package com.code.springdemo.rest;

/**
 * The Class StudentResponseError.
 */
public class StudentResponseError {

	/** The message. */
	private String message;
	
	/** The timestamp. */
	private long timestamp;
	
	/** The status. */
	private int status;
	
	/**
	 * Instantiates a new student response error.
	 */
	public StudentResponseError() {
	}
	
	/**
	 * Instantiates a new student response error.
	 *
	 * @param message the message
	 * @param timestamp the timestamp
	 * @param status the status
	 */
	public StudentResponseError(String message, long timestamp, int status) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.status = status;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentResponseError [message=" + message + ", timestamp=" + timestamp + ", status=" + status + "]";
	}
	
}
