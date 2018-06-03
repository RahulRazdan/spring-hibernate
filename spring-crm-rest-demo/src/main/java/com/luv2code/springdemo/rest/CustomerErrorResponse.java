package com.luv2code.springdemo.rest;

/**
 * The Class CustomerErrorResponse.
 */
public class CustomerErrorResponse {

	/** The message. */
	private String message;
	
	/** The status. */
	private int status;
	
	/** The timestamp. */
	private long timestamp;
	
	/**
	 * Instantiates a new customer error response.
	 */
	public CustomerErrorResponse() {
	}
	
	/**
	 * Instantiates a new customer error response.
	 *
	 * @param message the message
	 * @param status the status
	 * @param timestamp the timestamp
	 */
	public CustomerErrorResponse(String message, int status, long timestamp) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerErrorResponse [message=" + message + ", status=" + status + ", timestamp=" + timestamp + "]";
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
	
}
