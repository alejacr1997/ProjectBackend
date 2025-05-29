package com.project.springboot.users.application.model;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SaveUserRequest {

	@NotNull
	@NotBlank
	@Length(min = 8)
	private String username;
	@NotNull
	@NotBlank
	private String password;
	@NotNull
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	private String email;
	@NotNull
	@NotBlank
	private String firstname;
	private String middlename;
	@NotNull
	@NotBlank
	private String lastname;
	@NotNull
	@NotBlank
	private String sex;
	@Min(1)
	private int age;
	
}
