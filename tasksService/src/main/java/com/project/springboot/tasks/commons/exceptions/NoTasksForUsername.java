package com.project.springboot.tasks.commons.exceptions;

public class NoTasksForUsername extends RuntimeException{
	
private String message;
	
	public NoTasksForUsername(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}

	private static final long serialVersionUID = 1L;

}
