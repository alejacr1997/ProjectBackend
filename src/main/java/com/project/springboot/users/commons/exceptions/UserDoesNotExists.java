package com.project.springboot.users.commons.exceptions;

public class UserDoesNotExists extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;

	public UserDoesNotExists(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	
}
