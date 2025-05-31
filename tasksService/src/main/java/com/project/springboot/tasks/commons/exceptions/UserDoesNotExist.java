package com.project.springboot.tasks.commons.exceptions;

public class UserDoesNotExist extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UserDoesNotExist(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
