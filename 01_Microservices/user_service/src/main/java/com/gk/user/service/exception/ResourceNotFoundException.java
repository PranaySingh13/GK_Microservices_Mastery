package com.gk.user.service.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Resource Not found on server !!");

	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
