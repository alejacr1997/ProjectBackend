package com.project.springboot.users.commons.exceptions;

public class UserAlreadyExists extends RuntimeException{

	private String message;
	
	public UserAlreadyExists(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}

	private static final long serialVersionUID = 1L;

}
