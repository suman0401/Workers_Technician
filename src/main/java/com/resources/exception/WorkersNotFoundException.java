package com.resources.exception;

public class WorkersNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WorkersNotFoundException() {
		super();
	}

	public WorkersNotFoundException(String message) {
		super(message);
	}

}
