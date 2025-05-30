package com.project.springboot.tasks.commons.exceptions;

public class NoTaskWithId extends RuntimeException{
	
private String message;
	
	public NoTaskWithId(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}

	private static final long serialVersionUID = 1L;

}
