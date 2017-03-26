package com.cb.project.exceptions;

public class AccountException extends AppException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6950288001977064219L;

	/**
	 * @param message
	 * @param errorCode
	 */
	public AccountException(String message, String errorCode) {
		super(message, errorCode);
	}
}
