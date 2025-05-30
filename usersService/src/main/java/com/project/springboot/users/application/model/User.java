package com.project.springboot.users.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private String name;
	private String lastname;
	private String email;
	private String sex;
	private int age;

}
