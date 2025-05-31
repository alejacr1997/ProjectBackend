package com.project.springboot.users.application.model;

import java.util.List;

import lombok.Data;

@Data
public class CompleteUser {

	private Long id;
	private String username;
	private String name;
	private String lastname;
	private String email;
	private String sex;
	private int age;
	private List<Task> tasks;
	
	public CompleteUser(User user, List<Task> tasks) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.name = user.getName();
		this.lastname = user.getLastname();
		this.email = user.getEmail();
		this.sex = user.getSex();
		this.age = user.getAge();
		this.tasks = tasks;
	}
}
