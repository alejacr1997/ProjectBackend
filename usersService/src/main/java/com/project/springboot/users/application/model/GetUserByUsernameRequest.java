package com.project.springboot.users.application.model;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetUserByUsernameRequest {
	
	@NotNull
	@NotBlank
	@Length(min = 8)
	private String username;
}
