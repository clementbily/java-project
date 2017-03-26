package com.cb.project.exceptions;

/**
 * @author user
 *
 */
public abstract class AppException extends Exception {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3032042908830571914L;
	/**
	 * message
	 */
	private String message;
	/**
	 * errorCode 
	 */
	private String errorCode;
	
	
	/**
	 * AppException
	 */
	protected AppException() {
	}
	
	/**
	 * @param message
	 * @param errorCode
	 */
	protected AppException(String message, String errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
