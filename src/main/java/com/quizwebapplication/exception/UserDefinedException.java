package com.quizwebapplication.exception;

public class UserDefinedException extends RuntimeException {

	private static final long serialVersionUID = -4604247955309409196L;

	public UserDefinedException() {
		super();
	}

	public UserDefinedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserDefinedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDefinedException(String message) {
		super(message);
	}

	public UserDefinedException(Throwable cause) {
		super(cause);
	}

}