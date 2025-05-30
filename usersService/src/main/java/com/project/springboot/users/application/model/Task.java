package com.project.springboot.users.application.model;

import java.util.Date;

import lombok.Data;

@Data
public class Task {
	
	private String id;
	private String username;
	private String title;
	private String description;
	private boolean status;
	private Date dueDate;
	private Date creationDate;

}
