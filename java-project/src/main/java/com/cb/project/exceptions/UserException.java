package com.cb.project.exceptions;

public class UserException extends AppException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7247365893478742923L;

	public UserException(String message, String errorCode) {
		super(message, errorCode);
	}
}
