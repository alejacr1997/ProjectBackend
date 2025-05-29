package com.project.springboot.users.commons.exceptions;

public class NoUsersCreated extends RuntimeException {

private String message;
	
	public NoUsersCreated(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}

	private static final long serialVersionUID = 1L;

}
